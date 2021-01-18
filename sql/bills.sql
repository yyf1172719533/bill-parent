/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 114.55.96.13:3306
 Source Schema         : bills

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 18/01/2021 13:16:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bills
-- ----------------------------
DROP TABLE IF EXISTS `bills`;
CREATE TABLE `bills`  (
  `ID` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TITLE` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BILL_TIME` datetime(0) NULL DEFAULT NULL,
  `USER_ID` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TYPE_ID` int(11) NULL DEFAULT NULL,
  `PRICE` double(65, 2) NULL DEFAULT NULL,
  `REMARK` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bills
-- ----------------------------
INSERT INTO `bills` VALUES ('148837bf0b766850bb75d5b532198c1f', '2020-5月工资', '2021-01-18 01:41:43', 'a987c0b99ff96ceb5e712df85f0dbe11', 2, 2954.00, '实习（补发工资1288，请假扣款334）');
INSERT INTO `bills` VALUES ('22e5b61e49a4a63e62c28c262c61b8ad', '2020-12月公积金', '2021-01-18 03:08:21', 'a987c0b99ff96ceb5e712df85f0dbe11', 2, 720.00, '公积金');
INSERT INTO `bills` VALUES ('365b9cb3cd5ad942856eb956276096cb', '2020-8月工资', '2021-01-18 01:43:40', 'a987c0b99ff96ceb5e712df85f0dbe11', 2, 2769.00, '试用（请假扣款83）');
INSERT INTO `bills` VALUES ('3a9b40888ad7a7c4270df518844ace2c', '2020-8月公积金', '2021-01-18 03:06:28', 'a987c0b99ff96ceb5e712df85f0dbe11', 2, 720.00, '公积金');
INSERT INTO `bills` VALUES ('461fe86a867c620d583fbe13273c6b63', '京东还款', '2021-01-18 03:00:06', 'a987c0b99ff96ceb5e712df85f0dbe11', 1, 49.54, '2021年1月白条还款');
INSERT INTO `bills` VALUES ('517ef587faeefbd471c6c9274d9f244a', '2020-7月工资', '2021-01-18 01:42:49', 'a987c0b99ff96ceb5e712df85f0dbe11', 2, 2852.00, '试用');
INSERT INTO `bills` VALUES ('60dead55439765e643fe4fd41f919644', '2020-11月工资', '2021-01-18 01:45:24', 'a987c0b99ff96ceb5e712df85f0dbe11', 2, 2686.00, '试用（请假扣款166）');
INSERT INTO `bills` VALUES ('665f59e78cf3b51ae08700aaf61b8429', '2020-10月公积金', '2021-01-18 03:07:17', 'a987c0b99ff96ceb5e712df85f0dbe11', 2, 720.00, '公积金');
INSERT INTO `bills` VALUES ('6c8aae6cbd9f2cb245505c8d6e06f830', '2020-6月工资', '2021-01-18 01:42:17', 'a987c0b99ff96ceb5e712df85f0dbe11', 2, 2000.00, '实习');
INSERT INTO `bills` VALUES ('76ec30f672a34d641c681c845a60e5c8', '2020-10月工资', '2021-01-18 01:44:38', 'a987c0b99ff96ceb5e712df85f0dbe11', 2, 2852.00, '试用');
INSERT INTO `bills` VALUES ('b110b359ff907845620e212157ee760b', '2020-9月公积金', '2021-01-18 03:06:46', 'a987c0b99ff96ceb5e712df85f0dbe11', 2, 720.00, '公积金');
INSERT INTO `bills` VALUES ('b211e0aeab439790ab8be0dca5b74dad', '2020-9月工资', '2021-01-18 01:44:11', 'a987c0b99ff96ceb5e712df85f0dbe11', 2, 2852.00, '试用');
INSERT INTO `bills` VALUES ('ba06b1f6f189f10f597504d9364a9d50', '公积金提取', '2021-01-18 03:15:10', 'a987c0b99ff96ceb5e712df85f0dbe11', 1, 3400.00, '公积金');
INSERT INTO `bills` VALUES ('d4a9b4dbc613f0df2477eefab6164381', '2020-12月工资', '2021-01-18 01:45:53', 'a987c0b99ff96ceb5e712df85f0dbe11', 2, 2852.00, '试用');
INSERT INTO `bills` VALUES ('d8176a8797b5ed672cdb8602d9c506a7', '2020-11月公积金', '2021-01-18 03:07:38', 'a987c0b99ff96ceb5e712df85f0dbe11', 2, 720.00, '公积金');
INSERT INTO `bills` VALUES ('e71e95a48ae16e4858215ed2b686643c', '2020-7月公积金', '2021-01-18 03:05:56', 'a987c0b99ff96ceb5e712df85f0dbe11', 2, 720.00, '公积金');

-- ----------------------------
-- Table structure for billtype
-- ----------------------------
DROP TABLE IF EXISTS `billtype`;
CREATE TABLE `billtype`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of billtype
-- ----------------------------
INSERT INTO `billtype` VALUES (1, '支出');
INSERT INTO `billtype` VALUES (2, '收入');
INSERT INTO `billtype` VALUES (3, '借出');
INSERT INTO `billtype` VALUES (4, '借还');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `ID` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PASSWORD` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('a7f978d59c0d7653f040b69b99df7b9d', 'Eddy', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `user` VALUES ('a987c0b99ff96ceb5e712df85f0dbe11', '易瑶风', '3bdf583ae476d894e2a9b35f3b4d9de5');

SET FOREIGN_KEY_CHECKS = 1;
