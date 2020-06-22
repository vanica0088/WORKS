/*
Navicat MySQL Data Transfer

Source Server         : 201721074007
Source Server Version : 50077
Source Host           : 210.42.145.77:3306
Source Database       : koalait

Target Server Type    : MYSQL
Target Server Version : 50077
File Encoding         : 65001

Date: 2019-12-27 11:51:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bossconnect
-- ----------------------------
DROP TABLE IF EXISTS `bossconnect`;
CREATE TABLE `bossconnect` (
  `number` int(11) NOT NULL auto_increment,
  `boss_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `check` int(11) NOT NULL,
  PRIMARY KEY  (`number`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of bossconnect
-- ----------------------------
INSERT INTO `bossconnect` VALUES ('1', '218', '2', '1');
INSERT INTO `bossconnect` VALUES ('2', '217', '3', '0');
INSERT INTO `bossconnect` VALUES ('24', '3', '2', '1');
INSERT INTO `bossconnect` VALUES ('21', '210', '21', '0');
INSERT INTO `bossconnect` VALUES ('22', '214', '21', '0');
INSERT INTO `bossconnect` VALUES ('23', '198', '21', '0');
INSERT INTO `bossconnect` VALUES ('25', '6', '3', '0');
