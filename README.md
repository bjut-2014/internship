# internship

在数据库中添加这样一段sql：
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `courseId` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`studentId`,`courseId`),
  KEY `FK_t45vpfbqbh56bh3u7d4ppoopg` (`courseId`),
  CONSTRAINT `FK_pt5bwh1wp3fn0d5cr677p211f` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`),
  CONSTRAINT `FK_t45vpfbqbh56bh3u7d4ppoopg` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
原因：学生表与课程表是多对多的关联，所以就把成绩字段插在了这个连接表中

项目启动后，需要在admin表中自己插入一段代码，来完成管理员的登录