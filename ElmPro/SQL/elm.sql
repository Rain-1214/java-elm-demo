/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.36 : Database - db_elm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_elm` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_elm`;

/*Table structure for table `t_address` */

DROP TABLE IF EXISTS `t_address`;

CREATE TABLE `t_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `phoneNumber` varchar(11) DEFAULT NULL,
  `addressName` varchar(50) DEFAULT NULL,
  `addressDetail` varchar(40) DEFAULT NULL,
  `tag` varchar(10) DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `lng` double DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  CONSTRAINT `t_address_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `t_address` */

insert  into `t_address`(`id`,`userName`,`sex`,`phoneNumber`,`addressName`,`addressDetail`,`tag`,`lat`,`lng`,`userId`) values (15,'战鹰',1,'12345678989','上海市卢湾区阿三烤鸭店(复兴中路)','202','',31.220814,121.47167,2),(17,'战鹰',1,'13345678989','上海市卢湾区阿三烤鸭店(复兴中路)','202','学校',31.220814,121.47167,2),(19,'vxht99249',2,'13112345678','上海市徐汇区漕河泾万丽酒店','1602','公司',31.170956,121.40361,3),(21,'爱',1,'13131479856','上海市徐汇区新漕河泾国际商务中心','205','家',31.16982,121.410404,3),(23,'阿什顿发',2,'12345678989','上海市徐汇区漕河泾万丽酒店','1601','公司',31.170956,121.40361,2),(24,'锦桐',2,'13212345678','上海市徐汇区漕河泾开发区-地铁站','202','公司',31.17622,121.404164,3),(25,'锦桐',3,'13212345678','上海市徐汇区漕河泾开发区-地铁站','202','学校',31.17622,121.404164,3),(28,'战鹰',1,'13345678989','上海市卢湾区阿三烤鸭店(复兴中路)','202','公司',31.220814,121.47167,2),(29,'拉我',1,'13012345678','上海市闵行区漕河泾','205','公司',31.108386,121.511228,3);

/*Table structure for table `t_city` */

DROP TABLE IF EXISTS `t_city`;

