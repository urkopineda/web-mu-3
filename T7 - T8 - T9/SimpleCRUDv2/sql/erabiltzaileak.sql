
create database erabiltzaileak;
USE erabiltzaileak;
CREATE TABLE erabiltzaileak(
   uId INT NOT NULL AUTO_INCREMENT,
   uNick VARCHAR(100) NOT NULL,
   uEmail VARCHAR(40) NOT NULL,
   uPassword  VARCHAR(40) NOT NULL,
   PRIMARY KEY ( uId )
);
