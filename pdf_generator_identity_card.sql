CREATE DATABASE  IF NOT EXISTS `pdf_generator` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `pdf_generator`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: pdf_generator
-- ------------------------------------------------------
-- Server version	5.5.62

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
-- Table structure for table `identity_card`
--

DROP TABLE IF EXISTS `identity_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `identity_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `place_of_birthday` varchar(45) DEFAULT NULL,
  `date_of_birthday` datetime DEFAULT NULL,
  `date_of_expiry` datetime DEFAULT NULL,
  `date_of_issue` datetime DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `issued_by` varchar(45) DEFAULT NULL,
  `nationality` varchar(45) DEFAULT NULL,
  `personal_number` bigint(20) DEFAULT NULL,
  `residence` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `identity_card`
--

LOCK TABLES `identity_card` WRITE;
/*!40000 ALTER TABLE `identity_card` DISABLE KEYS */;
INSERT INTO `identity_card` VALUES (1,'Lendrit','Shala','Vushtrri','1995-12-08 23:59:59','2022-09-27 23:59:59','2017-09-17 23:59:59','M','Mia','Kosovar',1234902870,'Akrashtica'),(2,'Muzafer','Shala','Vushtrri','1976-03-04 00:00:00','2020-03-05 00:00:00','2020-03-02 00:00:00','M','MUP','Kosovar',4523465123,'Fushe Kosove'),(3,'Mendim','Mustafa','Prishtine','1991-12-12 00:00:00','2020-02-04 00:00:00','2020-09-10 00:00:00','M','Mia','Shqiptar',1253453245,'Matiqan '),(4,'Labrion','Zebica','Kaqanik','1998-04-04 00:00:00','2020-03-03 00:00:00','2020-09-09 00:00:00','M','Mia','Kosovar',5673456732,'Golem'),(5,'Fisnik','Ademi','Gjilan','1995-12-12 00:00:00','2020-02-02 00:00:00','2020-02-02 00:00:00','M','MUP','Shqiptar',5345231456,'Lepenc');
/*!40000 ALTER TABLE `identity_card` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-07 15:45:02
