/*
Navicat MySQL Data Transfer

Source Server         : fuwuqi
Source Server Version : 50562
Source Host           : 192.168.2.200:3306
Source Database       : course_cp

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-09-06 11:25:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for component
-- ----------------------------
DROP TABLE IF EXISTS `component`;
CREATE TABLE `component` (
  `id` varchar(36) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `group_id` varchar(36) DEFAULT NULL,
  `introduction` text,
  `parameter` text,
  `schematic` varchar(128) DEFAULT NULL,
  `type` varchar(64) DEFAULT NULL,
  `alias_Chinese` varchar(64) DEFAULT NULL,
  `alias_English` varchar(64) DEFAULT NULL,
  `icon` varchar(128) DEFAULT NULL,
  `vendor` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of component
-- ----------------------------

-- ----------------------------
-- Table structure for component_group
-- ----------------------------
DROP TABLE IF EXISTS `component_group`;
CREATE TABLE `component_group` (
  `id` varchar(36) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `alias` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of component_group
-- ----------------------------

-- ----------------------------
-- Table structure for experiment_types
-- ----------------------------
DROP TABLE IF EXISTS `experiment_types`;
CREATE TABLE `experiment_types` (
  `id` varchar(36) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL COMMENT '类型名称',
  `alias` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uix_experiment_types_name` (`name`),
  KEY `idx_experiment_types_deleted_at` (`deleted_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='实验类型';

-- ----------------------------
-- Records of experiment_types
-- ----------------------------
INSERT INTO `experiment_types` VALUES ('9ebde672-008e-4588-8e49-0c634c4b7f22', '2019-05-08 14:06:47', '2019-05-08 14:06:47', null, '综合实验', 'complex');
INSERT INTO `experiment_types` VALUES ('a252d75d-a06c-4ce1-ad4f-ff3b32cf86f7', '2019-05-08 14:06:47', '2019-05-08 14:06:47', null, '创新实验', 'Innovation');
INSERT INTO `experiment_types` VALUES ('abed17b5-fb4f-4164-8de2-a8145bd2ed58', '2019-05-08 14:06:47', '2019-05-08 14:06:47', null, '基础实验', 'basis');

-- ----------------------------
-- Table structure for resources
-- ----------------------------
DROP TABLE IF EXISTS `resources`;
CREATE TABLE `resources` (
  `id` varchar(36) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `creator_id` varchar(36) DEFAULT NULL,
  `resource_type_id` varchar(36) DEFAULT NULL,
  `name` varchar(64) NOT NULL COMMENT '资源名称',
  `path` varchar(128) NOT NULL COMMENT '资源路径',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uix_resources_path` (`path`),
  KEY `idx_course_resource` (`resource_type_id`),
  KEY `idx_resources_deleted_at` (`deleted_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of resources
-- ----------------------------

-- ----------------------------
-- Table structure for resource_type
-- ----------------------------
DROP TABLE IF EXISTS `resource_type`;
CREATE TABLE `resource_type` (
  `id` varchar(36) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `name` varchar(16) NOT NULL COMMENT '资源名称（字母代号）',
  `alias` varchar(16) NOT NULL COMMENT '资源名称（中文名称）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uix_resource_types_alias` (`alias`),
  UNIQUE KEY `uix_resource_types_name` (`name`),
  KEY `idx_resource_types_deleted_at` (`deleted_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源类型表';

-- ----------------------------
-- Records of resource_type
-- ----------------------------
INSERT INTO `resource_type` VALUES ('3b5280a9-0a9b-4be2-a476-4b3944445220', '2019-05-08 14:06:47', '2019-05-08 14:06:47', null, 'theory', '理论题');
INSERT INTO `resource_type` VALUES ('4cef1a50-79d9-11e9-a6ab-7085c206b232', '2019-05-19 09:56:21', '2019-05-19 09:56:21', null, 'report', '实验报告');
INSERT INTO `resource_type` VALUES ('7cb41d17-79d9-11e9-a6ab-7085c206b232', '2019-05-19 09:57:41', '2019-05-19 09:57:41', null, 'advising', '实验指导');
INSERT INTO `resource_type` VALUES ('9fe84a96-1099-429f-b39f-0a9c3f11e7bc', '2019-05-08 14:06:47', '2019-05-08 14:06:47', null, 'video', '视屏');
INSERT INTO `resource_type` VALUES ('acd923e5-881d-11e9-9e42-7085c206b232', '2019-06-06 13:41:04', '2019-06-06 13:41:04', null, 'sim', '数据文件');
INSERT INTO `resource_type` VALUES ('b0f51ae0-5fd9-4f58-9fe1-64974e7bdabd', '2019-05-08 14:06:47', '2019-05-08 14:06:47', null, 'file', '文件');
INSERT INTO `resource_type` VALUES ('c1efd8d8-881d-11e9-9e42-7085c206b232', '2019-06-06 13:41:40', '2019-06-06 13:41:40', null, 'scene', '场景文件');
INSERT INTO `resource_type` VALUES ('c4d3d3d7-8ced-11e9-a44d-7085c206b232', '2019-06-12 16:41:26', '2019-06-12 16:41:32', null, 'template_scene', '模板场景');
INSERT INTO `resource_type` VALUES ('e15356e5-79d8-11e9-a6ab-7085c206b232', '2019-05-19 09:53:21', '2019-05-19 09:53:21', null, 'annex', '附件');

-- ----------------------------
-- Table structure for scene_type
-- ----------------------------
DROP TABLE IF EXISTS `scene_type`;
CREATE TABLE `scene_type` (
  `id` varchar(36) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `name` varchar(16) DEFAULT NULL,
  `alias` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scene_type
-- ----------------------------
INSERT INTO `scene_type` VALUES ('229ea775-9663-11e9-b790-7085c206b232', '2019-06-24 17:33:31', '2019-06-24 17:33:31', null, '二维原理图', '2d');
INSERT INTO `scene_type` VALUES ('23f50dba-9663-11e9-b790-7085c206b232', '2019-06-24 17:33:34', '2019-06-24 17:33:34', null, '二维接线图', '2d');
INSERT INTO `scene_type` VALUES ('24941bc3-9663-11e9-b790-7085c206b232', '2019-06-24 17:33:35', '2019-06-24 17:33:35', null, '二维布局图', '2d');
INSERT INTO `scene_type` VALUES ('2539d5f1-9663-11e9-b790-7085c206b232', '2019-06-24 17:33:36', '2019-06-24 17:33:36', null, '三维工厂场景', '3d');
INSERT INTO `scene_type` VALUES ('9b940c48-9e3c-11e9-b790-7085c206b232', '2019-07-04 17:17:59', '2019-07-04 17:18:08', null, '三维教学场景', '3d');
INSERT INTO `scene_type` VALUES ('9cc5c5dc-9e3c-11e9-b790-7085c206b232', '2019-07-04 17:18:05', '2019-07-04 17:18:11', null, '三维工程场景', '3d');

-- ----------------------------
-- Table structure for simulation_resource
-- ----------------------------
DROP TABLE IF EXISTS `simulation_resource`;
CREATE TABLE `simulation_resource` (
  `id` varchar(36) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `name` varchar(32) NOT NULL,
  `innerr` tinyint(1) NOT NULL,
  `type_id` varchar(36) NOT NULL,
  `creator_id` varchar(36) DEFAULT NULL,
  `path` varchar(255) NOT NULL,
  `exp_type_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of simulation_resource
-- ----------------------------

-- ----------------------------
-- Table structure for training
-- ----------------------------
DROP TABLE IF EXISTS `training`;
CREATE TABLE `training` (
  `id` varchar(36) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `module_id` varchar(36) DEFAULT NULL,
  `type_id` varchar(36) DEFAULT NULL,
  `name` varchar(32) NOT NULL COMMENT '实验名称',
  `innerr` tinyint(1) NOT NULL COMMENT '是否内置实验',
  `creator_id` varchar(36) DEFAULT NULL COMMENT '创建老师id',
  `teach_description` text COMMENT '教学模式说明',
  `practice_description` text COMMENT '练习模式说明',
  `exam_description` text COMMENT '考核模式说明',
  PRIMARY KEY (`id`),
  KEY `idx_task_experiment_templates_deleted_at` (`deleted_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务模板表';

-- ----------------------------
-- Records of training
-- ----------------------------

-- ----------------------------
-- Table structure for training_file
-- ----------------------------
DROP TABLE IF EXISTS `training_file`;
CREATE TABLE `training_file` (
  `id` varchar(36) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `name` varchar(128) NOT NULL,
  `path` varchar(128) NOT NULL,
  `size` varchar(16) NOT NULL,
  `type_id` varchar(36) DEFAULT NULL,
  `suffix` varchar(8) NOT NULL,
  `quote` int(11) NOT NULL,
  `training_id` varchar(36) DEFAULT NULL,
  `training_pattern` varchar(16) DEFAULT NULL,
  `type` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of training_file
-- ----------------------------

-- ----------------------------
-- Table structure for training_module
-- ----------------------------
DROP TABLE IF EXISTS `training_module`;
CREATE TABLE `training_module` (
  `id` varchar(36) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `name` varchar(12) NOT NULL,
  `visible` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of training_module
-- ----------------------------
INSERT INTO `training_module` VALUES ('7017986f-c9ff-11e9-81b8-7085c206b232', '2019-08-29 09:51:04', '2019-08-29 09:51:09', null, '我的实训', '0');
INSERT INTO `training_module` VALUES ('a17a1d9a-ea67-4842-bf40-2a77b0bda785', '2019-09-04 09:47:23', '2019-09-04 09:47:23', null, '低压电气', '1');

-- ----------------------------
-- Table structure for training_sim
-- ----------------------------
DROP TABLE IF EXISTS `training_sim`;
CREATE TABLE `training_sim` (
  `id` varchar(36) NOT NULL,
  `created_at` varchar(255) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` varchar(255) DEFAULT NULL,
  `training_id` varchar(36) NOT NULL,
  `sim_id` varchar(36) NOT NULL,
  `mode` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of training_sim
-- ----------------------------

-- ----------------------------
-- Table structure for training_type
-- ----------------------------
DROP TABLE IF EXISTS `training_type`;
CREATE TABLE `training_type` (
  `id` varchar(36) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `name` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of training_type
-- ----------------------------
INSERT INTO `training_type` VALUES ('25da96b4-c9fe-11e9-81b8-7085c206b232', '2019-08-29 09:41:42', '2019-08-29 09:41:59', null, '虚拟仿真');
INSERT INTO `training_type` VALUES ('260e8769-c9fe-11e9-81b8-7085c206b232', '2019-08-29 09:41:43', '2019-08-29 09:42:11', null, '虚实结合');
INSERT INTO `training_type` VALUES ('26ae6557-c9fe-11e9-81b8-7085c206b232', '2019-08-29 09:41:44', '2019-08-29 09:42:17', null, '虚实联动');

-- ----------------------------
-- Procedure structure for update_task
-- ----------------------------
DROP PROCEDURE IF EXISTS `update_task`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `update_task`(IN p_in varchar(36))
    COMMENT '修改task_experiment的completed为1'
begin
update task_experiments set completed = 1 where id = p_in;
update account_and_task_experiments set statu = 'expired' where task_experiment_id = p_in and (statu='new' or statu='save');
end
;;
DELIMITER ;
