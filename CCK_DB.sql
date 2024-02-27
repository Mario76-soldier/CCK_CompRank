use cck;

CREATE TABLE `Accounts` (
  `email` varchar(40) NOT NULL,
  `name` varchar(30) NOT NULL,
  `password` varchar(512) DEFAULT NULL,
  `position` enum('customer','admin') DEFAULT 'customer',
  PRIMARY KEY (`email`)
);

CREATE TABLE `Competitor` (
  `email` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `enusername` varchar(30) NOT NULL,
  `nation` varchar(20) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `compIdx` int NOT NULL,
  `eventname` varchar(20) NOT NULL,
  PRIMARY KEY (`email`,`username`,`compIdx`,`eventname`)
) ;

CREATE TABLE `CompList` (
  `Idx` int NOT NULL AUTO_INCREMENT,
  `CompName` varchar(100) NOT NULL,
  `CompDate` date NOT NULL,
  `countRound` int DEFAULT NULL,
  PRIMARY KEY (`Idx`)
);

CREATE TABLE `CubeEvent` (
  `eventname` varchar(21) NOT NULL,
  `avgcalc` char(6) NOT NULL,
  PRIMARY KEY (`eventname`)
);

CREATE TABLE `Participate` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `UserName` varchar(20) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `EventName` varchar(21) NOT NULL,
  `round` int NOT NULL,
  `m1` int DEFAULT NULL,
  `s1` float DEFAULT NULL,
  `m2` int DEFAULT NULL,
  `s2` float DEFAULT NULL,
  `m3` int DEFAULT NULL,
  `s3` float DEFAULT NULL,
  `m4` int DEFAULT NULL,
  `s4` float DEFAULT NULL,
  `m5` int DEFAULT NULL,
  `s5` float DEFAULT NULL,
  `singlem` int DEFAULT NULL,
  `singles` float DEFAULT NULL,
  `avgm` int DEFAULT NULL,
  `avgs` float DEFAULT NULL,
  `ranking` int DEFAULT NULL,
  `checker1` varchar(15) DEFAULT NULL,
  `checker2` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idx`)
);

CREATE TABLE `Round` (
  `Idx` int NOT NULL AUTO_INCREMENT,
  `compidx` int NOT NULL,
  `seq` int NOT NULL,
  `eventname` varchar(21) DEFAULT NULL,
  `round` varchar(20) NOT NULL,
  `eventstart` datetime DEFAULT NULL,
  `eventend` datetime DEFAULT NULL,
  `Advance` int NOT NULL DEFAULT '8',
  PRIMARY KEY (`Idx`)
);

insert into CubeEvent(eventname, avgcalc) values
('3x3x3', 'ao5'),
('2x2x2', 'ao5'),
('4x4x4', 'ao5'),
('5x5x5', 'ao5'),
('6x6x6', 'mo3'),
('7x7x7', 'mo3'),
('3x3x3 BLD', 'mo3'),
('3x3x3 FMC', 'mo3'),
('3x3x3 OH', 'ao5'),
('clock', 'ao5'),
('megaminx', 'ao5'),
('pyraminx', 'ao5'),
('skewb', 'ao5'),
('square-1', 'ao5'),
('4x4x4 BLD', 'mo3'),
('5x5x5 BLD', 'mo3'),
('3x3x3 MULTBLD', 'single');