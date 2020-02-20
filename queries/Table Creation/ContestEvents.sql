CREATE TABLE ContestEvents (
	contestId INT,
	FOREIGN KEY (contestId) REFERENCES Contests(contestId),
	eventId INT,
	FOREIGN KEY (eventId) REFERENCES Events(eventId)
);