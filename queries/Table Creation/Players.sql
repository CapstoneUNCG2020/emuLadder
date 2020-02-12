CREATE TABLE players (
	contest_id INT,
	player_id INT,
	FOREIGN KEY (contest_id) REFERENCES contest_information(contest_id),
	FOREIGN KEY (player_id) REFERENCES player_information(player_id)
);