/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.10 : Database - slsaledb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`slsaledb` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `slsaledb`;

/*Table structure for table `affiche` */

DROP TABLE IF EXISTS `affiche`;

CREATE TABLE `affiche` (
  `id` bigint(60) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '编码',
  `title` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '标题',
  `content` text COLLATE utf8_unicode_ci COMMENT '内容',
  `publisher` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '发布人',
  `publishTime` datetime DEFAULT NULL COMMENT '发布时间',
  `startTime` datetime DEFAULT NULL COMMENT '生效时间',
  `endTime` datetime DEFAULT NULL COMMENT '失效时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `affiche` */

insert  into `affiche`(`id`,`code`,`title`,`content`,`publisher`,`publishTime`,`startTime`,`endTime`) values (34,'公告1','公告1','<font face=\"Arial, Verdana\" size=\"2\">公告<b><i>1公告1公告1公告1</i></b>公告1公告<span style=\"background-color: rgb(204, 0, 0);\">1公告1公告1</span>公告1公告1公告1公告1公告1公告1</font>','admin','2014-04-10 14:56:24','2014-04-10 00:00:00','2014-04-19 00:00:00'),(35,'公告2','公告2','<font face=\"Arial, Verdana\" size=\"2\">公告2公告2公告2公告2公告2公告2公告2公告2公告2公告2</font>','admin','2014-04-10 14:52:33','2014-04-09 00:00:00','2014-04-18 00:00:00'),(36,'公告3','公告3','<font face=\"Arial, Verdana\" size=\"2\">公告3公告3公告3公告3公告3公告3公告3</font>','admin','2014-04-10 14:52:54','2014-04-07 00:00:00','2014-04-18 00:00:00'),(37,'公告3','公告4','<font face=\"Arial, Verdana\" size=\"2\">公告4公告4公告4公告4公告4公告4公告4公告4公告4</font>','admin','2014-04-10 14:55:08','2014-04-09 00:00:00','2014-04-12 00:00:00'),(38,'公告5','公告5','<font face=\"Arial, Verdana\" size=\"2\">公告5公告5公告5公告5公告5公告5公告5</font>','admin','2014-04-17 14:03:03','2014-04-09 00:00:00','2014-04-19 00:00:00');

/*Table structure for table `au_authority` */

DROP TABLE IF EXISTS `au_authority`;

CREATE TABLE `au_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `roleId` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `functionId` bigint(20) DEFAULT NULL COMMENT '功能ID',
  `userTypeId` bigint(20) DEFAULT NULL COMMENT '用户类型ID',
  `creationTime` datetime DEFAULT NULL COMMENT '创建时间',
  `createdBy` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建者',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1721 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `au_authority` */

insert  into `au_authority`(`id`,`roleId`,`functionId`,`userTypeId`,`creationTime`,`createdBy`) values (1534,1,87,0,'2014-04-04 18:11:47','admin'),(1533,1,86,0,'2014-04-04 18:11:47','admin'),(1532,1,85,0,'2014-04-04 18:11:47','admin'),(1531,1,84,0,'2014-04-04 18:11:47','admin'),(1530,1,83,0,'2014-04-04 18:11:47','admin'),(1529,1,82,0,'2014-04-04 18:11:47','admin'),(1528,1,81,0,'2014-04-04 18:11:47','admin'),(1527,1,80,0,'2014-04-04 18:11:47','admin'),(1526,1,79,0,'2014-04-04 18:11:47','admin'),(1685,2,92,0,'2014-04-09 15:35:01','admin'),(1525,1,78,0,'2014-04-04 18:11:47','admin'),(1635,25,37,0,'2014-04-09 10:36:43','admin'),(1634,25,16,0,'2014-04-09 10:36:43','admin'),(1633,25,15,0,'2014-04-09 10:36:43','admin'),(1632,25,14,0,'2014-04-09 10:36:42','admin'),(1631,25,13,0,'2014-04-09 10:36:42','admin'),(1630,25,2,0,'2014-04-09 10:36:42','admin'),(1524,1,77,0,'2014-04-04 18:11:47','admin'),(1523,1,76,0,'2014-04-04 18:11:47','admin'),(1522,1,75,0,'2014-04-04 18:11:47','admin'),(1521,1,74,0,'2014-04-04 18:11:47','admin'),(1520,1,73,0,'2014-04-04 18:11:47','admin'),(1519,1,72,0,'2014-04-04 18:11:47','admin'),(1518,1,71,0,'2014-04-04 18:11:47','admin'),(1517,1,70,0,'2014-04-04 18:11:47','admin'),(1516,1,69,0,'2014-04-04 18:11:47','admin'),(1515,1,68,0,'2014-04-04 18:11:47','admin'),(1514,1,67,0,'2014-04-04 18:11:47','admin'),(1684,2,91,0,'2014-04-09 15:35:01','admin'),(1683,2,76,0,'2014-04-09 15:35:01','admin'),(1682,2,75,0,'2014-04-09 15:35:01','admin'),(1681,2,74,0,'2014-04-09 15:35:01','admin'),(1680,2,73,0,'2014-04-09 15:35:01','admin'),(1679,2,72,0,'2014-04-09 15:35:01','admin'),(1539,1,92,0,'2014-04-04 18:11:47','admin'),(1538,1,91,0,'2014-04-04 18:11:47','admin'),(1537,1,90,0,'2014-04-04 18:11:47','admin'),(1536,1,89,0,'2014-04-04 18:11:47','admin'),(1535,1,88,0,'2014-04-04 18:11:47','admin'),(1650,25,72,0,'2014-04-09 10:36:43','admin'),(1651,25,73,0,'2014-04-09 10:36:43','admin'),(1652,25,74,0,'2014-04-09 10:36:43','admin'),(1653,25,75,0,'2014-04-09 10:36:43','admin'),(1654,25,76,0,'2014-04-09 10:36:43','admin'),(1655,1,93,0,'2014-04-04 18:11:46','admin'),(1643,25,65,0,'2014-04-09 10:36:43','admin'),(1644,25,66,0,'2014-04-09 10:36:43','admin'),(1645,25,67,0,'2014-04-09 10:36:43','admin'),(1646,25,68,0,'2014-04-09 10:36:43','admin'),(1647,25,69,0,'2014-04-09 10:36:43','admin'),(1648,25,70,0,'2014-04-09 10:36:43','admin'),(1649,25,71,0,'2014-04-09 10:36:43','admin'),(1513,1,66,0,'2014-04-04 18:11:47','admin'),(1512,1,65,0,'2014-04-04 18:11:47','admin'),(1511,1,64,0,'2014-04-04 18:11:47','admin'),(1510,1,63,0,'2014-04-04 18:11:47','admin'),(1509,1,62,0,'2014-04-04 18:11:47','admin'),(1508,1,61,0,'2014-04-04 18:11:47','admin'),(1507,1,60,0,'2014-04-04 18:11:47','admin'),(1506,1,59,0,'2014-04-04 18:11:47','admin'),(1505,1,58,0,'2014-04-04 18:11:47','admin'),(1504,1,57,0,'2014-04-04 18:11:47','admin'),(1503,1,56,0,'2014-04-04 18:11:47','admin'),(1502,1,55,0,'2014-04-04 18:11:47','admin'),(1501,1,54,0,'2014-04-04 18:11:47','admin'),(1500,1,53,0,'2014-04-04 18:11:47','admin'),(1499,1,52,0,'2014-04-04 18:11:47','admin'),(1498,1,51,0,'2014-04-04 18:11:47','admin'),(1497,1,50,0,'2014-04-04 18:11:47','admin'),(1496,1,49,0,'2014-04-04 18:11:47','admin'),(1495,1,48,0,'2014-04-04 18:11:47','admin'),(1494,1,47,0,'2014-04-04 18:11:47','admin'),(1493,1,46,0,'2014-04-04 18:11:47','admin'),(1492,1,45,0,'2014-04-04 18:11:47','admin'),(1491,1,44,0,'2014-04-04 18:11:47','admin'),(1490,1,43,0,'2014-04-04 18:11:47','admin'),(1489,1,42,0,'2014-04-04 18:11:47','admin'),(1488,1,41,0,'2014-04-04 18:11:47','admin'),(1487,1,40,0,'2014-04-04 18:11:47','admin'),(1486,1,39,0,'2014-04-04 18:11:47','admin'),(1485,1,38,0,'2014-04-04 18:11:47','admin'),(1484,1,37,0,'2014-04-04 18:11:47','admin'),(1483,1,36,0,'2014-04-04 18:11:46','admin'),(1482,1,35,0,'2014-04-04 18:11:46','admin'),(1481,1,34,0,'2014-04-04 18:11:46','admin'),(1480,1,33,0,'2014-04-04 18:11:46','admin'),(1479,1,32,0,'2014-04-04 18:11:46','admin'),(1478,1,31,0,'2014-04-04 18:11:46','admin'),(1477,1,30,0,'2014-04-04 18:11:46','admin'),(1476,1,29,0,'2014-04-04 18:11:46','admin'),(1475,1,28,0,'2014-04-04 18:11:46','admin'),(1474,1,27,0,'2014-04-04 18:11:46','admin'),(1473,1,26,0,'2014-04-04 18:11:46','admin'),(1472,1,25,0,'2014-04-04 18:11:46','admin'),(1471,1,24,0,'2014-04-04 18:11:46','admin'),(1470,1,23,0,'2014-04-04 18:11:46','admin'),(1469,1,22,0,'2014-04-04 18:11:46','admin'),(1468,1,21,0,'2014-04-04 18:11:46','admin'),(1467,1,20,0,'2014-04-04 18:11:46','admin'),(1466,1,19,0,'2014-04-04 18:11:46','admin'),(1465,1,18,0,'2014-04-04 18:11:46','admin'),(1464,1,17,0,'2014-04-04 18:11:46','admin'),(1463,1,16,0,'2014-04-04 18:11:46','admin'),(1462,1,15,0,'2014-04-04 18:11:46','admin'),(1461,1,14,0,'2014-04-04 18:11:46','admin'),(1460,1,13,0,'2014-04-04 18:11:46','admin'),(1459,1,12,0,'2014-04-04 18:11:46','admin'),(1458,1,11,0,'2014-04-04 18:11:46','admin'),(1457,1,10,0,'2014-04-04 18:11:46','admin'),(1456,1,9,0,'2014-04-04 18:11:46','admin'),(1455,1,8,0,'2014-04-04 18:11:46','admin'),(1454,1,7,0,'2014-04-04 18:11:46','admin'),(1453,1,6,0,'2014-04-04 18:11:46','admin'),(1452,1,5,0,'2014-04-04 18:11:46','admin'),(1451,1,4,0,'2014-04-04 18:11:46','admin'),(1450,1,3,0,'2014-04-04 18:11:46','admin'),(1449,1,2,0,'2014-04-04 18:11:46','admin'),(1448,1,1,0,'2014-04-04 18:11:46','admin'),(1678,2,71,0,'2014-04-09 15:35:01','admin'),(1677,2,70,0,'2014-04-09 15:35:01','admin'),(1676,2,69,0,'2014-04-09 15:35:01','admin'),(1675,2,68,0,'2014-04-09 15:35:01','admin'),(1674,2,67,0,'2014-04-09 15:35:01','admin'),(1673,2,66,0,'2014-04-09 15:35:01','admin'),(1672,2,65,0,'2014-04-09 15:35:01','admin'),(1671,2,64,0,'2014-04-09 15:35:01','admin'),(1670,2,63,0,'2014-04-09 15:35:01','admin'),(1669,2,62,0,'2014-04-09 15:35:01','admin'),(1668,2,41,0,'2014-04-09 15:35:01','admin'),(1667,2,40,0,'2014-04-09 15:35:01','admin'),(1666,2,39,0,'2014-04-09 15:35:01','admin'),(1665,2,38,0,'2014-04-09 15:35:01','admin'),(1664,2,37,0,'2014-04-09 15:35:01','admin'),(1663,2,21,0,'2014-04-09 15:35:01','admin'),(1662,2,19,0,'2014-04-09 15:35:01','admin'),(1686,2,93,0,'2014-04-09 15:35:01','admin'),(1642,25,64,0,'2014-04-09 10:36:43','admin'),(1641,25,63,0,'2014-04-09 10:36:43','admin'),(1636,25,38,0,'2014-04-09 10:36:43','admin'),(1637,25,39,0,'2014-04-09 10:36:43','admin'),(1638,25,40,0,'2014-04-09 10:36:43','admin'),(1639,25,41,0,'2014-04-09 10:36:43','admin'),(1640,25,62,0,'2014-04-09 10:36:43','admin'),(1661,2,16,0,'2014-04-09 15:35:01','admin'),(1660,2,15,0,'2014-04-09 15:35:01','admin'),(1659,2,14,0,'2014-04-09 15:35:01','admin'),(1658,2,13,0,'2014-04-09 15:35:01','admin'),(1657,2,6,0,'2014-04-09 15:35:01','admin'),(1656,2,2,0,'2014-04-09 15:35:01','admin'),(1687,26,6,0,'2014-04-10 10:39:30','admin'),(1688,26,17,0,'2014-04-10 10:39:30','admin'),(1689,26,18,0,'2014-04-10 10:39:30','admin'),(1690,26,37,0,'2014-04-10 10:39:30','admin'),(1691,26,38,0,'2014-04-10 10:39:30','admin'),(1692,26,39,0,'2014-04-10 10:39:30','admin'),(1693,26,40,0,'2014-04-10 10:39:30','admin'),(1694,26,41,0,'2014-04-10 10:39:30','admin'),(1695,26,77,0,'2014-04-10 10:39:30','admin'),(1696,26,78,0,'2014-04-10 10:39:30','admin'),(1697,26,79,0,'2014-04-10 10:39:30','admin'),(1698,26,80,0,'2014-04-10 10:39:30','admin'),(1699,26,81,0,'2014-04-10 10:39:30','admin'),(1700,26,82,0,'2014-04-10 10:39:30','admin'),(1701,26,83,0,'2014-04-10 10:39:30','admin'),(1702,26,84,0,'2014-04-10 10:39:30','admin'),(1703,26,85,0,'2014-04-10 10:39:30','admin'),(1704,26,86,0,'2014-04-10 10:39:30','admin'),(1705,26,87,0,'2014-04-10 10:39:30','admin'),(1706,1,94,0,'2014-04-15 11:05:10','admin'),(1707,1,95,0,'2014-04-17 16:08:34','admin'),(1708,1,96,0,'2014-04-22 19:15:51','admin'),(1709,1,97,0,'2014-04-23 19:01:21','admin'),(1710,1,98,0,'2014-04-24 19:15:43','admin'),(1711,1,99,0,'2014-04-25 09:55:18','admin'),(1712,1,100,0,'2014-05-05 18:11:53','admin'),(1713,1,949,0,'2014-05-09 17:32:48','admin'),(1714,1,950,0,'2014-05-16 16:17:44','admin'),(1715,1,951,0,'2014-05-29 09:30:16','admin'),(1716,1,952,0,'2014-05-29 09:30:16','admin'),(1717,1,953,0,'2014-05-29 12:49:08','admin'),(1718,1,954,0,'2014-05-30 14:35:43','admin'),(1719,1,955,0,'2014-05-30 14:35:43','admin'),(1720,1,957,0,'2014-05-30 14:35:43','admin');

/*Table structure for table `au_function` */

DROP TABLE IF EXISTS `au_function`;

CREATE TABLE `au_function` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `functionCode` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '功能编码',
  `functionName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '功能名称',
  `funcUrl` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '功能URL',
  `parentId` bigint(20) DEFAULT NULL,
  `creationTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=958 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `au_function` */

insert  into `au_function`(`id`,`functionCode`,`functionName`,`funcUrl`,`parentId`,`creationTime`) values (1,'backendmanage','后台管理',NULL,0,NULL),(2,'membermanage','会员管理',NULL,0,'2014-04-04 15:03:24'),(3,'ebank','电子银行',NULL,0,'2014-04-04 15:03:24'),(4,'shoppingmanage','购物管理',NULL,0,'2014-04-04 15:03:24'),(5,'infosearch','信息查询',NULL,0,'2014-04-04 15:03:24'),(6,'informanage','信息管理','',0,'2014-04-04 15:03:24'),(7,'userlist','用户管理','/backend/userlist.html',1,'2014-04-04 15:03:24'),(8,'rolelist','角色管理','/backend/rolelist.html',1,'2014-04-04 15:03:24'),(9,'authoritymanage','权限管理','/backend/authoritymanage.html',1,'2014-04-04 15:03:24'),(10,'goodsinfolist','商品管理','/backend/goodsinfolist.html',1,'2014-04-04 15:03:24'),(11,'goodspacklist','商品套餐管理','/backend/goodspacklist.html',1,'2014-04-04 15:03:24'),(12,'datadictionary','数据字典','/backend/dicmanage.html',1,'2014-04-04 15:03:24'),(13,'registmember','注册新会员','/member/registmember.html',2,'2014-04-04 15:03:24'),(14,'memberlist','新会员管理','/member/memberlist.html',2,'2014-04-04 15:03:24'),(15,'modifypersonalinfo','修改本人资料','/member/modifypersonalinfo.html',2,'2014-04-04 15:03:24'),(16,'modifypersonalpwd','修改本人密码','/member/modifypersonalpwd.html',2,'2014-04-04 15:03:24'),(17,'affiche','公告管理','/informanage/affiche.html',6,'2014-04-04 15:03:24'),(18,'information','资讯管理','/informanage/information.html',6,'2014-04-04 15:03:24'),(19,'download','下载中心','/informanage/downloadcenter.html',6,'2014-04-04 15:03:24'),(20,'messagelist','留言管理','/message/messagelist.html',6,'2014-04-04 15:03:24'),(21,'mymessage','我的留言','/message/mymessage.html',6,'2014-04-04 15:03:24'),(22,'getgoodsinfo','查看商品信息','/backend/getgoodsinfo.html',10,'2014-04-04 15:03:24'),(23,'modifystate','修改商品上架状态','/backend/modifystate.html',10,'2014-04-04 15:05:48'),(24,'goodsSNisexit','商品编号重复判断','/backend/goodsSNisexit.html',10,'2014-04-04 15:05:48'),(25,'modifygoodsinfo','修改商品信息','/backend/modifygoodsinfo.html',10,'2014-04-04 15:05:48'),(26,'delgoodsinfo','删除商品','/backend/delgoodsinfo.html',10,'2014-04-04 15:05:48'),(27,'addgoodsinfo','添加商品','/backend/addgoodsinfo.html',10,'2014-04-04 15:05:48'),(28,'modifygoodspackstate','修改商务套餐上下架状态','/backend/modifygoodspackstate.html',11,'2014-04-04 15:10:20'),(29,'viewgoodspack','查看商务套餐信息','/backend/viewgoodspack.html',11,'2014-04-04 15:10:20'),(30,'addgoodspack','添加商务套餐','/backend/addgoodspack.html',11,'2014-04-04 15:10:20'),(31,'modifygoodspack','修改商务套餐','/backend/modifygoodspack.html',11,'2014-04-04 15:10:20'),(32,'saveaddgoodspack','保存添加的商品套餐','/backend/saveaddgoodspack.html',11,'2014-04-04 15:10:20'),(33,'savemodifygoodspack','修改商务套餐信息','/backend/savemodifygoodspack.html',11,'2014-04-04 15:10:20'),(34,'goodspackcodeisexit','商务套餐code重复判断','/backend/goodspackcodeisexit.html',11,'2014-04-04 15:10:20'),(35,'delgoodspack','删除商务套餐','/backend/delgoodspack.html',11,'2014-04-04 15:10:20'),(36,'goodslist','商务套餐中的商品列表','/backend/goodslist.html',11,'2014-04-04 15:10:20'),(37,'portalafficheList','后台首页公告列表页面','/informanage/portalafficheList.html',999,'2014-04-04 15:13:09'),(38,'portalAfficheDetail','后台首页公告列表点击进入详情页面','/informanage/portalAfficheDetail.html',999,'2014-04-04 15:13:09'),(39,'portalinfoList','后台首页资讯列表页面','/informanage/portalinfoList.html',999,'2014-04-04 15:13:09'),(40,'portalInfoDetail','后台首页资讯列表点击进入详情页面','/informanage/portalInfoDetail.html',999,'2014-04-04 15:13:09'),(41,'modifyPwd','首页head修改密码','/backend/modifyPwd.html',999,'2014-04-04 15:13:09'),(42,'adduser','添加用户','/backend/adduser.html',7,'2014-04-04 15:27:09'),(43,'getuser','获取用户','/backend/getuser.html',7,'2014-04-04 15:27:09'),(44,'loadUserTypeList','获取用户类型列表','/backend/loadUserTypeList.html',7,'2014-04-04 15:27:09'),(45,'upload','上传图片Url','/backend/upload.html',7,'2014-04-04 15:27:09'),(46,'delpic','删除上传后的图片的URL','/backend/delpic.html',7,'2014-04-04 15:27:09'),(47,'modifyuser','修改用户信息','/backend/modifyuser.html',7,'2014-04-04 15:27:09'),(48,'modifyRole','修改角色是否启用和修改角色信息','/backend/modifyRole.html',8,'2014-04-04 15:27:09'),(49,'addRole','增加角色','/backend/addRole.html',8,'2014-04-04 15:27:09'),(50,'delRole','删除角色','/backend/delRole.html',8,'2014-04-04 15:27:09'),(51,'functions','获取所有权限','/backend/functions.html',9,'2014-04-04 15:27:09'),(52,'getAuthorityDefault','获取权限回显','/backend/getAuthorityDefault.html',9,'2014-04-04 15:27:09'),(53,'modifyAuthority','修改权限','/backend/modifyAuthority.html',9,'2014-04-04 15:27:09'),(54,'addDic','添加数据字典','/backend/addDic.html',12,'2014-04-04 15:27:09'),(55,'addDicSub','添加数据字典枚举数据','/backend/addDicSub.html',12,'2014-04-04 15:27:09'),(56,'modifylDic','修改数据字典数据','/backend/modifylDic.html',12,'2014-04-04 15:27:09'),(57,'modifyDic','修改数据字典枚举数据','/backend/modifyDic.html',12,'2014-04-04 15:27:09'),(58,'delMainDic','删除数据字典','/backend/delMainDic.html',12,'2014-04-04 15:27:09'),(59,'delDic','删除数据字典枚举数据','/backend/delDic.html',12,'2014-04-04 15:27:09'),(60,'typecodeisexit','类型代码不能重复验证','/backend/typecodeisexit.html',12,'2014-04-04 15:27:09'),(61,'getJsonDic','获取数据字典枚举数据JSON','/backend/getJsonDic.html',12,'2014-04-04 15:27:09'),(62,'registmember','注册新会员下一步','/member/registmember.html',13,'2014-04-04 15:27:09'),(63,'saveregistmember','提交注册新会员','/member/saveregistmember.html',13,'2014-04-04 15:27:09'),(64,'upload','上传图片Url','/backend/upload.html',13,'2014-04-04 15:27:09'),(65,'delpic','删除上传后的图片的URL','/backend/delpic.html',13,'2014-04-04 15:27:09'),(66,'logincodeisexit','判断登录Code是否重复','/backend/logincodeisexit.html',13,'2014-04-04 15:27:09'),(67,'registok','注册成功信息回显','/member/registok.html',13,'2014-04-04 15:27:09'),(68,'getuser','获取用户','/backend/getuser.html',14,'2014-04-04 15:39:25'),(69,'logincodeisexit','判断登录Code是否重复','/backend/logincodeisexit.html',14,'2014-04-04 15:39:25'),(70,'modifymember','修改新会员信息','/member/modifymember.html',14,'2014-04-04 15:39:25'),(71,'deluser','删除新会员','/backend/deluser.html',14,'2014-04-04 15:39:25'),(72,'upload','上传图片Url','/backend/upload.html',15,'2014-04-04 15:39:25'),(73,'delpic','删除上传后的图片的URL','/backend/delpic.html',15,'2014-04-04 15:39:25'),(74,'savepersonalinfo','执行修改本人资料','/member/savepersonalinfo.html',15,'2014-04-04 15:39:25'),(75,'modifyPwd','执行修改本人密码','/backend/modifyPwd.html',16,'2014-04-04 15:39:25'),(76,'savesecondpwd','执行修改本人二级密码','/member/savesecondpwd.html',16,'2014-04-04 15:39:25'),(77,'addAffiche','添加公告','/informanage/addAffiche.html',17,'2014-04-04 15:39:25'),(78,'viewAffiche','查看公告','/informanage/viewAffiche.html',17,'2014-04-04 15:39:25'),(79,'modifyAffiche','修改公告','/informanage/modifyAffiche.html',17,'2014-04-04 15:39:25'),(80,'delAffiche','删除公告','/informanage/delAffiche.html',17,'2014-04-04 15:39:25'),(81,'modifyInfoState','修改发布状态','/informanage/modifyInfoState.html',18,'2014-04-04 15:39:25'),(82,'viewInfo','查看资讯信息','/informanage/viewInfo.html',18,'2014-04-04 15:39:25'),(83,'modifyinformation','修改资讯信息','/informanage/modifyinformation.html',18,'2014-04-04 15:39:25'),(84,'upload','上传资讯文件','/informanage/upload.html',18,'2014-04-04 15:39:25'),(85,'delInfoFile','删除资讯的文件','/informanage/delInfoFile.html',18,'2014-04-04 15:39:25'),(86,'delInfo','删除资讯','/informanage/delInfo.html',18,'2014-04-04 15:39:25'),(87,'addInformation','添加资讯信息','/informanage/addInformation.html',18,'2014-04-04 15:39:25'),(88,'getmessage','查看留言','/message/getmessage.html',20,'2014-04-04 15:39:25'),(89,'replymessage','回复留言','/message/replymessage.html',20,'2014-04-04 15:39:25'),(90,'delmessage','删除留言','/backend/delmessage.html',20,'2014-04-04 15:39:25'),(91,'addmessage','添加留言','/message/addmessage.html',21,'2014-04-04 15:39:25'),(92,'reply','显示回复列表','/message/reply.html',21,'2014-04-04 15:39:25'),(93,'registrule','查看注册条款','/member/registrule.html',13,'2014-04-04 15:27:09'),(95,'baseAccountLogList','基本账户','/bank/base_account/list.html',3,'2014-04-14 16:46:24'),(94,'gotoRecharge','汇款充值','/bank/recharge/gotoRecharge.html',3,'2014-04-14 16:07:42'),(96,'repeatedAccountLogList','重销账户','/bank/repeated_account/list.html',3,'2014-04-22 19:15:07'),(97,'doInternalTransfer','内部转账','/bank/transfer_accounts/transfer.html',3,'2014-04-23 18:59:07'),(98,'applyCash','申请提现','/bank/apply_cash/apply.html',3,'2014-04-24 19:14:47'),(99,'applyList','提现明细','/bank/apply_cash/list.html',3,'2014-04-25 09:54:24'),(100,'declarativePurchase','报单购货','/shopping/declarative/prompt.html',4,'2014-05-05 18:10:56'),(949,'getOrderInfoList','确认激活','/shopping/activate/list.html',4,'2014-05-09 17:32:14'),(950,'operatingInstruction','操作须知','/search/operating_instructions.html',5,'2014-05-16 16:17:09'),(951,'goodsPackListByRepeated','重消购货','/shopping/repeated/list.html',4,'2014-05-29 09:27:49'),(952,'goodsPackListByFX','辅消购货','/shopping/fx/list.html',4,'2014-05-29 09:27:49'),(953,'orderInfoList','订单管理','/shopping/management/list.html',4,'2014-05-29 12:48:46'),(954,'recommendSearch','推荐查询','/search/recommend_search.html',5,'2014-05-30 14:33:40'),(955,'placeSearch','区域查询','/shopping/activate/gotoActivate.html',5,'2014-05-30 14:33:40'),(957,'bonusSearch','奖励查询','/search/bonus_search.html',5,'2014-05-30 14:34:53');

/*Table structure for table `au_role` */

DROP TABLE IF EXISTS `au_role`;

CREATE TABLE `au_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `roleCode` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色编码',
  `roleName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色名称',
  `createDate` date DEFAULT NULL COMMENT '创建日期',
  `isStart` int(10) DEFAULT NULL COMMENT '是否启用（0、未启用1、启用）',
  `createdBy` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建者',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `au_role` */

insert  into `au_role`(`id`,`roleCode`,`roleName`,`createDate`,`isStart`,`createdBy`) values (1,'sl_role01','管理员','2014-03-13',1,'admin'),(2,'sl_role02','会员','2014-04-08',1,'admin'),(26,'sl_role03','其它','2014-04-10',1,'admin');

/*Table structure for table `au_user` */

DROP TABLE IF EXISTS `au_user`;

CREATE TABLE `au_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `loginCode` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '登录账号',
  `password` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '登录密码（初始密码为证件号码后六位）',
  `password2` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '二级密码（初始密码为证件号码后六位）',
  `userName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户真实姓名',
  `sex` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `cardType` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '证件类型id',
  `cardTypeName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '证件类型名称',
  `idCard` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '证件号码',
  `country` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '收货国家',
  `mobile` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机',
  `email` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'email',
  `userAddress` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '收获地址',
  `postCode` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮编',
  `createTime` datetime DEFAULT NULL COMMENT '注册时间',
  `referId` bigint(20) DEFAULT NULL COMMENT '推荐人id（默认为当前登录用户id）',
  `referCode` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '推荐人编码（默认为当前登录用户loginCode）',
  `roleId` bigint(20) DEFAULT NULL COMMENT '所属角色ID',
  `roleName` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '所属角色名称',
  `userType` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户类型id',
  `userTypeName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户类型名称',
  `isStart` int(10) DEFAULT NULL COMMENT '是否启用（1、启用2、未启用3、激活）',
  `lastUpdateTime` datetime DEFAULT NULL COMMENT '最新更新时间',
  `lastLoginTime` datetime DEFAULT NULL COMMENT '最后登录时间',
  `bankAccount` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开户卡号',
  `bankName` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开户行',
  `accountHolder` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开户人',
  `idCardPicPath` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '身份证照片存放路径',
  `bankPicPath` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '银行卡照片存放路径',
  `expressType` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '快递类型',
  `code` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '安置编号',
  `totalCode` text COLLATE utf8_unicode_ci COMMENT '完整编号',
  `depth` bigint(10) DEFAULT NULL COMMENT '安置层数',
  `isLeaf` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '是否为叶子',
  `parentId` bigint(20) DEFAULT NULL COMMENT '上级Id',
  `activeStatus` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '激活状态0为待激活1为已激活',
  `activeTime` time DEFAULT NULL COMMENT '激活时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=80 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `au_user` */

insert  into `au_user`(`id`,`loginCode`,`password`,`password2`,`userName`,`sex`,`birthday`,`cardType`,`cardTypeName`,`idCard`,`country`,`mobile`,`email`,`userAddress`,`postCode`,`createTime`,`referId`,`referCode`,`roleId`,`roleName`,`userType`,`userTypeName`,`isStart`,`lastUpdateTime`,`lastLoginTime`,`bankAccount`,`bankName`,`accountHolder`,`idCardPicPath`,`bankPicPath`,`expressType`,`code`,`totalCode`,`depth`,`isLeaf`,`parentId`,`activeStatus`,`activeTime`) values (2,'a','1','123456','系统管理员','女','2000-11-25','1','身份证','123456','中国','13522614019','123@hanlu.com','1','121212','2014-03-03 00:00:00',1,'admin',1,'管理员','','',1,'2014-04-09 16:27:54','2014-06-09 15:47:17','3423423432432','中国银行','张果','/statics/uploadfiles/1396950060999_IDcard.jpg','/statics/uploadfiles/1396950267285_bank.jpg','EMS','a','a',1,'N',NULL,'1',NULL),(73,'JBIT','123456','123456','北大青鸟','','2011-04-10','1','身份证','123456','中国','123456','','','','2014-04-10 00:00:00',2,'a',2,'会员','1','注册会员',1,'2014-04-10 14:41:14','2014-04-10 15:15:26','123456','北京银行','北大青鸟','/statics/uploadfiles/1397098771656_IDcard.jpg','/statics/uploadfiles/1397112341821_bank.jpg',NULL,'0','a0',2,'N',2,'1','20:51:20'),(76,'aa','111111','111111','aa','',NULL,'1','身份证','111111','中国','1','','','','2014-05-06 14:21:51',2,'a',2,'会员','1','注册会员',1,'2014-05-06 14:21:51',NULL,'11','aa','aa','','',NULL,'1','a01',3,'N',73,'1','20:52:01'),(77,'da','111111','111111','大名','',NULL,'1','身份证','111111','中国','1','','','','2014-05-17 19:47:06',2,'a',2,'会员','1','注册会员',1,'2014-05-17 19:47:06',NULL,'1','1','1','','',NULL,'1','a1',2,'Y',2,'1','20:52:30'),(79,'Un','123123','123123','Un','',NULL,'1','身份证','123123123','中国','1223','','','','2014-05-28 15:53:13',2,'a',2,'会员','1','注册会员',1,'2014-05-28 15:53:13',NULL,'123123','123','123','','',NULL,'1','a011',4,'Y',76,'1','20:53:16');

/*Table structure for table `basics_parameter` */

DROP TABLE IF EXISTS `basics_parameter`;

CREATE TABLE `basics_parameter` (
  `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `NAME` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CODE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `VALUE` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DESCRIPTION` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DR` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='系统基础支撑数据信息';

/*Data for the table `basics_parameter` */

insert  into `basics_parameter`(`ID`,`NAME`,`CODE`,`VALUE`,`DESCRIPTION`,`DR`) values ('1','推荐奖金比率','referRate','0.05','推荐奖金比率',NULL);

/*Table structure for table `data_dictionary` */

DROP TABLE IF EXISTS `data_dictionary`;

CREATE TABLE `data_dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `typeCode` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类型编码',
  `typeName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类型名称',
  `valueId` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '字典key',
  `valueName` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '字典value',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=103 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `data_dictionary` */

insert  into `data_dictionary`(`id`,`typeCode`,`typeName`,`valueId`,`valueName`) values (1,'CARD_TYPE','证件类型','1','身份证'),(2,'CARD_TYPE','证件类型','2','驾驶证'),(3,'CARD_TYPE','证件类型','3','军官证'),(4,'CARD_TYPE','证件类型','4','护照'),(5,'USER_TYPE','用户类型','1','注册会员'),(6,'USER_TYPE','用户类型','2','普通消费会员'),(7,'USER_TYPE','用户类型','3','VIP会员'),(8,'USER_TYPE','用户类型','4','加盟店'),(9,'PACK_TYPE','套餐类型','BD','1'),(10,'PACK_TYPE','套餐类型','CX','2'),(11,'PACK_TYPE','套餐类型','FX','3'),(12,'FINANCE_ACTION','财务动作','1','基本'),(13,'FINANCE_ACTION','财务动作','2','重消'),(14,'FINANCE_ACTION','财务动作','3','同时'),(15,'ORDER_STATUS','订单状态','1','已下单'),(16,'ORDER_STATUS','订单状态','2','已取消'),(17,'ORDER_STATUS','订单状态','3','已付款'),(18,'ORDER_STATUS','订单状态','4','已配货'),(19,'ORDER_STATUS','订单状态','5','已发货'),(20,'ORDER_STATUS','订单状态','6','已送达'),(21,'ORDER_STATUS','订单状态','7','已收货'),(22,'ORDER_STATUS','订单状态','8','交易成功'),(23,'ORDER_STATUS','订单状态','9','交易未成功'),(24,'EXPRESS_TYPE','快递类型','1','EMS'),(25,'EXPRESS_TYPE','快递类型','2','顺丰快递'),(26,'EXPRESS_TYPE','快递类型','3','圆通快递'),(27,'EXPRESS_TYPE','快递类型','4','申通快递'),(28,'INFO_TYPE','资讯类型','1','图片'),(29,'INFO_TYPE','资讯类型','2','视频'),(30,'INFO_TYPE','资讯类型','3','文本'),(31,'CASH_IN_STATUS','提现状态','1','已申请'),(32,'CASH_IN_STATUS','提现状态','2','已审核'),(33,'CASH_IN_STATUS','提现状态','3','未通过'),(34,'CASH_IN_STATUS','提现状态','4','等待中'),(35,'CASH_IN_STATUS','提现状态','5','已提现'),(81,'INFOFILE_SIZE','上传资讯文件大小','1','500000000'),(80,'PV_RATE','PV转换率','RMB','1'),(89,'BONUS_PV','对碰奖励','1','200'),(88,'EACH_PV','每碰PV数','1','400'),(87,'RECOMM_PV','推荐奖励PV','1','400'),(86,'BONUS_RATE','奖金比率','1','5%'),(83,'FEE','手续费','1','5%'),(84,'OTHER_FEE','其他费用','1','10'),(82,'PERSONALFILE_SIZE','上传个人资料附件大小','1','50000');

/*Table structure for table `goods_info` */

DROP TABLE IF EXISTS `goods_info`;

CREATE TABLE `goods_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `goodsSN` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品编码',
  `goodsName` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `goodsFormat` text COLLATE utf8_unicode_ci COMMENT '商品规格',
  `marketPrice` double DEFAULT NULL COMMENT '市场价',
  `realPrice` double DEFAULT NULL COMMENT '优惠价格',
  `state` int(10) DEFAULT NULL COMMENT '状态（1、上架、2、下架）',
  `note` text COLLATE utf8_unicode_ci COMMENT '商品说明',
  `num` int(20) DEFAULT '0' COMMENT '库存数量',
  `unit` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '单位',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `lastUpdateTime` datetime DEFAULT NULL COMMENT '最后更新时间',
  `createdBy` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `goods_info` */

insert  into `goods_info`(`id`,`goodsSN`,`goodsName`,`goodsFormat`,`marketPrice`,`realPrice`,`state`,`note`,`num`,`unit`,`createTime`,`lastUpdateTime`,`createdBy`) values (14,'001','上衣','<b><font size=\"5\">明星<span style=\"background-color: rgb(255, 204, 51);\">都教授</span>同款</font></b>',120,110,1,'',56,'件','2014-04-10 10:54:40','2014-04-10 10:54:40','admin'),(15,'002','裤子','',150,100,1,'',56,'条','2014-04-10 10:55:20','2014-04-10 10:55:20','admin'),(16,'003','裙子','',200,150,2,'明星同款',90,'条','2014-04-10 10:55:56','2014-04-10 10:57:06','admin');

/*Table structure for table `goods_pack` */

DROP TABLE IF EXISTS `goods_pack`;

CREATE TABLE `goods_pack` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `goodsPackName` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '套餐名称',
  `goodsPackCode` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '套餐编码',
  `typeId` int(20) DEFAULT NULL COMMENT '套餐类型ID',
  `typeName` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '套餐类型NAME',
  `totalPrice` double DEFAULT NULL COMMENT '套餐总价（系统生成，保存时根据相关商品的优惠价*数量计算生成）',
  `state` int(10) DEFAULT NULL COMMENT '状态（1、上架2、下架）',
  `note` text COLLATE utf8_unicode_ci COMMENT '备注说明',
  `num` int(20) DEFAULT '0' COMMENT '库存数量',
  `createdBy` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '创建人',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `lastUpdateTime` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `goods_pack` */

insert  into `goods_pack`(`id`,`goodsPackName`,`goodsPackCode`,`typeId`,`typeName`,`totalPrice`,`state`,`note`,`num`,`createdBy`,`createTime`,`lastUpdateTime`) values (20,'消费会员专用','001',1,'报单套餐',300,1,'',100,'admin','2014-04-10 10:59:27','2014-04-10 11:00:59'),(1,'VIP会员专用','002',1,'报单套餐',900,1,NULL,0,NULL,'2014-04-10 10:59:27',NULL),(2,'加盟店专用','003',1,'报单套餐',1500,1,NULL,0,NULL,'2014-04-10 10:59:27',NULL),(21,'重消A','a-1',2,'重消套餐',420,1,'',111,'a','2014-05-29 11:26:11','2014-05-29 11:26:11'),(22,'重消B','a-2',2,'重消套餐',121,1,'',111,'a','2014-05-29 11:27:01','2014-05-29 11:27:01'),(23,'辅消A','b-1',3,'辅消套餐',210,1,'',111,'a','2014-05-29 11:27:48','2014-05-29 11:27:48'),(24,'辅消B','b-2',3,'辅消套餐',121,1,'',11,'a','2014-05-29 11:28:33','2014-05-29 11:28:33');

/*Table structure for table `goods_pack_affiliated` */

DROP TABLE IF EXISTS `goods_pack_affiliated`;

CREATE TABLE `goods_pack_affiliated` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `goodsPackId` bigint(20) DEFAULT NULL COMMENT '商品套餐主表ID',
  `goodsInfoId` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `goodsNum` int(20) DEFAULT NULL COMMENT '商品数量',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=92 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `goods_pack_affiliated` */

insert  into `goods_pack_affiliated`(`id`,`goodsPackId`,`goodsInfoId`,`goodsNum`) values (85,20,16,1),(84,20,14,1),(86,21,15,2),(87,21,14,1),(88,22,14,1),(89,23,15,1),(90,23,14,1),(91,24,14,1);

/*Table structure for table `info_annexes` */

DROP TABLE IF EXISTS `info_annexes`;

CREATE TABLE `info_annexes` (
  `ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT 'GOODS_ID',
  `INFO_ID` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NAME` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '货品编码',
  `URL` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STATE` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TYPE` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `UPLOAD_TIME` date DEFAULT NULL,
  `SIZE` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='资讯附件表';

/*Data for the table `info_annexes` */

/*Table structure for table `information` */

DROP TABLE IF EXISTS `information`;

CREATE TABLE `information` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `title` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '标题',
  `content` text COLLATE utf8_unicode_ci COMMENT '内容',
  `state` int(20) DEFAULT '1' COMMENT '发布状态（0、未发布 1、发布）默认为发布',
  `publisher` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '发布人',
  `publishTime` datetime DEFAULT NULL COMMENT '发布时间',
  `typeId` int(10) DEFAULT NULL COMMENT '附件类型ID',
  `typeName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '附件类型NAME',
  `fileName` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '附件名称',
  `filePath` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '附件存放路径',
  `fileSize` double DEFAULT NULL COMMENT '附件大小',
  `uploadTime` datetime DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `information` */

insert  into `information`(`id`,`title`,`content`,`state`,`publisher`,`publishTime`,`typeId`,`typeName`,`fileName`,`filePath`,`fileSize`,`uploadTime`) values (38,'资讯2','<font face=\"Arial, Verdana\" size=\"2\">资讯2资讯2资讯2资讯2资讯2资讯2资讯2资讯2</font>',1,'admin','2014-04-10 15:02:56',30,'文本','','',NULL,'2014-04-10 15:02:56'),(37,'资讯1','<h3 style=\"margin: 0px; font-family: Karla, sans-serif; color: rgb(49, 126, 172); text-rendering: optimizelegibility; font-size: 18px; line-height: 27px; background-color: rgb(255, 255, 255);\">资讯1<span style=\"font-weight: normal;\">资讯1</span><span style=\"font-weight: normal;\">资讯1</span><span style=\"font-weight: normal;\">资讯1</span><span style=\"font-weight: normal;\">资讯1</span><span style=\"font-weight: normal;\">资讯1</span><span style=\"font-weight: normal;\">资讯1</span></h3>',1,'admin','2014-04-10 15:01:26',28,'图片','超容量.bmp','/statics/infofiles/1397113716035_info.bmp',3888026,'2014-04-10 15:01:26');

/*Table structure for table `inventory` */

DROP TABLE IF EXISTS `inventory`;

CREATE TABLE `inventory` (
  `id` bigint(20) NOT NULL,
  `type` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `goodsId` bigint(20) DEFAULT NULL,
  `num` bigint(10) DEFAULT NULL,
  `stat` bigint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='库存表';

/*Data for the table `inventory` */

/*Table structure for table `leave_message` */

DROP TABLE IF EXISTS `leave_message`;

CREATE TABLE `leave_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `createdBy` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '留言用户code',
  `messageCode` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '留言编码',
  `messageTitle` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '留言标题',
  `messageContent` text COLLATE utf8_unicode_ci COMMENT '留言内容',
  `state` int(10) DEFAULT NULL COMMENT '状态（1、已回复0、未回复）',
  `createTime` datetime DEFAULT NULL COMMENT '留言时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=75 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `leave_message` */

insert  into `leave_message`(`id`,`createdBy`,`messageCode`,`messageTitle`,`messageContent`,`state`,`createTime`) values (52,'JBIT',NULL,NULL,'留言第二条测试',0,'2014-04-10 15:09:58'),(51,'JBIT',NULL,NULL,'上次买的明星款衣服真心的不错，谢谢卖家',1,'2014-04-10 15:09:22'),(55,'admin','WDZTX1','用户admin未到账提醒','充值单号：1211111111111 日期：2014-04-16 00:00:00 金额：0.0 汇款未到账，速查！',0,'2014-04-16 18:02:02'),(56,'admin','WDZTX1','用户admin未到账提醒','充值单号：1211111111111 日期：2014-04-16 00:00:00 金额：0.0 汇款未到账，速查！',0,'2014-04-16 18:07:59'),(57,'admin',NULL,NULL,'v',0,'2014-04-16 18:09:30'),(58,'admin','WDZTX1','用户admin未到账提醒','充值单号：1211111111111 日期：2014-04-16 00:00:00 金额：0.0 汇款未到账，速查！',0,'2014-04-16 18:11:02'),(59,'admin','WDZTX1','用户admin未到账提醒','充值单号：1211111111111 日期：2014-04-16 00:00:00 金额：0.0 汇款未到账，速查！',0,'2014-04-16 18:11:17'),(60,'admin','WDZTX1','用户admin未到账提醒','充值单号：1211111111111 日期：2014-04-16 00:00:00 金额：0.0 汇款未到账，速查！',0,'2014-04-16 18:11:43'),(61,'admin','WDZTX1','用户admin未到账提醒','充值单号：1211111111111 日期：2014-04-16 00:00:00 金额：0.0 汇款未到账，速查！',0,'2014-04-16 18:13:15'),(62,'admin','WDZTX2','用户admin未到账提醒','充值单号：1211111111111 日期：2014-04-16 00:00:00 金额：0.0 汇款未到账，速查！',0,'2014-04-16 18:15:32'),(63,'admin','WDZTX3','用户admin未到账提醒','充值单号：1211111111111 日期：2014-04-16 00:00:00 金额：0.0 汇款未到账，速查！',0,'2014-04-16 18:19:15'),(64,'admin','WDZTX2','用户admin未到账提醒','充值单号：1211111111111 日期：2014-04-16 00:00:00 金额：0.0 汇款未到账，速查！',0,'2014-04-16 18:19:24'),(65,'admin','WDZTX2','用户admin未到账提醒','充值单号：1211111111111 日期：2014-04-16 00:00:00 金额：0.0 汇款未到账，速查！',0,'2014-04-16 18:21:06'),(66,'admin','WDZTX2','用户admin未到账提醒','充值单号：1211111111111 日期：2014-04-16 00:00:00 金额：0.0 汇款未到账，速查！',0,'2014-04-16 18:29:17'),(67,'admin','WDZTX3','用户admin未到账提醒','充值单号：1211111111111 日期：2014-04-16 00:00:00 金额：0.0 汇款未到账，速查！',0,'2014-04-16 18:30:09'),(68,'admin','WDZTX2','用户admin未到账提醒','充值单号：1211111111111 日期：2014-04-16 00:00:00 金额：0.0 汇款未到账，速查！',0,'2014-04-16 18:30:12'),(69,'admin','WDZTX1','用户admin未到账提醒','充值单号：1211111111111 日期：2014-04-16 00:00:00 金额：0.0 汇款未到账，速查！',0,'2014-04-16 18:30:39'),(70,'admin','WDZTX1','用户admin未到账提醒','充值单号：1211111111111 日期：2014-04-16 00:00:00 金额：0.0 汇款未到账，速查！',0,'2014-04-16 18:31:04'),(71,'admin','WDZTX2','用户admin未到账提醒','充值单号：1211111111111 日期：2014-04-16 00:00:00 金额：0.0 汇款未到账，速查！',0,'2014-04-16 18:31:06'),(72,'admin','WDZTX1','用户admin未到账提醒','充值单号：1211111111111 日期：2014-04-16 00:00:00 金额：0.0 汇款未到账，速查！',0,'2014-04-16 18:32:04'),(73,'a','WDZTX9','用户a未到账提醒','充值单号：13977250549151 日期：2014-04-23 00:00:00 金额：0.0 汇款未到账，速查！',0,'2014-04-24 14:30:33'),(74,'a',NULL,NULL,'a',0,'2014-04-24 15:58:09');

/*Table structure for table `multi_lan` */

DROP TABLE IF EXISTS `multi_lan`;

CREATE TABLE `multi_lan` (
  `ELEMENT_ID` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '元素内容ID',
  `PAGE_PATH` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '页面文件路径',
  `SCN` varchar(3000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '简体中文',
  `TCN` varchar(3000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '繁体中文',
  `EN` varchar(3000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '英文',
  `JP` varchar(3000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '日文',
  `KR` varchar(3000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '韩文',
  `FR` varchar(3000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '法文',
  `RA` varchar(3000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '俄文',
  PRIMARY KEY (`ELEMENT_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='多语言内容';

/*Data for the table `multi_lan` */

/*Table structure for table `order_info` */

DROP TABLE IF EXISTS `order_info`;

CREATE TABLE `order_info` (
  `orderId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ORDER_ID',
  `orderTime` timestamp NULL DEFAULT NULL COMMENT '订购时间',
  `orderNum` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '订购单号',
  `type` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '订单类型；BD为报单购货;CX为重销购货；FX为辅消购货',
  `pickUserId` bigint(20) DEFAULT NULL COMMENT '收货用户ID',
  `repeatPV` decimal(12,2) DEFAULT NULL COMMENT '重消PV',
  `basePV` decimal(12,2) DEFAULT NULL COMMENT '基本PV',
  `serviceFee` decimal(12,2) DEFAULT NULL COMMENT '服务费',
  `shipFre` decimal(12,2) DEFAULT NULL COMMENT '快递费',
  `tax` decimal(12,2) DEFAULT NULL COMMENT '税费',
  `country` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '收货国家',
  `tel` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `mobile` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机',
  `email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电邮',
  `userAddress` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '家庭住址',
  `postCode` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮政编码',
  `stat` bigint(2) DEFAULT NULL COMMENT '0新建,1已提交,2已审核,3已发货,4已收货,5审核未通过,6已撤销',
  `shipType` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '快递类型',
  `shipNum` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '快递单号',
  `shipTime` date DEFAULT NULL COMMENT '发货时间',
  `receiveTime` date DEFAULT NULL COMMENT '收货确认时间',
  `shipNote` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '送货说明',
  `buyUserId` bigint(20) NOT NULL COMMENT '付款用户ID',
  PRIMARY KEY (`orderId`)
) ENGINE=MyISAM AUTO_INCREMENT=192 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户订购记录表';

/*Data for the table `order_info` */

insert  into `order_info`(`orderId`,`orderTime`,`orderNum`,`type`,`pickUserId`,`repeatPV`,`basePV`,`serviceFee`,`shipFre`,`tax`,`country`,`tel`,`mobile`,`email`,`userAddress`,`postCode`,`stat`,`shipType`,`shipNum`,`shipTime`,`receiveTime`,`shipNote`,`buyUserId`) values (184,NULL,'CX14022918116433','CX',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,2),(182,NULL,'CX14022916753312','CX',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,2),(189,'2014-06-09 13:36:39','FX14022920849182','FX',2,NULL,'872.00',NULL,NULL,NULL,'中国',NULL,'13522614019','123@hanlu.com','1','121212',1,'EMS',NULL,NULL,NULL,NULL,2),(186,'2014-06-09 13:33:50','CX14022920307730','CX',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,2),(187,'2014-06-09 13:34:09','CX14022920490760','CX',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,2),(188,'2014-06-09 13:34:36','FX14022920765063','FX',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,2),(190,'2014-06-09 13:50:58','CX14022930582582','CX',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,2),(191,'2014-06-09 13:51:23','FX14022930839812','FX',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,2),(176,'2014-06-09 13:22:10','FX14022913134123','FX',2,NULL,'331.00',NULL,NULL,NULL,'中国',NULL,'13522614019','123@hanlu.com','1','121212',1,'EMS',NULL,NULL,NULL,NULL,2),(170,'2014-06-09 13:15:10','CX14022909006084','FX',2,NULL,'1082.00',NULL,NULL,NULL,'中国',NULL,'13522614019','123@hanlu.com','1','121212',1,'EMS',NULL,NULL,NULL,NULL,2),(169,'2014-06-09 12:51:43','CX14022894844953','CX',2,'541.00','0.00',NULL,NULL,NULL,'中国',NULL,'13522614019','123@hanlu.com','1','121212',1,'EMS',NULL,NULL,NULL,NULL,2),(167,'2014-06-09 11:17:55','CX14022836768523','CX',2,'662.00','662.00',NULL,NULL,NULL,'中国',NULL,'13522614019','123@hanlu.com','1','121212',1,'EMS',NULL,NULL,NULL,NULL,2),(168,'2014-06-09 11:36:27','CX14022849618272','CX',2,'1082.00','0.00',NULL,NULL,NULL,'中国',NULL,'13522614019','123@hanlu.com','1','121212',1,'EMS',NULL,NULL,NULL,NULL,2),(166,'2014-06-09 11:38:38','CX14022834019554','CX',2,'1203.00','0.00',NULL,NULL,NULL,'中国',NULL,'13522614019','123@hanlu.com','1','121212',1,'EMS',NULL,NULL,NULL,NULL,2),(164,NULL,'CX14021512098952','CX',2,NULL,'783.00',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,2),(165,'2014-06-09 11:38:04','CX14022833879612','CX',2,'363.00','0.00',NULL,NULL,NULL,'中国',NULL,'13522614019','123@hanlu.com','1','121212',1,'EMS',NULL,NULL,NULL,NULL,2),(163,'2014-06-08 11:46:03','CX14021991526212','CX',2,'541.00','541.00',NULL,NULL,NULL,'中国',NULL,'13522614019','123@hanlu.com','1','121212',1,'EMS',NULL,NULL,NULL,NULL,2),(161,'2014-06-07 22:26:27','CX14021511668610','CX',2,'1082.00','1082.00',NULL,NULL,NULL,'中国',NULL,'13522614019','123@hanlu.com','1','121212',1,'EMS',NULL,NULL,NULL,NULL,2);

/*Table structure for table `order_list` */

DROP TABLE IF EXISTS `order_list`;

CREATE TABLE `order_list` (
  `listId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `orderNum` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '订单号',
  `goodsType` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品类型；G为商品P为套餐',
  `goodsId` bigint(20) DEFAULT NULL COMMENT '商品或套餐ID',
  `goodsSN` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品或套餐编码',
  `goodsName` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品或套餐名称',
  `goodsFormat` text COLLATE utf8_unicode_ci COMMENT '规格',
  `goodsNum` bigint(20) DEFAULT NULL COMMENT '数量',
  `eachPrice` double(12,2) DEFAULT NULL COMMENT '单价',
  `sumPrice` double(12,2) DEFAULT NULL COMMENT '总价',
  `discount` double(6,4) DEFAULT NULL COMMENT '折扣',
  `realPrice` double(12,2) DEFAULT NULL COMMENT '实际价格',
  `currency` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '货币种类',
  `realPV` double(12,2) DEFAULT NULL COMMENT '实际PV',
  `pvRate` double(6,4) DEFAULT NULL COMMENT 'PV折算率',
  PRIMARY KEY (`listId`)
) ENGINE=MyISAM AUTO_INCREMENT=292 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户订购商品表';

/*Data for the table `order_list` */

insert  into `order_list`(`listId`,`orderNum`,`goodsType`,`goodsId`,`goodsSN`,`goodsName`,`goodsFormat`,`goodsNum`,`eachPrice`,`sumPrice`,`discount`,`realPrice`,`currency`,`realPV`,`pvRate`) values (280,'CX14022918116433','CX',22,'a-2','重消B',NULL,1,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000),(278,'CX14022916753312','CX',22,'a-2','重消B',NULL,2,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000),(286,'FX14022920765063','FX',24,'b-2','辅消B',NULL,2,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000),(287,'FX14022920849182','FX',24,'b-2','辅消B',NULL,2,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000),(285,'CX14022920490760','CX',22,'a-2','重消B',NULL,3,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000),(283,'CX14022920307730','CX',22,'a-2','重消B',NULL,1,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000),(284,'CX14022920307730','CX',21,'a-1','重消A',NULL,2,420.00,420.00,NULL,420.00,'RMB',420.00,1.0000),(271,'FX14022913134123','FX',23,'b-1','辅消A',NULL,1,210.00,210.00,NULL,210.00,'RMB',210.00,1.0000),(291,'FX14022930839812','FX',23,'b-1','辅消A',NULL,1,210.00,210.00,NULL,210.00,'RMB',210.00,1.0000),(270,'FX14022913134123','FX',24,'b-2','辅消B',NULL,1,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000),(288,'FX14022920849182','FX',23,'b-1','辅消A',NULL,3,210.00,210.00,NULL,210.00,'RMB',210.00,1.0000),(289,'CX14022930582582','CX',22,'a-2','重消B',NULL,2,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000),(290,'FX14022930839812','FX',24,'b-2','辅消B',NULL,1,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000),(260,'CX14022909006084','FX',21,'a-1','重消A',NULL,2,420.00,420.00,NULL,420.00,'RMB',420.00,1.0000),(259,'CX14022909006084','FX',22,'a-2','重消B',NULL,2,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000),(258,'CX14022894844953','CX',21,'a-1','重消A',NULL,1,420.00,420.00,NULL,420.00,'RMB',420.00,1.0000),(257,'CX14022894844953','CX',22,'a-2','重消B',NULL,1,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000),(256,'CX14022849618272','CX',21,'a-1','重消A',NULL,2,420.00,420.00,NULL,420.00,'RMB',420.00,1.0000),(255,'CX14022849618272','CX',22,'a-2','重消B',NULL,2,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000),(254,'CX14022836768523','CX',21,'a-1','重消A',NULL,1,420.00,420.00,NULL,420.00,'RMB',420.00,1.0000),(253,'CX14022836768523','CX',22,'a-2','重消B',NULL,2,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000),(249,'CX14021991526212','CX',21,'a-1','重消A',NULL,1,420.00,420.00,NULL,420.00,'RMB',420.00,1.0000),(248,'CX14021991526212','CX',22,'a-2','重消B',NULL,1,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000),(252,'CX14022834019554','CX',21,'a-1','重消A',NULL,1,420.00,420.00,NULL,420.00,'RMB',420.00,1.0000),(250,'CX14022833879612','CX',22,'a-2','重消B',NULL,2,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000),(244,'CX14021511668610','CX',22,'a-2','重消B',NULL,2,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000),(245,'CX14021511668610','CX',21,'a-1','重消A',NULL,2,420.00,420.00,NULL,420.00,'RMB',420.00,1.0000),(251,'CX14022834019554','CX',22,'a-2','重消B',NULL,2,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000),(239,'CX14021365098424','CX',21,'a-1','重消A',NULL,1,420.00,420.00,NULL,420.00,'RMB',420.00,1.0000),(238,'CX14021365098424','CX',22,'a-2','重消B',NULL,1,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000),(237,'CX14021359078983',NULL,21,'a-1','重消A',NULL,2,420.00,420.00,NULL,420.00,'RMB',420.00,1.0000),(236,'CX14021359078983',NULL,22,'a-2','重消B',NULL,2,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000),(235,'CX14021357198734',NULL,21,'a-1','重消A',NULL,2,420.00,420.00,NULL,420.00,'RMB',420.00,1.0000),(234,'CX14021357198734',NULL,22,'a-2','重消B',NULL,2,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000),(233,'CX14021350070372',NULL,21,'a-1','重消A',NULL,2,420.00,420.00,NULL,420.00,'RMB',420.00,1.0000),(232,'CX14021350070372',NULL,22,'a-2','重消B',NULL,2,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000),(231,'CX14021350070372',NULL,21,'a-1','重消A',NULL,2,420.00,420.00,NULL,420.00,'RMB',420.00,1.0000),(230,'CX14021350070372',NULL,22,'a-2','重消B',NULL,2,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000),(229,'CX14021346524623',NULL,21,'a-1','重消A',NULL,2,420.00,420.00,NULL,420.00,'RMB',420.00,1.0000),(228,'CX14021346524623',NULL,22,'a-2','重消B',NULL,2,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000),(227,'CX14021345248850',NULL,21,'a-1','重消A',NULL,2,420.00,420.00,NULL,420.00,'RMB',420.00,1.0000),(226,'CX14021345248850',NULL,22,'a-2','重消B',NULL,2,121.00,121.00,NULL,121.00,'RMB',121.00,1.0000);

/*Table structure for table `reply` */

DROP TABLE IF EXISTS `reply`;

CREATE TABLE `reply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `messageId` bigint(20) DEFAULT NULL COMMENT '留言ID（主表）',
  `replyContent` text COLLATE utf8_unicode_ci COMMENT '回复内容',
  `createdBy` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '回复人',
  `createTime` datetime DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `reply` */

insert  into `reply`(`id`,`messageId`,`replyContent`,`createdBy`,`createTime`) values (33,51,'那大家都来买吧，呵呵','admin','2014-04-10 15:11:25');

/*Table structure for table `uploadtemp` */

DROP TABLE IF EXISTS `uploadtemp`;

CREATE TABLE `uploadtemp` (
  `uploader` varchar(20) DEFAULT NULL,
  `uploadType` varchar(20) DEFAULT NULL,
  `uploadFilePath` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `uploadtemp` */

insert  into `uploadtemp`(`uploader`,`uploadType`,`uploadFilePath`) values ('admin','info','/statics/infofiles/1396950789567_info.jpg'),('admin','info','/statics/infofiles/1396951051763_info.png'),('admin','info','/statics/infofiles/1396951079132_info.jpg'),('admin','info','/statics/infofiles/1396951400713_info.jpg'),('admin','info','/statics/infofiles/1397024384221_info.jpg'),('admin','info','/statics/infofiles/1397113789074_info.JPG'),('admin','info','/statics/infofiles/1397113716035_info.bmp');

/*Table structure for table `user_account_201312` */

DROP TABLE IF EXISTS `user_account_201312`;

CREATE TABLE `user_account_201312` (
  `ACCOUNT_ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT 'ACCOUNT_ID',
  `USER_ID` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ACCOUNT_DATE` date DEFAULT NULL COMMENT '日期',
  `STAT` decimal(6,0) DEFAULT NULL COMMENT '0开放,1奖励完成,2积分消费完成',
  `BASE_IN` decimal(12,2) DEFAULT NULL COMMENT '基本入账',
  `BASE_OUT` decimal(12,2) DEFAULT NULL COMMENT '基本出账',
  `BASE_BALANCE` decimal(6,4) DEFAULT NULL COMMENT '基本余额',
  `REPEAT_IN` decimal(12,2) DEFAULT NULL COMMENT '重消入账',
  `REPEAT_OUT` decimal(12,2) DEFAULT NULL COMMENT '重消出账',
  `REPEAT_BALANCE` decimal(12,2) DEFAULT NULL COMMENT '重消余额',
  `FREE_PV` decimal(12,2) DEFAULT NULL COMMENT '还未够750PV，即够750PV后可分红的部分',
  `ALREADY_PV` decimal(12,2) DEFAULT NULL COMMENT '积分消费后的分红PV（可领货不可重分红）',
  `BUY_PV` decimal(12,2) DEFAULT NULL COMMENT '当天领货后的PV',
  PRIMARY KEY (`ACCOUNT_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户总账表';

/*Data for the table `user_account_201312` */

/*Table structure for table `user_account_201404` */

DROP TABLE IF EXISTS `user_account_201404`;

CREATE TABLE `user_account_201404` (
  `accountId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `userId` int(11) NOT NULL COMMENT '用户主键ID',
  `accountData` date DEFAULT NULL COMMENT '日期',
  `stat` int(11) DEFAULT NULL COMMENT '总账状态',
  `baseIn` double(12,4) DEFAULT NULL COMMENT '基本入账',
  `baseOut` double(12,4) DEFAULT NULL COMMENT '基本出账',
  `baseBalance` double(12,4) DEFAULT NULL COMMENT '基本余额',
  `repeatIn` double(12,4) DEFAULT NULL COMMENT '重消入账',
  `repeatOut` double(12,4) DEFAULT NULL COMMENT '重消出账',
  `repeatBalance` double(12,4) DEFAULT NULL COMMENT '重消余额',
  `freePV` double(12,4) DEFAULT NULL COMMENT '未分红重消PV',
  `alreadyPV` double(12,4) DEFAULT NULL COMMENT '已分红未领货重消PV',
  `buyPV` double(12,4) DEFAULT NULL COMMENT '已领货重消PV',
  PRIMARY KEY (`accountId`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user_account_201404` */

insert  into `user_account_201404`(`accountId`,`userId`,`accountData`,`stat`,`baseIn`,`baseOut`,`baseBalance`,`repeatIn`,`repeatOut`,`repeatBalance`,`freePV`,`alreadyPV`,`buyPV`) values (1,2,'2014-04-26',1,1.0000,1.0000,44.0000,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `user_account_201405` */

DROP TABLE IF EXISTS `user_account_201405`;

CREATE TABLE `user_account_201405` (
  `accountId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `userId` int(11) NOT NULL COMMENT '用户主键ID',
  `accountData` date DEFAULT NULL COMMENT '日期',
  `stat` int(11) DEFAULT NULL COMMENT '总账状态',
  `baseIn` double(12,4) DEFAULT NULL COMMENT '基本入账',
  `baseOut` double(12,4) DEFAULT NULL COMMENT '基本出账',
  `baseBalance` double(12,4) DEFAULT NULL COMMENT '基本余额',
  `repeatIn` double(12,4) DEFAULT NULL COMMENT '重消入账',
  `repeatOut` double(12,4) DEFAULT NULL COMMENT '重消出账',
  `repeatBalance` double(12,4) DEFAULT NULL COMMENT '重消余额',
  `freePV` double(12,4) DEFAULT NULL COMMENT '未分红重消PV',
  `alreadyPV` double(12,4) DEFAULT NULL COMMENT '已分红未领货重消PV',
  `buyPV` double(12,4) DEFAULT NULL COMMENT '已领货重消PV',
  PRIMARY KEY (`accountId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user_account_201405` */

insert  into `user_account_201405`(`accountId`,`userId`,`accountData`,`stat`,`baseIn`,`baseOut`,`baseBalance`,`repeatIn`,`repeatOut`,`repeatBalance`,`freePV`,`alreadyPV`,`buyPV`) values (1,2,'2014-05-28',6,300.0000,1.0000,196100.0000,NULL,NULL,NULL,NULL,NULL,NULL),(2,76,'2014-05-13',6,1.0000,0.0000,-1.0000,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `user_account_201406` */

DROP TABLE IF EXISTS `user_account_201406`;

CREATE TABLE `user_account_201406` (
  `accountId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `userId` int(11) NOT NULL COMMENT '用户主键ID',
  `accountData` date DEFAULT NULL COMMENT '日期',
  `stat` int(11) DEFAULT NULL COMMENT '总账状态',
  `baseIn` double(12,4) DEFAULT NULL COMMENT '基本入账',
  `baseOut` double(12,4) DEFAULT NULL COMMENT '基本出账',
  `baseBalance` double(12,4) DEFAULT NULL COMMENT '基本余额',
  `repeatIn` double(12,4) DEFAULT NULL COMMENT '重消入账',
  `repeatOut` double(12,4) DEFAULT NULL COMMENT '重消出账',
  `repeatBalance` double(12,4) DEFAULT NULL COMMENT '重消余额',
  `freePV` double(12,4) DEFAULT NULL COMMENT '未分红重消PV',
  `alreadyPV` double(12,4) DEFAULT NULL COMMENT '已分红未领货重消PV',
  `buyPV` double(12,4) DEFAULT NULL COMMENT '已领货重消PV',
  PRIMARY KEY (`accountId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user_account_201406` */

insert  into `user_account_201406`(`accountId`,`userId`,`accountData`,`stat`,`baseIn`,`baseOut`,`baseBalance`,`repeatIn`,`repeatOut`,`repeatBalance`,`freePV`,`alreadyPV`,`buyPV`) values (2,2,'2014-06-09',1,961.0000,872.0000,192491.0000,NULL,541.0000,96317.0000,NULL,NULL,NULL),(3,76,'2014-05-13',6,1.0000,0.0000,-1.0000,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `user_account_201407` */

DROP TABLE IF EXISTS `user_account_201407`;

CREATE TABLE `user_account_201407` (
  `accountId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `userId` int(11) NOT NULL COMMENT '用户主键ID',
  `accountData` timestamp NULL DEFAULT NULL COMMENT '日期',
  `stat` int(11) DEFAULT NULL COMMENT '总账状态',
  `baseIn` double(12,4) DEFAULT NULL COMMENT '基本入账',
  `baseOut` double(12,4) DEFAULT NULL COMMENT '基本出账',
  `baseBalance` double(12,4) DEFAULT NULL COMMENT '基本余额',
  `repeatIn` double(12,4) DEFAULT NULL COMMENT '重消入账',
  `repeatOut` double(12,4) DEFAULT NULL COMMENT '重消出账',
  `repeatBalance` double(12,4) DEFAULT NULL COMMENT '重消余额',
  `freePV` double(12,4) DEFAULT NULL COMMENT '未分红重消PV',
  `alreadyPV` double(12,4) DEFAULT NULL COMMENT '已分红未领货重消PV',
  `buyPV` double(12,4) DEFAULT NULL COMMENT '已领货重消PV',
  PRIMARY KEY (`accountId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user_account_201407` */

insert  into `user_account_201407`(`accountId`,`userId`,`accountData`,`stat`,`baseIn`,`baseOut`,`baseBalance`,`repeatIn`,`repeatOut`,`repeatBalance`,`freePV`,`alreadyPV`,`buyPV`) values (1,2,'2014-04-26 00:00:00',1,1.0000,1.0000,44.0000,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `user_account_log_201404` */

DROP TABLE IF EXISTS `user_account_log_201404`;

CREATE TABLE `user_account_log_201404` (
  `accountLogId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `actionTime` date DEFAULT NULL,
  `actionDesc` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '动作摘要',
  `actionType` decimal(6,0) DEFAULT NULL COMMENT '0辅消,1重消',
  `baseIn` decimal(12,4) DEFAULT NULL COMMENT '基本入账',
  `baseOut` decimal(12,4) DEFAULT NULL COMMENT '基本出账',
  `baseBalance` decimal(12,4) DEFAULT NULL COMMENT '基本余额',
  `repeatIn` decimal(12,4) DEFAULT NULL COMMENT '重消入账',
  `repeatOut` decimal(12,4) DEFAULT NULL COMMENT '重消出账',
  `repeatBalance` decimal(12,4) DEFAULT NULL COMMENT '重消余额',
  PRIMARY KEY (`accountLogId`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户总账明细表';

/*Data for the table `user_account_log_201404` */

insert  into `user_account_log_201404`(`accountLogId`,`userId`,`actionTime`,`actionDesc`,`actionType`,`baseIn`,`baseOut`,`baseBalance`,`repeatIn`,`repeatOut`,`repeatBalance`) values (14,2,'2014-04-26','a','0','1.0000','0.0000','45.0000','0.0000','0.0000','0.0000'),(13,2,'2014-04-25','提现3.0PV','1','0.0000','3.0000','44.0000','0.0000','0.0000','0.0000'),(12,2,'2014-04-25','提现2.0PV','1','0.0000','2.0000','47.0000','0.0000','0.0000','0.0000'),(10,2,'2014-04-24','a','0','1.0000','0.0000','50.0000','0.0000','0.0000','0.0000'),(11,2,'2014-04-24','a','1','0.0000','1.0000','49.0000','0.0000','0.0000','0.0000'),(15,2,'2014-04-26','a','1','0.0000','1.0000','44.0000','0.0000','0.0000','0.0000'),(16,2,'2014-04-26','aa','0','1.0000','0.0000','45.0000','0.0000','0.0000','0.0000'),(17,2,'2014-04-26','aa','1','0.0000','1.0000','44.0000','0.0000','0.0000','0.0000'),(18,2,'2014-04-26','dd','0','1.0000','0.0000','45.0000','0.0000','0.0000','0.0000'),(19,2,'2014-04-26','dd','1','0.0000','1.0000','44.0000','0.0000','0.0000','0.0000'),(20,2,'2014-04-26','e','0','1.0000','0.0000','45.0000','0.0000','0.0000','0.0000'),(21,2,'2014-04-26','e','1','0.0000','1.0000','44.0000','0.0000','0.0000','0.0000');

/*Table structure for table `user_account_log_201405` */

DROP TABLE IF EXISTS `user_account_log_201405`;

CREATE TABLE `user_account_log_201405` (
  `accountLogId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `actionTime` timestamp NULL DEFAULT NULL,
  `actionDesc` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '动作摘要',
  `actionType` decimal(6,0) DEFAULT NULL COMMENT '0辅消,1重消',
  `baseIn` decimal(12,4) DEFAULT NULL COMMENT '基本入账',
  `baseOut` decimal(12,4) DEFAULT NULL COMMENT '基本出账',
  `baseBalance` decimal(12,4) DEFAULT NULL COMMENT '基本余额',
  `repeatIn` decimal(12,4) DEFAULT NULL COMMENT '重消入账',
  `repeatOut` decimal(12,4) DEFAULT NULL COMMENT '重消出账',
  `repeatBalance` decimal(12,4) DEFAULT NULL COMMENT '重消余额',
  PRIMARY KEY (`accountLogId`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user_account_log_201405` */

insert  into `user_account_log_201405`(`accountLogId`,`userId`,`actionTime`,`actionDesc`,`actionType`,`baseIn`,`baseOut`,`baseBalance`,`repeatIn`,`repeatOut`,`repeatBalance`) values (13,2,'2014-05-13 11:19:53','报单购货','6','300.0000','0.0000','1700.0000','0.0000','0.0000','0.0000'),(14,2,'2014-05-17 18:43:49','报单购货','6','900.0000','0.0000','800.0000','0.0000','0.0000','0.0000'),(15,2,'2014-05-17 18:50:06','报单购货','6','300.0000','0.0000','500.0000','0.0000','0.0000','0.0000'),(16,2,'2014-05-17 18:52:56','报单购货','6','300.0000','0.0000','200.0000','0.0000','0.0000','0.0000'),(17,2,'2014-05-17 18:57:11','报单购货','6','300.0000','0.0000','199700.0000','0.0000','0.0000','0.0000'),(18,2,'2014-05-17 18:58:51','报单购货','6','300.0000','0.0000','199400.0000','0.0000','0.0000','0.0000'),(19,2,'2014-05-17 18:59:31','报单购货','6','300.0000','0.0000','199100.0000','0.0000','0.0000','0.0000'),(20,2,'2014-05-17 19:04:25','报单购货','6','300.0000','0.0000','198800.0000','0.0000','0.0000','0.0000'),(21,2,'2014-05-17 19:06:54','报单购货','6','300.0000','0.0000','198500.0000','0.0000','0.0000','0.0000'),(22,2,'2014-05-17 19:07:20','报单购货','6','300.0000','0.0000','198200.0000','0.0000','0.0000','0.0000'),(23,2,'2014-05-17 19:09:12','报单购货','6','300.0000','0.0000','197900.0000','0.0000','0.0000','0.0000'),(24,2,'2014-05-17 20:30:02','报单购货','6','300.0000','0.0000','197600.0000','0.0000','0.0000','0.0000'),(25,2,'2014-05-17 21:43:11','报单购货','6','300.0000','0.0000','197300.0000','0.0000','0.0000','0.0000'),(26,2,'2014-05-17 22:14:34','报单购货','6','300.0000','0.0000','197000.0000','0.0000','0.0000','0.0000'),(27,2,'2014-05-17 22:27:27','报单购货','6','300.0000','0.0000','196700.0000','0.0000','0.0000','0.0000'),(28,2,'2014-05-17 22:34:12','报单购货','6','300.0000','0.0000','196400.0000','0.0000','0.0000','0.0000'),(29,2,'2014-05-28 18:16:59','报单购货','6','300.0000','0.0000','196100.0000','0.0000','0.0000','0.0000');

/*Table structure for table `user_account_log_201406` */

DROP TABLE IF EXISTS `user_account_log_201406`;

CREATE TABLE `user_account_log_201406` (
  `accountLogId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `actionTime` date DEFAULT NULL,
  `actionDesc` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '动作摘要',
  `actionType` decimal(6,0) DEFAULT NULL COMMENT '0辅消,1重消',
  `baseIn` decimal(12,2) DEFAULT NULL COMMENT '基本入账',
  `baseOut` decimal(12,2) DEFAULT NULL COMMENT '基本出账',
  `baseBalance` decimal(12,4) DEFAULT NULL COMMENT '基本余额',
  `repeatIn` decimal(12,2) DEFAULT NULL COMMENT '重消入账',
  `repeatOut` decimal(12,2) DEFAULT NULL COMMENT '重消出账',
  `repeatBalance` decimal(12,2) DEFAULT NULL COMMENT '重消余额',
  PRIMARY KEY (`accountLogId`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user_account_log_201406` */

insert  into `user_account_log_201406`(`accountLogId`,`userId`,`actionTime`,`actionDesc`,`actionType`,`baseIn`,`baseOut`,`baseBalance`,`repeatIn`,`repeatOut`,`repeatBalance`) values (1,2,'2014-06-06','重消购货','6','121.00','0.00','195979.0000','0.00','0.00','0.00'),(2,2,'2014-06-06','重消购货','6','121.00','0.00','195858.0000','0.00','0.00','0.00'),(3,2,'2014-06-06','重消购货','3','121.00','0.00','195858.0000','0.00','0.00','0.00'),(4,2,'2014-06-06','重消购货','3','420.00','0.00','195858.0000','0.00','0.00','0.00'),(5,2,'2014-06-06','重消购货','3','121.00','0.00','195858.0000','0.00','0.00','0.00'),(6,2,'2014-06-06','重消购货','3','961.00','0.00','195858.0000','0.00','0.00','0.00'),(7,2,'2014-06-06','重消购货','3','0.00','0.00','0.0000','0.00','121.00','102332.00'),(8,2,'2014-06-07','辅消购货','1','0.00','1082.00','194776.0000','0.00','0.00','0.00'),(9,2,'2014-06-07','重消购货','3','0.00','0.00','0.0000','0.00','541.00','101791.00'),(10,2,'2014-06-07','重消购货','3','0.00','0.00','0.0000','0.00','1082.00','100709.00'),(11,2,'2014-06-08','重消购货','3','0.00','0.00','0.0000','0.00','541.00','100168.00'),(12,2,'2014-06-09','重消购货','3','0.00','0.00','0.0000','0.00','662.00','99506.00'),(13,2,'2014-06-09','重消购货','3','0.00','0.00','0.0000','0.00','1082.00','98424.00'),(14,2,'2014-06-09','重消购货','3','0.00','0.00','0.0000','0.00','363.00','98061.00'),(15,2,'2014-06-09','重消购货','3','0.00','0.00','0.0000','0.00','1203.00','96858.00'),(16,2,'2014-06-09','重消购货','3','0.00','0.00','0.0000','0.00','541.00','96317.00'),(17,2,'2014-06-09','辅消购货','1','0.00','1082.00','193694.0000','0.00','0.00','0.00'),(18,2,'2014-06-09','辅消购货','1','0.00','331.00','193363.0000','0.00','0.00','0.00'),(19,2,'2014-06-09','辅消购货','1','0.00','872.00','192491.0000','0.00','0.00','0.00');

/*Table structure for table `user_account_log_201407` */

DROP TABLE IF EXISTS `user_account_log_201407`;

CREATE TABLE `user_account_log_201407` (
  `accountLogId` bigint(20) NOT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `actionTime` date DEFAULT NULL,
  `actionDesc` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '动作摘要',
  `actionType` decimal(6,0) DEFAULT NULL COMMENT '0辅消,1重消',
  `baseIn` decimal(12,2) DEFAULT NULL COMMENT '基本入账',
  `baseOut` decimal(12,2) DEFAULT NULL COMMENT '基本出账',
  `baseBalance` decimal(6,4) DEFAULT NULL COMMENT '基本余额',
  `repeatIn` decimal(12,2) DEFAULT NULL COMMENT '重消入账',
  `repeatOut` decimal(12,2) DEFAULT NULL COMMENT '重消出账',
  `repeatBalance` decimal(12,2) DEFAULT NULL COMMENT '重消余额',
  PRIMARY KEY (`accountLogId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user_account_log_201407` */

/*Table structure for table `user_buy` */

DROP TABLE IF EXISTS `user_buy`;

CREATE TABLE `user_buy` (
  `BUY_ID` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT 'BUY_ID',
  `BUY_TIME` date DEFAULT NULL COMMENT '消费时间',
  `BONUS_USER_ID` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '拿奖金用户ID',
  `USER_ID` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `BUY_PV` decimal(12,2) DEFAULT NULL COMMENT '消费PV',
  `BONUS_RATE` decimal(6,4) DEFAULT NULL COMMENT '奖金比率',
  `BONUS_PV` decimal(12,2) DEFAULT NULL COMMENT '奖励PV',
  PRIMARY KEY (`BUY_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户重复消费记录表(个人拿钱再买)';

/*Data for the table `user_buy` */

/*Table structure for table `user_buy_bonus` */

DROP TABLE IF EXISTS `user_buy_bonus`;

CREATE TABLE `user_buy_bonus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'BUY_BONUS_ID',
  `bonusMonth` varchar(22) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '月份',
  `calTime` date DEFAULT NULL COMMENT '计算时间',
  `bonusUserId` bigint(20) DEFAULT NULL COMMENT '获得奖励用户ID',
  `buyPV` double(12,2) DEFAULT NULL COMMENT '下属总消费PV',
  `bonusRate` double(6,4) DEFAULT NULL COMMENT '奖金比率',
  `bonusPV` double(12,2) DEFAULT NULL COMMENT '总奖励PV',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户重复消费月奖励记录表';

/*Data for the table `user_buy_bonus` */

/*Table structure for table `user_cash` */

DROP TABLE IF EXISTS `user_cash`;

CREATE TABLE `user_cash` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'CASH_ID',
  `cashTime` date DEFAULT NULL COMMENT '申请提现时间',
  `cashNum` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '提现单号',
  `userId` bigint(20) DEFAULT NULL,
  `cashPV` decimal(12,4) DEFAULT NULL COMMENT '提现PV',
  `currency` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '提现货币',
  `pvRate` decimal(6,4) DEFAULT NULL COMMENT 'PV转换率',
  `cashMoney` decimal(12,4) DEFAULT NULL COMMENT '提现金额',
  `note` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '提现备注',
  `fee` decimal(12,4) DEFAULT NULL COMMENT '手续费',
  `tax` decimal(12,4) DEFAULT NULL COMMENT '税费',
  `otherFee` decimal(12,4) DEFAULT NULL COMMENT '其他费用',
  `bankName` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '提现银行名',
  `bankBrance` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '银行开户行名',
  `bankAccount` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '银行账号',
  `accountName` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '账号姓名',
  `stat` int(11) DEFAULT NULL COMMENT '0申请提现,1审核通过,2转账完毕',
  `creditedMoney` decimal(12,4) DEFAULT NULL COMMENT '到账金额',
  `creditedTime` date DEFAULT NULL COMMENT '到账时间',
  `operator` bigint(20) DEFAULT NULL COMMENT '操作人',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户PV提现记录表';

/*Data for the table `user_cash` */

insert  into `user_cash`(`id`,`cashTime`,`cashNum`,`userId`,`cashPV`,`currency`,`pvRate`,`cashMoney`,`note`,`fee`,`tax`,`otherFee`,`bankName`,`bankBrance`,`bankAccount`,`accountName`,`stat`,`creditedMoney`,`creditedTime`,`operator`) values (1,'2014-04-25','13984143902073',2,'2.0000','RMB','1.0000','1.9000',NULL,'0.1000','0.0000','0.0000','中国银行','1','1','1',0,NULL,NULL,NULL),(2,'2014-04-25','13984154014320',2,'3.0000','RMB','1.0000','2.8500',NULL,'0.1500','0.0000','0.0000','中国银行','1','1','1',0,NULL,NULL,NULL);

/*Table structure for table `user_pair_201312` */

DROP TABLE IF EXISTS `user_pair_201312`;

CREATE TABLE `user_pair_201312` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'PAIR_ID',
  `date` date DEFAULT NULL COMMENT '前一天的日期',
  `bonusUserId` bigint(20) DEFAULT NULL,
  `leftUserNum` bigint(10) DEFAULT NULL COMMENT '左用户总数',
  `rightUserNum` bigint(10) DEFAULT NULL COMMENT '右用户总数',
  `leftKeep` bigint(10) DEFAULT NULL COMMENT '左保留总数',
  `rightKeep` bigint(10) DEFAULT NULL COMMENT '右保留总数',
  `eachPV` double(12,2) DEFAULT '100.00' COMMENT '每碰PV数，从数据字典表取，目前是100',
  `sumPairPV` double(12,2) DEFAULT NULL COMMENT '总碰PV数',
  `bonusRate` double(6,4) DEFAULT NULL COMMENT '奖金比率',
  `bonusPV` double(12,2) DEFAULT NULL COMMENT '对碰奖励PV',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户对碰记录表';

/*Data for the table `user_pair_201312` */

/*Table structure for table `user_pair_201405` */

DROP TABLE IF EXISTS `user_pair_201405`;

CREATE TABLE `user_pair_201405` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `date` date DEFAULT NULL COMMENT '对碰时间',
  `bonusUserId` bigint(20) DEFAULT NULL,
  `leftUserNum` bigint(10) DEFAULT NULL COMMENT '左用户总数',
  `rightUserNum` bigint(10) DEFAULT NULL COMMENT '左用户总数',
  `leftKeep` bigint(10) DEFAULT NULL COMMENT '左保留总数',
  `rightKeep` bigint(10) DEFAULT NULL COMMENT '左保留总数',
  `eachPV` double(12,2) DEFAULT '100.00' COMMENT '每碰PV数',
  `sumPairPV` double(12,2) DEFAULT NULL COMMENT '总碰PV数',
  `bonusRate` double(6,4) DEFAULT NULL COMMENT '奖金比率',
  `bonusPV` double(12,2) DEFAULT NULL COMMENT '对碰奖励PV',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user_pair_201405` */

/*Table structure for table `user_pair_201406` */

DROP TABLE IF EXISTS `user_pair_201406`;

CREATE TABLE `user_pair_201406` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `date` date DEFAULT NULL COMMENT '对碰时间',
  `bonusUserId` bigint(20) DEFAULT NULL,
  `leftUserNum` bigint(10) DEFAULT NULL COMMENT '左用户总数',
  `rightUserNum` bigint(10) DEFAULT NULL COMMENT '左用户总数',
  `leftKeep` bigint(10) DEFAULT NULL COMMENT '左保留总数',
  `rightKeep` bigint(10) DEFAULT NULL COMMENT '左保留总数',
  `eachPV` double(12,2) DEFAULT '100.00' COMMENT '每碰PV数',
  `sumPairPV` double(12,2) DEFAULT NULL COMMENT '总碰PV数',
  `bonusRate` double(6,4) DEFAULT NULL COMMENT '奖金比率',
  `bonusPV` double(12,2) DEFAULT NULL COMMENT '对碰奖励PV',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user_pair_201406` */

/*Table structure for table `user_place` */

DROP TABLE IF EXISTS `user_place`;

CREATE TABLE `user_place` (
  `placeId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'PLACE_ID',
  `code` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '安置编号',
  `totalCode` text COLLATE utf8_unicode_ci COMMENT '完整编号',
  `depth` bigint(20) DEFAULT NULL COMMENT '安置层数',
  `isLeaf` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '是否叶子',
  `userId` bigint(20) DEFAULT NULL COMMENT '被安置用户id',
  `parentId` bigint(20) DEFAULT NULL COMMENT '上级用户Id',
  `bonusUserId` bigint(20) DEFAULT NULL COMMENT '拿奖金用户ID',
  `buyPV` decimal(12,4) DEFAULT NULL COMMENT '消费PV',
  `bonusRate` decimal(6,4) DEFAULT NULL COMMENT '奖金比率',
  `bonusPV` decimal(12,4) DEFAULT NULL COMMENT '安置奖励PV',
  `placeTime` time DEFAULT NULL COMMENT '安置时间',
  PRIMARY KEY (`placeId`)
) ENGINE=MyISAM AUTO_INCREMENT=86 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户安置记录表';

/*Data for the table `user_place` */

insert  into `user_place`(`placeId`,`code`,`totalCode`,`depth`,`isLeaf`,`userId`,`parentId`,`bonusUserId`,`buyPV`,`bonusRate`,`bonusPV`,`placeTime`) values (2,NULL,NULL,NULL,NULL,77,NULL,2,'300.0000','0.0050','1.5000','22:29:17'),(3,NULL,NULL,NULL,NULL,77,NULL,73,'300.0000','0.0050','1.5000','22:29:23'),(4,NULL,NULL,NULL,NULL,77,NULL,76,'300.0000','0.0050','1.5000','22:29:26'),(5,NULL,NULL,NULL,NULL,78,NULL,2,'300.0000','0.0050','1.5000','17:54:40'),(6,NULL,NULL,NULL,NULL,79,NULL,2,'300.0000','0.0050','1.5000','18:24:59'),(7,NULL,NULL,NULL,NULL,79,NULL,78,'300.0000','0.0050','1.5000','18:24:59'),(8,NULL,NULL,NULL,NULL,79,NULL,2,'300.0000','0.0050','1.5000','08:04:42'),(9,NULL,NULL,NULL,NULL,77,NULL,2,'300.0000','0.0050','1.5000','17:23:39'),(10,NULL,NULL,NULL,NULL,77,NULL,79,'300.0000','0.0050','1.5000','17:23:39'),(11,NULL,NULL,NULL,NULL,77,NULL,2,'300.0000','0.0050','1.5000','17:29:40'),(12,NULL,NULL,NULL,NULL,79,NULL,2,'300.0000','0.0050','1.5000','17:40:51'),(13,NULL,NULL,NULL,NULL,79,NULL,73,'300.0000','0.0050','1.5000','17:40:52'),(14,NULL,NULL,NULL,NULL,79,NULL,76,'300.0000','0.0050','1.5000','17:40:52'),(15,NULL,NULL,NULL,NULL,77,NULL,2,'300.0000','0.0050','1.5000','17:43:45'),(16,NULL,NULL,NULL,NULL,77,NULL,73,'300.0000','0.0050','1.5000','17:43:45'),(17,NULL,NULL,NULL,NULL,77,NULL,76,'300.0000','0.0050','1.5000','17:43:45'),(18,NULL,NULL,NULL,NULL,79,NULL,2,'300.0000','0.0050','1.5000','17:52:23'),(19,NULL,NULL,NULL,NULL,79,NULL,73,'300.0000','0.0050','1.5000','17:52:23'),(20,NULL,NULL,NULL,NULL,79,NULL,76,'300.0000','0.0050','1.5000','17:52:23'),(21,NULL,NULL,NULL,NULL,79,NULL,2,'300.0000','0.0050','1.5000','17:53:50'),(22,NULL,NULL,NULL,NULL,79,NULL,73,'300.0000','0.0050','1.5000','17:53:50'),(23,NULL,NULL,NULL,NULL,79,NULL,76,'300.0000','0.0050','1.5000','17:53:50'),(24,NULL,NULL,NULL,NULL,76,NULL,2,'300.0000','0.0050','1.5000','18:04:20'),(25,NULL,NULL,NULL,NULL,73,NULL,2,'300.0000','0.0050','1.5000','18:08:40'),(26,NULL,NULL,NULL,NULL,73,NULL,76,'300.0000','0.0050','1.5000','18:08:40'),(27,NULL,NULL,NULL,NULL,77,NULL,2,'300.0000','0.0050','1.5000','18:10:01'),(28,NULL,NULL,NULL,NULL,77,NULL,73,'300.0000','0.0050','1.5000','18:10:01'),(29,NULL,NULL,NULL,NULL,77,NULL,76,'300.0000','0.0050','1.5000','18:10:01'),(30,NULL,NULL,NULL,NULL,79,NULL,2,'300.0000','0.0050','1.5000','18:15:59'),(31,NULL,NULL,NULL,NULL,76,NULL,2,'300.0000','0.0050','1.5000','18:38:44'),(32,NULL,NULL,NULL,NULL,73,NULL,2,'300.0000','0.0050','1.5000','18:55:12'),(33,NULL,NULL,NULL,NULL,73,NULL,76,'300.0000','0.0050','1.5000','18:55:12'),(34,NULL,NULL,NULL,NULL,77,NULL,2,'300.0000','0.0050','1.5000','19:01:05'),(35,NULL,NULL,NULL,NULL,77,NULL,73,'300.0000','0.0050','1.5000','19:01:05'),(36,NULL,NULL,NULL,NULL,77,NULL,76,'300.0000','0.0050','1.5000','19:01:05'),(37,NULL,NULL,NULL,NULL,79,NULL,2,'300.0000','0.0050','1.5000','19:20:24'),(38,NULL,NULL,NULL,NULL,79,NULL,73,'300.0000','0.0050','1.5000','19:20:24'),(39,NULL,NULL,NULL,NULL,79,NULL,76,'300.0000','0.0050','1.5000','19:20:24'),(40,NULL,NULL,NULL,NULL,79,NULL,77,'300.0000','0.0050','1.5000','19:20:24'),(41,NULL,NULL,NULL,NULL,77,NULL,2,'300.0000','0.0050','1.5000','19:47:23'),(42,NULL,NULL,NULL,NULL,77,NULL,73,'300.0000','0.0050','1.5000','19:47:23'),(43,NULL,NULL,NULL,NULL,77,NULL,76,'300.0000','0.0050','1.5000','19:47:23'),(44,NULL,NULL,NULL,NULL,79,NULL,2,'300.0000','0.0050','1.5000','19:48:24'),(45,NULL,NULL,NULL,NULL,79,NULL,73,'300.0000','0.0050','1.5000','19:48:24'),(46,NULL,NULL,NULL,NULL,79,NULL,76,'300.0000','0.0050','1.5000','19:48:24'),(47,NULL,NULL,NULL,NULL,79,NULL,77,'300.0000','0.0050','1.5000','19:48:24'),(48,NULL,NULL,NULL,NULL,77,NULL,2,'300.0000','0.0050','1.5000','19:54:19'),(49,NULL,NULL,NULL,NULL,77,NULL,73,'300.0000','0.0050','1.5000','19:54:19'),(50,NULL,NULL,NULL,NULL,77,NULL,76,'300.0000','0.0050','1.5000','19:54:19'),(51,NULL,NULL,NULL,NULL,79,NULL,2,'300.0000','0.0050','1.5000','19:54:49'),(52,NULL,NULL,NULL,NULL,79,NULL,73,'300.0000','0.0050','1.5000','19:54:49'),(53,NULL,NULL,NULL,NULL,79,NULL,76,'300.0000','0.0050','1.5000','19:54:49'),(54,NULL,NULL,NULL,NULL,79,NULL,77,'300.0000','0.0050','1.5000','19:54:49'),(55,NULL,NULL,NULL,NULL,79,NULL,2,'300.0000','0.0050','1.5000','20:02:14'),(56,NULL,NULL,NULL,NULL,79,NULL,73,'300.0000','0.0050','1.5000','20:02:14'),(57,NULL,NULL,NULL,NULL,79,NULL,76,'300.0000','0.0050','1.5000','20:02:14'),(58,NULL,NULL,NULL,NULL,79,NULL,77,'300.0000','0.0050','1.5000','20:02:14'),(59,NULL,NULL,NULL,NULL,79,NULL,2,'300.0000','0.0050','1.5000','20:26:05'),(60,NULL,NULL,NULL,NULL,79,NULL,73,'300.0000','0.0050','1.5000','20:26:05'),(61,NULL,NULL,NULL,NULL,79,NULL,76,'300.0000','0.0050','1.5000','20:26:05'),(62,NULL,NULL,NULL,NULL,79,NULL,77,'300.0000','0.0050','1.5000','20:26:05'),(63,NULL,NULL,NULL,NULL,79,NULL,2,'300.0000','0.0050','1.5000','20:39:46'),(64,NULL,NULL,NULL,NULL,79,NULL,73,'300.0000','0.0050','1.5000','20:39:46'),(65,NULL,NULL,NULL,NULL,79,NULL,76,'300.0000','0.0050','1.5000','20:39:46'),(66,NULL,NULL,NULL,NULL,79,NULL,77,'300.0000','0.0050','1.5000','20:39:46'),(67,NULL,NULL,NULL,NULL,79,NULL,2,'300.0000','0.0050','1.5000','20:41:24'),(68,NULL,NULL,NULL,NULL,79,NULL,73,'300.0000','0.0050','1.5000','20:41:24'),(69,NULL,NULL,NULL,NULL,79,NULL,76,'300.0000','0.0050','1.5000','20:41:24'),(70,NULL,NULL,NULL,NULL,79,NULL,77,'300.0000','0.0050','1.5000','20:41:24'),(71,NULL,NULL,NULL,NULL,79,NULL,2,'300.0000','0.0050','1.5000','20:44:35'),(72,NULL,NULL,NULL,NULL,79,NULL,73,'300.0000','0.0050','1.5000','20:44:35'),(73,NULL,NULL,NULL,NULL,79,NULL,76,'300.0000','0.0050','1.5000','20:44:35'),(74,NULL,NULL,NULL,NULL,79,NULL,77,'300.0000','0.0050','1.5000','20:44:35'),(75,NULL,NULL,NULL,NULL,79,NULL,2,'300.0000','0.0050','1.5000','20:47:10'),(76,NULL,NULL,NULL,NULL,79,NULL,73,'300.0000','0.0050','1.5000','20:47:10'),(77,NULL,NULL,NULL,NULL,79,NULL,76,'300.0000','0.0050','1.5000','20:47:10'),(78,NULL,NULL,NULL,NULL,79,NULL,77,'300.0000','0.0050','1.5000','20:47:10'),(79,NULL,NULL,NULL,NULL,73,NULL,2,'300.0000','0.0050','1.5000','20:51:20'),(80,NULL,NULL,NULL,NULL,76,NULL,2,'300.0000','0.0050','1.5000','20:52:01'),(81,NULL,NULL,NULL,NULL,76,NULL,73,'300.0000','0.0050','1.5000','20:52:01'),(82,NULL,NULL,NULL,NULL,77,NULL,2,'300.0000','0.0050','1.5000','20:52:30'),(83,NULL,NULL,NULL,NULL,79,NULL,2,'300.0000','0.0050','1.5000','20:53:16'),(84,NULL,NULL,NULL,NULL,79,NULL,73,'300.0000','0.0050','1.5000','20:53:16'),(85,NULL,NULL,NULL,NULL,79,NULL,76,'300.0000','0.0050','1.5000','20:53:16');

/*Table structure for table `user_point` */

DROP TABLE IF EXISTS `user_point`;

CREATE TABLE `user_point` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'POINT_ID',
  `buyTime` date DEFAULT NULL COMMENT '消费时间',
  `bonusUserId` bigint(20) DEFAULT NULL COMMENT '拿奖金用户ID',
  `userId` bigint(20) DEFAULT NULL COMMENT '积分消费用户ID',
  `buyPV` double(12,2) DEFAULT NULL COMMENT '消费PV',
  `bonusRate` double(6,4) DEFAULT NULL COMMENT '奖金比率',
  `bonusPV` double(12,2) NOT NULL COMMENT '奖励PV',
  PRIMARY KEY (`id`,`bonusPV`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户积分消费奖励记录表';

/*Data for the table `user_point` */

/*Table structure for table `user_point_goods` */

DROP TABLE IF EXISTS `user_point_goods`;

CREATE TABLE `user_point_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'POINT_GOODS_ID',
  `pickTime` date DEFAULT NULL COMMENT '领货时间',
  `userId` bigint(20) DEFAULT NULL COMMENT '积分消费用户ID',
  `buyPV` double(12,2) DEFAULT NULL COMMENT '消费PV',
  `orderId` bigint(20) DEFAULT NULL COMMENT '订单ID',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户积分领货记录表';

/*Data for the table `user_point_goods` */

/*Table structure for table `user_recharge` */

DROP TABLE IF EXISTS `user_recharge`;

CREATE TABLE `user_recharge` (
  `rechargeId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `rechargeTime` date DEFAULT NULL COMMENT '充值时间',
  `rechargeNum` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '充值单号',
  `userId` bigint(20) DEFAULT NULL,
  `currency` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '充值货币',
  `rechargeMoney` decimal(12,2) DEFAULT NULL COMMENT '充值金额',
  `note` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '摘要备注',
  `creditedMoney` decimal(12,2) DEFAULT NULL COMMENT '到账金额',
  `creditedTime` date DEFAULT NULL COMMENT '到账时间',
  `auditUser` bigint(20) DEFAULT NULL COMMENT '审核人',
  `pvRate` decimal(6,4) DEFAULT NULL COMMENT 'PV比率',
  `pv` decimal(12,2) DEFAULT NULL COMMENT '兑换后PV值',
  `bankName` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '充值银行名',
  `bankAccount` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '充值账号名',
  `platform` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '充值平台',
  `param` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '充值接口参数',
  `rechargeType` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '充值状态',
  PRIMARY KEY (`rechargeId`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户汇款充值记录表';

/*Data for the table `user_recharge` */

insert  into `user_recharge`(`rechargeId`,`rechargeTime`,`rechargeNum`,`userId`,`currency`,`rechargeMoney`,`note`,`creditedMoney`,`creditedTime`,`auditUser`,`pvRate`,`pv`,`bankName`,`bankAccount`,`platform`,`param`,`rechargeType`) values (1,'2014-04-16','1211111111111',2,NULL,'50.00',NULL,NULL,NULL,NULL,NULL,NULL,'中国银行','2222222222',NULL,NULL,NULL),(2,'2014-04-16','1211111111111',2,NULL,'50.00',NULL,NULL,NULL,NULL,NULL,NULL,'民生银行','33333333333333',NULL,NULL,NULL),(3,'2014-04-16','1211111111111',2,NULL,'50.00',NULL,NULL,NULL,NULL,NULL,NULL,'光大银行','444444444444',NULL,NULL,NULL),(4,'2014-04-17','13977239348713',2,'CNY','111.00','111','0.00',NULL,0,'0.0000','0.00',NULL,NULL,NULL,NULL,NULL),(5,'2014-04-23','13977250549151',2,'CNY','11.00','11','0.00',NULL,0,'0.0000','0.00',NULL,NULL,NULL,NULL,NULL),(6,'2014-04-23','13977250549151',2,'CNY','11.00','11','0.00',NULL,0,'0.0000','0.00',NULL,NULL,NULL,NULL,NULL),(7,'2014-04-23','13977250549151',2,'CNY','11.00','11','0.00',NULL,0,'0.0000','0.00',NULL,NULL,NULL,NULL,NULL),(8,'2014-04-23','13977250549151',2,'CNY','11.00','11','0.00',NULL,0,'0.0000','0.00',NULL,NULL,NULL,NULL,NULL),(9,'2014-04-23','13977250549151',2,'CNY','11.00','11','0.00',NULL,0,'0.0000','0.00',NULL,NULL,NULL,NULL,NULL),(10,'2014-04-23','13977250549151',2,'CNY','11.00','11','0.00',NULL,0,'0.0000','0.00',NULL,NULL,NULL,NULL,NULL),(11,'2014-04-23','13977250549151',2,'CNY','11.00','11','0.00',NULL,0,'0.0000','0.00',NULL,NULL,NULL,NULL,NULL),(12,'2014-04-17','13977254385950',2,'CNY','1111.00','11','0.00',NULL,0,'0.0000','0.00',NULL,NULL,NULL,NULL,NULL),(13,'2014-04-17','13977254385950',2,'CNY','1111.00','11','0.00',NULL,0,'0.0000','0.00',NULL,NULL,NULL,NULL,NULL),(14,'2014-04-23','13977999111770',2,'CNY','111.00','11','0.00',NULL,0,'0.0000','0.00',NULL,NULL,NULL,NULL,NULL),(15,'2014-04-18','13978011913411',2,'CNY','11.00','1','0.00',NULL,0,'0.0000','0.00',NULL,NULL,NULL,NULL,NULL),(16,'2014-04-18','13978016105972',2,'CNY','1111.00','11','0.00',NULL,0,'0.0000','0.00',NULL,NULL,NULL,NULL,NULL),(17,'2014-04-18','13978053772791',2,'CNY','1111.00','1','0.00',NULL,0,'0.0000','0.00',NULL,NULL,NULL,NULL,NULL),(18,'2014-04-22','13981568543761',2,'CNY','11.00','1','0.00',NULL,0,'0.0000','0.00',NULL,NULL,NULL,NULL,NULL),(19,'2014-04-22','13981568543761',2,'CNY','11.00','1','0.00',NULL,0,'0.0000','0.00',NULL,NULL,NULL,NULL,NULL),(20,'2014-04-24','13983268995870',2,'CNY','111.00','11','0.00',NULL,0,'0.0000','0.00',NULL,NULL,NULL,NULL,NULL),(21,'2014-04-24','13983273602522',2,'CNY','111.00','a','0.00',NULL,0,'0.0000','0.00',NULL,NULL,NULL,NULL,NULL),(22,NULL,NULL,2,'CNY','0.00',NULL,'0.00',NULL,0,'0.0000','0.00',NULL,NULL,NULL,NULL,NULL),(23,'2014-04-24','13983274352334',2,'CNY','11.00','1','0.00',NULL,0,'0.0000','0.00',NULL,NULL,NULL,NULL,NULL),(24,'2014-04-24','13983287252271',2,'CNY','1111.00','1','0.00',NULL,0,'0.0000','0.00',NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `user_refer` */

DROP TABLE IF EXISTS `user_refer`;

CREATE TABLE `user_refer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'REFER_LOG_ID',
  `referTime` date DEFAULT NULL COMMENT '推荐时间',
  `userId` bigint(20) DEFAULT NULL COMMENT '被推荐人ID',
  `userName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `referUserId` bigint(32) DEFAULT NULL COMMENT '推荐人ID',
  `referUserName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `buyPV` decimal(12,2) DEFAULT NULL COMMENT '消费PV',
  `bonusRate` decimal(6,4) DEFAULT NULL COMMENT '奖金比率',
  `bonusPV` decimal(12,2) DEFAULT NULL COMMENT '推荐奖励PV',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户推荐记录表';

/*Data for the table `user_refer` */

insert  into `user_refer`(`id`,`referTime`,`userId`,`userName`,`referUserId`,`referUserName`,`buyPV`,`bonusRate`,`bonusPV`) values (22,'2014-05-17',77,NULL,2,NULL,'300.00','0.0500','15.00'),(20,'2014-05-17',73,NULL,2,NULL,'300.00','0.0500','15.00'),(21,'2014-05-17',76,NULL,2,NULL,'300.00','0.0500','15.00'),(23,'2014-05-17',78,NULL,2,NULL,'300.00','0.0500','15.00'),(24,'2014-05-28',79,NULL,2,NULL,'300.00','0.0500','15.00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
