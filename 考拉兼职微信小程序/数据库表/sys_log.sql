/*
Navicat MySQL Data Transfer

Source Server         : 201721074007
Source Server Version : 50077
Source Host           : 210.42.145.77:3306
Source Database       : koalait

Target Server Type    : MYSQL
Target Server Version : 50077
File Encoding         : 65001

Date: 2019-12-27 11:53:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `LogID` int(11) NOT NULL,
  `user_id` int(11) default NULL,
  `IP_Address` varchar(255) default NULL,
  `OS` varchar(255) default NULL,
  `IE` varchar(255) NOT NULL,
  `CreateDate` date default NULL,
  `log_content` varchar(255) default NULL,
  PRIMARY KEY  (`LogID`,`IE`)
) ENGINE=MyISAM DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', '1', '210.42.145.77', 'windows', 'Internet Exployer', '2019-12-24', null);
INSERT INTO `sys_log` VALUES ('2', '3', '127.0.0.1', 'mac', 'IE', '2019-12-23', null);
