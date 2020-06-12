/*
Navicat MySQL Data Transfer

Source Server         : project
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : bills

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-06-12 18:47:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bills
-- ----------------------------
DROP TABLE IF EXISTS `bills`;
CREATE TABLE `bills` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `billtime` datetime DEFAULT NULL,
  `typeid` int(11) DEFAULT NULL,
  `price` double(65,2) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bills
-- ----------------------------
INSERT INTO `bills` VALUES ('1', '小明借我的钱去喝酒', '2019-08-09 11:29:29', '3', '200.00', '111');
INSERT INTO `bills` VALUES ('2', '21231', '2019-08-09 04:25:21', '4', '22.00', '22');
INSERT INTO `bills` VALUES ('3', '222', '2019-09-03 16:00:00', '1', '222.00', '222');
INSERT INTO `bills` VALUES ('4', '22', '2019-09-20 06:48:50', '1', '22.00', '222');
INSERT INTO `bills` VALUES ('5', '44', '2019-09-20 06:49:23', '1', '444.00', '444');
INSERT INTO `bills` VALUES ('6', '555', '2019-09-20 06:50:04', '1', '555.00', '555');
INSERT INTO `bills` VALUES ('7', '777', '2019-09-20 06:50:51', '1', '777.00', '7777');
INSERT INTO `bills` VALUES ('8', '888', '2019-09-20 06:51:45', '1', '888.00', '8888');
INSERT INTO `bills` VALUES ('9', '999', '2019-09-20 06:51:54', '1', '999.00', '999');
INSERT INTO `bills` VALUES ('10', '123', '2019-09-20 06:52:05', '1', '123.00', '123');
INSERT INTO `bills` VALUES ('11', '23232', '2019-09-20 06:52:10', '1', '323.00', '2321312');
INSERT INTO `bills` VALUES ('12', '12312312', '2019-09-20 06:52:14', '2', '3123.00', '12312312');
INSERT INTO `bills` VALUES ('13', '2312', '2019-09-20 06:52:19', '3', '3123.00', '12312312');
INSERT INTO `bills` VALUES ('14', '312312', '2019-09-20 06:52:23', '4', '132312.00', '312321312');
INSERT INTO `bills` VALUES ('15', 'aaaa', '2019-12-04 02:16:14', '1', '110.00', '11111');
INSERT INTO `bills` VALUES ('16', '33', '2019-12-04 02:16:25', '3', '33.00', '333');

-- ----------------------------
-- Table structure for billtype
-- ----------------------------
DROP TABLE IF EXISTS `billtype`;
CREATE TABLE `billtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of billtype
-- ----------------------------
INSERT INTO `billtype` VALUES ('1', '支出');
INSERT INTO `billtype` VALUES ('2', '收入');
INSERT INTO `billtype` VALUES ('3', '借出');
INSERT INTO `billtype` VALUES ('4', '借入');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `loginname` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '小明', 'xiaoming', '123456', '男');
INSERT INTO `user` VALUES ('2', '管理员', 'admin', '123456', '女');
