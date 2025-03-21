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

 Date: 25/07/2024 14:31:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_donations
-- ----------------------------
DROP TABLE IF EXISTS `user_donations`;
CREATE TABLE `user_donations`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '捐赠记录id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '捐赠者id',
  `project_id` int(11) NULL DEFAULT NULL COMMENT '项目id',
  `amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '捐赠的爱心数目',
  `feedback` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '反馈内容',
  `feedback_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '反馈图片',
  `create_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `project_id`(`project_id`) USING BTREE,
  CONSTRAINT `user_donations_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_donations_ibfk_2` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_donations
-- ----------------------------
INSERT INTO `user_donations` VALUES (1, 1, 1, 100.00, '等待公益项目负责人进行反馈', NULL, '2024-07-24 14:12:28.000000');
INSERT INTO `user_donations` VALUES (13, 1, 12, 500.00, NULL, NULL, '2024-07-25 14:06:18.000000');

SET FOREIGN_KEY_CHECKS = 1;
