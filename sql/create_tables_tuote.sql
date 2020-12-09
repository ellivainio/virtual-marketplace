CREATE TABLE tuote (
	id int NOT NULL AUTO_INCREMENT,
	nimi varchar(100),
	kuvaus varchar(100),
	hinta decimal(10,2),
	PRIMARY KEY (id)
)engine=InnoDB;

CREATE TABLE vaate (
	id int NOT NULL AUTO_INCREMENT,
	nimi varchar(100),
	kuvaus varchar(100),
	hinta decimal(10,2),
	koko varchar(100),
	merkki varchar(100),
	PRIMARY KEY (id)
)engine=InnoDB;