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
  `create_time` timestamp(6) NULL DEFAULT NULL,
  `last_modify_time` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`account_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piw_usermgr_account`
--

LOCK TABLES `piw_usermgr_account` WRITE;
/*!40000 ALTER TABLE `piw_usermgr_account` DISABLE KEYS */;
INSERT INTO `piw_usermgr_account` VALUES (1,'Rean','1qaz2wsx',NULL,NULL,NULL),(2,'Alisa','1qaz2wsx',NULL,NULL,NULL),(3,'Eliot','1qaz2wsx',NULL,NULL,NULL),(4,'Rean_Wang','28865f16b81b1898c7d192671635f72e','f5c5d0f823527e45f71eb6f5719ef08d','2017-06-01 09:32:29.815000',NULL);
/*!40000 ALTER TABLE `piw_usermgr_account` ENABLE KEYS */;
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
INSERT INTO `piw_usermgr_account_role` VALUES (1,1),(2,2),(3,2),(4,1);
/*!40000 ALTER TABLE `piw_usermgr_account_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piw_usermgr_role`
--

DROP TABLE IF EXISTS `piw_usermgr_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `piw_usermgr_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `description` varchar(100) DEFAULT '""',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piw_usermgr_role`
--

LOCK TABLES `piw_usermgr_role` WRITE;
/*!40000 ALTER TABLE `piw_usermgr_role` DISABLE KEYS */;
INSERT INTO `piw_usermgr_role` VALUES (1,'ADMIN_ROLE_1','Adminstrator Role 1'),(2,'USER_ROLE_1','User Role 1');
/*!40000 ALTER TABLE `piw_usermgr_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-02 16:33:48
