CREATE TABLE LeagueStats (
	eventPointsId INT,
	PRIMARY KEY (eventPointsId),
	FOREIGN KEY (eventPointsId) REFERENCES EventPoints(eventPointsId),
	deaths INT,
	assists INT,
	kills INT,
	creepScore INT
);