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

 Date: 25/07/2024 14:30:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `buyer_id` int(50) NULL DEFAULT NULL COMMENT '购买者ID',
  `seller_id` int(50) NULL DEFAULT NULL COMMENT '售出者ID',
  `product_id` int(50) NULL DEFAULT NULL COMMENT '商品ID',
  `comment_id` int(50) NULL DEFAULT NULL COMMENT '对卖家的评价',
  `create_time` timestamp(6) NULL DEFAULT NULL COMMENT '订单创建时间',
  `update_time` timestamp(6) NULL DEFAULT NULL COMMENT '订单更新时间',
  `is_deleted` bit(1) NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (12, 3, 2, 1007, 14, '2024-07-25 09:37:21.000000', '2024-07-25 09:37:49.000000', b'0');
INSERT INTO `order` VALUES (13, 3, 2, 4010, 15, '2024-07-25 09:38:15.000000', '2024-07-25 09:38:38.000000', b'0');
INSERT INTO `order` VALUES (15, 3, 2, 2007, 17, '2024-07-25 09:39:01.000000', '2024-07-25 09:39:54.000000', b'0');
INSERT INTO `order` VALUES (16, 3, 2, 3006, 18, '2024-07-25 09:39:09.000000', '2024-07-25 09:40:12.000000', b'0');
INSERT INTO `order` VALUES (18, 3, 1, 3012, 20, '2024-07-25 09:41:23.000000', '2024-07-25 09:43:09.000000', b'0');
INSERT INTO `order` VALUES (19, 1, 2, 4004, 21, '2024-07-25 09:43:49.000000', '2024-07-25 09:44:33.000000', b'0');
INSERT INTO `order` VALUES (20, 1, 3, 6011, 22, '2024-07-25 09:44:08.000000', '2024-07-25 09:44:47.000000', b'0');
INSERT INTO `order` VALUES (21, 2, 3, 6005, 23, '2024-07-25 09:45:24.000000', '2024-07-25 09:46:08.000000', b'0');
INSERT INTO `order` VALUES (22, 2, 3, 6008, 24, '2024-07-25 09:45:32.000000', '2024-07-25 09:46:16.000000', b'0');
INSERT INTO `order` VALUES (23, 2, 1, 3002, 25, '2024-07-25 09:45:46.000000', '2024-07-25 09:46:22.000000', b'0');
INSERT INTO `order` VALUES (25, 1, 2, 3006, 27, '2024-07-25 14:03:12.000000', '2024-07-25 14:03:36.000000', b'0');

SET FOREIGN_KEY_CHECKS = 1;
