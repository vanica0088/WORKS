/*
Navicat MySQL Data Transfer

Source Server         : 201721074007
Source Server Version : 50077
Source Host           : 210.42.145.77:3306
Source Database       : koalait

Target Server Type    : MYSQL
Target Server Version : 50077
File Encoding         : 65001

Date: 2019-12-27 11:52:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hunterconnect
-- ----------------------------
DROP TABLE IF EXISTS `hunterconnect`;
CREATE TABLE `hunterconnect` (
  `number` int(11) NOT NULL auto_increment,
  `hunter_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `check` int(11) default NULL,
  PRIMARY KEY  (`number`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of hunterconnect
-- ----------------------------
INSERT INTO `hunterconnect` VALUES ('2', '498', '2', '0');
