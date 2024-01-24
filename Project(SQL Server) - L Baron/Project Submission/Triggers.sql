/*=================================================================== 
Author: Liam Baron
Date: 2023/08/24
Purpose: This file creates Triggers on the tables created in the 
Database 'mmorpg'
=====================================================================*/

USE mmorpg
GO
-- A trigger that is executed when the account table has newly inserted data.
CREATE TRIGGER tr_account
ON account
AFTER INSERT 
AS
	PRINT 'Your Account has been successfully registered.'
GO
-- A trigger that goes off when the inventory table is deleted.
CREATE TRIGGER tr_inventory
ON inventory
AFTER DELETE 
AS
	PRINT 'Deletion of inventory table was successful.'
GO