/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80020
Source Host           : localhost:3306
Source Database       : hui_shop

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2020-07-24 18:17:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_album
-- ----------------------------
DROP TABLE IF EXISTS `tb_album`;
CREATE TABLE `tb_album` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(100) DEFAULT NULL COMMENT '相册名称',
  `image` varchar(100) DEFAULT NULL COMMENT '相册封面',
  `image_items` text COMMENT '图片列表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_album
-- ----------------------------

-- ----------------------------
-- Table structure for tb_banner
-- ----------------------------
DROP TABLE IF EXISTS `tb_banner`;
CREATE TABLE `tb_banner` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `sort` tinyint DEFAULT NULL,
  `type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '类型  0  轮播图，1 new新品  2 recommend推荐  3 hot热门',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_banner
-- ----------------------------
INSERT INTO `tb_banner` VALUES ('1', '花姑娘', 'https://www.baidu.com', 'http://b2c.rageframe.com/attachment/images/2020/06/30/image_1593523585_C62i54oG.png', '1', '0');
INSERT INTO `tb_banner` VALUES ('2', '啊啊啊', 'https://www.baidu.com', 'http://b2c.rageframe.com/attachment/images/2020/06/30/image_1593522285_wPCKtcCf.png', '2', '0');
INSERT INTO `tb_banner` VALUES ('3', '888', '333', 'http://b2c.rageframe.com/attachment/images/2020/06/30/image_1593523284_r3K487yh.png', '1', '2');
INSERT INTO `tb_banner` VALUES ('4', '666', '111', 'http://b2c.rageframe.com/attachment/images/2020/06/30/image_1593523585_C62i54oG.png', '1', '1');
INSERT INTO `tb_banner` VALUES ('5', '666', '122', 'http://b2c.rageframe.com/attachment/images/2020/06/30/image_1593522285_wPCKtcCf.png', '2', '3');

-- ----------------------------
-- Table structure for tb_brand
-- ----------------------------
DROP TABLE IF EXISTS `tb_brand`;
CREATE TABLE `tb_brand` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '品牌id',
  `name` varchar(100) NOT NULL COMMENT '品牌名称',
  `image` varchar(1000) DEFAULT '' COMMENT '品牌图片地址',
  `letter` char(1) DEFAULT '' COMMENT '品牌的首字母',
  `seq` int DEFAULT NULL COMMENT '排序',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  `updatedate` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='品牌表';

-- ----------------------------
-- Records of tb_brand
-- ----------------------------
INSERT INTO `tb_brand` VALUES ('1', '森马', null, 'S', '1', '2020-07-21 16:32:20', '2020-07-21 16:32:20');

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `name` varchar(50) DEFAULT NULL COMMENT '分类名称',
  `caption` varchar(50) DEFAULT NULL COMMENT '副标题',
  `image` varchar(200) DEFAULT NULL COMMENT '图片',
  `goods_num` int DEFAULT '0' COMMENT '商品数量',
  `is_show` bit(1) DEFAULT b'1' COMMENT '是否显示0不显示  1显示',
  `is_nav` bit(1) DEFAULT b'0' COMMENT '是否导航0 false  1true',
  `seq` int DEFAULT NULL COMMENT '排序',
  `parent_id` int DEFAULT '0' COMMENT '上级ID',
  `template_id` int DEFAULT NULL COMMENT '模板ID',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  `updatedate` datetime DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(1) DEFAULT '0' COMMENT '0 可用  1不可用 2删除',
  `is_hot` bit(1) DEFAULT b'0' COMMENT '是否热门',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `parent_id` (`parent_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品类目';

