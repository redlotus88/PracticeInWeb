-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: piw
-- ------------------------------------------------------
-- Server version	5.7.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `piw_security_login_info`
--

DROP TABLE IF EXISTS `piw_security_login_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `piw_security_login_info` (
  `serial` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) DEFAULT NULL,
  `login_ip` varchar(20) DEFAULT NULL,
  `datetime` timestamp NULL DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL COMMENT '0表示登录，1表示登出',
  PRIMARY KEY (`serial`),
  UNIQUE KEY `serail_UNIQUE` (`serial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piw_security_login_info`
--

LOCK TABLES `piw_security_login_info` WRITE;
/*!40000 ALTER TABLE `piw_security_login_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `piw_security_login_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piw_usermgr_account`
--

DROP TABLE IF EXISTS `piw_usermgr_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `piw_usermgr_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(16) NOT NULL,
  `password` varchar(255) NOT NULL DEFAULT '1qaz2wsx',
  `salt` varchar(64) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`account_name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piw_usermgr_account`
--

LOCK TABLES `piw_usermgr_account` WRITE;
/*!40000 ALTER TABLE `piw_usermgr_account` DISABLE KEYS */;
INSERT INTO `piw_usermgr_account` VALUES (1,'Rean','14ecd5cdaffd4fbdca83fcd1d7b564dd','7d8e68c72c99c65803b3f5c65ad2a095','2017-07-03 06:58:24','2017-07-04 10:40:05'),(2,'Alisa','97644c3ce2c768d3858754d164cdbb4f','d9dc10faa706d93ae7e9cafc3718e06f','2017-07-03 06:58:24','2017-07-03 09:38:42'),(3,'Eliot','b52176aa9c3b3bec36a09a44b8923641','05e67f6fee9a15c2a7c907b9818e68b2','2017-07-03 06:58:24','2017-07-03 06:58:44'),(4,'Rean_Wang','77934ee1364d0f8576d79a29f723d169','eecc321855b8c1ceef840670be57f6ea','2017-07-03 06:58:24','2017-07-03 06:58:44'),(5,'wang','09220156e9f51008af978729e3277f9c','e44b9adf3e07f0a919d4461a1ca9c738','2017-07-03 06:58:24','2017-07-03 06:58:44'),(6,'A_VERY_LONG_NAME','6d6e12aeaf33b98a6270d668e1e018b9','c6ecca3e3620db146fefefb09d5c6347','2017-07-05 07:59:49','2017-07-05 08:04:36');
/*!40000 ALTER TABLE `piw_usermgr_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piw_usermgr_account_profile`
--

DROP TABLE IF EXISTS `piw_usermgr_account_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `piw_usermgr_account_profile` (
  `account_id` int(11) NOT NULL,
  `profile_name` varchar(16) NOT NULL,
  `public_email` varchar(50) DEFAULT NULL,
  `company` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piw_usermgr_account_profile`
--

LOCK TABLES `piw_usermgr_account_profile` WRITE;
/*!40000 ALTER TABLE `piw_usermgr_account_profile` DISABLE KEYS */;
INSERT INTO `piw_usermgr_account_profile` VALUES (1,'Dragon_Wang','jialong.wang@newtouch.cn','Newtouch Co.TTT'),(6,'A_VERY_LONG_NAME','A_VERY_LONG_EMAIL_ADDRESSS@newtouch.cn','A_VERY_VERY_VERY_VERY_VERY_LONG_COMPANY NAME');
/*!40000 ALTER TABLE `piw_usermgr_account_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piw_usermgr_account_role`
--

DROP TABLE IF EXISTS `piw_usermgr_account_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `piw_usermgr_account_role` (
  `account_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`account_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piw_usermgr_account_role`
--

LOCK TABLES `piw_usermgr_account_role` WRITE;
/*!40000 ALTER TABLE `piw_usermgr_account_role` DISABLE KEYS */;
INSERT INTO `piw_usermgr_account_role` VALUES (1,1),(2,2),(3,2),(4,1),(6,1);
/*!40000 ALTER TABLE `piw_usermgr_account_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piw_usermgr_permission`
--

DROP TABLE IF EXISTS `piw_usermgr_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `piw_usermgr_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piw_usermgr_permission`
--

LOCK TABLES `piw_usermgr_permission` WRITE;
/*!40000 ALTER TABLE `piw_usermgr_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `piw_usermgr_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piw_usermgr_role`
--

DROP TABLE IF EXISTS `piw_usermgr_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `piw_usermgr_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL,
  `description` varchar(100) DEFAULT '""',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piw_usermgr_role`
--

LOCK TABLES `piw_usermgr_role` WRITE;
/*!40000 ALTER TABLE `piw_usermgr_role` DISABLE KEYS */;
INSERT INTO `piw_usermgr_role` VALUES (1,'admin','Adminstrator Role 1'),(2,'user','User Role 1');
/*!40000 ALTER TABLE `piw_usermgr_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piw_usermgr_role_permission`
--

DROP TABLE IF EXISTS `piw_usermgr_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `piw_usermgr_role_permission` (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piw_usermgr_role_permission`
--

LOCK TABLES `piw_usermgr_role_permission` WRITE;
/*!40000 ALTER TABLE `piw_usermgr_role_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `piw_usermgr_role_permission` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-10 13:50:27
