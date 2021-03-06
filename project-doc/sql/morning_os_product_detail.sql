-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: morning
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `os_product_detail`
--

DROP TABLE IF EXISTS `os_product_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `os_product_detail` (
  `product_detail_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品描述ID',
  `product_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `description` text COMMENT '商品描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`product_detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商品描述表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `os_product_detail`
--

LOCK TABLES `os_product_detail` WRITE;
/*!40000 ALTER TABLE `os_product_detail` DISABLE KEYS */;
INSERT INTO `os_product_detail` VALUES (1,1,'<p><img alt=\"\" data-src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_01.jpg\" src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_01.jpg\"> <img alt=\"\" data-src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_03.jpg\" src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_03.jpg\"> <img alt=\"\" data-src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_05.jpg\" src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_05.jpg\"> <img alt=\"\" data-src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_07.jpg\" src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_07.jpg\"> <img alt=\"\" data-src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_09.jpg\"> <img alt=\"\" data-src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_11.jpg\"> <img alt=\"\" data-src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_13.jpg\"> <img alt=\"\" data-src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_15.jpg\"> <img alt=\"\" data-src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_17.jpg\"> <img alt=\"\" data-src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_19.jpg\"> <img alt=\"\" data-src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_21.jpg\"> <img alt=\"\" data-src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_23.jpg\"> <img alt=\"\" data-src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_25.jpg\"> <img alt=\"\" data-src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_27.jpg\"> <img alt=\"\" data-src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_29.jpg\"> <img alt=\"\" data-src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_31.jpg\"> <img alt=\"\" data-src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_33.jpg\"> <img alt=\"\" data-src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_35.jpg\"> <img alt=\"\" data-src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_37.jpg\"> <img alt=\"\" data-src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_39.jpg\"> <img alt=\"\" data-src=\"//c1.mifile.cn/f/i/g/2015/cn-index/U1xingzhen_41.jpg\"></p>','2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米');
/*!40000 ALTER TABLE `os_product_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-07 20:02:11
