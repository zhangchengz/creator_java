/*
Navicat MySQL Data Transfer

Source Server         : fuwuqi
Source Server Version : 50562
Source Host           : 192.168.2.200:3306
Source Database       : course_plc

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-09-06 11:26:13
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
INSERT INTO `component` VALUES ('091d0183-c56b-442f-a301-94b51346f925', '2019-08-17 11:56:54', '2019-08-20 16:45:01', null, '接触器（CJX2-18-10-M）', 'a57f3b60-bb55-11e9-b3b8-1c1b0dfbee1c', '接触器广义上是指工业电中利用线圈流过电流产生磁场，使触头闭合，以达到控制负载的电器。接触器的工作原理就是通过控制接在控制电路的辅助触点的通断来控制接在主电路的主触点的通断以达到控制电路的要求。', '名称：通用型交流接触器\n品牌：德力西电气有限公司\n电流规格：18A\n线圈电压：220V\n额定频率：50Hz\n辅助触点：一对常开触点\n', 'component_schematic/55323120-2129-42a7-8754-b1fc0e950315.png', 'CJX2-18-10-M', null, null, 'component_icon/a67ec296-6e72-40e4-b415-d685f67b5247.png', '德力西');
INSERT INTO `component` VALUES ('0d7b2813-4b48-433f-bf98-03093e1d5f02', '2019-08-17 11:51:37', '2019-08-20 16:45:01', null, '熔断器（RT18-32-3P-X- 10）', 'a52648bd-bb55-11e9-b3b8-1c1b0dfbee1c', '熔断器是根据电流超过规定值一段时间后，以其自身产生的热量使熔体熔化，从而使电路断开；运用这种原理制成的一种电流保护器。线路正常工作时，熔体不应熔断，当电路发生短路，熔体立即熔断，以保护电路及用电设备不遭损坏。熔断器广泛应用于高低压配电系统和控制系统以及用电设备中，作为短路和过电流的保护器，是应用最普遍的保护器件之一。', '名称：圆筒形帽熔断器\r品牌：德力西电气有限公司\r电流规格：10A\r熔断器电流：32A\r分断能力：100kA\r额定散耗功率：≤ 3W\r熔断体电流：10A\r额定电压：380~500V AC', 'component_schematic/7760a70a-73ee-4740-be4d-56a3f0674622.png', 'RT18-32-3P-X-10', null, null, 'component_icon/fc905863-e176-4b20-8ec6-03ca009a19e9.png', '德力西');
INSERT INTO `component` VALUES ('144061be-04e4-4fc0-98c8-fcb0e60c9f64', '2019-08-17 11:55:43', '2019-08-20 16:45:01', null, '接触器（CJX2-9-10-M）', 'a57f3b60-bb55-11e9-b3b8-1c1b0dfbee1c', '接触器广义上是指工业电中利用线圈流过电流产生磁场，使触头闭合，以达到控制负载的电器。接触器的工作原理就是通过控制接在控制电路的辅助触点的通断来控制接在主电路的主触点的通断以达到控制电路的要求。', '名称：通用型交流接触器\n品牌：德力西电气有限公司\n电流规格：9A\n线圈电压：220V\n额定频率：50Hz\n辅助触点：一对常开触点\n', 'component_schematic/126e22e5-d198-415f-a267-93a3a063cbf0.png', 'CJX2-09-10-M', null, null, 'component_icon/680685dd-168d-41d1-8122-bb577ed05072.png', '德力西');
INSERT INTO `component` VALUES ('157e86c8-2277-4024-b085-e95f488b6e21', '2019-08-17 11:43:05', '2019-08-20 16:45:01', null, '空气开关（HDBE-63-4P-C10）', 'a4d857a1-bb55-11e9-b3b8-1c1b0dfbee1c', '空气开关也就是空气断路器，在电路中作接通、分断和承载额定工作电流和短路、过载等故障电流，并能在线路和负载发生过载、短路、欠压等情况下，迅速分断电路，进行可靠的保护。', '名称：德力西断路器4P\n品牌：德力西电气有限公司\n额定电流：10A\n灭弧方式：压缩空气断路器\n功能：短路过载、过载保护\n极数：4P\n温度：-20 ℃ ~ 60 ℃', 'component_schematic/f9ef1e54-788e-4d34-9354-14f2472ba0ca.png', 'HDBE-63-4P-C10', null, null, 'component_icon/3295b9e7-3729-4fc0-8562-c78a0fa5b451.png', '德力西');
INSERT INTO `component` VALUES ('16cc4f15-1987-4edf-9b20-74f57e1f341c', '2019-08-17 11:47:41', '2019-08-20 16:45:01', null, '熔断器（RT18-32-3P-X- 4）', 'a52648bd-bb55-11e9-b3b8-1c1b0dfbee1c', '熔断器是根据电流超过规定值一段时间后，以其自身产生的热量使熔体熔化，从而使电路断开；运用这种原理制成的一种电流保护器。线路正常工作时，熔体不应熔断，当电路发生短路，熔体立即熔断，以保护电路及用电设备不遭损坏。熔断器广泛应用于高低压配电系统和控制系统以及用电设备中，作为短路和过电流的保护器，是应用最普遍的保护器件之一。', '名称：圆筒形帽熔断器\n品牌：德力西电气有限公司\n电流规格：4A\n熔断器电流：32A\n分断能力：100kA\n额定散耗功率：≤ 3W\n熔断体电流：4A\n额定电压：380~500V AC\n其他参数：开启式，单个支持见具有隔离电源的功能', 'component_schematic/3cc93784-76e9-45c5-8dd4-e7cf8e5b02c2.png', 'RT18-32-3P-X-4', null, null, 'component_icon/f61864f9-a4fa-4af7-8743-cc9e90d9d88c.png', '德力西');
INSERT INTO `component` VALUES ('206206ab-8726-4f35-9cc8-4fe0df31dde6', '2019-08-17 12:08:25', '2019-08-20 16:45:01', null, '时间继电器（JSZ3A-B-10）', 'a62770e4-bb55-11e9-b3b8-1c1b0dfbee1c', '时间继电器的特点是自吸引线圈得到信号起至触头动作中间有一段延时。时间继电器一般用于以时间为函数的电动机起动过程控制。\n时间继电器的主要功能是作为简单程序控制中的一种执行器件，当它接受了启动信号后开始计时，计时结束后它的工作触头进行开或合的动作，从而推动后续的电路工作。一般来说，时间继电器的延时性能在设计的范围内是可以调节的，从而方便调整它的延时时间长短。单凭一只时间继电器恐怕不能做到开始延时闭合，闭合一段时间后，再断开，先实现延时闭合后延时断开，但总体上说，通过配置一定数量的时间继电器和中间继电器都是可以做到的。\n\n根据其延时方式的不同，时间继电器又可分为通电延时型和断电延时型两种。\n通电延时型时间继电器在获得输入信号后立即开始延时，需待延时完毕，其执行部分才输出信号以操纵控制电路；当输入信号消失后，继电器立即恢复到动作前的状态。\n(2)断电延时型时间继电器恰恰相反，当获得输入信号后，执行部分立即有输出信号；而在输入信号消失后，继电器却需要经过一定的延时，才能恢复到动作前的状态。\n', '品牌：德力西\n型号：JSZ3A-B:10\n额定控制电源电压：220V\n延时范围：10s\n', 'component_schematic/88a26a89-3655-4181-89b9-9a0ce187d91c.png', 'JSZ3A-B-10', null, null, 'component_icon/fd6c044d-2335-4a8d-9f92-7465778b87d7.png', '德力西');
INSERT INTO `component` VALUES ('23048605-e879-4180-87ee-1964d5f53cf9', '2019-08-16 11:38:59', '2019-08-20 16:45:01', null, '空气开关（HDBE-63-4P-C6）', 'a4d857a1-bb55-11e9-b3b8-1c1b0dfbee1c', '空气开关也就是空气断路器，在电路中作接通、分断和承载额定工作电流和短路、过载等故障电流，并能在线路和负载发生过载、短路、欠压等情况下，迅速分断电路，进行可靠的保护。', '名称：德力西断路器4P\n品牌：德力西电气有限公司\n额定电流：6A\n灭弧方式：压缩空气断路器\n功能：短路过载、过载保护\n极数：4P\n温度：-20 ℃ ~ 60 ℃\n', 'component_schematic/79406761-23aa-4c2b-b948-3fb21744507c.png', 'HDBE-63-4P-C6', null, null, 'component_icon/e63227f8-a774-4ac3-8ba0-f93ba8ded9d0.png', '德力西');
INSERT INTO `component` VALUES ('2a853ec1-5096-4d67-b585-31753d0516da', '2019-08-17 12:03:10', '2019-08-20 16:45:01', null, '热过载继电器（JR36-20-5）', 'a5d201e9-bb55-11e9-b3b8-1c1b0dfbee1c', '简称热继电器，热继电器是用来保护电动机免受长期过载的危害。可以进行断相保护，温度补偿，自动复位，手动复位，停止按钮。由于热惯性，热继电器不能做短路保护。因为发生短路故障时，我们要求电路立即断开，而热继电器是不能立即动作的。但是这个热惯性也是合乎我们要求的，在电动机起动或者短时过载时，热继电器不会动作，这可以避免电机不必要的停车。如果要热继电器复位，则按下复位按钮即可。', '名称：热过载继电器\n品牌：德力西电气有限公司\n壳架电流：20A\n额定工作电流：5A\n整定电流调节范围：3.2A~5 A\n辅助触点：一对常闭（95-96），一对常开（97-98）\n', 'component_schematic/a142725c-569b-4efc-bc45-bdbfc69c3db3.png', 'JR36-20-5', null, null, 'component_icon/97fabdcf-bde6-4eda-ab33-c03f88907666.png', '德力西');
INSERT INTO `component` VALUES ('37ec95d1-6588-4654-8660-cf0ef558df0a', '2019-08-17 12:11:39', '2019-08-20 16:45:01', null, '时间继电器（ST3PC-B-60）', 'a62770e4-bb55-11e9-b3b8-1c1b0dfbee1c', '时间继电器的特点是自吸引线圈得到信号起至触头动作中间有一段延时。时间继电器一般用于以时间为函数的电动机起动过程控制。\n时间继电器的主要功能是作为简单程序控制中的一种执行器件，当它接受了启动信号后开始计时，计时结束后它的工作触头进行开或合的动作，从而推动后续的电路工作。一般来说，时间继电器的延时性能在设计的范围内是可以调节的，从而方便调整它的延时时间长短。单凭一只时间继电器恐怕不能做到开始延时闭合，闭合一段时间后，再断开，先实现延时闭合后延时断开，但总体上说，通过配置一定数量的时间继电器和中间继电器都是可以做到的。\n\n根据其延时方式的不同，时间继电器又可分为通电延时型和断电延时型两种。\n通电延时型时间继电器在获得输入信号后立即开始延时，需待延时完毕，其执行部分才输出信号以操纵控制电路；当输入信号消失后，继电器立即恢复到动作前的状态。\n(2)断电延时型时间继电器恰恰相反，当获得输入信号后，执行部分立即有输出信号；而在输入信号消失后，继电器却需要经过一定的延时，才能恢复到动作前的状态。\n', '品牌：欣灵\n型号：ST3PC-B：60\n延时范围： 60s.\n额定控制电源电压：220V\n', 'component_schematic/4a3afac7-ec9e-49ee-b0ce-d014687be774.png', 'ST3PC-B-60', null, null, 'component_icon/db737cd9-ee7f-4345-85aa-9a85bace3b60.png', '欣灵');
INSERT INTO `component` VALUES ('3bbb598e-8cf6-4fc5-87cc-33372aa70360', '2019-08-17 11:53:30', '2019-08-20 16:45:01', null, '熔断器（RT18-32-3P-X- 16）', 'a52648bd-bb55-11e9-b3b8-1c1b0dfbee1c', '熔断器是根据电流超过规定值一段时间后，以其自身产生的热量使熔体熔化，从而使电路断开；运用这种原理制成的一种电流保护器。线路正常工作时，熔体不应熔断，当电路发生短路，熔体立即熔断，以保护电路及用电设备不遭损坏。熔断器广泛应用于高低压配电系统和控制系统以及用电设备中，作为短路和过电流的保护器，是应用最普遍的保护器件之一。', '名称：圆筒形帽熔断器\r品牌：德力西电气有限公司\r电流规格：16A\r熔断器电流：32A\r分断能力：100kA\r额定散耗功率：≤ 3W\r熔断体电流：16A\r额定电压：380~500V AC', 'component_schematic/970a4289-6b97-4c57-8329-84c887918bca.png', 'RT18-32-3P-X-16', null, null, 'component_icon/f55782ce-06f7-4a5d-8ee7-ef5d95f1951e.png', '德力西');
INSERT INTO `component` VALUES ('44fe790c-4aa6-4de6-ae3a-79440320b68a', '2019-08-17 12:04:25', '2019-08-20 16:45:01', null, '热过载继电器（JR36-20-11）', 'a5d201e9-bb55-11e9-b3b8-1c1b0dfbee1c', '简称热继电器，热继电器是用来保护电动机免受长期过载的危害。可以进行断相保护，温度补偿，自动复位，手动复位，停止按钮。由于热惯性，热继电器不能做短路保护。因为发生短路故障时，我们要求电路立即断开，而热继电器是不能立即动作的。但是这个热惯性也是合乎我们要求的，在电动机起动或者短时过载时，热继电器不会动作，这可以避免电机不必要的停车。如果要热继电器复位，则按下复位按钮即可。', '名称：热过载继电器\n品牌：德力西电气有限公司\n壳架电流：20A\n额定工作电流：11A\n整定电流调节范围：6.8A~11 A\n辅助触点：一对常闭（95-96），一对常开（97-98）\n', 'component_schematic/f405e351-d6d2-431c-b08f-69c108ca892d.png', 'JR36-20-11', null, null, 'component_icon/c786cf32-4e6b-478d-8b28-cf1a9c95e581.png', '德力西');
INSERT INTO `component` VALUES ('4e0744f0-c4fb-4693-958f-f9b2da98de3d', '2019-08-17 12:03:49', '2019-08-20 16:45:02', null, '热过载继电器（JR36-20-7.2）', 'a5d201e9-bb55-11e9-b3b8-1c1b0dfbee1c', '简称热继电器，热继电器是用来保护电动机免受长期过载的危害。可以进行断相保护，温度补偿，自动复位，手动复位，停止按钮。由于热惯性，热继电器不能做短路保护。因为发生短路故障时，我们要求电路立即断开，而热继电器是不能立即动作的。但是这个热惯性也是合乎我们要求的，在电动机起动或者短时过载时，热继电器不会动作，这可以避免电机不必要的停车。如果要热继电器复位，则按下复位按钮即可。', '名称：热过载继电器\n品牌：德力西电气有限公司\n壳架电流：20A\n额定工作电流：7.2A\n整定电流调节范围：4.5A~7.2 A\n辅助触点：一对常闭（95-96），一对常开（97-98）\n', 'component_schematic/9832ff5a-4511-469b-8041-3c017feed3a2.png', 'JR36-20-7.2', null, null, 'component_icon/42ec0318-a432-45a1-acd4-6942e9f22831.png', '德力西');
INSERT INTO `component` VALUES ('57dec02b-045f-4ab2-9e55-2be8b1b2c1f8', '2019-08-17 12:19:54', '2019-08-20 16:45:02', null, '电机（Y90L-2）', 'b17d31b3-0bb7-4439-a6ae-f6e531c485dd', '三相异步电机(Triple-phase asynchronous motor)是靠同时接入380V三相交流电源(相位差120度)供电的一类电动机，由于三相异步电机的转子与定子旋转磁场以相同的方向、不同的转速成旋转，存在转差率，所以叫三相异步电机。', '型号：Y90L-2  \n额定功率：2.2kW\n额定电流：4.8A\n同步转速转速：3000rpm\n极数：2\n额定电压：380V\n额定频率：50Hz\n工作方式：S1\n转速：2840r/ min\n效率：80.5%\n功率因素：0.86\n', 'component_schematic/b2ad3397-a12e-4e92-ad83-29bda411f7bb.png', 'Y90L-2', null, null, 'component_icon/ba4673eb-ca70-4e4b-9f4d-d57f7f6ab044.png', '山界');
INSERT INTO `component` VALUES ('58a68db9-92af-4248-b076-896dba0f2a60', '2019-08-17 12:11:03', '2019-08-20 16:45:02', null, '时间继电器（ST3PC-B-10）', 'a62770e4-bb55-11e9-b3b8-1c1b0dfbee1c', '时间继电器的特点是自吸引线圈得到信号起至触头动作中间有一段延时。时间继电器一般用于以时间为函数的电动机起动过程控制。\n时间继电器的主要功能是作为简单程序控制中的一种执行器件，当它接受了启动信号后开始计时，计时结束后它的工作触头进行开或合的动作，从而推动后续的电路工作。一般来说，时间继电器的延时性能在设计的范围内是可以调节的，从而方便调整它的延时时间长短。单凭一只时间继电器恐怕不能做到开始延时闭合，闭合一段时间后，再断开，先实现延时闭合后延时断开，但总体上说，通过配置一定数量的时间继电器和中间继电器都是可以做到的。\n\n根据其延时方式的不同，时间继电器又可分为通电延时型和断电延时型两种。\n通电延时型时间继电器在获得输入信号后立即开始延时，需待延时完毕，其执行部分才输出信号以操纵控制电路；当输入信号消失后，继电器立即恢复到动作前的状态。\n(2)断电延时型时间继电器恰恰相反，当获得输入信号后，执行部分立即有输出信号；而在输入信号消失后，继电器却需要经过一定的延时，才能恢复到动作前的状态。\n', '品牌：欣灵\n型号：ST3PC-B：10\n额定控制电源电压：220V\n延时范围： 10s\n', 'component_schematic/8763760c-a7ff-4a55-8ead-37f95941f04d.png', 'ST3PC-B-10', null, null, 'component_icon/24df34a4-c541-42f3-af31-8ddda049eb19.png', '欣灵');
INSERT INTO `component` VALUES ('5b7e0a96-33f4-4a64-85c2-e075c904743d', '2019-08-17 12:09:08', '2019-08-20 16:45:02', null, '时间继电器（JSZ3A-B-1）', 'a62770e4-bb55-11e9-b3b8-1c1b0dfbee1c', '时间继电器的特点是自吸引线圈得到信号起至触头动作中间有一段延时。时间继电器一般用于以时间为函数的电动机起动过程控制。\n时间继电器的主要功能是作为简单程序控制中的一种执行器件，当它接受了启动信号后开始计时，计时结束后它的工作触头进行开或合的动作，从而推动后续的电路工作。一般来说，时间继电器的延时性能在设计的范围内是可以调节的，从而方便调整它的延时时间长短。单凭一只时间继电器恐怕不能做到开始延时闭合，闭合一段时间后，再断开，先实现延时闭合后延时断开，但总体上说，通过配置一定数量的时间继电器和中间继电器都是可以做到的。\n\n根据其延时方式的不同，时间继电器又可分为通电延时型和断电延时型两种。\n通电延时型时间继电器在获得输入信号后立即开始延时，需待延时完毕，其执行部分才输出信号以操纵控制电路；当输入信号消失后，继电器立即恢复到动作前的状态。\n(2)断电延时型时间继电器恰恰相反，当获得输入信号后，执行部分立即有输出信号；而在输入信号消失后，继电器却需要经过一定的延时，才能恢复到动作前的状态。\n', '品牌：德力西\n型号：JSZ3A-B:1\n额定控制电源电压：220V\n延时范围：1s\n', 'component_schematic/a234c918-961d-4a08-bfc7-9d5fd91593c3.png', 'JSZ3A-B-1', null, null, 'component_icon/805f4166-6c74-423e-8385-d344a906ced2.png', '德力西');
INSERT INTO `component` VALUES ('5ba781fb-ccf3-4abc-a679-8acb7eee6b26', '2019-08-17 12:02:37', '2019-08-20 16:45:02', null, '热过载继电器（JR36-20-3.5）', 'a5d201e9-bb55-11e9-b3b8-1c1b0dfbee1c', '简称热继电器，热继电器是用来保护电动机免受长期过载的危害。可以进行断相保护，温度补偿，自动复位，手动复位，停止按钮。由于热惯性，热继电器不能做短路保护。因为发生短路故障时，我们要求电路立即断开，而热继电器是不能立即动作的。但是这个热惯性也是合乎我们要求的，在电动机起动或者短时过载时，热继电器不会动作，这可以避免电机不必要的停车。如果要热继电器复位，则按下复位按钮即可。', '名称：热过载继电器\n品牌：德力西电气有限公司\n壳架电流：20A\n额定工作电流：3.5A\n整定电流调节范围：2.2A~3.5 A\n辅助触点：一对常闭（95-96），一对常开（97-98）\n', 'component_schematic/33e4a1e1-dcac-43b3-a8ff-e4bb9c7da6f7.png', 'JR36-20-3.5', null, null, 'component_icon/724db4d8-f600-4e52-92a2-2faa5958c579.png', '德力西');
INSERT INTO `component` VALUES ('67ee266a-3c8e-4f37-946c-e59e02ed7fc6', '2019-08-17 12:19:00', '2019-08-20 16:45:02', null, '电机（Y132S1-2）', 'b17d31b3-0bb7-4439-a6ae-f6e531c485dd', '三相异步电机(Triple-phase asynchronous motor)是靠同时接入380V三相交流电源(相位差120度)供电的一类电动机，由于三相异步电机的转子与定子旋转磁场以相同的方向、不同的转速成旋转，存在转差率，所以叫三相异步电机。', '型号：Y132S1-2\n额定功率：5.5kW\n额定电流：11.1A\n同步转速转速：3000rpm\n极数：2\n额定电压：380V\n额定频率：50Hz\n工作方式：S1\n转速：2900r/min\n效率：85.5%\n功率因素：0.88\n', 'component_schematic/fbaea238-5b96-4017-8927-99f6279655e2.png', 'Y132S1-2', null, null, 'component_icon/bbb45635-ad87-426b-b984-79cb61fdfd30.png', '山界');
INSERT INTO `component` VALUES ('8368c4c8-6f91-441a-bd28-44651b2ec360', '2019-08-17 12:10:05', '2019-08-20 16:45:02', null, '时间继电器（JSZ3A-B-60）', 'a62770e4-bb55-11e9-b3b8-1c1b0dfbee1c', '时间继电器的特点是自吸引线圈得到信号起至触头动作中间有一段延时。时间继电器一般用于以时间为函数的电动机起动过程控制。\n时间继电器的主要功能是作为简单程序控制中的一种执行器件，当它接受了启动信号后开始计时，计时结束后它的工作触头进行开或合的动作，从而推动后续的电路工作。一般来说，时间继电器的延时性能在设计的范围内是可以调节的，从而方便调整它的延时时间长短。单凭一只时间继电器恐怕不能做到开始延时闭合，闭合一段时间后，再断开，先实现延时闭合后延时断开，但总体上说，通过配置一定数量的时间继电器和中间继电器都是可以做到的。\n\n根据其延时方式的不同，时间继电器又可分为通电延时型和断电延时型两种。\n通电延时型时间继电器在获得输入信号后立即开始延时，需待延时完毕，其执行部分才输出信号以操纵控制电路；当输入信号消失后，继电器立即恢复到动作前的状态。\n(2)断电延时型时间继电器恰恰相反，当获得输入信号后，执行部分立即有输出信号；而在输入信号消失后，继电器却需要经过一定的延时，才能恢复到动作前的状态。\n', '品牌：德力西\n型号：JSZ3A-B:60\n额定控制电源电压：220V\n延时范围：60s\n', 'component_schematic/6362cd16-c8ab-4492-9b16-76210516a661.png', 'JSZ3A-B-60', null, null, 'component_icon/14820e2e-1287-4b47-bfe7-8df24df0b606.png', '德力西');
INSERT INTO `component` VALUES ('8ae12842-d69b-4269-8d8b-b50ca5e2cc52', '2019-08-17 12:17:10', '2019-08-20 16:45:02', null, '按钮开关（LAY711BN43）', 'a4745ed9-bb55-11e9-b3b8-1c1b0dfbee1c', '按钮是一种人工控制的主令电器。主要用来发布操作命令，接通或开断控制电路，控制机械与电气设备的运行。按钮的工作原理很简单，对于常开触头，在按钮未被按下前,电路是断开的,按下按钮后,常开触头被连通,电路也被接通;对于常闭触头，在按钮未被按下前，触头是闭合的，按下按钮后，触头被断开，电路也被分断。', '品牌：德力西\r型号：LAY711BN43\r额定绝缘电压：600V\r自由发热电流：10A\r触点数量：一常开一常闭\r', 'component_schematic/da5bfc74-4bfa-4803-be8a-e6fdd65fcc86.png', 'LAY711BN43', null, null, 'component_icon/ab35174b-1cac-460d-95d2-acf1cf88ee17.png', '德力西');
INSERT INTO `component` VALUES ('8e99163a-8e1f-4407-b14a-4b6a4af01193', '2019-08-17 11:49:04', '2019-08-20 16:45:02', null, '熔断器（RT18-32-3P-X- 6）', 'a52648bd-bb55-11e9-b3b8-1c1b0dfbee1c', '熔断器是根据电流超过规定值一段时间后，以其自身产生的热量使熔体熔化，从而使电路断开；运用这种原理制成的一种电流保护器。线路正常工作时，熔体不应熔断，当电路发生短路，熔体立即熔断，以保护电路及用电设备不遭损坏。熔断器广泛应用于高低压配电系统和控制系统以及用电设备中，作为短路和过电流的保护器，是应用最普遍的保护器件之一。', '名称：圆筒形帽熔断器\r品牌：德力西电气有限公司\r电流规格：6A\r熔断器电流：32A\r分断能力：100kA\r额定散耗功率：≤ 3W\r熔断体电流：6\r额定电压：380~500V AC', 'component_schematic/a837ae61-8f41-4892-9df8-77d1bee86dd3.png', 'RT18-32-3P-X-6', null, null, 'component_icon/cbaa5d30-e276-4b19-8d89-f7b1232ac808.png', '德力西');
INSERT INTO `component` VALUES ('942de052-9c32-4f16-8564-f3783f6ffb75', '2019-08-17 12:04:54', '2019-08-20 16:45:02', null, '热过载继电器（JR36-20-16）', 'a5d201e9-bb55-11e9-b3b8-1c1b0dfbee1c', '简称热继电器，热继电器是用来保护电动机免受长期过载的危害。可以进行断相保护，温度补偿，自动复位，手动复位，停止按钮。由于热惯性，热继电器不能做短路保护。因为发生短路故障时，我们要求电路立即断开，而热继电器是不能立即动作的。但是这个热惯性也是合乎我们要求的，在电动机起动或者短时过载时，热继电器不会动作，这可以避免电机不必要的停车。如果要热继电器复位，则按下复位按钮即可。', '名称：热过载继电器\n品牌：德力西电气有限公司\n壳架电流：20A\n额定工作电流：16A\n整定电流调节范围：10A~16 A\n辅助触点：一对常闭（95-96），一对常开（97-98）\n', 'component_schematic/9c69408e-81bb-4e20-9150-4b5359cc4e51.png', 'JR36-20-16', null, null, 'component_icon/f11ac2cc-7fed-4c36-ba4e-615918fb57d6.png', '德力西');
INSERT INTO `component` VALUES ('a05cda5b-b974-430e-ae68-eb5c86416c12', '2019-08-17 12:14:32', '2019-08-20 16:45:02', null, 'PLC（S7-1200 CPU1214C AC/DC/RLY）', 'a67e7450-bb55-11e9-b3b8-1c1b0dfbee1c', '可编程逻辑控制器，它采用一类可编程的存储器，用于其内部存储程序，执行逻辑运算、顺序控制、定时、计数与算术操作等面向用户的指令，并通过数字或模拟式输入/输出控制各种类型的机械或生产过程。', '电源电压范围：85-264V AC\n功耗：14W\n输入输出端电压范围：20.4-28.8VDC\n数字量输入/输出点：14点输入/10点输出\n模拟量输入点：2路输入\n信号模块扩展：最多扩展8个信号模块\n信号板扩展：最多扩展1个信号模块\n通讯模块扩展：最多扩展3个通讯模块\n通讯端口数量：1\n通讯类型：以太网\n', 'component_schematic/d4bf2973-6b82-4669-b1ab-d43666ea9789.png', 'S7-1200 CPU1214C', null, null, 'component_icon/78d78840-51cb-418d-951e-62fb8866accf.png', '德力西');
INSERT INTO `component` VALUES ('b121ffc8-bf22-46e7-bad8-c322edf1c542', '2019-08-17 11:57:26', '2019-08-20 16:45:02', null, '接触器（CJX2-25-10-M）', 'a57f3b60-bb55-11e9-b3b8-1c1b0dfbee1c', '接触器广义上是指工业电中利用线圈流过电流产生磁场，使触头闭合，以达到控制负载的电器。接触器的工作原理就是通过控制接在控制电路的辅助触点的通断来控制接在主电路的主触点的通断以达到控制电路的要求。\n', '名称：通用型交流接触器\n品牌：德力西电气有限公司\n电流规格：25A\n线圈电压：220V\n额定频率：50Hz\n辅助触点：一对常开触点\n', 'component_schematic/75fb942b-3cb1-4e6c-8eb4-068ba048cf25.png', 'CJX2-25-10-M', null, null, 'component_icon/07c841c7-39c4-461c-914b-b1ecdd7176a3.png', '德力西');
INSERT INTO `component` VALUES ('b796ba8e-6f17-4aea-bae8-7554cb4d8875', '2019-08-17 11:50:27', '2019-08-20 16:45:02', null, '熔断器（RT18-32-3P-X- 8）', 'a52648bd-bb55-11e9-b3b8-1c1b0dfbee1c', '熔断器是根据电流超过规定值一段时间后，以其自身产生的热量使熔体熔化，从而使电路断开；运用这种原理制成的一种电流保护器。线路正常工作时，熔体不应熔断，当电路发生短路，熔体立即熔断，以保护电路及用电设备不遭损坏。熔断器广泛应用于高低压配电系统和控制系统以及用电设备中，作为短路和过电流的保护器，是应用最普遍的保护器件之一。', '名称：圆筒形帽熔断器\r品牌：德力西电气有限公司\r电流规格：8A\r熔断器电流：32A\r分断能力：100kA\r额定散耗功率：≤ 3W\r熔断体电流：8A\r额定电压：380~500V AC', 'component_schematic/6719e66e-4884-4a2b-b1d5-dd845daa61f1.png', 'RT18-32-3P-X-8', null, null, 'component_icon/869a0bf8-40db-490a-bd9b-8edf053daee3.png', '德力西');
INSERT INTO `component` VALUES ('b88dbf5d-2929-4b73-a1a9-ece5e4a6e8c4', '2019-08-17 11:44:41', '2019-08-20 16:45:02', null, '空气开关（HDBE-63-4P-C16）', 'a4d857a1-bb55-11e9-b3b8-1c1b0dfbee1c', '空气开关也就是空气断路器，在电路中作接通、分断和承载额定工作电流和短路、过载等故障电流，并能在线路和负载发生过载、短路、欠压等情况下，迅速分断电路，进行可靠的保护。', '名称：德力西断路器4P\n品牌：德力西电气有限公司\n额定电流：16A\n灭弧方式：压缩空气断路器\n功能：短路过载、过载保护\n极数：4P\n温度：-20 ℃ ~ 60 ℃\n', 'component_schematic/817ff082-3cbe-4d5a-a88b-7ee1edeb3f12.png', 'HDBE-63-4P-C16', null, null, 'component_icon/9cefe5f5-897d-4b0c-baf8-51912e0331d1.png', '德力西');
INSERT INTO `component` VALUES ('be06045f-82b3-4695-b160-41083c416bb4', '2019-08-17 12:16:26', '2019-08-20 16:45:02', null, '按钮开关（LAY711BN32）', 'a4745ed9-bb55-11e9-b3b8-1c1b0dfbee1c', '按钮是一种人工控制的主令电器。主要用来发布操作命令，接通或开断控制电路，控制机械与电气设备的运行。按钮的工作原理很简单，对于常开触头，在按钮未被按下前,电路是断开的,按下按钮后,常开触头被连通,电路也被接通;对于常闭触头，在按钮未被按下前，触头是闭合的，按下按钮后，触头被断开，电路也被分断。', '品牌：德力西\r型号：LAY711BN32\r额定绝缘电压：600V\r自由发热电流：10A\r触点数量：一常开一常闭\r', 'component_schematic/30b2a511-3dd0-4e0d-aa79-6c847e3b563a.png', 'LAY711BN32', null, null, 'component_icon/bb5dc70d-a606-4058-aa7f-380bddda7fba.png', '德力西');
INSERT INTO `component` VALUES ('c97bd54b-0170-4d3e-8bc2-65062e1099d1', '2019-08-17 12:05:28', '2019-08-20 16:45:02', null, '热过载继电器（JR36-20-22）', 'a5d201e9-bb55-11e9-b3b8-1c1b0dfbee1c', '简称热继电器，热继电器是用来保护电动机免受长期过载的危害。可以进行断相保护，温度补偿，自动复位，手动复位，停止按钮。由于热惯性，热继电器不能做短路保护。因为发生短路故障时，我们要求电路立即断开，而热继电器是不能立即动作的。但是这个热惯性也是合乎我们要求的，在电动机起动或者短时过载时，热继电器不会动作，这可以避免电机不必要的停车。如果要热继电器复位，则按下复位按钮即可。', '名称：热过载继电器\n品牌：德力西电气有限公司\n壳架电流：20A\n额定工作电流：22A\n整定电流调节范围：14A~22 A\n辅助触点：一对常闭（95-96），一对常开（97-98）\n', 'component_schematic/b726e073-ce5b-4f94-898c-cbd2e9c22566.png', 'JR36-20-22', null, null, 'component_icon/7d1b71be-0c60-4cf8-b018-ae09eb510dd7.png', '德力西');
INSERT INTO `component` VALUES ('cca075ea-3bcd-4ff7-b9b7-ada76e3b117e', '2019-08-17 11:52:43', '2019-08-20 16:45:02', null, '熔断器（RT18-32-3P-X- 12）', 'a52648bd-bb55-11e9-b3b8-1c1b0dfbee1c', '熔断器是根据电流超过规定值一段时间后，以其自身产生的热量使熔体熔化，从而使电路断开；运用这种原理制成的一种电流保护器。线路正常工作时，熔体不应熔断，当电路发生短路，熔体立即熔断，以保护电路及用电设备不遭损坏。熔断器广泛应用于高低压配电系统和控制系统以及用电设备中，作为短路和过电流的保护器，是应用最普遍的保护器件之一。', '名称：圆筒形帽熔断器\r品牌：德力西电气有限公司\r电流规格：12A\r熔断器电流：32A\r分断能力：100kA\r额定散耗功率：≤ 3W\r熔断体电流：12A\r额定电压：380~500V AC', 'component_schematic/759ef98a-eb7a-44ae-9aff-5b312f3067c5.png', 'RT18-32-3P-X-12', null, null, 'component_icon/00616165-27c1-4ae5-9033-274aa2734366.png', '德力西');
INSERT INTO `component` VALUES ('ccbee16c-e886-40b1-a20d-7a323ffff4c9', '2019-08-17 12:00:55', '2019-08-20 16:45:02', null, '热过载继电器（JR36-20-1.6）', 'a5d201e9-bb55-11e9-b3b8-1c1b0dfbee1c', '简称热继电器，热继电器是用来保护电动机免受长期过载的危害。可以进行断相保护，温度补偿，自动复位，手动复位，停止按钮。由于热惯性，热继电器不能做短路保护。因为发生短路故障时，我们要求电路立即断开，而热继电器是不能立即动作的。但是这个热惯性也是合乎我们要求的，在电动机起动或者短时过载时，热继电器不会动作，这可以避免电机不必要的停车。如果要热继电器复位，则按下复位按钮即可。', '名称：热过载继电器\n品牌：德力西电气有限公司\n壳架电流：20A\n额定工作电流：1.6A\n整定电流调节范围：1A~1.6A\n辅助触点：一对常闭（95-96），一对常开（97-98）\n', 'component_schematic/14c65072-1f12-4b6b-8abd-dd898c7f3929.png', 'JR36-20-1.6', null, null, 'component_icon/626efdbe-d824-45fa-8096-8abea7fe33d1.png', '德力西');
INSERT INTO `component` VALUES ('d0559507-2ad7-47c3-88a7-23f6b22bda9e', '2019-08-17 12:00:18', '2019-08-20 16:45:02', null, '热过载继电器（JR36-20-1.1）', 'a5d201e9-bb55-11e9-b3b8-1c1b0dfbee1c', '简称热继电器，热继电器是用来保护电动机免受长期过载的危害。可以进行断相保护，温度补偿，自动复位，手动复位，停止按钮。由于热惯性，热继电器不能做短路保护。因为发生短路故障时，我们要求电路立即断开，而热继电器是不能立即动作的。但是这个热惯性也是合乎我们要求的，在电动机起动或者短时过载时，热继电器不会动作，这可以避免电机不必要的停车。如果要热继电器复位，则按下复位按钮即可。', '名称：热过载继电器\n品牌：德力西电气有限公司\n壳架电流：20A\n额定工作电流：1.1A\n整定电流调节范围：0.68A~1.1A\n辅助触点：一对常闭（95-96），一对常开（97-98）\n', 'component_schematic/126e9879-906d-4209-bc27-48646148ffb0.png', 'JR36-20-1.1', null, null, 'component_icon/a425b9be-dd02-405c-984c-9c955b88a658.png', '德力西');
INSERT INTO `component` VALUES ('dcdae787-fc6b-4d28-a528-3ccb9d1e73cb', '2019-08-17 11:56:25', '2019-08-20 16:45:02', null, '接触器（CJX2-12-10-M）', 'a57f3b60-bb55-11e9-b3b8-1c1b0dfbee1c', '接触器广义上是指工业电中利用线圈流过电流产生磁场，使触头闭合，以达到控制负载的电器。接触器的工作原理就是通过控制接在控制电路的辅助触点的通断来控制接在主电路的主触点的通断以达到控制电路的要求。', '名称：通用型交流接触器\n品牌：德力西电气有限公司\n电流规格：12A\n线圈电压：220V\n额定频率：50Hz\n辅助触点：一对常开触点\n', 'component_schematic/c162c16d-552f-4b0f-b4d8-4596394b21be.png', 'CJX2-12-10-M', null, null, 'component_icon/830e5f7e-6db1-4ab8-b72f-b4858833e8fa.png', '德力西');
INSERT INTO `component` VALUES ('f94c0ef7-5fd6-4979-9cf9-b5ba796cab2b', '2019-08-17 12:01:54', '2019-08-20 16:45:02', null, '热过载继电器（JR36-20-2.4）', 'a5d201e9-bb55-11e9-b3b8-1c1b0dfbee1c', '简称热继电器，热继电器是用来保护电动机免受长期过载的危害。可以进行断相保护，温度补偿，自动复位，手动复位，停止按钮。由于热惯性，热继电器不能做短路保护。因为发生短路故障时，我们要求电路立即断开，而热继电器是不能立即动作的。但是这个热惯性也是合乎我们要求的，在电动机起动或者短时过载时，热继电器不会动作，这可以避免电机不必要的停车。如果要热继电器复位，则按下复位按钮即可。', '名称：热过载继电器\n品牌：德力西电气有限公司\n壳架电流：20A\n额定工作电流：2.4A\n整定电流调节范围：1.5A~2.4 A\n辅助触点：一对常闭（95-96），一对常开（97-98）\n', 'component_schematic/c43eb291-34b3-4a94-92fa-d5f6c779681e.png', 'JR36-20-2.4', null, null, 'component_icon/f4d72a8f-afa2-40cc-9a8f-f155044b24dd.png', '德力西');

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
INSERT INTO `component_group` VALUES ('180730ce-2572-49e1-8fb2-16e412bacdc9', '2019-08-16 11:34:52', '2019-08-16 11:34:52', '2019-08-16 11:35:08', '仪表', '');
INSERT INTO `component_group` VALUES ('5080d19d-1d00-4d0d-9189-454d67e71990', '2019-08-17 11:32:14', '2019-08-17 11:32:14', '2019-08-19 09:30:09', '3P+N电源端子', '');
INSERT INTO `component_group` VALUES ('8c119a12-42ff-4b53-94fc-d388ebe065a5', '2019-08-16 11:35:15', '2019-08-16 11:35:15', null, '仪表', '');
INSERT INTO `component_group` VALUES ('9d642004-c116-460f-b555-9d400891ed9a', '2019-08-17 11:32:34', '2019-08-17 11:32:34', '2019-08-19 09:30:17', '零线端子', '');
INSERT INTO `component_group` VALUES ('a4745ed9-bb55-11e9-b3b8-1c1b0dfbee1c', '2019-08-10 18:00:40', '2019-08-10 18:00:40', null, '按钮', '');
INSERT INTO `component_group` VALUES ('a4d857a1-bb55-11e9-b3b8-1c1b0dfbee1c', '2019-08-10 18:00:40', '2019-08-10 18:00:40', null, '空气开关', '');
INSERT INTO `component_group` VALUES ('a52648bd-bb55-11e9-b3b8-1c1b0dfbee1c', '2019-08-10 18:00:41', '2019-08-10 18:00:41', null, '熔断器', '');
INSERT INTO `component_group` VALUES ('a57f3b60-bb55-11e9-b3b8-1c1b0dfbee1c', '2019-08-10 18:00:41', '2019-08-10 18:00:41', null, '接触器', '');
INSERT INTO `component_group` VALUES ('a5d201e9-bb55-11e9-b3b8-1c1b0dfbee1c', '2019-08-10 18:00:42', '2019-08-10 18:00:42', null, '热继电器', '');
INSERT INTO `component_group` VALUES ('a62770e4-bb55-11e9-b3b8-1c1b0dfbee1c', '2019-08-10 18:00:43', '2019-08-10 18:00:43', null, '时间继电器', '');
INSERT INTO `component_group` VALUES ('a67e7450-bb55-11e9-b3b8-1c1b0dfbee1c', '2019-08-10 18:00:43', '2019-08-10 18:00:43', null, 'PLC', '');
INSERT INTO `component_group` VALUES ('a6d67d90-bb55-11e9-b3b8-1c1b0dfbee1c', '2019-08-10 18:00:44', '2019-08-10 18:00:44', null, '开关电源', '');
INSERT INTO `component_group` VALUES ('b17d31b3-0bb7-4439-a6ae-f6e531c485dd', '2019-08-17 12:24:04', '2019-08-17 12:24:04', null, '电机', '');
INSERT INTO `component_group` VALUES ('cc7636b1-e5e6-481a-bc9d-6fc5b3e0b66b', '2019-08-17 11:31:43', '2019-08-17 11:31:43', '2019-08-19 09:31:03', '三相电源端子', '');
INSERT INTO `component_group` VALUES ('ccf5a384-8ca6-4421-ab17-a0ae2ebae3b6', '2019-08-17 11:30:49', '2019-08-17 11:30:49', '2019-08-19 09:30:48', '接地端子', '');
INSERT INTO `component_group` VALUES ('dbfe2e92-defc-4971-9db2-3c34420a8ccb', '2019-08-17 11:32:45', '2019-08-17 11:32:45', null, '线材', '');
INSERT INTO `component_group` VALUES ('efa9bd1f-d36f-4ac0-99c0-10b83be1d78e', '2019-08-19 09:30:37', '2019-08-19 09:30:37', null, '端子排', '');

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
INSERT INTO `training` VALUES ('14f64eb3-df8f-46f3-b4c7-aeb92af33f76', '2019-09-06 10:43:01', '2019-09-06 10:47:44', null, 'd6f87387-f1eb-4ed1-a551-2fc92745437a', '25da96b4-c9fe-11e9-81b8-7085c206b232', '熔断器认知', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('1b28fb29-eb60-4252-8bc7-531e07ae041a', '2019-09-05 10:15:54', '2019-09-05 14:27:04', '2019-09-05 14:27:04', 'd6f87387-f1eb-4ed1-a551-2fc92745437a', '', '电气基础知识', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, '[]');
INSERT INTO `training` VALUES ('4f11a365-44c9-49dc-93ce-994d45544609', '2019-09-06 10:43:33', '2019-09-06 10:48:03', null, 'd6f87387-f1eb-4ed1-a551-2fc92745437a', '25da96b4-c9fe-11e9-81b8-7085c206b232', '信号继电器认知', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('6308172d-2875-4a93-bdf8-3959bb2a038b', '2019-09-06 10:43:22', '2019-09-06 10:47:00', '2019-09-06 10:47:00', 'd6f87387-f1eb-4ed1-a551-2fc92745437a', '25da96b4-c9fe-11e9-81b8-7085c206b232', '主令电器认知', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('6997de04-ab8c-4b46-8533-f9b17accd00f', '2019-09-06 11:24:31', '2019-09-06 11:24:31', null, '7017986f-c9ff-11e9-81b8-7085c206b232', '25da96b4-c9fe-11e9-81b8-7085c206b232', '电气识图', '0', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('73a9ab39-3255-4ad8-9790-ef3ad5c0f582', '2019-09-06 10:31:52', '2019-09-06 10:47:29', null, 'd6f87387-f1eb-4ed1-a551-2fc92745437a', '25da96b4-c9fe-11e9-81b8-7085c206b232', '接触器控制基础', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('a4ef5f21-deed-4633-9fae-8acca0521a68', '2019-09-06 10:41:57', '2019-09-06 10:47:19', null, 'd6f87387-f1eb-4ed1-a551-2fc92745437a', '25da96b4-c9fe-11e9-81b8-7085c206b232', '电器基础知识', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('abe6787b-6004-4d36-a0e0-07508224f564', '2019-09-06 10:43:44', '2019-09-06 10:48:10', null, 'd6f87387-f1eb-4ed1-a551-2fc92745437a', '25da96b4-c9fe-11e9-81b8-7085c206b232', '常用执行器件认知', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('aeeb730a-5f4c-4f57-85e6-59713e91edf1', '2019-09-05 14:28:12', '2019-09-06 10:31:05', '2019-09-06 10:31:05', '7017986f-c9ff-11e9-81b8-7085c206b232', '25da96b4-c9fe-11e9-81b8-7085c206b232', '电器基础知识', '0', '07c0267a-0cbb-473d-9685-54e0798c10ca', '[]', null, '[]');
INSERT INTO `training` VALUES ('c962226f-3699-41da-a69e-4acaf06c4620', '2019-09-06 10:44:03', '2019-09-06 10:48:28', null, 'd6f87387-f1eb-4ed1-a551-2fc92745437a', '25da96b4-c9fe-11e9-81b8-7085c206b232', '常用电气安装附件', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('cbb6e860-3643-4b05-8032-1ef3ae799f35', '2019-09-04 11:50:18', '2019-09-05 10:14:44', '2019-09-05 10:14:44', null, '25da96b4-c9fe-11e9-81b8-7085c206b232', 'test', '0', '07c0267a-0cbb-473d-9685-54e0798c10ca', '[]', null, null);
INSERT INTO `training` VALUES ('cc8603a2-e1bc-4f6e-89b5-633bd76ed09e', '2019-09-06 10:35:52', '2019-09-06 10:47:37', null, 'd6f87387-f1eb-4ed1-a551-2fc92745437a', '25da96b4-c9fe-11e9-81b8-7085c206b232', '低压断路器控制基础', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('e3716257-8380-408d-a18a-41f69287727d', '2019-09-06 10:43:54', '2019-09-06 10:48:22', null, 'd6f87387-f1eb-4ed1-a551-2fc92745437a', '25da96b4-c9fe-11e9-81b8-7085c206b232', '常用检测仪表', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);
INSERT INTO `training` VALUES ('fa61342e-3553-4f89-ad3f-dfa8c5507f3e', '2019-09-06 10:47:12', '2019-09-06 10:47:54', null, 'd6f87387-f1eb-4ed1-a551-2fc92745437a', '25da96b4-c9fe-11e9-81b8-7085c206b232', '主令电器认知', '1', '07c0267a-0cbb-473d-9685-54e0798c10ca', null, null, null);

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
INSERT INTO `training_file` VALUES ('44ca5c13-3258-4b45-a1a9-946005003bc6', '2019-09-06 10:17:26', '2019-09-06 10:31:05', '2019-09-06 10:31:05', 'GB-T 7159-1987 电气技术中的文字符号制订通则.pdf', 'course_plc\\annex\\44ca5c13-3258-4b45-a1a9-946005003bc6.pdf', '747.54 KB', null, 'pdf', '0', 'aeeb730a-5f4c-4f57-85e6-59713e91edf1', 'TEACHING', 'ANNEX');
INSERT INTO `training_file` VALUES ('46c63dcc-ca5a-458b-bde8-4eba5509a6fc', '2019-09-05 14:29:41', '2019-09-06 10:31:05', '2019-09-06 10:31:05', '01常用低压电器.ppt', 'course_plc\\annex\\46c63dcc-ca5a-458b-bde8-4eba5509a6fc.ppt', '3.32 MB', null, 'ppt', '0', 'aeeb730a-5f4c-4f57-85e6-59713e91edf1', 'TEACHING', 'ANNEX');
INSERT INTO `training_file` VALUES ('7f7e15d3-85fc-425c-9805-16ffbcbda1b2', '2019-09-06 10:13:32', '2019-09-06 10:31:05', '2019-09-06 10:31:05', '电器基础知识实训报告模板.doc', 'course_plc\\report\\7f7e15d3-85fc-425c-9805-16ffbcbda1b2.doc', '149.0 KB', null, 'doc', '0', 'aeeb730a-5f4c-4f57-85e6-59713e91edf1', 'EXAM', 'REPORT');
INSERT INTO `training_file` VALUES ('a6346985-596c-4650-a2eb-725cdfe90d4b', '2019-09-05 14:29:41', '2019-09-06 10:31:05', '2019-09-06 10:31:05', '电器基础知识实训指导书 .pdf', 'course_plc\\guide\\a6346985-596c-4650-a2eb-725cdfe90d4b.pdf', '161.09 KB', null, 'pdf', '0', 'aeeb730a-5f4c-4f57-85e6-59713e91edf1', 'TEACHING', 'GUIDE');
INSERT INTO `training_file` VALUES ('c4db4c80-1d19-4f0a-9ecf-a4a8e51a4202', '2019-09-06 10:17:26', '2019-09-06 10:31:05', '2019-09-06 10:31:05', 'GBT 6988.1-2008 电气制图国家标准.pdf', 'course_plc\\annex\\c4db4c80-1d19-4f0a-9ecf-a4a8e51a4202.pdf', '1.27 MB', null, 'pdf', '0', 'aeeb730a-5f4c-4f57-85e6-59713e91edf1', 'TEACHING', 'ANNEX');
INSERT INTO `training_file` VALUES ('ead21b15-7008-4edb-80ba-ebb6886dfe4c', '2019-09-04 15:23:33', '2019-09-05 10:14:44', '2019-09-05 10:14:44', 'gx-simulation.zip', 'course_plc\\annex\\ead21b15-7008-4edb-80ba-ebb6886dfe4c.zip', '17.99 MB', null, 'zip', '0', 'cbb6e860-3643-4b05-8032-1ef3ae799f35', 'TEACHING', 'ANNEX');

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
INSERT INTO `training_module` VALUES ('0c17a94a-cb04-4753-afc0-5bed2bcba7fd', '2019-09-05 10:13:27', '2019-09-05 10:13:27', null, '电气基本控制', '1');
INSERT INTO `training_module` VALUES ('4a881a88-1e25-444b-bebe-8de800a8f0d7', '2019-09-05 10:14:14', '2019-09-05 10:14:14', null, 'PLC', '1');
INSERT INTO `training_module` VALUES ('7017986f-c9ff-11e9-81b8-7085c206b232', '2019-08-29 09:51:04', '2019-08-29 09:51:09', null, '我的实训', '0');
INSERT INTO `training_module` VALUES ('d6f87387-f1eb-4ed1-a551-2fc92745437a', '2019-09-05 10:13:06', '2019-09-05 10:13:06', null, '低压电器', '1');
INSERT INTO `training_module` VALUES ('d935ecc2-4c76-46be-9a3b-7826a028ccd1', '2019-09-05 10:13:39', '2019-09-05 10:13:39', null, '机床电气', '1');
INSERT INTO `training_module` VALUES ('e14a6581-1af4-4ab0-8066-93a44aadee2e', '2019-09-06 10:23:05', '2019-09-06 10:24:35', '2019-09-06 10:24:35', '低压电器认知', '1');

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
