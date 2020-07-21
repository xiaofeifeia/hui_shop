/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : hui_shop

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2020-07-21 17:03:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_album
-- ----------------------------
DROP TABLE IF EXISTS `tb_album`;
CREATE TABLE `tb_album` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `sort` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_banner
-- ----------------------------

-- ----------------------------
-- Table structure for tb_brand
-- ----------------------------
DROP TABLE IF EXISTS `tb_brand`;
CREATE TABLE `tb_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '品牌id',
  `name` varchar(100) NOT NULL COMMENT '品牌名称',
  `image` varchar(1000) DEFAULT '' COMMENT '品牌图片地址',
  `letter` char(1) DEFAULT '' COMMENT '品牌的首字母',
  `seq` int(11) DEFAULT NULL COMMENT '排序',
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
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `name` varchar(50) DEFAULT NULL COMMENT '分类名称',
  `caption` varchar(50) DEFAULT NULL COMMENT '副标题',
  `image` varchar(200) DEFAULT NULL COMMENT '图片',
  `goods_num` int(11) DEFAULT '0' COMMENT '商品数量',
  `is_show` bit(1) DEFAULT NULL COMMENT '是否显示',
  `is_menu` bit(1) DEFAULT NULL COMMENT '是否导航',
  `seq` int(11) DEFAULT NULL COMMENT '排序',
  `parent_id` int(20) DEFAULT '0' COMMENT '上级ID',
  `template_id` int(11) DEFAULT NULL COMMENT '模板ID',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  `updatedate` datetime DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(1) DEFAULT '0' COMMENT '0 可用  1不可用 2删除',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `parent_id` (`parent_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品类目';

