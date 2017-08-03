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
  `record_time` timestamp NULL DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL COMMENT '0表示登录，1表示登出',
  PRIMARY KEY (`serial`),
  UNIQUE KEY `serail_UNIQUE` (`serial`)
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piw_security_login_info`
--

LOCK TABLES `piw_security_login_info` WRITE;
/*!40000 ALTER TABLE `piw_security_login_info` DISABLE KEYS */;
INSERT INTO `piw_security_login_info` VALUES (51,1,'0:0:0:0:0:0:0:1','2017-07-20 07:48:56',0),(52,1,'0:0:0:0:0:0:0:1','2017-07-20 07:50:38',0),(53,1,'0:0:0:0:0:0:0:1','2017-07-20 08:31:24',0),(54,1,'0:0:0:0:0:0:0:1','2017-07-20 08:33:50',0),(55,1,'0:0:0:0:0:0:0:1','2017-07-20 08:40:08',0),(56,1,'0:0:0:0:0:0:0:1','2017-07-20 08:45:04',0),(57,1,'0:0:0:0:0:0:0:1','2017-07-20 08:45:32',0),(58,1,'0:0:0:0:0:0:0:1','2017-07-20 08:50:10',0),(59,1,'0:0:0:0:0:0:0:1','2017-07-20 09:00:04',0),(60,1,'0:0:0:0:0:0:0:1','2017-07-20 09:22:16',0),(61,1,'0:0:0:0:0:0:0:1','2017-07-20 09:23:56',0),(62,1,'0:0:0:0:0:0:0:1','2017-07-20 09:33:53',0),(63,1,'0:0:0:0:0:0:0:1','2017-07-20 09:56:38',0),(64,1,'0:0:0:0:0:0:0:1','2017-07-20 09:59:05',0),(65,1,'0:0:0:0:0:0:0:1','2017-07-20 10:00:01',0),(66,1,'0:0:0:0:0:0:0:1','2017-07-20 10:16:20',0),(67,1,'0:0:0:0:0:0:0:1','2017-07-20 11:04:35',0),(68,1,'0:0:0:0:0:0:0:1','2017-07-20 11:15:38',0),(69,1,'0:0:0:0:0:0:0:1','2017-07-26 06:42:36',0),(70,1,'0:0:0:0:0:0:0:1','2017-07-26 06:55:35',0),(71,1,'0:0:0:0:0:0:0:1','2017-07-26 07:22:40',0),(72,1,'0:0:0:0:0:0:0:1','2017-07-26 07:36:17',0),(73,1,'0:0:0:0:0:0:0:1','2017-07-26 08:20:40',0),(74,1,'0:0:0:0:0:0:0:1','2017-07-26 08:23:11',0),(75,1,'0:0:0:0:0:0:0:1','2017-07-26 08:34:48',0),(76,1,'0:0:0:0:0:0:0:1','2017-07-26 08:38:23',0),(77,1,'0:0:0:0:0:0:0:1','2017-07-26 08:47:51',0),(78,1,'0:0:0:0:0:0:0:1','2017-07-26 08:49:15',0),(79,1,'0:0:0:0:0:0:0:1','2017-07-26 08:49:40',0),(80,1,'0:0:0:0:0:0:0:1','2017-07-26 08:53:18',0),(81,1,'0:0:0:0:0:0:0:1','2017-07-26 08:54:35',0),(82,1,'0:0:0:0:0:0:0:1','2017-07-26 08:55:47',0),(83,1,'0:0:0:0:0:0:0:1','2017-07-26 08:56:44',0),(84,1,'0:0:0:0:0:0:0:1','2017-07-26 08:57:22',0),(85,1,'0:0:0:0:0:0:0:1','2017-07-26 08:58:46',0),(86,1,'0:0:0:0:0:0:0:1','2017-07-26 09:00:15',0),(87,1,'0:0:0:0:0:0:0:1','2017-07-26 09:01:50',0),(88,1,'0:0:0:0:0:0:0:1','2017-07-26 09:02:58',0),(89,1,'0:0:0:0:0:0:0:1','2017-07-26 09:11:37',0),(90,1,'0:0:0:0:0:0:0:1','2017-07-26 09:14:03',0),(91,1,'0:0:0:0:0:0:0:1','2017-07-26 09:22:13',0),(92,1,'0:0:0:0:0:0:0:1','2017-07-26 09:24:32',0),(93,1,'0:0:0:0:0:0:0:1','2017-07-26 09:36:58',0),(94,1,'0:0:0:0:0:0:0:1','2017-07-27 07:12:38',0),(95,1,'0:0:0:0:0:0:0:1','2017-07-27 07:16:10',0),(96,1,'0:0:0:0:0:0:0:1','2017-07-27 07:28:50',0),(97,1,'0:0:0:0:0:0:0:1','2017-07-27 07:45:51',0),(98,1,'0:0:0:0:0:0:0:1','2017-07-27 08:11:54',0),(99,1,'0:0:0:0:0:0:0:1','2017-07-27 09:35:14',0),(100,1,'0:0:0:0:0:0:0:1','2017-07-27 09:37:10',0),(101,1,'0:0:0:0:0:0:0:1','2017-07-27 09:38:04',0),(102,1,'0:0:0:0:0:0:0:1','2017-07-27 09:42:21',0),(103,1,'0:0:0:0:0:0:0:1','2017-07-27 09:49:23',0),(104,1,'0:0:0:0:0:0:0:1','2017-07-27 09:50:14',0),(105,1,'0:0:0:0:0:0:0:1','2017-07-28 03:01:32',0),(106,1,'0:0:0:0:0:0:0:1','2017-07-28 03:10:11',0),(107,1,'0:0:0:0:0:0:0:1','2017-07-28 05:10:37',0),(108,1,'0:0:0:0:0:0:0:1','2017-07-28 05:14:14',0),(109,1,'0:0:0:0:0:0:0:1','2017-07-28 05:18:34',0),(110,1,'0:0:0:0:0:0:0:1','2017-07-28 05:50:54',0),(111,1,'0:0:0:0:0:0:0:1','2017-07-28 05:52:03',0),(112,1,'0:0:0:0:0:0:0:1','2017-07-28 05:53:05',0),(113,1,'0:0:0:0:0:0:0:1','2017-07-28 05:54:15',0),(114,1,'0:0:0:0:0:0:0:1','2017-07-28 05:54:15',0),(115,1,'0:0:0:0:0:0:0:1','2017-07-28 05:54:15',0),(116,1,'0:0:0:0:0:0:0:1','2017-07-28 05:55:00',0),(117,1,'0:0:0:0:0:0:0:1','2017-07-28 05:59:43',0),(118,1,'0:0:0:0:0:0:0:1','2017-07-28 06:02:03',0),(119,1,'0:0:0:0:0:0:0:1','2017-07-28 06:05:55',0),(120,1,'0:0:0:0:0:0:0:1','2017-07-28 06:36:27',0),(121,1,'0:0:0:0:0:0:0:1','2017-07-28 06:37:03',0),(122,1,'0:0:0:0:0:0:0:1','2017-07-28 06:39:27',0),(123,1,'0:0:0:0:0:0:0:1','2017-07-28 06:41:01',0),(124,1,'0:0:0:0:0:0:0:1','2017-07-28 06:42:40',0),(125,1,'0:0:0:0:0:0:0:1','2017-07-28 06:45:29',0),(126,1,'0:0:0:0:0:0:0:1','2017-07-28 06:49:20',0),(127,1,'0:0:0:0:0:0:0:1','2017-07-28 07:12:26',0),(128,1,'0:0:0:0:0:0:0:1','2017-07-28 07:23:49',0),(129,1,'0:0:0:0:0:0:0:1','2017-07-28 07:31:20',0),(130,1,'0:0:0:0:0:0:0:1','2017-07-28 07:38:39',0),(131,1,'0:0:0:0:0:0:0:1','2017-08-02 06:23:43',0),(132,1,'0:0:0:0:0:0:0:1','2017-08-02 06:24:54',0),(133,1,'0:0:0:0:0:0:0:1','2017-08-02 06:25:52',0),(134,1,'0:0:0:0:0:0:0:1','2017-08-02 06:26:13',0),(135,1,'0:0:0:0:0:0:0:1','2017-08-03 02:11:24',0),(136,1,'0:0:0:0:0:0:0:1','2017-08-03 06:07:16',0),(137,1,'0:0:0:0:0:0:0:1','2017-08-03 07:28:37',0);
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
INSERT INTO `piw_usermgr_account` VALUES (1,'Rean','14ecd5cdaffd4fbdca83fcd1d7b564dd','7d8e68c72c99c65803b3f5c65ad2a095','2017-07-03 06:58:24','2017-07-04 10:40:05'),(2,'Alisa','97644c3ce2c768d3858754d164cdbb4f','d9dc10faa706d93ae7e9cafc3718e06f','2017-07-03 06:58:24','2017-07-03 09:38:42'),(6,'A_VERY_LONG_NAME','6d6e12aeaf33b98a6270d668e1e018b9','c6ecca3e3620db146fefefb09d5c6347','2017-07-05 07:59:49','2017-07-05 08:04:36');
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
  PRIMARY KEY (`account_id`,`role_id`),
  KEY `idx_account_role_account_id` (`account_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piw_usermgr_account_role`
--

LOCK TABLES `piw_usermgr_account_role` WRITE;
/*!40000 ALTER TABLE `piw_usermgr_account_role` DISABLE KEYS */;
INSERT INTO `piw_usermgr_account_role` VALUES (1,1),(2,2),(3,2),(4,1),(6,3),(19,1),(20,2),(21,3),(22,3);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piw_usermgr_role`
--

LOCK TABLES `piw_usermgr_role` WRITE;
/*!40000 ALTER TABLE `piw_usermgr_role` DISABLE KEYS */;
INSERT INTO `piw_usermgr_role` VALUES (1,'admin','Adminstrator Role 1'),(2,'user','User Role 1'),(3,'guest','Guest Role 1'),(4,'admin_test','Administrator Test Role');
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

-- Dump completed on 2017-08-03 15:31:00
