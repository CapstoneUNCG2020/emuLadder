CREATE TABLE ContestPlayers (
	contestPlayersId INT AUTO_INCREMENT,
	PRIMARY KEY (contestPlayersId),
	contestId INT,
	FOREIGN KEY (contestId) REFERENCES Contests(contestId),
	playerId INT,
	FOREIGN KEY (playerId) REFERENCES Players(playerId)
);