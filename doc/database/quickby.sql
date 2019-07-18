/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.6.24-72.2 : Database - quickbuy
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`quickbuy` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `quickbuy`;

/*Table structure for table `announcement_info` */

DROP TABLE IF EXISTS `announcement_info`;

CREATE TABLE `announcement_info` (
  `announcement_id` int(10) NOT NULL AUTO_INCREMENT,
  `announcement_title` varchar(50) NOT NULL,
  `announcement_description` text NOT NULL,
  `announcement_distribute_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`announcement_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `announcement_info` */

insert  into `announcement_info`(`announcement_id`,`announcement_title`,`announcement_description`,`announcement_distribute_time`) values (1,'放假通知','自该消息发布之日起，店长回老家探亲，下单不予以配送，请谅解','2019-07-12 14:05:07'),(2,'正常营业通知','由于店长提前回来，即日起恢复营业，望周知','2019-07-12 17:16:21');

/*Table structure for table `cart_info` */

DROP TABLE IF EXISTS `cart_info`;

CREATE TABLE `cart_info` (
  `cart_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) NOT NULL,
  `product_id` int(10) NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `product_count` int(10) DEFAULT '1',
  `total_price` decimal(12,2) NOT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=195 DEFAULT CHARSET=utf8;

/*Data for the table `cart_info` */

insert  into `cart_info`(`cart_id`,`user_id`,`product_id`,`product_name`,`product_count`,`total_price`) values (1,100,2,'yyyyy',23,'12.00'),(2,2,2,'wanglaoshi',87,'2.00'),(3,5,1,'1',6,'1.00'),(4,1,3,'liulaoshi',5,'1.00'),(10,188,70,'50',1,'5.00'),(12,188,77,'uusn',7,'1111.00'),(13,8,35,'sjsja',1,'54.00'),(28,6,7,'liulaoshi',20,'2.00'),(38,5,8,'liulaoshi',20,'2.00'),(40,2,8,'liulaoshi',140,'2.00'),(111,1222,1,'1',1,'1.00'),(194,3,23,'薯片',1,'22.50');

/*Table structure for table `order_info` */

DROP TABLE IF EXISTS `order_info`;

CREATE TABLE `order_info` (
  `order_id` bigint(20) NOT NULL,
  `order_status` int(1) DEFAULT '0',
  `user_id` int(10) NOT NULL,
  `user_real_name` varchar(50) NOT NULL,
  `user_phone` varchar(11) NOT NULL,
  `user_address` varchar(255) NOT NULL,
  `order_detail` text,
  `order_remark` text,
  `order_distribute_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `order_total_price` decimal(12,2) NOT NULL,
  `product_id` int(10) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order_info` */

insert  into `order_info`(`order_id`,`order_status`,`user_id`,`user_real_name`,`user_phone`,`user_address`,`order_detail`,`order_remark`,`order_distribute_time`,`order_total_price`,`product_id`) values (1,0,3,'dhl','12345678901','nj',NULL,NULL,'2019-07-14 15:02:41','100.00',0),(2,0,3,'dhl','12345609871','nj',NULL,NULL,'2019-07-14 15:03:10','12.00',0),(30000000001,0,3,'dhl','12345678910','nj',NULL,NULL,'2019-07-15 19:02:40','10.00',1),(30000000002,0,3,'戴海林','15651803360','南京市玄武区总统府校区达内',NULL,NULL,'2019-07-16 19:34:08','22.50',23),(150000000016,0,15,'111111','15720606003','111111',NULL,NULL,'2019-07-15 18:36:25','5.00',1),(150000000017,0,15,'111111','15720606003','111111',NULL,NULL,'2019-07-15 18:38:58','5.00',1),(150000000018,0,15,'111111','15720606003','111111',NULL,NULL,'2019-07-15 18:41:02','3.00',3),(150000000019,0,15,'111111','15720606003','111111',NULL,NULL,'2019-07-15 18:43:39','10.00',1),(150000000020,0,15,'111111','15720606003','111111',NULL,NULL,'2019-07-15 18:45:09','3.00',2),(150000000021,0,15,'111111','15720606003','111111',NULL,NULL,'2019-07-15 18:45:43','10.00',4),(150000000022,0,15,'111111','15720606003','111111',NULL,NULL,'2019-07-15 18:47:17','5.00',1),(150000000023,0,15,'111111','15720606003','111111',NULL,NULL,'2019-07-15 18:49:30','3.00',3),(150000000024,0,15,'111111','15720606003','111111',NULL,NULL,'2019-07-15 18:51:45','5.00',4),(150000000025,0,15,'111111','15720606003','111111',NULL,NULL,'2019-07-15 18:54:40','3.00',2),(150000000026,0,15,'111111','15720606003','111111',NULL,NULL,'2019-07-15 18:55:50','5.00',1),(150000000027,0,15,'111111','15720606003','111111',NULL,NULL,'2019-07-15 18:55:50','3.00',2),(150000000028,0,15,'111','15720606003','qqqqqq',NULL,NULL,'2019-07-16 19:56:53','3.00',3),(150000000029,0,15,'111','15720606003','qqqqqq',NULL,NULL,'2019-07-17 09:40:48','15.00',1),(150000000030,0,15,'111','15720606003','qqqqqq',NULL,NULL,'2019-07-17 10:19:53','30.00',1),(200000000001,0,20,'yxy','15852911858','111',NULL,NULL,'2019-07-16 19:57:03','7.00',15),(200000000002,0,20,'yxy','15852911858','111',NULL,NULL,'2019-07-16 19:57:03','22.50',23),(210000000001,0,21,'赵文鸿','15751865763','南京',NULL,NULL,'2019-07-16 20:38:31','5.00',1),(210000000002,0,21,'赵文鸿','15751865763','南京',NULL,NULL,'2019-07-17 09:58:08','5.00',1);

/*Table structure for table `product_info` */

DROP TABLE IF EXISTS `product_info`;

CREATE TABLE `product_info` (
  `product_id` int(10) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(50) NOT NULL,
  `product_image_path` varchar(255) DEFAULT NULL,
  `sort_id` int(10) DEFAULT NULL,
  `sort_name` varchar(50) DEFAULT NULL,
  `product_price` decimal(12,2) NOT NULL,
  `recommendation_level` int(1) DEFAULT '0',
  `product_heat` int(10) DEFAULT '0',
  `product_sell_count` int(10) DEFAULT '0',
  `product_description` text,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

/*Data for the table `product_info` */

insert  into `product_info`(`product_id`,`product_name`,`product_image_path`,`sort_id`,`sort_name`,`product_price`,`recommendation_level`,`product_heat`,`product_sell_count`,`product_description`) values (1,'好基友面包','http://www.florist.com/image/mianbao.jpg',1,'零食','5.00',0,0,11,'跟好基友一起吃的面包'),(2,'万事可乐','http://www.florist.com/image/kele.jpg',2,'饮料','3.00',0,0,3,'建议配合好基友面包一起食用'),(3,'cola','http://www.florist.com/image/kele.jpg',2,'饮料','3.00',0,0,4,NULL),(4,'bread','http://www.florist.com/image/mianbao.jpg',1,'零食','5.00',0,0,8,NULL),(10,'小型煎蛋器','http://www.florist.com/image/s8p001.png',3,'生活用品','10.00',0,0,1,'这是煎蛋器'),(11,'挖勺器','http://www.florist.com/image/s8p002.png',3,'生活用品','5.00',0,0,11,'这是挖勺器'),(12,'USB小风扇','http://www.florist.com/image/s8p003.png',3,'生活用品','23.00',0,0,4,'这是小风扇'),(13,'垃圾袋','http://www.florist.com/image/s8p004.png',3,'生活用品','3.00',0,0,1,'这是垃圾袋'),(14,'小型行李箱','http://www.florist.com/image/s8p005.png',3,'生活用品','5.00',0,0,5,'这是行李箱'),(15,'肥皂盒','http://www.florist.com/image/s8p006.png',3,'生活用品','7.00',0,0,8,'这是肥皂盒'),(16,'钥匙钩','http://www.florist.com/image/s8p007.png',3,'生活用品','5.00',0,0,6,'这是钥匙钩'),(17,'USB小夜灯','http://www.florist.com/image/s8p008.png',3,'生活用品','32.00',0,0,4,'这是小夜灯'),(18,'晾衣架','http://www.florist.com/image/s8p009.png',3,'生活用品','23.00',0,0,1,'这是晾衣架'),(19,'USB加湿器','http://www.florist.com/image/s8p010.png',3,'生活用品','55.00',0,0,96,'这是加湿器'),(20,'红毛丹','http://www.florist.com/image/s9p001.png',1,'零食','34.00',0,0,35,'这是红毛丹'),(21,'奶片','http://www.florist.com/image/s9p002.png',1,'零食','10.00',0,0,4,'这是奶片'),(22,'奇异果','http://www.florist.com/image/s9p003.png',1,'零食','15.00',0,0,3,'这是奇异果'),(23,'薯片','http://www.florist.com/image/s9p004.png',1,'零食','22.50',0,0,13,'这是薯片'),(24,'不二家棒棒糖','http://www.florist.com/image/s9p005.png',1,'零食','11.70',0,0,8,'这是不二家棒棒糖'),(25,'红富士苹果','http://www.florist.com/image/s9p006.png',1,'零食','34.50',0,0,3,'这是红富士苹果'),(26,'精品雪糕','http://www.florist.com/image/s9p007.png',1,'零食','56.70',0,0,5,'这是雪糕'),(27,'精品猪肉铺','http://www.florist.com/image/s9p008.png',1,'零食','15.30',0,0,8,'这是猪肉铺'),(28,'巴旦木','http://www.florist.com/image/s9p009.png',1,'零食','23.80',0,0,3,'这是巴旦木'),(29,'奥利奥饼干','http://www.florist.com/image/s9p010.png',1,'零食','26.00',0,0,11,'这是奥利奥饼干'),(30,'哈根达斯','http://www.florist.com/image/s9p011.png',1,'零食','66.00',0,0,34,'这是哈根达斯'),(31,'高级笔袋','http://www.florist.com/image/s10p001.png',4,'文具','15.00',0,0,4,'这是笔袋'),(32,'高级笔记本','http://www.florist.com/image/s10p002.png',4,'文具','23.00',0,0,14,'这是笔记本'),(33,'文件夹','http://www.florist.com/image/s10p003.png',4,'文具','7.00',0,0,7,'这是文件夹'),(34,'高级双面胶','http://www.florist.com/image/s10p004.png',4,'文具','5.50',0,0,8,'这是双面胶'),(35,'书夹','http://www.florist.com/image/s10p005.png',4,'文具','7.00',0,0,7,'这是书夹'),(36,'水彩笔','http://www.florist.com/image/s10p006.png',4,'文具','15.00',0,0,3,'这是水彩笔'),(37,'橡皮','http://www.florist.com/image/s10p007.png',4,'文具','3.00',0,0,33,'这是橡皮'),(38,'黑水笔','http://www.florist.com/image/s10p008.png',4,'文具','10.00',0,0,5,'这是黑水笔'),(39,'奶茶','http://www.florist.com/image/s11p001.png',2,'饮料','7.00',0,0,7,'这是奶茶'),(40,'农妇山泉','http://www.florist.com/image/s11p002.png',2,'饮料','22.00',0,0,7,'这是农夫山泉'),(41,'七个核桃','http://www.florist.com/image/s11p003.png',2,'饮料','67.00',0,0,43,'这是六个核桃'),(42,'高级橙汁','http://www.florist.com/image/s11p004.png',2,'饮料','34.00',0,0,3,'这是橙汁'),(43,'高级椰子汁','http://www.florist.com/image/s11p005.png',2,'饮料','54.00',0,0,5,'这是椰子汁'),(44,'加少宝凉茶','http://www.florist.com/image/s11p006.png',2,'饮料','37.00',0,0,2,'这是加多宝'),(45,'依云矿泉水','http://www.florist.com/image/s11p007.png',2,'饮料','110.00',0,0,9,'这是依云矿泉水'),(46,'波尔少红酒','http://www.florist.com/image/s11p008.png',2,'饮料','6667.00',0,0,8,'这是红酒'),(47,'红牛能量饮料','http://www.florist.com/image/s11p009.png',2,'饮料','90.00',0,0,0,'这是红牛能量饮料');

/*Table structure for table `product_sort` */

DROP TABLE IF EXISTS `product_sort`;

CREATE TABLE `product_sort` (
  `sort_id` int(10) NOT NULL AUTO_INCREMENT,
  `sort_name` varchar(50) NOT NULL,
  `sort_count` int(10) DEFAULT '0',
  `sort_heat` int(10) DEFAULT '0',
  `sort_sell_count` int(10) DEFAULT '0',
  PRIMARY KEY (`sort_id`),
  UNIQUE KEY `sort_name` (`sort_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `product_sort` */

insert  into `product_sort`(`sort_id`,`sort_name`,`sort_count`,`sort_heat`,`sort_sell_count`) values (1,'零食',11,0,0),(2,'饮料',1,0,0),(3,'生活用品',10,0,0),(4,'文具',8,0,0);

/*Table structure for table `user_address_info` */

DROP TABLE IF EXISTS `user_address_info`;

CREATE TABLE `user_address_info` (
  `address_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `user_real_name` varchar(50) NOT NULL,
  `user_phone` varchar(11) NOT NULL,
  `user_address` varchar(255) NOT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_address_info` */

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `user_level` int(1) DEFAULT '1',
  `history_order_count` int(10) DEFAULT '0',
  `user_real_name` varchar(50) NOT NULL,
  `user_phone` varchar(11) NOT NULL,
  `user_address` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `user_info` */

insert  into `user_info`(`user_id`,`user_name`,`user_password`,`user_level`,`history_order_count`,`user_real_name`,`user_phone`,`user_address`) values (1,'storekeeper','96e79218965eb72c92a549dd5a330112',0,0,'店长','00000000000','宿舍1楼小卖部'),(2,'g04r03b02','96e79218965eb72c92a549dd5a330112',1,0,'铁柱','11111111111','宿舍403的2号床'),(3,'dhl','e10adc3949ba59abbe56e057f20f883e',1,2,'戴海林','15651803360','南京市玄武区总统府校区达内'),(4,'admin','e10adc3949ba59abbe56e057f20f883e',1,0,'dhl','12345678910','nj'),(15,'ljy','96e79218965eb72c92a549dd5a330112',1,30,'111','15720606003','qqqqqq'),(16,'w','96e79218965eb72c92a549dd5a330112',1,0,'111111','15720606003','aaa'),(17,'www','96e79218965eb72c92a549dd5a330112',1,0,'??','15720606003','111'),(18,'xfx','202cb962ac59075b964b07152d234b70',1,0,'dai','11','dai'),(19,'ljy111','96e79218965eb72c92a549dd5a330112',1,0,'ljy','15720606003','aaa'),(20,'yvonne','202cb962ac59075b964b07152d234b70',1,2,'zzz','15852911858','111'),(21,'bruce','202cb962ac59075b964b07152d234b70',1,2,'赵文鸿','15751865763','南京'),(22,'yjj','e10adc3949ba59abbe56e057f20f883e',1,0,'杨家界','111111111','呜呜呜呜');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
