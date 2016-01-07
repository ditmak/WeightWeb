/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : weight

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2016-01-07 23:02:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickName` varchar(255) DEFAULT NULL,
  `loginName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `createTIme` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for weightrecord
-- ----------------------------
DROP TABLE IF EXISTS `weightrecord`;
CREATE TABLE `weightrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `weight` double DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
