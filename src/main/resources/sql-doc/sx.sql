/*
 Navicat Premium Data Transfer

 Source Server         : 学校34服务器
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : 10.255.251.34:3306
 Source Schema         : sx

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 23/11/2019 13:46:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (48);
INSERT INTO `hibernate_sequence` VALUES (48);
INSERT INTO `hibernate_sequence` VALUES (48);
INSERT INTO `hibernate_sequence` VALUES (48);
INSERT INTO `hibernate_sequence` VALUES (48);
INSERT INTO `hibernate_sequence` VALUES (48);
INSERT INTO `hibernate_sequence` VALUES (48);
INSERT INTO `hibernate_sequence` VALUES (48);
INSERT INTO `hibernate_sequence` VALUES (48);

-- ----------------------------
-- Table structure for sx_college_principal
-- ----------------------------
DROP TABLE IF EXISTS `sx_college_principal`;
CREATE TABLE `sx_college_principal`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `college` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学院',
  `college_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学院代码',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学院负责人' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sx_corp
-- ----------------------------
DROP TABLE IF EXISTS `sx_corp`;
CREATE TABLE `sx_corp`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `taxcode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '纳税人识别号',
  `principal` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `corp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '企业名称',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '实习公司负责人' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sx_corp
-- ----------------------------
INSERT INTO `sx_corp` VALUES (1, '10000', '1234', NULL, NULL, NULL, '2019-10-23 23:07:52', '2019-10-23 23:07:52');

-- ----------------------------
-- Table structure for sx_corp_teacher
-- ----------------------------
DROP TABLE IF EXISTS `sx_corp_teacher`;
CREATE TABLE `sx_corp_teacher`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `id_card` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `corp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '企业',
  `unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单位',
  `work` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '工作',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  `qq` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'qq',
  `mail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `wechat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '微信',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '校外导师' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sx_corp_teacher
-- ----------------------------
INSERT INTO `sx_corp_teacher` VALUES (1, '10000', '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2019-10-23 22:59:32', '2019-10-23 22:59:32');
INSERT INTO `sx_corp_teacher` VALUES (16, 'test', '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2019-10-25 10:30:34', '2019-10-25 10:30:34');

-- ----------------------------
-- Table structure for sx_corporation
-- ----------------------------
DROP TABLE IF EXISTS `sx_corporation`;
CREATE TABLE `sx_corporation`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT ' 主键',
  `stu_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT ' 学号,表示这条记录由某个学生填写',
  `credit_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '统一社会信用代码',
  `corp_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT ' 企业名称',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型 (如：有限责任公司)',
  `legal_person` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人',
  `register_capita` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ' 注册资本',
  `create_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ' 创建日期',
  `start_business` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开始营业日期',
  `end_business` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ' 营业期限截止日期',
  `reg_authority` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工商信息登记机关',
  `approval_date` datetime(0) NULL DEFAULT NULL COMMENT '核准日期',
  `reg_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ' 登记状态',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住所地址',
  `business_scope` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经营范围',
  `is_corp_checked` bit(1) NULL DEFAULT b'0' COMMENT ' 表示该公司信息后台管理员是否已经核实,默\r\n认未核实',
  `gmt_create` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT ' 数据库记录创建日期',
  `gmt_modified` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT ' 数据库记录修改日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公司信息表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sx_identify_form
-- ----------------------------
DROP TABLE IF EXISTS `sx_identify_form`;
CREATE TABLE `sx_identify_form`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `stu_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学号',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `gmt_start` date NULL DEFAULT NULL COMMENT '实习开始时间',
  `gmt_end` date NULL DEFAULT NULL COMMENT '实习结束时间',
  `sx_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '实习内容',
  `self_summary` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '自我总结',
  `corp_teacher_opinion` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '校外导师意见',
  `corp_teacher_score` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '校外导师打分',
  `c_t_o_date` date NULL DEFAULT NULL COMMENT '校外导师意见填写日期',
  `corp_opinion` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '实习单位意见',
  `c_o_date` date NULL DEFAULT NULL COMMENT '实习单位意见填写时间',
  `corp_teacher_grade` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '实习单位导师成绩评定',
  `c_t_g_date` date NULL DEFAULT NULL COMMENT '实习单位导师成绩评定日期',
  `teacher_grade` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学院导师成绩评定',
  `t_g_date` date NULL DEFAULT NULL COMMENT '学院导师成绩评定日期',
  `comprehsv_grade` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '综合实习成绩评定',
  `c_g_date` date NULL DEFAULT NULL COMMENT '综合实习成绩评定日期',
  `college_principal_opinion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学院实习领导小组意见',
  `c_p_o_date` date NULL DEFAULT NULL COMMENT '学院实习领导小组意见填写日期',
  `l_o_date` date NULL DEFAULT NULL,
  `leader_opinion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '实习鉴定表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sx_identify_form
-- ----------------------------
INSERT INTO `sx_identify_form` VALUES (19, '201513015114', '2019-11-14 11:40:17', '2019-11-14 11:40:17', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_identify_form` VALUES (21, '201513015310', '2019-11-14 13:53:10', '2019-11-22 18:24:20', NULL, NULL, '搬砖', '良好', '', '优秀', '2019-11-08', '1111', '2019-11-01', '优秀', NULL, '优秀', '2019-11-09', NULL, '2019-11-23', 'aaa', '2019-11-09', NULL, NULL);
INSERT INTO `sx_identify_form` VALUES (23, '2016010302', '2019-11-14 14:04:34', '2019-11-14 14:04:34', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_identify_form` VALUES (25, '201512045141', '2019-11-14 14:16:37', '2019-11-22 21:08:47', NULL, NULL, '是打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎', '杀了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲', 'hghghhghhgfdv d dsfdsfdsfewfwefwvvdvdsdssd sdcsdcvdsgssdf', '优秀', '2019-11-17', '这个瓜娃子实习很努力，值得表扬!!!这个瓜娃子实习很努力，值得表扬!!!这个瓜娃子实习很努力，值得表扬!!!这个瓜娃子实习很努力，值得表扬!!!', '2019-11-17', '优秀', NULL, '及格', '2019-11-17', '', '2019-11-17', '这个瓜娃子实习很努力，值得表扬!!!这个瓜娃子实习很努力，值得表扬!!!', '2019-11-17', NULL, NULL);
INSERT INTO `sx_identify_form` VALUES (27, '2016010374', '2019-11-14 14:19:32', '2019-11-14 14:19:32', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_identify_form` VALUES (29, '2016010303', '2019-11-14 14:33:22', '2019-11-14 14:33:22', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_identify_form` VALUES (31, '201513015252', '2019-11-14 14:52:29', '2019-11-14 15:22:00', NULL, NULL, '111', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_identify_form` VALUES (33, '201512025142', '2019-11-14 15:42:32', '2019-11-22 21:08:35', NULL, NULL, '是打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎打开链接撒谎', '杀了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲了的骄傲', '不好哟', '优秀', NULL, '优秀', NULL, '优秀', NULL, '优秀', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_identify_form` VALUES (35, '201530015331', '2019-11-14 15:44:08', '2019-11-21 13:13:22', NULL, NULL, '11', '22', '344676543', '良好', NULL, '2', NULL, NULL, NULL, '', NULL, '', NULL, '', NULL, NULL, NULL);
INSERT INTO `sx_identify_form` VALUES (37, '2016010377', '2019-11-20 22:36:48', '2019-11-20 22:36:48', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_identify_form` VALUES (39, '2016010242', '2019-11-20 22:37:28', '2019-11-20 22:37:28', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_identify_form` VALUES (41, '2016010304', '2019-11-21 19:09:53', '2019-11-21 19:09:53', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_identify_form` VALUES (43, '2016010307', '2019-11-21 19:10:05', '2019-11-21 19:10:05', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_identify_form` VALUES (45, '2016010243', '2019-11-21 19:10:17', '2019-11-21 19:10:17', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_identify_form` VALUES (47, '201530015340', '2019-11-22 19:59:02', '2019-11-22 20:05:37', NULL, NULL, '11', '', '1', NULL, NULL, '', NULL, '优秀', NULL, '', NULL, NULL, NULL, '', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sx_report
-- ----------------------------
DROP TABLE IF EXISTS `sx_report`;
CREATE TABLE `sx_report`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `stu_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '关联学生学号',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `gmt_start` date NULL DEFAULT NULL COMMENT '实习开始时间',
  `gmt_end` date NULL DEFAULT NULL COMMENT '实习结束时间',
  `stage1_guide_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '第一阶段指导时间,应该为时间段，留varchar',
  `stage1_guide_way` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '第一阶段指导方式',
  `stage1_summary` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '第一阶段实习总结',
  `stage1_date` date NULL DEFAULT NULL COMMENT '第一阶段填写日期',
  `stage1_comment` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '第一阶段学院实习指导教师评语',
  `stage1_grade` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '第一阶段实习成绩评定',
  `stage1_grade_date` date NULL DEFAULT NULL COMMENT '第一阶段实习成绩评定日期',
  `stage2_guide_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '第二阶段指导时间',
  `stage2_guide_way` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '第二阶段实习指导方式',
  `stage2_summary` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '第二阶段实习总结',
  `stage2_date` date NULL DEFAULT NULL COMMENT '第二阶段填写日期',
  `stage2_comment` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '第二阶段学院实习导师评语',
  `stage2_grade` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '第二阶段实习成绩评定',
  `stage2_grade_date` date NULL DEFAULT NULL COMMENT '第二阶段实习成绩评定日期',
  `total_grade` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '学院实习指导老师总评',
  `total_score` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学院实习指导老师总评成绩ABCDE',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sx_report
-- ----------------------------
INSERT INTO `sx_report` VALUES (18, '201513015114', '2019-11-14 11:40:17', '2019-11-14 11:40:17', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_report` VALUES (20, '201513015310', '2019-11-14 13:53:10', '2019-11-20 21:45:39', '2019-03-14', '2019-11-20', '3月份吧', '远程指导', '挺好的vddvdvdvd', '2019-11-19', 'tgrtgtrgrt', '43', '2019-11-19', '忘了', '线上指导', '可以', NULL, 'trgtrgrtg', '22', '2019-11-19', 'defc', '43');
INSERT INTO `sx_report` VALUES (22, '2016010302', '2019-11-14 14:04:34', '2019-11-14 14:04:34', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_report` VALUES (24, '201512045141', '2019-11-14 14:16:37', '2019-11-22 15:21:48', '2019-11-01', '2019-11-01', '2019-11-15', '面对面指导', '面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导面对面指导', '2019-11-17', '可以嘛，实习很给力！可以嘛，实习很给力！可以嘛，实习很给力！可以嘛，实习很给力！可以嘛，实习很给力！可以嘛，实习很给力！', '优秀', '2019-11-17', '2019-11-17', '微信', '微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导信指导信指导指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导信指导信指导指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指导微信指', '2019-11-17', '可以嘛，实习很给力！可以嘛，实习很给力！可以嘛，实习很给力！可以嘛，实习很给力！可以嘛，实习很给力！可以嘛，实习很给力！', '优秀', '2019-11-17', '希望在今后的道路上继续努力加油！', '良好');
INSERT INTO `sx_report` VALUES (26, '2016010374', '2019-11-14 14:19:32', '2019-11-14 14:19:32', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_report` VALUES (28, '2016010303', '2019-11-14 14:33:22', '2019-11-14 14:33:22', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_report` VALUES (30, '201513015252', '2019-11-14 14:52:29', '2019-11-14 15:43:49', NULL, '2019-11-21', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2019-11-07', '微信', '学到了很多', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_report` VALUES (32, '201512025142', '2019-11-14 15:42:32', '2019-11-14 15:46:02', '2019-03-12', '2019-11-12', '3月到5月', '线上指导', '可以滴', NULL, NULL, NULL, NULL, '6月到11月', '线上指导', '感觉', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_report` VALUES (34, '201530015331', '2019-11-14 15:44:08', '2019-11-14 16:24:39', '2019-11-14', '2019-11-14', '2019-11-15', '微信', '', NULL, NULL, NULL, NULL, '2019-11-14', '', '', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_report` VALUES (36, '2016010377', '2019-11-20 22:36:48', '2019-11-20 22:36:48', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_report` VALUES (38, '2016010242', '2019-11-20 22:37:28', '2019-11-20 22:37:28', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_report` VALUES (40, '2016010304', '2019-11-21 19:09:53', '2019-11-21 19:09:53', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_report` VALUES (42, '2016010307', '2019-11-21 19:10:05', '2019-11-21 19:10:05', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_report` VALUES (44, '2016010243', '2019-11-21 19:10:17', '2019-11-21 19:10:17', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_report` VALUES (46, '201530015340', '2019-11-22 19:59:02', '2019-11-22 19:59:02', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sx_root
-- ----------------------------
DROP TABLE IF EXISTS `sx_root`;
CREATE TABLE `sx_root`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '超管账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '超管密码',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '超级管理员的信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sx_root
-- ----------------------------
INSERT INTO `sx_root` VALUES (1, 'admin', '21232F297A57A5A743894A0E4A801FC3', '2019-10-17 19:51:46', '2019-10-17 19:51:46');

-- ----------------------------
-- Table structure for sx_stagemanage
-- ----------------------------
DROP TABLE IF EXISTS `sx_stagemanage`;
CREATE TABLE `sx_stagemanage`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `is_report_stage1_open` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '报告册第一阶段开放:学生填写阶段1,教师评价阶段1',
  `is_report_stage2_open` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '报告册第二阶段开放:学生填写阶段2,教师评价阶段2',
  `is_report_stage3_open` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '报告册第三阶段开放:教师进行总评/打总成绩',
  `is_identify_form_stage1_open` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '鉴定表第一阶段开放:学生填写阶段',
  `is_identify_form_stage2_open` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '鉴定表第二阶段开放:其他角色(除学院领导小组)进行意见填写/打分',
  `is_identify_form_stage3_open` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '鉴定表第三阶段开放:学院领导小组意见填写/打分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sx_stagemanage
-- ----------------------------
INSERT INTO `sx_stagemanage` VALUES (1, 0, 1, 0, 1, 0, 0);

-- ----------------------------
-- Table structure for sx_student
-- ----------------------------
DROP TABLE IF EXISTS `sx_student`;
CREATE TABLE `sx_student`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `stu_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  `qq` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'qq',
  `wechat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '微信',
  `id_card` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `college` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学院',
  `college_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学院代码',
  `major` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '专业',
  `major_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '专业代码',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `corp_taxcode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '实习企业信用代码',
  `corp_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '企业名称',
  `corp_reg_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '企业注册号',
  `corp_position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '实习岗位',
  `teacher_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '校内导师工号',
  `corp_teacher_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '校外导师工号',
  `identify_flag` tinyint(1) UNSIGNED NULL DEFAULT 0 COMMENT '是否填写鉴定表',
  `report_flag` tinyint(1) UNSIGNED NULL DEFAULT 0 COMMENT '是否填写报告册\r\n',
  `identify_filled_flag` int(11) NULL DEFAULT NULL,
  `report_filled_flag` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 151 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学生信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sx_student
-- ----------------------------
INSERT INTO `sx_student` VALUES (136, '201512045141', 'E10ADC3949BA59ABBE56E057F20F883E', '泽仁拉姆', 22, '女', '1878322', '2324', '23434dv', '513229199612160724', '文法', '12', '法学', '030101', '2019-11-14 10:15:39', '2019-11-22 19:51:14', '3454645', 'dfdg', '34546', 'bdfbfgb', '2016010374', NULL, 2, 2, NULL, NULL);
INSERT INTO `sx_student` VALUES (137, '201513015114', 'E10ADC3949BA59ABBE56E057F20F883E', '胡伟', 23, '女', NULL, NULL, NULL, '513125199610152244', '文法', '13', '法学', '030101', '2019-11-14 10:15:39', '2019-11-20 22:37:28', NULL, NULL, NULL, NULL, '2016010242', NULL, 0, 0, NULL, NULL);
INSERT INTO `sx_student` VALUES (138, '201513015252', 'E10ADC3949BA59ABBE56E057F20F883E', '杨永红', 22, '女', NULL, NULL, NULL, '513227199705102424', '文法', '13', '法学', '030101', '2019-11-14 10:15:39', '2019-11-20 22:37:28', NULL, NULL, NULL, NULL, '2016010242', NULL, 0, 0, NULL, NULL);
INSERT INTO `sx_student` VALUES (139, '201513015310', 'E10ADC3949BA59ABBE56E057F20F883E', '康珠拥措', 22, '女', NULL, NULL, NULL, '513334199701100025', '文法', '13', '法学', '030101', '2019-11-14 10:15:39', '2019-11-22 19:48:54', NULL, NULL, NULL, NULL, '2016010302', NULL, 1, 2, NULL, NULL);
INSERT INTO `sx_student` VALUES (140, '201530015340', 'E10ADC3949BA59ABBE56E057F20F883E', '鲁桑杜基', 26, '男', NULL, NULL, NULL, '513422199307032917', '会计', '30', '会计学', '120203', '2019-11-14 10:15:39', '2019-11-23 11:35:12', NULL, NULL, NULL, NULL, '2016010374', NULL, 1, 0, 2, 1);
INSERT INTO `sx_student` VALUES (141, '201512025101', 'E10ADC3949BA59ABBE56E057F20F883E', '安莎', 22, '女', NULL, NULL, NULL, '522424199705104641', '经济管理', '12', '工商管理', '120201', '2019-11-14 10:15:39', '2019-11-23 11:35:12', NULL, NULL, NULL, NULL, '2016010374', NULL, 0, 0, 0, 0);
INSERT INTO `sx_student` VALUES (142, '201512025409', 'E10ADC3949BA59ABBE56E057F20F883E', '加里准', 24, '女', NULL, NULL, NULL, '513229199510081048', '经济管理', '12', '工商管理', '120201', '2019-11-14 10:15:39', '2019-11-23 11:35:12', NULL, NULL, NULL, NULL, '2016010374', NULL, 0, 0, 0, 0);
INSERT INTO `sx_student` VALUES (143, '201512025142', 'E10ADC3949BA59ABBE56E057F20F883E', '余小花', 23, '女', NULL, NULL, NULL, '513425199611185028', '经济管理', '12', '工商管理', '120201', '2019-11-14 10:15:39', '2019-11-23 11:35:12', NULL, NULL, NULL, NULL, '2016010374', NULL, 1, 1, NULL, NULL);
INSERT INTO `sx_student` VALUES (144, '201530015323', 'E10ADC3949BA59ABBE56E057F20F883E', '洛松', 22, '男', NULL, NULL, NULL, '513333199703080017', '会计', '30', '会计学', '120203', '2019-11-14 10:15:39', '2019-11-23 11:35:12', NULL, NULL, NULL, NULL, '2016010374', NULL, 0, 0, 0, 0);
INSERT INTO `sx_student` VALUES (145, '201530015331', 'E10ADC3949BA59ABBE56E057F20F883E', '宋杨', 23, '女', NULL, NULL, NULL, '513128199608260042', '会计', '30', '会计学', '120203', '2019-11-14 10:15:39', '2019-11-21 13:12:55', NULL, NULL, NULL, NULL, '2016010303', NULL, 0, 0, NULL, NULL);
INSERT INTO `sx_student` VALUES (146, '201530015548', 'E10ADC3949BA59ABBE56E057F20F883E', '余烽荣', 24, '男', NULL, NULL, NULL, '513401199506273033', '会计', '30', '会计学', '120203', '2019-11-14 10:15:39', '2019-11-23 11:35:12', NULL, NULL, NULL, NULL, '2016010374', NULL, 0, 0, 0, 0);
INSERT INTO `sx_student` VALUES (147, '201530015622', 'E10ADC3949BA59ABBE56E057F20F883E', '李维莲', 22, '女', NULL, NULL, NULL, '513227199703151628', '会计', '30', '会计学', '120203', '2019-11-14 10:15:39', '2019-11-23 11:35:12', NULL, NULL, NULL, NULL, '2016010374', NULL, 0, 0, 0, 0);
INSERT INTO `sx_student` VALUES (148, '201530015745', 'E10ADC3949BA59ABBE56E057F20F883E', '叶茂皓', 24, '男', NULL, NULL, NULL, '513422199510250012', '会计', '30', '会计学', '120203', '2019-11-14 10:15:39', '2019-11-23 11:35:12', NULL, NULL, NULL, NULL, '2016010374', NULL, 0, 0, 0, 0);
INSERT INTO `sx_student` VALUES (149, '201530095124', 'E10ADC3949BA59ABBE56E057F20F883E', '于天宇', 23, '女', NULL, NULL, NULL, '13022419960415154X', '会计', '30', '会计学(ACCA)', '120203', '2019-11-14 10:15:40', '2019-11-23 11:35:12', NULL, NULL, NULL, NULL, '2016010374', NULL, 0, 0, 0, 0);
INSERT INTO `sx_student` VALUES (150, '201529055119', 'E10ADC3949BA59ABBE56E057F20F883E', '孔紫菡', 22, '女', NULL, NULL, NULL, '513128199708145324', '经济管理', '29', '旅游管理', '120901', '2019-11-14 10:15:40', '2019-11-23 11:35:12', NULL, NULL, NULL, NULL, '2016010374', NULL, 0, 0, 0, 0);

-- ----------------------------
-- Table structure for sx_teacher
-- ----------------------------
DROP TABLE IF EXISTS `sx_teacher`;
CREATE TABLE `sx_teacher`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `teacher_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '教职工号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `id_card` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `college` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学院',
  `college_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学院代码',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 83 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '校内导师信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sx_teacher
-- ----------------------------
INSERT INTO `sx_teacher` VALUES (73, '2016010302', 'E10ADC3949BA59ABBE56E057F20F883E', '张际萍', 45, '女', '510103197406017360', '会计学院', '30', '2019-11-14 10:15:58', '2019-11-14 10:15:58');
INSERT INTO `sx_teacher` VALUES (74, '2016010303', 'E10ADC3949BA59ABBE56E057F20F883E', '王晓秋', 44, '女', '520103197508252021', '会计学院', '30', '2019-11-14 10:15:58', '2019-11-14 10:15:58');
INSERT INTO `sx_teacher` VALUES (75, '2016010304', 'E10ADC3949BA59ABBE56E057F20F883E', '夏洪智', 39, '男', '220284198011140013', '会计学院', '30', '2019-11-14 10:15:58', '2019-11-14 10:15:58');
INSERT INTO `sx_teacher` VALUES (76, '2016010307', 'E10ADC3949BA59ABBE56E057F20F883E', '刘燕', 40, '女', '510126197912061043', '会计学院', '30', '2019-11-14 10:15:58', '2019-11-14 10:15:58');
INSERT INTO `sx_teacher` VALUES (77, '2016010372', 'E10ADC3949BA59ABBE56E057F20F883E', '袁骏', 44, '男', '510106197512280719', '经济管理学院', '12', '2019-11-14 10:15:58', '2019-11-14 10:15:58');
INSERT INTO `sx_teacher` VALUES (78, '2016010374', 'E10ADC3949BA59ABBE56E057F20F883E', '李映辉', 41, '男', '510622197803148117', '经济管理学院', '12', '2019-11-14 10:15:58', '2019-11-14 10:15:58');
INSERT INTO `sx_teacher` VALUES (79, '2016010377', 'E10ADC3949BA59ABBE56E057F20F883E', '钟涛', 38, '男', '510112198110210031', '经济管理学院', '12', '2019-11-14 10:15:58', '2019-11-14 10:15:58');
INSERT INTO `sx_teacher` VALUES (80, '2016010379', 'E10ADC3949BA59ABBE56E057F20F883E', '石玉峰', 46, '男', '510107197310279636', '经济管理学院', '12', '2019-11-14 10:15:58', '2019-11-14 10:15:58');
INSERT INTO `sx_teacher` VALUES (81, '2016010242', 'E10ADC3949BA59ABBE56E057F20F883E', '蒋瑜', 38, '女', '510107198103210526', '文法学院', '13', '2019-11-14 10:15:58', '2019-11-14 10:15:58');
INSERT INTO `sx_teacher` VALUES (82, '2016010243', 'E10ADC3949BA59ABBE56E057F20F883E', '曹佳丽', 39, '女', '510282198011010821', '文法学院', '13', '2019-11-14 10:15:58', '2019-11-14 10:15:58');

SET FOREIGN_KEY_CHECKS = 1;
