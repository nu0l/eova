/**
 * Copyright (c) 2013-2015, Jieven. All rights reserved.
 *
 * Licensed under the GPL license: http://www.gnu.org/licenses/gpl.txt
 * To use it on other terms please contact us at 1623736450@qq.com
 */
package com.eova.core.meta;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eova.common.Easy;
import com.eova.common.utils.xx;
import com.eova.common.utils.db.DsUtil;
import com.eova.config.EovaConfig;
import com.eova.engine.EovaExp;
import com.eova.model.MetaField;
import com.eova.model.MetaObject;
import com.eova.template.common.config.TemplateConfig;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.tx.Tx;

/**
 * 元数据相关获取
 * 
 * @author Jieven
 * 
 */
public class MetaController extends Controller {

	// 获取元对象
	public void object() {
		String code = getPara(0);
		MetaObject mo = MetaObject.dao.getByCode(code);
		renderJson(JsonKit.toJson(mo));
	}

	// 获取元字段集
	public void fields() {
		String code = getPara(0);
		List<MetaField> mfs = MetaField.dao.queryByObjectCode(code);
		// 获取Edit 控件类型
		for (MetaField item : mfs) {
			String type = item.getStr("type");
			if (type.equals(MetaField.TYPE_CHECK)) {
				item.put("editor", "eovacheck");
			} else if (type.equals(MetaField.TYPE_COMBO)) {
				item.put("editor", "eovacombo");
			} else if (type.equals(MetaField.TYPE_FIND)) {
				item.put("editor", "eovafind");
			} else if (type.equals(MetaField.TYPE_TIME)) {
				item.put("editor", "eovatime");
			} else {
				item.put("editor", "eovatext");
			}
		}
		renderJson(JsonKit.toJson(mfs));
	}

	// 编辑元数据
	public void edit(){
		String objectCode = getPara(0);
		setAttr("objectCode", objectCode);
		render("/eova/metadata/edit.html");
	}
	
	// 导入页面
	public void imports() {
		setAttr("dataSources", EovaConfig.dataSources);
		render("/eova/metadata/importMetaData.html");
	}

	// 查找表结构表头
	public void find() {

		String ds = getPara(0);
		String type = getPara(1);
		// 根据表达式手工构建Eova_Object
		MetaObject eo = MetaObject.dao.getTemplate();
		eo.put("data_source", ds);
		// 第1列名
		eo.put("pk_name", "table_name");
		// 第2列名
		eo.put("cn", "table_name");
		
		// 根据表达式手工构建Eova_Item
		List<MetaField> eis = new ArrayList<MetaField>();
		eis.add(EovaExp.buildItem(1, "table_name", "编码", false));
		eis.add(EovaExp.buildItem(2, "table_name", "表名", true));
		
		setAttr("objectJson", JsonKit.toJson(eo));
		setAttr("fieldsJson", JsonKit.toJson(eis));
		setAttr("itemList", eis);
		
		setAttr("action", "/meta/findJson/" + ds + '-' + type);

		render("/eova/dialog/find.html");
	}

