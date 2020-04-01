CREATE TABLE Events (
	eventId INT AUTO_INCREMENT,
	PRIMARY KEY (eventId),
	name VARCHAR(50),
	startTime DATETIME,
	currentState INT,
	link VARCHAR(50),
	teamName VARCHAR(255),
	teamCode VARCHAR(10),
	teamName2 VARCHAR(255),
	teamCode2 VARCHAR(10)
);