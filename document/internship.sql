-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: internship
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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `userType` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'123',1,'admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carousel_figure`
--

DROP TABLE IF EXISTS `carousel_figure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carousel_figure` (
  `carouselFigureId` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `date` date DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `pictureName` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`carouselFigureId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carousel_figure`
--

LOCK TABLES `carousel_figure` WRITE;
/*!40000 ALTER TABLE `carousel_figure` DISABLE KEYS */;
/*!40000 ALTER TABLE `carousel_figure` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `case_library`
--

LOCK TABLES `case_library` WRITE;
/*!40000 ALTER TABLE `case_library` DISABLE KEYS */;
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
  `courseDate` varchar(255) DEFAULT NULL,
  `coursePlace` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `teacherId` int(11) DEFAULT NULL,
  PRIMARY KEY (`courseId`),
  KEY `FK_tn5xxerkw82ii7pwadnuc60s4` (`teacherId`),
  CONSTRAINT `FK_tn5xxerkw82ii7pwadnuc60s4` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`teacherId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (4,'周一下午','软院718','嵌入式开发',11),(5,'周二上午','一教418','计算机网络',12),(6,'周二下午','一教418','数据结构',13),(7,'周三上午','信东102','软件项目管理',14);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment`
--

DROP TABLE IF EXISTS `equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipment` (
  `equipmentId` int(11) NOT NULL AUTO_INCREMENT,
  `eno` varchar(255) DEFAULT NULL,
  `lendDate` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `owner` varchar(255) DEFAULT NULL,
  `people` varchar(255) DEFAULT NULL,
  `returnDate` date DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `teacherId` int(11) DEFAULT NULL,
  `isHistory` bit(1) DEFAULT NULL,
  PRIMARY KEY (`equipmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment`
--

LOCK TABLES `equipment` WRITE;
/*!40000 ALTER TABLE `equipment` DISABLE KEYS */;
INSERT INTO `equipment` VALUES (24,'T1010','2016-01-30','arm板子','谌云莉','孟晗','2016-01-04','借出',10,NULL),(25,'T1011',NULL,'xp主机','谌云莉',NULL,NULL,NULL,10,NULL),(26,'S2010','2016-01-25','蓝牙接收器','李永','孟晗','2016-01-01','借出',11,NULL),(27,'X2012',NULL,'X86板子','谌云莉',NULL,NULL,NULL,10,NULL),(28,'Z1050',NULL,'VR设备','阎长顺',NULL,NULL,NULL,14,NULL),(29,'G5824',NULL,'WIN7主机','谌云莉',NULL,NULL,NULL,10,NULL);
/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment_history`
--

DROP TABLE IF EXISTS `equipment_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipment_history` (
  `equipmentHistoryId` int(11) NOT NULL AUTO_INCREMENT,
  `eno` varchar(255) DEFAULT NULL,
  `equipmentId` int(11) DEFAULT NULL,
  `isDeleted` bit(1) DEFAULT NULL,
  `lendDate` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `owner` varchar(255) DEFAULT NULL,
  `people` varchar(255) DEFAULT NULL,
  `returnDate` date DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `ownerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`equipmentHistoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment_history`
--

LOCK TABLES `equipment_history` WRITE;
/*!40000 ALTER TABLE `equipment_history` DISABLE KEYS */;
INSERT INTO `equipment_history` VALUES (20,'T1010',24,'\0','2016-01-30','arm板子','谌云莉','孟晗','2016-01-04','借出',10),(21,'S2010',26,'\0','2016-01-25','蓝牙接收器','李永','孟晗','2016-01-01','借出',11);
/*!40000 ALTER TABLE `equipment_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `graduation_pro_sele`
--

DROP TABLE IF EXISTS `graduation_pro_sele`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `graduation_pro_sele` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `GraduationProTitle` varchar(1000) DEFAULT NULL,
  `sno` varchar(24) DEFAULT NULL,
  `tno` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_bxun13oony350nk0n2m0ji1kf` (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `graduation_pro_sele`
--

LOCK TABLES `graduation_pro_sele` WRITE;
/*!40000 ALTER TABLE `graduation_pro_sele` DISABLE KEYS */;
INSERT INTO `graduation_pro_sele` VALUES (7,'三维模型处理','S201425057','T201401'),(8,'Linux嵌入式操作信息内核研究','S201425058','T201402'),(9,'网络舆情分析','S201425059','T201403'),(10,'中文分词处理','S201425060','T201404'),(11,'SVM算法优化','S201425061','T201405'),(12,'深度学习算法综述研究','S201425062','T201401'),(13,'蓝牙信息数据采集分析','S201425063','T201402'),(15,'TIRE树性能分析与提高策略','S201425064','T201403'),(16,'Arduino设计','S201425065','T201401'),(17,'基于SVM的人体亚健康分析','S201425066','T201402'),(18,'设备故障检测','S201425067','T201402'),(19,'5G传输','S201425068','T201402'),(20,'特征选择算法优化','S201425069','T201402'),(21,'Web系统开发','S201425070','T201402');
/*!40000 ALTER TABLE `graduation_pro_sele` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `graduation_weekly_report`
--

DROP TABLE IF EXISTS `graduation_weekly_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `graduation_weekly_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `date` datetime DEFAULT NULL,
  `sno` varchar(24) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `graduation_weekly_report`
--

LOCK TABLES `graduation_weekly_report` WRITE;
/*!40000 ALTER TABLE `graduation_weekly_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `graduation_weekly_report` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homework`
--

LOCK TABLES `homework` WRITE;
/*!40000 ALTER TABLE `homework` DISABLE KEYS */;
INSERT INTO `homework` VALUES (2,3,'2016-05-30','/upload/homework/S201425058/',12,'Android开发作业.docx'),(3,5,'2016-05-30','/upload/homework/S201425058/',12,'计算机网络作业.docx'),(4,6,'2016-05-30','/upload/homework/S201425058/',12,'数据结构作业.docx'),(5,3,'2016-05-30','/upload/homework/S201425057/',11,'Android开发作业.docx'),(6,5,'2016-05-30','/upload/homework/S201425057/',11,'计算机网络作业.docx'),(7,6,'2016-05-30','/upload/homework/S201425057/',11,'数据结构作业.docx');
/*!40000 ALTER TABLE `homework` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `internship_detail`
--

DROP TABLE IF EXISTS `internship_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `internship_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_address` varchar(100) DEFAULT NULL,
  `company_name` varchar(100) DEFAULT NULL,
  `company_teacher` varchar(100) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `sno` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_dsr0l69of46xjvk8xey7yd3gd` (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `internship_detail`
--

LOCK TABLES `internship_detail` WRITE;
/*!40000 ALTER TABLE `internship_detail` DISABLE KEYS */;
INSERT INTO `internship_detail` VALUES (2,'海淀','百度','谌云莉','2016-05-21 00:00:00',78,'S201425057'),(3,'广州','淘宝','谌云莉','2016-05-06 00:00:00',79,'S201425058'),(4,'深圳','联通','李永','2016-05-21 00:00:00',78,'S201425059'),(5,'海淀区','百度','Sam','2016-06-20 00:00:00',79,'S201425017'),(6,'西城区','移动','Tonny','2016-06-20 00:00:00',79,'S201425013'),(7,'朝阳区','IBM','谌云莉','2016-06-20 00:00:00',80,'S201425012'),(8,'海淀区','中科院软件研究所','李永','2016-06-23 00:00:00',82,'S201425001'),(9,'海淀区','电信','张三','2016-06-20 00:00:00',82,'S201425002'),(10,'杭州','阿里巴巴','Lee','2016-06-20 00:00:00',82,'S201425003'),(12,'海淀','新浪','谌云莉','2016-06-06 00:00:00',88,'S201425004'),(13,'海淀','搜狐','李永','2016-06-01 00:00:00',85,'S201425005'),(14,'海淀五路居','政协报','Cheney','2016-06-06 00:00:00',70,'S201425007'),(15,'知春路','今日头条','Sunny','2016-06-06 00:00:00',79,'S201425008'),(16,'知春路','腾讯视频','马化腾','2016-06-06 00:00:00',78,'S201425006'),(17,'海淀','水晶石','Tommy','2016-06-06 00:00:00',80,'S201425009'),(18,'海淀','腾讯','Tom','2016-06-06 00:00:00',89,'S201425010'),(19,'北京','Keep','Toto','2016-06-06 00:00:00',89,'S201425011');
/*!40000 ALTER TABLE `internship_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `internship_report`
--

DROP TABLE IF EXISTS `internship_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `internship_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL,
  `sno` varchar(24) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `internship_report`
--

LOCK TABLES `internship_report` WRITE;
/*!40000 ALTER TABLE `internship_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `internship_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice_board`
--

DROP TABLE IF EXISTS `notice_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice_board` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `date` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice_board`
--

LOCK TABLES `notice_board` WRITE;
/*!40000 ALTER TABLE `notice_board` DISABLE KEYS */;
INSERT INTO `notice_board` VALUES (10,'八届教代会提案工作专门委员会主任白志强作提案收集情况报告。本次会议期间共收到提案5件、意见建议7件，内容涉及制度建设与总体规划、人才队伍建设与人事制度、教育教学质量与教风建设、科学研究与科研管理、学生管理与学风建设、校园管理、福利待遇与教职工切身利益等相关工作。\r\n\r\n依据《北京工业大学教职工代表大会优秀提案奖、提案工作优秀代表组、提案承办先进单位评选办法》，教代会提案工作专门委员会对八届一次会议的提案进行了认真评选，经第八届教代会暨第十三届工代会主席团审议，决定表彰外语学院龚文静、承红等代表的提案《依托公共基础课学业辅导体系拓展公共基础课教师职业发展空间》为优秀提案，人事处、教务处、后勤保障处、保卫部（处）为优秀提案承办先进单位。','2016-05-30','北京工业大学第八届教职工代表大会暨第十三届工会会员代表大会第二次会议闭幕'),(11,'为培养和提高学生的创新精神、创业意识及创新创业能力，激发学生创新创业热情，营造良好校园创新创业氛围，为北工大大学生搭建创新创业教育平台，推动我校创新创业工作的全面发展，5月23-27日，北工大启动“北京工业大学首届创新创业宣传周”（以下简称双创宣传周）活动。本届宣传周主要有四项内容，包括创新创业校园文化展示、创新创业沙龙、创新创业公开课以及创新创业系列竞赛活动等。各项活动广泛利用微信、网络等线上平台，与线下路展、海报等同步宣传推广，开展了全方位、立体式的创新创业文化教育，打造具有北京工业大学特色的创新创业教育品牌活动。','2016-05-30','创无止境，业达天下——北工大举办创新创业宣传周'),(12,'为提高全校师生资源意识和主动节约意识，加快建设节约型高校，5月25日中午，北工大举办主题为“携手节能低碳，共建碧水蓝天”、“践行节能低碳，建设美丽家园”的2016年节能宣传周启动暨节能作品颁奖仪式。副校长刘建萍，后勤保障处、宣传部、研工部、国资处、基建修缮处、学工部等部门主要负责人及师生代表参加启动仪式。仪式由后勤保障处处长涂鸣主持。\r\n\r\n启动仪式上，涂鸣处长首先致辞。他指出，节约能源、资源是我国的一项基本国策，是利国利民关系子孙后代永续生存的大事，大力推进能源资源的节约，对促进经济可持续发展具有十分重要的意义。在学校领导及广大师生的支持与配合下，北工大高标准完成了国家下达的减排任务，获得多项荣誉。此次节能作品征集活动也受到了师生的欢迎，从作品数量、质量、参与人数上反映了师生参加节能活动的积极性和主动性。此外，涂鸣处长还对北工大下一步节能重点工作进行了部署。','2016-05-30','北工大举办2016年节能宣传周启动暨节能作品颁奖仪式'),(13,'“读书与人生”微访谈环节，由国际交流合作处处长吴文英主持，本期访谈嘉宾有人事处处长、博士生导师乔俊飞，校档案馆馆长李娟，建规学院书记、博士生导师杨昌鸣，都柏林学院院长、博士生导师刘中良，外籍专家 Professor Peter King。访谈现场，五位受邀嘉宾结合个人的读书历程，对吴文英教授提出的 “为什么读、读什么、怎么读”的问题从不同角度做了回答与阐释。乔俊飞教授说“因好奇而读，因职业需求而读，因自我提升而读”；李娟教授说“阅读是一种生活方式，是读者与作者的一场对话，看不同的书，就是在和不同的人聊天”；杨昌鸣教授以自己青年时期的读书经历，生动再现了读书在他的人生历程中所留下的曼妙回忆；刘中良教授表示“书能带给我们知识、信息，激发你对生命终极问题的思考，我们需要读不同的书来获取一个人生活所需的各种知识。一本好书背后必然是一个好的作者，所以作者是你衡量一本书是否值得去读的重要标准”；Peter King教授说“Reading makes me busy and active. Read the books that you are interested in, the author that is thoughtful, the subject that your life needs”。五位教授为大家推荐了最近读的一本好书。嘉宾的精彩回答，让现场观众深受启发，热烈的掌声一阵又一阵响起。','2016-05-30','图书馆举行“读书与人生”微访谈 2016图书馆月闭幕');
/*!40000 ALTER TABLE `notice_board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recruit_info`
--

DROP TABLE IF EXISTS `recruit_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recruit_info` (
  `recruitInfoId` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `date` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`recruitInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recruit_info`
--

LOCK TABLES `recruit_info` WRITE;
/*!40000 ALTER TABLE `recruit_info` DISABLE KEYS */;
INSERT INTO `recruit_info` VALUES (9,'岗位职责：\r\n1.    Eclipse集成开发环境的维护与开发。在Eclipse框架基础上开发插件，实现对当前Eclipse的功能增强；\r\n2.    熟悉GDB调试方法，了解调试原理；\r\n2.   相关的技术调研、文档编写、编码和自动化测试。\r\n \r\n岗位要求：\r\n1.   计算机相关专业本科及以上；\r\n2.   具有Java、数据结构等方面的基础知识；\r\n3.   英文阅读能力出色，能无障碍阅读英文技术资料；\r\n4.   优秀的学习能力、较强的责任心、沟通能力以及团队合作意识。','2016-05-30','Java开发工程师实习生'),(10,'1. 负责乐视云商业化 IaaS 产品的研发构建。\r\n2. 负责云服务相关组建、模块的研发，包含用户系统、计费系统及运维自动化系统，Web端产品及其API。\r\n3. 与技术团队紧密合作，整合各业务系统，把控服务质量，确保产品的可用性和易用性。\r\n\r\n职位要求\r\n\r\n1. 熟悉Python开发语言及周边开源项目。\r\n2. 大型 Web 应用系统设计与开发经验。\r\n3. 对数据结构和算法设计有深刻的理解。\r\n4. 对分布式系统有深刻的理解。\r\n5. 对计算机网络知识有深刻的理解。\r\n6. 了解主流云服务框架，例如 openstack/kubernetes/mesos等。\r\n7. 了解数据库技术，例如 mysql/postgresql/mongodb/redis/cassandra/elasticsearch等。\r\n','2016-05-30','Python, JAVA开发工程师'),(11,'岗位职责： \r\n1、完成部门布置的研发任务； \r\n2、完成领导分配的其他任务。 \r\n\r\n任职资格： \r\n1、2017届大学本科及以上学历，计算机或者相关专业； \r\n2、熟悉Java开发语言，且熟练使用SQL指令 \r\n3、有良好的口头及书面表达能力，有较强的逻辑思维能力、学习和适应能力； \r\n4、工作责任心强，具备良好的团队合作精神，较强的沟通、协作能力； \r\n5、从事过ERP软件、物流、仓储等系统开发者优先。','2016-05-30','Java开发实习生（2017届）'),(12,'职位描述\r\n1.       熟悉python或者java一门开发语言\r\n2.       熟悉windows服务器维护工作\r\n3.       熟悉使用Wireshark抓包工具，并能分析网络协议\r\n4.       具有良好的学习能力、沟通能力和合作精神，强烈的责任心与主动性\r\n截止日期\r\n2016-06-07','2016-05-30','技术运维实习生(JAVA)'),(13,'职位描述\r\n工作职责：\r\n1.基础系统架构、模块研发；\r\n2.公共基础库维护；\r\n3.海量数据处理；\r\n4.数据系统优化。\r\n\r\n工作要求：\r\n1.1年及以上的开发经验，有一定的抗压能力，能独立解决问题；\r\n2.熟练使用Golang/C/C++/Java/Python/PHP等一种或以上语言；\r\n3.熟悉基于TCP/UDP/HTTP协议的网络编程；\r\n4.熟悉Linux下编程和操作经验，且相关的各类技术情有独钟；\r\n5.熟练使用各种数据库存储，并且能够进行调；\r\n6.熟练使用各种团队协作工具（Wiki，Git，BugTracker）；\r\n7.有大规模、高性能互联网网站系统相关的设计和开发经验者优先。','2016-05-30','后端开发工程师');
/*!40000 ALTER TABLE `recruit_info` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (11,'2011',NULL,801,'孟晗1','S201425057',NULL,1,'S201425057',NULL),(12,'2011',NULL,801,'孟晗2','S201425058',NULL,1,'S201425058',NULL),(13,'2011',NULL,801,'孟晗3','S201425059',NULL,1,'S201425059',NULL),(14,'2011',NULL,801,'孟晗4','S201425060',NULL,1,'S201425060',NULL),(15,'2011',NULL,801,'孟晗5','S201425061',NULL,1,'S201425061',NULL),(16,'2011',NULL,801,'孟晗6','S201425062',NULL,1,'S201425062',NULL),(17,'2011',NULL,801,'孟晗7','S201425063',NULL,1,'S201425063',NULL),(18,'2011',NULL,801,'孟晗8','S201425064',NULL,1,'S201425064',NULL),(19,'2011',NULL,801,'孟晗9','S201425065',NULL,1,'S201425065',NULL),(20,'2011',NULL,801,'孟晗10','S201425066',NULL,1,'S201425066',NULL),(21,'2011',NULL,801,'孟晗11','S201425067',NULL,1,'S201425067',NULL),(22,'2011',NULL,801,'孟晗12','S201425068',NULL,1,'S201425068',NULL),(23,'2011',NULL,801,'孟晗13','S201425069',NULL,1,'S201425069',NULL),(24,'2011',NULL,801,'孟晗14','S201425070',NULL,1,'S201425070',NULL),(25,'2011',NULL,801,'孟晗15','S201425071',NULL,1,'S201425071',NULL),(26,'2011',NULL,801,'孟晗16','S201425072',NULL,1,'S201425072',NULL),(27,'2011',NULL,801,'孟晗17','S201425073',NULL,1,'S201425073',NULL),(28,'2011',NULL,801,'孟晗18','S201425074',NULL,1,'S201425074',NULL),(29,'2011',NULL,801,'孟晗19','S201425075',NULL,1,'S201425075',NULL),(30,'2011',NULL,801,'孟晗20','S201425076',NULL,1,'S201425076',NULL),(31,'2011',NULL,801,'孟晗21','S201425077',NULL,1,'S201425077',NULL),(32,'2011',NULL,801,'孟晗22','S201425078',NULL,1,'S201425078',NULL),(33,'2011',NULL,801,'孟晗23','S201425079',NULL,1,'S201425079',NULL),(34,'2011',NULL,801,'孟晗24','S201425080',NULL,1,'S201425080',NULL),(35,'2011',NULL,801,'孟晗25','S201425081',NULL,1,'S201425081',NULL),(36,'2011',NULL,801,'孟晗26','S201425082',NULL,1,'S201425082',NULL),(37,'2011',NULL,801,'孟晗27','S201425083',NULL,1,'S201425083',NULL),(38,'2011',NULL,801,'孟晗28','S201425084',NULL,1,'S201425084',NULL),(39,'2011',NULL,801,'孟晗29','S201425085',NULL,1,'S201425085',NULL),(40,'2011',NULL,801,'孟晗30','S201425086',NULL,1,'S201425086',NULL),(41,'2011',NULL,801,'孟晗31','S201425087',NULL,1,'S201425087',NULL),(42,'2011',NULL,801,'孟晗32','S201425088',NULL,1,'S201425088',NULL),(43,'2011',NULL,801,'孟晗33','S201425089',NULL,1,'S201425089',NULL),(44,'2011',NULL,801,'孟晗34','S201425090',NULL,1,'S201425090',NULL),(45,'2011',NULL,801,'孟晗35','S201425091',NULL,1,'S201425091',NULL),(46,'2011',NULL,801,'孟晗36','S201425092',NULL,1,'S201425092',NULL),(47,'2011',NULL,801,'孟晗37','S201425093',NULL,1,'S201425093',NULL),(48,'2011',NULL,801,'孟晗38','S201425094',NULL,1,'S201425094',NULL),(49,'2011',NULL,801,'孟晗39','S201425095',NULL,1,'S201425095',NULL);
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
INSERT INTO `student_course` VALUES (4,11,NULL),(5,11,NULL),(6,11,NULL),(7,11,NULL),(4,12,NULL),(5,12,NULL),(6,12,NULL),(7,12,NULL),(4,13,NULL),(5,13,NULL),(6,13,NULL),(7,13,NULL),(4,14,NULL),(5,14,NULL),(6,14,NULL),(7,14,NULL),(4,15,NULL),(5,15,NULL),(6,15,NULL),(7,15,NULL),(4,16,NULL),(5,16,NULL),(6,16,NULL),(7,16,NULL),(4,17,NULL),(5,17,NULL),(6,17,NULL),(7,17,NULL),(4,18,NULL),(5,18,NULL),(6,18,NULL),(7,18,NULL),(4,19,NULL),(5,19,NULL),(6,19,NULL),(7,19,NULL),(4,20,NULL),(5,20,NULL),(6,20,NULL),(7,20,NULL),(4,21,NULL),(5,21,NULL),(6,21,NULL),(7,21,NULL),(4,22,NULL),(5,22,NULL),(6,22,NULL),(7,22,NULL),(4,23,NULL),(5,23,NULL),(6,23,NULL),(7,23,NULL),(4,24,NULL),(5,24,NULL),(6,24,NULL),(7,24,NULL),(4,25,NULL),(5,25,NULL),(6,25,NULL),(7,25,NULL),(4,26,NULL),(5,26,NULL),(6,26,NULL),(7,26,NULL),(4,27,NULL),(5,27,NULL),(6,27,NULL),(7,27,NULL),(4,28,NULL),(5,28,NULL),(6,28,NULL),(7,28,NULL),(4,29,NULL),(5,29,NULL),(6,29,NULL),(7,29,NULL),(4,30,NULL),(5,30,NULL),(6,30,NULL),(7,30,NULL),(4,31,NULL),(5,31,NULL),(6,31,NULL),(7,31,NULL),(4,32,NULL),(5,32,NULL),(6,32,NULL),(7,32,NULL),(4,33,NULL),(5,33,NULL),(6,33,NULL),(7,33,NULL),(4,34,NULL),(5,34,NULL),(6,34,NULL),(7,34,NULL),(4,35,NULL),(5,35,NULL),(6,35,NULL),(7,35,NULL),(4,36,NULL),(5,36,NULL),(6,36,NULL),(7,36,NULL),(4,37,NULL),(5,37,NULL),(6,37,NULL),(7,37,NULL),(4,38,NULL),(5,38,NULL),(6,38,NULL),(7,38,NULL),(4,39,NULL),(5,39,NULL),(6,39,NULL),(7,39,NULL),(4,40,NULL),(5,40,NULL),(6,40,NULL),(7,40,NULL),(4,41,NULL),(5,41,NULL),(6,41,NULL),(7,41,NULL),(4,42,NULL),(5,42,NULL),(6,42,NULL),(7,42,NULL),(4,43,NULL),(5,43,NULL),(6,43,NULL),(7,43,NULL),(4,44,NULL),(5,44,NULL),(6,44,NULL),(7,44,NULL),(4,45,NULL),(5,45,NULL),(6,45,NULL),(7,45,NULL),(4,46,NULL),(5,46,NULL),(6,46,NULL),(7,46,NULL),(4,47,NULL),(5,47,NULL),(6,47,NULL),(7,47,NULL),(4,48,NULL),(5,48,NULL),(6,48,NULL),(7,48,NULL),(4,49,NULL),(5,49,NULL),(6,49,NULL),(7,49,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=603 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `syslog`
--

LOCK TABLES `syslog` WRITE;
/*!40000 ALTER TABLE `syslog` DISABLE KEYS */;
INSERT INTO `syslog` VALUES (161,'注销了','2016-05-19 23:10:11','孟老师','T2014'),(162,'登陆了','2016-05-19 23:10:20','孟老师','T2014'),(163,'注销了','2016-05-19 23:10:26','孟老师','T2014'),(164,'登陆了','2016-05-19 23:10:38','孟老师','T2014'),(165,'do nothing','2016-05-19 23:11:49','孟老师','T2014'),(166,'do nothing','2016-05-19 23:12:09','孟老师','T2014'),(167,'注销了','2016-05-19 23:12:20','孟老师','T2014'),(168,'登陆了','2016-05-20 11:41:11',NULL,NULL),(169,'do nothing','2016-05-20 11:41:29',NULL,NULL),(170,'登陆了','2016-05-20 12:44:10',NULL,NULL),(171,'do nothing','2016-05-20 12:44:22',NULL,NULL),(172,'do nothing','2016-05-20 12:44:34',NULL,NULL),(173,'do nothing','2016-05-20 12:44:37',NULL,NULL),(174,'do nothing','2016-05-20 12:44:45',NULL,NULL),(175,'注销了','2016-05-20 12:44:58',NULL,NULL),(176,'登陆了','2016-05-20 12:45:08','孟老师','T2014'),(177,'do nothing','2016-05-20 12:45:23','孟老师','T2014'),(178,'注销了','2016-05-20 12:45:32','孟老师','T2014'),(179,'登陆了','2016-05-21 20:35:35','孟老师','T2014'),(180,'注销了','2016-05-21 20:35:45','孟老师','T2014'),(181,'登陆了','2016-05-21 20:35:57','孟老师','T2014'),(182,'do nothing','2016-05-21 20:36:07','孟老师','T2014'),(183,'注销了','2016-05-21 20:36:10','孟老师','T2014'),(184,'登陆了','2016-05-21 20:36:17','孟老师','T2014'),(185,'上传了一个案例','2016-05-21 20:36:40','孟老师','T2014'),(186,'上传了一个案例','2016-05-21 20:38:02','孟老师','T2014'),(187,'上传了一个案例','2016-05-21 20:38:42','孟老师','T2014'),(188,'上传了一个案例','2016-05-21 20:39:04','孟老师','T2014'),(189,'上传了一个案例','2016-05-21 20:40:42','孟老师','T2014'),(190,'登陆了','2016-05-21 20:44:28','孟老师','T2014'),(191,'注销了','2016-05-21 20:44:34','孟老师','T2014'),(192,'登陆了','2016-05-21 20:44:46','孟老师','T2014'),(193,'登陆了','2016-05-21 20:45:07','孟晗','S201425057'),(194,'登陆了','2016-05-22 22:26:52',NULL,NULL),(195,'do nothing','2016-05-22 22:26:57',NULL,NULL),(196,'do nothing','2016-05-22 22:27:01',NULL,NULL),(197,'do nothing','2016-05-22 22:27:09',NULL,NULL),(198,'登陆了','2016-05-23 10:36:54',NULL,NULL),(199,'do nothing','2016-05-23 10:37:08',NULL,NULL),(200,'do nothing','2016-05-23 10:37:10',NULL,NULL),(201,'登陆了','2016-05-23 11:06:58',NULL,NULL),(202,'do nothing','2016-05-23 11:07:15',NULL,NULL),(203,'do nothing','2016-05-23 11:07:27',NULL,NULL),(204,'登陆了','2016-05-23 12:29:54',NULL,NULL),(205,'do nothing','2016-05-23 12:30:05',NULL,NULL),(206,'登陆了','2016-05-23 12:32:12',NULL,NULL),(207,'登陆了','2016-05-23 12:33:30',NULL,NULL),(208,'do nothing','2016-05-23 12:33:45',NULL,NULL),(209,'登陆了','2016-05-23 12:45:32',NULL,NULL),(210,'do nothing','2016-05-23 12:46:19',NULL,NULL),(211,'do nothing','2016-05-23 12:54:17',NULL,NULL),(212,'登陆了','2016-05-23 12:57:04',NULL,NULL),(213,'do nothing','2016-05-23 12:57:22',NULL,NULL),(214,'登陆了','2016-05-23 13:03:12',NULL,NULL),(215,'do nothing','2016-05-23 13:03:44',NULL,NULL),(216,'注销了','2016-05-23 13:04:31',NULL,NULL),(217,'登陆了','2016-05-23 13:49:16',NULL,NULL),(218,'do nothing','2016-05-23 13:52:05',NULL,NULL),(219,'do nothing','2016-05-23 13:55:26',NULL,NULL),(220,'do nothing','2016-05-23 13:56:56',NULL,NULL),(221,'注销了','2016-05-23 14:02:30',NULL,NULL),(222,'登陆了','2016-05-23 14:02:38','孟老师','T2014'),(223,'上传了一个案例','2016-05-23 14:03:14','孟老师','T2014'),(224,'注销了','2016-05-23 14:03:19','孟老师','T2014'),(225,'登陆了','2016-05-23 14:03:30','孟','S1111'),(226,'上传了作业','2016-05-23 14:03:49','孟','S1111'),(227,'注销了','2016-05-23 14:03:51','孟','S1111'),(228,'登陆了','2016-05-23 14:04:00','孟','S1111'),(229,'登陆了','2016-05-23 14:04:14','孟老师','T2014'),(230,'注销了','2016-05-23 14:04:34','孟老师','T2014'),(231,'登陆了','2016-05-23 14:04:43','孟老师','T2014'),(232,'do nothing','2016-05-23 14:05:02','孟老师','T2014'),(233,'do nothing','2016-05-23 14:05:14','孟老师','T2014'),(234,'注销了','2016-05-23 14:05:16','孟老师','T2014'),(235,'登陆了','2016-05-23 14:05:34','meng','T2010'),(236,'注销了','2016-05-23 14:06:43','meng','T2010'),(237,'登陆了','2016-05-23 15:10:51',NULL,NULL),(238,'登陆了','2016-05-23 15:19:16',NULL,NULL),(239,'注销了','2016-05-23 15:19:18',NULL,NULL),(240,'登陆了','2016-05-23 15:24:25',NULL,NULL),(241,'注销了','2016-05-23 15:24:30',NULL,NULL),(242,'登陆了','2016-05-23 15:26:02',NULL,NULL),(243,'注销了','2016-05-23 15:26:16',NULL,NULL),(244,'登陆了','2016-05-23 15:28:37',NULL,NULL),(245,'注销了','2016-05-23 15:28:41',NULL,NULL),(246,'登陆了','2016-05-23 15:35:55',NULL,NULL),(247,'注销了','2016-05-23 15:35:57',NULL,NULL),(248,'登陆了','2016-05-23 15:37:14',NULL,NULL),(249,'注销了','2016-05-23 15:37:17',NULL,NULL),(250,'登陆了','2016-05-23 15:37:27',NULL,NULL),(251,'do nothing','2016-05-23 15:37:41',NULL,NULL),(252,'注销了','2016-05-23 15:39:24',NULL,NULL),(253,'登陆了','2016-05-23 16:24:25',NULL,NULL),(254,'登陆了','2016-05-23 16:35:40',NULL,NULL),(255,'登陆了','2016-05-23 20:16:03',NULL,NULL),(256,'登陆了','2016-05-23 20:17:27',NULL,NULL),(257,'do nothing','2016-05-23 20:27:37',NULL,NULL),(258,'do nothing','2016-05-23 20:35:30',NULL,NULL),(259,'do nothing','2016-05-23 20:36:19',NULL,NULL),(260,'do nothing','2016-05-23 20:36:31',NULL,NULL),(261,'do nothing','2016-05-23 20:52:58',NULL,NULL),(262,'do nothing','2016-05-23 21:02:13',NULL,NULL),(263,'do nothing','2016-05-23 21:08:49',NULL,NULL),(264,'注销了','2016-05-23 21:09:11',NULL,NULL),(265,'登陆了','2016-05-28 15:33:51',NULL,NULL),(266,'登陆了','2016-05-28 16:03:06',NULL,NULL),(267,'登陆了','2016-05-28 16:10:42',NULL,NULL),(268,'do nothing','2016-05-28 16:11:06',NULL,NULL),(269,'do nothing','2016-05-28 16:11:15',NULL,NULL),(270,'do nothing','2016-05-28 16:14:59',NULL,NULL),(271,'do nothing','2016-05-28 16:20:37',NULL,NULL),(272,'do nothing','2016-05-28 16:20:59',NULL,NULL),(273,'do nothing','2016-05-28 16:21:20',NULL,NULL),(274,'do nothing','2016-05-28 16:21:26',NULL,NULL),(275,'登陆了','2016-05-28 16:33:34',NULL,NULL),(276,'do nothing','2016-05-28 16:34:21',NULL,NULL),(277,'do nothing','2016-05-28 16:34:40',NULL,NULL),(278,'do nothing','2016-05-28 16:35:17',NULL,NULL),(279,'登陆了','2016-05-28 16:52:37',NULL,NULL),(280,'do nothing','2016-05-28 16:53:01',NULL,NULL),(281,'do nothing','2016-05-28 16:53:14',NULL,NULL),(282,'do nothing','2016-05-28 16:53:29',NULL,NULL),(283,'登陆了','2016-05-28 16:55:48',NULL,NULL),(284,'do nothing','2016-05-28 16:55:57',NULL,NULL),(285,'do nothing','2016-05-28 16:56:12',NULL,NULL),(286,'do nothing','2016-05-28 16:56:28',NULL,NULL),(287,'do nothing','2016-05-28 16:56:31',NULL,NULL),(288,'登陆了','2016-05-28 17:01:41',NULL,NULL),(289,'do nothing','2016-05-28 17:01:50',NULL,NULL),(290,'do nothing','2016-05-28 17:01:56',NULL,NULL),(291,'do nothing','2016-05-28 17:02:03',NULL,NULL),(292,'do nothing','2016-05-28 17:02:11',NULL,NULL),(293,'do nothing','2016-05-28 17:02:11',NULL,NULL),(294,'do nothing','2016-05-28 17:02:11',NULL,NULL),(295,'do nothing','2016-05-28 17:03:52',NULL,NULL),(296,'登陆了','2016-05-28 18:09:48','孟老师','T2014'),(297,'do nothing','2016-05-28 18:10:12','孟老师','T2014'),(298,'do nothing','2016-05-28 18:10:26','孟老师','T2014'),(299,'登陆了','2016-05-28 18:21:00','孟老师','T2014'),(300,'do nothing','2016-05-28 18:21:51','孟老师','T2014'),(301,'登陆了','2016-05-28 18:23:14','孟老师','T2014'),(302,'登陆了','2016-05-28 18:28:48','孟老师','T2014'),(303,'do nothing','2016-05-28 18:29:46','孟老师','T2014'),(304,'登陆了','2016-05-28 18:32:15','孟老师','T2014'),(305,'do nothing','2016-05-28 18:32:42','孟老师','T2014'),(306,'登陆了','2016-05-28 18:36:19','孟老师','T2014'),(307,'do nothing','2016-05-28 18:36:33','孟老师','T2014'),(308,'do nothing','2016-05-28 18:36:49','孟老师','T2014'),(309,'do nothing','2016-05-28 18:36:55','孟老师','T2014'),(310,'do nothing','2016-05-28 18:36:59','孟老师','T2014'),(311,'do nothing','2016-05-28 18:37:01','孟老师','T2014'),(312,'登陆了','2016-05-28 18:39:18','孟老师','T2014'),(313,'do nothing','2016-05-28 18:39:51','孟老师','T2014'),(314,'do nothing','2016-05-28 18:39:59','孟老师','T2014'),(315,'do nothing','2016-05-28 18:40:11','孟老师','T2014'),(316,'do nothing','2016-05-28 18:40:13','孟老师','T2014'),(317,'登陆了','2016-05-28 18:54:49','孟老师','T2014'),(318,'do nothing','2016-05-28 18:55:19','孟老师','T2014'),(319,'do nothing','2016-05-28 18:55:25','孟老师','T2014'),(320,'do nothing','2016-05-28 18:55:31','孟老师','T2014'),(321,'do nothing','2016-05-28 18:55:50','孟老师','T2014'),(322,'do nothing','2016-05-28 18:57:05','孟老师','T2014'),(323,'do nothing','2016-05-28 18:57:32','孟老师','T2014'),(324,'do nothing','2016-05-28 18:57:57','孟老师','T2014'),(325,'do nothing','2016-05-28 18:58:12','孟老师','T2014'),(326,'登陆了','2016-05-28 19:01:34','孟老师','T2014'),(327,'do nothing','2016-05-28 19:02:00','孟老师','T2014'),(328,'do nothing','2016-05-28 19:02:06','孟老师','T2014'),(329,'do nothing','2016-05-28 19:02:15','孟老师','T2014'),(330,'do nothing','2016-05-28 19:03:31','孟老师','T2014'),(331,'登陆了','2016-05-28 19:05:38','孟老师','T2014'),(332,'do nothing','2016-05-28 19:05:49','孟老师','T2014'),(333,'do nothing','2016-05-28 19:06:05','孟老师','T2014'),(334,'do nothing','2016-05-28 19:06:12','孟老师','T2014'),(335,'do nothing','2016-05-28 19:06:17','孟老师','T2014'),(336,'do nothing','2016-05-28 19:06:17','孟老师','T2014'),(337,'do nothing','2016-05-28 19:06:17','孟老师','T2014'),(338,'do nothing','2016-05-28 19:06:23','孟老师','T2014'),(339,'do nothing','2016-05-28 19:06:24','孟老师','T2014'),(340,'do nothing','2016-05-28 19:06:42','孟老师','T2014'),(341,'登陆了','2016-05-28 19:11:42','孟老师','T2014'),(342,'登陆了','2016-05-28 19:12:06','孟老师','T2014'),(343,'登陆了','2016-05-30 08:57:23',NULL,NULL),(344,'do nothing','2016-05-30 08:57:50',NULL,NULL),(345,'do nothing','2016-05-30 08:57:52',NULL,NULL),(346,'do nothing','2016-05-30 08:57:52',NULL,NULL),(347,'do nothing','2016-05-30 08:57:55',NULL,NULL),(348,'do nothing','2016-05-30 09:05:52',NULL,NULL),(349,'do nothing','2016-05-30 09:05:54',NULL,NULL),(350,'do nothing','2016-05-30 09:06:06',NULL,NULL),(351,'do nothing','2016-05-30 09:06:15',NULL,NULL),(352,'do nothing','2016-05-30 09:06:29',NULL,NULL),(353,'do nothing','2016-05-30 09:06:38',NULL,NULL),(354,'do nothing','2016-05-30 09:06:38',NULL,NULL),(355,'do nothing','2016-05-30 09:06:38',NULL,NULL),(356,'do nothing','2016-05-30 09:06:40',NULL,NULL),(357,'登陆了','2016-05-30 09:07:50',NULL,NULL),(358,'do nothing','2016-05-30 09:07:59',NULL,NULL),(359,'登陆了','2016-05-30 09:09:02',NULL,NULL),(360,'登陆了','2016-05-30 09:09:24','孟老师','T2014'),(361,'do nothing','2016-05-30 09:09:35','孟老师','T2014'),(362,'登陆了','2016-05-30 09:11:24',NULL,NULL),(363,'登陆了','2016-05-30 09:11:37','孟老师','T2014'),(364,'登陆了','2016-05-30 09:12:50','孟老师','T2014'),(365,'登陆了','2016-05-30 09:14:56','孟老师','T2014'),(366,'登陆了','2016-05-30 09:17:21','孟老师','T2014'),(367,'do nothing','2016-05-30 09:17:28','孟老师','T2014'),(368,'登陆了','2016-05-30 09:17:48','孟老师','T2014'),(369,'do nothing','2016-05-30 09:18:08','孟老师','T2014'),(370,'do nothing','2016-05-30 09:18:15','孟老师','T2014'),(371,'do nothing','2016-05-30 09:18:15','孟老师','T2014'),(372,'do nothing','2016-05-30 09:18:15','孟老师','T2014'),(373,'do nothing','2016-05-30 09:18:46','孟老师','T2014'),(374,'登陆了','2016-05-30 09:33:06','孟老师','T2014'),(375,'登陆了','2016-05-30 09:35:20','孟老师','T2014'),(376,'登陆了','2016-05-30 09:36:19','孟老师','T2014'),(377,'注销了','2016-05-30 09:36:37','孟老师','T2014'),(378,'登陆了','2016-05-30 09:36:44','孟老师','T2014'),(379,'注销了','2016-05-30 09:36:56','孟老师','T2014'),(380,'登陆了','2016-05-30 09:37:04','孟老师','T2014'),(381,'do nothing','2016-05-30 09:37:19','孟老师','T2014'),(382,'do nothing','2016-05-30 09:43:46','孟老师','T2014'),(383,'登陆了','2016-05-30 09:49:15','孟老师','T2014'),(384,'登陆了','2016-05-30 09:52:58','孟老师','T2014'),(385,'登陆了','2016-05-30 09:53:28','孟老师','T2014'),(386,'登陆了','2016-05-30 10:50:55',NULL,NULL),(387,'登陆了','2016-05-30 11:05:52','孟老师','T2014'),(388,'注销了','2016-05-30 11:06:04','孟老师','T2014'),(389,'登陆了','2016-05-30 11:06:17','孟老师','T2014'),(390,'do nothing','2016-05-30 11:06:31','孟老师','T2014'),(391,'do nothing','2016-05-30 11:06:36','孟老师','T2014'),(392,'do nothing','2016-05-30 11:06:36','孟老师','T2014'),(393,'do nothing','2016-05-30 11:06:49','孟老师','T2014'),(394,'do nothing','2016-05-30 11:06:59','孟老师','T2014'),(395,'do nothing','2016-05-30 11:07:16','孟老师','T2014'),(396,'do nothing','2016-05-30 11:07:36','孟老师','T2014'),(397,'登陆了','2016-05-30 11:34:40','孟老师','T2014'),(398,'注销了','2016-05-30 11:36:20','孟老师','T2014'),(399,'登陆了','2016-05-30 11:36:32','孟老师','T2014'),(400,'登陆了','2016-05-30 11:37:01','孟老师','T2014'),(401,'do nothing','2016-05-30 11:39:31','孟老师','T2014'),(402,'do nothing','2016-05-30 11:45:55','孟老师','T2014'),(403,'do nothing','2016-05-30 11:50:49','孟老师','T2014'),(404,'do nothing','2016-05-30 11:50:52','孟老师','T2014'),(405,'登陆了','2016-05-30 11:55:11','孟老师','T2014'),(406,'do nothing','2016-05-30 11:56:15','孟老师','T2014'),(407,'do nothing','2016-05-30 11:56:33','孟老师','T2014'),(408,'do nothing','2016-05-30 11:56:52','孟老师','T2014'),(409,'登陆了','2016-05-30 11:59:07',NULL,NULL),(410,'do nothing','2016-05-30 11:59:23',NULL,NULL),(411,'登陆了','2016-05-30 12:02:48',NULL,NULL),(412,'do nothing','2016-05-30 12:03:05',NULL,NULL),(413,'登陆了','2016-05-30 12:13:29','孟老师','T2014'),(414,'do nothing','2016-05-30 12:13:40','孟老师','T2014'),(415,'注销了','2016-05-30 12:16:30','孟老师','T2014'),(416,'登陆了','2016-05-30 12:16:39','孟老师','T2014'),(417,'do nothing','2016-05-30 12:16:52','孟老师','T2014'),(418,'注销了','2016-05-30 12:16:58','孟老师','T2014'),(419,'登陆了','2016-05-30 12:17:06','孟老师','T2014'),(420,'do nothing','2016-05-30 12:18:30','孟老师','T2014'),(421,'登陆了','2016-05-30 12:59:32','孟老师','T2014'),(422,'do nothing','2016-05-30 12:59:37','孟老师','T2014'),(423,'do nothing','2016-05-30 12:59:39','孟老师','T2014'),(425,'登陆了','2016-05-30 13:00:09','孟老师','T2014'),(426,'下载了一份实习报告','2016-05-30 13:09:06','孟老师','T2014'),(427,'do nothing','2016-05-30 13:09:59','孟老师','T2014'),(428,'do nothing','2016-05-30 13:09:59','孟老师','T2014'),(429,'do nothing','2016-05-30 13:09:59','孟老师','T2014'),(430,'do nothing','2016-05-30 13:12:20','孟老师','T2014'),(431,'do nothing','2016-05-30 13:12:21','孟老师','T2014'),(432,'do nothing','2016-05-30 13:12:21','孟老师','T2014'),(433,'do nothing','2016-05-30 13:12:22','孟老师','T2014'),(434,'do nothing','2016-05-30 13:12:22','孟老师','T2014'),(435,'do nothing','2016-05-30 13:12:33','孟老师','T2014'),(436,'do nothing','2016-05-30 13:12:33','孟老师','T2014'),(437,'do nothing','2016-05-30 13:12:33','孟老师','T2014'),(438,'do nothing','2016-05-30 13:12:33','孟老师','T2014'),(439,'do nothing','2016-05-30 13:12:33','孟老师','T2014'),(440,'do nothing','2016-05-30 13:12:33','孟老师','T2014'),(441,'do nothing','2016-05-30 13:12:33','孟老师','T2014'),(442,'do nothing','2016-05-30 13:12:33','孟老师','T2014'),(443,'do nothing','2016-05-30 13:12:33','孟老师','T2014'),(444,'do nothing','2016-05-30 13:12:33','孟老师','T2014'),(445,'do nothing','2016-05-30 13:12:33','孟老师','T2014'),(446,'do nothing','2016-05-30 13:12:41','孟老师','T2014'),(447,'do nothing','2016-05-30 13:12:42','孟老师','T2014'),(448,'do nothing','2016-05-30 13:12:42','孟老师','T2014'),(449,'do nothing','2016-05-30 13:12:42','孟老师','T2014'),(450,'do nothing','2016-05-30 13:12:43','孟老师','T2014'),(451,'do nothing','2016-05-30 13:12:43','孟老师','T2014'),(452,'do nothing','2016-05-30 13:12:44','孟老师','T2014'),(453,'do nothing','2016-05-30 13:12:44','孟老师','T2014'),(454,'do nothing','2016-05-30 13:12:44','孟老师','T2014'),(455,'do nothing','2016-05-30 13:12:45','孟老师','T2014'),(456,'do nothing','2016-05-30 13:12:54','孟老师','T2014'),(457,'do nothing','2016-05-30 13:13:06','孟老师','T2014'),(458,'do nothing','2016-05-30 13:13:18','孟老师','T2014'),(459,'do nothing','2016-05-30 13:13:18','孟老师','T2014'),(461,'do nothing','2016-05-30 13:16:16','孟老师','T2014'),(462,'do nothing','2016-05-30 13:16:20','孟老师','T2014'),(463,'do nothing','2016-05-30 13:16:22','孟老师','T2014'),(464,'do nothing','2016-05-30 13:16:31','孟老师','T2014'),(466,'do nothing','2016-05-30 13:17:41','孟老师','T2014'),(467,'do nothing','2016-05-30 13:17:51','孟老师','T2014'),(468,'do nothing','2016-05-30 13:17:52','孟老师','T2014'),(469,'登陆了','2016-05-30 13:38:20',NULL,NULL),(470,'do nothing','2016-05-30 13:38:37',NULL,NULL),(471,'do nothing','2016-05-30 13:38:45',NULL,NULL),(472,'do nothing','2016-05-30 13:38:53',NULL,NULL),(473,'do nothing','2016-05-30 13:38:59',NULL,NULL),(474,'do nothing','2016-05-30 13:39:04',NULL,NULL),(475,'do nothing','2016-05-30 13:39:15',NULL,NULL),(476,'do nothing','2016-05-30 13:39:38',NULL,NULL),(477,'do nothing','2016-05-30 13:39:43',NULL,NULL),(478,'do nothing','2016-05-30 13:39:52',NULL,NULL),(479,'do nothing','2016-05-30 13:39:57',NULL,NULL),(480,'do nothing','2016-05-30 13:40:03',NULL,NULL),(481,'do nothing','2016-05-30 13:40:11',NULL,NULL),(482,'登陆了','2016-05-30 13:42:32',NULL,NULL),(483,'登陆了','2016-05-30 13:47:15',NULL,NULL),(484,'do nothing','2016-05-30 13:49:16',NULL,NULL),(485,'do nothing','2016-05-30 13:49:27',NULL,NULL),(486,'do nothing','2016-05-30 13:49:44',NULL,NULL),(487,'do nothing','2016-05-30 13:49:45',NULL,NULL),(488,'do nothing','2016-05-30 13:49:45',NULL,NULL),(489,'do nothing','2016-05-30 13:49:46',NULL,NULL),(490,'do nothing','2016-05-30 13:49:46',NULL,NULL),(491,'do nothing','2016-05-30 13:49:47',NULL,NULL),(492,'do nothing','2016-05-30 13:49:49',NULL,NULL),(493,'do nothing','2016-05-30 13:49:52',NULL,NULL),(494,'do nothing','2016-05-30 13:49:54',NULL,NULL),(495,'do nothing','2016-05-30 13:49:55',NULL,NULL),(496,'do nothing','2016-05-30 13:49:57',NULL,NULL),(497,'do nothing','2016-05-30 13:49:59',NULL,NULL),(498,'do nothing','2016-05-30 13:50:01',NULL,NULL),(499,'do nothing','2016-05-30 13:50:03',NULL,NULL),(500,'do nothing','2016-05-30 13:50:05',NULL,NULL),(501,'do nothing','2016-05-30 13:50:07',NULL,NULL),(502,'注销了','2016-05-30 13:50:22',NULL,NULL),(503,'登陆了','2016-05-30 13:50:45',NULL,NULL),(504,'do nothing','2016-05-30 13:51:24',NULL,NULL),(505,'do nothing','2016-05-30 13:51:44',NULL,NULL),(506,'do nothing','2016-05-30 13:52:04',NULL,NULL),(507,'do nothing','2016-05-30 13:52:19',NULL,NULL),(508,'do nothing','2016-05-30 13:52:43',NULL,NULL),(509,'do nothing','2016-05-30 13:53:19',NULL,NULL),(510,'do nothing','2016-05-30 13:53:35',NULL,NULL),(511,'do nothing','2016-05-30 13:53:52',NULL,NULL),(512,'do nothing','2016-05-30 13:54:08',NULL,NULL),(513,'do nothing','2016-05-30 13:54:23',NULL,NULL),(514,'登陆了','2016-05-30 13:56:12',NULL,NULL),(515,'登陆了','2016-05-30 13:57:27',NULL,NULL),(516,'do nothing','2016-05-30 14:11:05',NULL,NULL),(517,'do nothing','2016-05-30 14:11:05',NULL,NULL),(518,'do nothing','2016-05-30 14:11:05',NULL,NULL),(519,'do nothing','2016-05-30 14:11:05',NULL,NULL),(520,'do nothing','2016-05-30 14:11:05',NULL,NULL),(521,'do nothing','2016-05-30 14:12:37',NULL,NULL),(522,'do nothing','2016-05-30 14:12:58',NULL,NULL),(523,'do nothing','2016-05-30 14:13:16',NULL,NULL),(524,'do nothing','2016-05-30 14:13:50',NULL,NULL),(525,'do nothing','2016-05-30 14:14:15',NULL,NULL),(526,'do nothing','2016-05-30 14:14:43',NULL,NULL),(527,'do nothing','2016-05-30 14:15:23',NULL,NULL),(528,'do nothing','2016-05-30 14:15:38',NULL,NULL),(529,'do nothing','2016-05-30 14:16:00',NULL,NULL),(530,'do nothing','2016-05-30 14:16:10',NULL,NULL),(531,'do nothing','2016-05-30 14:16:31',NULL,NULL),(532,'do nothing','2016-05-30 14:17:19',NULL,NULL),(533,'do nothing','2016-05-30 14:18:06',NULL,NULL),(534,'do nothing','2016-05-30 14:18:32',NULL,NULL),(535,'登陆了','2016-05-30 14:23:51',NULL,NULL),(536,'do nothing','2016-05-30 14:27:54',NULL,NULL),(537,'do nothing','2016-05-30 14:28:05',NULL,NULL),(538,'登陆了','2016-05-30 14:36:09',NULL,NULL),(539,'登陆了','2016-05-30 14:36:09',NULL,NULL),(540,'do nothing','2016-05-30 14:38:54',NULL,NULL),(541,'登陆了','2016-05-30 14:39:47',NULL,NULL),(542,'do nothing','2016-05-30 14:40:37',NULL,NULL),(543,'do nothing','2016-05-30 14:40:56',NULL,NULL),(544,'登陆了','2016-05-30 14:41:51','谌云莉','T201401'),(545,'do nothing','2016-05-30 14:44:00','谌云莉','T201401'),(546,'do nothing','2016-05-30 14:44:48','谌云莉','T201401'),(547,'do nothing','2016-05-30 14:44:52','谌云莉','T201401'),(548,'登陆了','2016-05-30 14:47:57','孟晗1','S201425057'),(549,'下载了一份实习报告','2016-05-30 14:49:32','孟晗1','S201425057'),(550,'注销了','2016-05-30 14:49:58','孟晗1','S201425057'),(551,'登陆了','2016-05-30 14:50:15','孟晗2','S201425058'),(552,'下载了一份实习报告','2016-05-30 14:50:17','孟晗2','S201425058'),(553,'登陆了','2016-05-30 14:50:37','孟晗1','S201425057'),(554,'上传了作业','2016-05-30 14:51:55','孟晗1','S201425057'),(555,'上传了作业','2016-05-30 14:52:15','孟晗1','S201425057'),(556,'上传了作业','2016-05-30 14:52:31','孟晗1','S201425057'),(557,'下载了一份实习报告','2016-05-30 14:52:33','孟晗1','S201425057'),(558,'下载了一份实习报告','2016-05-30 14:52:36','孟晗1','S201425057'),(559,'注销了','2016-05-30 14:52:43','孟晗1','S201425057'),(560,'do nothing','2016-05-30 14:56:12','孟晗1','S201425057'),(561,'do nothing','2016-05-30 14:56:20','孟晗1','S201425057'),(562,'登陆了','2016-05-30 14:59:21','孟晗1','S201425057'),(563,'下载了一份实习报告','2016-05-30 14:59:24','孟晗1','S201425057'),(564,'上传了作业','2016-05-30 14:59:37','孟晗1','S201425057'),(565,'上传了作业','2016-05-30 15:00:11','孟晗1','S201425057'),(566,'上传了作业','2016-05-30 15:00:14','孟晗1','S201425057'),(567,'下载了一份实习报告','2016-05-30 15:00:15','孟晗1','S201425057'),(568,'下载了一份实习报告','2016-05-30 15:00:18','孟晗1','S201425057'),(569,'登陆了','2016-05-30 15:00:48','孟晗1','S201425057'),(570,'登陆了','2016-06-05 14:17:10',NULL,NULL),(571,'登陆了','2016-06-05 14:18:00','谌云莉','T201401'),(572,'登陆了','2016-06-05 15:01:40','谌云莉','T201401'),(573,'登陆了','2016-06-05 15:06:13','谌云莉','T201401'),(574,'登陆了','2016-06-05 15:13:18','谌云莉','T201401'),(575,'登陆了','2016-06-05 15:23:59','谌云莉','T201401'),(576,'登陆了','2016-06-05 15:25:37','谌云莉','T201401'),(577,'登陆了','2016-06-05 15:29:38','谌云莉','T201401'),(578,'登陆了','2016-06-05 15:32:38','谌云莉','T201401'),(579,'登陆了','2016-06-05 15:46:27','谌云莉','T201401'),(580,'登陆了','2016-06-05 15:54:04','谌云莉','T201401'),(581,'登陆了','2016-06-05 15:55:13','谌云莉','T201401'),(582,'登陆了','2016-06-05 15:56:25','谌云莉','T201401'),(583,'登陆了','2016-06-05 15:58:59','谌云莉','T201401'),(584,'登陆了','2016-06-05 16:21:51',NULL,NULL),(585,'do nothing','2016-06-05 16:21:59',NULL,NULL),(586,'登陆了','2016-06-05 16:23:07','谌云莉','T201401'),(587,'注销了','2016-06-05 16:28:24','谌云莉','T201401'),(588,'登陆了','2016-06-05 16:28:46','谌云莉','T201401'),(589,'上传了一个案例','2016-06-05 16:29:23','谌云莉','T201401'),(590,'上传了一个案例','2016-06-05 16:29:26','谌云莉','T201401'),(591,'注销了','2016-06-05 16:29:28','谌云莉','T201401'),(592,'登陆了','2016-06-05 16:29:38','谌云莉','T201401'),(594,'登陆了','2016-06-05 16:37:06',NULL,NULL),(595,'do nothing','2016-06-05 16:37:17',NULL,NULL),(596,'do nothing','2016-06-05 16:37:17',NULL,NULL),(597,'do nothing','2016-06-05 16:37:21',NULL,NULL),(598,'do nothing','2016-06-05 16:37:23',NULL,NULL),(599,'do nothing','2016-06-05 16:37:24',NULL,NULL),(600,'do nothing','2016-06-05 16:37:38',NULL,NULL),(601,'do nothing','2016-06-05 16:37:38',NULL,NULL),(602,'do nothing','2016-06-05 16:37:38',NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (10,'yunlichen@bjut.edu.cn','谌云莉','T201401','67396121-201',2,'T201401',NULL,'无线ad hoc networks, 无线sensor networks以及网络QoS',NULL),(11,'liyong@bjut.edu.cn','李永','T201402','67396111',1,'T201402',NULL,'下一代网络研究，信产部无障碍通信业务和终端研究，伽利略定位导航系统研制，统一IMS研究',NULL),(12,'zl_hlj@126.com','张丽','T201403','67396121-203',2,'T201403',NULL,'计算机网络通讯协议、无线网络应用、计算机游戏、无线NDN网络',NULL),(13,'shenq@bjut.edu.cn','沈琦','T201404','67396121',2,'T201404',NULL,'计算机网络技术及应用、分布式计算、代理技术及应用',NULL),(14,'yuewuxing@hit.edu.cn','阎长顺','T201405','67396124-14',1,'T201405',NULL,'客户关系管理',NULL);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rights` int(11) DEFAULT NULL,
  `userType` int(11) DEFAULT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weekly_report`
--

DROP TABLE IF EXISTS `weekly_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `weekly_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `date` datetime DEFAULT NULL,
  `sno` varchar(24) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weekly_report`
--

LOCK TABLES `weekly_report` WRITE;
/*!40000 ALTER TABLE `weekly_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `weekly_report` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-28 19:55:17
