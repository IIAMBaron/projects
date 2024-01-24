CREATE DATABASE AdvJava
GO

USE AdvJava
GO

CREATE TABLE AdminInfo (
	adminID INT IDENTITY(1,1),
	username VARCHAR(MAX) NOT NULL,
	password VARCHAR(MAX) NOT NULL,
	fullName VARCHAR(30) NOT NULL,
	CONSTRAINT adminID_PK PRIMARY KEY (adminID)
)

CREATE TABLE AddressInfo (
	addID INT IDENTITY(1,1),
	streetNum INT NOT NULL,
	streetName VARCHAR(MAX) NOT NULL,
	suburb VARCHAR(40) NOT NULL,
	city VARCHAR(30) NOT NULL,
	CONSTRAINT addID_PK PRIMARY KEY (addID)
)

CREATE TABLE OrderInfo (
	orderID INT IDENTITY(1,1) PRIMARY KEY,
	orderDate DATE NOT NULL,
	deliveryMode VARCHAR(50) NOT NULL,
	deliveryPay INT NOT NULL,
	addID INT NOT NULL,
	CONSTRAINT addID_FK FOREIGN KEY (addID) REFERENCES AddressInfo(addID)
)

CREATE TABLE ProductCategory (
	name VARCHAR(40) NOT NULL,
	prodType INT NOT NULL,
	CONSTRAINT prodType_PK PRIMARY KEY (prodType)
)

CREATE TABLE ProductInfo (
	productID INT IDENTITY(1,1),
	name VARCHAR(40) NOT NULL,
	price FLOAT NOT NULL,
	prodDesc VARCHAR(MAX) NOT NULL,
	imageLocation VARCHAR(MAX) NOT NULL,
	prodType INT NOT NULL,
	CONSTRAINT productID_PK PRIMARY KEY (productID),
	CONSTRAINT prodType_FK FOREIGN KEY (prodType) REFERENCES ProductCategory(prodType)
)

CREATE TABLE OrderDetails (
	quantity INT NOT NULL,
	productID INT NOT NULL,
	orderID INT NOT NULL,
	CONSTRAINT productID_FK FOREIGN KEY (productID) REFERENCES ProductInfo(productID),
	CONSTRAINT orderID_FK FOREIGN KEY (orderID) REFERENCES OrderInfo(orderID)
)
