/**
 * Copyright (c) 2013-2016, Jieven. All rights reserved.
 *
 * Licensed under the GPL license: http://www.gnu.org/licenses/gpl.txt
 * To use it on other terms please contact us at 1623736450@qq.com
 */
package com.oss;

import com.eova.core.IndexController;
import com.eova.model.User;
import com.jfinal.core.Controller;
import com.oss.model.UserInfo;

/**
 * 自定义 新增或重写 登录 注册 等各种默认系统业务！！！
 *
 * @author Jieven
 * @date 2016-05-11
 */
public class OSSController extends IndexController {

    @Override
    public void toIndex() {
        System.out.println("我是来自草原的狼，自由奔跑在EOVA上，想干嘛就干嘛！");
        render("/eova/index.html");
    }

    @Override
    protected void loginInit(Controller ctrl, User user) throws Exception {
        super.loginInit(ctrl, user);

        // 添加自定义业务信息到当前用户中
        UserInfo info = UserInfo.dao.findById(user.get("id"));
        if (info != null) {
            user.put("info", info);
            // 页面或表达式 调用用户信息 ${user.info.nickname}
        }

        // 还可以将相关信息放入session中
        // ctrl.setSessionAttr("UserInfo", info);
    }

    @Override
    public void toLogin() {
        // 新手部署错误引导
        int port = getRequest().getServerPort();
        String name = getRequest().getServerName();
        String project = getRequest().getServletContext().getContextPath();
        if (!project.equals("")) {
        	System.out.println("Eova不支持子项目(目录)方式访问,如需同时使用多个项目请使用不同的端口部署Web服务!");
        	String ctx = "http://" + name + ':' + port + project;
        	setAttr("ctx", ctx);
            render("/eova/520.html");
            return;
		}
        
        super.toLogin();
    }

}