-- ----------------------------
-- Records of tb_category
-- ----------------------------
INSERT INTO `tb_category` VALUES ('1', '时尚女装', '女装', 'http://www.yllook.com/attachment/images/2019/12/24/image_157717039810157100.jpg', '0', '', '', '1', '0', '1', '2020-07-18 17:57:14', '2020-07-21 18:06:01', '0', '');
INSERT INTO `tb_category` VALUES ('2', '潮流男装', '男装', 'http://www.yllook.com/attachment/images/2019/12/24/image_157717039810157100.jpg', '0', '', '', '2', '0', '1', '2020-07-18 18:02:35', '2020-07-21 18:06:14', '0', '');
INSERT INTO `tb_category` VALUES ('3', '女士上衣', '女士上衣', 'http://www.yllook.com/attachment/images/2019/12/24/image_157717039810157100.jpg', '0', '', '', '1', '1', '1', '2020-07-18 18:03:09', '2020-07-18 18:03:09', '0', '\0');
INSERT INTO `tb_category` VALUES ('4', '时尚裙子', '裙子', '/images/b951762990004021a587640c7cff307c/连衣裙.png', '0', '', '', '2', '1', '1', '2020-07-18 18:03:46', '2020-07-19 15:41:37', '0', '\0');
INSERT INTO `tb_category` VALUES ('5', '女士裤装', '女士裤装', 'https://www.yllook.com/attachment/images/2020/05/10/image_1589088571_Xbo89eR9.jpg', '0', '', '', '3', '1', '1', '2020-07-18 18:04:31', '2020-07-18 18:04:31', '0', '\0');
INSERT INTO `tb_category` VALUES ('6', '内衣内裤', '内衣内裤', 'https://www.yllook.com/attachment/images/2020/05/10/image_1589088571_Xbo89eR9.jpg', '0', '', '', '4', '1', '1', '2020-07-18 18:05:46', '2020-07-18 18:05:46', '0', '\0');
INSERT INTO `tb_category` VALUES ('7', '男士上衣', '男士上衣', 'http://www.yllook.com/attachment/images/2019/12/24/image_157717039810157100.jpg', '0', '', '', '1', '2', '1', '2020-07-18 18:06:38', '2020-07-21 18:06:32', '0', '');
INSERT INTO `tb_category` VALUES ('8', '男士裤装', '男士裤装', 'https://www.yllook.com/attachment/images/2020/05/10/image_1589088571_Xbo89eR9.jpg', '0', '', '', '1', '2', '1', '2020-07-18 18:07:01', '2020-07-21 18:06:31', '0', '');
INSERT INTO `tb_category` VALUES ('9', '内衣内裤', '内衣内裤', 'https://www.yllook.com/attachment/images/2020/05/10/image_1589088571_Xbo89eR9.jpg', '0', '', '', '3', '2', '1', '2020-07-18 18:07:16', '2020-07-21 18:06:32', '0', '');
INSERT INTO `tb_category` VALUES ('10', 'T恤', 'T恤', '/images/a95cc2c354e44276be655a503c9b2268/T恤.png', '0', '', '', '1', '3', '1', '2020-07-18 18:12:36', '2020-07-19 15:56:47', '0', '\0');
INSERT INTO `tb_category` VALUES ('11', '衬衫', '衬衫', '/images/a95cc2c354e44276be655a503c9b2268/衬衫.png', '0', '', '', '2', '3', '1', '2020-07-18 18:13:04', '2020-07-19 15:58:25', '0', '\0');
INSERT INTO `tb_category` VALUES ('12', '卫衣', '卫衣', '/images/a95cc2c354e44276be655a503c9b2268/卫衣.png', '0', '', '', '3', '3', '1', '2020-07-18 18:13:28', '2020-07-19 15:59:15', '0', '\0');
INSERT INTO `tb_category` VALUES ('13', '针织衫', '针织衫', '/images/a95cc2c354e44276be655a503c9b2268/针织衫.png', '0', '', '', '3', '3', '1', '2020-07-18 18:13:53', '2020-07-19 16:00:00', '0', '\0');
INSERT INTO `tb_category` VALUES ('14', '打底衫', '打底衫', 'https://www.yllook.com/attachment/images/2020/05/10/image_1589088571_Xbo89eR9.jpg', '0', '', '', '5', '3', '1', '2020-07-18 18:14:39', '2020-07-18 18:14:39', '0', '\0');
INSERT INTO `tb_category` VALUES ('15', '连衣裙', '连衣裙', '/images/ed86f23dba924958bea2f248d278c5ee/连衣裙.png', '0', '', '', '1', '4', '1', '2020-07-18 18:15:15', '2020-07-19 15:45:43', '0', '\0');
INSERT INTO `tb_category` VALUES ('16', '半身裙', '半身裙', '/images/ed86f23dba924958bea2f248d278c5ee/半身裙.png', '0', '', '', '2', '4', '1', '2020-07-18 18:15:32', '2020-07-19 15:48:34', '0', '\0');
INSERT INTO `tb_category` VALUES ('17', '牛仔裤', '牛仔裤', null, '0', '', '', '1', '5', '1', '2020-07-18 18:16:38', '2020-07-18 18:16:38', '0', '\0');
INSERT INTO `tb_category` VALUES ('18', '休闲裤', '休闲裤', null, '0', '', '', '1', '5', '1', '2020-07-18 18:16:51', '2020-07-18 18:16:51', '0', '\0');
INSERT INTO `tb_category` VALUES ('19', '小脚裤', '小脚裤', null, '0', '', '', '3', '5', '1', '2020-07-18 18:17:09', '2020-07-18 18:17:09', '0', '\0');
INSERT INTO `tb_category` VALUES ('20', '阔腿裤', '阔腿裤', null, '0', '', '', '1', '5', '1', '2020-07-18 18:17:57', '2020-07-18 18:17:57', '0', '\0');
INSERT INTO `tb_category` VALUES ('21', '正装裤', '正装裤', null, '0', '', '', '1', '5', '1', '2020-07-18 18:18:25', '2020-07-18 18:18:25', '0', '\0');
INSERT INTO `tb_category` VALUES ('22', '文胸', '文胸', null, '0', '', '', '1', '6', '1', '2020-07-18 18:18:44', '2020-07-18 18:18:44', '0', '\0');
INSERT INTO `tb_category` VALUES ('23', '内裤', '内裤', null, '0', '', '', '1', '6', '1', '2020-07-18 18:18:53', '2020-07-18 18:18:53', '0', '\0');
INSERT INTO `tb_category` VALUES ('24', '睡衣/居家衣', '睡衣/居家衣', null, '0', '', '', '1', '6', '1', '2020-07-18 18:19:13', '2020-07-18 18:19:13', '0', '\0');
INSERT INTO `tb_category` VALUES ('25', '吊带背心', '吊带背心', null, '0', '', '', '1', '6', '1', '2020-07-18 18:19:33', '2020-07-18 18:19:33', '0', '\0');
INSERT INTO `tb_category` VALUES ('26', '塑身美体', '塑身美体', null, '0', '', '', null, '6', '1', '2020-07-18 18:19:53', '2020-07-18 18:19:53', '0', '\0');
INSERT INTO `tb_category` VALUES ('27', 'T恤', 'T恤', null, '0', '', '', '1', '7', '1', '2020-07-18 18:20:30', '2020-07-18 18:20:30', '0', '\0');
INSERT INTO `tb_category` VALUES ('28', 'POLO衫', 'POLO衫', null, '0', '', '', '2', '7', '1', '2020-07-18 18:20:40', '2020-07-18 18:20:40', '0', '\0');
INSERT INTO `tb_category` VALUES ('29', '衬衫', '衬衫', null, '0', '', '', '3', '7', '1', '2020-07-18 18:20:51', '2020-07-18 18:20:51', '0', '\0');
INSERT INTO `tb_category` VALUES ('30', '卫衣', '卫衣', null, '0', '', '', null, '7', '1', '2020-07-18 18:21:09', '2020-07-18 18:21:09', '0', '\0');
INSERT INTO `tb_category` VALUES ('31', '卫衣', '卫衣', null, '0', '', '', null, '7', '1', '2020-07-18 18:21:34', '2020-07-18 18:21:34', '0', '\0');
INSERT INTO `tb_category` VALUES ('32', '长袖', '长袖', null, '0', '', '', null, '7', '1', '2020-07-18 18:21:44', '2020-07-18 18:21:44', '0', '\0');
INSERT INTO `tb_category` VALUES ('33', '针织衫', '针织衫', null, '0', '', '', null, '7', '1', '2020-07-18 18:21:54', '2020-07-18 18:21:54', '0', '\0');
INSERT INTO `tb_category` VALUES ('34', '夹克', '夹克', null, '0', '', '', null, '7', '1', '2020-07-18 18:22:13', '2020-07-18 18:22:13', '0', '\0');
INSERT INTO `tb_category` VALUES ('35', '外套', '外套', null, '0', '', '', '1', '7', '1', '2020-07-18 18:22:23', '2020-07-18 18:22:23', '0', '\0');
INSERT INTO `tb_category` VALUES ('36', '风衣', '风衣', null, '0', '', '', null, '7', '1', '2020-07-18 18:22:33', '2020-07-18 18:22:33', '0', '\0');
INSERT INTO `tb_category` VALUES ('37', '休闲裤', '休闲裤', null, '0', '', '', null, '8', '1', '2020-07-18 18:22:44', '2020-07-18 18:22:44', '0', '\0');
INSERT INTO `tb_category` VALUES ('38', '牛仔裤', '牛仔裤', null, '0', '', '', '1', '8', '1', '2020-07-18 18:22:52', '2020-07-18 18:22:52', '0', '\0');
INSERT INTO `tb_category` VALUES ('39', '运动裤', '运动裤', null, '0', '', '', null, '8', '1', '2020-07-18 18:23:07', '2020-07-18 18:23:07', '0', '\0');
INSERT INTO `tb_category` VALUES ('40', '短裤', '短裤', null, '0', '', '', null, '8', '1', '2020-07-18 18:23:15', '2020-07-18 18:23:15', '0', '\0');
INSERT INTO `tb_category` VALUES ('41', '九分裤', '九分裤', null, '0', '', '', null, '8', '1', '2020-07-18 18:23:24', '2020-07-18 18:23:24', '0', '\0');
INSERT INTO `tb_category` VALUES ('42', '西裤', '西裤', null, '0', '', '', null, '8', '1', '2020-07-18 18:23:36', '2020-07-18 18:23:36', '0', '\0');
INSERT INTO `tb_category` VALUES ('43', '三角内裤', '三角内裤', null, '0', '', '', null, '9', '1', '2020-07-18 18:24:37', '2020-07-19 13:02:05', '0', '\0');