CREATE TABLE `t_city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `hotCityId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_city` */

insert  into `t_city`(`id`,`name`,`hotCityId`) values (1,'上海',1),(2,'北京',1),(3,'杭州',1),(4,'徐州',1),(5,'深圳',1),(6,'广州',1),(7,'青岛',1),(8,'大连',1),(9,'无锡',1),(10,'包头',1);

/*Table structure for table `t_foodlist` */

DROP TABLE IF EXISTS `t_foodlist`;

CREATE TABLE `t_foodlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `foodName` varchar(20) DEFAULT NULL,
  `foodInfo` varchar(20) DEFAULT NULL,
  `foodPic` varchar(200) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `countMonth` int(11) DEFAULT NULL,
  `goodEvaluate` double DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `inventory` int(11) DEFAULT NULL,
  `foodTypeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `foodTypeId` (`foodTypeId`),
  CONSTRAINT `t_foodlist_ibfk_1` FOREIGN KEY (`foodTypeId`) REFERENCES `t_foodtypelist` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `t_foodlist` */

insert  into `t_foodlist`(`id`,`foodName`,`foodInfo`,`foodPic`,`price`,`countMonth`,`goodEvaluate`,`type`,`inventory`,`foodTypeId`) values (1,'水饺','好吃的水饺','https://fuss10.elemecdn.com/7/aa/d409b4aa4a9abbe42d4ce04c2d8d0jpeg.jpeg?imageMogr/format/webp/thumbnail/!140x140r/gravity/Center/crop/140x140/',3,58,0.98,1,-1,1),(2,'米饭','好吃的米饭','https://fuss10.elemecdn.com/7/aa/d409b4aa4a9abbe42d4ce04c2d8d0jpeg.jpeg?imageMogr/format/webp/thumbnail/!140x140r/gravity/Center/crop/140x140/',2.5,88,0.99,1,-1,2),(3,'米饭','好吃的米饭','https://fuss10.elemecdn.com/7/aa/d409b4aa4a9abbe42d4ce04c2d8d0jpeg.jpeg?imageMogr/format/webp/thumbnail/!140x140r/gravity/Center/crop/140x140/',10,98,0.99,1,-1,2),(4,'米饭','好吃的米饭','https://fuss10.elemecdn.com/7/aa/d409b4aa4a9abbe42d4ce04c2d8d0jpeg.jpeg?imageMogr/format/webp/thumbnail/!140x140r/gravity/Center/crop/140x140/',15,108,0.99,1,-1,2),(5,'米饭','好吃的米饭','https://fuss10.elemecdn.com/7/aa/d409b4aa4a9abbe42d4ce04c2d8d0jpeg.jpeg?imageMogr/format/webp/thumbnail/!140x140r/gravity/Center/crop/140x140/',11,111,0.99,1,-1,2),(6,'米饭','好吃的米饭','https://fuss10.elemecdn.com/7/aa/d409b4aa4a9abbe42d4ce04c2d8d0jpeg.jpeg?imageMogr/format/webp/thumbnail/!140x140r/gravity/Center/crop/140x140/',20,23,0.99,1,-1,2),(7,'米饭','好吃的米饭','https://fuss10.elemecdn.com/7/aa/d409b4aa4a9abbe42d4ce04c2d8d0jpeg.jpeg?imageMogr/format/webp/thumbnail/!140x140r/gravity/Center/crop/140x140/',15,222,0.99,1,-1,2),(8,'米饭','好吃的米饭','https://fuss10.elemecdn.com/7/aa/d409b4aa4a9abbe42d4ce04c2d8d0jpeg.jpeg?imageMogr/format/webp/thumbnail/!140x140r/gravity/Center/crop/140x140/',1.5,15,0.99,1,-1,2),(10,'米饭','好吃的米饭','https://fuss10.elemecdn.com/7/aa/d409b4aa4a9abbe42d4ce04c2d8d0jpeg.jpeg?imageMogr/format/webp/thumbnail/!140x140r/gravity/Center/crop/140x140/',0.22,145,0.99,1,-1,2),(11,'米饭','好吃的米饭','https://fuss10.elemecdn.com/7/aa/d409b4aa4a9abbe42d4ce04c2d8d0jpeg.jpeg?imageMogr/format/webp/thumbnail/!140x140r/gravity/Center/crop/140x140/',0.33,36,0.99,1,-1,2),(12,'米饭','好吃的米饭','https://fuss10.elemecdn.com/7/aa/d409b4aa4a9abbe42d4ce04c2d8d0jpeg.jpeg?imageMogr/format/webp/thumbnail/!140x140r/gravity/Center/crop/140x140/',0.99,22,0.99,1,-1,2),(13,'米饭','好吃的米饭','https://fuss10.elemecdn.com/7/aa/d409b4aa4a9abbe42d4ce04c2d8d0jpeg.jpeg?imageMogr/format/webp/thumbnail/!140x140r/gravity/Center/crop/140x140/',1.99,33,0.99,1,-1,2),(14,'米饭','好吃的米饭','https://fuss10.elemecdn.com/7/aa/d409b4aa4a9abbe42d4ce04c2d8d0jpeg.jpeg?imageMogr/format/webp/thumbnail/!140x140r/gravity/Center/crop/140x140/',11,44,0.99,1,-1,2),(15,'米饭','好吃的米饭','https://fuss10.elemecdn.com/7/aa/d409b4aa4a9abbe42d4ce04c2d8d0jpeg.jpeg?imageMogr/format/webp/thumbnail/!140x140r/gravity/Center/crop/140x140/',1.11,55,0.99,1,-1,2),(16,'米饭','好吃的米饭','https://fuss10.elemecdn.com/7/aa/d409b4aa4a9abbe42d4ce04c2d8d0jpeg.jpeg?imageMogr/format/webp/thumbnail/!140x140r/gravity/Center/crop/140x140/',11.11,66,0.99,1,-1,2),(17,'米饭','好吃的米饭','https://fuss10.elemecdn.com/7/aa/d409b4aa4a9abbe42d4ce04c2d8d0jpeg.jpeg?imageMogr/format/webp/thumbnail/!140x140r/gravity/Center/crop/140x140/',12.12,77,0.99,1,-1,2),(18,'米饭','好吃的米饭','https://fuss10.elemecdn.com/7/aa/d409b4aa4a9abbe42d4ce04c2d8d0jpeg.jpeg?imageMogr/format/webp/thumbnail/!140x140r/gravity/Center/crop/140x140/',13.13,88,0.99,1,-1,2);

/*Table structure for table `t_foodtype` */

DROP TABLE IF EXISTS `t_foodtype`;

CREATE TABLE `t_foodtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(20) DEFAULT NULL,
  `foodId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `foodId` (`foodId`),
  CONSTRAINT `t_foodtype_ibfk_1` FOREIGN KEY (`foodId`) REFERENCES `t_foodlist` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_foodtype` */

