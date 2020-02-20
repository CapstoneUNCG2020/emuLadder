CREATE TABLE EventPoints (
	eventPointsId INT AUTO_INCREMENT,
	PRIMARY KEY (eventPointsId),
	eventId INT,
	FOREIGN KEY (eventId) REFERENCES Events(eventId),
	playerId INT,
	FOREIGN KEY (playerId) REFERENCES Players(playerId),
	points INT
);