-- ----------------------------
-- Records of tb_category
-- ----------------------------
INSERT INTO `tb_category` VALUES ('1', '时尚女装', '女装', null, '0', '', '', '1', '0', '1', '2020-07-18 17:57:14', '2020-07-18 18:02:12', '0');
INSERT INTO `tb_category` VALUES ('2', '潮流男装', '男装', null, '0', '', '', '2', '0', '1', '2020-07-18 18:02:35', '2020-07-18 18:02:35', '0');
INSERT INTO `tb_category` VALUES ('3', '女士上衣', '女士上衣', null, '0', '', '', '1', '1', '1', '2020-07-18 18:03:09', '2020-07-18 18:03:09', '0');
INSERT INTO `tb_category` VALUES ('4', '时尚裙子', '裙子', '/images/b951762990004021a587640c7cff307c/连衣裙.png', '0', '', '', '2', '1', '1', '2020-07-18 18:03:46', '2020-07-19 15:41:37', '0');
INSERT INTO `tb_category` VALUES ('5', '女士裤装', '女士裤装', null, '0', '', '', '3', '1', '1', '2020-07-18 18:04:31', '2020-07-18 18:04:31', '0');
INSERT INTO `tb_category` VALUES ('6', '内衣内裤', '内衣内裤', null, '0', '', '', '4', '1', '1', '2020-07-18 18:05:46', '2020-07-18 18:05:46', '0');
INSERT INTO `tb_category` VALUES ('7', '男士上衣', '男士上衣', null, '0', '', '', '1', '2', '1', '2020-07-18 18:06:38', '2020-07-18 18:06:38', '0');
INSERT INTO `tb_category` VALUES ('8', '男士裤装', '男士裤装', null, '0', '', '', '1', '2', '1', '2020-07-18 18:07:01', '2020-07-18 18:07:01', '0');
INSERT INTO `tb_category` VALUES ('9', '内衣内裤', '内衣内裤', null, '0', '', '', '3', '2', '1', '2020-07-18 18:07:16', '2020-07-18 18:07:16', '0');
INSERT INTO `tb_category` VALUES ('10', 'T恤', 'T恤', '/images/a95cc2c354e44276be655a503c9b2268/T恤.png', '0', '', '', '1', '3', '1', '2020-07-18 18:12:36', '2020-07-19 15:56:47', '0');
INSERT INTO `tb_category` VALUES ('11', '衬衫', '衬衫', '/images/a95cc2c354e44276be655a503c9b2268/衬衫.png', '0', '', '', '2', '3', '1', '2020-07-18 18:13:04', '2020-07-19 15:58:25', '0');
INSERT INTO `tb_category` VALUES ('12', '卫衣', '卫衣', '/images/a95cc2c354e44276be655a503c9b2268/卫衣.png', '0', '', '', '3', '3', '1', '2020-07-18 18:13:28', '2020-07-19 15:59:15', '0');
INSERT INTO `tb_category` VALUES ('13', '针织衫', '针织衫', '/images/a95cc2c354e44276be655a503c9b2268/针织衫.png', '0', '', '', '3', '3', '1', '2020-07-18 18:13:53', '2020-07-19 16:00:00', '0');
INSERT INTO `tb_category` VALUES ('14', '打底衫', '打底衫', null, '0', '', '', '5', '3', '1', '2020-07-18 18:14:39', '2020-07-18 18:14:39', '0');
INSERT INTO `tb_category` VALUES ('15', '连衣裙', '连衣裙', '/images/ed86f23dba924958bea2f248d278c5ee/连衣裙.png', '0', '', '', '1', '4', '1', '2020-07-18 18:15:15', '2020-07-19 15:45:43', '0');
INSERT INTO `tb_category` VALUES ('16', '半身裙', '半身裙', '/images/ed86f23dba924958bea2f248d278c5ee/半身裙.png', '0', '', '', '2', '4', '1', '2020-07-18 18:15:32', '2020-07-19 15:48:34', '0');
INSERT INTO `tb_category` VALUES ('17', '牛仔裤', '牛仔裤', null, '0', '', '', '1', '5', '1', '2020-07-18 18:16:38', '2020-07-18 18:16:38', '0');
INSERT INTO `tb_category` VALUES ('18', '休闲裤', '休闲裤', null, '0', '', '', '1', '5', '1', '2020-07-18 18:16:51', '2020-07-18 18:16:51', '0');
INSERT INTO `tb_category` VALUES ('19', '小脚裤', '小脚裤', null, '0', '', '', '3', '5', '1', '2020-07-18 18:17:09', '2020-07-18 18:17:09', '0');
INSERT INTO `tb_category` VALUES ('20', '阔腿裤', '阔腿裤', null, '0', '', '', '1', '5', '1', '2020-07-18 18:17:57', '2020-07-18 18:17:57', '0');
INSERT INTO `tb_category` VALUES ('21', '正装裤', '正装裤', null, '0', '', '', '1', '5', '1', '2020-07-18 18:18:25', '2020-07-18 18:18:25', '0');
INSERT INTO `tb_category` VALUES ('22', '文胸', '文胸', null, '0', '', '', '1', '6', '1', '2020-07-18 18:18:44', '2020-07-18 18:18:44', '0');
INSERT INTO `tb_category` VALUES ('23', '内裤', '内裤', null, '0', '', '', '1', '6', '1', '2020-07-18 18:18:53', '2020-07-18 18:18:53', '0');
INSERT INTO `tb_category` VALUES ('24', '睡衣/居家衣', '睡衣/居家衣', null, '0', '', '', '1', '6', '1', '2020-07-18 18:19:13', '2020-07-18 18:19:13', '0');
INSERT INTO `tb_category` VALUES ('25', '吊带背心', '吊带背心', null, '0', '', '', '1', '6', '1', '2020-07-18 18:19:33', '2020-07-18 18:19:33', '0');
INSERT INTO `tb_category` VALUES ('26', '塑身美体', '塑身美体', null, '0', '', '', null, '6', '1', '2020-07-18 18:19:53', '2020-07-18 18:19:53', '0');
INSERT INTO `tb_category` VALUES ('27', 'T恤', 'T恤', null, '0', '', '', '1', '7', '1', '2020-07-18 18:20:30', '2020-07-18 18:20:30', '0');
INSERT INTO `tb_category` VALUES ('28', 'POLO衫', 'POLO衫', null, '0', '', '', '2', '7', '1', '2020-07-18 18:20:40', '2020-07-18 18:20:40', '0');
INSERT INTO `tb_category` VALUES ('29', '衬衫', '衬衫', null, '0', '', '', '3', '7', '1', '2020-07-18 18:20:51', '2020-07-18 18:20:51', '0');
INSERT INTO `tb_category` VALUES ('30', '卫衣', '卫衣', null, '0', '', '', null, '7', '1', '2020-07-18 18:21:09', '2020-07-18 18:21:09', '0');
INSERT INTO `tb_category` VALUES ('31', '卫衣', '卫衣', null, '0', '', '', null, '7', '1', '2020-07-18 18:21:34', '2020-07-18 18:21:34', '0');
INSERT INTO `tb_category` VALUES ('32', '长袖', '长袖', null, '0', '', '', null, '7', '1', '2020-07-18 18:21:44', '2020-07-18 18:21:44', '0');
INSERT INTO `tb_category` VALUES ('33', '针织衫', '针织衫', null, '0', '', '', null, '7', '1', '2020-07-18 18:21:54', '2020-07-18 18:21:54', '0');
INSERT INTO `tb_category` VALUES ('34', '夹克', '夹克', null, '0', '', '', null, '7', '1', '2020-07-18 18:22:13', '2020-07-18 18:22:13', '0');
INSERT INTO `tb_category` VALUES ('35', '外套', '外套', null, '0', '', '', '1', '7', '1', '2020-07-18 18:22:23', '2020-07-18 18:22:23', '0');
INSERT INTO `tb_category` VALUES ('36', '风衣', '风衣', null, '0', '', '', null, '7', '1', '2020-07-18 18:22:33', '2020-07-18 18:22:33', '0');
INSERT INTO `tb_category` VALUES ('37', '休闲裤', '休闲裤', null, '0', '', '', null, '8', '1', '2020-07-18 18:22:44', '2020-07-18 18:22:44', '0');
INSERT INTO `tb_category` VALUES ('38', '牛仔裤', '牛仔裤', null, '0', '', '', '1', '8', '1', '2020-07-18 18:22:52', '2020-07-18 18:22:52', '0');
INSERT INTO `tb_category` VALUES ('39', '运动裤', '运动裤', null, '0', '', '', null, '8', '1', '2020-07-18 18:23:07', '2020-07-18 18:23:07', '0');
INSERT INTO `tb_category` VALUES ('40', '短裤', '短裤', null, '0', '', '', null, '8', '1', '2020-07-18 18:23:15', '2020-07-18 18:23:15', '0');
INSERT INTO `tb_category` VALUES ('41', '九分裤', '九分裤', null, '0', '', '', null, '8', '1', '2020-07-18 18:23:24', '2020-07-18 18:23:24', '0');
INSERT INTO `tb_category` VALUES ('42', '西裤', '西裤', null, '0', '', '', null, '8', '1', '2020-07-18 18:23:36', '2020-07-18 18:23:36', '0');
INSERT INTO `tb_category` VALUES ('43', '三角内裤', '三角内裤', null, '0', '', '', null, '9', '1', '2020-07-18 18:24:37', '2020-07-19 13:02:05', '0');

