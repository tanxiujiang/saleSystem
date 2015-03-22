/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : salesystem

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-03-22 23:23:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(30) DEFAULT NULL,
  `factory_price` float DEFAULT NULL,
  `sell_price` float DEFAULT NULL,
  `total_amount` int(11) DEFAULT NULL,
  `remain_amount` int(11) DEFAULT NULL,
  `introduction` varchar(500) DEFAULT NULL,
  `image_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'U盘', '120', '150', '100', '80', '红色8G', null);
INSERT INTO `product` VALUES ('2', 'Iphone', '4800', '5500', '1200', '100', '金色', null);

-- ----------------------------
-- Table structure for `product_staff`
-- ----------------------------
DROP TABLE IF EXISTS `product_staff`;
CREATE TABLE `product_staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staffid` int(11) NOT NULL DEFAULT '0',
  `productid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_staff
-- ----------------------------
INSERT INTO `product_staff` VALUES ('1', '1', '1');
INSERT INTO `product_staff` VALUES ('2', '1', '2');
INSERT INTO `product_staff` VALUES ('3', '1', '1');

-- ----------------------------
-- Table structure for `staff`
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(16) NOT NULL,
  `sex` char(2) NOT NULL,
  `pwd` varchar(64) NOT NULL,
  `tel` varchar(30) NOT NULL,
  `introduce` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('1', 'harry', '男', '111111', '18202888720', '阳光帅气');
INSERT INTO `staff` VALUES ('2', 'leina', '女', '222222', '18289888280', '国宝');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES ('1', '国美', '成都市万年场99号', '品质第一');
INSERT INTO `store` VALUES ('2', '京东', '成都高新区', '速度第一');

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
