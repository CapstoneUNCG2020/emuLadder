CREATE TABLE contest_information (
	contest_id INT AUTO_INCREMENT,
	contest_name CHAR(50) NOT NULL,
	game_url CHAR(50) NOT NULL,
	max_players INT NOT NULL,
	PRIMARY KEY (contest_id)
);