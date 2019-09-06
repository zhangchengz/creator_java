/*
Navicat MySQL Data Transfer

Source Server         : fuwuqi
Source Server Version : 50562
Source Host           : 192.168.2.200:3306
Source Database       : course_dj

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-09-06 11:25:40
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
INSERT INTO `component_group` VALUES ('4b6682db-a980-4677-874a-22483831429e', '2019-06-11 17:50:44', '2019-06-11 17:50:44', null, '开关及保护元件', '\r\nSwitch and protection component');
INSERT INTO `component_group` VALUES ('7d796865-c1e8-44af-b6a6-ee7672f9882c', '2019-06-11 17:50:07', '2019-06-11 17:50:07', null, '电源元件', '\r\nPower supply component');
INSERT INTO `component_group` VALUES ('7fc19d4b-1bc6-4c8d-b419-5a14b82f9bd3', '2019-06-14 11:22:37', '2019-06-14 11:22:37', null, '工具', 'Tool');
INSERT INTO `component_group` VALUES ('8a219432-3dae-4e90-b368-128b6b275d76', '2019-06-12 11:29:00', '2019-06-12 11:29:00', null, '电机元件', 'Motor component');
INSERT INTO `component_group` VALUES ('a796bedc-aae0-441e-963a-083ca469a603', '2019-06-11 17:49:01', '2019-06-11 17:49:01', null, '接触器及继电器元件', 'Contactor and relay components');

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
INSERT INTO `training` VALUES ('56699663-25af-4647-b0ba-49e36ae35a3f', '2019-09-04 11:36:26', '2019-09-04 11:37:18', null, null, '25da96b4-c9fe-11e9-81b8-7085c206b232', 'demo', '0', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, '[]');
INSERT INTO `training` VALUES ('6f6c69ca-1cc2-4021-97a1-5305a353860a', '2019-09-04 14:56:31', '2019-09-04 14:56:31', null, null, '', '123', '0', '268de5dc-f84b-4833-acb5-6ebf7970a28a', null, null, null);

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
INSERT INTO `training_file` VALUES ('0d0390ea-7a28-4ee9-8834-3b900bfc249a', '2019-09-04 11:37:17', '2019-09-04 11:37:18', null, 'demoWord.docx', 'course_dj\\report\\0d0390ea-7a28-4ee9-8834-3b900bfc249a.docx', '10.13 KB', null, 'docx', '0', '56699663-25af-4647-b0ba-49e36ae35a3f', 'EXAM', 'REPORT');

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
