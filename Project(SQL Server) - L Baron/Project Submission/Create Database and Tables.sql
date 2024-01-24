/*=================================================================== 
Author: Liam Baron
Date: 2023/08/21
Purpose: This file will create the Database as well as the Tables that
come along with it.
=====================================================================*/

CREATE DATABASE mmorpg
GO

USE mmorpg
GO

CREATE TABLE error 
(
	errorCode INT NOT NULL ,
	errorDesc VARCHAR(40) NOT NULL ,
	PRIMARY KEY (errorCode),
	UNIQUE (errorDesc)
)

CREATE TABLE account
(
	accName VARCHAR(30) NOT NULL,
	accNum INT NOT NULL IDENTITY(1,1),
	bankNum INT NOT NULL,
	PRIMARY KEY (accName),
)

CREATE TABLE errorType
(
	errorName VARCHAR(20) NOT NULL,
	accOfError VARCHAR(30) NOT NULL,
	errorTypeCode INT NOT NULL,
	CONSTRAINT fkNameAcc FOREIGN KEY (accOfError) REFERENCES  account(accName),
	CONSTRAINT fkCodeError FOREIGN KEY (errorTypeCode) REFERENCES error(errorCode),
	PRIMARY KEY (accOfError, errorTypeCode)
)
--Creating the fee table.
CREATE TABLE fee
(
	feeID INT NOT NULL,
	feeDate DATE NOT NULL,
	feeDesc VARCHAR(30) NOT NULL,
	PRIMARY KEY (feeID)
)
-- Creating the accoun time table.
CREATE TABLE accTime
(
	timeStart DATE NULL DEFAULT GETDATE(),
	timeEnd DATE NULL DEFAULT GETDATE(),
	accWithTime VARCHAR(30) NOT NULL,
	feeTime INT NOT NULL,
	CONSTRAINT fkAccNameTime FOREIGN KEY (accWithTime) REFERENCES account(accName),
	CONSTRAINT fkFeeIDTime FOREIGN KEY (feeTime) REFERENCES fee(feeID),
	CONSTRAINT pkTime PRIMARY KEY (accWithTime, feeTime)
)
-- creating the account character table.
CREATE TABLE accCharacter
(
	charName VARCHAR(30) NOT NULL,
	charTeam VARCHAR(10) NULL DEFAULT 'None',
	charSkillLvl INT NULL DEFAULT 0,
	belongAccount VARCHAR(30) NOT NULL,
	PRIMARY KEY (charName),
	CONSTRAINT fkAccount FOREIGN KEY (belongAccount) REFERENCES account(accName)
)
-- Creating the inventory of a character table.
CREATE TABLE inventory 
(
	slot INT NOT NULL CHECK (slot <9) , 
	numItems INT NULL DEFAULT 0,
	belongChar VARCHAR(30) NOT NULL,
	itemName VARCHAR(20) NOT NULL,
	rarity VARCHAR(20) NOT NULL,
	CONSTRAINT fkCharName FOREIGN KEY (belongChar) REFERENCES accCharacter(charName),
	PRIMARY KEY (slot, belongChar)
)

