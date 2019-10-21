/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : sx

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 21/10/2019 19:32:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sx_college_principal
-- ----------------------------
DROP TABLE IF EXISTS `sx_college_principal`;
CREATE TABLE `sx_college_principal` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `college` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '学院',
  `college_code` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学院代码',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='学院负责人';

-- ----------------------------
-- Table structure for sx_corp
-- ----------------------------
DROP TABLE IF EXISTS `sx_corp`;
CREATE TABLE `sx_corp` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `taxcode` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '纳税人识别号',
  `principal` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '负责人',
  `corp` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '企业名称',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='实习公司负责人';

-- ----------------------------
-- Table structure for sx_corp_teacher
-- ----------------------------
DROP TABLE IF EXISTS `sx_corp_teacher`;
CREATE TABLE `sx_corp_teacher` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `id_card` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '身份证号码',
  `corp` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '企业',
  `unit` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '单位',
  `work` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '工作',
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '电话',
  `qq` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'qq',
  `mail` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱',
  `wechat` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '微信',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='校外导师';

-- ----------------------------
-- Table structure for sx_identify_form
-- ----------------------------
DROP TABLE IF EXISTS `sx_identify_form`;
CREATE TABLE `sx_identify_form` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `stu_no` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '学号',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `gmt_start` date DEFAULT NULL COMMENT '实习开始时间',
  `gmt_end` date DEFAULT NULL COMMENT '实习结束时间',
  `sx_content` text COLLATE utf8mb4_general_ci COMMENT '实习内容',
  `self_summary` text COLLATE utf8mb4_general_ci COMMENT '自我总结',
  `leader_opinion` text COLLATE utf8mb4_general_ci COMMENT '实习小组小组长意见',
  `l_o_date` date DEFAULT NULL COMMENT '实习小组小组长意见签署时间',
  `corp_teacher_opinion` text COLLATE utf8mb4_general_ci COMMENT '校外导师意见',
  `corp_teacher_score` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '校外导师打分',
  `c_t_o_date` date DEFAULT NULL COMMENT '校外导师意见填写日期',
  `corp_opinion` text COLLATE utf8mb4_general_ci COMMENT '实习单位意见',
  `c_o_date` date DEFAULT NULL COMMENT '实习单位意见填写时间',
  `corp_teacher_grade` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '实习单位导师成绩评定',
  `c_t_g_date` date DEFAULT NULL COMMENT '实习单位导师成绩评定日期',
  `teacher_grade` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学院导师成绩评定',
  `t_g_date` date DEFAULT NULL COMMENT '学院导师成绩评定日期',
  `comprehsv_grade` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '综合实习成绩评定',
  `c_g_date` date DEFAULT NULL COMMENT '综合实习成绩评定日期',
  `college_principal_opinion` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学院实习领导小组意见',
  `c_p_o_date` date DEFAULT NULL COMMENT '学院实习领导小组意见填写日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='实习鉴定表';

