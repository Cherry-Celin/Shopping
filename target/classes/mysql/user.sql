/*
 Navicat MySQL Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : shopping

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 25/07/2024 14:31:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键用户ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '登录用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '登录密码',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '头像',
  `property` double(255, 2) NULL DEFAULT NULL COMMENT '爱心资产',
  `create_time` datetime(6) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(6) NULL DEFAULT NULL COMMENT '更新时间',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户邮箱',
  `sexy` enum('MALE','FEMALE','NONE') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '地区',
  `phone_number` decimal(11, 0) NULL DEFAULT NULL COMMENT '手机号码',
  `detail_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '详细地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'cl', 'e10adc3949ba59abbe56e057f20f883e', 'C巷', 'http://localhost:8084/img/cl_20240725140538.png', 3618.00, '2024-07-17 16:09:18.000000', '2024-07-25 14:05:39.000000', 'cl@qq.com', 'FEMALE', '2004-09-05', '北京市,市辖区,东城区', 7777777, 'scusss');
INSERT INTO `user` VALUES (2, 'zkx', 'e10adc3949ba59abbe56e057f20f883e', '小翟', 'http://localhost:8084/img/zkx_20240725092608.jpg', 9599.00, '2024-07-18 13:59:10.000000', '2024-07-25 09:45:46.000000', 'zkx@qq.com', 'FEMALE', '2024-07-01', '四川省,成都市,双流区', 8888888, 'scu南门');
INSERT INTO `user` VALUES (3, 'myx', 'e10adc3949ba59abbe56e057f20f883e', '小马', 'http://localhost:8084/img/tou_20240725093428.jpg', 8332.00, '2024-07-19 08:48:07.000000', '2024-07-25 09:41:23.000000', 'myx@qq.com', 'NONE', '2024-07-06', '甘肃省,白银市,平川区', 9999999, 'scu东门');

SET FOREIGN_KEY_CHECKS = 1;
