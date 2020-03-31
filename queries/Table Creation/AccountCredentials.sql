CREATE TABLE AccountCredentials (
	email VARCHAR(50),
	PRIMARY KEY (email),
	FOREIGN KEY (email) REFERENCES Accounts(email),
	password VARCHAR(50)
);