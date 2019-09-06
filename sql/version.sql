/*
Navicat MySQL Data Transfer

Source Server         : fuwuqi
Source Server Version : 50562
Source Host           : 192.168.2.200:3306
Source Database       : creator_account

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-09-06 11:31:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for version
-- ----------------------------
DROP TABLE IF EXISTS `version`;
CREATE TABLE `version` (
  `id` varchar(36) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `item_id` varchar(36) DEFAULT NULL,
  `bulletin` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of version
-- ----------------------------
INSERT INTO `version` VALUES ('05aede84-5875-4a2d-8064-64eb6c385c7c', '2019-09-05 17:47:11', '2019-09-06 09:33:42', null, 'V1.0', '743e4823-f506-48e7-aba3-d3aab1b1aaf7', 'CubeEducation 仿真实训综合管理平台');
INSERT INTO `version` VALUES ('3cca188b-879c-47c2-9b45-4658aa503788', '2019-09-05 17:48:03', '2019-09-05 17:48:11', '2019-09-05 17:48:11', 'V1.0', '651a98fd-b1b4-4957-a88b-82823cc188f1', null);
INSERT INTO `version` VALUES ('54ddeec2-12fb-4c7a-bbc8-3b55c2beaee3', '2019-09-05 17:45:17', '2019-09-05 17:45:41', '2019-09-05 17:45:41', 'demo1', '214b1c27-1c30-45f4-a285-798e8d383bf4', null);
INSERT INTO `version` VALUES ('7328fd0f-4a38-4ede-adab-38c2a98f6c4e', '2019-09-05 17:48:32', '2019-09-05 17:51:37', '2019-09-05 17:51:37', 'V0.1', '651a98fd-b1b4-4957-a88b-82823cc188f1', null);
INSERT INTO `version` VALUES ('73841c18-310a-4b6b-a0ce-cbfecb94e200', '2019-09-05 17:51:58', '2019-09-05 17:51:58', null, 'V1.0', '76264234-2e30-4b52-8176-52b3998b3ce2', null);
INSERT INTO `version` VALUES ('cad64f6e-d3d9-444c-88f3-15d8d5aa1967', '2019-09-05 17:47:54', '2019-09-06 09:38:50', null, 'V0.1', '651a98fd-b1b4-4957-a88b-82823cc188f1', '使用说明：\n软件首次打开需要软件授权，如有需要，请联系同立方科技研发部索取授权码。\n联系人：王登威 \n联系方式：418043944（QQ号码）');
INSERT INTO `version` VALUES ('dd799cd4-e2ef-49cd-8d43-69b6414020bc', '2019-09-05 17:48:55', '2019-09-05 17:52:08', '2019-09-05 17:52:08', 'V0.9', '192f35c9-cd86-4cdc-b0ab-1e369a17e264', null);
INSERT INTO `version` VALUES ('e5a9c1e6-0267-47a3-8e59-8f660b41e39e', '2019-09-05 17:51:44', '2019-09-06 09:32:51', '2019-09-06 09:32:51', 'V1.0', '651a98fd-b1b4-4957-a88b-82823cc188f1', null);
INSERT INTO `version` VALUES ('ebb528d7-b93d-441f-b153-cc03a10c94fe', '2019-09-05 17:49:07', '2019-09-05 17:51:50', '2019-09-05 17:51:50', 'V0.5', '76264234-2e30-4b52-8176-52b3998b3ce2', null);
INSERT INTO `version` VALUES ('f590f6e2-4c18-4808-801f-ed229d2f020f', '2019-09-05 17:52:14', '2019-09-05 17:52:14', null, 'V1.0', '192f35c9-cd86-4cdc-b0ab-1e369a17e264', null);
