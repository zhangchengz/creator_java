/*
Navicat MySQL Data Transfer

Source Server         : fuwuqi
Source Server Version : 50562
Source Host           : 192.168.2.200:3306
Source Database       : creator_account

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-09-06 11:31:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for document
-- ----------------------------
DROP TABLE IF EXISTS `document`;
CREATE TABLE `document` (
  `id` varchar(36) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `version_id` varchar(36) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of document
-- ----------------------------
INSERT INTO `document` VALUES ('063b0584-75df-4252-96e2-74830eb2e8cf', '2019-09-05 19:09:55', '2019-09-05 19:10:08', '2019-09-05 19:10:08', '实验六：异步电机两地控制.docx', '55.48 KB', 'docx', 'cad64f6e-d3d9-444c-88f3-15d8d5aa1967', '063b0584-75df-4252-96e2-74830eb2e8cf.docx');
INSERT INTO `document` VALUES ('22790d29-d830-48f6-a3da-2e98c520247c', '2019-09-05 18:59:17', '2019-09-05 19:09:14', '2019-09-05 19:09:14', '实验六  异步电机两地控制.cc3d', '12.99 KB', 'cc3d', 'cad64f6e-d3d9-444c-88f3-15d8d5aa1967', '22790d29-d830-48f6-a3da-2e98c520247c.cc3d');
INSERT INTO `document` VALUES ('3c473c93-5326-4fb4-9321-080e536e3add', '2019-09-06 09:16:39', '2019-09-06 09:30:54', '2019-09-06 09:30:54', '《自动化产线机电装调技术》产品白皮书.docx', '6.1 MB', 'docx', 'e5a9c1e6-0267-47a3-8e59-8f660b41e39e', '3c473c93-5326-4fb4-9321-080e536e3add.docx');
INSERT INTO `document` VALUES ('40491f43-626e-496d-9a8f-500c68d38d86', '2019-09-06 09:31:06', '2019-09-06 09:31:13', '2019-09-06 09:31:13', '《自动化产线机电装调技术》产品白皮书.docx', '6.1 MB', 'docx', 'e5a9c1e6-0267-47a3-8e59-8f660b41e39e', '40491f43-626e-496d-9a8f-500c68d38d86.docx');
INSERT INTO `document` VALUES ('52acb3f6-60e3-4d8e-8693-53794c248ecb', '2019-09-06 09:31:20', '2019-09-06 09:31:20', null, '《自动化产线机电装调技术》产品白皮书.docx', '6.1 MB', 'docx', 'cad64f6e-d3d9-444c-88f3-15d8d5aa1967', '52acb3f6-60e3-4d8e-8693-53794c248ecb.docx');
INSERT INTO `document` VALUES ('6df0d659-dccf-4b62-9fba-a610b1bd06fe', '2019-09-05 19:12:49', '2019-09-05 19:13:09', '2019-09-05 19:13:09', '实验六  异步电机两地控制.cc3d', '12.99 KB', 'cc3d', 'cad64f6e-d3d9-444c-88f3-15d8d5aa1967', '6df0d659-dccf-4b62-9fba-a610b1bd06fe.cc3d');
INSERT INTO `document` VALUES ('b3146fb3-fbae-4923-b02f-d4c3c9e43fd3', '2019-09-06 09:39:50', '2019-09-06 09:39:50', null, '《CubeEducation仿真实训综合管理平台》技术白皮书.docx', '127.64 KB', 'docx', '05aede84-5875-4a2d-8064-64eb6c385c7c', 'b3146fb3-fbae-4923-b02f-d4c3c9e43fd3.docx');
INSERT INTO `document` VALUES ('bf90d992-0326-4f65-b6f9-aad25de02b74', '2019-09-05 19:16:57', '2019-09-05 19:18:01', '2019-09-05 19:18:01', 'creator_java-master.zip', '177.11 MB', 'zip', 'cad64f6e-d3d9-444c-88f3-15d8d5aa1967', 'bf90d992-0326-4f65-b6f9-aad25de02b74.zip');
INSERT INTO `document` VALUES ('d4204a1e-7b2b-4591-bb36-d2b9cff879e3', '2019-09-06 09:16:19', '2019-09-06 09:16:19', null, '《电气控制与PLC应用技术》技术白皮书.docx', '103.98 KB', 'docx', 'f590f6e2-4c18-4808-801f-ed229d2f020f', 'd4204a1e-7b2b-4591-bb36-d2b9cff879e3.docx');
INSERT INTO `document` VALUES ('e3152f11-4e83-42f5-844f-3d06ccb36a62', '2019-09-05 19:09:19', '2019-09-05 19:09:44', '2019-09-05 19:09:44', '实验六  异步电机两地控制.cc3d', '12.99 KB', 'cc3d', 'cad64f6e-d3d9-444c-88f3-15d8d5aa1967', 'e3152f11-4e83-42f5-844f-3d06ccb36a62.cc3d');
INSERT INTO `document` VALUES ('f6f5f4a7-81ea-41f3-ba79-95ac34572598', '2019-09-06 09:16:03', '2019-09-06 09:39:41', '2019-09-06 09:39:41', '《CubeEducation仿真实训综合管理平台》技术白皮书V1.0.docx', '127.64 KB', 'docx', '05aede84-5875-4a2d-8064-64eb6c385c7c', 'f6f5f4a7-81ea-41f3-ba79-95ac34572598.docx');
INSERT INTO `document` VALUES ('fe7290b5-641e-4295-9182-0c919e974a0b', '2019-09-06 09:09:57', '2019-09-06 09:09:57', null, '自动化产线机电装调技术Demo.zip', '36.95 MB', 'zip', 'cad64f6e-d3d9-444c-88f3-15d8d5aa1967', 'fe7290b5-641e-4295-9182-0c919e974a0b.zip');
