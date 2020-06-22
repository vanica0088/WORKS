/*
Navicat MySQL Data Transfer

Source Server         : 201721074007
Source Server Version : 50077
Source Host           : 210.42.145.77:3306
Source Database       : koalait

Target Server Type    : MYSQL
Target Server Version : 50077
File Encoding         : 65001

Date: 2019-12-27 11:52:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `manager_id` int(11) NOT NULL,
  `password` varchar(255) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`manager_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', '234');
