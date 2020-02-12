CREATE TABLE account_credentials (
	email CHAR(50) NOT NULL,
    password CHAR(50) NOT NULL,
    CONSTRAINT account_credentials_pk PRIMARY KEY (email),
    CONSTRAINT account_credentials_fk 
		FOREIGN KEY (email) 
		REFERENCES account_information(email)
);