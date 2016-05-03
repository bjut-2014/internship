-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2016-05-03 13:13:49
-- 服务器版本: 5.5.46-0ubuntu0.14.04.2
-- PHP 版本: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `internship`
--

-- --------------------------------------------------------

--
-- 表的结构 `case_library`
--

CREATE TABLE IF NOT EXISTS `case_library` (
  `caseLibraryId` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `filePath` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `stuCaseLibrary` bit(1) DEFAULT NULL,
  `tchCaseLibrary` bit(1) DEFAULT NULL,
  `courseId` int(11) NOT NULL,
  PRIMARY KEY (`caseLibraryId`),
  KEY `FK_2vlt43etuwg65w915uk2hsekf` (`courseId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `case_library`
--

INSERT INTO `case_library` (`caseLibraryId`, `date`, `filePath`, `name`, `stuCaseLibrary`, `tchCaseLibrary`, `courseId`) VALUES
(1, '2014-01-01', '/upload/caselibrary/移动技术开发/', '移动开发技术第一章.ppt', NULL, NULL, 1),
(2, '2014-01-02', '/upload/caselibrary/移动技术开发/', '移动开发技术第二章.ppt', NULL, NULL, 1),
(3, '2014-01-03', '/upload/caselibrary/移动技术开发/', '移动开发技术第三章.ppt', NULL, NULL, 1);

-- --------------------------------------------------------

--
-- 表的结构 `course`
--

CREATE TABLE IF NOT EXISTS `course` (
  `courseId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `teacherId` int(11) NOT NULL,
  `courseDate` varchar(255) DEFAULT NULL,
  `coursePlace` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`courseId`),
  KEY `FK_tn5xxerkw82ii7pwadnuc60s4` (`teacherId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- 转存表中的数据 `course`
--

INSERT INTO `course` (`courseId`, `name`, `teacherId`, `courseDate`, `coursePlace`) VALUES
(1, '移动技术开发', 1, '周一下午5、6节', '1教401'),
(2, 'Linux嵌入式系统', 1, '周四上午1、2节', '软院717'),
(3, '软件工程', 2, '周二上午3、4节', '3教501'),
(4, '计算机网络', 2, '周三上午1、2节', '1教401');

-- --------------------------------------------------------

--
-- 表的结构 `graduation_weekly_report`
--

CREATE TABLE IF NOT EXISTS `graduation_weekly_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `date` datetime DEFAULT NULL,
  `sno` varchar(24) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `homework`
--

CREATE TABLE IF NOT EXISTS `homework` (
  `homeworkId` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `studentId` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`homeworkId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `homework`
--

INSERT INTO `homework` (`homeworkId`, `courseId`, `date`, `path`, `studentId`, `title`) VALUES
(1, 1, '2016-05-03', '/upload/homework/10080108/', 2, '基于有效子串标注的中文分词.pdf'),
(2, 1, '2016-05-03', '/upload/homework/S201425057/', 1, 'HMM学习最佳范例.pdf');

-- --------------------------------------------------------

--
-- 表的结构 `internship_detail`
--

CREATE TABLE IF NOT EXISTS `internship_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_address` varchar(100) DEFAULT NULL,
  `company_name` varchar(100) DEFAULT NULL,
  `company_teacher` varchar(100) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `sno` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_dsr0l69of46xjvk8xey7yd3gd` (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `internship_report`
--

CREATE TABLE IF NOT EXISTS `internship_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `path` varchar(1000) DEFAULT NULL,
  `sno` varchar(24) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `student`
--

CREATE TABLE IF NOT EXISTS `student` (
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
  `id` int(11) NOT NULL,
  PRIMARY KEY (`studentId`),
  UNIQUE KEY `UK_cxffpo742xolsmubc0erwwf9m` (`sno`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `student`
--

INSERT INTO `student` (`studentId`, `classes`, `email`, `grade`, `name`, `password`, `phone`, `sex`, `sno`, `userType`, `id`) VALUES
(1, '801', NULL, 2014, '孟晗', 'mh', '15001185667', 1, 'S201425057', 1, 0),
(2, NULL, NULL, NULL, '孟同学', 'mtx', NULL, NULL, '10080108', 1, 0);

-- --------------------------------------------------------

--
-- 表的结构 `student_course`
--

CREATE TABLE IF NOT EXISTS `student_course` (
  `courseId` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`studentId`,`courseId`),
  KEY `FK_t45vpfbqbh56bh3u7d4ppoopg` (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `student_course`
--

INSERT INTO `student_course` (`courseId`, `studentId`, `score`) VALUES
(1, 1, 85),
(2, 1, 70),
(3, 1, 93),
(1, 2, NULL),
(4, 2, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `syslog`
--

CREATE TABLE IF NOT EXISTS `syslog` (
  `syslogId` int(11) NOT NULL AUTO_INCREMENT,
  `behavior` varchar(100) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `name` varchar(24) DEFAULT NULL,
  `no` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`syslogId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=71 ;

--
-- 转存表中的数据 `syslog`
--

INSERT INTO `syslog` (`syslogId`, `behavior`, `date`, `name`, `no`) VALUES
(1, '登陆了', '2016-05-01 11:04:43', '孟晗', 'S201425057'),
(2, '登陆了', '2016-05-01 11:08:10', '孟同学', '10080108'),
(3, '登陆了', '2016-05-01 11:08:58', '孟同学', '10080108'),
(4, '登陆了', '2016-05-01 11:14:29', '孟同学', '10080108'),
(5, '登陆了', '2016-05-01 13:20:23', '孟晗', 'S201425057'),
(6, '注销了', '2016-05-01 13:21:44', '孟晗', 'S201425057'),
(7, '登陆了', '2016-05-01 13:21:51', '谌云莉', 'T2014'),
(8, '注销了', '2016-05-01 13:22:50', '谌云莉', 'T2014'),
(9, '登陆了', '2016-05-01 13:22:55', '孟同学', '10080108'),
(10, '登陆了', '2016-05-01 16:18:21', '谌云莉', 'T2014'),
(11, '注销了', '2016-05-01 16:18:40', '谌云莉', 'T2014'),
(12, '登陆了', '2016-05-01 16:18:47', '孟晗', 'S201425057'),
(13, '登陆了', '2016-05-01 17:08:14', '孟晗', 'S201425057'),
(14, '登陆了', '2016-05-01 17:12:56', '孟晗', 'S201425057'),
(15, '登陆了', '2016-05-01 17:17:37', '孟晗', 'S201425057'),
(16, '登陆了', '2016-05-01 17:31:29', '孟晗', 'S201425057'),
(17, '登陆了', '2016-05-01 17:34:45', '孟晗', 'S201425057'),
(18, '登陆了', '2016-05-01 17:37:26', '孟晗', 'S201425057'),
(19, '登陆了', '2016-05-01 17:46:35', '孟晗', 'S201425057'),
(20, '登陆了', '2016-05-01 17:47:34', '孟晗', 'S201425057'),
(21, '登陆了', '2016-05-01 17:48:19', '孟晗', 'S201425057'),
(22, '登陆了', '2016-05-01 17:53:08', '孟晗', 'S201425057'),
(23, '登陆了', '2016-05-01 18:01:13', '孟晗', 'S201425057'),
(24, '登陆了', '2016-05-01 18:17:25', '孟晗', 'S201425057'),
(25, '登陆了', '2016-05-01 18:25:30', '孟晗', 'S201425057'),
(26, '注销了', '2016-05-01 18:51:38', '孟晗', 'S201425057'),
(27, '登陆了', '2016-05-01 18:51:44', '谌云莉', 'T2014'),
(28, '登陆了', '2016-05-01 19:20:18', '谌云莉', 'T2014'),
(29, '登陆了', '2016-05-01 19:24:59', NULL, NULL),
(30, '登陆了', '2016-05-01 19:25:06', '孟晗', 'S201425057'),
(31, '注销了', '2016-05-01 19:25:22', '孟晗', 'S201425057'),
(32, '登陆了', '2016-05-01 19:25:31', '孟同学', '10080108'),
(33, '注销了', '2016-05-01 19:25:52', '孟同学', '10080108'),
(34, '登陆了', '2016-05-01 19:25:59', '谌云莉', 'T2014'),
(35, '注销了', '2016-05-01 19:26:29', '谌云莉', 'T2014'),
(36, '登陆了', '2016-05-01 19:34:26', '谌云莉', 'T2014'),
(37, '登陆了', '2016-05-01 20:37:16', '孟晗', 'S201425057'),
(38, '登陆了', '2016-05-01 20:53:16', '孟晗', 'S201425057'),
(39, '登陆了', '2016-05-01 21:08:30', '谌云莉', 'T2014'),
(40, '注销了', '2016-05-01 21:08:36', '谌云莉', 'T2014'),
(41, '登陆了', '2016-05-01 21:08:41', '孟晗', 'S201425057'),
(42, '登陆了', '2016-05-01 21:11:09', '孟晗', 'S201425057'),
(43, '登陆了', '2016-05-01 21:21:27', '孟晗', 'S201425057'),
(44, '登陆了', '2016-05-01 21:23:08', '孟晗', 'S201425057'),
(45, '登陆了', '2016-05-01 21:23:53', '孟晗', 'S201425057'),
(46, '登陆了', '2016-05-01 21:55:53', '孟晗', 'S201425057'),
(47, '登陆了', '2016-05-01 21:57:31', '孟晗', 'S201425057'),
(48, '登陆了', '2016-05-01 21:59:03', '孟晗', 'S201425057'),
(49, '登陆了', '2016-05-01 22:01:51', '孟晗', 'S201425057'),
(50, '登陆了', '2016-05-01 22:10:50', NULL, NULL),
(51, '登陆了', '2016-05-01 22:10:58', '孟晗', 'S201425057'),
(52, '登陆了', '2016-05-01 22:23:14', '孟晗', 'S201425057'),
(53, '登陆了', '2016-05-01 23:00:35', '孟晗', 'S201425057'),
(54, '上传了作业', '2016-05-01 23:00:56', '孟晗', 'S201425057'),
(55, '登陆了', '2016-05-02 13:28:59', '孟晗', 'S201425057'),
(56, '登陆了', '2016-05-02 20:49:50', '孟晗', 'S201425057'),
(57, '注销了', '2016-05-02 20:54:54', '孟晗', 'S201425057'),
(58, '注销了', '2016-05-03 13:03:33', '孟晗', 'S201425057'),
(59, '注销了', '2016-05-03 13:03:35', '孟晗', 'S201425057'),
(60, '登陆了', '2016-05-03 13:03:49', '孟晗', 'S201425057'),
(61, '上传了作业', '2016-05-03 13:05:44', '孟晗', 'S201425057'),
(62, '注销了', '2016-05-03 13:07:37', '孟晗', 'S201425057'),
(63, '登陆了', '2016-05-03 13:08:02', '孟晗', 'S201425057'),
(64, '登陆了', '2016-05-03 13:08:23', '孟同学', '10080108'),
(65, '上传了作业', '2016-05-03 13:08:51', '孟同学', '10080108'),
(66, '注销了', '2016-05-03 13:09:45', '孟同学', '10080108'),
(67, '登陆了', '2016-05-03 13:10:18', '孟晗', 'S201425057'),
(68, '上传了作业', '2016-05-03 13:10:30', '孟晗', 'S201425057'),
(69, '注销了', '2016-05-03 13:10:58', '孟晗', 'S201425057'),
(70, '登陆了', '2016-05-03 13:11:22', '谌云莉', 'T2014');

-- --------------------------------------------------------

--
-- 表的结构 `teacher`
--

CREATE TABLE IF NOT EXISTS `teacher` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `teacher`
--

INSERT INTO `teacher` (`teacherId`, `email`, `name`, `password`, `phone`, `sex`, `tno`, `userType`, `major`, `title`) VALUES
(1, NULL, '谌云莉', 'cyl', NULL, 2, 'T2014', 2, '无线网络', '副教授'),
(2, NULL, '谌老师', 'cls', NULL, NULL, 'T2010', 2, NULL, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rights` int(11) DEFAULT NULL,
  `userType` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `weekly_report`
--

CREATE TABLE IF NOT EXISTS `weekly_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `date` datetime DEFAULT NULL,
  `sno` varchar(24) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 限制导出的表
--

--
-- 限制表 `case_library`
--
ALTER TABLE `case_library`
  ADD CONSTRAINT `FK_2vlt43etuwg65w915uk2hsekf` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`);

--
-- 限制表 `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `FK_tn5xxerkw82ii7pwadnuc60s4` FOREIGN KEY (`teacherId`) REFERENCES `teacher` (`teacherId`);

--
-- 限制表 `student_course`
--
ALTER TABLE `student_course`
  ADD CONSTRAINT `FK_pt5bwh1wp3fn0d5cr677p211f` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`),
  ADD CONSTRAINT `FK_t45vpfbqbh56bh3u7d4ppoopg` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
