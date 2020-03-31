CREATE TABLE ContestParticipants (
	contestParticipantsId INT AUTO_INCREMENT,
	PRIMARY KEY (contestParticipantsId),
	contestId INT,
	FOREIGN KEY (contestId) REFERENCES Contests(contestId),
	email VARCHAR(50),
	FOREIGN KEY (email) REFERENCES Accounts(email),
	points INT
);