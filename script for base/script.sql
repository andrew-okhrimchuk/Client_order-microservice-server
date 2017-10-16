DROP DATABASE IF EXISTS test;
CREATE DATABASE test ;
USE test;

CREATE TABLE `client`(
	`id1` BIGINT  PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`surname` VARCHAR(25) DEFAULT '0',
	`name` VARCHAR(15) DEFAULT '0',
	`date_of_birth` TIMESTAMP DEFAULT "2015-10-13",
	`sex` VARCHAR(15) DEFAULT '0');
#	ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;


CREATE TABLE `order1`(
	`id` BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`tIN2` BIGINT ,
	`status` BOOLEAN DEFAULT '0',
	`amount` DOUBLE DEFAULT '0',
	`date` TIMESTAMP ,
	`currency` VARCHAR(10) DEFAULT '0',
		#CONSTRAINT `fk_ordert_client`	FOREIGN KEY (`tIN2`) REFERENCES `client`(`tIN`)ON UPDATE CASCADE ON DELETE CASCADE
	FOREIGN KEY (`tIN2`) REFERENCES `client` (`id1`));

#	ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `client` (`id1`,`surname`,`name`,`date_of_birth`,`sex`)
VALUES (2,"2Okhrimchcuk","2Andrew","2015-10-14 00:00:00", "m"),
	(3,"Okhrimchcuk","Andrew","2015-10-13 00:00:00", "m");

INSERT INTO `order1` (`id`,tIN2,  `status`,`amount`,`date`,`currency`)
VALUES (1,2, false,55.25,"2015-10-10", "EURO"),
	(2, 3, false,55.25,"2015-10-16", "USD");