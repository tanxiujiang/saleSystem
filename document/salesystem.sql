/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : salesystem

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2015-03-31 19:23:17
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
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` varchar(30) NOT NULL COMMENT '产品的唯一标识',
  `product_name` varchar(30) NOT NULL,
  `factory_price` float NOT NULL,
  `sell_price` float NOT NULL,
  `total_amount` int(11) NOT NULL,
  `remain_amount` int(11) NOT NULL,
  `introduction` varchar(500) DEFAULT NULL,
  `image_url` varchar(100) DEFAULT NULL,
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0表示逻辑删除，1表示存在',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'U盘', '120', '150', '100', '80', '红色8G', null, '0');
INSERT INTO `product` VALUES ('2', 'Iphone', '4800', '5500', '1200', '100', '金色', null, '0');
INSERT INTO `product` VALUES ('20150330091852027859', '裙子', '145', '178', '122', '102', '娅 2015春夏新款韩版女装连衣裙欧根纱修身公主裙雪纺无袖背心印花裙子0066 粉红色 L         ', null, '0');
INSERT INTO `product` VALUES ('20150331065616065591', '诺基亚5230', '1150', '1350', '100', '100', '诺基亚全国质量第一，销量第一。', null, '0');
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
  `productid` varchar(30) NOT NULL COMMENT '产品表主键',
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
-- Table structure for `sale_order`
-- ----------------------------
DROP TABLE IF EXISTS `sale_order`;
CREATE TABLE `sale_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` varchar(30) NOT NULL,
  `staff_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL COMMENT '卖出数量',
  `sell_price` double NOT NULL COMMENT '售价',
  `sell_date` varchar(255) NOT NULL COMMENT '卖出时间，字符串存储',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sale_order
-- ----------------------------
INSERT INTO `sale_order` VALUES ('2', '1', '10', '2', '150', '2015-03-30 11:27:57');
INSERT INTO `sale_order` VALUES ('3', '1', '10', '2', '150', '2015-03-30 11:27:57');
INSERT INTO `sale_order` VALUES ('4', '1', '10', '2', '150', '2015-03-30 11:27:57');
INSERT INTO `sale_order` VALUES ('5', '2', '10', '2', '5500', '2015-03-30 12:15:27');
INSERT INTO `sale_order` VALUES ('6', '20150330052037005969', '10', '20', '300', '2015-03-30 05:28:59');
INSERT INTO `sale_order` VALUES ('7', '20150330052037005969', '10', '10', '300', '2015-03-30 05:38:51');
INSERT INTO `sale_order` VALUES ('8', '20150330052037005969', '10', '5', '300', '2015-03-30 05:45:01');
INSERT INTO `sale_order` VALUES ('9', '20150330091852027859', '10', '2', '178', '2015-03-31 04:46:45');
INSERT INTO `sale_order` VALUES ('10', '20150330091852027859', '10', '2', '178', '2015-03-31 04:50:07');
INSERT INTO `sale_order` VALUES ('11', '20150330091852027859', '10', '2', '178', '2015-03-31 04:53:19');
INSERT INTO `sale_order` VALUES ('12', '20150330091852027859', '10', '2', '178', '2015-03-31 04:56:03');
INSERT INTO `sale_order` VALUES ('13', '20150330091852027859', '10', '2', '178', '2015-03-31 05:00:15');
INSERT INTO `sale_order` VALUES ('14', '20150330091852027859', '10', '2', '178', '2015-03-31 05:13:46');
INSERT INTO `sale_order` VALUES ('15', '20150330091852027859', '10', '2', '178', '2015-03-31 05:17:19');
INSERT INTO `sale_order` VALUES ('16', '20150330091852027859', '10', '2', '178', '2015-03-31 05:20:06');
INSERT INTO `sale_order` VALUES ('17', '20150330091852027859', '10', '2', '178', '2015-03-31 05:42:56');
INSERT INTO `sale_order` VALUES ('18', '20150330091852027859', '10', '2', '178', '2015-03-31 06:02:03');

-- ----------------------------
-- Table structure for `sale_product`
-- ----------------------------
DROP TABLE IF EXISTS `sale_product`;
CREATE TABLE `sale_product` (
  `id` int(11) NOT NULL,
  `product_id` varchar(30) NOT NULL,
  `staff_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `sell_price` double NOT NULL,
  `sell_date` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sale_product
-- ----------------------------

-- ----------------------------
-- Table structure for `staff`
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `email` varchar(30) DEFAULT NULL,
  `name` varchar(16) NOT NULL,
  `sex` char(2) NOT NULL,
  `pwd` varchar(64) NOT NULL DEFAULT '111111',
  `tel` varchar(30) NOT NULL,
  `introduction` varchar(1000) DEFAULT NULL,
  `store_id` int(11) NOT NULL,
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0表示逻辑未删除，1表示逻辑删除',
  `role` int(11) NOT NULL DEFAULT '0' COMMENT '0表示职工，2表示管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('1', '1026741591@qq.com', 'harry', '男', '111111', '18202888720', '阳光帅气', '0', '0', '0');
INSERT INTO `staff` VALUES ('2', '1026741592@qq.com', 'leina', '女', '222222', '18289888280', '国宝', '0', '0', '0');
INSERT INTO `staff` VALUES ('8', '1026741593@qq.com', 'lisary', '男', '111111', '18202888720', '好样儿的', '0', '0', '0');
INSERT INTO `staff` VALUES ('9', '1026741594@qq.com', 'leina', 'on', '111111', '18202888720', '大家好才是真的好，广州好滴.', '5', '0', '0');
INSERT INTO `staff` VALUES ('10', '1026741595@qq.com', 'lisary', 'on', '111111', '13540660605', '大学本科，现在在成都安科思有限公司上班.		         ', '5', '0', '0');
INSERT INTO `staff` VALUES ('11', null, 'fanny', 'on', '111111', '13540660605', '实习生.			         ', '2', '0', '0');
INSERT INTO `staff` VALUES ('12', null, 'zhangbing', '男', '111111', '12123123132132', '二逼青年欢乐多', '1', '0', '0');

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
