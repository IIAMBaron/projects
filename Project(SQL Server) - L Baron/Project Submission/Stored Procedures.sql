/*=================================================================== 
Author: Liam Baron
Date: 2023/08/23
Purpose: This file creates the Stored Procedures.
=====================================================================*/

USE mmorpg
GO

-- Creating a stored procedure that will insert new data into the account table.
CREATE PROCEDURE spRegister 
@name VARCHAR(30),
@bankCardDetails INT
AS
BEGIN
	INSERT INTO account (
		accName, 
		bankNum
		)
	VALUES (@name,
			@bankCardDetails
			) 
END
GO

-- This stored procedure adds time to accounts that already exists and it also checks if it does exist.
CREATE PROCEDURE spAddTime
@name VARCHAR(30),
@lengthOfTime INT
AS
BEGIN
	IF (SELECT accName
		FROM account
		WHERE @name = accName) = @name
		BEGIN 
			UPDATE accTime
			SET timeEnd = DATEADD(day, @lengthOfTime, timeEnd)
			WHERE @name = accWithTime
		END
	ELSE
		BEGIN
			RAISERROR('Account Name does not exist',17,1)
			RETURN
		END
END
GO

-- Adds new rows of data into the inventory table.
CREATE PROCEDURE spAddItem
@nameOfItem VARCHAR(20),
@rarityOfItem VARCHAR(20)
AS
BEGIN
	INSERT INTO inventory (itemName, rarity)
	VALUES (
		@nameOfItem,
		@rarityOfItem)
END
GO

CREATE PROCEDURE spAddChar
@nameOfChar VARCHAR(30),
@TeamOfChar VARCHAR(10),
@charLvl INT,
@nameOfAcc VARCHAR(20)
AS
BEGIN
	if (SELECT accName 
			FROM account
			WHERE @nameOfChar = accName) = @nameOfChar -- Checks if the account name does exist in the table. If so it will insert the new data.
		BEGIN
			INSERT INTO accCharacter
			VALUES (@nameOfChar,
				@TeamOfChar,
				@charLvl,
				@nameOfAcc)
		END
	ELSE
		BEGIN
			RAISERROR('Account Name does not exist',17,1) -- If not an error is raised.
			RETURN
		END
END
GO

CREATE PROCEDURE spSendLetter 
@news VARCHAR(MAX) = NULL
AS
BEGIN
	DECLARE accWithTime_cursor CURSOR -- A cursor is made to help me loop through the rows of data in the account table.
	FOR 
	SELECT accWithTime
	FROM accTime
	OPEN accWithTime_cursor 
	DECLARE @name VARCHAR(MAX)
	DECLARE @time INT
	FETCH NEXT FROM accWithTime_cursor INTO @name -- Getting the first row of data.
	WHILE @@FETCH_STATUS = 0 -- The fetch status will only return 1 when there is no more rows left to fetch that is why we are making it equal to 1 instead.
	BEGIN 
			SET @time = (SELECT DATEDIFF(day, GETDATE(), timeEnd) FROM accCharacter, accTime WHERE belongAccount = @name AND belongAccount = accWithTime) -- We will be using this to get the different days left from each account.
			IF @time < 0 -- This will help us dodge negative values returned from line 100.
			BEGIN
				SET @time = 0
			END
			PRINT 'Hi, '+  @name +' you have ' +  LTRIM(STR(@time)) +' day/s left.'
			IF @news IS NOT NULL
			BEGIN
				PRINT(@news)
			END
			FETCH NEXT FROM accWithTime_cursor INTO @name -- Retrieves next row of data.
	END
	CLOSE accWithTime_cursor -- To help save memory and increase performance
	DEALLOCATE accWithTime_cursor -- We delete so we have the option to execute this procedure many times.
END
GO
