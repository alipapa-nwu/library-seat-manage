/*
 Navicat Premium Data Transfer

 Source Server         : 本机docker
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : seat

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 15/06/2020 18:59:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for reservation
-- ----------------------------
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation`
(
    `id`               int(11) NOT NULL AUTO_INCREMENT,
    `user_id`          int(11) NOT NULL,
    `seat_id`          int(11) NOT NULL,
    `start`            time(0) NOT NULL,
    `end`              time(0) NOT NULL,
    `reservation_date` date    NOT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `user_id` (`user_id`) USING BTREE,
    INDEX `seat_id` (`seat_id`) USING BTREE,
    CONSTRAINT `reservation_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `reservation_ibfk_4` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reservation
-- ----------------------------
INSERT INTO `reservation`
VALUES (1, 1, 6, '08:00:00', '22:00:00', '2020-06-15');


-- ----------------------------
-- Table structure for realtime
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`
(
    `id`               int(11) NOT NULL AUTO_INCREMENT,
    `user_id`          int(11) NOT NULL,
    `enter_time`       time(0) NOT NULL,
    `leave_time`       time(0) NULL DEFAULT NULL,
    `record_date` date    NOT NULL,
    PRIMARY KEY (`id`) USING BTREE,
     CONSTRAINT `record_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of realtime
-- ----------------------------
INSERT INTO `record`
VALUES (1,1, '08:26:23', NULL,'2020-06-15');


-- ----------------------------
-- Table structure for seat
-- ----------------------------
DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat`
(
    `id`       int(11) NOT NULL AUTO_INCREMENT,
    `table_id` int(11) NOT NULL,
    `position` int(11) NOT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `table_id` (`table_id`) USING BTREE,
    CONSTRAINT `seat_ibfk_1` FOREIGN KEY (`table_id`) REFERENCES `table` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 33
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seat
-- ----------------------------
INSERT INTO `seat`
VALUES (1, 1, 1);
INSERT INTO `seat`
VALUES (2, 1, 2);
INSERT INTO `seat`
VALUES (3, 1, 3);
INSERT INTO `seat`
VALUES (4, 1, 4);
INSERT INTO `seat`
VALUES (5, 2, 1);
INSERT INTO `seat`
VALUES (6, 2, 2);
INSERT INTO `seat`
VALUES (7, 2, 3);
INSERT INTO `seat`
VALUES (8, 2, 4);
INSERT INTO `seat`
VALUES (9, 3, 1);
INSERT INTO `seat`
VALUES (10, 3, 2);
INSERT INTO `seat`
VALUES (11, 3, 3);
INSERT INTO `seat`
VALUES (12, 3, 4);
INSERT INTO `seat`
VALUES (13, 4, 1);
INSERT INTO `seat`
VALUES (14, 4, 2);
INSERT INTO `seat`
VALUES (15, 4, 3);
INSERT INTO `seat`
VALUES (16, 4, 4);
INSERT INTO `seat`
VALUES (17, 5, 1);
INSERT INTO `seat`
VALUES (18, 5, 2);
INSERT INTO `seat`
VALUES (19, 5, 3);
INSERT INTO `seat`
VALUES (20, 5, 4);
INSERT INTO `seat`
VALUES (21, 6, 1);
INSERT INTO `seat`
VALUES (22, 6, 2);
INSERT INTO `seat`
VALUES (23, 6, 3);
INSERT INTO `seat`
VALUES (24, 6, 4);
INSERT INTO `seat`
VALUES (25, 7, 1);
INSERT INTO `seat`
VALUES (26, 7, 2);
INSERT INTO `seat`
VALUES (27, 7, 3);
INSERT INTO `seat`
VALUES (28, 7, 4);
INSERT INTO `seat`
VALUES (29, 8, 1);
INSERT INTO `seat`
VALUES (30, 8, 2);
INSERT INTO `seat`
VALUES (31, 8, 3);
INSERT INTO `seat`
VALUES (32, 8, 4);

-- ----------------------------
-- Table structure for serial
-- ----------------------------
DROP TABLE IF EXISTS `serial`;
CREATE TABLE `serial`
(
    `id`       int(11)                                                       NOT NULL AUTO_INCREMENT,
    `serial`   varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL,
    `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `serial` (`serial`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 23
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of serial
-- ----------------------------
INSERT INTO `serial`
VALUES (1, '2018115209', '22511X');
INSERT INTO `serial`
VALUES (3, '2018115100', '115100');
INSERT INTO `serial`
VALUES (4, '2018115101', '115101');
INSERT INTO `serial`
VALUES (5, '2018115102', '115102');
INSERT INTO `serial`
VALUES (6, '2018115103', '115103');
INSERT INTO `serial`
VALUES (7, '2018115104', '115104');
INSERT INTO `serial`
VALUES (8, '2018115105', '115105');
INSERT INTO `serial`
VALUES (9, '2018115106', '115106');
INSERT INTO `serial`
VALUES (10, '2018115107', '115107');
INSERT INTO `serial`
VALUES (11, '2018115108', '115108');
INSERT INTO `serial`
VALUES (12, '2018115109', '115109');
INSERT INTO `serial`
VALUES (13, '2018115110', '115110');
INSERT INTO `serial`
VALUES (14, '2018115111', '115111');
INSERT INTO `serial`
VALUES (15, '2018115112', '115112');
INSERT INTO `serial`
VALUES (16, '2018115113', '115113');
INSERT INTO `serial`
VALUES (17, '2018115114', '115114');
INSERT INTO `serial`
VALUES (18, '2018115115', '115115');
INSERT INTO `serial`
VALUES (19, '2018115116', '115116');
INSERT INTO `serial`
VALUES (20, '2018115117', '115117');
INSERT INTO `serial`
VALUES (21, '2018115118', '115118');
INSERT INTO `serial`
VALUES (22, '2018115119', '115119');

-- ----------------------------
-- Table structure for table
-- ----------------------------
DROP TABLE IF EXISTS `table`;
CREATE TABLE `table`
(
    `id`     int(11) NOT NULL AUTO_INCREMENT,
    `level`  int(11) NOT NULL,
    `column` int(11) NOT NULL,
    `row`    int(11) NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 12
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of table
-- ----------------------------
INSERT INTO `table`
VALUES (1, 0, 0, 0);
INSERT INTO `table`
VALUES (2, 0, 1, 0);
INSERT INTO `table`
VALUES (3, 0, 3, 0);
INSERT INTO `table`
VALUES (4, 0, 2, 1);
INSERT INTO `table`
VALUES (5, 0, 4, 1);
INSERT INTO `table`
VALUES (6, 0, 1, 2);
INSERT INTO `table`
VALUES (7, 0, 2, 2);
INSERT INTO `table`
VALUES (8, 0, 4, 2);
INSERT INTO `table`
VALUES (9, 0, 2, 3);
INSERT INTO `table`
VALUES (10, 0, 1, 5);
INSERT INTO `table`
VALUES (11, 0, 6, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`             int(11)                                                       NOT NULL AUTO_INCREMENT,
    `serial`         varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL,
    `name`           varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL,
    `punish_date`    date                                                          NULL DEFAULT NULL,
    `openid`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `session_id`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL,
    `session_key`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `session_expire` datetime(0)                                                   NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `serial` (`serial`) USING BTREE,
    CONSTRAINT `user_ibfk_1` FOREIGN KEY (`serial`) REFERENCES `serial` (`serial`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES (1, '2018115209', 'milo', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- View structure for in_use_seats_each_level
-- ----------------------------
DROP VIEW IF EXISTS `in_use_seats_each_level`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `in_use_seats_each_level` AS
select `t`.`level` AS `level`, count(0) AS `count`
from ((`reservation` `r` join `seat` `s`)
         join `table` `t`)
where ((`r`.`seat_id` = `s`.`id`) and (`s`.`table_id` = `t`.`id`) and (`r`.`reservation_date` = curdate()) and
       (curtime() > `r`.`start`) and (`r`.`end` > curtime()) and isnull(`r`.`leave_time`) and
       (((`r`.`enter_time` + interval 30 minute) > curtime()) or
        ((`r`.`enter_time` is not null) and ((`r`.`start` + interval 30 minute) > `r`.`enter_time`))))
group by `t`.`level`;

-- ----------------------------
-- View structure for seats_count_each_level
-- ----------------------------
DROP VIEW IF EXISTS `seats_count_each_level`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `seats_count_each_level` AS
select `t`.`level` AS `level`, count(0) AS `count`
from (`seat` `s`
         join `table` `t`)
where (`s`.`table_id` = `t`.`id`)
group by `t`.`level`;

SET FOREIGN_KEY_CHECKS = 1;
