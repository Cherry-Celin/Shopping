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

 Date: 25/07/2024 14:30:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '收藏夹ID',
  `user_id` int(50) NULL DEFAULT NULL COMMENT '收藏人ID',
  `product_id` int(50) NULL DEFAULT NULL COMMENT '商品ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (7, 1, 3);
INSERT INTO `cart` VALUES (9, 1, 5);
INSERT INTO `cart` VALUES (13, 1, 9);
INSERT INTO `cart` VALUES (15, 1, 11);
INSERT INTO `cart` VALUES (16, 1, 12);
INSERT INTO `cart` VALUES (22, 1, 2);
INSERT INTO `cart` VALUES (23, 1, 4);
INSERT INTO `cart` VALUES (24, 1, 28);
INSERT INTO `cart` VALUES (25, 1, 1);
INSERT INTO `cart` VALUES (28, 3, 6012);
INSERT INTO `cart` VALUES (30, 2, 4001);
INSERT INTO `cart` VALUES (31, 2, 3004);
INSERT INTO `cart` VALUES (32, 2, 2006);
INSERT INTO `cart` VALUES (33, 2, 3008);
INSERT INTO `cart` VALUES (35, 2, 6014);
INSERT INTO `cart` VALUES (36, 2, 3009);
INSERT INTO `cart` VALUES (37, 2, 6003);
INSERT INTO `cart` VALUES (39, 3, 3001);
INSERT INTO `cart` VALUES (41, 3, 1010);
INSERT INTO `cart` VALUES (42, 3, 2016);
INSERT INTO `cart` VALUES (43, 3, 2010);
INSERT INTO `cart` VALUES (44, 3, 6008);
INSERT INTO `cart` VALUES (45, 3, 1014);
INSERT INTO `cart` VALUES (47, 1, 5008);
INSERT INTO `cart` VALUES (49, 1, 4011);
INSERT INTO `cart` VALUES (50, 1, 1016);
INSERT INTO `cart` VALUES (51, 2, 6016);
INSERT INTO `cart` VALUES (55, 1, 1001);

SET FOREIGN_KEY_CHECKS = 1;
