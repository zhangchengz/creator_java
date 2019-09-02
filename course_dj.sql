/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : course_dj

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2019-09-02 15:35:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account_and_task_experiments
-- ----------------------------
DROP TABLE IF EXISTS `account_and_task_experiments`;
CREATE TABLE `account_and_task_experiments` (
  `id` varchar(36) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `account_id` varchar(36) NOT NULL COMMENT '账号id',
  `task_experiment_id` varchar(36) NOT NULL COMMENT '任务id',
  `statu` varchar(16) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`),
  KEY `idx_account_and_task_experiments_deleted_at` (`deleted_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账号和任务关联表';

-- ----------------------------
-- Records of account_and_task_experiments
-- ----------------------------
INSERT INTO `account_and_task_experiments` VALUES ('07e80676-6fc3-49a2-8f05-044fc74d2222', '2019-08-09 11:35:55', '2019-08-09 11:35:55', null, '2da7dcfc-629a-4550-9bd7-2d096d7d06a6', '953d5b88-1fd2-4fdd-bd08-390d35d2166d', 'approved');
INSERT INTO `account_and_task_experiments` VALUES ('09d4e46d-a47a-4098-a8a4-85b2f71e6993', '2019-08-09 15:48:38', '2019-08-09 15:48:38', null, '256ea2d0-1091-46da-8e7f-de36ad3f45d7', '5741127a-7692-44d3-828e-191946250606', 'expired');
INSERT INTO `account_and_task_experiments` VALUES ('0d44410b-1c89-4f91-9770-313d6395ffae', '2019-08-09 11:35:55', '2019-08-09 11:35:55', null, '14a98659-4b61-4933-9eff-a0ba1eda3f8a', '953d5b88-1fd2-4fdd-bd08-390d35d2166d', 'expired');
INSERT INTO `account_and_task_experiments` VALUES ('2a0f0838-f8e9-48b5-85b3-f0c66a9f4baf', '2019-08-07 09:37:02', '2019-08-07 09:37:02', null, 'f6e2d806-87a4-447f-b4e8-aec0c297e318', '84e96d72-dcab-4bda-9ffb-caa3cd31f234', 'expired');
INSERT INTO `account_and_task_experiments` VALUES ('30120bd8-c18d-44d7-ba6b-3a570e3cbe94', '2019-08-07 09:37:02', '2019-08-07 09:37:02', null, '256ea2d0-1091-46da-8e7f-de36ad3f45d7', '84e96d72-dcab-4bda-9ffb-caa3cd31f234', 'approved');
INSERT INTO `account_and_task_experiments` VALUES ('347f6dd5-432c-4540-b6ec-bd4bdfe394b9', '2019-08-09 18:37:57', '2019-08-09 18:37:57', null, '256ea2d0-1091-46da-8e7f-de36ad3f45d7', 'd738807c-29b2-4f95-a6fe-d29c86e47ded', 'expired');
INSERT INTO `account_and_task_experiments` VALUES ('3b45a447-0b63-4c92-b89e-d964937f7441', '2019-08-09 19:47:54', '2019-08-09 19:47:54', null, '2da7dcfc-629a-4550-9bd7-2d096d7d06a6', '69b3bcc3-a9a7-4ba2-8a37-b89cd09ff996', 'expired');
INSERT INTO `account_and_task_experiments` VALUES ('48e8dfb6-0732-43e0-8e74-dc1f5470d102', '2019-08-07 09:37:02', '2019-08-07 09:37:02', null, '2da7dcfc-629a-4550-9bd7-2d096d7d06a6', '84e96d72-dcab-4bda-9ffb-caa3cd31f234', 'expired');
INSERT INTO `account_and_task_experiments` VALUES ('52272370-8db5-4a32-beed-1fd933828b8e', '2019-08-08 09:34:40', '2019-08-08 09:34:40', null, '256ea2d0-1091-46da-8e7f-de36ad3f45d7', '64a60e3d-57c8-4b1f-9831-cab8822a1bbb', 'expired');
INSERT INTO `account_and_task_experiments` VALUES ('556a5e58-5cc4-433e-bebd-a7567292eee7', '2019-08-07 09:37:02', '2019-08-07 09:37:02', null, '14a98659-4b61-4933-9eff-a0ba1eda3f8a', '84e96d72-dcab-4bda-9ffb-caa3cd31f234', 'expired');
INSERT INTO `account_and_task_experiments` VALUES ('57713fc5-a2c4-45a2-91dc-d98de606f9c0', '2019-08-19 10:13:05', '2019-08-19 10:13:05', null, '256ea2d0-1091-46da-8e7f-de36ad3f45d7', 'd4b354df-cd6a-4cd7-895a-cfce9773ad1a', 'approved');
INSERT INTO `account_and_task_experiments` VALUES ('5c0b05a7-2c53-4105-8659-47cb67419a3e', '2019-08-09 19:47:54', '2019-08-09 19:47:54', null, '256ea2d0-1091-46da-8e7f-de36ad3f45d7', '69b3bcc3-a9a7-4ba2-8a37-b89cd09ff996', 'submit');
INSERT INTO `account_and_task_experiments` VALUES ('681a7333-8d54-45e9-9070-f1d4662387a9', '2019-08-09 19:56:14', '2019-08-09 19:56:14', null, '2da7dcfc-629a-4550-9bd7-2d096d7d06a6', '607a162c-162d-441d-ad08-3981f98df06b', 'submit');
INSERT INTO `account_and_task_experiments` VALUES ('6908c2ce-d4f7-48b4-bb04-608ca6e9b75a', '2019-08-07 11:24:37', '2019-08-07 11:24:37', null, '256ea2d0-1091-46da-8e7f-de36ad3f45d7', 'a8200d89-83f4-4d83-9e25-3229376d52be', 'expired');
INSERT INTO `account_and_task_experiments` VALUES ('6ed56c8d-0931-4163-8df9-91d2b27b262f', '2019-08-09 15:47:24', '2019-08-09 15:47:24', null, '2da7dcfc-629a-4550-9bd7-2d096d7d06a6', '9b765d22-1742-4506-873d-fb6e20e9c276', 'new');
INSERT INTO `account_and_task_experiments` VALUES ('71bedd32-dbe9-4c1d-b5a0-10ffc52d03be', '2019-08-09 18:29:36', '2019-08-09 18:29:36', null, '2da7dcfc-629a-4550-9bd7-2d096d7d06a6', 'c8674cc2-1383-41f1-9327-b8f50fe4b71a', 'new');
INSERT INTO `account_and_task_experiments` VALUES ('7ccae3f7-aee9-44cb-863f-5ed62dfe5f2f', '2019-08-09 15:47:24', '2019-08-09 15:47:24', null, '256ea2d0-1091-46da-8e7f-de36ad3f45d7', '9b765d22-1742-4506-873d-fb6e20e9c276', 'save');
INSERT INTO `account_and_task_experiments` VALUES ('88f9acee-b76b-4551-b814-19c70c5efe3c', '2019-08-19 10:13:05', '2019-08-19 10:13:05', null, 'ac64a23b-8c72-4b77-bdb8-794159dad490', 'd4b354df-cd6a-4cd7-895a-cfce9773ad1a', 'expired');
INSERT INTO `account_and_task_experiments` VALUES ('8f0458a9-6deb-4b6f-b961-71dfcf090ddc', '2019-08-09 15:48:38', '2019-08-09 15:48:38', null, '2da7dcfc-629a-4550-9bd7-2d096d7d06a6', '5741127a-7692-44d3-828e-191946250606', 'submit');
INSERT INTO `account_and_task_experiments` VALUES ('a99bed04-674c-4f1c-b8b2-47f15ca21926', '2019-08-09 18:20:54', '2019-08-09 18:20:54', null, '256ea2d0-1091-46da-8e7f-de36ad3f45d7', 'e95c4439-06f2-4803-9b70-323f7b1e3593', 'submit');
INSERT INTO `account_and_task_experiments` VALUES ('ac427618-59d9-40a4-8b92-750a3792d2ea', '2019-08-19 10:13:05', '2019-08-19 10:13:05', null, '14a98659-4b61-4933-9eff-a0ba1eda3f8a', 'd4b354df-cd6a-4cd7-895a-cfce9773ad1a', 'expired');
INSERT INTO `account_and_task_experiments` VALUES ('bcf7c486-07ce-4987-a949-eaa7bf091b3d', '2019-08-09 11:35:55', '2019-08-09 11:35:55', null, 'f6e2d806-87a4-447f-b4e8-aec0c297e318', '953d5b88-1fd2-4fdd-bd08-390d35d2166d', 'expired');
INSERT INTO `account_and_task_experiments` VALUES ('cb75b313-221d-4f4c-b430-3c73d07f41df', '2019-08-07 09:37:02', '2019-08-07 09:37:02', null, 'ac64a23b-8c72-4b77-bdb8-794159dad490', '84e96d72-dcab-4bda-9ffb-caa3cd31f234', 'expired');
INSERT INTO `account_and_task_experiments` VALUES ('cbda97ab-e839-427c-a64b-dac3209da10e', '2019-08-09 11:35:55', '2019-08-09 11:35:55', null, 'ac64a23b-8c72-4b77-bdb8-794159dad490', '953d5b88-1fd2-4fdd-bd08-390d35d2166d', 'expired');
INSERT INTO `account_and_task_experiments` VALUES ('cc4ba2b4-21e0-4d86-905c-849b1f86c934', '2019-08-09 18:29:36', '2019-08-09 18:29:36', null, '256ea2d0-1091-46da-8e7f-de36ad3f45d7', 'c8674cc2-1383-41f1-9327-b8f50fe4b71a', 'new');
INSERT INTO `account_and_task_experiments` VALUES ('d04313c7-a3d3-4e6e-bd0f-380ae1336a22', '2019-08-09 18:20:54', '2019-08-09 18:20:54', null, '2da7dcfc-629a-4550-9bd7-2d096d7d06a6', 'e95c4439-06f2-4803-9b70-323f7b1e3593', 'expired');
INSERT INTO `account_and_task_experiments` VALUES ('d86cb891-8075-427e-b49b-e6571f563409', '2019-08-09 19:56:14', '2019-08-09 19:56:14', null, '256ea2d0-1091-46da-8e7f-de36ad3f45d7', '607a162c-162d-441d-ad08-3981f98df06b', 'expired');
INSERT INTO `account_and_task_experiments` VALUES ('dfb37405-7e4a-4819-90b7-4e005a58dd05', '2019-08-19 10:13:05', '2019-08-19 10:13:05', null, '2da7dcfc-629a-4550-9bd7-2d096d7d06a6', 'd4b354df-cd6a-4cd7-895a-cfce9773ad1a', 'expired');
INSERT INTO `account_and_task_experiments` VALUES ('ed44370b-23ed-4cd1-a964-33cca02ee442', '2019-08-09 11:35:55', '2019-08-09 11:35:55', null, '256ea2d0-1091-46da-8e7f-de36ad3f45d7', '953d5b88-1fd2-4fdd-bd08-390d35d2166d', 'expired');
INSERT INTO `account_and_task_experiments` VALUES ('f54a92b0-8d1c-4743-987b-149c0a2789c3', '2019-08-09 18:37:57', '2019-08-09 18:37:57', null, '2da7dcfc-629a-4550-9bd7-2d096d7d06a6', 'd738807c-29b2-4f95-a6fe-d29c86e47ded', 'submit');

-- ----------------------------
-- Table structure for chapter
-- ----------------------------
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter` (
  `id` varchar(36) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chapter
-- ----------------------------
INSERT INTO `chapter` VALUES ('0057331d-41a1-4a23-885e-819882f92639', '2019-08-05 10:33:24', '2019-06-15 17:23:56', null, '变压器', '3');
INSERT INTO `chapter` VALUES ('02843fa4-031e-4276-9830-cd685c4ad5d0', '2019-06-18 10:14:09', '2019-06-18 09:56:04', '2019-06-18 10:14:09', '第四章', '1');
INSERT INTO `chapter` VALUES ('02da0423-23f1-43cd-b72e-e12ae400c031', '2019-06-18 10:14:11', '2019-06-18 10:01:25', '2019-06-18 10:14:11', '第五章', '1');
INSERT INTO `chapter` VALUES ('06466da9-26b9-4220-9192-2d88e3173dab', '2019-06-10 11:52:08', '2019-06-10 09:54:11', '2019-06-10 11:52:08', '第六章', '4');
INSERT INTO `chapter` VALUES ('0b2b3028-5c84-41d0-af7f-57c2cb127e86', '2019-06-09 10:05:32', '2019-06-06 10:47:00', '2019-06-09 10:05:32', '章名称', '4');
INSERT INTO `chapter` VALUES ('0d1aa77e-2255-4216-bd7e-2bd409c6d500', '2019-07-22 16:43:32', '2019-07-22 16:43:24', '2019-07-22 16:43:32', '测试嗯嗯', '1');
INSERT INTO `chapter` VALUES ('1223ed80-c0cb-4e6d-95b5-879c5d09e7d6', '2019-06-18 10:14:02', '2019-06-18 09:55:24', '2019-06-18 10:14:02', '第三章', '1');
INSERT INTO `chapter` VALUES ('1273a2e6-f502-4ec9-95a2-5787f69ea4f9', '2019-06-09 17:36:11', '2019-06-09 17:32:12', '2019-06-09 17:36:11', '第二点五章', '3');
INSERT INTO `chapter` VALUES ('150d8a85-4ca5-4b3b-b50d-ae33ef082a3c', '2019-08-05 10:33:24', '2019-06-15 17:22:26', null, '直流电机及其拖动控制', '2');
INSERT INTO `chapter` VALUES ('1abe3279-bb81-4a04-b468-b328ca9dc5d8', '2019-06-16 14:18:45', '2019-06-16 14:17:17', '2019-06-16 14:18:45', '123', '9');
INSERT INTO `chapter` VALUES ('1c1f2190-8536-487f-af0c-9066d4be9991', '2019-06-17 16:15:44', '2019-06-17 16:15:41', '2019-06-17 16:15:44', '.kjh', '1');
INSERT INTO `chapter` VALUES ('2bed9c3d-ae8d-4d5b-95b2-ce2faff46bed', '2019-06-09 17:29:33', '2019-06-09 15:09:35', '2019-06-09 17:29:33', '第四章', '7');
INSERT INTO `chapter` VALUES ('2eaf3657-4ff9-4028-a760-217d12896634', '2019-08-06 15:57:10', '2019-08-06 15:57:10', null, '电力拖动系统的基础', '1');
INSERT INTO `chapter` VALUES ('3237c076-c2e5-4b04-b607-047630216c24', '2019-06-06 11:26:05', '2019-06-06 11:24:58', '2019-06-06 11:26:05', '章名称', '4');
INSERT INTO `chapter` VALUES ('3b2717a0-220c-49ac-9783-33ce31b1ce94', '2019-06-11 11:42:44', '2019-06-11 11:42:41', '2019-06-11 11:42:44', '第一章uuuuu', '1');
INSERT INTO `chapter` VALUES ('3e212bee-8b5a-4839-9d26-93d0d42926e8', '2019-08-05 10:33:24', '2019-06-15 17:26:41', null, '电气控制系统的设计', '8');
INSERT INTO `chapter` VALUES ('44e01d15-f67f-4ffc-9d51-bf03f8bc3f74', '2019-08-04 09:47:35', '2019-08-04 09:47:17', '2019-08-04 09:47:35', '1', '1');
INSERT INTO `chapter` VALUES ('4dd86b8a-e913-46be-8712-f4c02e8c8fa5', '2019-08-05 10:33:24', '2019-06-15 17:26:36', null, '典型生产机械的电气控制线路分析', '7');
INSERT INTO `chapter` VALUES ('4ee6d0d4-3b36-4579-bb70-bf2663deaf47', '2019-08-04 09:43:42', '2019-08-04 09:43:09', '2019-08-04 09:43:42', '1', '1');
INSERT INTO `chapter` VALUES ('5149652b-4791-46ed-9403-d550a69885c2', '2019-06-10 11:52:04', '2019-06-09 17:28:45', '2019-06-10 11:52:04', '第三章', '2');
INSERT INTO `chapter` VALUES ('539bcb2a-a949-4f27-9d42-6d7ebffcc7ec', '2019-08-04 09:44:25', '2019-08-04 09:43:59', '2019-08-04 09:44:25', '1', '1');
INSERT INTO `chapter` VALUES ('550004ce-c57e-4659-8be3-ca7b5c72d628', '2019-06-09 17:31:10', '2019-06-09 17:31:06', '2019-06-09 17:31:10', 'aa', '1');
INSERT INTO `chapter` VALUES ('617c52a5-9de8-4f85-8bd9-07e949837dda', '2019-08-05 10:33:24', '2019-06-15 17:25:35', null, '交流电动机', '4');
INSERT INTO `chapter` VALUES ('628c77dd-43f6-4d80-9a20-2c71f637701d', '2019-06-15 17:19:53', '2019-06-15 14:35:59', '2019-06-15 17:19:53', '实验2', '1');
INSERT INTO `chapter` VALUES ('63ccbe77-d93a-41c3-a121-d4b680546b92', '2019-06-09 17:29:38', '2019-06-09 15:20:52', '2019-06-09 17:29:38', '第五章', '5');
INSERT INTO `chapter` VALUES ('68ed2f63-96a9-402e-9065-dc4ff1ead3fb', '2019-06-09 17:30:00', '2019-06-09 17:29:57', '2019-06-09 17:30:00', '第四章', '3');
INSERT INTO `chapter` VALUES ('6e3e3e29-6bba-42fd-b905-3ccff18aeb62', '2019-06-18 09:29:21', '2019-06-18 09:04:09', '2019-06-18 09:29:21', '第一章', '1');
INSERT INTO `chapter` VALUES ('73a4bb1f-4967-4985-9453-daa2fd60d5c6', '2019-06-18 11:34:37', '2019-06-18 10:58:56', '2019-06-18 11:34:37', '第一章', '1');
INSERT INTO `chapter` VALUES ('73b92dd4-e173-4710-b734-c212d8babde4', '2019-06-09 10:05:34', '2019-06-06 10:46:40', '2019-06-09 10:05:34', '章名称', '4');
INSERT INTO `chapter` VALUES ('7b1bd342-bdac-46d7-8863-763892aafd4c', '2019-06-16 14:17:23', '2019-06-16 14:17:05', '2019-06-16 14:17:23', 'ceshi', '8');
INSERT INTO `chapter` VALUES ('7e472dfd-4e08-41c2-8d34-7e241ef3b232', '2019-06-17 14:48:16', '2019-06-17 14:48:10', '2019-06-17 14:48:16', '111', '1');
INSERT INTO `chapter` VALUES ('8412e7a1-c65c-4101-a813-78cdf5e1e846', '2019-06-10 11:52:10', '2019-06-09 17:37:48', '2019-06-10 11:52:10', '第五章', '3');
INSERT INTO `chapter` VALUES ('8e6e9993-6b1f-4070-8bf5-c71efadcefcd', '2019-06-09 17:29:40', '2019-06-09 15:24:42', '2019-06-09 17:29:40', '第六章', '4');
INSERT INTO `chapter` VALUES ('92f4d959-1115-478a-9a05-98f3d3ddb53e', '2019-06-09 17:29:35', '2019-06-09 17:29:04', '2019-06-09 17:29:35', '第七章', '6');
INSERT INTO `chapter` VALUES ('9717d920-69df-4abe-81e1-0dbdd5c53a08', '2019-08-04 09:45:42', '2019-08-04 09:45:37', '2019-08-04 09:45:42', '1', '1');
INSERT INTO `chapter` VALUES ('97ce6e66-fe67-4e04-9431-bb4ade63c141', '2019-06-19 16:11:36', '2019-06-19 16:11:32', '2019-06-19 16:11:36', '第二章', '1');
INSERT INTO `chapter` VALUES ('97d7eab4-43ae-475e-a24f-42971c796ec2', '2019-08-05 10:33:24', '2019-08-04 09:48:18', '2019-08-05 10:33:24', '1', '1');
INSERT INTO `chapter` VALUES ('996562a2-ca11-4428-b7a4-0923f75167be', '2019-06-10 11:52:02', '2019-06-09 11:12:58', '2019-06-10 11:52:02', '第二章', '2');
INSERT INTO `chapter` VALUES ('9cf30779-f849-40fe-ac1e-181e4b4b2c9d', '2019-06-18 09:29:24', '2019-06-18 09:17:24', '2019-06-18 09:29:24', '第二章', '1');
INSERT INTO `chapter` VALUES ('a06306a2-57db-459c-a685-acf81f31808d', '2019-08-01 10:42:29', '2019-08-01 10:39:13', '2019-08-01 10:42:29', '111', '1');
INSERT INTO `chapter` VALUES ('a8eb04df-ae26-4f57-8d9a-7c8c38aba2fe', '2019-06-09 18:08:15', '2019-06-09 17:36:28', '2019-06-09 18:08:15', '第一章', '1');
INSERT INTO `chapter` VALUES ('b23b1ae8-aa2e-47ac-820e-a5949e0d63e2', '2019-08-06 16:36:21', '2019-08-06 16:35:01', '2019-08-06 16:36:21', '111', '9');
INSERT INTO `chapter` VALUES ('bad58668-c309-4f8d-bcd9-fc068b68fff4', '2019-06-18 10:14:06', '2019-06-18 09:50:54', '2019-06-18 10:14:06', '第二章', '1');
INSERT INTO `chapter` VALUES ('bd5466fc-4cea-4c07-89a1-f3f1bd89d875', '2019-06-18 11:34:39', '2019-06-18 11:05:01', '2019-06-18 11:34:39', '第二章', '1');
INSERT INTO `chapter` VALUES ('c6459f02-a9b8-4385-9afe-9c6bfb20a443', '2019-06-09 15:26:01', '2019-06-09 15:08:08', '2019-06-09 15:26:01', '第三章', '7');
INSERT INTO `chapter` VALUES ('d1a1e915-d47c-40b0-a9c9-9bd52b8ce3d6', '2019-06-17 16:16:00', '2019-06-17 16:15:55', '2019-06-17 16:16:00', 'yuj', '1');
INSERT INTO `chapter` VALUES ('d933914d-8c02-4ac8-a33f-3c7aa4258660', '2019-06-09 10:10:23', '2019-06-04 15:07:56', '2019-06-09 10:10:23', '第三章 chapterIII', '3');
INSERT INTO `chapter` VALUES ('dc85ae93-4fb7-4a1f-9259-48a06fe68930', '2019-06-18 10:14:04', '2019-06-18 09:49:27', '2019-06-18 10:14:04', '第一章', '1');
INSERT INTO `chapter` VALUES ('eefdcebd-bc2a-428b-968f-c87ec9e8c6a4', '2019-08-05 10:33:24', '2019-06-15 17:25:51', null, '三相异步电动机的拖动与控制', '5');
INSERT INTO `chapter` VALUES ('f4df4f5c-448a-4607-acb4-c4ed22ffadbd', '2019-08-05 10:33:24', '2019-06-15 17:26:30', null, '控制电机', '6');

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
INSERT INTO `component` VALUES ('14600d3f-28f8-4dc3-a679-ce4c5abc4863', '2019-06-14 11:31:58', '2019-07-15 14:42:24', null, '交流接触器KM2', 'a796bedc-aae0-441e-963a-083ca469a603', '三相交流接触器，它应用于电力、配电与用电场合。接触器广义上是指工业电中利用线圈流过电流产生磁场，使触头闭合，以达到控制负载的电器。', '线圈额定电压：380V\n主触头额定电压：380V\n此接触器模型有三种故障可供设置，分别为： 线圈断路故障、常开触点短路故障、主触头三相接地故障', 'component_schematic/a487dd9e-bb92-4f6e-8dce-f3e04da4d785JieChuQiYLT.png', 'SanXiangJiaoLiuJieChuQiKM2', '交流接触器KM2', '', 'component_icon/273dd65a-9539-48c0-9f49-ea0c2da80a81JieChuQi.png', '西门子');
INSERT INTO `component` VALUES ('289e196a-5623-483b-93fe-4333028aedc2', '2019-06-12 11:58:26', '2019-08-16 15:33:38', null, '3P空气开关50A', '4b6682db-a980-4677-874a-22483831429e', '空气开关，又名空气断路器，是断路器的一种。是一种只要电路中电流超过额定电流就会自动断开的开关。空气开关是低压配电网络和电力拖动系统中非常重要的一种电器，它集控制和多种保护功能于一身。\n       除能完成接触和分断电路外，尚能对电路或电气设备发生的短路、严重过载及欠电压等进行保护，同时也可以用于不频繁地启动电动机。', '额定电压：380V 额定电流：40A 动作电流：50A', 'component_schematic/59cff1b4-cc83-41d0-8ea5-1ecab5760189KongQiKaiGuan3PYLT.png', '送达', '3P空气开关50A', '', 'component_icon/63c342bf-a486-4b84-ac10-bddf0d0e53a6KongQiKaiGuan3P.png', '西门子');
INSERT INTO `component` VALUES ('45fee2e7-7e52-496f-aa3c-f1d931b2b327', '2019-06-12 11:52:06', '2019-07-15 14:42:25', null, '三相交流接触器/18A', 'a796bedc-aae0-441e-963a-083ca469a603', '三相交流接触器，它应用于电力、配电与用电场合。接触器广义上是指工业电中利用线圈流过电流产生磁场，使触头闭合，以达到控制负载的电器。', '线圈额定电压：380V\n主触头额定电压：380V\n发热电流：15A', 'component_schematic/c4cb2066-e40a-4d03-8887-2ff8821593f1JieChuQiYLT.png', 'SanXiangJiaoLiuJieChuQi18A', '三相交流接触器18A', '', 'component_icon/d01a4770-ae7a-4ea1-b8dc-3be3897fec36JieChuQi.png', '西门子');
INSERT INTO `component` VALUES ('4d5e6a16-10f4-49a2-bd9c-d781bc571f4a', '2019-06-12 11:51:26', '2019-07-15 14:42:26', null, '三相交流接触器', 'a796bedc-aae0-441e-963a-083ca469a603', '三相交流接触器，它应用于电力、配电与用电场合。接触器广义上是指工业电中利用线圈流过电流产生磁场，使触头闭合，以达到控制负载的电器。', '线圈额定电压：380V\r\n主触头额定电压：380V\r\n额定电流：40A', 'component_schematic/25f6c6b6-8b55-4975-8d2f-4b6ef8380d4bJieChuQiYLT.png', 'SanXiangJiaoLiuJieChuQi', '三相交流接触器', '', 'component_icon/e239862d-e72a-49ac-a1fc-771b63eb108eJieChuQi.png', '西门子');
INSERT INTO `component` VALUES ('5040b87c-f41f-44c0-b859-cb54b4b61df4', '2019-06-12 12:01:55', '2019-08-16 11:10:27', null, '熔断器（3P）', '4b6682db-a980-4677-874a-22483831429e', '熔断器（fuse）是指当电流超过规定值时，以本身产生的热量使熔体熔断，断开电路的一种电器。熔断器是根据电流超过规定值一段时间后，以其自身产生的热量使熔体熔化，从而使电路断开；运用这种原理制成的一种电流保护器。熔断器广泛应用于高低压配电系统和控制系统以及用电设备中，作为短路和过电流的保护器，是应用最普遍的保护器件之一。', '额定电压：380V \n额定电流：可设置 ', 'component_schematic/9cc11866-1d3a-4b50-b2cb-a3086a32949aRongDuanQi3YLT.png', '', '熔断器（3P）', '', 'component_icon/e9613ca6-3a0c-41f9-98d1-91a783c90912RongDuanQi3.png', '西门子');
INSERT INTO `component` VALUES ('6c129751-7100-4fbd-9c9e-b02688286e84', '2019-06-12 11:59:14', '2019-07-15 14:42:31', null, '热继电器', '4b6682db-a980-4677-874a-22483831429e', '热继电器的工作原理是电流入热元件的电流产生热量，使有不同膨胀系数的双金属片发生形变，当形变达到一定距离时，就推动连杆动作，使控制电路断开，从而使接触器失电，主电路断开，实现电动机的过载保护。', '额定电压：380V\n设定范围：5~10A', 'component_schematic/d639707a-4362-4058-a37f-231c5e277659ReJiDianQiYLT.png', 'ReJiDianQi', '热继电器', '', 'component_icon/12b728be-8e6a-4fe3-9b45-e44c3a84280bReJiDianQi.png', '西门子');
INSERT INTO `component` VALUES ('8ea57f9e-da79-4e6d-99aa-2400a2e2676c', '2019-06-12 11:57:47', '2019-08-21 17:51:16', null, '3P空气开关', '4b6682db-a980-4677-874a-22483831429e', '空气开关，又名空气断路器，是断路器的一种。是一种只要电路中电流超过额定电流就会自动断开的开关。空气开关是低压配电网络和电力拖动系统中非常重要的一种电器，它集控制和多种保护功能于一身。除能完成接触和分断电路外，尚能对电路或电气设备发生的短路、严重过载及欠电压等进行保护，同时也可以用于不频繁地启动电动机。', '额定电压：380V\n额定电流：40A', 'component_schematic/f63f36f6-9293-4bc3-8110-e68400dfa4d9KongQiKaiGuan3PYLT.png', '盛世嫡妃', '3P空气开关', '', 'component_icon/f6d32f06-8ba7-44ac-8f01-016687e399c4KongQiKaiGuan3P.png', '西门子');
INSERT INTO `component` VALUES ('95a30d95-91d1-4ae9-83dc-e08482ccd00e', '2019-06-12 12:00:40', '2019-08-16 11:18:28', null, '自保持按钮', '4b6682db-a980-4677-874a-22483831429e', '自保持按钮开关是一种按下即动作，释放不复位的用来接通和分断小电流电路的电器。一般用于交直流电压440V以下，电流小于5A的控制电路中，一般不直接操纵主电路，也可以用于互联电路中。', '额定电压：380V\n额定电流：5A', 'component_schematic/d1e91e8b-139b-4b8f-85df-9ffa06f15aafZiBaoChiAnNiuYLT.png', '', '自保持按钮', '', 'component_icon/49a1d34b-35f0-4f79-acd3-8db04b195e7fZiBaoChiAnNiu.png', '西门子');
INSERT INTO `component` VALUES ('9db8d612-a4e2-4cd4-87f4-276870215c52', '2019-06-12 12:00:01', '2019-07-15 14:42:31', null, '脉冲按钮', '4b6682db-a980-4677-874a-22483831429e', '脉冲按钮开关是一种按下即动作，释放即复位的用来接通和分断小电流电路的电器。一般用于交直流电压440V以下，电流小于5A的控制电路中，一般不直接操纵主电路，也可以用于互联电路中。', '额定电压：380V\n额定电流：5A', 'component_schematic/665170b9-12fe-4e55-8f44-4be694767ba6MaiChongAnNiuYLT.png', 'MaiCongAnNiu', '脉冲按钮', '', 'component_icon/718237ae-7905-407f-95c9-994fa5200f9fMaiChongAnNiu.png', '西门子');
INSERT INTO `component` VALUES ('9ea20392-8985-4152-9534-1d220e5296bb', '2019-06-14 11:25:56', '2019-08-16 11:20:12', null, '电压表', '7fc19d4b-1bc6-4c8d-b419-5a14b82f9bd3', '数字电压表（DigitalVoltmeter）简称DVM，它是采用数字化测量技术，把连续的模拟量转换成不连续、离散的数字形式并加以显示的仪表。', '量程：0~1000V', 'component_schematic/431e2141-4046-49be-8fc0-71c100dfe0e7DianYaBiaoYLT.png', '', '电压表', '', 'component_icon/4f1713d2-397e-4803-8048-1f678115ba06DianYaBiao.png', '西门子');
INSERT INTO `component` VALUES ('b5d0f148-ee9c-4654-9a7e-7d482005dbf2', '2019-06-14 11:33:33', '2019-08-16 11:03:35', null, '常闭按钮', '4b6682db-a980-4677-874a-22483831429e', '常闭按钮开关是一种按下即断开，释放不复位的用来接通和分断小电流电路的电器。一般用于交直流电压440V以下，电流小于5A的控制电路中，一般不直接操纵主电路，也可以用于互联电路中。', '额定电压：380V\n额定电流：5A', 'component_schematic/5bca8dc3-b4ff-4c99-879d-cd02b10b5121ChangBiAnNiuYLT.png', '', '常闭按钮', '', 'component_icon/4bb9a609-402f-4b58-8b5a-f42486bf3456ChangBiAnNiu.png', '西门子');
INSERT INTO `component` VALUES ('bb8f3ac0-b4d2-465d-a577-2041e4f2d385', '2019-06-12 11:49:45', '2019-07-15 14:42:31', null, '三相异步电动机', '8a219432-3dae-4e90-b368-128b6b275d76', '三相异步电机（Triple-phase asynchronous motor）是感应电动机的一种，是靠同时接入380V三相交流电流（相位差120度）供电的一类电动机，由于三相异步电动机的转子与定子旋转磁场以相同的方向、不同的转速成旋转，存在转差率，所以叫三相异步电动机。三相异步电动机转子的转速低于旋转磁场的转速，转子绕组因与磁场间存在着相对运动而产生电动势和电流，并与磁场相互作用产生电磁转矩，实现能量变换。', '额定电压：380V； 功率因数：0.8； 额定功率：7.1', 'component_schematic/e8442c87-cfc4-4735-a95b-6c5783e58da4SanXiangYiBuDianDongJiYLT.png', 'SanXiangYiBuDianDongJi', '三相异步电动机', '', 'component_icon/6c5cb76c-76c2-4744-99e3-41ea364fa5a6SanXiangYiBuDianDongJi.png', '西门子');
INSERT INTO `component` VALUES ('cb9facb2-b6bd-4bb1-8d9f-b5402b26875b', '2019-06-12 11:44:36', '2019-08-23 14:08:52', null, '交流三相电源端子排', '7d796865-c1e8-44af-b6a6-ee7672f9882c', '三相交流电源端子排包含三个接线端子，分别对应ABC三相电源线，为负载提供三相380V\n\n\n', '电压：380V', 'component_schematic/1279e394-5661-4b21-a23a-1226f87f11d7SanXiangJiaoLiuDianYuanYLT.png', '', '端子排', '', 'component_icon/07a13284-217a-47f2-a5d6-5dde6ffb4e74SanXiangJiaoLiuDianYuan.png', '西门子');
INSERT INTO `component` VALUES ('ccda93ee-9e34-4be7-b698-a9a319b16c1c', '2019-06-14 11:28:24', '2019-08-23 14:08:52', null, '三相异步电动机37kW', '8a219432-3dae-4e90-b368-128b6b275d76', '三相异步电机（Triple-phase asynchronous motor）是感应电动机的一种，是靠同时接入380V三相交流电流（相位差120度）供电的一类电动机，由于三相异步电动机的转子与定子旋转磁场以相同的方向、不同的转速成旋转，存在转差率，所以叫三相异步电动机。三相异步电动机转子的转速低于旋转磁场的转速，转子绕组因与磁场间存在着相对运动而产生电动势和电流，并与磁场相互作用产生电磁转矩，实现能量变换。', '额定电压：380V\n功率因数：0.8\n额定功率：37kW', 'component_schematic/3c12afdd-b9b7-4305-8885-fba7b2c48678SanXiangYiBuDianDongJiYLT.png', 'SanXiangYiBuDianDongJi2', '三相异步电动机37KW', '', 'component_icon/4063afe6-07bc-4ae0-a077-b48555eb2eb7SanXiangYiBuDianDongJi.png', '西门子');
INSERT INTO `component` VALUES ('d7a1b10b-b5c9-4837-ac19-6967abee932a', '2019-06-12 11:56:37', '2019-08-23 14:08:52', null, '通电延时继电器', 'a796bedc-aae0-441e-963a-083ca469a603', '延时继电器主要用于直流或交流操作的各种保护和自动控制线路中，作为辅助继电器，以增加触点数量和触点容量。可根据需要自由调节延时的时间。 通电延时继电器的线圈缓吸类型继电器线圈，可实现线圈通电后触点延时动作。', '额定电压：380V\n额定电流：5A\n延时范围0.1s~0.9s', 'component_schematic/107a2581-8569-4771-9356-585ddd03f509DongDianYanShiJiDianQiYLT.png', 'TongDianYanShiJiDianQi', '通电延时继电器', '', 'component_icon/ad39ab56-07b1-4b2e-bf67-ce2cb644e7e2DongDianYanShiJiDianQi.png', '西门子');
INSERT INTO `component` VALUES ('dffb00d1-1742-4afb-9577-730a63027097', '2019-06-14 11:25:02', '2019-08-23 14:08:52', null, '电流表', '7fc19d4b-1bc6-4c8d-b419-5a14b82f9bd3', '数字电流表AMP，它是采用数字化测量技术，把连续的模拟量转换成不连续、离散的数字形式并加以显示的仪表。', '量程0~1000A', 'component_schematic/1d97fde7-8846-4022-9d76-67cacad9ec18DianLiuBiaoYLT.png', 'DianLiuBiao', '电流表', '', 'component_icon/56386cb7-79ff-4c67-b316-48c8bfa285bdDianLiuBiao.png', '西门子');
INSERT INTO `component` VALUES ('e06d9e26-5381-48e9-89f3-7f4134c39a17', '2019-06-14 11:33:00', '2019-08-23 14:08:52', null, '常开按钮', '4b6682db-a980-4677-874a-22483831429e', '常开按钮开关是一种按下即导通，释放不复位的用来接通和分断小电流电路的电器。一般用于交直流电压440V以下，电流小于5A的控制电路中，一般不直接操纵主电路，也可以用于互联电路中。', '额定电压：380V\n额定电流：5A', 'component_schematic/20ac4eb7-b1b3-4d3c-a5c7-c1902c370b9eChangKaiAnNiuYLT.png', '他人同意', '常开按钮', '', 'component_icon/647fdecc-d5eb-4ebf-b7c5-8b1283558c10ChangKaiAnNiu.png', '西门子');
INSERT INTO `component` VALUES ('e69b2c69-decf-4f23-a449-d431602c9643', '2019-06-14 11:29:52', '2019-08-23 14:08:52', null, '电机端子排', '8a219432-3dae-4e90-b368-128b6b275d76', '端子排，意为承载多组相互绝缘的端子组件并用于固定支持件的绝缘部件。电机端子排的作用就是将电机内绕组和电源的线路相连接，起到信号（电流电压）传输的作用。有了端子排，使得接线美观，维护方便，在远距离线之间的联接时主要是牢靠，施工和维护方便。', '额定电压：380V；（需要在控制柜内选择电机端子排连接的电机）', 'component_schematic/6b2ea6af-6b57-4d5f-b637-5c63ae5cf1beDianJiDuanZiPaiYLT.png', 'DianJiDuanZiPai', '电机端子排', '', 'component_icon/ee0c11ce-9a8a-49dd-ab50-e358a9a61aedDianJiDuanZiPai.png', '西门子');
INSERT INTO `component` VALUES ('ee424b92-ecb6-40b5-b059-02f4670b8c39', '2019-06-12 12:01:35', '2019-08-23 14:08:52', null, '熔断器（2P）', '4b6682db-a980-4677-874a-22483831429e', '熔断器（fuse）是指当电流超过规定值时，以本身产生的热量使熔体熔断，断开电路的一种电器。熔断器是根据电流超过规定值一段时间后，以其自身产生的热量使熔体熔化，从而使电路断开；运用这种原理制成的一种电流保护器。熔断器广泛应用于高低压配电系统和控制系统以及用电设备中，作为短路和过电流的保护器，是应用最普遍的保护器件之一。', '额定电压：380V\n额定电流：可设置', 'component_schematic/1a3ff00e-7dbd-45e7-8d9a-a154cf6a6759RongDuanQiYLT.png', '', '熔断器（2P）', '', 'component_icon/2128d2b3-b1d8-409e-93d7-87fbb9fc4c73RongDuanQi.png', '西门子');
INSERT INTO `component` VALUES ('f3192ca6-8e41-455d-880f-e8a37db901a0', '2019-06-14 11:31:23', '2019-08-23 14:08:52', null, '交流接触器KM1', 'a796bedc-aae0-441e-963a-083ca469a603', '三相交流接触器，它应用于电力、配电与用电场合。接触器广义上是指工业电中利用线圈流过电流产生磁场，使触头闭合，以达到控制负载的电器。', '线圈额定电压：380V\n主触头额定电压：380V\n额定电流：此接触器可设置阈值电流，超过阈值电流主触头会过热', 'component_schematic/60feb046-1dac-4bef-b7cb-08e962e18e83JieChuQiYLT.png', 'SanXiangJiaoLiuJieChuQiKM1', '交流接触器KM1', '', 'component_icon/99332b1b-e1d6-4c08-b889-b49d6e4943a2JieChuQi.png', '西门子');

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
INSERT INTO `component_group` VALUES ('1e82674c-98c6-42a7-8a3a-850610b291d8', '2019-08-15 16:47:40', '2019-08-15 16:47:40', '2019-08-15 17:33:38', '1231321', null);
INSERT INTO `component_group` VALUES ('3f24562e-82a6-479a-8157-6197a66c1e4c', '2019-08-15 14:28:49', '2019-08-15 14:28:49', '2019-08-15 16:02:37', '12333', null);
INSERT INTO `component_group` VALUES ('4b6682db-a980-4677-874a-22483831429e', '2019-06-11 17:50:44', '2019-06-11 17:50:44', null, '开关及保护元件', '\r\nSwitch and protection component');
INSERT INTO `component_group` VALUES ('54791415-62b7-4c64-8b65-361b165f3e3e', '2019-08-16 09:44:54', '2019-08-16 09:44:54', '2019-08-16 09:48:20', 'demo', null);
INSERT INTO `component_group` VALUES ('7d796865-c1e8-44af-b6a6-ee7672f9882c', '2019-06-11 17:50:07', '2019-06-11 17:50:07', null, '电源元件', '\r\nPower supply component');
INSERT INTO `component_group` VALUES ('7fc19d4b-1bc6-4c8d-b419-5a14b82f9bd3', '2019-06-14 11:22:37', '2019-06-14 11:22:37', null, '工具', 'Tool');
INSERT INTO `component_group` VALUES ('8a219432-3dae-4e90-b368-128b6b275d76', '2019-06-12 11:29:00', '2019-06-12 11:29:00', null, '电机元件', 'Motor component');
INSERT INTO `component_group` VALUES ('8bec327d-1f2b-4832-ade4-052391983ddd', '2019-08-15 15:00:27', '2019-08-15 15:00:27', '2019-08-15 15:01:10', '4654656', null);
INSERT INTO `component_group` VALUES ('a526236f-1725-4dae-b2f7-97fc31aa17b1', '2019-08-16 09:39:00', '2019-08-16 09:39:00', '2019-08-16 09:44:41', 'demo', null);
INSERT INTO `component_group` VALUES ('a796bedc-aae0-441e-963a-083ca469a603', '2019-06-11 17:49:01', '2019-06-11 17:49:01', null, '接触器及继电器元件', 'Contactor and relay components');
INSERT INTO `component_group` VALUES ('c073ac6f-7178-49c1-8070-b551e038931b', '2019-08-15 14:24:32', '2019-08-15 14:24:32', '2019-08-15 14:28:01', '132', null);

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
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `id` varchar(36) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `path` varchar(128) DEFAULT NULL,
  `type_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES ('022f7b37-91a1-11e9-a44d-7085c206b232', '2019-08-12 11:53:14', '2019-08-12 11:53:14', null, '第14章－自整角机.ppt', 'material/2e3be0ff-a85c-4e69-bfd5-ac90094311be.ppt', null);
INSERT INTO `material` VALUES ('02de0251-91a1-11e9-a44d-7085c206b232', '2019-08-10 14:04:05', '2019-06-18 16:13:53', null, '第03章－变压器.ppt', 'material/76e5ff4e-1c2f-4f8b-920e-52cd47d39c01.ppt', null);
INSERT INTO `material` VALUES ('04cd7cbd-91a1-11e9-a44d-7085c206b232', '2019-08-10 14:07:22', '2019-06-18 16:13:56', null, '第11章－同步电动机和同步调相机.ppt', 'material/8a344373-0a56-4d0d-aec9-7a9b94b9c838.ppt', null);
INSERT INTO `material` VALUES ('0559d6af-91a1-11e9-a44d-7085c206b232', '2019-08-10 16:34:03', '2019-07-04 17:50:08', null, '视屏11.mp4', 'material/14665422-2cbb-4d14-aaa4-a2d735fbd7a6.mp4', null);
INSERT INTO `material` VALUES ('059aa02a-91a1-11e9-a44d-7085c206b232', '2019-08-10 14:02:27', '2019-06-18 16:13:58', null, '第00章－绪论.ppt', 'material/04f9457a-6515-401f-9597-650f2242ac78.ppt', null);
INSERT INTO `material` VALUES ('05dee131-91a1-11e9-a44d-7085c206b232', '2019-08-10 14:07:42', '2019-06-18 16:13:58', null, '第12章－伺服电动机.ppt', 'material/99b60d20-2d3b-4e1b-b910-2ca47eb7ecf1.ppt', null);
INSERT INTO `material` VALUES ('061f9391-91a1-11e9-a44d-7085c206b232', '2019-08-10 14:06:23', '2019-06-18 16:13:58', null, '第10章－同步发电机.ppt', 'material/1a574cd1-4191-4610-8799-e6e9c80441eb.ppt', null);
INSERT INTO `material` VALUES ('06643e64-91a1-11e9-a44d-7085c206b232', '2019-08-10 14:05:27', '2019-06-18 16:13:59', null, '第08章－其它种类的感应电动机及感应电机新技术.ppt', 'material/e08d49ac-e80d-4c1a-badd-aa4aae5450c6.ppt', null);
INSERT INTO `material` VALUES ('06ef4b9a-91a1-11e9-a44d-7085c206b232', '2019-08-10 14:01:46', '2019-06-18 16:14:00', null, '电机与拖动 电机部分(01).wmv', 'material/5e825348-eafb-4249-9e6b-b89c5d48b28a.wmv', null);
INSERT INTO `material` VALUES ('07351132-91a1-11e9-a44d-7085c206b232', '2019-08-10 14:04:55', '2019-06-18 16:14:00', null, '第06章－三相感应电动机的运行原理.ppt', 'material/996c2a3e-d391-4147-8726-9d0562cc45fa.ppt', null);
INSERT INTO `material` VALUES ('077d57b6-91a1-11e9-a44d-7085c206b232', '2019-08-10 14:06:18', '2019-06-18 16:14:01', null, '第09章－同步电机的基本类型和基本结构.ppt', 'material/b8bef00b-a8e4-4852-84b8-8feb9ca60964.ppt', null);
INSERT INTO `material` VALUES ('07c50fa9-91a1-11e9-a44d-7085c206b232', '2019-08-10 14:03:26', '2019-06-18 16:14:01', null, '第02章－直流电动机的电力拖动.ppt', 'material/6c269ef6-e49c-4e0a-9fa3-d0298aa4270e.ppt', null);
INSERT INTO `material` VALUES ('080e232e-91a1-11e9-a44d-7085c206b232', '2019-08-10 14:07:46', '2019-06-18 16:14:02', null, '第13章－测速发电机.ppt', 'material/259994a3-1886-4a7e-b17a-17ff6ee1477c.ppt', null);
INSERT INTO `material` VALUES ('085b09dd-91a1-11e9-a44d-7085c206b232', '2019-08-10 14:05:23', '2019-06-18 16:14:02', null, '第07章－三相感应电动机的电力拖动.ppt', 'material/d7388a28-2866-4403-ae6a-8d97ee97cef5.ppt', null);
INSERT INTO `material` VALUES ('08a9334a-91a1-11e9-a44d-7085c206b232', '2019-08-10 14:04:24', '2019-06-18 16:14:03', null, '第05章－三相感应电动机的基本原理.ppt', 'material/2ead3069-d1d2-46ca-8169-3b66a12bc57f.ppt', null);
INSERT INTO `material` VALUES ('08f5fcdf-91a1-11e9-a44d-7085c206b232', '2019-08-10 14:19:37', '2019-06-18 16:14:03', null, '第16章－步进电动机.ppt', 'material/5b254f85-068d-44bc-95c7-3135bd03e888.ppt', null);
INSERT INTO `material` VALUES ('0dc0c7c7-f68b-4a61-87af-8564cd6436b7', '2019-08-05 15:28:34', '2019-08-05 15:28:34', null, 'chrome.exe', 'material/80bba19f-8127-4af5-bc69-1b1a06eda379.exe', null);
INSERT INTO `material` VALUES ('28efca43-f8de-4171-8be9-f36f63cd5303', '2019-08-06 15:28:08', '2019-08-06 15:28:08', null, '实验七：异步电动机联锁正反转控制.pdf', 'material/2bae57cf-c04c-463a-94fa-2ad2ed54d555.pdf', null);
INSERT INTO `material` VALUES ('4a18bb9b-bfb8-410e-8bdc-c34d1019dbf1', '2019-08-06 15:27:35', '2019-08-06 15:27:35', null, '实验六：异步电机两地控制.docx', 'material/6215eabc-0f06-40b3-a55e-ae7d81111b0e.docx', null);
INSERT INTO `material` VALUES ('521ea7f5-273c-4ad4-a5b5-d8bfd6cd1202', '2019-08-06 15:28:32', '2019-08-06 15:28:32', null, '实验一指导书：异步电动机手动单向运转控制.docx', 'material/0b4032df-44f1-4491-9912-7ab8fb5dae0c.docx', null);
INSERT INTO `material` VALUES ('63e94133-8a4a-4318-af32-2bbebdaccfa5', '2019-07-19 11:37:42', '2019-07-19 11:37:42', null, '电机拖动与控制介绍.docx', 'material/864757a5-be09-48b0-ac85-e8615853e823.docx', null);
INSERT INTO `material` VALUES ('663cfbb3-b757-4d15-986e-b7660f668b03', '2019-08-06 15:27:56', '2019-08-06 15:27:56', null, '实验五：.异步电动机单向点动启动控制.docx', 'material/6a5cecc3-a040-422f-a13a-9054f50c4836.docx', null);
INSERT INTO `material` VALUES ('6e4c2292-d41f-4fab-97ea-f221375e00d3', '2019-08-06 16:36:00', '2019-08-06 16:36:00', null, '任务.md', 'material/40d1580a-a164-4bcd-9210-df38cdc6885e.md', null);
INSERT INTO `material` VALUES ('6ea67b3b-47d4-4b20-be59-0b65a777577a', '2019-08-05 15:29:12', '2019-08-05 15:29:12', null, 'winhttp.dll', 'material/e5b19aad-c40d-4a21-827c-e830b8d4c15f.dll', null);
INSERT INTO `material` VALUES ('7422dd96-cfbb-4ae1-aea9-0ed09c2f7695', '2019-08-06 16:23:36', '2019-08-06 16:23:36', null, '技术需求.txt', 'material/f219de05-6fd8-40aa-8907-15d3573e4e70.txt', null);
INSERT INTO `material` VALUES ('81b6a638-4de4-436e-8d64-b278e3e92960', '2019-08-06 15:27:52', '2019-08-06 15:27:52', null, '实验五：.异步电动机单向点动启动控制.pdf', 'material/dd264846-3dec-4a6b-b890-5e121bfe73c7.pdf', null);
INSERT INTO `material` VALUES ('8be9e6ef-9045-4898-97b5-237749e6d882', '2019-08-06 15:27:39', '2019-08-06 15:27:39', null, '实验六：异步电机两地控制指导书.pdf', 'material/8faceee1-cda3-4420-b85d-e21c28163430.pdf', null);
INSERT INTO `material` VALUES ('901b10a5-c276-462b-9cf5-80f28965e42a', '2019-08-12 11:36:33', '2019-08-06 16:23:28', '2019-08-12 11:36:33', 'eeee.slx', 'material/5bf4230d-afa3-4af7-9c24-c1c3c2f5c616.slx', null);
INSERT INTO `material` VALUES ('a98a41e1-dad4-40a3-a74b-4fb3e989769d', '2019-08-12 11:36:33', '2019-08-05 15:29:03', '2019-08-12 11:36:33', 'GreenChrome.ini', 'material/e6d15889-9fa7-4d07-aaed-769506cfc6c2.ini', null);
INSERT INTO `material` VALUES ('afae24b4-ac66-4d3c-954a-f0313017f770', '2019-08-05 15:30:04', '2019-08-05 15:30:04', null, '微信图片_20190726143215.jpg', 'material/f220580b-0f3e-417d-b477-788ad2f45abe.jpg', null);
INSERT INTO `material` VALUES ('b4282744-3d59-43f8-af7f-50832c4212bf', '2019-08-06 15:28:29', '2019-08-06 15:28:29', null, '实验一指导书：异步电动机手动单向运转控制.pdf', 'material/c9f56824-abaf-411e-9b56-da604183941f.pdf', null);
INSERT INTO `material` VALUES ('c3a48b17-e8c8-4d9b-8245-71ade9540e70', '2019-08-10 15:05:15', '2019-08-10 15:05:15', null, '登录页面.psd', 'material/424c06c3-d7fc-4b53-b42c-7c1973bca7a8.psd', null);
INSERT INTO `material` VALUES ('d49e7850-ed31-4794-9dd4-a817837b125a', '2019-08-06 15:28:12', '2019-08-06 15:28:12', null, '实验七：异步电动机联锁正反转控制.docx', 'material/ae3508a5-9b45-4ebc-a8ac-1daa249e6142.docx', null);
INSERT INTO `material` VALUES ('f6536326-1966-42f1-a7a0-cc14f565a53d', '2019-08-05 15:28:12', '2019-08-05 15:28:12', null, '微信图片_20190801134506.jpg', 'material/3a8435e6-bc05-45b5-9ee8-dd29d0184976.jpg', null);

-- ----------------------------
-- Table structure for material_and_chapter
-- ----------------------------
DROP TABLE IF EXISTS `material_and_chapter`;
CREATE TABLE `material_and_chapter` (
  `id` varchar(36) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `material_id` varchar(36) DEFAULT NULL,
  `chapter_id` varchar(36) DEFAULT NULL,
  `unit_id` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of material_and_chapter
-- ----------------------------
INSERT INTO `material_and_chapter` VALUES ('72b66c54-9aab-4409-8a7a-97f12d0573da', '2019-06-05 15:11:15', '2019-06-19 13:39:38', null, '048a5fd9-91a1-11e9-a44d-7085c206b232', '617c52a5-9de8-4f85-8bd9-07e949837dda', 'bb4b78af-e041-40c9-8034-4f2b11b5c5cc');
INSERT INTO `material_and_chapter` VALUES ('4618b8b7-a4f7-4bbd-8c8f-99523818baaf', '2019-06-10 20:00:21', '2019-07-30 13:19:02', null, '022f7b37-91a1-11e9-a44d-7085c206b232', '150d8a85-4ca5-4b3b-b50d-ae33ef082a3c', '0012ec60-e79e-410b-bea8-981bcfc6d415');
INSERT INTO `material_and_chapter` VALUES ('edd6167f-7cea-4c6a-8ea4-f0bf91e3156d', '2019-06-10 20:07:08', '2019-07-30 12:52:57', '2019-08-01 10:20:44', '027eb835-91a1-11e9-a44d-7085c206b232', '150d8a85-4ca5-4b3b-b50d-ae33ef082a3c', 'cd738805-8692-480b-80aa-51e52dbad282');
INSERT INTO `material_and_chapter` VALUES ('6b15606b-c86f-4204-b025-f045fbfdde16', '2019-06-10 20:07:18', '2019-07-30 12:53:17', null, '02de0251-91a1-11e9-a44d-7085c206b232', 'eefdcebd-bc2a-428b-968f-c87ec9e8c6a4', '4c430a49-d474-4ddd-8636-768290aff002');
INSERT INTO `material_and_chapter` VALUES ('f589f9fe-1a4c-4f52-ad39-8f62e1b1d5f2', '2019-06-10 20:13:57', '2019-06-19 15:32:01', '2019-08-01 09:58:08', '032716ee-91a1-11e9-a44d-7085c206b232', '3e212bee-8b5a-4839-9d26-93d0d42926e8', '2515ac89-3df2-4a65-b537-b0a20375ac43');
INSERT INTO `material_and_chapter` VALUES ('9edea895-fc3b-412a-8c43-29623c2bffc5', '2019-06-10 21:13:00', '2019-08-01 09:45:23', '2019-08-01 09:58:16', '03717659-91a1-11e9-a44d-7085c206b232', '2eaf3657-4ff9-4028-a760-217d12896634', '07a14cd1-fa54-415f-99b9-4e4c8f902529');
INSERT INTO `material_and_chapter` VALUES ('afdb7f1c-4d88-41c2-a3d0-57b5cb6f50d4', '2019-06-10 21:16:42', '2019-06-19 16:23:01', '2019-08-01 10:40:44', '03b770e6-91a1-11e9-a44d-7085c206b232', 'f4df4f5c-448a-4607-acb4-c4ed22ffadbd', '05579db9-089d-4fcc-abb2-e75c9453a33c');
INSERT INTO `material_and_chapter` VALUES ('e474bb00-b4fd-4125-a8c2-3d6fde92e01e', '2019-06-10 21:17:00', '2019-06-10 21:17:00', null, '03fd2161-91a1-11e9-a44d-7085c206b232', 'f4df4f5c-448a-4607-acb4-c4ed22ffadbd', '05579db9-089d-4fcc-abb2-e75c9453a33c');
INSERT INTO `material_and_chapter` VALUES ('2f542eca-f01b-40d1-9ac0-0926b0d8562e', '2019-06-10 21:17:58', '2019-06-19 11:28:51', '2019-07-19 11:38:17', '04439968-91a1-11e9-a44d-7085c206b232', '2eaf3657-4ff9-4028-a760-217d12896634', '8d8b5148-2135-4612-bc05-be180ac565bf');
INSERT INTO `material_and_chapter` VALUES ('7a6bc9c5-758d-401f-b652-31ffd81222d2', '2019-06-11 10:00:49', '2019-07-30 14:33:40', '2019-08-01 09:47:48', '06a9a3bb-91a1-11e9-a44d-7085c206b232', '2eaf3657-4ff9-4028-a760-217d12896634', '8d8b5148-2135-4612-bc05-be180ac565bf');
INSERT INTO `material_and_chapter` VALUES ('b981699a-007f-48c5-8d68-54bfc600c61a', '2019-06-11 17:33:49', '2019-06-19 11:34:21', null, '08f5fcdf-91a1-11e9-a44d-7085c206b232', 'f4df4f5c-448a-4607-acb4-c4ed22ffadbd', 'b93d9c4c-67f3-4ed8-9ecb-12f7145181f9');
INSERT INTO `material_and_chapter` VALUES ('27d1ea10-afaf-43ec-ab60-c363977d8c4d', '2019-06-11 17:33:52', '2019-08-04 09:43:30', null, '085b09dd-91a1-11e9-a44d-7085c206b232', '4ee6d0d4-3b36-4579-bb70-bf2663deaf47', '1886fea7-89e0-41e6-b370-b21ca09e686a');
INSERT INTO `material_and_chapter` VALUES ('6d0c14ee-392a-4d4c-9d66-b029ddf82d2f', '2019-06-11 17:33:54', '2019-08-01 10:42:10', null, '0559d6af-91a1-11e9-a44d-7085c206b232', 'a06306a2-57db-459c-a685-acf81f31808d', '');
INSERT INTO `material_and_chapter` VALUES ('6fc4fd20-617b-4f12-b208-93f395836905', '2019-06-11 17:36:35', '2019-06-11 17:36:35', null, '06643e64-91a1-11e9-a44d-7085c206b232', 'f4df4f5c-448a-4607-acb4-c4ed22ffadbd', '05579db9-089d-4fcc-abb2-e75c9453a33c');
INSERT INTO `material_and_chapter` VALUES ('cf6f954e-73fe-4505-b93e-4b0288bf1585', '2019-06-11 17:36:40', '2019-06-19 11:33:09', null, '077d57b6-91a1-11e9-a44d-7085c206b232', '617c52a5-9de8-4f85-8bd9-07e949837dda', '7e3dc3cc-f46b-42b1-8067-ee95abcb3f3e');
INSERT INTO `material_and_chapter` VALUES ('790dcf92-bdfb-48cc-a146-b13dcbd0b319', '2019-06-11 17:36:42', '2019-06-19 11:30:02', '2019-07-19 11:36:53', '05122489-91a1-11e9-a44d-7085c206b232', '2eaf3657-4ff9-4028-a760-217d12896634', '8d8b5148-2135-4612-bc05-be180ac565bf');
INSERT INTO `material_and_chapter` VALUES ('51e679f9-20c1-425a-96ee-a205be57b20d', '2019-06-11 18:04:46', '2019-06-19 11:29:27', null, '04cd7cbd-91a1-11e9-a44d-7085c206b232', '617c52a5-9de8-4f85-8bd9-07e949837dda', '7e3dc3cc-f46b-42b1-8067-ee95abcb3f3e');
INSERT INTO `material_and_chapter` VALUES ('4ea645a4-b5f1-40fc-b3f3-a133b4ba29cc', '2019-06-12 11:35:12', '2019-06-19 11:31:42', null, '061f9391-91a1-11e9-a44d-7085c206b232', '617c52a5-9de8-4f85-8bd9-07e949837dda', '7e3dc3cc-f46b-42b1-8067-ee95abcb3f3e');
INSERT INTO `material_and_chapter` VALUES ('583afc4b-3909-4784-92dd-5103cb1eb3d1', '2019-06-13 09:30:21', '2019-06-19 11:30:36', null, '059aa02a-91a1-11e9-a44d-7085c206b232', '2eaf3657-4ff9-4028-a760-217d12896634', '8d8b5148-2135-4612-bc05-be180ac565bf');
INSERT INTO `material_and_chapter` VALUES ('8e0c080d-9e15-4c22-bb35-4cbbdccf5a13', '2019-06-13 09:31:08', '2019-06-19 11:31:23', null, '05dee131-91a1-11e9-a44d-7085c206b232', 'f4df4f5c-448a-4607-acb4-c4ed22ffadbd', '9c15258a-7361-4ecd-80ff-080c6edb8360');
INSERT INTO `material_and_chapter` VALUES ('8d326442-a117-4a1f-a9f5-24642ccb3de2', '2019-06-13 15:14:51', '2019-08-04 09:44:17', null, '06ef4b9a-91a1-11e9-a44d-7085c206b232', '539bcb2a-a949-4f27-9d42-6d7ebffcc7ec', '3fef7357-6f03-4e15-9d12-6e89566f0a53');
INSERT INTO `material_and_chapter` VALUES ('a5491186-939a-4bd7-8a85-f65c6322b6de', '2019-06-14 16:04:00', '2019-08-04 09:47:28', null, '07c50fa9-91a1-11e9-a44d-7085c206b232', '44e01d15-f67f-4ffc-9d51-bf03f8bc3f74', '');
INSERT INTO `material_and_chapter` VALUES ('836ceef1-1f59-4fca-80d9-9bebea9a5f99', '2019-06-14 16:04:07', '2019-06-19 11:33:33', null, '080e232e-91a1-11e9-a44d-7085c206b232', 'f4df4f5c-448a-4607-acb4-c4ed22ffadbd', '05579db9-089d-4fcc-abb2-e75c9453a33c');
INSERT INTO `material_and_chapter` VALUES ('e56d78cf-34ea-4327-b8ac-7f5eb76dde28', '2019-06-17 14:11:27', '2019-06-17 14:11:27', null, 'f8fd82a4-91a0-11e9-a44d-7085c206b232', 'f4df4f5c-448a-4607-acb4-c4ed22ffadbd', '05579db9-089d-4fcc-abb2-e75c9453a33c');
INSERT INTO `material_and_chapter` VALUES ('6411ea17-05f1-434d-bb00-cad3dd778cfe', '2019-06-17 14:17:24', '2019-06-19 11:34:09', null, '08a9334a-91a1-11e9-a44d-7085c206b232', '617c52a5-9de8-4f85-8bd9-07e949837dda', 'fc2ea4b9-6ca3-4a29-8cd5-9c6c610ff7ae');
INSERT INTO `material_and_chapter` VALUES ('fbc3fcbf-ffdb-47f9-80ec-5afde10213c5', '2019-06-18 10:10:28', '2019-06-19 11:32:44', null, '07351132-91a1-11e9-a44d-7085c206b232', '617c52a5-9de8-4f85-8bd9-07e949837dda', 'fc2ea4b9-6ca3-4a29-8cd5-9c6c610ff7ae');
INSERT INTO `material_and_chapter` VALUES ('9c924cb0-7c3a-4847-86be-4f5edd454a10', '2019-06-21 17:25:54', '2019-06-21 17:25:54', '2019-07-19 11:37:01', '6fa94e33-1f3d-4517-bac6-891160e1d393', '5149652b-4791-46ed-9403-d550a69885c2', 'ffb28893-97ae-4de2-a1ae-c2da0406edc5');
INSERT INTO `material_and_chapter` VALUES ('6c5a43e8-267c-484c-8549-1b6749e13f1d', '2019-07-02 18:47:10', '2019-07-02 18:47:10', '2019-07-02 18:49:53', '21ce056a-169e-4f91-bea0-063b37969b75', '2eaf3657-4ff9-4028-a760-217d12896634', '8d8b5148-2135-4612-bc05-be180ac565bf');
INSERT INTO `material_and_chapter` VALUES ('a0f380c7-0273-4398-b56b-3984ba54f524', '2019-07-02 18:50:06', '2019-07-02 18:50:06', '2019-07-03 09:04:17', '71326d9c-321e-4887-9443-50ae5c5c8147', '2eaf3657-4ff9-4028-a760-217d12896634', '8d8b5148-2135-4612-bc05-be180ac565bf');
INSERT INTO `material_and_chapter` VALUES ('b05f33bc-5319-4300-82af-1be56fbf1417', '2019-07-03 09:03:11', '2019-07-03 09:03:11', '2019-07-03 09:04:12', 'c2b85cdd-da21-4d26-97b2-7cd42df019f2', '2eaf3657-4ff9-4028-a760-217d12896634', '8d8b5148-2135-4612-bc05-be180ac565bf');
INSERT INTO `material_and_chapter` VALUES ('9653bf79-d0f4-4885-9a61-48455a4c9676', '2019-07-03 09:04:37', '2019-07-03 09:04:37', '2019-07-03 09:17:11', 'aeba2059-0016-449a-805c-daaf8f897562', '2eaf3657-4ff9-4028-a760-217d12896634', '8d8b5148-2135-4612-bc05-be180ac565bf');
INSERT INTO `material_and_chapter` VALUES ('792f712d-eea9-49fb-a37d-4825e1d4223b', '2019-07-03 09:17:17', '2019-07-03 09:17:17', '2019-07-03 09:42:09', '8d3c5400-ace8-4fb0-a2f4-3289dcd2d10b', '2eaf3657-4ff9-4028-a760-217d12896634', '8d8b5148-2135-4612-bc05-be180ac565bf');
INSERT INTO `material_and_chapter` VALUES ('df1328a8-19cc-4a03-b555-4b27522335f4', '2019-07-03 09:43:14', '2019-07-03 09:43:14', null, '7204c196-d5c1-4b1e-b447-9092414dc2fa', '2eaf3657-4ff9-4028-a760-217d12896634', '8d8b5148-2135-4612-bc05-be180ac565bf');
INSERT INTO `material_and_chapter` VALUES ('eaaafd49-7712-4557-99c7-e1340d963ff3', '2019-07-03 10:14:38', '2019-07-03 10:14:38', null, 'ef9ffc90-f777-4a8c-81ed-d1fe2c03f1b5', '2eaf3657-4ff9-4028-a760-217d12896634', '8d8b5148-2135-4612-bc05-be180ac565bf');
INSERT INTO `material_and_chapter` VALUES ('cd8e9da3-8942-4afd-9d05-876e8b216e00', '2019-07-03 10:19:50', '2019-07-03 10:19:50', null, '228391b9-6795-4bdf-b186-e22878029430', '2eaf3657-4ff9-4028-a760-217d12896634', '07a14cd1-fa54-415f-99b9-4e4c8f902529');
INSERT INTO `material_and_chapter` VALUES ('4db08c1f-d782-4f8a-8a3b-3676d59382ca', '2019-07-03 10:31:00', '2019-07-03 10:31:00', null, 'b067f518-ad99-4b0f-bcaf-56c9b4baddaf', '2eaf3657-4ff9-4028-a760-217d12896634', '8d8b5148-2135-4612-bc05-be180ac565bf');
INSERT INTO `material_and_chapter` VALUES ('ebfe19d1-38a7-4c6d-824f-4b4b2dc6014d', '2019-07-03 10:32:14', '2019-07-03 10:32:14', null, 'f99fe246-5342-406d-a494-b029e0a84b5b', '2eaf3657-4ff9-4028-a760-217d12896634', '8d8b5148-2135-4612-bc05-be180ac565bf');
INSERT INTO `material_and_chapter` VALUES ('067b0f47-1ab6-488f-8183-137e02a247ac', '2019-07-03 10:36:17', '2019-07-03 10:36:17', null, 'bcfe997e-34d5-4f2e-a4da-e414c7f52a25', '2eaf3657-4ff9-4028-a760-217d12896634', '07a14cd1-fa54-415f-99b9-4e4c8f902529');
INSERT INTO `material_and_chapter` VALUES ('13446ca2-03d3-4a2f-9509-0ba6f1d5b2b8', '2019-07-03 10:38:04', '2019-07-03 10:38:04', '2019-07-19 11:48:50', 'a82af570-0371-4979-b265-ed69f675e0b3', '2eaf3657-4ff9-4028-a760-217d12896634', '07a14cd1-fa54-415f-99b9-4e4c8f902529');
INSERT INTO `material_and_chapter` VALUES ('1e97e762-130f-4365-833a-60ca84f66c2b', '2019-07-03 10:38:14', '2019-07-03 10:38:14', '2019-07-19 11:37:04', '772b1ea2-8e8d-4e9f-af7c-c97fa9c14e2d', '2eaf3657-4ff9-4028-a760-217d12896634', '07a14cd1-fa54-415f-99b9-4e4c8f902529');
INSERT INTO `material_and_chapter` VALUES ('1f6b4edb-df49-41e2-8bae-40f6d18c8328', '2019-07-17 09:26:20', '2019-07-17 09:26:20', null, 'e0f4f86e-fc1b-4376-b361-309673d68b6d', '2eaf3657-4ff9-4028-a760-217d12896634', 'eec639b8-0cb2-4fb7-b9d8-5619034d7c0f');
INSERT INTO `material_and_chapter` VALUES ('ff7a8715-1080-44a1-ac68-c3bbb1feb247', '2019-07-17 09:26:30', '2019-07-17 09:26:30', null, '9ef97d95-b536-4d92-961a-35b6b639c411', '2eaf3657-4ff9-4028-a760-217d12896634', 'eec639b8-0cb2-4fb7-b9d8-5619034d7c0f');
INSERT INTO `material_and_chapter` VALUES ('bc4eabd5-e837-4785-a20e-0bb215d7aeb7', '2019-07-17 10:19:00', '2019-07-17 10:19:00', null, '8ffee57e-329c-4b90-8ce3-f05982f3bc44', '2eaf3657-4ff9-4028-a760-217d12896634', '75b5ace1-5933-4518-9f0c-3ee1fc9d39e5');
INSERT INTO `material_and_chapter` VALUES ('28b50138-ed1a-43c3-85e8-2b9c22eebb93', '2019-07-17 10:19:42', '2019-07-17 10:19:42', null, '09c47059-1719-4d98-b66b-c77e7ffe82b7', '2eaf3657-4ff9-4028-a760-217d12896634', 'eec639b8-0cb2-4fb7-b9d8-5619034d7c0f');
INSERT INTO `material_and_chapter` VALUES ('dfcfe9e3-65df-4db2-bce2-888653f23071', '2019-07-17 10:22:33', '2019-07-17 10:22:33', null, '1addb8b7-2a06-49ee-b95d-e4c65498778b', '2eaf3657-4ff9-4028-a760-217d12896634', '07a14cd1-fa54-415f-99b9-4e4c8f902529');
INSERT INTO `material_and_chapter` VALUES ('8654aca7-5f59-42cd-aefd-20f7f0c62ef7', '2019-07-17 10:23:39', '2019-07-17 10:23:39', null, '2e036c20-5fbd-4063-8dd6-2857dce58068', '2eaf3657-4ff9-4028-a760-217d12896634', '07a14cd1-fa54-415f-99b9-4e4c8f902529');
INSERT INTO `material_and_chapter` VALUES ('e37a5764-b7e2-497b-806f-52e232dfd7a8', '2019-07-18 13:53:26', '2019-07-18 13:53:26', null, '1478bf28-7000-476e-ae76-1bf5ed2148ca', '3e212bee-8b5a-4839-9d26-93d0d42926e8', 'cf35be3c-dedb-48e9-ab8e-808e1e7a958a');
INSERT INTO `material_and_chapter` VALUES ('8d5fdb48-1900-4688-9dca-9ac98ba02d9b', '2019-07-19 11:37:42', '2019-07-30 12:53:37', null, '63e94133-8a4a-4318-af32-2bbebdaccfa5', 'f4df4f5c-448a-4607-acb4-c4ed22ffadbd', 'b93d9c4c-67f3-4ed8-9ecb-12f7145181f9');
INSERT INTO `material_and_chapter` VALUES ('844750b4-522c-408f-b466-d1843a00f865', '2019-07-19 11:38:32', '2019-07-29 17:04:38', '2019-08-05 15:26:34', 'd07ca48d-2b2b-486b-bb5a-f2dd10e55832', '2eaf3657-4ff9-4028-a760-217d12896634', '8d8b5148-2135-4612-bc05-be180ac565bf');
INSERT INTO `material_and_chapter` VALUES ('d22030cd-d4f0-4a16-b1d4-4bac8fede06d', '2019-07-19 11:43:54', '2019-07-19 11:43:54', null, '705b0363-42ec-479c-9ec0-7b650a74a9cf', '3e212bee-8b5a-4839-9d26-93d0d42926e8', '2515ac89-3df2-4a65-b537-b0a20375ac43');
INSERT INTO `material_and_chapter` VALUES ('433afb5e-054e-470f-91bb-afcef09a5693', '2019-07-19 11:45:20', '2019-07-19 11:45:20', null, '467ba3d6-dbb8-4890-bdd0-9457cb6f15da', '3e212bee-8b5a-4839-9d26-93d0d42926e8', '69aa12d2-b624-4186-98a2-bf32cd237532');
INSERT INTO `material_and_chapter` VALUES ('dd786100-af36-4859-8216-5857300eb425', '2019-07-22 16:25:26', '2019-08-04 09:53:23', '2019-08-05 15:26:34', '7f910d11-e8a4-4762-9016-b8a01b2f3ddf', '97d7eab4-43ae-475e-a24f-42971c796ec2', 'fc5e449f-a3b8-4b0c-a64a-e84f5039d8a8');
INSERT INTO `material_and_chapter` VALUES ('e2cfacc5-0776-47c8-9fab-0989fff67c66', '2019-08-01 09:45:35', '2019-08-01 09:45:35', '2019-08-01 10:41:16', '88ec7105-5f14-49e6-b04f-8016981e32f9', '2eaf3657-4ff9-4028-a760-217d12896634', '8d8b5148-2135-4612-bc05-be180ac565bf');
INSERT INTO `material_and_chapter` VALUES ('88723c86-3d0e-404b-b8a5-e8499f392aef', '2019-08-01 09:45:50', '2019-08-04 09:49:15', '2019-08-05 15:26:34', '7f9f5006-1f39-405f-8e2a-b22fd417b723', '97d7eab4-43ae-475e-a24f-42971c796ec2', '45357bac-1ca3-4ba2-b887-ebf27ac61fc3');
INSERT INTO `material_and_chapter` VALUES ('ec84e153-8fbc-4a10-9cdb-784dadba728b', '2019-08-04 10:06:51', '2019-08-04 10:06:51', '2019-08-05 15:26:34', 'f73cee85-8e3e-49bd-b74e-06bd3a280cea', '0057331d-41a1-4a23-885e-819882f92639', '528794fa-0ba8-489c-a279-f38793797378');
INSERT INTO `material_and_chapter` VALUES ('fa499b4a-d3d3-41a2-a4ca-433b47b64549', '2019-08-04 10:08:32', '2019-08-04 10:08:32', '2019-08-05 15:26:39', 'f179932c-4bda-4558-9593-9da038f65688', '617c52a5-9de8-4f85-8bd9-07e949837dda', 'bb4b78af-e041-40c9-8034-4f2b11b5c5cc');
INSERT INTO `material_and_chapter` VALUES ('1385f4be-b881-450c-ad99-6b0f45023032', '2019-08-05 15:19:08', '2019-08-05 15:19:08', '2019-08-05 15:28:00', '55e41a24-9d82-409e-9bb6-ce26e731b6ed', '', '');
INSERT INTO `material_and_chapter` VALUES ('55bc8fd8-b43a-4d5e-ba73-017b5651255b', '2019-08-05 15:19:18', '2019-08-05 15:19:18', '2019-08-05 15:28:00', '1b1216bc-25a5-43e8-a81c-80325403e7d0', '', '');
INSERT INTO `material_and_chapter` VALUES ('5559249d-b200-44ef-908a-eccb8f2bc150', '2019-08-05 15:19:38', '2019-08-05 15:19:38', '2019-08-05 15:26:34', 'd93874d1-e7c7-4adc-a818-2dce9d67ed9d', '2eaf3657-4ff9-4028-a760-217d12896634', '');
INSERT INTO `material_and_chapter` VALUES ('1a96147e-c092-416c-8269-30958ce1b1ce', '2019-08-05 15:19:48', '2019-08-05 15:19:48', '2019-08-05 15:28:00', '541b9eb7-cd52-4141-b1c5-0e23d99c4b66', '2eaf3657-4ff9-4028-a760-217d12896634', '37cbd1bf-fa21-4753-b5ec-5209a2124edd');
INSERT INTO `material_and_chapter` VALUES ('dd6c009d-9dc0-4f74-8c0c-50dfd2ddf4d2', '2019-08-05 15:25:18', '2019-08-05 15:25:18', '2019-08-05 15:26:34', 'c06494a4-3641-4a37-b098-2be6765ac625', '2eaf3657-4ff9-4028-a760-217d12896634', '');
INSERT INTO `material_and_chapter` VALUES ('37547000-74ed-4ce1-9b04-0b1203a1caa7', '2019-08-05 15:25:29', '2019-08-05 15:25:29', '2019-08-05 15:28:00', '59887448-3a18-4ea5-8c2e-670e97a552ed', '2eaf3657-4ff9-4028-a760-217d12896634', '8d8b5148-2135-4612-bc05-be180ac565bf');
INSERT INTO `material_and_chapter` VALUES ('0ba57fbf-cb9a-4a7d-9ad0-8bae9aea2df8', '2019-08-05 15:25:56', '2019-08-05 15:25:56', '2019-08-05 15:26:34', 'ef5a9a4c-a577-4810-9169-bd7b078ceafc', '', '');
INSERT INTO `material_and_chapter` VALUES ('424b2a9b-5591-4af5-8ab5-14a0d858833e', '2019-08-05 15:26:52', '2019-08-05 15:26:52', '2019-08-05 15:28:00', '5caddd55-7cd9-4b8c-8fc7-9dd3af2ba4de', '', '');
INSERT INTO `material_and_chapter` VALUES ('ad103ff6-08b6-44d5-a8c6-e9e03d058d87', '2019-08-05 15:28:12', '2019-08-05 15:28:12', null, 'f6536326-1966-42f1-a7a0-cc14f565a53d', '', '');
INSERT INTO `material_and_chapter` VALUES ('b54f7b6f-ea86-441c-bb17-eeff1b9dd7ee', '2019-08-05 15:28:34', '2019-08-05 15:28:34', null, '0dc0c7c7-f68b-4a61-87af-8564cd6436b7', '', '');
INSERT INTO `material_and_chapter` VALUES ('a59a1efa-59d0-4eb4-9e08-c48345817812', '2019-08-05 15:28:42', '2019-08-05 15:28:42', '2019-08-06 16:42:40', '02e57c79-5531-46aa-9cb3-a1ba3e3c6e61', '', '');
INSERT INTO `material_and_chapter` VALUES ('f8239105-24d1-42a2-837f-02bc8c23f2f4', '2019-08-05 15:29:03', '2019-08-05 15:29:03', '2019-08-12 11:36:33', 'a98a41e1-dad4-40a3-a74b-4fb3e989769d', '', '');
INSERT INTO `material_and_chapter` VALUES ('1319813e-4696-4482-b5f3-b90d95cf3138', '2019-08-05 15:29:12', '2019-08-05 15:29:12', null, '6ea67b3b-47d4-4b20-be59-0b65a777577a', '', '');
INSERT INTO `material_and_chapter` VALUES ('e3a68562-5859-4d67-9825-2462297f513b', '2019-08-05 15:30:04', '2019-08-06 16:34:49', null, 'afae24b4-ac66-4d3c-954a-f0313017f770', '2eaf3657-4ff9-4028-a760-217d12896634', '8d8b5148-2135-4612-bc05-be180ac565bf');
INSERT INTO `material_and_chapter` VALUES ('3a901f49-2421-4cde-82ef-7b373f0ab51f', '2019-08-06 15:27:35', '2019-08-06 15:27:35', null, '4a18bb9b-bfb8-410e-8bdc-c34d1019dbf1', '2eaf3657-4ff9-4028-a760-217d12896634', '8d8b5148-2135-4612-bc05-be180ac565bf');
INSERT INTO `material_and_chapter` VALUES ('9f9415be-fe9e-4367-985d-28fd22b3561c', '2019-08-06 15:27:39', '2019-08-06 15:27:39', null, '8be9e6ef-9045-4898-97b5-237749e6d882', '2eaf3657-4ff9-4028-a760-217d12896634', '8d8b5148-2135-4612-bc05-be180ac565bf');
INSERT INTO `material_and_chapter` VALUES ('71f2c24d-2b70-42a4-adfa-f265834f1581', '2019-08-06 15:27:52', '2019-08-06 15:27:52', null, '81b6a638-4de4-436e-8d64-b278e3e92960', '2eaf3657-4ff9-4028-a760-217d12896634', '37cbd1bf-fa21-4753-b5ec-5209a2124edd');
INSERT INTO `material_and_chapter` VALUES ('0f9cb882-74f2-4580-b1a3-ad094759f43b', '2019-08-06 15:27:56', '2019-08-06 15:27:56', null, '663cfbb3-b757-4d15-986e-b7660f668b03', '2eaf3657-4ff9-4028-a760-217d12896634', '37cbd1bf-fa21-4753-b5ec-5209a2124edd');
INSERT INTO `material_and_chapter` VALUES ('af9e5d2d-bc1a-4190-9c94-e7c27e1ac722', '2019-08-06 15:28:08', '2019-08-06 15:28:08', null, '28efca43-f8de-4171-8be9-f36f63cd5303', '2eaf3657-4ff9-4028-a760-217d12896634', '07a14cd1-fa54-415f-99b9-4e4c8f902529');
INSERT INTO `material_and_chapter` VALUES ('73971006-fcf6-4d8d-9bcc-f96b7456cea3', '2019-08-06 15:28:12', '2019-08-06 15:28:12', null, 'd49e7850-ed31-4794-9dd4-a817837b125a', '2eaf3657-4ff9-4028-a760-217d12896634', '07a14cd1-fa54-415f-99b9-4e4c8f902529');
INSERT INTO `material_and_chapter` VALUES ('33a1e5ba-15ac-4652-b3c2-58efb147ece0', '2019-08-06 15:28:29', '2019-08-06 15:28:29', null, 'b4282744-3d59-43f8-af7f-50832c4212bf', '2eaf3657-4ff9-4028-a760-217d12896634', '75b5ace1-5933-4518-9f0c-3ee1fc9d39e5');
INSERT INTO `material_and_chapter` VALUES ('30d98e4c-35e2-4602-b89b-96e7fe913b58', '2019-08-06 15:28:32', '2019-08-06 15:28:32', null, '521ea7f5-273c-4ad4-a5b5-d8bfd6cd1202', '2eaf3657-4ff9-4028-a760-217d12896634', '75b5ace1-5933-4518-9f0c-3ee1fc9d39e5');
INSERT INTO `material_and_chapter` VALUES ('08baaaa6-3277-4f17-b0b1-5bd55e955ff8', '2019-08-06 16:23:28', '2019-08-06 16:23:28', '2019-08-12 11:36:33', '901b10a5-c276-462b-9cf5-80f28965e42a', '', '');
INSERT INTO `material_and_chapter` VALUES ('d30bec68-5a6f-4d65-823c-a31ca148cc05', '2019-08-06 16:23:36', '2019-08-06 16:23:36', null, '7422dd96-cfbb-4ae1-aea9-0ed09c2f7695', '2eaf3657-4ff9-4028-a760-217d12896634', '');
INSERT INTO `material_and_chapter` VALUES ('11530c7e-a842-4d48-9a54-efa7cb6ec66e', '2019-08-06 16:35:51', '2019-08-06 16:35:51', '2019-08-06 16:42:46', '0036fdd5-14fa-41a3-8638-8d6d9d2deb5a', 'b23b1ae8-aa2e-47ac-820e-a5949e0d63e2', 'c70254ec-a64e-4372-ac7b-9df55c524f5a');
INSERT INTO `material_and_chapter` VALUES ('97c75348-4ce3-4df6-8ad1-f9f7df88b46c', '2019-08-06 16:36:00', '2019-08-06 16:36:00', null, '6e4c2292-d41f-4fab-97ea-f221375e00d3', 'b23b1ae8-aa2e-47ac-820e-a5949e0d63e2', '');
INSERT INTO `material_and_chapter` VALUES ('49956cd7-ae59-4d61-8a69-b7676f06d11d', '2019-08-10 15:05:15', '2019-08-10 15:05:15', null, 'c3a48b17-e8c8-4d9b-8245-71ade9540e70', '', '');
INSERT INTO `material_and_chapter` VALUES ('d338d5b6-4467-4390-81a2-623fd1c2986f', '2019-08-10 16:35:32', '2019-08-10 16:35:32', '2019-08-10 16:36:45', 'cf27e33e-47be-46b7-81ae-ba71844abd3b', '3e212bee-8b5a-4839-9d26-93d0d42926e8', '2515ac89-3df2-4a65-b537-b0a20375ac43');

-- ----------------------------
-- Table structure for material_type
-- ----------------------------
DROP TABLE IF EXISTS `material_type`;
CREATE TABLE `material_type` (
  `id` varchar(36) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `name` varchar(36) DEFAULT NULL,
  `alias` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of material_type
-- ----------------------------

-- ----------------------------
-- Table structure for pattern
-- ----------------------------
DROP TABLE IF EXISTS `pattern`;
CREATE TABLE `pattern` (
  `id` varchar(36) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `name` varchar(16) DEFAULT NULL,
  `alias` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pattern
-- ----------------------------

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
INSERT INTO `simulation_resource` VALUES ('0572f228-7796-4bfb-96d4-44867f733ba5', '2019-08-16 09:34:34', '2019-08-16 09:34:37', '2019-08-16 09:34:37', 'demo', '0', '2539d5f1-9663-11e9-b790-7085c206b232', '4abbf810-ae55-4609-9766-30fddf0bf4bd', 'simulation_resource/0572f228-7796-4bfb-96d4-44867f733ba5.cc3d', 'abed17b5-fb4f-4164-8de2-a8145bd2ed58');
INSERT INTO `simulation_resource` VALUES ('066978bc-d004-4efb-a439-a471f436d2f9', '2019-08-15 11:18:02', '2019-08-15 11:18:02', null, '二维', '0', '229ea775-9663-11e9-b790-7085c206b232', '268de5dc-f84b-4833-acb5-6ebf7970a28a', 'simulation_resource/066978bc-d004-4efb-a439-a471f436d2f9.cc3d', '');
INSERT INTO `simulation_resource` VALUES ('0ebbfaef-83ab-4d25-b00b-9fabed94a207', '2019-08-29 17:04:41', '2019-08-29 17:04:41', null, '异步电机两地控制', '0', '2539d5f1-9663-11e9-b790-7085c206b232', null, 'course_dj/simulation_resource/0ebbfaef-83ab-4d25-b00b-9fabed94a207.cc3d', 'a252d75d-a06c-4ce1-ad4f-ff3b32cf86f7');
INSERT INTO `simulation_resource` VALUES ('279cf060-336b-4c94-b0ac-c6b46c1c21f5', '2019-08-29 16:58:53', '2019-08-29 16:58:53', null, '异步电机两地控制', '0', '2539d5f1-9663-11e9-b790-7085c206b232', null, 'course_dj/simulation_resource/279cf060-336b-4c94-b0ac-c6b46c1c21f5.cc3d', 'a252d75d-a06c-4ce1-ad4f-ff3b32cf86f7');
INSERT INTO `simulation_resource` VALUES ('2d64d679-54c6-4705-9e18-f83deacd680a', '2019-08-07 15:39:05', '2019-08-07 15:41:51', '2019-08-07 15:41:51', '333', '0', '2539d5f1-9663-11e9-b790-7085c206b232', '268de5dc-f84b-4833-acb5-6ebf7970a28a', 'simulation_resource/2d64d679-54c6-4705-9e18-f83deacd680a.cc3d', '');
INSERT INTO `simulation_resource` VALUES ('2dfffae8-672b-4f2c-bd76-58aba92e47b4', '2019-08-15 11:17:35', '2019-08-19 10:31:22', '2019-08-19 10:31:22', '的', '0', '229ea775-9663-11e9-b790-7085c206b232', '268de5dc-f84b-4833-acb5-6ebf7970a28a', 'simulation_resource/2dfffae8-672b-4f2c-bd76-58aba92e47b4.cc3d', '');
INSERT INTO `simulation_resource` VALUES ('3279adfc-39ef-4b0c-a08e-fcbfacb52445', '2019-08-16 09:33:55', '2019-08-16 09:33:58', '2019-08-16 09:33:58', 'demo', '0', '2539d5f1-9663-11e9-b790-7085c206b232', '4abbf810-ae55-4609-9766-30fddf0bf4bd', 'simulation_resource/3279adfc-39ef-4b0c-a08e-fcbfacb52445.cc3d', 'a252d75d-a06c-4ce1-ad4f-ff3b32cf86f7');
INSERT INTO `simulation_resource` VALUES ('340b9a85-6d0c-4d16-8ca9-72b933852242', '2019-08-09 17:34:03', '2019-08-09 17:34:03', null, 'sadc', '0', '229ea775-9663-11e9-b790-7085c206b232', 'c06faba5-aa09-11e9-aad5-fa163e70a28a', 'simulation_resource/340b9a85-6d0c-4d16-8ca9-72b933852242.cc3d', '');
INSERT INTO `simulation_resource` VALUES ('40308895-5fd7-450a-8ead-2bd79022aef8', '2019-08-29 16:57:09', '2019-08-29 16:57:09', null, '异步电机两地控制', '0', '2539d5f1-9663-11e9-b790-7085c206b232', null, 'course_dj/simulation_resource/40308895-5fd7-450a-8ead-2bd79022aef8.cc3d', 'a252d75d-a06c-4ce1-ad4f-ff3b32cf86f7');
INSERT INTO `simulation_resource` VALUES ('45afc794-2d42-46fd-b9b8-c8746a5e984f', '2019-07-16 11:02:54', '2019-08-06 15:26:19', null, '异步电动机单向点动启动控制', '1', '2539d5f1-9663-11e9-b790-7085c206b232', null, 'simulation_resource/45afc794-2d42-46fd-b9b8-c8746a5e984f.cc3d', '9ebde672-008e-4588-8e49-0c634c4b7f22');
INSERT INTO `simulation_resource` VALUES ('4f5e05fc-c29a-4958-83f2-12d78938d361', '2019-09-02 14:00:19', '2019-09-02 14:00:19', null, '异步电动机联锁正反转控制', '0', '2539d5f1-9663-11e9-b790-7085c206b232', null, 'course_dj/simulation_resource/4f5e05fc-c29a-4958-83f2-12d78938d361.cc3d', 'a252d75d-a06c-4ce1-ad4f-ff3b32cf86f7');
INSERT INTO `simulation_resource` VALUES ('8430c46f-ffa3-4246-80f6-fb2ba97351ec', '2019-08-07 15:34:37', '2019-08-19 10:31:33', '2019-08-19 10:31:33', '阿萨', '0', '2539d5f1-9663-11e9-b790-7085c206b232', '268de5dc-f84b-4833-acb5-6ebf7970a28a', 'simulation_resource/8430c46f-ffa3-4246-80f6-fb2ba97351ec.cc3d', '9ebde672-008e-4588-8e49-0c634c4b7f22');
INSERT INTO `simulation_resource` VALUES ('8447b9dc-1cff-44f2-8324-8b483b471564', '2019-08-29 16:49:07', '2019-08-29 16:49:07', null, '异步电动机联锁正反转控制', '0', '2539d5f1-9663-11e9-b790-7085c206b232', null, 'course_dj/simulation_resource/8447b9dc-1cff-44f2-8324-8b483b471564.cc3d', 'a252d75d-a06c-4ce1-ad4f-ff3b32cf86f7');
INSERT INTO `simulation_resource` VALUES ('8ac888c9-23d9-401b-b7ce-f6d5d6682716', '2019-08-29 16:55:41', '2019-08-29 16:55:41', null, '异步电机两地控制', '0', '2539d5f1-9663-11e9-b790-7085c206b232', null, 'course_dj/simulation_resource/8ac888c9-23d9-401b-b7ce-f6d5d6682716.cc3d', 'a252d75d-a06c-4ce1-ad4f-ff3b32cf86f7');
INSERT INTO `simulation_resource` VALUES ('9247b50e-5f82-4c28-b9f7-faeaee8e0d47', '2019-08-29 17:03:02', '2019-08-29 17:03:02', null, '异步电机两地控制', '0', '2539d5f1-9663-11e9-b790-7085c206b232', null, 'course_dj/simulation_resource/9247b50e-5f82-4c28-b9f7-faeaee8e0d47.cc3d', 'a252d75d-a06c-4ce1-ad4f-ff3b32cf86f7');
INSERT INTO `simulation_resource` VALUES ('974e2f53-33e0-425c-ac5d-5ecee9db2ebf', '2019-08-15 11:17:41', '2019-08-19 10:31:19', '2019-08-19 10:31:19', '额', '0', '229ea775-9663-11e9-b790-7085c206b232', '268de5dc-f84b-4833-acb5-6ebf7970a28a', 'simulation_resource/974e2f53-33e0-425c-ac5d-5ecee9db2ebf.cc3d', '');
INSERT INTO `simulation_resource` VALUES ('990e529b-80a4-4683-91fa-6b00c5e3b534', '2019-08-30 15:43:32', '2019-08-30 15:43:32', null, '异步电动机联锁正反转控制', '0', '2539d5f1-9663-11e9-b790-7085c206b232', null, 'course_dj/simulation_resource/990e529b-80a4-4683-91fa-6b00c5e3b534.cc3d', 'a252d75d-a06c-4ce1-ad4f-ff3b32cf86f7');
INSERT INTO `simulation_resource` VALUES ('999ea144-8136-41b0-8d0a-3e5efaad97f7', '2019-09-02 09:20:42', '2019-09-02 09:20:42', null, '异步电机两地控制', '0', '2539d5f1-9663-11e9-b790-7085c206b232', null, 'course_dj/simulation_resource/999ea144-8136-41b0-8d0a-3e5efaad97f7.cc3d', 'a252d75d-a06c-4ce1-ad4f-ff3b32cf86f7');
INSERT INTO `simulation_resource` VALUES ('ac1dc5ce-2d71-4425-9f07-a803740e40de', '2019-08-07 15:35:50', '2019-08-19 10:31:31', '2019-08-19 10:31:31', '搜索', '0', '2539d5f1-9663-11e9-b790-7085c206b232', '268de5dc-f84b-4833-acb5-6ebf7970a28a', 'simulation_resource/ac1dc5ce-2d71-4425-9f07-a803740e40de.cc3d', '');
INSERT INTO `simulation_resource` VALUES ('bdeaf9d4-817c-48b6-b2d1-3e97337afb81', '2019-09-02 14:00:20', '2019-09-02 14:00:20', null, '异步电动机联锁正反转控制', '0', '2539d5f1-9663-11e9-b790-7085c206b232', null, 'course_dj/simulation_resource/bdeaf9d4-817c-48b6-b2d1-3e97337afb81.cc3d', 'a252d75d-a06c-4ce1-ad4f-ff3b32cf86f7');
INSERT INTO `simulation_resource` VALUES ('bf0da7cf-57a4-4770-8010-8a4b81116fc4', '2019-08-07 15:36:21', '2019-08-19 10:31:26', '2019-08-19 10:31:26', '电风扇', '0', '9b940c48-9e3c-11e9-b790-7085c206b232', '268de5dc-f84b-4833-acb5-6ebf7970a28a', 'simulation_resource/bf0da7cf-57a4-4770-8010-8a4b81116fc4.cc3d', '');
INSERT INTO `simulation_resource` VALUES ('bfb1e4ee-5d52-4f70-9edd-87861e8d9a6d', '2019-07-13 16:29:05', '2019-08-29 16:55:07', null, '异步电机两地控制', '1', '2539d5f1-9663-11e9-b790-7085c206b232', null, 'course_dj/simulation_resource/bfb1e4ee-5d52-4f70-9edd-87861e8d9a6d.cc3d', 'a252d75d-a06c-4ce1-ad4f-ff3b32cf86f7');
INSERT INTO `simulation_resource` VALUES ('c41a19a5-0b19-436f-8013-72a1a771b093', '2019-08-29 17:04:15', '2019-08-29 17:04:15', null, '异步电机两地控制', '0', '2539d5f1-9663-11e9-b790-7085c206b232', null, 'course_dj/simulation_resource/c41a19a5-0b19-436f-8013-72a1a771b093.cc3d', 'a252d75d-a06c-4ce1-ad4f-ff3b32cf86f7');
INSERT INTO `simulation_resource` VALUES ('c55062e5-f4b9-4af5-9653-f62892c1f8dd', '2019-08-15 11:17:55', '2019-08-16 09:52:25', '2019-08-16 09:52:25', '额人', '0', '229ea775-9663-11e9-b790-7085c206b232', '268de5dc-f84b-4833-acb5-6ebf7970a28a', 'simulation_resource/c55062e5-f4b9-4af5-9653-f62892c1f8dd.cc3d', '');
INSERT INTO `simulation_resource` VALUES ('c6a1eb20-b314-4211-bb31-3120dfe43851', '2019-08-07 15:37:35', '2019-08-19 10:31:24', '2019-08-19 10:31:24', 'jk', '0', '2539d5f1-9663-11e9-b790-7085c206b232', '268de5dc-f84b-4833-acb5-6ebf7970a28a', 'simulation_resource/c6a1eb20-b314-4211-bb31-3120dfe43851.cc3d', '9ebde672-008e-4588-8e49-0c634c4b7f22');
INSERT INTO `simulation_resource` VALUES ('cd22277c-881a-404a-8bb6-5547f9472fb9', '2019-08-21 09:49:14', '2019-08-21 09:49:14', null, '333', '0', '2539d5f1-9663-11e9-b790-7085c206b232', '4abbf810-ae55-4609-9766-30fddf0bf4bd', 'simulation_resource/cd22277c-881a-404a-8bb6-5547f9472fb9.cc3d', 'abed17b5-fb4f-4164-8de2-a8145bd2ed58');
INSERT INTO `simulation_resource` VALUES ('d006983b-1d96-4563-b110-f7ce449f4559', '2019-08-29 17:00:06', '2019-08-29 17:00:06', null, '异步电机两地控制', '0', '2539d5f1-9663-11e9-b790-7085c206b232', null, 'course_dj/simulation_resource/d006983b-1d96-4563-b110-f7ce449f4559.cc3d', 'a252d75d-a06c-4ce1-ad4f-ff3b32cf86f7');
INSERT INTO `simulation_resource` VALUES ('d464f0c0-e608-4527-a728-dfd1e3da7fa2', '2019-07-17 09:26:50', '2019-08-29 16:43:01', null, '异步电动机联锁正反转控制', '1', '2539d5f1-9663-11e9-b790-7085c206b232', null, 'course_dj/simulation_resource/d464f0c0-e608-4527-a728-dfd1e3da7fa2.cc3d', 'a252d75d-a06c-4ce1-ad4f-ff3b32cf86f7');
INSERT INTO `simulation_resource` VALUES ('e6912264-936a-4fc7-9989-77019e08901f', '2019-08-29 17:05:06', '2019-08-29 17:05:06', null, '异步电动机联锁正反转控制', '0', '2539d5f1-9663-11e9-b790-7085c206b232', null, 'course_dj/simulation_resource/e6912264-936a-4fc7-9989-77019e08901f.cc3d', 'a252d75d-a06c-4ce1-ad4f-ff3b32cf86f7');
INSERT INTO `simulation_resource` VALUES ('eeab7a44-b3b0-4288-bd27-dacb7ba6280d', '2019-09-02 09:27:43', '2019-09-02 09:27:43', null, '异步电动机联锁正反转控制', '0', '2539d5f1-9663-11e9-b790-7085c206b232', null, 'course_dj/simulation_resource/eeab7a44-b3b0-4288-bd27-dacb7ba6280d.cc3d', 'a252d75d-a06c-4ce1-ad4f-ff3b32cf86f7');
INSERT INTO `simulation_resource` VALUES ('f4fce549-fbd7-4fe5-950d-0c2dfb631761', '2019-08-07 15:36:09', '2019-08-19 10:31:29', '2019-08-19 10:31:29', '但是', '0', '2539d5f1-9663-11e9-b790-7085c206b232', '268de5dc-f84b-4833-acb5-6ebf7970a28a', 'simulation_resource/f4fce549-fbd7-4fe5-950d-0c2dfb631761.cc3d', '');
INSERT INTO `simulation_resource` VALUES ('f7b14e0b-d9ac-44ae-9419-5a78e84d8f7d', '2019-07-16 10:35:21', '2019-08-06 15:26:55', null, '异步电动机手动单向运转控制', '1', '2539d5f1-9663-11e9-b790-7085c206b232', null, 'simulation_resource/f7b14e0b-d9ac-44ae-9419-5a78e84d8f7d.cc3d', '9ebde672-008e-4588-8e49-0c634c4b7f22');

-- ----------------------------
-- Table structure for task_experiments
-- ----------------------------
DROP TABLE IF EXISTS `task_experiments`;
CREATE TABLE `task_experiments` (
  `id` varchar(36) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `template_id` varchar(36) NOT NULL COMMENT '任务模板id',
  `innerr` tinyint(1) DEFAULT NULL COMMENT '是否为内置实验',
  `master_id` varchar(36) DEFAULT NULL COMMENT '老师id',
  `start_time` timestamp NULL DEFAULT NULL COMMENT '开始时间',
  `finish_time` timestamp NULL DEFAULT NULL COMMENT '结束时间',
  `total` int(11) unsigned DEFAULT NULL COMMENT '总人数',
  `complete` int(11) unsigned DEFAULT NULL COMMENT '已完成人数',
  `remark` text,
  `completed` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_task_experiments_deleted_at` (`deleted_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='实验任务表';

-- ----------------------------
-- Records of task_experiments
-- ----------------------------
INSERT INTO `task_experiments` VALUES ('5741127a-7692-44d3-828e-191946250606', '2019-08-09 15:48:38', '2019-08-10 11:40:00', null, 'a158b0dd-d80b-404b-add1-377e8a91e638', '0', '268de5dc-f84b-4833-acb5-6ebf7970a28a', '2019-08-09 15:45:19', '2019-08-09 15:55:00', '2', '0', null, '1');
INSERT INTO `task_experiments` VALUES ('607a162c-162d-441d-ad08-3981f98df06b', '2019-08-09 19:56:14', '2019-08-09 20:00:00', null, 'b7dd98a2-bbaa-47d4-824b-9ff73225e875', '0', '268de5dc-f84b-4833-acb5-6ebf7970a28a', '2019-08-09 15:45:19', '2019-08-09 20:00:00', '2', '0', '111', '1');
INSERT INTO `task_experiments` VALUES ('64a60e3d-57c8-4b1f-9831-cab8822a1bbb', '2019-08-08 09:34:40', '2019-08-15 00:00:00', null, '067f9cd7-33d5-4849-a296-62e57b46dbad', '0', '268de5dc-f84b-4833-acb5-6ebf7970a28a', '2019-08-08 09:34:46', '2019-08-14 23:59:59', '1', '0', '测试', '1');
INSERT INTO `task_experiments` VALUES ('69b3bcc3-a9a7-4ba2-8a37-b89cd09ff996', '2019-08-09 19:47:54', '2019-08-09 19:50:00', null, '37ba558a-6a7c-4b37-b7dd-519cbfcdc77a', '0', '268de5dc-f84b-4833-acb5-6ebf7970a28a', '2019-08-09 15:45:19', '2019-08-09 19:50:00', '2', '0', '121', '1');
INSERT INTO `task_experiments` VALUES ('84e96d72-dcab-4bda-9ffb-caa3cd31f234', '2019-08-07 09:37:02', '2019-08-07 09:40:07', null, '65a03642-7518-452a-aa93-17ae67f1b8e2', '0', '268de5dc-f84b-4833-acb5-6ebf7970a28a', '2019-08-07 09:37:04', '2019-08-08 23:59:59', '5', '1', '好的', '1');
INSERT INTO `task_experiments` VALUES ('953d5b88-1fd2-4fdd-bd08-390d35d2166d', '2019-08-09 11:35:55', '2019-08-09 11:35:55', null, '4769e1a8-72b1-436b-9262-12586fe94059', '0', '268de5dc-f84b-4833-acb5-6ebf7970a28a', '2019-08-09 11:35:55', '2019-08-31 23:59:59', '5', '0', '好好学习', '0');
INSERT INTO `task_experiments` VALUES ('9b765d22-1742-4506-873d-fb6e20e9c276', '2019-08-09 15:47:24', '2019-08-09 15:47:24', null, '5f269366-f209-45fc-a184-98b462bf7fab', '0', '268de5dc-f84b-4833-acb5-6ebf7970a28a', '2019-08-09 15:45:19', '2019-08-31 23:59:59', '2', '0', '123321', '0');
INSERT INTO `task_experiments` VALUES ('a8200d89-83f4-4d83-9e25-3229376d52be', '2019-08-07 11:24:37', '2019-08-14 00:00:00', null, '13ba88dc-ac0c-44bc-b64d-f5447217c1e0', '0', '268de5dc-f84b-4833-acb5-6ebf7970a28a', '2019-08-07 11:24:41', '2019-08-13 23:59:59', '1', '0', '重庆测试b', '1');
INSERT INTO `task_experiments` VALUES ('d4b354df-cd6a-4cd7-895a-cfce9773ad1a', '2019-08-19 10:13:05', '2019-08-22 00:00:02', null, '1fc41bc4-e461-45ad-a6bb-fc51bf0db66f', '0', '268de5dc-f84b-4833-acb5-6ebf7970a28a', '2019-08-19 10:13:06', '2019-08-20 23:59:59', '4', '1', '', '1');
INSERT INTO `task_experiments` VALUES ('d738807c-29b2-4f95-a6fe-d29c86e47ded', '2019-08-09 18:37:57', '2019-08-10 11:40:00', null, '380e9c46-def5-4b29-819c-744256fb2b38', '0', '268de5dc-f84b-4833-acb5-6ebf7970a28a', '2019-08-09 15:45:19', '2019-08-09 18:40:00', '2', '0', 'hao111', '1');
INSERT INTO `task_experiments` VALUES ('e95c4439-06f2-4803-9b70-323f7b1e3593', '2019-08-09 18:20:54', '2019-08-10 11:40:00', null, 'ec995992-48fc-4c69-82ea-94f0537a2522', '0', '268de5dc-f84b-4833-acb5-6ebf7970a28a', '2019-08-09 15:45:19', '2019-08-09 07:30:00', '2', '0', null, '1');

-- ----------------------------
-- Table structure for task_experiment_projects
-- ----------------------------
DROP TABLE IF EXISTS `task_experiment_projects`;
CREATE TABLE `task_experiment_projects` (
  `id` varchar(36) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `task_experiment_id` varchar(36) NOT NULL COMMENT '实验任务id',
  `submitter_id` varchar(36) NOT NULL COMMENT '学生id',
  `sim_id` varchar(36) NOT NULL,
  `scene_path` varchar(64) DEFAULT NULL COMMENT 'u3d工程文件的路径',
  `sim_path` varchar(64) DEFAULT NULL COMMENT '实验数据文件路径',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uix_task_experiment_projects_scene_path` (`scene_path`),
  UNIQUE KEY `uix_task_experiment_projects_sim_path` (`sim_path`),
  KEY `idx_task_experiment_projects_deleted_at` (`deleted_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='实验任务项目';

-- ----------------------------
-- Records of task_experiment_projects
-- ----------------------------

-- ----------------------------
-- Table structure for task_experiment_reports
-- ----------------------------
DROP TABLE IF EXISTS `task_experiment_reports`;
CREATE TABLE `task_experiment_reports` (
  `id` varchar(36) NOT NULL DEFAULT '',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `task_experiment_id` varchar(36) NOT NULL,
  `account_id` varchar(36) NOT NULL,
  `name` varchar(36) DEFAULT NULL COMMENT '资源id实验报告',
  `path` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_task_experiment_reports_deleted_at` (`deleted_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task_experiment_reports
-- ----------------------------
INSERT INTO `task_experiment_reports` VALUES ('0aa97e6b-f50f-462d-9e74-be6fa2369e5a', '2019-08-07 09:38:21', '2019-08-07 09:38:21', null, '84e96d72-dcab-4bda-9ffb-caa3cd31f234', '256ea2d0-1091-46da-8e7f-de36ad3f45d7', '新建 Microsoft Word 2007 文档.pdf', 'report/0aa97e6b-f50f-462d-9e74-be6fa2369e5a.pdf');

-- ----------------------------
-- Table structure for task_score
-- ----------------------------
DROP TABLE IF EXISTS `task_score`;
CREATE TABLE `task_score` (
  `id` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `account_id` varchar(255) DEFAULT NULL,
  `task_experiment_id` varchar(255) DEFAULT NULL,
  `score` double(255,1) DEFAULT NULL,
  `comment` text,
  `completed` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task_score
-- ----------------------------
INSERT INTO `task_score` VALUES ('04c6b3b3-0946-4376-a631-bfb4f5220952', '2019-08-09 15:48:38', '2019-08-09 15:48:38', null, '2da7dcfc-629a-4550-9bd7-2d096d7d06a6', '5741127a-7692-44d3-828e-191946250606', null, null, '0');
INSERT INTO `task_score` VALUES ('07fe586a-6544-47c4-b3a0-9244a6b81904', '2019-08-09 11:35:55', '2019-08-09 11:35:55', null, '14a98659-4b61-4933-9eff-a0ba1eda3f8a', '953d5b88-1fd2-4fdd-bd08-390d35d2166d', null, null, '0');
INSERT INTO `task_score` VALUES ('0be54a0e-8228-4074-9be3-02ef57283d55', '2019-08-09 18:37:57', '2019-08-09 18:37:57', null, '2da7dcfc-629a-4550-9bd7-2d096d7d06a6', 'd738807c-29b2-4f95-a6fe-d29c86e47ded', null, null, '0');
INSERT INTO `task_score` VALUES ('3423ad66-1684-44ab-b138-de39e2964f89', '2019-08-09 15:47:24', '2019-08-09 15:47:24', null, '2da7dcfc-629a-4550-9bd7-2d096d7d06a6', '9b765d22-1742-4506-873d-fb6e20e9c276', null, null, '0');
INSERT INTO `task_score` VALUES ('4dca1c2d-1afd-46fb-8643-61197d2f6bab', '2019-08-09 11:35:55', '2019-08-09 11:35:55', null, 'ac64a23b-8c72-4b77-bdb8-794159dad490', '953d5b88-1fd2-4fdd-bd08-390d35d2166d', null, null, '0');
INSERT INTO `task_score` VALUES ('586bcdb9-1d79-4a94-a2ac-743015d54a12', '2019-08-07 09:39:24', '2019-08-09 14:39:38', null, '256ea2d0-1091-46da-8e7f-de36ad3f45d7', '84e96d72-dcab-4bda-9ffb-caa3cd31f234', '78.0', '阿斯顿发撒旦法', '0');
INSERT INTO `task_score` VALUES ('5fd5d42b-601f-4606-b844-a0a646e1b85e', '2019-08-09 11:35:55', '2019-08-09 14:41:19', null, '256ea2d0-1091-46da-8e7f-de36ad3f45d7', '953d5b88-1fd2-4fdd-bd08-390d35d2166d', null, null, '1');
INSERT INTO `task_score` VALUES ('64afc098-52c2-43c4-9dd7-cee29e5dd26f', '2019-08-09 19:47:54', '2019-08-09 19:47:54', null, '2da7dcfc-629a-4550-9bd7-2d096d7d06a6', '69b3bcc3-a9a7-4ba2-8a37-b89cd09ff996', null, null, '0');
INSERT INTO `task_score` VALUES ('6869ad0f-2c15-4020-af4b-c2ad08815d76', '2019-08-09 18:29:36', '2019-08-09 18:29:36', null, '2da7dcfc-629a-4550-9bd7-2d096d7d06a6', 'c8674cc2-1383-41f1-9327-b8f50fe4b71a', null, null, '0');
INSERT INTO `task_score` VALUES ('70cde963-b818-467c-9fb5-7c9f0bf2466b', '2019-08-09 19:56:14', '2019-08-09 19:56:14', null, '2da7dcfc-629a-4550-9bd7-2d096d7d06a6', '607a162c-162d-441d-ad08-3981f98df06b', null, null, '0');
INSERT INTO `task_score` VALUES ('763b0b17-f37c-4253-abac-31f95b32bd52', '2019-08-09 15:47:24', '2019-08-09 15:47:24', null, '256ea2d0-1091-46da-8e7f-de36ad3f45d7', '9b765d22-1742-4506-873d-fb6e20e9c276', null, null, '0');
INSERT INTO `task_score` VALUES ('82b4e589-ddab-48d4-bea2-a3c6e538185d', '2019-08-09 18:29:36', '2019-08-09 18:29:36', null, '256ea2d0-1091-46da-8e7f-de36ad3f45d7', 'c8674cc2-1383-41f1-9327-b8f50fe4b71a', null, null, '0');
INSERT INTO `task_score` VALUES ('8466a9cc-bf9e-46a2-92a7-b3b7473d05d3', '2019-08-19 10:13:05', '2019-08-19 10:13:05', null, '2da7dcfc-629a-4550-9bd7-2d096d7d06a6', 'd4b354df-cd6a-4cd7-895a-cfce9773ad1a', null, null, '0');
INSERT INTO `task_score` VALUES ('903a8d04-f2e8-40b0-80bb-32f72c006c0f', '2019-08-09 18:37:57', '2019-08-09 18:37:57', null, '256ea2d0-1091-46da-8e7f-de36ad3f45d7', 'd738807c-29b2-4f95-a6fe-d29c86e47ded', null, null, '0');
INSERT INTO `task_score` VALUES ('9f05686a-be84-4cfe-bb0e-fe99e8451f5e', '2019-08-09 18:20:54', '2019-08-09 18:20:54', null, '2da7dcfc-629a-4550-9bd7-2d096d7d06a6', 'e95c4439-06f2-4803-9b70-323f7b1e3593', null, null, '0');
INSERT INTO `task_score` VALUES ('a9a86e23-f2dd-4a73-a71d-81e8d193c486', '2019-08-19 10:13:05', '2019-08-19 14:05:34', null, '256ea2d0-1091-46da-8e7f-de36ad3f45d7', 'd4b354df-cd6a-4cd7-895a-cfce9773ad1a', '100.0', '', '0');
INSERT INTO `task_score` VALUES ('ac6b41dc-50f7-487c-b234-b52625d78992', '2019-08-09 11:35:55', '2019-08-19 10:12:15', null, '2da7dcfc-629a-4550-9bd7-2d096d7d06a6', '953d5b88-1fd2-4fdd-bd08-390d35d2166d', null, null, '0');
INSERT INTO `task_score` VALUES ('b37eda78-ee10-411c-94b4-e0d3da23cd33', '2019-08-09 11:35:55', '2019-08-09 11:35:55', null, 'f6e2d806-87a4-447f-b4e8-aec0c297e318', '953d5b88-1fd2-4fdd-bd08-390d35d2166d', null, null, '0');
INSERT INTO `task_score` VALUES ('b785a16e-dd8e-4b91-aa8e-43a993b7706c', '2019-08-09 15:48:38', '2019-08-09 15:48:38', null, '256ea2d0-1091-46da-8e7f-de36ad3f45d7', '5741127a-7692-44d3-828e-191946250606', null, null, '0');
INSERT INTO `task_score` VALUES ('cd9259e5-5822-43d8-95c9-c95b7e2a9710', '2019-08-09 19:56:14', '2019-08-09 19:56:14', null, '256ea2d0-1091-46da-8e7f-de36ad3f45d7', '607a162c-162d-441d-ad08-3981f98df06b', null, null, '0');
INSERT INTO `task_score` VALUES ('cde7641d-1579-4299-bfdd-584c678ee4c9', '2019-08-19 10:13:05', '2019-08-19 10:13:05', null, 'ac64a23b-8c72-4b77-bdb8-794159dad490', 'd4b354df-cd6a-4cd7-895a-cfce9773ad1a', null, null, '0');
INSERT INTO `task_score` VALUES ('d47317c7-ce87-4848-a239-2c3c1ba777cd', '2019-08-19 10:13:05', '2019-08-19 10:13:05', null, '14a98659-4b61-4933-9eff-a0ba1eda3f8a', 'd4b354df-cd6a-4cd7-895a-cfce9773ad1a', null, null, '0');
INSERT INTO `task_score` VALUES ('ef3e191f-fee3-42ef-bb7e-fd667a2abc6f', '2019-08-09 18:20:54', '2019-08-09 18:20:54', null, '256ea2d0-1091-46da-8e7f-de36ad3f45d7', 'e95c4439-06f2-4803-9b70-323f7b1e3593', null, null, '0');
INSERT INTO `task_score` VALUES ('fa0c1d58-3c4d-4245-963a-1d02a65ffef5', '2019-08-09 19:47:54', '2019-08-09 19:47:54', null, '256ea2d0-1091-46da-8e7f-de36ad3f45d7', '69b3bcc3-a9a7-4ba2-8a37-b89cd09ff996', null, null, '0');

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
INSERT INTO `training` VALUES ('1b3708bd-1608-4c32-915c-a17f2c265a48', '2019-09-02 10:59:28', '2019-09-02 10:59:28', null, null, '25da96b4-c9fe-11e9-81b8-7085c206b232', 'www', '0', '268de5dc-f84b-4833-acb5-6ebf7970a28a', null, null, null);
INSERT INTO `training` VALUES ('3219ef3e-0163-40e0-83dd-9dabb28fcc68', '2019-08-29 18:15:29', '2019-08-30 14:35:14', null, '7017986f-c9ff-11e9-81b8-7085c206b232', null, '21313', '0', '268de5dc-f84b-4833-acb5-6ebf7970a28a', null, null, null);
INSERT INTO `training` VALUES ('742dc4aa-76f4-40b9-8708-171063e20ae8', '2019-08-30 11:28:55', '2019-08-30 14:35:06', null, 'a3d8e0a7-c9fe-11e9-81b8-7085c206b232', '25da96b4-c9fe-11e9-81b8-7085c206b232', 'dsv', '1', null, null, null, null);
INSERT INTO `training` VALUES ('8b54cec1-ce17-4a30-8573-ffd6db130317', '2019-09-02 09:40:14', '2019-09-02 09:40:14', null, null, '25da96b4-c9fe-11e9-81b8-7085c206b232', '0达瓦大阿达', '0', '4abbf810-ae55-4609-9766-30fddf0bf4bd', null, null, null);
INSERT INTO `training` VALUES ('b2d7fe76-49b8-4bad-9a3f-78e8d0c29fe5', '2019-09-01 23:44:11', '2019-09-01 23:44:11', null, null, '25da96b4-c9fe-11e9-81b8-7085c206b232', 'aaa', '0', '268de5dc-f84b-4833-acb5-6ebf7970a28a', null, null, null);
INSERT INTO `training` VALUES ('b5a63565-c9f2-4dc5-bb1a-b6dcb547932f', '2019-08-30 11:21:53', '2019-08-30 14:42:33', null, '7017986f-c9ff-11e9-81b8-7085c206b232', '25da96b4-c9fe-11e9-81b8-7085c206b232', 'dsfds', '0', '268de5dc-f84b-4833-acb5-6ebf7970a28a', null, null, null);
INSERT INTO `training` VALUES ('c14313e7-dbe9-41c5-9eb6-f65dd381fff7', '2019-08-29 18:15:54', '2019-09-02 14:00:20', null, 'a4d79855-c9fe-11e9-81b8-7085c206b232', null, '21313', '1', null, null, '[{\"name\":\"实训内容\",\"value\":\"内容\"},{\"name\":\"实训步骤\",\"value\":\"内容\"},{\"name\":\"实训原理\",\"value\":\"内容\"}]', null);
INSERT INTO `training` VALUES ('db9e420d-813b-407b-a4ed-a31af6b1a128', '2019-08-29 15:38:37', '2019-08-30 14:54:31', null, 'd33648ee-c9fe-11e9-81b8-7085c206b232', null, 'ceshi', '1', null, '[{\"name\":\"实训目的\",\"value\":\"好好学习\"},{\"name\":\"实训目1的\",\"value\":\"好好学1习\"}]', '[{\"name\":\"实训要求\",\"value\":\"好好学习啊\"},{\"name\":\"实训要求1\",\"value\":\"好好学习\"},{\"name\":\"demo\",\"value\":\"123456\"}]', '[{\"name\":\"实训说明\",\"value\":\"完成考核\"},{\"name\":\"实训要求1\",\"value\":\"完成\"}]');

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
INSERT INTO `training_file` VALUES ('00b4c826-527b-4de2-bb1a-700624588608', '2019-08-30 13:47:01', '2019-08-30 13:47:01', null, 'demoWord.pdf', 'course_dj\\annex\\00b4c826-527b-4de2-bb1a-700624588608.pdf', '13.12 KB', null, 'pdf', '0', null, null, 'annex');
INSERT INTO `training_file` VALUES ('07cd97d3-c768-4699-b430-090a5264984c', '2019-08-30 13:53:30', '2019-08-30 13:53:30', null, 'demoWord.html', 'course_dj\\annex\\07cd97d3-c768-4699-b430-090a5264984c.html', '999.0 B', null, 'html', '0', null, null, 'annex');
INSERT INTO `training_file` VALUES ('10eb99c5-d06b-4fe9-9d4d-2ac65a7b71b6', '2019-08-29 16:21:31', '2019-08-29 16:46:54', null, '实验二：电机点动控制实验指导书.pdf', 'course_dj\\GUIDE\\10eb99c5-d06b-4fe9-9d4d-2ac65a7b71b6.pdf', '244.47 KB', null, 'pdf', '0', 'db9e420d-813b-407b-a4ed-a31af6b1a128', 'TEACHING', 'GUIDE');
INSERT INTO `training_file` VALUES ('11a8b617-ff9b-4008-9dcf-a94225fca7e5', '2019-08-30 14:26:55', '2019-08-30 14:26:55', null, 'demoWord.html', 'course_dj\\annex\\11a8b617-ff9b-4008-9dcf-a94225fca7e5.html', '999.0 B', null, 'html', '0', null, null, 'annex');
INSERT INTO `training_file` VALUES ('132be411-f64d-4229-8d23-cf6ebd61dd9a', '2019-08-29 16:53:33', '2019-08-29 17:04:41', null, '实验三报告模板： 自动顺序启动控制实验报告模板 .docx', 'course_dj\\REPORT\\132be411-f64d-4229-8d23-cf6ebd61dd9a.docx', '52.93 KB', null, 'docx', '0', 'db9e420d-813b-407b-a4ed-a31af6b1a128', 'EXAM', 'REPORT');
INSERT INTO `training_file` VALUES ('1f1522c1-53c0-42ec-8191-62b03b66de1a', '2019-08-30 13:55:13', '2019-08-30 13:55:13', null, 'demoWord.html', 'course_dj\\annex\\1f1522c1-53c0-42ec-8191-62b03b66de1a.html', '999.0 B', null, 'html', '0', null, null, 'annex');
INSERT INTO `training_file` VALUES ('21aef7da-a49c-497a-9d22-072978fedb85', '2019-08-30 13:47:59', '2019-08-30 13:47:59', null, 'demoWord.html', 'course_dj\\annex\\21aef7da-a49c-497a-9d22-072978fedb85.html', '999.0 B', null, 'html', '0', null, null, 'annex');
INSERT INTO `training_file` VALUES ('2af99e08-75fd-4657-a4fb-c730325bcd84', '2019-08-30 11:08:00', '2019-08-30 11:08:00', null, 'demoWord.pdf', 'course_dj\\guide\\2af99e08-75fd-4657-a4fb-c730325bcd84.pdf', '13.12 KB', null, 'pdf', '0', null, null, 'guide');
INSERT INTO `training_file` VALUES ('33d04814-38e7-4b25-a601-10971895500c', '2019-08-30 14:37:02', '2019-08-30 14:37:02', null, 'demoWord.html', 'course_dj\\annex\\33d04814-38e7-4b25-a601-10971895500c.html', '999.0 B', null, 'html', '0', null, null, 'annex');
INSERT INTO `training_file` VALUES ('52a6e629-12d0-42e0-bb9e-5d451bcb94db', '2019-08-27 19:09:47', '2019-08-27 19:09:47', null, 'git命令.txt', 'course_dj\\report\\52a6e629-12d0-42e0-bb9e-5d451bcb94db.txt', '112.0 B', null, 'txt', '0', null, null, 'report');
INSERT INTO `training_file` VALUES ('55023f88-db84-4a4c-8721-100592f1ae5a', '2019-08-27 19:15:32', '2019-08-29 16:47:00', null, 'git命令.txt', 'course_dj\\report\\55023f88-db84-4a4c-8721-100592f1ae5a.txt', '112.0 B', null, 'txt', '0', null, null, 'report');
INSERT INTO `training_file` VALUES ('5a6ee8e4-089e-42d1-8e5f-bd4070fe7b37', '2019-08-30 13:50:37', '2019-08-30 13:50:37', null, 'demoWord.html', 'course_dj\\annex\\5a6ee8e4-089e-42d1-8e5f-bd4070fe7b37.html', '999.0 B', null, 'html', '0', null, null, 'annex');
INSERT INTO `training_file` VALUES ('66f8f85e-174d-4f5d-b352-e0c314a58e5a', '2019-08-29 16:30:39', '2019-08-29 16:47:05', null, '实验三：自动顺序启动控制.pdf', 'course_dj\\MATERIAL\\66f8f85e-174d-4f5d-b352-e0c314a58e5a.pdf', '252.26 KB', null, 'pdf', '0', 'db9e420d-813b-407b-a4ed-a31af6b1a128', 'PRACTICE', 'MATERIAL');
INSERT INTO `training_file` VALUES ('6844b5ad-6a25-459c-8aae-3139b1edc5bf', '2019-08-30 14:15:57', '2019-08-30 14:15:57', null, 'demoWord.html', 'course_dj\\annex\\6844b5ad-6a25-459c-8aae-3139b1edc5bf.html', '999.0 B', null, 'html', '0', null, null, 'annex');
INSERT INTO `training_file` VALUES ('76f8c965-a6b9-497e-a56e-35d39d93d288', '2019-08-30 13:52:02', '2019-08-30 13:52:02', null, 'demoWord.html', 'course_dj\\annex\\76f8c965-a6b9-497e-a56e-35d39d93d288.html', '999.0 B', null, 'html', '0', null, null, 'annex');
INSERT INTO `training_file` VALUES ('77f93787-be8f-4797-98d8-c5c46f5d153d', '2019-08-30 13:57:05', '2019-08-30 13:57:05', null, 'demoWord.html', 'course_dj\\annex\\77f93787-be8f-4797-98d8-c5c46f5d153d.html', '999.0 B', null, 'html', '0', null, null, 'annex');
INSERT INTO `training_file` VALUES ('887baaf4-0115-4013-be43-bc87eeabaa89', '2019-08-30 13:58:15', '2019-08-30 13:58:15', null, 'demoWord.html', 'course_dj\\annex\\887baaf4-0115-4013-be43-bc87eeabaa89.html', '999.0 B', null, 'html', '0', null, null, 'annex');
INSERT INTO `training_file` VALUES ('8d63d94b-a1f7-4cad-843e-0ddb281a78b4', '2019-08-30 13:54:31', '2019-08-30 13:54:31', null, 'demoWord.html', 'course_dj\\annex\\8d63d94b-a1f7-4cad-843e-0ddb281a78b4.html', '999.0 B', null, 'html', '0', null, null, 'annex');
INSERT INTO `training_file` VALUES ('a4676b66-c990-4629-bdcf-8e861e3391c1', '2019-08-30 14:40:27', '2019-08-30 17:22:28', '2019-08-30 17:22:28', 'demoWord.html', 'course_dj\\annex\\a4676b66-c990-4629-bdcf-8e861e3391c1.html', '999.0 B', null, 'html', '0', 'db9e420d-813b-407b-a4ed-a31af6b1a128', 'TEACHING', 'ANNEX');
INSERT INTO `training_file` VALUES ('a5c2e4c0-e6bd-46b8-a5d1-4e77b300847e', '2019-08-30 14:45:24', '2019-08-30 14:45:24', null, 'demoWord.docx', 'course_dj\\material\\a5c2e4c0-e6bd-46b8-a5d1-4e77b300847e.docx', '10.13 KB', null, 'docx', '0', 'db9e420d-813b-407b-a4ed-a31af6b1a128', 'PRACTICE', 'MATERIAL');
INSERT INTO `training_file` VALUES ('ad243c33-cd55-4b04-9f33-b9eb2fdaa252', '2019-08-27 19:01:57', '2019-08-27 19:01:57', null, 'git命令.txt', 'course_dj\\report\\ad243c33-cd55-4b04-9f33-b9eb2fdaa252.txt', '112.0 B', null, 'txt', '0', null, null, 'report');
INSERT INTO `training_file` VALUES ('c2ea3b49-ffb9-47d6-b6c2-a7e1326c286c', '2019-08-29 16:31:13', '2019-08-29 16:47:08', null, '实验三报告模板： 自动顺序启动控制实验报告模板 .docx', 'course_dj\\MATERIAL\\c2ea3b49-ffb9-47d6-b6c2-a7e1326c286c.docx', '52.93 KB', null, 'docx', '0', 'db9e420d-813b-407b-a4ed-a31af6b1a128', 'PRACTICE', 'MATERIAL');
INSERT INTO `training_file` VALUES ('d67055a0-2bc7-4845-b4d5-49b87115f0ca', '2019-08-30 14:29:00', '2019-08-30 14:29:00', null, 'demoWord.html', 'course_dj\\annex\\d67055a0-2bc7-4845-b4d5-49b87115f0ca.html', '999.0 B', null, 'html', '0', null, null, 'annex');
INSERT INTO `training_file` VALUES ('d9fb41f5-62d8-4480-8e42-19feb9306f81', '2019-08-30 14:38:31', '2019-08-30 14:38:31', null, 'demoWord.html', 'course_dj\\annex\\d9fb41f5-62d8-4480-8e42-19feb9306f81.html', '999.0 B', null, 'html', '0', null, null, 'annex');
INSERT INTO `training_file` VALUES ('e3133f5c-4b3d-47a5-837f-1261275258f9', '2019-08-30 16:18:56', '2019-08-30 16:18:57', null, 'demoWord.pdf', 'course_dj\\material\\e3133f5c-4b3d-47a5-837f-1261275258f9.pdf', '13.12 KB', null, 'pdf', '0', 'db9e420d-813b-407b-a4ed-a31af6b1a128', 'PRACTICE', 'MATERIAL');
INSERT INTO `training_file` VALUES ('eadb9e70-7580-4519-8bea-ef3b4ddf1855', '2019-08-30 14:00:09', '2019-08-30 14:00:09', null, 'demoWord.html', 'course_dj\\annex\\eadb9e70-7580-4519-8bea-ef3b4ddf1855.html', '999.0 B', null, 'html', '0', null, null, 'annex');
INSERT INTO `training_file` VALUES ('f0228376-f119-45f2-adaf-f81f33f13d49', '2019-08-30 13:57:36', '2019-08-30 13:57:36', null, 'demoWord.html', 'course_dj\\annex\\f0228376-f119-45f2-adaf-f81f33f13d49.html', '999.0 B', null, 'html', '0', null, null, 'annex');
INSERT INTO `training_file` VALUES ('f266f470-0f39-423f-bb5e-614e75e9834e', '2019-08-30 14:30:25', '2019-08-30 14:30:25', null, 'demoWord.html', 'course_dj\\annex\\f266f470-0f39-423f-bb5e-614e75e9834e.html', '999.0 B', null, 'html', '0', null, null, 'annex');
INSERT INTO `training_file` VALUES ('f4b7d3f7-6536-45c4-86b3-923108f8ddd2', '2019-08-29 16:22:26', '2019-08-29 16:47:14', null, '实验六：异步电机两地控制指导书.pdf', 'course_dj\\ANNEX\\f4b7d3f7-6536-45c4-86b3-923108f8ddd2.pdf', '126.82 KB', null, 'pdf', '0', 'db9e420d-813b-407b-a4ed-a31af6b1a128', 'TEACHING', 'ANNEX');
INSERT INTO `training_file` VALUES ('fb0507b4-ddc6-4812-9f80-a26f1f095a45', '2019-08-29 16:22:06', '2019-08-29 16:47:24', null, '实验六：异步电机两地控制.docx', 'course_dj\\ANNEX\\fb0507b4-ddc6-4812-9f80-a26f1f095a45.docx', '55.48 KB', null, 'docx', '0', 'db9e420d-813b-407b-a4ed-a31af6b1a128', 'TEACHING', 'ANNEX');
INSERT INTO `training_file` VALUES ('fd0dbe6f-dab5-4e31-b94b-a4caeca80fde', '2019-08-30 11:06:06', '2019-08-30 11:06:06', null, 'demoWord.pdf', 'course_dj\\guide\\fd0dbe6f-dab5-4e31-b94b-a4caeca80fde.pdf', '13.12 KB', null, 'pdf', '0', null, null, 'guide');

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
INSERT INTO `training_module` VALUES ('835fae1e-1797-4e03-86be-5b0a5fdb1001', '2019-09-02 14:53:42', '2019-09-02 14:56:41', '2019-09-02 14:56:41', '123', '1');
INSERT INTO `training_module` VALUES ('a2bd580c-c9fe-11e9-81b8-7085c206b232', '2019-08-29 09:45:12', '2019-08-29 09:49:59', null, '虚拟实验', '1');
INSERT INTO `training_module` VALUES ('a3211198-c9fe-11e9-81b8-7085c206b232', '2019-08-29 09:45:12', '2019-08-29 09:50:00', null, '虚实结合实验', '1');
INSERT INTO `training_module` VALUES ('a37a2f9d-c9fe-11e9-81b8-7085c206b232', '2019-08-29 09:45:13', '2019-08-29 09:50:00', null, '低压电气', '1');
INSERT INTO `training_module` VALUES ('a3d8e0a7-c9fe-11e9-81b8-7085c206b232', '2019-08-29 09:45:14', '2019-08-29 09:50:01', null, '电气基本控制', '1');
INSERT INTO `training_module` VALUES ('a4d79855-c9fe-11e9-81b8-7085c206b232', '2019-08-29 09:45:15', '2019-08-29 09:50:01', null, '机床电气', '1');
INSERT INTO `training_module` VALUES ('d33648ee-c9fe-11e9-81b8-7085c206b232', '2019-08-29 09:46:33', '2019-08-29 09:50:03', null, 'PLC', '1');

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
INSERT INTO `training_sim` VALUES ('0aa51fe6-4ba9-4cc4-b850-3e4a2031793c', '2019-08-29 17:05:06', '2019-08-30 14:45:24', '2019-08-30 14:45:24', 'db9e420d-813b-407b-a4ed-a31af6b1a128', 'e6912264-936a-4fc7-9989-77019e08901f', 'PRACTICE');
INSERT INTO `training_sim` VALUES ('0d695a22-c167-4f9f-a8ec-0530d5544ffb', '2019-09-02 09:27:43', '2019-09-02 09:27:43', null, 'db9e420d-813b-407b-a4ed-a31af6b1a128', 'eeab7a44-b3b0-4288-bd27-dacb7ba6280d', 'EXAM');
INSERT INTO `training_sim` VALUES ('17d390b3-ea7a-4b17-a539-ae2d72ec33e2', '2019-08-29 17:03:02', '2019-08-29 17:04:15', '2019-08-29 17:04:15', 'db9e420d-813b-407b-a4ed-a31af6b1a128', '9247b50e-5f82-4c28-b9f7-faeaee8e0d47', 'EXAM');
INSERT INTO `training_sim` VALUES ('1863b94e-c432-4b86-96d7-b7521710bd33', '2019-08-29 17:04:15', '2019-08-29 17:04:41', '2019-08-29 17:04:41', 'db9e420d-813b-407b-a4ed-a31af6b1a128', 'c41a19a5-0b19-436f-8013-72a1a771b093', 'EXAM');
INSERT INTO `training_sim` VALUES ('35f248a5-08b0-43aa-907f-600958a514d8', '2019-09-02 09:20:42', '2019-09-02 09:20:42', null, 'db9e420d-813b-407b-a4ed-a31af6b1a128', '999ea144-8136-41b0-8d0a-3e5efaad97f7', 'PRACTICE');
INSERT INTO `training_sim` VALUES ('5ecbfadb-cdf1-4a26-a3f9-2fffad6f99be', '2019-09-02 14:00:20', '2019-09-02 14:00:20', null, 'c14313e7-dbe9-41c5-9eb6-f65dd381fff7', 'bdeaf9d4-817c-48b6-b2d1-3e97337afb81', 'PRACTICE');
INSERT INTO `training_sim` VALUES ('68cf1994-5757-46f0-8505-ba93516ba3af', '2019-08-29 17:04:41', '2019-08-30 14:53:02', '2019-08-30 14:53:02', 'db9e420d-813b-407b-a4ed-a31af6b1a128', '0ebbfaef-83ab-4d25-b00b-9fabed94a207', 'EXAM');
INSERT INTO `training_sim` VALUES ('6e175476-4733-4583-8a80-737964b39440', '2019-09-02 14:00:19', '2019-09-02 14:00:20', '2019-09-02 14:00:20', 'c14313e7-dbe9-41c5-9eb6-f65dd381fff7', '4f5e05fc-c29a-4958-83f2-12d78938d361', 'PRACTICE');
INSERT INTO `training_sim` VALUES ('bb9fb888-634d-47e0-a989-e547d537d15f', '2019-08-30 15:43:32', '2019-08-30 16:18:57', '2019-08-30 16:18:57', 'db9e420d-813b-407b-a4ed-a31af6b1a128', '990e529b-80a4-4683-91fa-6b00c5e3b534', 'PRACTICE');
INSERT INTO `training_sim` VALUES ('e6dd31dc-34b9-41c6-984a-cbfc5a7faf27', '2019-08-29 17:00:06', '2019-08-29 17:03:02', '2019-08-29 17:03:02', 'db9e420d-813b-407b-a4ed-a31af6b1a128', 'd006983b-1d96-4563-b110-f7ce449f4559', 'EXAM');

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
-- Table structure for unit
-- ----------------------------
DROP TABLE IF EXISTS `unit`;
CREATE TABLE `unit` (
  `id` varchar(36) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `chapter_id` varchar(36) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of unit
-- ----------------------------
INSERT INTO `unit` VALUES ('0012ec60-e79e-410b-bea8-981bcfc6d415', '2019-06-15 17:22:58', '2019-06-15 17:22:58', null, '直流电机的概述', '150d8a85-4ca5-4b3b-b50d-ae33ef082a3c', '2');
INSERT INTO `unit` VALUES ('002bcf82-7208-45d3-bba3-3ee2e64f0a44', '2019-06-09 10:15:24', '2019-06-09 10:15:24', null, '第二节', '3b2717a0-220c-49ac-9783-33ce31b1ce94', '2');
INSERT INTO `unit` VALUES ('01b11580-d60d-443e-84c0-f84d037d7e97', '2019-06-09 10:19:03', '2019-06-06 13:37:14', '2019-06-09 10:19:03', 'ooo', '996562a2-ca11-4428-b7a4-0923f75167be', '4');
INSERT INTO `unit` VALUES ('02d723c8-a355-467d-bb80-12ee9890220a', '2019-06-15 17:29:11', '2019-06-15 17:29:11', null, '三相异步电动机的故障分析及维护', '617c52a5-9de8-4f85-8bd9-07e949837dda', '6');
INSERT INTO `unit` VALUES ('03cc6b27-7483-4228-8751-bb6982648e5c', '2019-06-09 10:16:00', '2019-06-06 11:31:44', '2019-06-09 10:16:00', '第四节 unitIV', '3b2717a0-220c-49ac-9783-33ce31b1ce94', '5');
INSERT INTO `unit` VALUES ('05579db9-089d-4fcc-abb2-e75c9453a33c', '2019-06-15 17:32:05', '2019-06-15 17:32:05', null, '测速发电机', 'f4df4f5c-448a-4607-acb4-c4ed22ffadbd', '2');
INSERT INTO `unit` VALUES ('06641a7c-067e-4285-a986-a83ad63526b2', '2019-06-06 14:08:32', '2019-06-06 14:08:32', null, 'tuyuy', 'd933914d-8c02-4ac8-a33f-3c7aa4258660', '4');
INSERT INTO `unit` VALUES ('07a14cd1-fa54-415f-99b9-4e4c8f902529', '2019-06-15 17:21:52', '2019-06-15 17:21:52', null, '基本电气控制元件', '2eaf3657-4ff9-4028-a760-217d12896634', '3');
INSERT INTO `unit` VALUES ('08cc5480-840f-4c08-863f-d4a959dd2a3b', '2019-06-10 09:54:40', '2019-06-10 09:54:34', '2019-06-10 09:54:40', '第四节', '3b2717a0-220c-49ac-9783-33ce31b1ce94', '3');
INSERT INTO `unit` VALUES ('0a2f9176-9dd1-4af7-909b-5dd9cce27fbf', '2019-06-18 11:05:14', '2019-06-18 11:05:14', null, '第一节', 'bd5466fc-4cea-4c07-89a1-f3f1bd89d875', '1');
INSERT INTO `unit` VALUES ('0bd613ca-f01d-4f1c-b5d4-b1faa4ecc6e3', '2019-06-18 11:03:23', '2019-06-18 11:03:23', null, '第一节', '73a4bb1f-4967-4985-9453-daa2fd60d5c6', '1');
INSERT INTO `unit` VALUES ('0d26d896-a61b-4e40-a00b-defe76d2f9a6', '2019-06-10 09:55:18', '2019-06-10 09:55:18', null, '第一节', '996562a2-ca11-4428-b7a4-0923f75167be', '1');
INSERT INTO `unit` VALUES ('1886fea7-89e0-41e6-b370-b21ca09e686a', '2019-08-04 09:43:18', '2019-08-04 09:43:18', null, '111', '4ee6d0d4-3b36-4579-bb70-bf2663deaf47', '1');
INSERT INTO `unit` VALUES ('1a1aa0bf-9edd-47ba-9ed9-9d4e087611b7', '2019-06-04 15:23:43', '2019-06-04 15:14:34', null, '第二节 unit②', 'd933914d-8c02-4ac8-a33f-3c7aa4258660', '2');
INSERT INTO `unit` VALUES ('1c8274f1-1606-4722-ba56-3a87ad3bc0e8', '2019-06-09 10:10:23', '2019-06-04 15:12:19', '2019-06-09 10:10:23', '第二节 unitII', '3b2717a0-220c-49ac-9783-33ce31b1ce94', '1');
INSERT INTO `unit` VALUES ('24184815-9930-4d27-8fea-5c41ed8493fa', '2019-06-09 10:10:22', '2019-06-06 13:28:13', '2019-06-09 10:10:22', 'cc', '3b2717a0-220c-49ac-9783-33ce31b1ce94', '3');
INSERT INTO `unit` VALUES ('2515ac89-3df2-4a65-b537-b0a20375ac43', '2019-08-13 14:38:22', '2019-06-15 17:35:54', null, '气控制设备的工艺设计', '3e212bee-8b5a-4839-9d26-93d0d42926e8', '4');
INSERT INTO `unit` VALUES ('2684afa4-f11e-469e-913c-5996413c755a', '2019-06-10 09:55:26', '2019-06-09 12:00:59', '2019-06-10 09:55:26', '但是', '996562a2-ca11-4428-b7a4-0923f75167be', '2');
INSERT INTO `unit` VALUES ('2ec324e5-97d5-4d07-870e-e8e88643085e', '2019-06-09 16:07:02', '2019-06-09 16:07:02', null, '第一节', '8e6e9993-6b1f-4070-8bf5-c71efadcefcd', '4');
INSERT INTO `unit` VALUES ('31745125-9477-4f18-b123-ec265b8d4b5c', '2019-06-15 17:24:44', '2019-06-15 17:24:44', null, '单相变压器的负载运行分析', '0057331d-41a1-4a23-885e-819882f92639', '4');
INSERT INTO `unit` VALUES ('33283c0b-ff42-4401-8bbf-e42558121f7d', '2019-06-18 11:28:09', '2019-06-18 11:28:09', null, '第二节', 'bd5466fc-4cea-4c07-89a1-f3f1bd89d875', '2');
INSERT INTO `unit` VALUES ('37cbd1bf-fa21-4753-b5ec-5209a2124edd', '2019-06-15 17:21:46', '2019-06-15 17:21:46', null, '电力拖动系统机械负载的转矩特性', '2eaf3657-4ff9-4028-a760-217d12896634', '2');
INSERT INTO `unit` VALUES ('3ab18ac6-272c-4421-ba05-b89e76ed0acf', '2019-06-09 16:09:17', '2019-06-09 16:09:17', null, '第一节', '2bed9c3d-ae8d-4d5b-95b2-ce2faff46bed', '4');
INSERT INTO `unit` VALUES ('3f3e7b5a-6649-4b48-84b8-5666fe948a49', '2019-06-18 09:18:00', '2019-06-18 09:18:00', null, '第一节', '9cf30779-f849-40fe-ac1e-181e4b4b2c9d', '2');
INSERT INTO `unit` VALUES ('3fef7357-6f03-4e15-9d12-6e89566f0a53', '2019-08-04 09:44:06', '2019-08-04 09:44:06', null, '111', '539bcb2a-a949-4f27-9d42-6d7ebffcc7ec', '1');
INSERT INTO `unit` VALUES ('45357bac-1ca3-4ba2-b887-ebf27ac61fc3', '2019-08-04 09:49:40', '2019-08-04 09:48:28', '2019-08-04 09:49:40', '1111', '97d7eab4-43ae-475e-a24f-42971c796ec2', '2');
INSERT INTO `unit` VALUES ('48cc0d97-a7b1-416c-a248-faf9b02e8ed8', '2019-06-15 17:34:33', '2019-06-15 17:34:33', null, '电气控制系统图的类型及有关规定', '4dd86b8a-e913-46be-8712-f4c02e8c8fa5', '1');
INSERT INTO `unit` VALUES ('4c430a49-d474-4ddd-8636-768290aff002', '2019-06-15 17:30:55', '2019-06-15 17:30:55', null, '三相鼠笼异步电动机的启动与控制', 'eefdcebd-bc2a-428b-968f-c87ec9e8c6a4', '2');
INSERT INTO `unit` VALUES ('523dd830-cb8d-4dd3-a4e3-c9997a778694', '2019-06-18 09:18:15', '2019-06-18 09:18:15', null, '第二节', '9cf30779-f849-40fe-ac1e-181e4b4b2c9d', '1');
INSERT INTO `unit` VALUES ('528794fa-0ba8-489c-a279-f38793797378', '2019-06-15 17:24:26', '2019-06-15 17:24:26', null, '变压器概述', '0057331d-41a1-4a23-885e-819882f92639', '2');
INSERT INTO `unit` VALUES ('53a561e7-d538-46de-b615-e2435f098214', '2019-06-09 10:49:30', '2019-06-04 15:13:45', '2019-06-09 10:49:30', '第三节 unit3', '996562a2-ca11-4428-b7a4-0923f75167be', '3');
INSERT INTO `unit` VALUES ('57124e73-b34e-4aaa-a912-c71391784362', '2019-06-18 11:32:30', '2019-06-18 11:32:30', null, '第二节', '73a4bb1f-4967-4985-9453-daa2fd60d5c6', '2');
INSERT INTO `unit` VALUES ('58229827-5030-4cfc-9033-44c439095ced', '2019-06-09 16:07:22', '2019-06-09 16:07:22', null, '第一节', '63ccbe77-d93a-41c3-a121-d4b680546b92', '4');
INSERT INTO `unit` VALUES ('5d1ccc9e-d855-4329-9f0e-250fdc0cd6b6', '2019-06-09 12:02:59', '2019-06-06 16:45:23', null, '', '', '5');
INSERT INTO `unit` VALUES ('60961118-57de-43d5-b2e5-54fed832935c', '2019-06-15 17:31:18', '2019-06-15 17:31:18', null, '三相异步电动机的制动与控制', 'eefdcebd-bc2a-428b-968f-c87ec9e8c6a4', '8');
INSERT INTO `unit` VALUES ('6613fd70-8c64-41e9-b21f-2436af7e24bd', '2019-06-09 10:47:24', '2019-06-09 10:15:42', '2019-06-09 10:47:24', '第四节', '3b2717a0-220c-49ac-9783-33ce31b1ce94', '3');
INSERT INTO `unit` VALUES ('69aa12d2-b624-4186-98a2-bf32cd237532', '2019-08-13 14:38:22', '2019-06-15 17:35:43', null, '电力拖动方案的确定和电动机的选择', '3e212bee-8b5a-4839-9d26-93d0d42926e8', '2');
INSERT INTO `unit` VALUES ('6a1ffb0c-eabb-46af-9f11-5c502e3691fe', '2019-08-13 14:38:22', '2019-08-13 14:38:15', '2019-08-13 14:38:22', '11', '3e212bee-8b5a-4839-9d26-93d0d42926e8', '1');
INSERT INTO `unit` VALUES ('6cfad44a-72a7-4582-ad2b-8355768196aa', '2019-07-22 16:43:29', '2019-07-22 16:25:15', '2019-07-22 16:43:29', '测试1', '0d1aa77e-2255-4216-bd7e-2bd409c6d500', '1');
INSERT INTO `unit` VALUES ('75848b01-5dc5-4a48-b655-67c199fcbe7a', '2019-08-13 14:38:22', '2019-06-15 17:35:48', null, '电气控制原理线路设计的方法和步骤', '3e212bee-8b5a-4839-9d26-93d0d42926e8', '3');
INSERT INTO `unit` VALUES ('75b5ace1-5933-4518-9f0c-3ee1fc9d39e5', '2019-06-15 17:21:58', '2019-06-15 17:21:58', null, '基本控制电路环节', '2eaf3657-4ff9-4028-a760-217d12896634', '4');
INSERT INTO `unit` VALUES ('77b59a69-9d12-4439-92b2-7628198245db', '2019-06-04 15:23:44', '2019-06-04 15:14:18', null, '第一节 unit①', 'd933914d-8c02-4ac8-a33f-3c7aa4258660', '1');
INSERT INTO `unit` VALUES ('77c8285d-de40-4a7d-80fe-d5d3cbf8dc9d', '2019-06-18 09:17:02', '2019-06-18 09:17:02', null, '第一节', '6e3e3e29-6bba-42fd-b905-3ccff18aeb62', '1');
INSERT INTO `unit` VALUES ('7be0bdc3-4915-4184-bb89-40dff95cbeec', '2019-06-09 12:01:22', '2019-06-09 11:59:35', '2019-06-09 12:01:22', '为单位', '996562a2-ca11-4428-b7a4-0923f75167be', '2');
INSERT INTO `unit` VALUES ('7e3dc3cc-f46b-42b1-8067-ee95abcb3f3e', '2019-06-15 17:29:25', '2019-06-15 17:29:25', null, '三相同步电动机', '617c52a5-9de8-4f85-8bd9-07e949837dda', '8');
INSERT INTO `unit` VALUES ('7fc53fd6-019a-4481-984a-4fa53cc62b40', '2019-06-04 15:23:46', '2019-06-04 15:14:50', null, '第三节 unit③', 'd933914d-8c02-4ac8-a33f-3c7aa4258660', '3');
INSERT INTO `unit` VALUES ('8572f799-d7c9-450e-94b0-029649352a24', '2019-06-15 17:34:47', '2019-06-15 17:34:47', null, '普通车床的电气控制', '4dd86b8a-e913-46be-8712-f4c02e8c8fa5', '3');
INSERT INTO `unit` VALUES ('8a421c8f-30aa-46d6-88ea-49524a9affa5', '2019-06-18 09:59:02', '2019-06-18 09:59:02', null, '第一节', '1223ed80-c0cb-4e6d-95b5-879c5d09e7d6', '2');
INSERT INTO `unit` VALUES ('8ad72814-6e13-45a3-a240-5c0613978008', '2019-06-15 17:34:40', '2019-06-15 17:34:40', null, '电气控制线路分析基础', '4dd86b8a-e913-46be-8712-f4c02e8c8fa5', '2');
INSERT INTO `unit` VALUES ('8ccc4be6-24de-45d4-8bdc-bc994ecb06c7', '2019-06-15 17:24:59', '2019-06-15 17:24:59', null, '变压器的运行特性', '0057331d-41a1-4a23-885e-819882f92639', '6');
INSERT INTO `unit` VALUES ('8d8b5148-2135-4612-bc05-be180ac565bf', '2019-06-15 17:20:48', '2019-06-15 17:20:48', null, '电力拖动系统的概述', '2eaf3657-4ff9-4028-a760-217d12896634', '1');
INSERT INTO `unit` VALUES ('9693e125-4e60-47c4-8bf8-f88cb6dde777', '2019-06-15 17:24:34', '2019-06-15 17:24:34', null, '变压器的空载运行分析', '0057331d-41a1-4a23-885e-819882f92639', '3');
INSERT INTO `unit` VALUES ('985d2850-a23b-418d-8ee9-81a06d7e7b1f', '2019-06-15 17:30:47', '2019-06-15 17:30:47', null, '三相异步电动机的机械特性', 'eefdcebd-bc2a-428b-968f-c87ec9e8c6a4', '1');
INSERT INTO `unit` VALUES ('99b240d6-1767-4dbe-9ecb-3b54cede0dde', '2019-06-16 14:18:41', '2019-06-16 14:18:41', null, '123', '1abe3279-bb81-4a04-b468-b328ca9dc5d8', '1');
INSERT INTO `unit` VALUES ('9c15258a-7361-4ecd-80ff-080c6edb8360', '2019-06-15 17:31:59', '2019-06-15 17:31:59', null, '伺服电动机', 'f4df4f5c-448a-4607-acb4-c4ed22ffadbd', '1');
INSERT INTO `unit` VALUES ('9c237578-d478-47eb-a1f6-98480083afba', '2019-06-15 17:35:07', '2019-06-15 17:35:07', null, '起重机械电气控制线路分析', '4dd86b8a-e913-46be-8712-f4c02e8c8fa5', '10');
INSERT INTO `unit` VALUES ('a9831159-514a-4210-a498-60887b0f5e82', '2019-06-10 09:54:40', '2019-06-09 17:32:30', null, '第三节', '3b2717a0-220c-49ac-9783-33ce31b1ce94', '3');
INSERT INTO `unit` VALUES ('ac96018c-26e7-4ae4-9730-cb7240b5ba4d', '2019-06-15 17:31:04', '2019-06-15 17:31:04', null, '三相绕线转子异步电动机的启动与控制', 'eefdcebd-bc2a-428b-968f-c87ec9e8c6a4', '3');
INSERT INTO `unit` VALUES ('afe9a5cc-39f0-42e4-9236-c16735ec2795', '2019-06-15 17:23:34', '2019-06-15 17:23:34', null, '直流发电机简介', '150d8a85-4ca5-4b3b-b50d-ae33ef082a3c', '6');
INSERT INTO `unit` VALUES ('b2410206-b86a-4fe4-8067-7f26801a1215', '2019-06-09 10:10:51', '2019-06-06 13:35:12', '2019-06-09 10:10:51', 'qq', '3b2717a0-220c-49ac-9783-33ce31b1ce94', '2');
INSERT INTO `unit` VALUES ('b2d33b10-641b-4076-a6d3-bb961936526f', '2019-06-15 17:31:11', '2019-06-15 17:31:11', null, '三相异步电动机的调速与控制', 'eefdcebd-bc2a-428b-968f-c87ec9e8c6a4', '4');
INSERT INTO `unit` VALUES ('b68b3742-e0d6-4c4e-86be-3e70d4352e69', '2019-06-15 17:28:41', '2019-06-15 17:28:41', null, '三相异步电动机的电路分析', '617c52a5-9de8-4f85-8bd9-07e949837dda', '3');
INSERT INTO `unit` VALUES ('b93d9c4c-67f3-4ed8-9ecb-12f7145181f9', '2019-06-15 17:32:10', '2019-06-15 17:32:10', null, '步进电动机', 'f4df4f5c-448a-4607-acb4-c4ed22ffadbd', '3');
INSERT INTO `unit` VALUES ('bb4b78af-e041-40c9-8034-4f2b11b5c5cc', '2019-06-15 17:28:31', '2019-06-15 17:28:31', null, '交流电机的定子绕组', '617c52a5-9de8-4f85-8bd9-07e949837dda', '2');
INSERT INTO `unit` VALUES ('bcf57a41-9a51-4609-ab45-4d141f3c2d77', '2019-06-15 17:23:25', '2019-06-15 17:23:25', null, '直流电动机', '150d8a85-4ca5-4b3b-b50d-ae33ef082a3c', '5');
INSERT INTO `unit` VALUES ('bfae5d5b-2ed2-4052-903a-e34123558111', '2019-06-15 17:29:04', '2019-06-15 17:29:04', null, '三相异步电动机的工作特性及参数测定', '617c52a5-9de8-4f85-8bd9-07e949837dda', '5');
INSERT INTO `unit` VALUES ('c70254ec-a64e-4372-ac7b-9df55c524f5a', '2019-08-06 16:35:40', '2019-08-06 16:35:40', null, '33333', 'b23b1ae8-aa2e-47ac-820e-a5949e0d63e2', '1');
INSERT INTO `unit` VALUES ('cd738805-8692-480b-80aa-51e52dbad282', '2019-06-15 17:23:07', '2019-06-15 17:23:07', null, '直流电机的电枢绕组', '150d8a85-4ca5-4b3b-b50d-ae33ef082a3c', '3');
INSERT INTO `unit` VALUES ('cf35be3c-dedb-48e9-ab8e-808e1e7a958a', '2019-08-13 14:38:22', '2019-06-15 17:35:22', null, '电气控制线路设计的一般原则和基本内容', '3e212bee-8b5a-4839-9d26-93d0d42926e8', '1');
INSERT INTO `unit` VALUES ('cf9d9a2c-6efd-4474-b775-7a8478087535', '2019-06-09 10:39:58', '2019-06-09 10:15:52', '2019-06-09 10:39:58', '第五节', '3b2717a0-220c-49ac-9783-33ce31b1ce94', '4');
INSERT INTO `unit` VALUES ('d46f0fa4-0ef5-425f-b881-858641c85b6e', '2019-06-09 12:02:59', '2019-06-06 15:54:46', null, '', '', '6');
INSERT INTO `unit` VALUES ('d67fea4f-c24c-445d-baa3-b06d515970da', '2019-06-09 15:28:40', '2019-06-09 15:28:40', null, '第一节', '3b2717a0-220c-49ac-9783-33ce31b1ce94', '1');
INSERT INTO `unit` VALUES ('d68dcc37-ee09-4c25-9cac-c82de31b3bdc', '2019-06-09 10:09:49', '2019-06-06 14:07:19', '2019-06-09 10:09:49', '3367', '3b2717a0-220c-49ac-9783-33ce31b1ce94', '3');
INSERT INTO `unit` VALUES ('d79751a0-a780-48c0-aa1d-d404baf6118c', '2019-06-06 14:08:32', '2019-06-06 13:24:33', null, 'aa', 'd933914d-8c02-4ac8-a33f-3c7aa4258660', '5');
INSERT INTO `unit` VALUES ('d975460a-6b38-4b6a-9168-38d6f0807f50', '2019-06-15 17:32:17', '2019-06-15 17:32:17', null, '直线电动机', 'f4df4f5c-448a-4607-acb4-c4ed22ffadbd', '4');
INSERT INTO `unit` VALUES ('daada256-1dba-48f3-b836-7df66328a49d', '2019-06-15 17:24:52', '2019-06-15 17:24:52', null, '变压器参数的试验测定', '0057331d-41a1-4a23-885e-819882f92639', '5');
INSERT INTO `unit` VALUES ('e0f15736-136f-4d01-9f84-4e55b8e16bcb', '2019-06-15 17:34:53', '2019-06-15 17:34:53', null, '铣床的电气控制', '4dd86b8a-e913-46be-8712-f4c02e8c8fa5', '4');
INSERT INTO `unit` VALUES ('e149ad38-cab7-4a32-89df-0269db199b68', '2019-06-09 10:03:57', '2019-06-04 15:11:57', '2019-06-09 10:03:57', '第一节 unitI', '3b2717a0-220c-49ac-9783-33ce31b1ce94', '1');
INSERT INTO `unit` VALUES ('e2667fe5-6be2-42cc-9a52-58fa700d8d0b', '2019-06-15 17:29:17', '2019-06-15 17:29:17', null, '单相异步电动机', '617c52a5-9de8-4f85-8bd9-07e949837dda', '7');
INSERT INTO `unit` VALUES ('e4348e92-c833-4b5c-a485-44691760d598', '2019-06-15 17:23:16', '2019-06-15 17:23:16', null, '直流电机的磁场分布与换向的改善', '150d8a85-4ca5-4b3b-b50d-ae33ef082a3c', '4');
INSERT INTO `unit` VALUES ('e753eaff-6067-4bcf-80e7-fddd1c8436f3', '2019-06-15 17:35:00', '2019-06-15 17:35:00', null, '磨床的电液控制', '4dd86b8a-e913-46be-8712-f4c02e8c8fa5', '5');
INSERT INTO `unit` VALUES ('e869968c-ed6d-45ba-ba5e-8620b835916c', '2019-06-15 17:28:54', '2019-06-15 17:28:54', null, '三相异步电动机的功率与电磁转矩', '617c52a5-9de8-4f85-8bd9-07e949837dda', '4');
INSERT INTO `unit` VALUES ('e8779ab7-2d2a-4ea0-b668-31ae35965e37', '2019-08-04 09:52:59', '2019-08-04 09:48:36', '2019-08-04 09:52:59', '1222', '97d7eab4-43ae-475e-a24f-42971c796ec2', '1');
INSERT INTO `unit` VALUES ('e9cd09d4-4135-44a0-996a-bd05bcf89b84', '2019-06-18 11:29:34', '2019-06-18 11:29:34', null, '第三节', 'bd5466fc-4cea-4c07-89a1-f3f1bd89d875', '3');
INSERT INTO `unit` VALUES ('eb4b4ef5-be40-43ad-9a49-75fce0f52ce6', '2019-06-18 09:49:52', '2019-06-18 09:49:52', null, '第一节', 'dc85ae93-4fb7-4a1f-9259-48a06fe68930', '1');
INSERT INTO `unit` VALUES ('ecd3e379-40bf-42fe-9f4d-7cdc8220444d', '2019-06-15 17:32:23', '2019-06-15 17:32:23', null, '自整角机', 'f4df4f5c-448a-4607-acb4-c4ed22ffadbd', '5');
INSERT INTO `unit` VALUES ('eec639b8-0cb2-4fb7-b9d8-5619034d7c0f', '2019-06-15 17:22:04', '2019-06-15 17:22:04', null, '常用低压电器的结构和工作原理', '2eaf3657-4ff9-4028-a760-217d12896634', '8');
INSERT INTO `unit` VALUES ('f564121c-8665-40ce-b7ec-d8c2e180a685', '2019-06-09 12:01:12', '2019-06-09 10:15:33', '2019-06-09 12:01:12', '第三节', '3b2717a0-220c-49ac-9783-33ce31b1ce94', '2');
INSERT INTO `unit` VALUES ('f61797b2-aa27-4f5f-81af-6b016330a1d3', '2019-06-09 12:02:59', '2019-06-09 12:02:59', null, '', '', '4');
INSERT INTO `unit` VALUES ('f7a8c722-fcb8-402c-a96a-2981c9376bbb', '2019-06-18 11:33:36', '2019-06-18 11:33:36', null, '地方', 'bd5466fc-4cea-4c07-89a1-f3f1bd89d875', '4');
INSERT INTO `unit` VALUES ('fc2ea4b9-6ca3-4a29-8cd5-9c6c610ff7ae', '2019-06-15 17:28:14', '2019-06-15 17:28:14', null, '三相异步电动机的工作原理和结构', '617c52a5-9de8-4f85-8bd9-07e949837dda', '1');
INSERT INTO `unit` VALUES ('fc5e449f-a3b8-4b0c-a64a-e84f5039d8a8', '2019-08-04 09:53:28', '2019-08-04 09:53:11', '2019-08-04 09:53:28', '111', '97d7eab4-43ae-475e-a24f-42971c796ec2', '1');
INSERT INTO `unit` VALUES ('ffb28893-97ae-4de2-a1ae-c2da0406edc5', '2019-06-09 17:35:22', '2019-06-09 17:35:22', null, '第一节', '5149652b-4791-46ed-9403-d550a69885c2', '1');

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