-- ----------------------------
-- Table structure for tb_category_brand
-- ----------------------------
DROP TABLE IF EXISTS `tb_category_brand`;
CREATE TABLE `tb_category_brand` (
  `category_id` int NOT NULL COMMENT '分类ID',
  `brand_id` int NOT NULL COMMENT '品牌ID',
  PRIMARY KEY (`category_id`,`brand_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_category_brand
-- ----------------------------

-- ----------------------------
-- Table structure for tb_dict
-- ----------------------------
DROP TABLE IF EXISTS `tb_dict`;
CREATE TABLE `tb_dict` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dict_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `dict_value` varchar(255) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_dict
-- ----------------------------
INSERT INTO `tb_dict` VALUES ('1', 'a', '1', '2020-07-23 17:05:19', '2020-07-23 17:50:32');
INSERT INTO `tb_dict` VALUES ('2', 'b', 'c', '2020-07-23 17:50:49', '2020-07-23 17:50:49');

-- ----------------------------
-- Table structure for tb_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `tb_dict_item`;
CREATE TABLE `tb_dict_item` (
  `dict_item_id` int NOT NULL AUTO_INCREMENT,
  `dict_id` int NOT NULL COMMENT '字典id',
  `dict_item_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `dict_item_value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典值名称',
  `sort` int NOT NULL DEFAULT '0' COMMENT '排序字段',
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  PRIMARY KEY (`dict_item_id`),
  KEY `index_dict_id` (`dict_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_dict_item
-- ----------------------------
INSERT INTO `tb_dict_item` VALUES ('1', '1', '手动', 'munal', '1', null, '2020-07-24 10:36:49');
INSERT INTO `tb_dict_item` VALUES ('2', '1', '自动', 'auto', '1', null, '2020-07-24 10:37:33');
INSERT INTO `tb_dict_item` VALUES ('3', '2', 'SP', 'SP', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('4', '2', 'SB', 'SB', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('5', '2', 'SD', 'SD', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('6', '3', '数据趋势', 'form_trend', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('7', '3', '数据对比', 'form_contrast', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('8', '3', '广告数据', 'form_ad_data', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('9', '3', '产品数据', 'form_product_data', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('10', '3', '广告活动', 'form_activity', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('11', '3', '国家数据', 'form_country_data', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('12', '3', '店铺数据', 'form_shop_data', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('13', '3', '部门数据', 'form_dept_data', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('14', '4', 'SC', 'SC', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('15', '4', 'VC', 'VC', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('16', '6', 'USD（美元）', 'USD', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('17', '6', 'CNY（人民币）', 'CNY', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('18', '6', '原币种', 'ORIG', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('19', '7', '环比', '1', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('20', '7', '同比', '2', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('21', '7', '任意时间段', '3', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('22', '8', '广告销售额', 'sales', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('23', '8', '广告订单数', 'orders', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('24', '8', '广告花费金额', 'spend', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('25', '8', '广告点击量', 'clicks', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('26', '8', 'ACoS', 'acos', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('27', '8', 'CTR', 'ctr', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('28', '8', 'CPC', 'cpc', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('29', '8', 'CVR', 'cvr', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('30', '8', '曝光量', 'impressions', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('31', '9', 'Impressions', 'impressions', '1', null, null);
INSERT INTO `tb_dict_item` VALUES ('32', '9', 'Clicks', 'clicks', '2', null, null);
INSERT INTO `tb_dict_item` VALUES ('33', '9', 'CTR', 'ctr', '3', null, null);
INSERT INTO `tb_dict_item` VALUES ('34', '9', 'Spend', 'spend', '4', null, null);
INSERT INTO `tb_dict_item` VALUES ('35', '9', 'CPC', 'cpc', '5', null, null);
INSERT INTO `tb_dict_item` VALUES ('36', '9', 'CPM', 'cpm', '6', null, null);
INSERT INTO `tb_dict_item` VALUES ('37', '9', 'DPV', 'dpv', '7', null, null);
INSERT INTO `tb_dict_item` VALUES ('38', '9', 'DPV Clicks', 'dpvClicks', '8', null, null);
INSERT INTO `tb_dict_item` VALUES ('39', '9', 'Cost Per DPV', 'sdpv', '9', null, null);
INSERT INTO `tb_dict_item` VALUES ('40', '9', 'Cost Per ATC', 'satc', '10', null, null);
INSERT INTO `tb_dict_item` VALUES ('41', '10', 'Orders', 'orders', '11', null, null);
INSERT INTO `tb_dict_item` VALUES ('42', '10', 'Sales', 'sales', '12', null, null);
INSERT INTO `tb_dict_item` VALUES ('43', '10', 'ACoS', 'acos', '3', null, null);
INSERT INTO `tb_dict_item` VALUES ('44', '10', 'CVR', 'cvr', '14', null, null);
INSERT INTO `tb_dict_item` VALUES ('45', '10', 'CPA', 'cpa', '15', null, null);
INSERT INTO `tb_dict_item` VALUES ('46', '10', 'ROAS', 'roas', '16', null, null);
INSERT INTO `tb_dict_item` VALUES ('47', '10', 'Units', 'units', '17', null, null);
INSERT INTO `tb_dict_item` VALUES ('48', '10', 'ATC', 'atc', '18', null, null);
INSERT INTO `tb_dict_item` VALUES ('49', '10', 'ATC Clicks', 'atcClicks', '19', null, null);
INSERT INTO `tb_dict_item` VALUES ('50', '10', 'Orders Clicks', 'ordersClicks', '20', null, null);
INSERT INTO `tb_dict_item` VALUES ('51', '10', 'Sales Clicks', 'salesClicks', '21', null, null);
INSERT INTO `tb_dict_item` VALUES ('52', '10', 'ACoS Clicks', 'acosClicks', '22', null, null);
INSERT INTO `tb_dict_item` VALUES ('53', '10', 'ROAS Clicks', 'roasClicks', '23', null, null);
INSERT INTO `tb_dict_item` VALUES ('54', '10', 'Advertised Sku Units', 'advertisedSkuUnits', '24', null, null);
INSERT INTO `tb_dict_item` VALUES ('55', '10', 'Brand Asin Units', 'brandAsinUnits', '25', null, null);
INSERT INTO `tb_dict_item` VALUES ('56', '10', 'Advertised Asin Sales', 'advertisedAsinSales', '26', null, null);
INSERT INTO `tb_dict_item` VALUES ('57', '10', 'Brand Asin Sales', 'brandAsinSales', '27', null, null);
INSERT INTO `tb_dict_item` VALUES ('58', '10', 'Advertised Sku Sales', 'advertisedSkuSales', '28', null, null);
INSERT INTO `tb_dict_item` VALUES ('59', '10', 'Other Sku Units', 'otherSkuUnits', '29', null, null);
INSERT INTO `tb_dict_item` VALUES ('60', '10', 'Other Sku Sales', 'otherSkuSales', '30', null, null);
INSERT INTO `tb_dict_item` VALUES ('61', '10', 'Other Sku Orders', 'otherSkuOrders', '31', null, null);
INSERT INTO `tb_dict_item` VALUES ('62', '11', 'NTB Orders', 'ntbOrders', '34', null, null);
INSERT INTO `tb_dict_item` VALUES ('63', '11', 'NTB Sales', 'ntbSales', '35', null, null);
INSERT INTO `tb_dict_item` VALUES ('64', '11', 'NTB Units', 'ntbUnits', '36', null, null);
INSERT INTO `tb_dict_item` VALUES ('65', '11', 'NTB Orders Clicks', 'ntbOrdersClicks', '37', null, null);
INSERT INTO `tb_dict_item` VALUES ('66', '11', 'NTB Sales Clicks', 'ntbSalesClicks', '38', null, null);
INSERT INTO `tb_dict_item` VALUES ('67', '11', '% Of Orders NTB', 'ntboo', '39', null, null);
INSERT INTO `tb_dict_item` VALUES ('68', '11', '% Of Sales NTB', 'ntbss', '40', null, null);
INSERT INTO `tb_dict_item` VALUES ('69', '11', '% Of Units NTB', 'ntbuu', '41', null, null);
INSERT INTO `tb_dict_item` VALUES ('70', '11', 'NTB Orders Rate', 'ntbor', '42', null, null);
INSERT INTO `tb_dict_item` VALUES ('71', '12', '净收入', 'netIncome', '43', null, null);
INSERT INTO `tb_dict_item` VALUES ('74', '12', '广告SKU销售额占销售收入比值', 'skus', '52', null, null);
INSERT INTO `tb_dict_item` VALUES ('75', '12', '销售收入', 'totalSales', '45', null, null);
INSERT INTO `tb_dict_item` VALUES ('76', '12', '订单数', 'totalOrders', '46', null, null);
INSERT INTO `tb_dict_item` VALUES ('77', '12', '广告销售额占净收比值', 'asi', '48', null, null);
INSERT INTO `tb_dict_item` VALUES ('78', '12', '广告花费占净收比值', 'aps', '47', null, null);
INSERT INTO `tb_dict_item` VALUES ('79', '12', '广告订单占订单数比值', 'aos', '50', null, null);
INSERT INTO `tb_dict_item` VALUES ('80', '13', 'reportDate', 'reportDate', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('81', '13', 'amazonaccount', 'amazonaccountid', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('82', '13', 'campaign', 'campaignLocalId', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('83', '13', 'team', 'team', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('84', '13', 'country', 'country', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('85', '13', 'adType', 'adTypeStr', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('86', '13', 'product Name', 'productName', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('87', '13', 'product Model', 'productModel', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('88', '13', 'adGroup', 'adGroupLocalId', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('89', '13', 'erpSku', 'erpSku', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('90', '13', 'asin', 'asin', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('91', '13', 'msku', 'msku', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('92', '13', 'keyword', 'keywordText', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('93', '13', 'matchType', 'matchType', '0', null, null);
INSERT INTO `tb_dict_item` VALUES ('94', '10', '推广商品的销售额百分比', 'askuss', '32', null, null);
INSERT INTO `tb_dict_item` VALUES ('95', '10', '推广商品售出的商品数量百分比', 'askuUnits', '33', null, null);
INSERT INTO `tb_dict_item` VALUES ('96', '12', '广告销售额占销售收入比值', 'ass', '51', null, null);
INSERT INTO `tb_dict_item` VALUES ('98', '12', '订单销量', 'salesQty', '53', null, null);
INSERT INTO `tb_dict_item` VALUES ('99', '12', '广告订单占订单销量比值', 'skuUnitQty', '54', null, null);
INSERT INTO `tb_dict_item` VALUES ('100', '12', '广告花费占销售收入比值', 'sps', '49', null, null);
INSERT INTO `tb_dict_item` VALUES ('101', '12', 'FBA在库可售数量', 'afnFulfillableQty', '55', null, null);
INSERT INTO `tb_dict_item` VALUES ('102', '12', 'FBA在库可售天数', 'fbaAvailableDays', '56', null, null);
INSERT INTO `tb_dict_item` VALUES ('103', '12', 'FBA在库数量', 'fbaInStockQty', '57', null, null);
INSERT INTO `tb_dict_item` VALUES ('105', '1', '777', '7', '7', '2020-07-24 14:53:37', '2020-07-24 14:53:37');

-- ----------------------------
-- Table structure for tb_para
-- ----------------------------
DROP TABLE IF EXISTS `tb_para`;
CREATE TABLE `tb_para` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `options` varchar(2000) DEFAULT NULL COMMENT '选项',
  `seq` int DEFAULT NULL COMMENT '排序',
  `template_id` int DEFAULT NULL COMMENT '模板ID',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  `updatedate` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_para
-- ----------------------------
INSERT INTO `tb_para` VALUES ('1', '裙长', '短裙', '1', '1', '2020-07-21 17:32:34', '2020-07-21 17:32:34');
INSERT INTO `tb_para` VALUES ('2', '袖长', '短袖,长袖', '2', '1', '2020-07-21 17:32:49', '2020-07-21 17:32:49');
INSERT INTO `tb_para` VALUES ('3', '腰型', '松紧腰', '3', '1', '2020-07-21 17:33:11', '2020-07-21 17:33:11');

-- ----------------------------
-- Table structure for tb_pref
-- ----------------------------
DROP TABLE IF EXISTS `tb_pref`;
CREATE TABLE `tb_pref` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `cate_id` int DEFAULT NULL COMMENT '分类ID',
  `buy_money` int DEFAULT NULL COMMENT '消费金额',
  `pre_money` int DEFAULT NULL COMMENT '优惠金额',
  `start_time` date DEFAULT NULL COMMENT '活动开始日期',
  `end_time` date DEFAULT NULL COMMENT '活动截至日期',
  `type` char(1) DEFAULT NULL COMMENT '类型',
  `state` char(1) DEFAULT NULL COMMENT '状态',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  `updatedate` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_pref
-- ----------------------------

-- ----------------------------
-- Table structure for tb_sku
-- ----------------------------
DROP TABLE IF EXISTS `tb_sku`;
CREATE TABLE `tb_sku` (
  `id` varchar(20) NOT NULL COMMENT '商品id',
  `sn` varchar(100) NOT NULL COMMENT '商品条码',
  `name` varchar(200) NOT NULL COMMENT 'SKU名称',
  `price` int NOT NULL DEFAULT '0' COMMENT '价格（分）',
  `num` int NOT NULL DEFAULT '0' COMMENT '库存数量',
  `alert_num` int DEFAULT '0' COMMENT '库存预警数量',
  `image` varchar(300) DEFAULT NULL COMMENT '商品图片',
  `images` varchar(2000) DEFAULT NULL COMMENT '商品图片列表',
  `weight` int DEFAULT NULL COMMENT '重量（克）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `spu_id` varchar(20) DEFAULT NULL COMMENT 'SPUID',
  `category_id` int DEFAULT NULL COMMENT '类目ID',
  `category_name` varchar(200) DEFAULT NULL COMMENT '类目名称',
  `brand_name` varchar(100) DEFAULT NULL COMMENT '品牌名称',
  `spec` varchar(200) DEFAULT NULL COMMENT '规格',
  `sale_num` int DEFAULT '0' COMMENT '销量',
  `comment_num` int DEFAULT '0' COMMENT '评论数',
  `status` char(1) DEFAULT '1' COMMENT '商品状态 1-正常，2-下架，3-删除',
  `version` int DEFAULT '1',
  `old_price` int DEFAULT '0' COMMENT '价格（分）',
  `is_hot` bit(1) DEFAULT b'0' COMMENT '是否火爆 0 否 1是',
  `is_recommend` bit(1) DEFAULT b'0' COMMENT '是否推荐0 否 1是',
  `is_new` bit(1) DEFAULT b'0' COMMENT '是否是新的 0 否 1是',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `cid` (`category_id`) USING BTREE,
  KEY `status` (`status`) USING BTREE,
  KEY `updated` (`update_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品表';

-- ----------------------------
-- Records of tb_sku
-- ----------------------------
INSERT INTO `tb_sku` VALUES ('1285508464654815232', 'SN0010', '森马美女群 橘红色 M', '39', '100', '80', 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t22861/8/2449951226/155000/42b9bdd5/5b7fd79cN2223f4a5.jpg!q70.jpg.webp', 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t22861/8/2449951226/155000/42b9bdd5/5b7fd79cN2223f4a5.jpg!q70.jpg.webp', '10', '2020-07-21 17:34:36', '2020-07-22 09:41:58', '1285508462402473984', '15', '连衣裙', '森马', '{\"颜色\":\"橘红色\",\"尺码\":\"M\"}', '0', '0', '1', '1', '100', '', '', '');

-- ----------------------------
-- Table structure for tb_spec
-- ----------------------------
DROP TABLE IF EXISTS `tb_spec`;
CREATE TABLE `tb_spec` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `options` varchar(2000) DEFAULT NULL COMMENT '规格选项',
  `seq` int DEFAULT '0' COMMENT '排序',
  `template_id` int DEFAULT NULL COMMENT '模板ID',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  `updatedate` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_spec
-- ----------------------------
INSERT INTO `tb_spec` VALUES ('1', '颜色', '橘红色,蓝色，粉红色', '1', '1', '2020-07-21 17:30:54', '2020-07-21 17:30:54');
INSERT INTO `tb_spec` VALUES ('2', '尺码', 'S,M,L,XL,XXL', '2', '1', '2020-07-21 17:31:16', '2020-07-21 17:31:16');

-- ----------------------------
-- Table structure for tb_spu
-- ----------------------------
DROP TABLE IF EXISTS `tb_spu`;
CREATE TABLE `tb_spu` (
  `id` varchar(20) NOT NULL COMMENT '主键',
  `sn` varchar(60) DEFAULT NULL COMMENT '货号',
  `name` varchar(100) DEFAULT NULL COMMENT 'SPU名',
  `caption` varchar(100) DEFAULT NULL COMMENT '副标题',
  `brand_id` int DEFAULT NULL COMMENT '品牌ID',
  `category1_id` int DEFAULT NULL COMMENT '一级分类',
  `category2_id` int DEFAULT NULL COMMENT '二级分类',
  `category3_id` int DEFAULT NULL COMMENT '三级分类',
  `template_id` int DEFAULT NULL COMMENT '模板ID',
  `freight_id` int DEFAULT NULL COMMENT '运费模板id',
  `image` varchar(300) DEFAULT NULL COMMENT '图片',
  `images` varchar(1000) DEFAULT NULL COMMENT '图片列表',
  `sale_service` varchar(50) DEFAULT NULL COMMENT '售后服务',
  `introduction` text COMMENT '介绍',
  `spec_items` varchar(3000) DEFAULT NULL COMMENT '规格列表',
  `para_items` varchar(3000) DEFAULT NULL COMMENT '参数列表',
  `sale_num` int DEFAULT '0' COMMENT '销量',
  `comment_num` int DEFAULT '0' COMMENT '评论数',
  `is_marketable` char(1) DEFAULT '1' COMMENT '是否上架 0 下架  1上架',
  `is_enable_spec` char(1) DEFAULT '1' COMMENT '是否启用规格',
  `is_delete` bit(1) DEFAULT b'0' COMMENT '是否删除0否 1是',
  `audit_status` tinyint(1) DEFAULT '0' COMMENT '审核状态0 未审核  1审核中 2审核通过 3审核失败',
  `audit_user` int DEFAULT NULL COMMENT '审核人',
  `auditdate` datetime DEFAULT NULL COMMENT '审核时间',
  `audit_info` varchar(255) DEFAULT NULL COMMENT '审核详情',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  `updatedate` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_spu
-- ----------------------------
INSERT INTO `tb_spu` VALUES ('1285493062138728448', '1', '森马裙', '森马裙', '1', '1', '4', '15', '1', null, null, null, '快速退款,无忧退货', '111', '[]', '{}', '0', '0', '1', '1', '\0', '0', null, null, null, '2020-07-21 16:33:24', '2020-07-21 16:33:24');
INSERT INTO `tb_spu` VALUES ('1285508462402473984', 'SN001', '森马美女群', '森马美女群', '1', '1', '4', '15', '1', null, 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t22861/8/2449951226/155000/42b9bdd5/5b7fd79cN2223f4a5.jpg!q70.jpg.webp', 'https://m.360buyimg.com/mobilecms/s720x720_jfs/t22861/8/2449951226/155000/42b9bdd5/5b7fd79cN2223f4a5.jpg!q70.jpg.webp', '无忧退货,快速退款', '森马美女群森马美女群森马美女群', '[]', '{\"裙长\":\"短裙\",\"袖长\":\"短袖\",\"腰型\":\"松紧腰\"}', '0', '0', '1', '1', '\0', '0', null, null, null, '2020-07-21 17:34:36', '2020-07-21 17:34:36');

-- ----------------------------
-- Table structure for tb_stock_back
-- ----------------------------
DROP TABLE IF EXISTS `tb_stock_back`;
CREATE TABLE `tb_stock_back` (
  `order_id` varchar(20) NOT NULL COMMENT '订单id',
  `sku_id` varchar(20) NOT NULL COMMENT 'SKU的id',
  `num` int DEFAULT NULL COMMENT '回滚数量',
  `status` char(1) DEFAULT NULL COMMENT '回滚状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `back_time` datetime DEFAULT NULL COMMENT '回滚时间',
  PRIMARY KEY (`order_id`,`sku_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_stock_back
-- ----------------------------

-- ----------------------------
-- Table structure for tb_store
-- ----------------------------
DROP TABLE IF EXISTS `tb_store`;
CREATE TABLE `tb_store` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '店铺名',
  `phone` varchar(15) DEFAULT NULL COMMENT '门店联系电话',
  `logo` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `introduction` varchar(255) DEFAULT NULL COMMENT '门店介绍',
  `delivery_time` varchar(20) DEFAULT NULL COMMENT '配送时间',
  `delivery_info` varchar(255) DEFAULT NULL COMMENT '配送信息',
  `user_id` int NOT NULL COMMENT '创建人',
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  `status` tinyint DEFAULT NULL COMMENT '0 正常  1禁用 2删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_store
-- ----------------------------

-- ----------------------------
-- Table structure for tb_template
-- ----------------------------
DROP TABLE IF EXISTS `tb_template`;
CREATE TABLE `tb_template` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) DEFAULT NULL COMMENT '模板名称',
  `spec_num` int DEFAULT '0' COMMENT '规格数量',
  `para_num` int DEFAULT '0' COMMENT '参数数量',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  `updatedate` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_template
-- ----------------------------
INSERT INTO `tb_template` VALUES ('1', '服装', '0', '0', '2020-07-18 17:58:10', '2020-07-18 17:58:10');
INSERT INTO `tb_template` VALUES ('2', '水果', '0', '0', '2020-07-18 17:58:34', '2020-07-18 17:58:34');
INSERT INTO `tb_template` VALUES ('3', '酒水', '0', '0', '2020-07-18 17:58:46', '2020-07-18 17:58:46');
INSERT INTO `tb_template` VALUES ('4', '手机', '0', '0', '2020-07-18 17:59:08', '2020-07-18 17:59:08');
INSERT INTO `tb_template` VALUES ('5', '电器', '0', '0', '2020-07-18 18:01:17', '2020-07-18 18:01:17');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `nickname` varchar(100) DEFAULT NULL COMMENT '别名',
  `password` varchar(120) NOT NULL COMMENT '密码',
  `source_type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0后台创建 1:微信小程序，2:PC，3：H5，4：Android，5：IOS',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `headPic` varchar(200) DEFAULT NULL COMMENT '头像',
  `sex` tinyint(1) DEFAULT '0' COMMENT '性别 0 默认0未知  1 男 2 女',
  `phone` varchar(30) DEFAULT NULL COMMENT '手机号码',
  `birthday` varchar(20) DEFAULT NULL COMMENT '生日',
  `status` varchar(255) DEFAULT '0' COMMENT '0 正常  1 禁用  2删除',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  `updatedate` datetime DEFAULT NULL COMMENT '更新时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', 'admin', '$2a$10$.juo9B/RZy4nN4MNkOk6JuB4RycL7gaUKrT5/Thi6fwSCq7Wl2qcC', '0', 'admin@qq.com', null, '0', '18938643582', null, '0', '2020-06-13 15:18:53', '2020-06-20 15:37:42', '2020-07-21 16:30:35', '123');
INSERT INTO `tb_user` VALUES ('2', 'aaa', 'AAA', '$2a$10$cpXQJJEE5RPHscoytCW6hO8cExdLxeAZpxXsy9uB4orHM4D5yxcxq', '0', '626128140@qq.com', '/ddfds', '1', '12003939252', '2020-01-01', '0', '2020-06-14 15:28:42', '2020-06-20 17:23:33', '2020-06-14 15:39:01', '123');
INSERT INTO `tb_user` VALUES ('3', '哈哈哈哈', null, '$2a$10$Hnhbbx5s.y0zCYiKlFZIGehO9m6H2YR7YG4B6VRJhjNQJNDm66kr6', '0', '6261@qq.com', null, '0', '18380949396', null, '2', '2020-06-20 14:51:08', '2020-06-20 17:23:27', null, null);
INSERT INTO `tb_user` VALUES ('4', 'ccccc', '123', '$2a$10$Cb6coGBD0HYLgOmygVjLcetWeigyziARE6mXU5MOETO0.mSP/5OCG', '0', '6261222@qq.com', null, '0', '16838292382', null, '2', '2020-06-20 14:51:21', '2020-06-20 16:20:20', null, null);
INSERT INTO `tb_user` VALUES ('5', '66666', 'qqqq', '$2a$10$HksaNFZiLNgfTKeJR7tpzenxAvYFaKCDeoW/CR8EAw7O.t1p4jgu2', '0', '222@qq.com', null, '0', '18738492832', null, '0', '2020-06-20 15:06:19', '2020-06-20 17:23:11', null, '123');
