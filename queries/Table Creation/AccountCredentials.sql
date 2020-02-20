CREATE TABLE AccountCredentials (
	userId VARCHAR(50),
	PRIMARY KEY (userId),
	FOREIGN KEY (userId) REFERENCES Accounts(userId),
	password VARCHAR(50)
);