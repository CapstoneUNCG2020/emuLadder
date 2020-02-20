CREATE TABLE ContestEvents (
	contestEventsId INT AUTO_INCREMENT,
	PRIMARY KEY (contestEventsId),
	contestId INT,
	FOREIGN KEY (contestId) REFERENCES Contests(contestId),
	eventId INT,
	FOREIGN KEY (eventId) REFERENCES Events(eventId)
);