/*=================================================================== 
Author: Liam Baron
Date: 2023/08/23
Purpose: To insert data within tables
=====================================================================*/

USE mmorpg
GO

INSERT INTO error
VALUES (
	0,
	'The program has stopped working'
),
(
	1,
	'The account is not accessible'
),
(
	2,
	'The server is under maintenance'
),
(
	3,
	'Account is blocked'
),
(
	4,
	'Access denied'
),
(
	5,
	'Account is banned'
),
(
	6,
	'Game needs to update'
)

GO 

INSERT INTO account(accName, bankNum)
VALUES ('PowerShot', 34961204),
('John1000', 49180883),
('GIJOE23', 64320296),
('MaxSteel2392', 15785666),
('KenZenII', 17020768),
('SHADOWDRAGOON', 55329561),
('HarryBorne', 56931150)
GO

INSERT INTO errorType 
VALUES ('Bad Gateway', 'MaxSteel2392',1),
('No internet', 'SHADOWDRAGOON', 0),
('Banned', 'KenZenII', 5),
('Blocked', 'PowerShot', 3),
('Game Unavailable', 'HarryBorne', 6)
GO

INSERT INTO fee
VALUES (0, '2023/02/23', 'First payment of subscription'),
(1, '2023/10/19', 'Third payment of subscription'),
(2, '2023/04/12', 'Fifth payment of subscription'),
(3, '2023/07/02', 'Tenth payment of subscription'),
(4, '2022/11/29', 'Second payment of subscription'),
(5, '2023/01/13', 'First payment of subscription'), 
(6, '2023/03/21', 'Second payment of subscription')
GO

INSERT INTO accTime 
VALUES ('2022/11/29', '2022/12/29','SHADOWDRAGOON', 4), 
('2023/02/23', '2023/03/23','HarryBorne', 0),
('2023/01/13', '2023/02/13','MaxSteel2392', 5), 
('2023/04/12', '2023/05/12','KenZenII', 2),
('2023/03/21', '2023/04/21','PowerShot', 6)
GO

INSERT INTO accCharacter
VALUES ('Imperial','ASC',21, 'MaxSteel2392'),
('NINJA','TSM' ,65, 'SHADOWDRAGOON'),
('BREADZOOKA', 'C9', 24, 'KenZenII'),
('Swift', 'H2O', 54, 'HarryBorne'),
('Warlord353', 'MTN',1, 'PowerShot')
GO

INSERT INTO inventory
VALUES (1, 1, 'NINJA','Master Sword', 'Legendary'),
(5, 10, 'Imperial', 'Big Heal Potion', 'Rare'),
(3, 5, 'Swift', 'Big Heal Potion', 'Rare'),
(8, 2, 'BREADZOOKA', 'Big Heal Potion', 'Rare'),
(2, 4, 'Warlord353', 'Fire Rod', 'Mythic')
GO