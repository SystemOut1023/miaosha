/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2018-05-18 17:38:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(4) NOT NULL,
  `goodsName` varchar(20) NOT NULL,
  `goodsNum` int(10) NOT NULL,
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`goodsName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', 'mobile', '1', '2018-05-18 17:04:25');
INSERT INTO `goods` VALUES ('2', 'notebook', '198', '2018-05-17 14:03:42');

-- ----------------------------
-- Table structure for secondskill
-- ----------------------------
DROP TABLE IF EXISTS `secondskill`;
CREATE TABLE `secondskill` (
  `id` int(11) NOT NULL,
  `userName` varchar(0) DEFAULT NULL,
  `goodsName` varchar(0) DEFAULT NULL,
  `carateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of secondskill
-- ----------------------------
INSERT INTO `secondskill` VALUES ('1', null, null, '2018-05-17 16:43:32');