-- ----------------------------
-- Table structure for tb_category_brand
-- ----------------------------
DROP TABLE IF EXISTS `tb_category_brand`;
CREATE TABLE `tb_category_brand` (
  `category_id` int(11) NOT NULL COMMENT '分类ID',
  `brand_id` int(11) NOT NULL COMMENT '品牌ID',
  PRIMARY KEY (`category_id`,`brand_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_category_brand
-- ----------------------------

-- ----------------------------
-- Table structure for tb_para
-- ----------------------------
DROP TABLE IF EXISTS `tb_para`;
CREATE TABLE `tb_para` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `options` varchar(2000) DEFAULT NULL COMMENT '选项',
  `seq` int(11) DEFAULT NULL COMMENT '排序',
  `template_id` int(11) DEFAULT NULL COMMENT '模板ID',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  `updatedate` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_para
-- ----------------------------

-- ----------------------------
-- Table structure for tb_pref
-- ----------------------------
DROP TABLE IF EXISTS `tb_pref`;
CREATE TABLE `tb_pref` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `cate_id` int(11) DEFAULT NULL COMMENT '分类ID',
  `buy_money` int(11) DEFAULT NULL COMMENT '消费金额',
  `pre_money` int(11) DEFAULT NULL COMMENT '优惠金额',
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
  `price` int(20) NOT NULL COMMENT '价格（分）',
  `num` int(10) NOT NULL COMMENT '库存数量',
  `alert_num` int(11) DEFAULT NULL COMMENT '库存预警数量',
  `image` varchar(300) DEFAULT NULL COMMENT '商品图片',
  `images` varchar(2000) DEFAULT NULL COMMENT '商品图片列表',
  `weight` int(11) DEFAULT NULL COMMENT '重量（克）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `spu_id` varchar(20) DEFAULT NULL COMMENT 'SPUID',
  `category_id` int(10) DEFAULT NULL COMMENT '类目ID',
  `category_name` varchar(200) DEFAULT NULL COMMENT '类目名称',
  `brand_name` varchar(100) DEFAULT NULL COMMENT '品牌名称',
  `spec` varchar(200) DEFAULT NULL COMMENT '规格',
  `sale_num` int(11) DEFAULT '0' COMMENT '销量',
  `comment_num` int(11) DEFAULT '0' COMMENT '评论数',
  `status` char(1) DEFAULT '1' COMMENT '商品状态 1-正常，2-下架，3-删除',
  `version` int(255) DEFAULT '1',
  `old_price` int(20) DEFAULT NULL COMMENT '价格（分）',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `cid` (`category_id`) USING BTREE,
  KEY `status` (`status`) USING BTREE,
  KEY `updated` (`update_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品表';

-- ----------------------------
-- Records of tb_sku
-- ----------------------------

-- ----------------------------
-- Table structure for tb_spec
-- ----------------------------
DROP TABLE IF EXISTS `tb_spec`;
CREATE TABLE `tb_spec` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `options` varchar(2000) DEFAULT NULL COMMENT '规格选项',
  `seq` int(11) DEFAULT '0' COMMENT '排序',
  `template_id` int(11) DEFAULT NULL COMMENT '模板ID',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  `updatedate` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_spec
-- ----------------------------

-- ----------------------------
-- Table structure for tb_spu
-- ----------------------------
DROP TABLE IF EXISTS `tb_spu`;
CREATE TABLE `tb_spu` (
  `id` varchar(20) NOT NULL COMMENT '主键',
  `sn` varchar(60) DEFAULT NULL COMMENT '货号',
  `name` varchar(100) DEFAULT NULL COMMENT 'SPU名',
  `caption` varchar(100) DEFAULT NULL COMMENT '副标题',
  `brand_id` int(11) DEFAULT NULL COMMENT '品牌ID',
  `category1_id` int(20) DEFAULT NULL COMMENT '一级分类',
  `category2_id` int(10) DEFAULT NULL COMMENT '二级分类',
  `category3_id` int(10) DEFAULT NULL COMMENT '三级分类',
  `template_id` int(20) DEFAULT NULL COMMENT '模板ID',
  `freight_id` int(11) DEFAULT NULL COMMENT '运费模板id',
  `image` varchar(300) DEFAULT NULL COMMENT '图片',
  `images` varchar(1000) DEFAULT NULL COMMENT '图片列表',
  `sale_service` varchar(50) DEFAULT NULL COMMENT '售后服务',
  `introduction` text COMMENT '介绍',
  `spec_items` varchar(3000) DEFAULT NULL COMMENT '规格列表',
  `para_items` varchar(3000) DEFAULT NULL COMMENT '参数列表',
  `sale_num` int(11) DEFAULT '0' COMMENT '销量',
  `comment_num` int(11) DEFAULT '0' COMMENT '评论数',
  `is_marketable` char(1) DEFAULT '1' COMMENT '是否上架 0 下架  1上架',
  `is_enable_spec` char(1) DEFAULT '1' COMMENT '是否启用规格',
  `is_delete` bit(1) DEFAULT b'0' COMMENT '是否删除0否 1是',
  `audit_status` tinyint(1) DEFAULT '0' COMMENT '审核状态0 未审核  1审核中 2审核通过 3审核失败',
  `audit_user` int(11) DEFAULT NULL COMMENT '审核人',
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

-- ----------------------------
-- Table structure for tb_stock_back
-- ----------------------------
DROP TABLE IF EXISTS `tb_stock_back`;
CREATE TABLE `tb_stock_back` (
  `order_id` varchar(20) NOT NULL COMMENT '订单id',
  `sku_id` varchar(20) NOT NULL COMMENT 'SKU的id',
  `num` int(11) DEFAULT NULL COMMENT '回滚数量',
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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '店铺名',
  `phone` varchar(15) DEFAULT NULL COMMENT '门店联系电话',
  `logo` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `introduction` varchar(255) DEFAULT NULL COMMENT '门店介绍',
  `delivery_time` varchar(20) DEFAULT NULL COMMENT '配送时间',
  `delivery_info` varchar(255) DEFAULT NULL COMMENT '配送信息',
  `user_id` int(11) NOT NULL COMMENT '创建人',
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL COMMENT '0 正常  1禁用 2删除',
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
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) DEFAULT NULL COMMENT '模板名称',
  `spec_num` int(11) DEFAULT '0' COMMENT '规格数量',
  `para_num` int(11) DEFAULT '0' COMMENT '参数数量',
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
  `user_id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '用户id',
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
