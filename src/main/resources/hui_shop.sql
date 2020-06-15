/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : hui_shop

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2020-06-15 23:19:46
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', 'admin', '$2a$10$wDdLsGbYgfNAEn5Vk4HkB.r28OnCT1wgYRrN6Cciot7j3nq4CN8yy', '0', 'admin@qq.com', null, '0', '18938643582', null, '0', '2020-06-13 15:18:53', null, '2020-06-15 22:24:00');
INSERT INTO `tb_user` VALUES ('2', 'aaa', 'AAA', '$2a$10$qrGnuFqS1qOkcOLZGbYiUOrufxDnunUBTQWPWQduoT3c9jLAC4Tb6', '0', '626128140@qq.com', '/ddfds', '1', '1200393925', '2020-01-01', '0', '2020-06-14 15:28:42', '2020-06-14 15:32:57', '2020-06-14 15:39:01');
