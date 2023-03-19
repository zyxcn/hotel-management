/*
MySQL Backup
Database: hotel_management
Backup Time: 2023-03-19 16:05:50
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `hotel_management`.`admin`;
DROP TABLE IF EXISTS `hotel_management`.`order`;
DROP TABLE IF EXISTS `hotel_management`.`price`;
DROP TABLE IF EXISTS `hotel_management`.`relation`;
DROP TABLE IF EXISTS `hotel_management`.`room`;
DROP TABLE IF EXISTS `hotel_management`.`room_type`;
DROP TABLE IF EXISTS `hotel_management`.`user`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL COMMENT '管理员id',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `account` varchar(20) DEFAULT NULL COMMENT '账号',
  `password` varchar(30) DEFAULT NULL COMMENT '密码',
  `user_name` varchar(20) DEFAULT NULL COMMENT '用户名',
  `img_url` varchar(255) DEFAULT NULL COMMENT '图片url',
  `id_card` char(18) DEFAULT NULL COMMENT '身份证',
  `tel` varchar(16) DEFAULT NULL COMMENT '电话号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `order` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `begin` date DEFAULT NULL COMMENT '订单起租时间',
  `stay` int(11) DEFAULT NULL COMMENT '居住时长',
  `prepay` float DEFAULT NULL COMMENT '预付款',
  `pay` float DEFAULT NULL COMMENT '实付款',
  `rental` float DEFAULT NULL COMMENT '租金总额',
  `id_card` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
CREATE TABLE `price` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '价目id',
  `money` float DEFAULT NULL COMMENT '日租金额',
  `prepay` float DEFAULT NULL COMMENT '预付金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
CREATE TABLE `relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  `order_id` bigint(30) DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`),
  KEY `fk_relation_admin_1` (`admin_id`),
  KEY `fk_relation_order_1` (`order_id`),
  KEY `fk_relation_user_1` (`user_id`),
  KEY `fk_relation_room_1` (`room_id`),
  CONSTRAINT `fk_relation_admin_1` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_relation_order_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_relation_room_1` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_relation_user_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
CREATE TABLE `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '房间id',
  `num` varchar(6) NOT NULL COMMENT '房间号',
  `type_id` int(11) NOT NULL COMMENT '房间类型id',
  `price_id` int(11) NOT NULL COMMENT '房间价目id',
  `status` varchar(20) DEFAULT NULL COMMENT '房间状态',
  PRIMARY KEY (`id`),
  KEY `fk_room_room_type` (`type_id`),
  KEY `fk_room_price` (`price_id`),
  CONSTRAINT `fk_room_price` FOREIGN KEY (`price_id`) REFERENCES `price` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_room_room_type` FOREIGN KEY (`type_id`) REFERENCES `room_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
CREATE TABLE `room_type` (
  `id` int(11) NOT NULL,
  `type` varchar(20) DEFAULT NULL COMMENT '房间类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `img` mediumblob COMMENT '用户图片url',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `id_card` char(18) DEFAULT NULL COMMENT '身份证号',
  `sex` varchar(20) DEFAULT NULL COMMENT '性别',
  `tel` varchar(16) DEFAULT NULL COMMENT '电话号码',
  `status` varchar(20) DEFAULT NULL COMMENT '状态',
  `account` varchar(20) DEFAULT NULL COMMENT '账号',
  `user_name` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(30) DEFAULT NULL COMMENT '密码',
  `admin` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
BEGIN;
LOCK TABLES `hotel_management`.`admin` WRITE;
DELETE FROM `hotel_management`.`admin`;
INSERT INTO `hotel_management`.`admin` (`id`,`name`,`account`,`password`,`user_name`,`img_url`,`id_card`,`tel`) VALUES (1, '李四', 'admin01', '1318409b40c7b818', 'admin01', '', '211xxxxxxxxxx11', '166******23');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `hotel_management`.`order` WRITE;
DELETE FROM `hotel_management`.`order`;
INSERT INTO `hotel_management`.`order` (`id`,`begin`,`stay`,`prepay`,`pay`,`rental`,`id_card`,`name`,`phone`) VALUES (3, '2023-10-29', 427, 150, 150, 200, NULL, NULL, NULL),(4, '2023-11-29', 31, 4650, 4650, 6200, NULL, NULL, NULL),(5, '2023-12-30', -30, -4500, -4500, -6000, NULL, NULL, NULL),(6, '2023-11-30', 30, 4500, 4500, 6000, NULL, NULL, NULL),(7, '2023-11-30', 30, 4500, 4500, 6000, NULL, NULL, NULL),(8, '2023-10-29', 61, 9150, 9150, 12200, NULL, NULL, NULL),(10, '2023-03-17', 166, 24900, 24900, 33200, '***********', '张三', '123456');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `hotel_management`.`price` WRITE;
DELETE FROM `hotel_management`.`price`;
INSERT INTO `hotel_management`.`price` (`id`,`money`,`prepay`) VALUES (1, 200, 150),(2, 100, 50),(7, 123, 123),(8, 200, 111);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `hotel_management`.`relation` WRITE;
DELETE FROM `hotel_management`.`relation`;
INSERT INTO `hotel_management`.`relation` (`id`,`user_id`,`room_id`,`order_id`,`admin_id`,`status`) VALUES (4, 1, 2, 10, NULL, '有效');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `hotel_management`.`room` WRITE;
DELETE FROM `hotel_management`.`room`;
INSERT INTO `hotel_management`.`room` (`id`,`num`,`type_id`,`price_id`,`status`) VALUES (1, '101', 2, 8, '已租出'),(2, '102', 1, 1, '新增'),(7, '123', 1, 2, '新增'),(19, '12311', 1, 1, '新增');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `hotel_management`.`room_type` WRITE;
DELETE FROM `hotel_management`.`room_type`;
INSERT INTO `hotel_management`.`room_type` (`id`,`type`) VALUES (1, '单人房'),(2, '双人房'),(3, '三人房'),(4, '大床房');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `hotel_management`.`user` WRITE;
DELETE FROM `hotel_management`.`user`;
INSERT INTO `hotel_management`.`user` (`id`,`img`,`name`,`id_card`,`sex`,`tel`,`status`,`account`,`user_name`,`password`,`admin`) VALUES (1, NULL, '张三', '***********', '男', '123456', '已入住', '123456', 'zs111', '123456', 1);
UNLOCK TABLES;
COMMIT;
