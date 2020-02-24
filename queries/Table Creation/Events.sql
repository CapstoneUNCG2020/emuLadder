CREATE TABLE Events (
	eventId INT AUTO_INCREMENT,
	PRIMARY KEY (eventId),
	name VARCHAR(50),
	startTime DATETIME,
	currentState INT,
	link VARCHAR(50)
);