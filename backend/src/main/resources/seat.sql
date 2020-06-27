/*
 Navicat Premium Data Transfer

 Source Server         : pub-test
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : pub-test.milolab.cn:32768
 Source Schema         : seat

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 27/06/2020 21:22:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for reservation
-- ----------------------------
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `seat_id` int(11) NOT NULL,
  `start` time(0) NOT NULL,
  `end` time(0) NOT NULL,
  `enter_time` time(0) NULL DEFAULT NULL,
  `leave_time` time(0) NULL DEFAULT NULL,
  `reservation_date` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `seat_id`(`seat_id`) USING BTREE,
  CONSTRAINT `reservation_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `reservation_ibfk_4` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reservation
-- ----------------------------
INSERT INTO `reservation` VALUES (1, 8, 1, '14:45:00', '16:44:00', '14:27:05', NULL, '2020-06-28');
INSERT INTO `reservation` VALUES (2, 9, 2, '16:40:00', '21:25:00', '15:27:10', NULL, '2020-06-29');
INSERT INTO `reservation` VALUES (3, 10, 3, '13:42:00', '20:54:00', '12:27:14', '12:33:30', '2020-06-28');
INSERT INTO `reservation` VALUES (4, 11, 4, '14:28:00', '16:51:00', NULL, NULL, '2020-06-29');
INSERT INTO `reservation` VALUES (5, 12, 5, '18:28:00', '20:10:00', '17:27:19', '18:27:24', '2020-06-28');
INSERT INTO `reservation` VALUES (6, 13, 6, '11:17:00', '18:47:00', NULL, NULL, '2020-06-29');
INSERT INTO `reservation` VALUES (7, 14, 7, '18:17:00', '19:41:00', '09:27:46', NULL, '2020-06-29');
INSERT INTO `reservation` VALUES (8, 15, 8, '10:08:00', '20:33:00', NULL, NULL, '2020-06-29');
INSERT INTO `reservation` VALUES (9, 16, 9, '10:48:00', '18:09:00', NULL, NULL, '2020-06-29');
INSERT INTO `reservation` VALUES (10, 17, 10, '10:20:00', '19:58:00', NULL, NULL, '2020-06-29');
INSERT INTO `reservation` VALUES (11, 18, 11, '15:21:00', '20:00:00', NULL, NULL, '2020-06-29');
INSERT INTO `reservation` VALUES (12, 19, 12, '10:24:00', '18:21:00', NULL, NULL, '2020-06-28');
INSERT INTO `reservation` VALUES (13, 20, 13, '17:55:00', '19:28:00', NULL, NULL, '2020-06-28');
INSERT INTO `reservation` VALUES (14, 21, 14, '16:10:00', '19:25:00', NULL, NULL, '2020-06-28');
INSERT INTO `reservation` VALUES (15, 22, 15, '18:33:00', '20:32:00', NULL, NULL, '2020-06-28');

-- ----------------------------
-- Table structure for seat
-- ----------------------------
DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `table_id` int(11) NOT NULL,
  `position` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `table_id`(`table_id`) USING BTREE,
  CONSTRAINT `seat_ibfk_1` FOREIGN KEY (`table_id`) REFERENCES `table` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 265 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seat
-- ----------------------------
INSERT INTO `seat` VALUES (1, 1, 1);
INSERT INTO `seat` VALUES (2, 1, 2);
INSERT INTO `seat` VALUES (3, 1, 3);
INSERT INTO `seat` VALUES (4, 1, 4);
INSERT INTO `seat` VALUES (5, 2, 1);
INSERT INTO `seat` VALUES (6, 2, 2);
INSERT INTO `seat` VALUES (7, 2, 3);
INSERT INTO `seat` VALUES (8, 2, 4);
INSERT INTO `seat` VALUES (9, 3, 1);
INSERT INTO `seat` VALUES (10, 3, 2);
INSERT INTO `seat` VALUES (11, 3, 3);
INSERT INTO `seat` VALUES (12, 3, 4);
INSERT INTO `seat` VALUES (13, 4, 1);
INSERT INTO `seat` VALUES (14, 4, 2);
INSERT INTO `seat` VALUES (15, 4, 3);
INSERT INTO `seat` VALUES (16, 4, 4);
INSERT INTO `seat` VALUES (17, 5, 1);
INSERT INTO `seat` VALUES (18, 5, 2);
INSERT INTO `seat` VALUES (19, 5, 3);
INSERT INTO `seat` VALUES (20, 5, 4);
INSERT INTO `seat` VALUES (21, 6, 1);
INSERT INTO `seat` VALUES (22, 6, 2);
INSERT INTO `seat` VALUES (23, 6, 3);
INSERT INTO `seat` VALUES (24, 6, 4);
INSERT INTO `seat` VALUES (25, 7, 1);
INSERT INTO `seat` VALUES (26, 7, 2);
INSERT INTO `seat` VALUES (27, 7, 3);
INSERT INTO `seat` VALUES (28, 7, 4);
INSERT INTO `seat` VALUES (29, 8, 1);
INSERT INTO `seat` VALUES (30, 8, 2);
INSERT INTO `seat` VALUES (31, 8, 3);
INSERT INTO `seat` VALUES (32, 8, 4);
INSERT INTO `seat` VALUES (33, 9, 1);
INSERT INTO `seat` VALUES (34, 9, 2);
INSERT INTO `seat` VALUES (35, 9, 3);
INSERT INTO `seat` VALUES (36, 9, 4);
INSERT INTO `seat` VALUES (37, 10, 1);
INSERT INTO `seat` VALUES (38, 10, 2);
INSERT INTO `seat` VALUES (39, 10, 3);
INSERT INTO `seat` VALUES (40, 10, 4);
INSERT INTO `seat` VALUES (41, 11, 1);
INSERT INTO `seat` VALUES (42, 11, 2);
INSERT INTO `seat` VALUES (43, 11, 3);
INSERT INTO `seat` VALUES (44, 11, 4);
INSERT INTO `seat` VALUES (45, 12, 1);
INSERT INTO `seat` VALUES (46, 12, 2);
INSERT INTO `seat` VALUES (47, 12, 3);
INSERT INTO `seat` VALUES (48, 12, 4);
INSERT INTO `seat` VALUES (49, 13, 1);
INSERT INTO `seat` VALUES (50, 13, 2);
INSERT INTO `seat` VALUES (51, 13, 3);
INSERT INTO `seat` VALUES (52, 13, 4);
INSERT INTO `seat` VALUES (53, 14, 1);
INSERT INTO `seat` VALUES (54, 14, 2);
INSERT INTO `seat` VALUES (55, 14, 3);
INSERT INTO `seat` VALUES (56, 14, 4);
INSERT INTO `seat` VALUES (57, 15, 1);
INSERT INTO `seat` VALUES (58, 15, 2);
INSERT INTO `seat` VALUES (59, 15, 3);
INSERT INTO `seat` VALUES (60, 15, 4);
INSERT INTO `seat` VALUES (61, 16, 1);
INSERT INTO `seat` VALUES (62, 16, 2);
INSERT INTO `seat` VALUES (63, 16, 3);
INSERT INTO `seat` VALUES (64, 16, 4);
INSERT INTO `seat` VALUES (65, 17, 1);
INSERT INTO `seat` VALUES (66, 17, 2);
INSERT INTO `seat` VALUES (67, 17, 3);
INSERT INTO `seat` VALUES (68, 17, 4);
INSERT INTO `seat` VALUES (69, 18, 1);
INSERT INTO `seat` VALUES (70, 18, 2);
INSERT INTO `seat` VALUES (71, 18, 3);
INSERT INTO `seat` VALUES (72, 18, 4);
INSERT INTO `seat` VALUES (73, 19, 1);
INSERT INTO `seat` VALUES (74, 19, 2);
INSERT INTO `seat` VALUES (75, 19, 3);
INSERT INTO `seat` VALUES (76, 19, 4);
INSERT INTO `seat` VALUES (77, 20, 1);
INSERT INTO `seat` VALUES (78, 20, 2);
INSERT INTO `seat` VALUES (79, 20, 3);
INSERT INTO `seat` VALUES (80, 20, 4);
INSERT INTO `seat` VALUES (81, 21, 1);
INSERT INTO `seat` VALUES (82, 21, 2);
INSERT INTO `seat` VALUES (83, 21, 3);
INSERT INTO `seat` VALUES (84, 21, 4);
INSERT INTO `seat` VALUES (85, 22, 1);
INSERT INTO `seat` VALUES (86, 22, 2);
INSERT INTO `seat` VALUES (87, 22, 3);
INSERT INTO `seat` VALUES (88, 22, 4);
INSERT INTO `seat` VALUES (89, 23, 1);
INSERT INTO `seat` VALUES (90, 23, 2);
INSERT INTO `seat` VALUES (91, 23, 3);
INSERT INTO `seat` VALUES (92, 23, 4);
INSERT INTO `seat` VALUES (93, 24, 1);
INSERT INTO `seat` VALUES (94, 24, 2);
INSERT INTO `seat` VALUES (95, 24, 3);
INSERT INTO `seat` VALUES (96, 24, 4);
INSERT INTO `seat` VALUES (97, 25, 1);
INSERT INTO `seat` VALUES (98, 25, 2);
INSERT INTO `seat` VALUES (99, 25, 3);
INSERT INTO `seat` VALUES (100, 25, 4);
INSERT INTO `seat` VALUES (101, 26, 1);
INSERT INTO `seat` VALUES (102, 26, 2);
INSERT INTO `seat` VALUES (103, 26, 3);
INSERT INTO `seat` VALUES (104, 26, 4);
INSERT INTO `seat` VALUES (105, 27, 1);
INSERT INTO `seat` VALUES (106, 27, 2);
INSERT INTO `seat` VALUES (107, 27, 3);
INSERT INTO `seat` VALUES (108, 27, 4);
INSERT INTO `seat` VALUES (109, 28, 1);
INSERT INTO `seat` VALUES (110, 28, 2);
INSERT INTO `seat` VALUES (111, 28, 3);
INSERT INTO `seat` VALUES (112, 28, 4);
INSERT INTO `seat` VALUES (113, 29, 1);
INSERT INTO `seat` VALUES (114, 29, 2);
INSERT INTO `seat` VALUES (115, 29, 3);
INSERT INTO `seat` VALUES (116, 29, 4);
INSERT INTO `seat` VALUES (117, 30, 1);
INSERT INTO `seat` VALUES (118, 30, 2);
INSERT INTO `seat` VALUES (119, 30, 3);
INSERT INTO `seat` VALUES (120, 30, 4);
INSERT INTO `seat` VALUES (121, 31, 1);
INSERT INTO `seat` VALUES (122, 31, 2);
INSERT INTO `seat` VALUES (123, 31, 3);
INSERT INTO `seat` VALUES (124, 31, 4);
INSERT INTO `seat` VALUES (125, 32, 1);
INSERT INTO `seat` VALUES (126, 32, 2);
INSERT INTO `seat` VALUES (127, 32, 3);
INSERT INTO `seat` VALUES (128, 32, 4);
INSERT INTO `seat` VALUES (129, 33, 1);
INSERT INTO `seat` VALUES (130, 33, 2);
INSERT INTO `seat` VALUES (131, 33, 3);
INSERT INTO `seat` VALUES (132, 33, 4);
INSERT INTO `seat` VALUES (133, 34, 1);
INSERT INTO `seat` VALUES (134, 34, 2);
INSERT INTO `seat` VALUES (135, 34, 3);
INSERT INTO `seat` VALUES (136, 34, 4);
INSERT INTO `seat` VALUES (137, 35, 1);
INSERT INTO `seat` VALUES (138, 35, 2);
INSERT INTO `seat` VALUES (139, 35, 3);
INSERT INTO `seat` VALUES (140, 35, 4);
INSERT INTO `seat` VALUES (141, 36, 1);
INSERT INTO `seat` VALUES (142, 36, 2);
INSERT INTO `seat` VALUES (143, 36, 3);
INSERT INTO `seat` VALUES (144, 36, 4);
INSERT INTO `seat` VALUES (145, 37, 1);
INSERT INTO `seat` VALUES (146, 37, 2);
INSERT INTO `seat` VALUES (147, 37, 3);
INSERT INTO `seat` VALUES (148, 37, 4);
INSERT INTO `seat` VALUES (149, 38, 1);
INSERT INTO `seat` VALUES (150, 38, 2);
INSERT INTO `seat` VALUES (151, 38, 3);
INSERT INTO `seat` VALUES (152, 38, 4);
INSERT INTO `seat` VALUES (153, 39, 1);
INSERT INTO `seat` VALUES (154, 39, 2);
INSERT INTO `seat` VALUES (155, 39, 3);
INSERT INTO `seat` VALUES (156, 39, 4);
INSERT INTO `seat` VALUES (157, 40, 1);
INSERT INTO `seat` VALUES (158, 40, 2);
INSERT INTO `seat` VALUES (159, 40, 3);
INSERT INTO `seat` VALUES (160, 40, 4);
INSERT INTO `seat` VALUES (161, 41, 1);
INSERT INTO `seat` VALUES (162, 41, 2);
INSERT INTO `seat` VALUES (163, 41, 3);
INSERT INTO `seat` VALUES (164, 41, 4);
INSERT INTO `seat` VALUES (165, 42, 1);
INSERT INTO `seat` VALUES (166, 42, 2);
INSERT INTO `seat` VALUES (167, 42, 3);
INSERT INTO `seat` VALUES (168, 42, 4);
INSERT INTO `seat` VALUES (169, 43, 1);
INSERT INTO `seat` VALUES (170, 43, 2);
INSERT INTO `seat` VALUES (171, 43, 3);
INSERT INTO `seat` VALUES (172, 43, 4);
INSERT INTO `seat` VALUES (173, 44, 1);
INSERT INTO `seat` VALUES (174, 44, 2);
INSERT INTO `seat` VALUES (175, 44, 3);
INSERT INTO `seat` VALUES (176, 44, 4);
INSERT INTO `seat` VALUES (177, 45, 1);
INSERT INTO `seat` VALUES (178, 45, 2);
INSERT INTO `seat` VALUES (179, 45, 3);
INSERT INTO `seat` VALUES (180, 45, 4);
INSERT INTO `seat` VALUES (181, 46, 1);
INSERT INTO `seat` VALUES (182, 46, 2);
INSERT INTO `seat` VALUES (183, 46, 3);
INSERT INTO `seat` VALUES (184, 46, 4);
INSERT INTO `seat` VALUES (185, 47, 1);
INSERT INTO `seat` VALUES (186, 47, 2);
INSERT INTO `seat` VALUES (187, 47, 3);
INSERT INTO `seat` VALUES (188, 47, 4);
INSERT INTO `seat` VALUES (189, 48, 1);
INSERT INTO `seat` VALUES (190, 48, 2);
INSERT INTO `seat` VALUES (191, 48, 3);
INSERT INTO `seat` VALUES (192, 48, 4);
INSERT INTO `seat` VALUES (193, 49, 1);
INSERT INTO `seat` VALUES (194, 49, 2);
INSERT INTO `seat` VALUES (195, 49, 3);
INSERT INTO `seat` VALUES (196, 49, 4);
INSERT INTO `seat` VALUES (197, 50, 1);
INSERT INTO `seat` VALUES (198, 50, 2);
INSERT INTO `seat` VALUES (199, 50, 3);
INSERT INTO `seat` VALUES (200, 50, 4);
INSERT INTO `seat` VALUES (201, 51, 1);
INSERT INTO `seat` VALUES (202, 51, 2);
INSERT INTO `seat` VALUES (203, 51, 3);
INSERT INTO `seat` VALUES (204, 51, 4);
INSERT INTO `seat` VALUES (205, 52, 1);
INSERT INTO `seat` VALUES (206, 52, 2);
INSERT INTO `seat` VALUES (207, 52, 3);
INSERT INTO `seat` VALUES (208, 52, 4);
INSERT INTO `seat` VALUES (209, 53, 1);
INSERT INTO `seat` VALUES (210, 53, 2);
INSERT INTO `seat` VALUES (211, 53, 3);
INSERT INTO `seat` VALUES (212, 53, 4);
INSERT INTO `seat` VALUES (213, 54, 1);
INSERT INTO `seat` VALUES (214, 54, 2);
INSERT INTO `seat` VALUES (215, 54, 3);
INSERT INTO `seat` VALUES (216, 54, 4);
INSERT INTO `seat` VALUES (217, 55, 1);
INSERT INTO `seat` VALUES (218, 55, 2);
INSERT INTO `seat` VALUES (219, 55, 3);
INSERT INTO `seat` VALUES (220, 55, 4);
INSERT INTO `seat` VALUES (221, 56, 1);
INSERT INTO `seat` VALUES (222, 56, 2);
INSERT INTO `seat` VALUES (223, 56, 3);
INSERT INTO `seat` VALUES (224, 56, 4);
INSERT INTO `seat` VALUES (225, 57, 1);
INSERT INTO `seat` VALUES (226, 57, 2);
INSERT INTO `seat` VALUES (227, 57, 3);
INSERT INTO `seat` VALUES (228, 57, 4);
INSERT INTO `seat` VALUES (229, 58, 1);
INSERT INTO `seat` VALUES (230, 58, 2);
INSERT INTO `seat` VALUES (231, 58, 3);
INSERT INTO `seat` VALUES (232, 58, 4);
INSERT INTO `seat` VALUES (233, 59, 1);
INSERT INTO `seat` VALUES (234, 59, 2);
INSERT INTO `seat` VALUES (235, 59, 3);
INSERT INTO `seat` VALUES (236, 59, 4);
INSERT INTO `seat` VALUES (237, 60, 1);
INSERT INTO `seat` VALUES (238, 60, 2);
INSERT INTO `seat` VALUES (239, 60, 3);
INSERT INTO `seat` VALUES (240, 60, 4);
INSERT INTO `seat` VALUES (241, 61, 1);
INSERT INTO `seat` VALUES (242, 61, 2);
INSERT INTO `seat` VALUES (243, 61, 3);
INSERT INTO `seat` VALUES (244, 61, 4);
INSERT INTO `seat` VALUES (245, 62, 1);
INSERT INTO `seat` VALUES (246, 62, 2);
INSERT INTO `seat` VALUES (247, 62, 3);
INSERT INTO `seat` VALUES (248, 62, 4);
INSERT INTO `seat` VALUES (249, 63, 1);
INSERT INTO `seat` VALUES (250, 63, 2);
INSERT INTO `seat` VALUES (251, 63, 3);
INSERT INTO `seat` VALUES (252, 63, 4);
INSERT INTO `seat` VALUES (253, 64, 1);
INSERT INTO `seat` VALUES (254, 64, 2);
INSERT INTO `seat` VALUES (255, 64, 3);
INSERT INTO `seat` VALUES (256, 64, 4);
INSERT INTO `seat` VALUES (257, 65, 1);
INSERT INTO `seat` VALUES (258, 65, 2);
INSERT INTO `seat` VALUES (259, 65, 3);
INSERT INTO `seat` VALUES (260, 65, 4);
INSERT INTO `seat` VALUES (261, 66, 1);
INSERT INTO `seat` VALUES (262, 66, 2);
INSERT INTO `seat` VALUES (263, 66, 3);
INSERT INTO `seat` VALUES (264, 66, 4);

-- ----------------------------
-- Table structure for serial
-- ----------------------------
DROP TABLE IF EXISTS `serial`;
CREATE TABLE `serial`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serial` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `serial`(`serial`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Redundant;

-- ----------------------------
-- Records of serial
-- ----------------------------
INSERT INTO `serial` VALUES (1, '2018119055', '20010129');
INSERT INTO `serial` VALUES (2, '2018119056', '20001203');
INSERT INTO `serial` VALUES (3, '2018119057', '20001114');
INSERT INTO `serial` VALUES (4, '2018119058', '20001113');
INSERT INTO `serial` VALUES (5, '2018119059', '20001027');
INSERT INTO `serial` VALUES (6, '2018119060', '20001022');
INSERT INTO `serial` VALUES (7, '2018119061', '20000926');
INSERT INTO `serial` VALUES (8, '2018119062', '20000824');
INSERT INTO `serial` VALUES (9, '2018119063', '20000810');
INSERT INTO `serial` VALUES (10, '2018119064', '20000725');
INSERT INTO `serial` VALUES (11, '2018119065', '20000522');
INSERT INTO `serial` VALUES (12, '2018119066', '20000421');
INSERT INTO `serial` VALUES (13, '2018119067', '20000415');
INSERT INTO `serial` VALUES (14, '2018119068', '20000311');
INSERT INTO `serial` VALUES (15, '2018119069', '20000219');
INSERT INTO `serial` VALUES (16, '2018119071', '20000123');
INSERT INTO `serial` VALUES (17, '2018119072', '20000120');
INSERT INTO `serial` VALUES (18, '2018119073', '20000112');
INSERT INTO `serial` VALUES (19, '2018119074', '19991106');
INSERT INTO `serial` VALUES (20, '2018119075', '19991106');
INSERT INTO `serial` VALUES (21, '2018119076', '19981217');
INSERT INTO `serial` VALUES (22, '2018119077', '19980728');
INSERT INTO `serial` VALUES (23, '2018119078', '20011013');
INSERT INTO `serial` VALUES (24, '2018119079', '20010610');
INSERT INTO `serial` VALUES (25, '2018119080', '20010204');
INSERT INTO `serial` VALUES (26, '2018119081', '20010127');
INSERT INTO `serial` VALUES (27, '2018119082', '20001121');
INSERT INTO `serial` VALUES (28, '2018119083', '20001106');
INSERT INTO `serial` VALUES (29, '2018119084', '20001025');
INSERT INTO `serial` VALUES (30, '2018119085', '20001022');
INSERT INTO `serial` VALUES (31, '2018119086', '20000912');
INSERT INTO `serial` VALUES (32, '2018119087', '20000805');
INSERT INTO `serial` VALUES (33, '2018119088', '20000714');
INSERT INTO `serial` VALUES (34, '2018119089', '20000308');
INSERT INTO `serial` VALUES (35, '2018119090', '20000205');
INSERT INTO `serial` VALUES (36, '2018119091', '20000126');
INSERT INTO `serial` VALUES (37, '2018119092', '20000122');
INSERT INTO `serial` VALUES (38, '2018119093', '20000120');
INSERT INTO `serial` VALUES (39, '2018119094', '19991207');
INSERT INTO `serial` VALUES (40, '2018119095', '19991204');
INSERT INTO `serial` VALUES (41, '2018119096', '19991118');
INSERT INTO `serial` VALUES (42, '2018119097', '19991106');
INSERT INTO `serial` VALUES (43, '2018119098', '19990823');
INSERT INTO `serial` VALUES (44, '2018119099', '19990703');

-- ----------------------------
-- Table structure for table
-- ----------------------------
DROP TABLE IF EXISTS `table`;
CREATE TABLE `table`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` int(11) NOT NULL,
  `column` int(11) NOT NULL,
  `row` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of table
-- ----------------------------
INSERT INTO `table` VALUES (1, 0, 0, 0);
INSERT INTO `table` VALUES (2, 0, 1, 0);
INSERT INTO `table` VALUES (3, 0, 3, 0);
INSERT INTO `table` VALUES (4, 0, 2, 1);
INSERT INTO `table` VALUES (5, 0, 4, 1);
INSERT INTO `table` VALUES (6, 0, 1, 2);
INSERT INTO `table` VALUES (7, 0, 2, 2);
INSERT INTO `table` VALUES (8, 0, 4, 2);
INSERT INTO `table` VALUES (9, 0, 2, 3);
INSERT INTO `table` VALUES (10, 0, 1, 5);
INSERT INTO `table` VALUES (11, 0, 6, 1);
INSERT INTO `table` VALUES (12, 1, 0, 0);
INSERT INTO `table` VALUES (13, 1, 1, 0);
INSERT INTO `table` VALUES (14, 1, 3, 0);
INSERT INTO `table` VALUES (15, 1, 2, 1);
INSERT INTO `table` VALUES (16, 1, 4, 1);
INSERT INTO `table` VALUES (17, 1, 1, 2);
INSERT INTO `table` VALUES (18, 1, 2, 2);
INSERT INTO `table` VALUES (19, 1, 4, 2);
INSERT INTO `table` VALUES (20, 1, 2, 3);
INSERT INTO `table` VALUES (21, 1, 1, 5);
INSERT INTO `table` VALUES (22, 1, 6, 1);
INSERT INTO `table` VALUES (23, 2, 0, 0);
INSERT INTO `table` VALUES (24, 2, 1, 0);
INSERT INTO `table` VALUES (25, 2, 3, 0);
INSERT INTO `table` VALUES (26, 2, 2, 1);
INSERT INTO `table` VALUES (27, 2, 4, 1);
INSERT INTO `table` VALUES (28, 2, 1, 2);
INSERT INTO `table` VALUES (29, 2, 2, 2);
INSERT INTO `table` VALUES (30, 2, 4, 2);
INSERT INTO `table` VALUES (31, 2, 2, 3);
INSERT INTO `table` VALUES (32, 2, 1, 5);
INSERT INTO `table` VALUES (33, 2, 6, 1);
INSERT INTO `table` VALUES (34, 3, 0, 0);
INSERT INTO `table` VALUES (35, 3, 1, 0);
INSERT INTO `table` VALUES (36, 3, 3, 0);
INSERT INTO `table` VALUES (37, 3, 2, 1);
INSERT INTO `table` VALUES (38, 3, 4, 1);
INSERT INTO `table` VALUES (39, 3, 1, 2);
INSERT INTO `table` VALUES (40, 3, 2, 2);
INSERT INTO `table` VALUES (41, 3, 4, 2);
INSERT INTO `table` VALUES (42, 3, 2, 3);
INSERT INTO `table` VALUES (43, 3, 1, 5);
INSERT INTO `table` VALUES (44, 3, 6, 1);
INSERT INTO `table` VALUES (45, 4, 0, 0);
INSERT INTO `table` VALUES (46, 4, 1, 0);
INSERT INTO `table` VALUES (47, 4, 3, 0);
INSERT INTO `table` VALUES (48, 4, 2, 1);
INSERT INTO `table` VALUES (49, 4, 4, 1);
INSERT INTO `table` VALUES (50, 4, 1, 2);
INSERT INTO `table` VALUES (51, 4, 2, 2);
INSERT INTO `table` VALUES (52, 4, 4, 2);
INSERT INTO `table` VALUES (53, 4, 2, 3);
INSERT INTO `table` VALUES (54, 4, 1, 5);
INSERT INTO `table` VALUES (55, 4, 6, 1);
INSERT INTO `table` VALUES (56, 5, 0, 0);
INSERT INTO `table` VALUES (57, 5, 1, 0);
INSERT INTO `table` VALUES (58, 5, 3, 0);
INSERT INTO `table` VALUES (59, 5, 2, 1);
INSERT INTO `table` VALUES (60, 5, 4, 1);
INSERT INTO `table` VALUES (61, 5, 1, 2);
INSERT INTO `table` VALUES (62, 5, 2, 2);
INSERT INTO `table` VALUES (63, 5, 4, 2);
INSERT INTO `table` VALUES (64, 5, 2, 3);
INSERT INTO `table` VALUES (65, 5, 1, 5);
INSERT INTO `table` VALUES (66, 5, 6, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serial` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `punish_date` date NULL DEFAULT NULL,
  `openid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `session_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `session_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `serial`(`serial`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`serial`) REFERENCES `serial` (`serial`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '2018119055', '2020-06-30', '11129', '1110', '10003');
INSERT INTO `user` VALUES (2, '2018119056', '2020-07-02', '12694', '1463', '10008');
INSERT INTO `user` VALUES (3, '2018119057', '2020-06-28', '14399', '1884', '10015');
INSERT INTO `user` VALUES (4, '2018119058', '2020-06-29', '16250', '2379', '10024');
INSERT INTO `user` VALUES (5, '2018119059', '2020-06-30', '18253', '2954', '10035');
INSERT INTO `user` VALUES (6, '2018119060', '2020-06-30', '20414', '3615', '10048');
INSERT INTO `user` VALUES (7, '2018119061', '2020-06-29', '22739', '4368', '10063');
INSERT INTO `user` VALUES (8, '2018119062', NULL, '25234', '5219', '10080');
INSERT INTO `user` VALUES (9, '2018119063', NULL, '27905', '6174', '10099');
INSERT INTO `user` VALUES (10, '2018119064', NULL, '30758', '7239', '10120');
INSERT INTO `user` VALUES (11, '2018119065', NULL, '33799', '8420', '10143');
INSERT INTO `user` VALUES (12, '2018119066', NULL, '37034', '9723', '10168');
INSERT INTO `user` VALUES (13, '2018119067', NULL, '40469', '11154', '10195');
INSERT INTO `user` VALUES (14, '2018119068', NULL, '44110', '12719', '10224');
INSERT INTO `user` VALUES (15, '2018119069', NULL, '47963', '14424', '10255');
INSERT INTO `user` VALUES (16, '2018119071', NULL, '52034', '16275', '10288');
INSERT INTO `user` VALUES (17, '2018119072', NULL, '56329', '18278', '10323');
INSERT INTO `user` VALUES (18, '2018119073', NULL, '60854', '20439', '10360');
INSERT INTO `user` VALUES (19, '2018119074', NULL, '65615', '22764', '10399');
INSERT INTO `user` VALUES (20, '2018119075', NULL, '70618', '25259', '10440');
INSERT INTO `user` VALUES (21, '2018119076', NULL, '75869', '12345', '10483');
INSERT INTO `user` VALUES (22, '2018119077', NULL, '81374', '32521', '13456');

-- ----------------------------
-- View structure for in_use_seats_each_level
-- ----------------------------
DROP VIEW IF EXISTS `in_use_seats_each_level`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `in_use_seats_each_level` AS select `t`.`level` AS `level`,count(0) AS `count` from ((`reservation` `r` join `seat` `s`) join `table` `t`) where ((`r`.`seat_id` = `s`.`id`) and (`s`.`table_id` = `t`.`id`) and (`r`.`reservation_date` = curdate()) and (curtime() > `r`.`start`) and (`r`.`end` > curtime()) and isnull(`r`.`leave_time`) and (((`r`.`enter_time` + interval 30 minute) > curtime()) or ((`r`.`enter_time` is not null) and ((`r`.`start` + interval 30 minute) > `r`.`enter_time`)))) group by `t`.`level`;

-- ----------------------------
-- View structure for seats_count_each_level
-- ----------------------------
DROP VIEW IF EXISTS `seats_count_each_level`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `seats_count_each_level` AS select `t`.`level` AS `level`,count(0) AS `count` from (`seat` `s` join `table` `t`) where (`s`.`table_id` = `t`.`id`) group by `t`.`level`;

SET FOREIGN_KEY_CHECKS = 1;
