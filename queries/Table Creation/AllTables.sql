CREATE TABLE Accounts (
	userId VARCHAR(50),
	PRIMARY KEY (userId),
	email VARCHAR(50),
	firstName VARCHAR(50),
	lastName VARCHAR(50)
);

CREATE TABLE AccountCredentials (
	userId VARCHAR(50),
	PRIMARY KEY (userId),
	FOREIGN KEY (userId) REFERENCES Accounts(userId),
	password VARCHAR(50)
);

CREATE TABLE Contests (
	contestId INT AUTO_INCREMENT,
	PRIMARY KEY (contestId),
	createdBy VARCHAR(50),
	FOREIGN KEY (createdBy) REFERENCES Accounts(userId),
	startTime DATETIME,
	name VARCHAR(50),
	currentState INT
);

CREATE TABLE ContestParticipants (
	contestParticipantsId INT AUTO_INCREMENT,
	PRIMARY KEY (contestParticipantsId),
	contestId INT,
	FOREIGN KEY (contestId) REFERENCES Contests(contestId),
	userId VARCHAR(50),
	FOREIGN KEY (userId) REFERENCES Accounts(userId),
	points INT
);

CREATE TABLE Events (
	eventId INT AUTO_INCREMENT,
	PRIMARY KEY (eventId),
	name VARCHAR(50),
	startTime DATETIME,
	currentState INT,
	link VARCHAR(50)
);

CREATE TABLE ContestEvents (
	contestEventsId INT AUTO_INCREMENT,
	PRIMARY KEY (contestEventsId),
	contestId INT,
	FOREIGN KEY (contestId) REFERENCES Contests(contestId),
	eventId INT,
	FOREIGN KEY (eventId) REFERENCES Events(eventId)
);

CREATE TABLE Players (
	playerId INT AUTO_INCREMENT,
	PRIMARY KEY (playerId),
	firstName VARCHAR(50),
	lastName VARCHAR(50),
	displayName VARCHAR(50),
	image VARCHAR(50),
	salary INT
);

CREATE TABLE ContestPlayers (
	contestPlayersId INT AUTO_INCREMENT,
	PRIMARY KEY (contestPlayersId),
	contestId INT,
	FOREIGN KEY (contestId) REFERENCES Contests(contestId),
	playerId INT,
	FOREIGN KEY (playerId) REFERENCES Players(playerId)
);

CREATE TABLE EventPoints (
	eventPointsId INT AUTO_INCREMENT,
	PRIMARY KEY (eventPointsId),
	eventId INT,
	FOREIGN KEY (eventId) REFERENCES Events(eventId),
	playerId INT,
	FOREIGN KEY (playerId) REFERENCES Players(playerId),
	points INT
);

CREATE TABLE LeagueStats (
	eventPointsId INT,
	PRIMARY KEY (eventPointsId),
	FOREIGN KEY (eventPointsId) REFERENCES EventPoints(eventPointsId),
	deaths INT,
	assists INT,
	kills INT,
	creepScore INT
);