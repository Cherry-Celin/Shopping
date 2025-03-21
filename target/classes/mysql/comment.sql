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

 Date: 25/07/2024 14:30:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '评价ID',
  `buyer_id` int(50) NULL DEFAULT NULL COMMENT '评价者ID',
  `seller_id` int(50) NULL DEFAULT NULL COMMENT '被评价者ID',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '评价内容',
  `comment_date` datetime(6) NULL DEFAULT NULL COMMENT '评价时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (11, 1, 3, '很好用，拍照特别好看', '2024-07-25 01:21:03.000000');
INSERT INTO `comment` VALUES (12, 1, 3, '拍照很好看', '2024-07-25 01:22:22.000000');
INSERT INTO `comment` VALUES (13, 1, 3, '这是一个好相机', '2024-07-25 09:09:36.000000');
INSERT INTO `comment` VALUES (14, 3, 2, '衣服很好看~', '2024-07-25 09:37:49.000000');
INSERT INTO `comment` VALUES (15, 3, 2, '东西很新 质量很好', '2024-07-25 09:38:38.000000');
INSERT INTO `comment` VALUES (16, 3, 1, '宝宝很好看 卖家人很好', '2024-07-25 09:39:32.000000');
INSERT INTO `comment` VALUES (17, 3, 2, '很可爱的包包 很喜欢', '2024-07-25 09:39:54.000000');
INSERT INTO `comment` VALUES (18, 3, 2, '拍立得有点贵 但是很好看', '2024-07-25 09:40:12.000000');
INSERT INTO `comment` VALUES (19, 3, 1, '相机的质量还不错 卖家人很好', '2024-07-25 09:42:15.000000');
INSERT INTO `comment` VALUES (20, 3, 1, '东西有点旧 但是并不影响使用', '2024-07-25 09:43:09.000000');
INSERT INTO `comment` VALUES (21, 1, 2, '风扇的声音有点大', '2024-07-25 09:44:33.000000');
INSERT INTO `comment` VALUES (22, 1, 3, '我家猫猫不喜欢玩猫抓板', '2024-07-25 09:44:47.000000');
INSERT INTO `comment` VALUES (23, 2, 3, '东西很好', '2024-07-25 09:46:08.000000');
INSERT INTO `comment` VALUES (24, 2, 3, '我家狗狗很喜欢', '2024-07-25 09:46:16.000000');
INSERT INTO `comment` VALUES (25, 2, 1, '价格有点贵', '2024-07-25 09:46:22.000000');
INSERT INTO `comment` VALUES (26, 1, 2, '这个相机很好', '2024-07-25 14:03:36.000000');
INSERT INTO `comment` VALUES (27, 1, 2, '这个相机很好', '2024-07-25 14:03:36.000000');

SET FOREIGN_KEY_CHECKS = 1;
