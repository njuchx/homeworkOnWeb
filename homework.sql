/*
MySQL Data Transfer
Source Host: localhost
Source Database: homework
Target Host: localhost
Target Database: homework
Date: 2017/12/7 19:05:05
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for assteacher
-- ----------------------------
DROP TABLE IF EXISTS `assteacher`;
CREATE TABLE `assteacher` (
  `assTeacherID` varchar(50) NOT NULL DEFAULT '1',
  `assTeacherPwd` varchar(50) DEFAULT '1',
  `assTeacherName` varchar(50) DEFAULT '1',
  PRIMARY KEY (`assTeacherID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for class_assteacher
-- ----------------------------
DROP TABLE IF EXISTS `class_assteacher`;
CREATE TABLE `class_assteacher` (
  `classID` varchar(50) DEFAULT NULL,
  `teacherID` varchar(50) DEFAULT NULL,
  `assTeacherID` varchar(50) DEFAULT NULL,
  `assTeacherName` varchar(50) DEFAULT NULL,
  `stuManState` int(5) NOT NULL DEFAULT '0',
  `addQuestion` int(5) NOT NULL DEFAULT '0',
  `addHomework` int(5) NOT NULL DEFAULT '0',
  `correctHomework` int(5) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for class_student
-- ----------------------------
DROP TABLE IF EXISTS `class_student`;
CREATE TABLE `class_student` (
  `classID` varchar(50) DEFAULT NULL,
  `stuID` varchar(50) DEFAULT NULL,
  `stuName` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for class_teacher
-- ----------------------------
DROP TABLE IF EXISTS `class_teacher`;
CREATE TABLE `class_teacher` (
  `classID` varchar(50) DEFAULT NULL,
  `course` varchar(50) DEFAULT NULL,
  `teacherID` varchar(50) DEFAULT NULL,
  `teacherName` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for homework
-- ----------------------------
DROP TABLE IF EXISTS `homework`;
CREATE TABLE `homework` (
  `homeworkID` varchar(50) NOT NULL DEFAULT '1',
  `classID` varchar(50) DEFAULT NULL,
  `homeworkTitle` varchar(21000) DEFAULT NULL,
  `deadline` datetime DEFAULT NULL,
  `homeworkState` varchar(50) NOT NULL DEFAULT '未截止',
  PRIMARY KEY (`homeworkID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for questions
-- ----------------------------
DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
  `tskID` varchar(50) DEFAULT NULL,
  `course` varchar(50) DEFAULT NULL,
  `chapter` varchar(50) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `tskDetail` varchar(21000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stuID` varchar(20) NOT NULL DEFAULT '0000',
  `password` varchar(20) NOT NULL DEFAULT '123456',
  `name` varchar(10) NOT NULL DEFAULT '无名',
  `classID` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`stuID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `stuID` varchar(20) NOT NULL DEFAULT '0000',
  `password` varchar(20) NOT NULL DEFAULT '123456',
  `name` varchar(10) NOT NULL DEFAULT '无名',
  `classID` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`stuID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for stugrade
-- ----------------------------
DROP TABLE IF EXISTS `stugrade`;
CREATE TABLE `stugrade` (
  `classID` varchar(50) DEFAULT NULL,
  `stuID` varchar(50) DEFAULT NULL,
  `homeworkTitle` varchar(50) DEFAULT NULL,
  `grade` varchar(50) DEFAULT NULL,
  `subState` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for task_answerstu
-- ----------------------------
DROP TABLE IF EXISTS `task_answerstu`;
CREATE TABLE `task_answerstu` (
  `tskID` varchar(50) NOT NULL DEFAULT '1',
  `tskDetail` varchar(21000) DEFAULT NULL,
  `homeworkID` varchar(50) NOT NULL DEFAULT '1',
  `stuID` varchar(50) NOT NULL DEFAULT '123456',
  `tskStuAnswer` varchar(50) DEFAULT NULL,
  `tskState` varchar(50) NOT NULL DEFAULT '已保存'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for task_detail
-- ----------------------------
DROP TABLE IF EXISTS `task_detail`;
CREATE TABLE `task_detail` (
  `homeworkID` varchar(50) DEFAULT NULL,
  `tskID` varchar(50) DEFAULT NULL,
  `tskContent` varchar(210) DEFAULT NULL,
  `tskDetail` varchar(21000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacherID` varchar(20) NOT NULL DEFAULT '0000',
  `name` varchar(10) NOT NULL DEFAULT '无名',
  `password` varchar(20) NOT NULL DEFAULT '123456',
  PRIMARY KEY (`teacherID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `homework` VALUES ('1', '软件工程', '第一次作业', '2017-11-30 19:00:00', '已截止');
INSERT INTO `homework` VALUES ('2', '软件工程', '第二次作业', '2017-12-30 20:00:00', '未截止');
INSERT INTO `homework` VALUES ('3', '软件工程', '第三次作业', '2017-12-18 20:11:24', '未截止');
INSERT INTO `student` VALUES ('MF1723009', '12', '陈旭', '软件工程');
INSERT INTO `students` VALUES ('MF1723009', '123456', '陈旭', '软件工程');
INSERT INTO `task_answerstu` VALUES ('1', 'null', '1', 'MF1723009', '2\r\n 										', '已保存');
INSERT INTO `task_answerstu` VALUES ('3', 'null', '2', 'MF1723009', '3\r\n 										', '已保存');
INSERT INTO `task_answerstu` VALUES ('2', 'null', '1', 'MF1723009', '未回答', '未回答');
INSERT INTO `task_answerstu` VALUES ('4', 'null', '2', 'MF1723009', '未回答', '未回答');
INSERT INTO `task_answerstu` VALUES ('5', null, '3', 'MF1723009', '未回答', '未回答');
INSERT INTO `task_detail` VALUES ('1', '1', '第一题', '1+1=？');
INSERT INTO `task_detail` VALUES ('1', '2', '第二题', '1+2=？');
INSERT INTO `task_detail` VALUES ('2', '3', '第一题', '2+1=？');
INSERT INTO `task_detail` VALUES ('2', '4', '第二题', '2+2=？');
INSERT INTO `task_detail` VALUES ('3', '5', '第一题', '3*3=？');
INSERT INTO `teacher` VALUES ('123456', '无名', '123456');
