/*
Navicat MySQL Data Transfer

Source Server         : 201721074007
Source Server Version : 50077
Source Host           : 210.42.145.77:3306
Source Database       : koalait

Target Server Type    : MYSQL
Target Server Version : 50077
File Encoding         : 65001

Date: 2019-12-27 11:51:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for checkconnect
-- ----------------------------
DROP TABLE IF EXISTS `checkconnect`;
CREATE TABLE `checkconnect` (
  `check` int(11) NOT NULL,
  `state` varchar(255) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`check`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of checkconnect
-- ----------------------------
INSERT INTO `checkconnect` VALUES ('0', '待查看');
INSERT INTO `checkconnect` VALUES ('1', '已同意');
INSERT INTO `checkconnect` VALUES ('2', '已拒绝');
