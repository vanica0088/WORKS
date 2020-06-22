/*
Navicat MySQL Data Transfer

Source Server         : 201721074007
Source Server Version : 50077
Source Host           : 210.42.145.77:3306
Source Database       : koalait

Target Server Type    : MYSQL
Target Server Version : 50077
File Encoding         : 65001

Date: 2019-12-27 11:53:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for resume
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume` (
  `resume_id` int(11) NOT NULL auto_increment,
  `name` varchar(255) collate utf8_bin NOT NULL,
  `education` varchar(255) collate utf8_bin NOT NULL,
  `self_introduction` varchar(255) collate utf8_bin NOT NULL,
  `phone` varchar(255) collate utf8_bin NOT NULL,
  `email` varchar(255) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`resume_id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of resume
-- ----------------------------
INSERT INTO `resume` VALUES ('12', '阿笨', '本科', '组长小号', '13937827711', '332@qq.com');
INSERT INTO `resume` VALUES ('5', '黄大仙', '大专', '本人擅长瞎逼逼，呸，算命', '13330596877', '110@qq.com');
INSERT INTO `resume` VALUES ('2', '王大', '本科', '我是一个朴实的程序猿。', '13821221211', '2122@qq.com');