-- ----------------------------
-- Table structure for sx_report
-- ----------------------------
DROP TABLE IF EXISTS `sx_report`;
CREATE TABLE `sx_report` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `stu_no` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '关联学生学号',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `gmt_start` date DEFAULT NULL COMMENT '实习开始时间',
  `gmt_end` date DEFAULT NULL COMMENT '实习结束时间',
  `stage1_guide_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '第一阶段指导时间,应该为时间段，留varchar',
  `stage1_guide_way` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '第一阶段指导方式',
  `stage1_summary` text COLLATE utf8mb4_general_ci COMMENT '第一阶段实习总结',
  `stage1_date` date DEFAULT NULL COMMENT '第一阶段填写日期',
  `stage1_comment` text COLLATE utf8mb4_general_ci COMMENT '第一阶段学院实习指导教师评语',
  `stage1_grade` text COLLATE utf8mb4_general_ci COMMENT '第一阶段实习成绩评定',
  `stage1_grade_date` date DEFAULT NULL COMMENT '第一阶段实习成绩评定日期',
  `stage2_summary` text COLLATE utf8mb4_general_ci COMMENT '第二阶段实习总结',
  `stage2_date` date DEFAULT NULL COMMENT '第二阶段填写日期',
  `stage2_comment` text COLLATE utf8mb4_general_ci COMMENT '第二阶段学院实习导师评语',
  `stage2_grade` text COLLATE utf8mb4_general_ci COMMENT '第二阶段实习成绩评定',
  `stage2_grade_date` date DEFAULT NULL COMMENT '第二阶段实习成绩评定日期',
  `total_grade` text COLLATE utf8mb4_general_ci COMMENT '学院实习指导老师总评',
  `total_score` varchar(12) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学院实习指导老师总评成绩ABCDE',
  `stage2_guide_date` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '第二阶段指导时间',
  `stage2_guide_way` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '第二阶段实习指导方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for sx_root
-- ----------------------------
DROP TABLE IF EXISTS `sx_root`;
CREATE TABLE `sx_root` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '超管账号',
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '超管密码',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='超级管理员的信息';

-- ----------------------------
-- Records of sx_root
-- ----------------------------
BEGIN;
INSERT INTO `sx_root` VALUES (1, 'admin', '21232F297A57A5A743894A0E4A801FC3', '2019-10-17 19:51:46', '2019-10-17 19:51:46');
COMMIT;

-- ----------------------------
-- Table structure for sx_stagemanage
-- ----------------------------
DROP TABLE IF EXISTS `sx_stagemanage`;
CREATE TABLE `sx_stagemanage` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `is_report_stage1_open` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '报告册第一阶段开放:学生填写阶段1,教师评价阶段1',
  `is_report_stage2_open` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '报告册第二阶段开放:学生填写阶段2,教师评价阶段2',
  `is_report_stage3_open` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '报告册第三阶段开放:教师进行总评/打总成绩',
  `is_identify_form_stage1_open` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '鉴定表第一阶段开放:学生填写阶段',
  `is_identify_form_stage2_open` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '鉴定表第二阶段开放:其他角色(除学院领导小组)进行意见填写/打分',
  `is_identify_form_stage3_open` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '鉴定表第三阶段开放:学院领导小组意见填写/打分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of sx_stagemanage
-- ----------------------------
BEGIN;
INSERT INTO `sx_stagemanage` VALUES (1, 1, 1, 1, 1, 1, 1);
COMMIT;

-- ----------------------------
-- Table structure for sx_student
-- ----------------------------
DROP TABLE IF EXISTS `sx_student`;
CREATE TABLE `sx_student` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `stu_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学号',
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '电话',
  `qq` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'qq',
  `wechat` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '微信',
  `id_card` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '身份证号',
  `college` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学院',
  `college_code` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学院代码',
  `major` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '专业',
  `major_code` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '专业代码',
  `group` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '组',
  `group_code` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '组代码',
  `is_group_head` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否是小组长',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `corp_taxcode` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '实习企业信用代码',
  `corp_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '企业名称',
  `corp_reg_code` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '企业注册号',
  `corp_position` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '实习岗位',
  `teacher_no` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '校内导师工号',
  `corp_teacher_no` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '校外导师工号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='学生信息';

-- ----------------------------
-- Records of sx_student
-- ----------------------------
BEGIN;
INSERT INTO `sx_student` VALUES (1, '2019209007', '21232F297A57A5A743894A0E4A801FC3', '阮坤', 24, '男', '18783551223', '314445437', 'ruankun521', '510623199507266911', '信息工程学院', '101', '农业信息工程', '101001', NULL, NULL, 0, '2019-10-17 20:10:24', '2019-10-17 20:10:54', NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sx_teacher
-- ----------------------------
DROP TABLE IF EXISTS `sx_teacher`;
CREATE TABLE `sx_teacher` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `teacher_no` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '教职工号',
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '性别',
  `id_card` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '身份证号码',
  `college` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学院',
  `college_code` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学院代码',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='校内导师信息';

SET FOREIGN_KEY_CHECKS = 1;
