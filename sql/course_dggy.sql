/*
Navicat MySQL Data Transfer

Source Server         : fuwuqi
Source Server Version : 50562
Source Host           : 192.168.2.200:3306
Source Database       : course_dggy

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-09-06 11:25:31
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
INSERT INTO `component_group` VALUES ('3fe6baf0-3d2f-404f-ac31-6e5a69460a9a', '2019-09-05 13:57:56', '2019-09-05 13:57:56', null, '工具', null);
INSERT INTO `component_group` VALUES ('52b454eb-6c2c-4719-8d97-be71daf4e64d', '2019-09-05 13:58:15', '2019-09-05 13:58:15', null, '材料', null);
INSERT INTO `component_group` VALUES ('8e056334-c10d-44ea-8b51-42276ff66615', '2019-09-05 13:58:02', '2019-09-05 13:58:02', null, '导线', null);
INSERT INTO `component_group` VALUES ('9d265e19-7835-489a-9eea-2935263e339f', '2019-09-05 13:57:42', '2019-09-05 13:57:42', null, '设备', null);
INSERT INTO `component_group` VALUES ('acc926b6-e174-45cf-98a7-f53cd0bd596f', '2019-09-05 13:57:37', '2019-09-05 13:57:37', null, '场景', null);

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
INSERT INTO `training` VALUES ('1572dad7-9b4b-47ca-a7d0-ecfcbec59b3f', '2019-09-05 13:48:33', '2019-09-05 14:11:12', null, '56a37460-65d7-4299-875c-2a9bea31f739', '', '常用电工工具的使用', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('15c85049-9b87-4fdd-99e6-5140ecd91583', '2019-09-05 13:48:58', '2019-09-05 14:06:47', null, '56a37460-65d7-4299-875c-2a9bea31f739', '', '七股导线的连接方法', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('17e84cd6-077b-404d-a928-d960cfcebab8', '2019-09-05 13:49:34', '2019-09-05 14:06:31', null, '61d24b75-381f-4b53-bbcf-7adbc6f47ec6', '', '白炽灯照明线路安装和维修', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('2704f993-ba16-42d9-b375-64a6d0b6a9d9', '2019-09-05 13:50:25', '2019-09-05 14:05:31', null, '62c57e54-4a72-4f3c-879e-85b185e929c6', '', '低压配电盘的安装方法', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('42e579c9-f54b-4063-96bc-10d706f28814', '2019-09-05 13:48:43', '2019-09-05 14:11:03', null, '56a37460-65d7-4299-875c-2a9bea31f739', '', '常用电动工具的使用', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('4407cfb4-c73d-4fe4-b36a-59d1ee578bb6', '2019-09-05 13:50:01', '2019-09-05 14:05:53', null, '62c57e54-4a72-4f3c-879e-85b185e929c6', '', '线槽配线的配线方法', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('4a7749fc-7f87-48bc-ac5c-d480c5edc3b4', '2019-09-05 13:48:53', '2019-09-05 14:06:52', null, '56a37460-65d7-4299-875c-2a9bea31f739', '', '单股导线的连接方法', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('562c3be7-f006-485e-9eb1-dc824956d189', '2019-09-05 13:48:16', '2019-09-05 14:11:18', null, 'c19e4f8d-50d3-4ec0-90ab-4bea11fbac4b', '', '安全标志', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('5861c8bc-be4f-4458-8a14-88ade16b3c9f', '2019-09-05 13:48:49', '2019-09-05 14:10:59', null, '56a37460-65d7-4299-875c-2a9bea31f739', '', '常用登高工具的使用', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('634ae173-351a-4330-87b5-62e154d15476', '2019-09-05 13:49:06', '2019-09-05 14:06:44', null, '56a37460-65d7-4299-875c-2a9bea31f739', '', '导线种类和截面的选用', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('643e325e-d2a3-472d-8dea-ed14f05afc5f', '2019-09-05 13:50:20', '2019-09-05 14:05:40', null, '62c57e54-4a72-4f3c-879e-85b185e929c6', '', '拖链带配线的配线方法', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('6befcd8b-2692-42c8-99c9-86e158ce4088', '2019-09-06 10:28:52', '2019-09-06 10:28:52', null, '7017986f-c9ff-11e9-81b8-7085c206b232', '25da96b4-c9fe-11e9-81b8-7085c206b232', '123', '0', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('79db24d0-734e-46ae-9975-fb4907548696', '2019-09-05 13:48:21', '2019-09-05 14:11:15', null, 'c19e4f8d-50d3-4ec0-90ab-4bea11fbac4b', '', '触电急救的操作方法', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('8a5c42f8-85dd-4479-be59-6b14e5da89da', '2019-09-05 13:49:12', '2019-09-05 14:06:41', null, '56a37460-65d7-4299-875c-2a9bea31f739', '', '导线绝缘的恢复', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('aadc5b60-ed2d-4544-8c21-d4039cd91cb0', '2019-09-05 13:48:38', '2019-09-05 14:11:06', null, '56a37460-65d7-4299-875c-2a9bea31f739', '', '常用电工仪表的使用', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('b87a11b9-a5ad-45d2-addc-70608d6ed787', '2019-09-05 13:49:44', '2019-09-05 14:06:24', null, '61d24b75-381f-4b53-bbcf-7adbc6f47ec6', '', '碘钨灯、高压汞灯照明线路安装和维修', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('cf637939-48bc-4719-b632-82c140180ce0', '2019-09-05 13:49:39', '2019-09-05 14:06:28', null, '61d24b75-381f-4b53-bbcf-7adbc6f47ec6', '', '荧光灯照明线路安装和维修', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('da6214a4-10fc-45f1-983b-ee75576f20f3', '2019-09-05 13:50:14', '2019-09-05 14:05:46', null, '62c57e54-4a72-4f3c-879e-85b185e929c6', '', '桥架配线的配线方法', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('e900540e-9f94-4dd0-afc6-d83527276ecc', '2019-09-05 13:49:57', '2019-09-05 14:05:58', null, '62c57e54-4a72-4f3c-879e-85b185e929c6', '', '塑料护套线的配线方法', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('f4c17a5e-5b5d-4454-b6c9-315dac19ec07', '2019-09-05 13:48:05', '2019-09-05 14:11:21', null, 'c19e4f8d-50d3-4ec0-90ab-4bea11fbac4b', '', '电工安全操作规程', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('fa9dfa29-b7b6-444f-8434-4f098ccb3694', '2019-09-05 13:50:06', '2019-09-05 14:05:50', null, '62c57e54-4a72-4f3c-879e-85b185e929c6', '', '线管配线的配线方法', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('fd7f02b0-07fb-4bbd-8ceb-837b215e547a', '2019-09-05 13:49:51', '2019-09-05 14:06:21', null, '61d24b75-381f-4b53-bbcf-7adbc6f47ec6', '', 'LED灯、高压钠灯照明线路安装和维修', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);

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
INSERT INTO `training_module` VALUES ('56a37460-65d7-4299-875c-2a9bea31f739', '2019-09-05 13:45:04', '2019-09-05 13:45:04', null, '电工基本技能', '1');
INSERT INTO `training_module` VALUES ('61d24b75-381f-4b53-bbcf-7adbc6f47ec6', '2019-09-05 13:45:39', '2019-09-05 13:45:39', null, '照明电路的安装和维修', '1');
INSERT INTO `training_module` VALUES ('62c57e54-4a72-4f3c-879e-85b185e929c6', '2019-09-05 13:47:45', '2019-09-05 13:47:45', null, '室内照明线路的配线', '1');
INSERT INTO `training_module` VALUES ('7017986f-c9ff-11e9-81b8-7085c206b232', '2019-08-29 09:51:04', '2019-08-29 09:51:09', null, '我的实训', '0');
INSERT INTO `training_module` VALUES ('c19e4f8d-50d3-4ec0-90ab-4bea11fbac4b', '2019-09-05 13:44:57', '2019-09-05 13:44:57', null, '电工安全常识', '1');

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