	// 查找表结构数据
	public void findJson() {

		// 获取数据库
		String ds = getPara(0);
		String type = getPara(1);

		// 用户过滤
		String schemaPattern = null;
		// Oracle需要根据用户名过滤表
		if (xx.isOracle()) {
			schemaPattern = DsUtil.getUserNameByConfigName(ds);
		}

		// 表名过滤
		String tableNamePattern = getPara("query_table_name");
		if (!xx.isEmpty(tableNamePattern)) {
			tableNamePattern = "%" + tableNamePattern + "%";
		}

		List<String> tables = DsUtil.getTableNamesByConfigName(ds, type, schemaPattern, tableNamePattern);
		JSONArray tableArray = new JSONArray();
		for (String tableName : tables) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("table_name", tableName);
			tableArray.add(jsonObject);
		}
		// 将分页数据转换成JSON
		String json = JsonKit.toJson(tableArray);
		json = "{\"total\":" + tableArray.size() + ",\"rows\":" + json + "}";
		renderJson(json);
	}

	// 导入元数据
	@Before(Tx.class)
	public void doImports() {

		String ds = getPara("ds");
		String type = getPara("type");
		String table = getPara("table");
		String name = getPara("name");
		String code = getPara("code");

		JSONArray list = DsUtil.getColumnInfoByConfigName(ds, table);
		System.out.println(list);

		// 导入元字段
		importMetaField(code, list, ds, table);

		// 导入视图默认第一列为主键
		String pkName = DsUtil.getPkName(ds, table);
		if (xx.isEmpty(pkName)) {
			pkName = list.getJSONObject(0).getString("COLUMN_NAME");
		}

		// 导入元对象
		importMetaObject(ds, type, table, name, code, pkName);

		renderJson(new Easy());
	}

	// 导入元字段
	private void importMetaField(String code, JSONArray list, String ds, String table) {
		// 因为 Oralce 配置参数 DatabaseMetaData 无法获取注释，手工从表中查询字段注释
		List<Record> comments = null;
		if(xx.isOracle()){
			// 获取用户名
			String userName = DsUtil.getUserNameByConfigName(ds);
			String sql = "select column_name,comments from all_col_comments where owner = ? and table_name = ?";
			comments = Db.use(ds).find(sql, userName, table);
		}
		for (int i = 0; i < list.size(); i++) {
			JSONObject o = list.getJSONObject(i);
			MetaField mi = new MetaField();
			mi.set("en", o.getString("COLUMN_NAME").toLowerCase());
			mi.set("cn", o.getString("REMARKS"));
			mi.set("order_num", o.getIntValue("ORDINAL_POSITION"));
			mi.set("is_required", "YES".equalsIgnoreCase(o.getString("IS_NULLABLE")) ? "1" : "0");
			
			// Oracle 导入注释 特殊处理
			if (comments != null) {
				for(Record x : comments){
					if(mi.getEn().equals(x.getStr("column_name").toLowerCase())){
						mi.set("cn", x.getStr("comments"));
						break;
					}
				}
			}

			// 是否自增
			boolean isAuto = "YES".equalsIgnoreCase(o.getString("IS_AUTOINCREMENT")) ? true : false;
			mi.set("is_auto", isAuto);
			// 字段类型
			String typeName = o.getString("TYPE_NAME");
			mi.set("data_type", getDataType(typeName));
			// 字段长度
			int size = o.getIntValue("COLUMN_SIZE");
			// 默认值
			String def = o.getString("COLUMN_DEF");
			mi.set("defaulter", def);

			// 控件类型
			mi.set("type", getFormType(isAuto, typeName, size));
			// 将注释作为CN,若为空使用EN
			if (xx.isEmpty(mi.getCn())) {
				mi.set("cn", mi.getEn());
			}
			
			// 默认值
			if (xx.isEmpty(mi.getStr("defaulter"))) {
				mi.set("defaulter", "");
			}
			// 对象编码
			mi.set("object_code", code);
			
			mi.save();
			
		}
	}

	// 导入元对象
	private void importMetaObject(String ds, String type, String table, String name, String code, String pkName) {
		MetaObject mo = new MetaObject();
		// 编码
		mo.set("code", code);
		// 名称
		mo.set("name", name);
		// 主键
		mo.set("pk_name", pkName.toLowerCase());
		// 数据源
		mo.set("data_source", ds);
		// 表或视图
		if (type.equalsIgnoreCase(DsUtil.TABLE)) {
			mo.set("table_name", table.toLowerCase());
		} else {
			mo.set("view_name", table.toLowerCase());
		}
		mo.save();
	}

	/**
	 * 转换数据类型
	 * 
	 * @param typeName DB数据类型
	 * @return
	 */
	private String getDataType(String typeName) {
		typeName = typeName.toLowerCase();
		if (typeName.contains("int") || typeName.contains("bit") || typeName.equals("number")) {
			return TemplateConfig.DATATYPE_NUMBER;
		} else if (typeName.contains("time") || typeName.contains("date")) {
			return TemplateConfig.DATATYPE_TIME;
		} else {
			return TemplateConfig.DATATYPE_STRING;
		}
	}

	/**
	 * 获取表单类型
	 * 
	 * @param isAuto 是否自增
	 * @param typeName 类型
	 * @param size 长度
	 * @return
	 */
	private String getFormType(boolean isAuto, String typeName, int size) {
		if (typeName.contains("time")) {
			return MetaField.TYPE_TIME;
		} else if (isAuto) {
			return MetaField.TYPE_AUTO;
		} else if (size > 255) {
			return MetaField.TYPE_TEXTS;
		} else if (size > 500) {
			return MetaField.TYPE_EDIT;
		} else {
			// 默认都是文本框
			return MetaField.TYPE_TEXT;
		}
	}

}