CREATE TABLE Players (
	playerId INT AUTO_INCREMENT,
	PRIMARY KEY (playerId),
	firstName VARCHAR(50),
	lastName VARCHAR(50),
	displayName VARCHAR(50),
	image VARCHAR(50),
	salary INT,
	teamId VARCHAR(20),
	teamName VARCHAR(255),
	teamCode VARCHAR(10),
	role VARCHAR(20),
	region VARCHAR (20)
);