insert  into `t_foodtype`(`id`,`typeName`,`foodId`) values (1,'辣度',1),(2,'份量',1);

/*Table structure for table `t_foodtypedetail` */

DROP TABLE IF EXISTS `t_foodtypedetail`;

CREATE TABLE `t_foodtypedetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `foodTypeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `foodTypeId` (`foodTypeId`),
  CONSTRAINT `t_foodtypedetail_ibfk_1` FOREIGN KEY (`foodTypeId`) REFERENCES `t_foodtype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `t_foodtypedetail` */

insert  into `t_foodtypedetail`(`id`,`name`,`price`,`foodTypeId`) values (1,'不辣',0,1),(2,'中辣',0,1),(3,'变态辣',0,1),(4,'小份',0,2),(5,'中份',5,2),(6,'大份',10,2);

/*Table structure for table `t_foodtypelist` */

DROP TABLE IF EXISTS `t_foodtypelist`;

CREATE TABLE `t_foodtypelist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `listName` varchar(20) DEFAULT NULL,
  `description` varchar(20) DEFAULT NULL,
  `shopId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `shopId` (`shopId`),
  CONSTRAINT `t_foodtypelist_ibfk_1` FOREIGN KEY (`shopId`) REFERENCES `t_shop` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_foodtypelist` */

insert  into `t_foodtypelist`(`id`,`listName`,`description`,`shopId`) values (1,'早餐','好吃的早餐',1),(2,'晚餐','好吃的晚餐',1);

/*Table structure for table `t_hongbao` */

DROP TABLE IF EXISTS `t_hongbao`;

CREATE TABLE `t_hongbao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hongbaoName` varchar(30) DEFAULT NULL,
  `fillMoney` double DEFAULT NULL,
  `minusMoney` double DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `hongbaoState` int(11) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `phoneNumber` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  CONSTRAINT `t_hongbao_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_hongbao` */

insert  into `t_hongbao`(`id`,`hongbaoName`,`fillMoney`,`minusMoney`,`userId`,`hongbaoState`,`startTime`,`endTime`,`phoneNumber`) values (1,'超级会员专享',30,20,2,1,'2017-10-01 16:32:44','2017-10-31 16:32:47','13012345678'),(2,'一个大红包',20,19.99,2,1,'2017-10-01 17:57:21','2017-10-31 17:57:24',NULL),(3,'超级会员专享',30,20,3,1,'2017-10-01 18:09:57','2017-10-31 18:10:00','13012345678'),(4,'夜宵',30,29.99,3,1,'2017-10-01 18:10:30','2017-10-31 18:10:33',NULL);

/*Table structure for table `t_hongbaorules` */

DROP TABLE IF EXISTS `t_hongbaorules`;

