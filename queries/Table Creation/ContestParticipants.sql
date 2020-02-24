CREATE TABLE ContestParticipants (
	contestParticipantsId INT AUTO_INCREMENT,
	PRIMARY KEY (contestParticipantsId),
	contestId INT,
	FOREIGN KEY (contestId) REFERENCES Contests(contestId),
	userId VARCHAR(50),
	FOREIGN KEY (userId) REFERENCES Accounts(userId),
	points INT
);