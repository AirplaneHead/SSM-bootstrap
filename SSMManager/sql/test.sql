/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-08-17 17:38:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(255) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) NOT NULL COMMENT '姓名',
  `age` int(5) NOT NULL COMMENT '年龄',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '111', '1');
INSERT INTO `user` VALUES ('2', '12345', '2');
INSERT INTO `user` VALUES ('3', '444', '4');
INSERT INTO `user` VALUES ('4', '555', '5');
INSERT INTO `user` VALUES ('5', '6666', '6');
INSERT INTO `user` VALUES ('6', '777', '7');
INSERT INTO `user` VALUES ('7', '77', '7');
INSERT INTO `user` VALUES ('8', '888', '8');
INSERT INTO `user` VALUES ('9', '77777', '777');
INSERT INTO `user` VALUES ('10', '33333', '3333');