CREATE TABLE `t_hongbaorules` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hongbaoId` int(11) DEFAULT NULL,
  `shopTypeId` int(11) DEFAULT NULL,
  `shopTypeName` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `hongbaoId` (`hongbaoId`),
  KEY `shopTypeId` (`shopTypeId`),
  CONSTRAINT `t_hongbaorules_ibfk_1` FOREIGN KEY (`hongbaoId`) REFERENCES `t_hongbao` (`id`),
  CONSTRAINT `t_hongbaorules_ibfk_2` FOREIGN KEY (`shopTypeId`) REFERENCES `t_shoptype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_hongbaorules` */

insert  into `t_hongbaorules`(`id`,`hongbaoId`,`shopTypeId`,`shopTypeName`) values (2,1,1,'美食'),(3,1,8,'帮买帮送'),(4,1,4,'预定早餐');

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shopId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `addressId` int(11) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `payMethod` varchar(10) DEFAULT NULL,
  `deliveryMethod` varchar(10) DEFAULT NULL,
  `arrivedTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_order` */

/*Table structure for table `t_orderproduct` */

DROP TABLE IF EXISTS `t_orderproduct`;

CREATE TABLE `t_orderproduct` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `orderId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orderId` (`orderId`),
  CONSTRAINT `t_orderproduct_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `t_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_orderproduct` */

/*Table structure for table `t_shop` */

DROP TABLE IF EXISTS `t_shop`;

CREATE TABLE `t_shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shopName` varchar(30) DEFAULT NULL,
  `shopLogo` varchar(200) DEFAULT NULL,
  `shopNptice` varchar(30) DEFAULT NULL,
  `isBrand` int(11) DEFAULT NULL,
  `serveEvaluate` double DEFAULT NULL,
  `foodEvaluate` double DEFAULT NULL,
  `countOrder` int(11) DEFAULT NULL,
  `deliveryCost` double DEFAULT NULL,
  `startCost` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `averageUserCost` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_shop` */

insert  into `t_shop`(`id`,`shopName`,`shopLogo`,`shopNptice`,`isBrand`,`serveEvaluate`,`foodEvaluate`,`countOrder`,`deliveryCost`,`startCost`,`latitude`,`longitude`,`averageUserCost`) values (1,'乐凯撒比萨（正大广场店）','//fuss10.elemecdn.com/8/bb/dee0380909002eb1a646aa5f9de0cjpeg.jpeg?imageMogr/format/webp/thumbnail/!130x130r/gravity/Center/crop/130x130/','欢迎光临，用餐高峰期请提前下单，谢谢。',1,4.6,4.8,201,5,20,31.240448,121.49717,30);

/*Table structure for table `t_shopfullminus` */

DROP TABLE IF EXISTS `t_shopfullminus`;

CREATE TABLE `t_shopfullminus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `full` double DEFAULT NULL,
  `minus` double DEFAULT NULL,
  `shopId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `shopId` (`shopId`),
  CONSTRAINT `t_shopfullminus_ibfk_1` FOREIGN KEY (`shopId`) REFERENCES `t_shop` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_shopfullminus` */

insert  into `t_shopfullminus`(`id`,`full`,`minus`,`shopId`) values (1,30,20,1),(2,50,25,1),(3,70,30,1);

/*Table structure for table `t_shopproperty` */

DROP TABLE IF EXISTS `t_shopproperty`;

CREATE TABLE `t_shopproperty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `newUserFavorable` int(11) DEFAULT NULL,
  `safeguard` int(11) DEFAULT NULL,
  `invoice` int(11) DEFAULT NULL,
  `hummingbird` int(11) DEFAULT NULL,
  `shopId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `shopId` (`shopId`),
  CONSTRAINT `t_shopproperty_ibfk_1` FOREIGN KEY (`shopId`) REFERENCES `t_shop` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_shopproperty` */

insert  into `t_shopproperty`(`id`,`newUserFavorable`,`safeguard`,`invoice`,`hummingbird`,`shopId`) values (1,1,1,1,1,1);

/*Table structure for table `t_shopproperty_types` */

DROP TABLE IF EXISTS `t_shopproperty_types`;

CREATE TABLE `t_shopproperty_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shoptypeId` int(11) DEFAULT NULL,
  `shoptypeName` varchar(20) DEFAULT NULL,
  `shopId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `shopId` (`shopId`),
  CONSTRAINT `t_shopproperty_types_ibfk_1` FOREIGN KEY (`shopId`) REFERENCES `t_shop` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_shopproperty_types` */

insert  into `t_shopproperty_types`(`id`,`shoptypeId`,`shoptypeName`,`shopId`) values (1,1,'帮买',1),(2,4,'预定早餐',1);

/*Table structure for table `t_shoptype` */

DROP TABLE IF EXISTS `t_shoptype`;

CREATE TABLE `t_shoptype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeLogo` varchar(200) DEFAULT NULL,
  `typeName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `t_shoptype` */

