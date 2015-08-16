/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : web

Target Server Type    : ORACLE
Target Server Version : 100200
File Encoding         : 65001

Date: 2015-08-13 22:24:11
*/

;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO item VALUES ('1', '灭世者的死亡之帽', '<p>+140点法术强度。唯一被动：提升30%法术强度。</p>', null);
INSERT INTO item VALUES ('2', '麦瑞德裂血手套', '<p>+40点攻击、+40%攻击速度、+25点护甲、唯一被动：物理攻击会造成目标最大生命值的4%的魔法伤害。</p>', null);
INSERT INTO item VALUES ('3', '多兰之盾', '<p>+120点生命值、+10点护甲、+8点生命回复/5秒</p>', null);
INSERT INTO item VALUES ('4', '黑色切割者', '<p>+55点攻击力、+30%攻击速度。唯一被动：物理攻击减少目标15点护甲，持续5秒（最多叠加3次）。</p>', null);
INSERT INTO item VALUES ('5', '长剑', '<p>+10点攻击力</p>', '1437496392574.gif');
INSERT INTO item VALUES ('6', '灵巧披风', '<p>+18%暴击几率</p>', '1437495216704.png');
INSERT INTO item VALUES ('7', '多兰之刃', '<p>+80点生命值、+10点攻击力、+3%生命偷取</p>', '1437494908238.png');

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO users VALUES ('1', '3', 'test1', '000000', '无极剑圣', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('2', '0', 'test2', '000000', '雪人骑士', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('3', '0', 'test3', '000000', '战争女神', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('4', '0', 'test4', '000000', '众星之子', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('5', '0', 'test5', '000000', '审判天使', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('6', '0', 'test6', '000000', '寒冰射手', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('7', '0', 'test7', '000000', '德玛西亚之力', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('8', '0', 'test8', '000000', '流浪法师', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('9', '0', 'test9', '000000', '卡牌大师', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('10', '0', 'test10', '000000', '堕落天使', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('11', '0', 'test11', '000000', '炼金术士', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('12', '0', 'test12', '000000', '熔岩巨兽', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('13', '0', 'test13', '000000', '祖安狂人', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('14', '0', 'test14', '000000', '钢铁大使', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('15', '0', 'test15', '000000', '寡妇制造者', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('16', '0', 'test16', '000000', '时光守护者', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('17', '0', 'test17', '000000', '末日使者', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('18', '0', 'test18', '000000', '殇之木乃伊', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('19', '0', 'test19', '000000', '牛头酋长', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('20', '0', 'test20', '000000', '邪恶小法师', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('21', '0', 'test21', '000000', '风暴之怒', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('22', '0', 'test22', '000000', '麦林炮手', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('23', '0', 'test23', '000000', '黑暗之女', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('24', '0', 'test24', '000000', '亡灵勇士', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('25', '0', 'test2511', '000000', '沙漠死神1', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('26', '0', 'test26', '000000', '蛮族之王', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('27', '0', 'test27', '000000', '德邦总管', TO_TIMESTAMP('2014-12-30 00:55:49', 'YYYY-MM-DD HH24:MI:SS'), '');
INSERT INTO users VALUES ('28', '0', '1111', '1111', '死神传说', TO_TIMESTAMP('2015-07-26 23:26:19', 'YYYY-MM-DD HH24:MI:SS'), '');

-- ----------------------------
-- Records of users_exp
-- ----------------------------
INSERT INTO users_exp VALUES ('1', '0', '18', '1623736450');
INSERT INTO users_exp VALUES ('2', '0', '19', '1623736451');
INSERT INTO users_exp VALUES ('3', '0', '20', '1623736452');
INSERT INTO users_exp VALUES ('4', '0', '21', '1623736453');
INSERT INTO users_exp VALUES ('5', '0', '22', '1623736454');
INSERT INTO users_exp VALUES ('6', '0', '23', '1623736455');
INSERT INTO users_exp VALUES ('7', '0', '24', '1623736456');
INSERT INTO users_exp VALUES ('8', '0', '25', '1623736457');
INSERT INTO users_exp VALUES ('9', '0', '26', '1623736458');
INSERT INTO users_exp VALUES ('10', '0', '27', '1623736459');
INSERT INTO users_exp VALUES ('11', '0', '28', '1623736460');
INSERT INTO users_exp VALUES ('12', '0', '29', '1623736461');
INSERT INTO users_exp VALUES ('13', '0', '30', '1623736462');
INSERT INTO users_exp VALUES ('14', '0', '31', '1623736463');
INSERT INTO users_exp VALUES ('15', '0', '32', '1623736464');
INSERT INTO users_exp VALUES ('16', '0', '33', '1623736465');
INSERT INTO users_exp VALUES ('17', '0', '34', '1623736466');
INSERT INTO users_exp VALUES ('18', '0', '35', '1623736467');
INSERT INTO users_exp VALUES ('19', '0', '36', '1623736468');
INSERT INTO users_exp VALUES ('21', '0', '38', '1623736470');
INSERT INTO users_exp VALUES ('22', '0', '39', '1623736471');
INSERT INTO users_exp VALUES ('23', '0', '40', '1623736472');
INSERT INTO users_exp VALUES ('24', '0', '41', '1623736473');
INSERT INTO users_exp VALUES ('25', '0', '42', '1623736474');
INSERT INTO users_exp VALUES ('26', '0', '43', '1623736475');
INSERT INTO users_exp VALUES ('27', '0', '44', '1623736476');
INSERT INTO users_exp VALUES ('28', '0', '45', '1623736477');

-- ----------------------------
-- Records of users_item
-- ----------------------------
INSERT INTO users_item VALUES ('1', '1', '1');
INSERT INTO users_item VALUES ('2', '1', '2');
INSERT INTO users_item VALUES ('3', '2', '5');
INSERT INTO users_item VALUES ('4', '2', '2');
INSERT INTO users_item VALUES ('5', '2', '3');
INSERT INTO users_item VALUES ('6', '4', '4');

-- ----------------------------
-- Records of webdict
-- ----------------------------
INSERT INTO webdict VALUES ('1', '0', '正常', 'users', 'status', '');
INSERT INTO webdict VALUES ('2', '1', '封号', 'users', 'status', '');
INSERT INTO webdict VALUES ('3', '2', '禁言', 'users', 'status', '');
INSERT INTO webdict VALUES ('4', '3', '删除', 'users', 'status', '');