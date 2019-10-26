/*
 Navicat Premium Data Transfer

 Source Server         : Localhost
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : sx

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 25/10/2019 10:34:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (17);
INSERT INTO `hibernate_sequence` VALUES (17);
INSERT INTO `hibernate_sequence` VALUES (17);
INSERT INTO `hibernate_sequence` VALUES (17);
INSERT INTO `hibernate_sequence` VALUES (17);
INSERT INTO `hibernate_sequence` VALUES (17);
INSERT INTO `hibernate_sequence` VALUES (17);
INSERT INTO `hibernate_sequence` VALUES (17);
INSERT INTO `hibernate_sequence` VALUES (17);

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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '校外导师' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sx_corp_teacher
-- ----------------------------
INSERT INTO `sx_corp_teacher` VALUES (1, '10000', '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2019-10-23 22:59:32', '2019-10-23 22:59:32');
INSERT INTO `sx_corp_teacher` VALUES (16, 'test', '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2019-10-25 10:30:34', '2019-10-25 10:30:34');

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
  `leader_opinion` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '实习小组小组长意见',
  `l_o_date` date NULL DEFAULT NULL COMMENT '实习小组小组长意见签署时间',
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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '实习鉴定表' ROW_FORMAT = Dynamic;

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
  `stage2_summary` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '第二阶段实习总结',
  `stage2_date` date NULL DEFAULT NULL COMMENT '第二阶段填写日期',
  `stage2_comment` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '第二阶段学院实习导师评语',
  `stage2_grade` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '第二阶段实习成绩评定',
  `stage2_grade_date` date NULL DEFAULT NULL COMMENT '第二阶段实习成绩评定日期',
  `total_grade` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '学院实习指导老师总评',
  `total_score` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学院实习指导老师总评成绩ABCDE',
  `stage2_guide_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '第二阶段指导时间',
  `stage2_guide_way` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '第二阶段实习指导方式',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

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
INSERT INTO `sx_stagemanage` VALUES (1, 1, 1, 1, 1, 1, 1);

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学生信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sx_student
-- ----------------------------
INSERT INTO `sx_student` VALUES (1, '2019209007', '21232F297A57A5A743894A0E4A801FC3', '阮坤', 24, '男', '18783551223', '314445437', 'ruankun521', '510623199507266911', '信息工程学院', '101', '农业信息工程', '101001', '2019-10-17 20:10:24', '2019-10-17 20:10:54', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_student` VALUES (2, '2018209001', '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2019-10-24 16:21:20', '2019-10-24 16:21:20', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sx_student` VALUES (15, '123456', '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2019-10-24 19:10:31', '2019-10-24 19:10:31', NULL, NULL, NULL, NULL, NULL, NULL);

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
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '校内导师信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sx_teacher
-- ----------------------------
INSERT INTO `sx_teacher` VALUES (1, '10000', '12345', '张三', 34, '男', '511524196600000000', '信息工程学院', '10001', '2019-10-23 11:16:56', '2019-10-23 23:09:36');
INSERT INTO `sx_teacher` VALUES (9, '12345', '123', NULL, NULL, NULL, NULL, NULL, NULL, '2019-10-24 17:22:13', '2019-10-24 17:22:13');
INSERT INTO `sx_teacher` VALUES (10, '123456', '123', NULL, NULL, NULL, NULL, NULL, NULL, '2019-10-24 17:26:39', '2019-10-24 17:26:39');

SET FOREIGN_KEY_CHECKS = 1;
