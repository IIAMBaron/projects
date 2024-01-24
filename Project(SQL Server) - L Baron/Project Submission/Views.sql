/*=================================================================== 
Author: Liam Baron
Date: 2023/08/22
Purpose: Creating the views and the stored procedures
=====================================================================*/
USE mmorpg
GO 

CREATE VIEW vwBlockedAccounts 
AS
SELECT accName
FROM account, accTime
WHERE DATEDIFF(day, GETDATE(),timeEnd) <= 0 AND accName = accWithTime -- I use this function(DATEDIFF) to help me get the days left using GETDATE and timeEnd.
GO

CREATE VIEW vwTopSkill 
AS
SELECT TOP 20 charSkillLvl, accName, accNum, bankNum
FROM account, accCharacter
WHERE belongAccount = accName
ORDER BY charSkillLvl DESC
GO

CREATE VIEW vwTopStackedItems 
AS
SELECT TOP 20 itemName, belongChar
FROM inventory
GROUP BY itemName, belongChar -- I am using GROUP BY here because U can group all the items with the same name in different inventories
ORDER BY itemName, COUNT(numItems) DESC -- This enables me to count all the stacks with the same name returning a value which I can use to determnine the TOP 20.
GO

CREATE VIEW vwPopItems 
AS
SELECT TOP 5 itemName, COUNT(itemName) 
AS total
FROM inventory
GROUP BY itemName -- I am using GROUP BY here because U can group all the items with the same name in different inventories.
ORDER BY COUNT(itemName) DESC -- Then I use the COUNT function to help me get the totals of said items in each inventory.
GO