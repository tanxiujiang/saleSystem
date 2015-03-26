/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : salesystem

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-03-27 00:32:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(30) NOT NULL,
  `pwd` varchar(30) NOT NULL,
  `name` varchar(12) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '1026741594@qq.com', '123', '肖苗');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `staff_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL COMMENT '卖出数量',
  `sell_price` float NOT NULL COMMENT '售价',
  `sell_date` varchar(255) NOT NULL COMMENT '卖出时间，字符串存储',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(30) NOT NULL,
  `factory_price` float NOT NULL,
  `sell_price` float NOT NULL,
  `total_amount` int(11) NOT NULL,
  `remain_amount` int(11) NOT NULL,
  `introduction` varchar(500) DEFAULT NULL,
  `image_url` varchar(100) DEFAULT NULL,
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0表示逻辑删除，1表示存在',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'U盘', '120', '150', '100', '80', '红色8G', null, '0');
INSERT INTO `product` VALUES ('2', 'Iphone', '4800', '5500', '1200', '100', '金色', null, '0');
INSERT INTO `product` VALUES ('3', '纯棉超薄羽绒服', '120', '150', '100', '100', '跳楼价，赶紧抢购吧。', '', '0');
INSERT INTO `product` VALUES ('4', '纯棉超薄羽绒服', '120', '150', '100', '100', '跳楼价，赶紧抢购吧。', '', '0');
INSERT INTO `product` VALUES ('5', '小米(Note)', '1200', '1500', '100', '100', '价格实惠，便宜好用.			         ', null, '0');
INSERT INTO `product` VALUES ('6', '华为', '850', '100', '1000', '1000', '					         	\r\n		大大大达大厦			         ', null, '0');

-- ----------------------------
-- Table structure for `product_staff`
-- ----------------------------
DROP TABLE IF EXISTS `product_staff`;
CREATE TABLE `product_staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staffid` int(11) NOT NULL DEFAULT '0',
  `productid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_staff
-- ----------------------------
INSERT INTO `product_staff` VALUES ('1', '1', '1');
INSERT INTO `product_staff` VALUES ('2', '1', '2');
INSERT INTO `product_staff` VALUES ('3', '1', '1');
INSERT INTO `product_staff` VALUES ('4', '1', '1');
INSERT INTO `product_staff` VALUES ('5', '1', '6');
INSERT INTO `product_staff` VALUES ('6', '1', '6');
INSERT INTO `product_staff` VALUES ('7', '1', '4');
INSERT INTO `product_staff` VALUES ('8', '1', '4');
INSERT INTO `product_staff` VALUES ('9', '1', '5');
INSERT INTO `product_staff` VALUES ('10', '1', '5');
INSERT INTO `product_staff` VALUES ('11', '1', '5');
INSERT INTO `product_staff` VALUES ('12', '1', '5');
INSERT INTO `product_staff` VALUES ('13', '1', '5');

-- ----------------------------
-- Table structure for `staff`
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(16) NOT NULL,
  `sex` char(2) NOT NULL,
  `pwd` varchar(64) NOT NULL DEFAULT '111111',
  `tel` varchar(30) NOT NULL,
  `introduction` varchar(1000) DEFAULT NULL,
  `store_id` int(11) NOT NULL,
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0表示逻辑未删除，1表示逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('1', 'harry', '男', '111111', '18202888720', '阳光帅气', '0', '0');
INSERT INTO `staff` VALUES ('2', 'leina', '女', '222222', '18289888280', '国宝', '0', '0');
INSERT INTO `staff` VALUES ('8', 'lisary', '男', '111111', '18202888720', '好样儿的', '0', '0');
INSERT INTO `staff` VALUES ('9', 'leina', 'on', '111111', '18202888720', '大家好才是真的好，广州好滴.', '5', '0');
INSERT INTO `staff` VALUES ('10', 'lisary', 'on', '111111', '13540660605', '大学本科，现在在成都安科思有限公司上班.		         ', '5', '0');

-- ----------------------------
-- Table structure for `store`
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `store_name` varchar(100) DEFAULT NULL,
  `adress` varchar(100) DEFAULT NULL,
  `introduce` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES ('1', '国美', '成都市万年场99号', '品质第一');
INSERT INTO `store` VALUES ('2', '京东', '成都高新区', '速度第一');
INSERT INTO `store` VALUES ('5', '红旗超市1', '成都花牌坊街', '世界500强');
INSERT INTO `store` VALUES ('6', '红旗超市2', '成都西门车站', '中国100强');

-- ----------------------------
-- Table structure for `store_product`
-- ----------------------------
DROP TABLE IF EXISTS `store_product`;
CREATE TABLE `store_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `storeId` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store_product
-- ----------------------------
INSERT INTO `store_product` VALUES ('1', '1', '1');
INSERT INTO `store_product` VALUES ('2', '1', '1');
INSERT INTO `store_product` VALUES ('3', '1', '2');

-- ----------------------------
-- Table structure for `store_staff`
-- ----------------------------
DROP TABLE IF EXISTS `store_staff`;
CREATE TABLE `store_staff` (
  `store_id` int(11) NOT NULL,
  `staff_id` int(11) NOT NULL,
  PRIMARY KEY (`store_id`,`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store_staff
-- ----------------------------
INSERT INTO `store_staff` VALUES ('1', '1');
INSERT INTO `store_staff` VALUES ('2', '2');
