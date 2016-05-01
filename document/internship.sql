-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: internship
-- ------------------------------------------------------
-- Server version	5.6.28-log

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
-- Table structure for table `case_library`
--

DROP TABLE IF EXISTS `case_library`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `case_library` (
  `caseLibraryId` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `filePath` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `stuCaseLibrary` bit(1) DEFAULT NULL,
  `tchCaseLibrary` bit(1) DEFAULT NULL,
  `courseId` int(11) NOT NULL,
  PRIMARY KEY (`caseLibraryId`),
  KEY `FK_2vlt43etuwg65w915uk2hsekf` (`courseId`),
  CONSTRAINT `FK_2vlt43etuwg65w915uk2hsekf` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `case_library`
--

LOCK TABLES `case_library` WRITE;
/*!40000 ALTER TABLE `case_library` DISABLE KEYS */;
INSERT INTO `case_library` VALUES (1,'2014-01-01',NULL,'移动开发技术第一章.ppt',NULL,NULL,1),(2,'2014-01-02',NULL,'移动开发技术第二章.ppt',NULL,NULL,1),(3,'2014-01-03',NULL,'移动开发技术第三章.ppt',NULL,NULL,1);
/*!40000 ALTER TABLE `case_library` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `courseId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `teacherId` int(11) NOT NULL,
  `courseDate` varchar(255) DEFAULT NULL,
  `coursePlace` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`courseId`),
  KEY `FK_tn5xxerkw82ii7pwadnuc60s4` (`teacherId`),
  CONSTRAINT `FK_tn5xxerkw82ii7pwadnuc60s4` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`teacherId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'移动技术开发',1,'周一下午5、6节','1教401'),(2,'Linux嵌入式系统',1,'周四上午1、2节','软院717'),(3,'软件工程',2,'周二上午3、4节','3教501'),(4,'计算机网络',2,'周三上午1、2节','1教401');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homework`
--

DROP TABLE IF EXISTS `homework`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `homework` (
  `homeworkId` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `studentId` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`homeworkId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homework`
--

LOCK TABLES `homework` WRITE;
/*!40000 ALTER TABLE `homework` DISABLE KEYS */;
INSERT INTO `homework` VALUES (1,1,'2014-05-05','D:\\workspace\\eclipseEE\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\internship\\upload\\数据表修改.docx',1,'数据表修改.docx'),(2,1,'2014-05-05','D:\\workspace\\eclipseEE\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\internship\\upload\\数据表修改2.docx',2,'数据表修改2.docx');
/*!40000 ALTER TABLE `homework` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `studentId` int(11) NOT NULL AUTO_INCREMENT,
  `classes` varchar(24) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  `name` varchar(24) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `phone` varchar(24) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `sno` varchar(24) DEFAULT NULL,
  `userType` int(11) DEFAULT NULL,
  PRIMARY KEY (`studentId`),
  UNIQUE KEY `UK_cxffpo742xolsmubc0erwwf9m` (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'801',NULL,2014,'孟晗','mh','15001185667',1,'S201425057',1),(2,NULL,NULL,NULL,'孟同学','mtx',NULL,NULL,'10080108',1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_course`
--

DROP TABLE IF EXISTS `student_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_course` (
  `courseId` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`studentId`,`courseId`),
  KEY `FK_t45vpfbqbh56bh3u7d4ppoopg` (`courseId`),
  CONSTRAINT `FK_pt5bwh1wp3fn0d5cr677p211f` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`),
  CONSTRAINT `FK_t45vpfbqbh56bh3u7d4ppoopg` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_course`
--

LOCK TABLES `student_course` WRITE;
/*!40000 ALTER TABLE `student_course` DISABLE KEYS */;
INSERT INTO `student_course` VALUES (1,1,85),(2,1,70),(3,1,93),(1,2,NULL),(4,2,NULL);
/*!40000 ALTER TABLE `student_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `syslog`
--

DROP TABLE IF EXISTS `syslog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `syslog` (
  `syslogId` int(11) NOT NULL AUTO_INCREMENT,
  `behavior` varchar(100) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `name` varchar(24) DEFAULT NULL,
  `no` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`syslogId`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `syslog`
--

LOCK TABLES `syslog` WRITE;
/*!40000 ALTER TABLE `syslog` DISABLE KEYS */;
INSERT INTO `syslog` VALUES (1,'登陆了','2016-04-28 15:21:10','孟同学','10080108'),(2,'登陆了','2016-04-28 15:40:04','孟同学','10080108'),(3,'登陆了','2016-04-28 17:04:22','孟晗','S201425057'),(4,'登陆了','2016-04-28 17:17:37','孟晗','S201425057'),(5,'登陆了','2016-04-28 19:09:26','孟晗','S201425057'),(6,'登陆了','2016-04-28 19:15:56','孟晗','S201425057'),(7,'登陆了','2016-04-28 19:17:28','孟晗','S201425057'),(8,'登陆了','2016-04-28 19:28:05','孟晗','S201425057'),(9,'登陆了','2016-04-28 19:32:55','孟同学','10080108'),(10,'登陆了','2016-04-28 19:35:49','孟晗','S201425057'),(11,'登陆了','2016-04-28 19:37:31','孟同学','10080108'),(12,'登陆了','2016-04-28 19:39:03','孟晗','S201425057'),(13,'登陆了','2016-04-28 19:40:24','孟晗','S201425057'),(14,'登陆了','2016-04-28 19:41:05','孟晗','S201425057'),(15,'登陆了','2016-04-28 19:43:42','孟晗','S201425057'),(16,'登陆了','2016-04-28 19:47:06','孟晗','S201425057'),(17,'登陆了','2016-04-28 19:49:29','孟晗','S201425057'),(18,'登陆了','2016-04-28 19:50:16','孟晗','S201425057'),(19,'登陆了','2016-04-28 21:43:40','孟晗','S201425057'),(20,'登陆了','2016-04-28 22:44:12','孟晗','S201425057'),(21,'登陆了','2016-04-29 11:05:06','孟晗','S201425057'),(22,'登陆了','2016-04-29 17:03:35','孟晗','S201425057'),(23,'登陆了','2016-04-29 17:05:14','孟晗','S201425057'),(24,'登陆了','2016-04-29 17:10:02','孟晗','S201425057'),(25,'登陆了','2016-04-29 17:14:12','孟晗','S201425057'),(26,'登陆了','2016-04-29 18:20:22','孟晗','S201425057'),(27,'登陆了','2016-04-29 19:06:32','孟晗','S201425057'),(28,'登陆了','2016-04-30 10:19:44','孟晗','S201425057'),(29,'注销了','2016-04-30 10:33:50','孟晗','S201425057'),(30,'注销了','2016-04-30 10:34:41','孟晗','S201425057'),(31,'注销了','2016-04-30 10:35:07','孟晗','S201425057'),(32,'注销了','2016-04-30 10:35:37','孟晗','S201425057'),(33,'注销了','2016-04-30 10:35:48','孟晗','S201425057'),(34,'注销了','2016-04-30 10:35:54','孟晗','S201425057'),(35,'注销了','2016-04-30 10:36:51','孟晗','S201425057'),(36,'注销了','2016-04-30 10:37:16','孟晗','S201425057'),(37,'注销了','2016-04-30 10:37:55','孟晗','S201425057'),(38,'注销了','2016-04-30 10:38:23','孟晗','S201425057'),(39,'登陆了','2016-04-30 11:53:57',NULL,NULL),(40,'登陆了','2016-04-30 11:54:34','孟晗','S201425057'),(41,'登陆了','2016-04-30 12:21:24','谌云莉','T2014'),(42,'登陆了','2016-04-30 12:24:43','谌云莉','T2014'),(43,'登陆了','2016-04-30 12:29:59','谌云莉','T2014'),(44,'登陆了','2016-04-30 12:36:08','谌云莉','T2014'),(45,'登陆了','2016-04-30 12:41:35','谌云莉','T2014'),(46,'注销了','2016-04-30 12:41:47','谌云莉','T2014'),(47,'登陆了','2016-04-30 12:41:54','孟晗','S201425057'),(48,'注销了','2016-04-30 12:42:07','孟晗','S201425057'),(49,'登陆了','2016-04-30 15:43:40','谌云莉','T2014'),(50,'登陆了','2016-04-30 15:59:29','谌云莉','T2014'),(51,'登陆了','2016-04-30 17:15:13','谌云莉','T2014'),(52,'登陆了','2016-04-30 17:18:53','谌云莉','T2014'),(53,'登陆了','2016-04-30 18:00:38','谌云莉','T2014'),(54,'登陆了','2016-04-30 18:04:06','谌云莉','T2014'),(55,'登陆了','2016-04-30 18:05:15','谌云莉','T2014'),(56,'登陆了','2016-04-30 18:16:13','谌云莉','T2014'),(57,'注销了','2016-04-30 18:20:56','谌云莉','T2014'),(58,'登陆了','2016-04-30 18:21:04','孟晗','S201425057'),(59,'注销了','2016-04-30 18:24:19','孟晗','S201425057'),(60,'登陆了','2016-04-30 18:24:26','谌云莉','T2014'),(61,'登陆了','2016-04-30 18:56:50','谌云莉','T2014'),(62,'登陆了','2016-04-30 20:28:48','谌云莉','T2014'),(63,'登陆了','2016-04-30 20:31:04','孟晗','S201425057'),(64,'注销了','2016-04-30 20:32:22','孟晗','S201425057'),(65,'登陆了','2016-04-30 20:33:17','谌云莉','T2014'),(66,'注销了','2016-04-30 20:33:42','谌云莉','T2014'),(67,'登陆了','2016-05-01 09:52:52','谌云莉','T2014'),(68,'注销了','2016-05-01 09:53:03','谌云莉','T2014'),(69,'登陆了','2016-05-01 09:53:11','孟同学','10080108'),(70,'注销了','2016-05-01 09:53:23','孟同学','10080108');
/*!40000 ALTER TABLE `syslog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `teacherId` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `name` varchar(24) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `phone` varchar(24) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `tno` varchar(24) DEFAULT NULL,
  `userType` int(11) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`teacherId`),
  UNIQUE KEY `UK_d49gchwugshiu3qlhlxrwxd4m` (`tno`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,NULL,'谌云莉','cyl',NULL,2,'T2014',2,'无线网络','副教授'),(2,NULL,'谌老师','cls',NULL,NULL,'T2010',2,NULL,NULL);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-01  9:56:35
