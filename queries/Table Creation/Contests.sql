CREATE TABLE Contests (
	contestId INT AUTO_INCREMENT,
	PRIMARY KEY (contestId),
	createdBy VARCHAR(50),
	FOREIGN KEY (createdBy) REFERENCES Accounts(userId),
	startTime DATETIME,
	name VARCHAR(50),
	currentState INT
);