insert  into `t_shoptype`(`id`,`typeLogo`,`typeName`) values (1,'//fuss10.elemecdn.com/b/7e/d1890cf73ae6f2adb97caa39de7fcjpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/','美食'),(2,'//fuss10.elemecdn.com/2/35/696aa5cf9820adada9b11a3d14bf5jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/','甜品饮品'),(3,'//fuss10.elemecdn.com/c/3c/0184f5b3fa72f295fc01864734218jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/','商超便利'),(4,'//fuss10.elemecdn.com/3/2a/e6505427e44c58e79d2c6d57912c1jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/','预定早餐'),(5,'//fuss10.elemecdn.com/c/db/d20d49e5029281b9b73db1c5ec6f9jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/','果蔬生鲜'),(6,'//fuss10.elemecdn.com/a/fa/d41b04d520d445dc5de42dae9a384jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/','新店特惠'),(7,'//fuss10.elemecdn.com/e/7e/02b72b5e63c127d5bfae57b8e4ab1jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/','大牌必吃'),(8,'//fuss10.elemecdn.com/1/c1/dfade1a31f312f161074c3dd6a89cjpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/','帮买帮送'),(9,'//fuss10.elemecdn.com/d/38/7bddb07503aea4b711236348e2632jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/','午餐'),(10,'//fuss10.elemecdn.com/3/01/c888acb2c8ba9e0c813f36ec9e90ajpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/','浪漫鲜花'),(11,'//fuss10.elemecdn.com/b/e1/58aa34ef194d216c9f2328f603588jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/','医药健康'),(12,'//fuss10.elemecdn.com/b/7f/432619fb21a40b05cd25d11eca02djpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/','汉堡香烟'),(13,'//fuss10.elemecdn.com/2/17/244241b514affc0f12f4168cf6628jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/','包子粥店'),(14,'//fuss10.elemecdn.com/a/8a/ec21096d528b7cfd23cdd894f01c6jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/','地方菜系'),(15,'//fuss10.elemecdn.com/7/b6/235761e50d391445f021922b71789jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/','披萨意面'),(16,'//fuss10.elemecdn.com/3/c7/a9ef469a12e7a596b559145b87f09jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/','麻辣烫');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL,
  `phoneNumber` varchar(11) DEFAULT NULL,
  `userImg` varchar(200) DEFAULT NULL,
  `activityPoints` int(11) DEFAULT NULL,
  `safetyQuestion` varchar(30) DEFAULT NULL,
  `safetyAnswer` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`userName`,`password`,`phoneNumber`,`userImg`,`activityPoints`,`safetyQuestion`,`safetyAnswer`) values (1,'admin','12345','12345678978','',2000,NULL,NULL),(2,'aaaaa','123456','13012345678','//fuss10.elemecdn.com/a/d3/9956008d1e7000c9470032467adaapng.png?imageMogr/format/webp/thumbnail/!130x130r/gravity/Center/crop/130x130/',0,'aaaaa','aaaaa'),(3,'a123','123456','','https://fuss10.elemecdn.com/3/91/d09a9b9623e643dd400f41871c416jpeg.jpeg?',0,'bbbb','bbbb'),(4,'123','123456','','',0,'aaaa','aaaa'),(5,'1234','123456','','',0,'aaaa','aaaa');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
