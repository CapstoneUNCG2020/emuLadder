CREATE TABLE participants (
	email CHAR(50) NOT NULL,
	contest_id INT NOT NULL,
	player_id INT NOT NULL,
	FOREIGN KEY (email)
		REFERENCES account_information(email),
	FOREIGN KEY (contest_id)
		REFERENCES contest_information(contest_id),
	FOREIGN KEY (player_Id)
		REFERENCES player_information(player_id)
);
