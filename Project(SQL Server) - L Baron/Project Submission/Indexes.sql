/*=================================================================== 
Author: Liam Baron
Date: 2023/08/24
Purpose: This file creates indexes for tables created in the database
'mmorpg'
=====================================================================*/

USE mmorpg
GO
-- This allows us to reorder the table account around the column 'accName'.
CREATE NONCLUSTERED INDEX idx_account
ON account
(
	accName
)
GO
-- This allows us to reorder the table errorType around the column 'errorName'.
CREATE NONCLUSTERED INDEX idx_errorType
ON errorType
(
	errorName
)
GO