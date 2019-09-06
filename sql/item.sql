/*
Navicat MySQL Data Transfer

Source Server         : fuwuqi
Source Server Version : 50562
Source Host           : 192.168.2.200:3306
Source Database       : creator_account

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-09-06 11:31:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` varchar(36) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('192f35c9-cd86-4cdc-b0ab-1e369a17e264', '2019-09-05 17:47:31', '2019-09-05 17:47:31', null, '电气控制与PLC应用技术');
INSERT INTO `item` VALUES ('214b1c27-1c30-45f4-a285-798e8d383bf4', '2019-09-05 17:44:35', '2019-09-05 17:45:46', '2019-09-05 17:45:46', 'demo');
INSERT INTO `item` VALUES ('651a98fd-b1b4-4957-a88b-82823cc188f1', '2019-09-05 17:47:36', '2019-09-05 17:47:36', null, '自动化产线机电装调技术');
INSERT INTO `item` VALUES ('743e4823-f506-48e7-aba3-d3aab1b1aaf7', '2019-09-05 17:46:52', '2019-09-05 17:46:52', null, 'CubeEducation');
INSERT INTO `item` VALUES ('76264234-2e30-4b52-8176-52b3998b3ce2', '2019-09-05 17:47:43', '2019-09-05 17:47:43', null, '昌平项目');
