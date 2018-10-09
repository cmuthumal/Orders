CREATE DATABASE ceymoss01;
USE ceymoss01;

CREATE TABLE User (
	id int(10) NOT NULL,
	pin int(10),
	CONSTRAINT PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE Shop (
	id int(10) NOT NULL,
	shopName varchar(255),
	shopAddress varchar(255),
	contact varchar(255),
	CONSTRAINT PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE ItemType (
	id int(10) NOT NULL,
	itemType varchar(255),
	CONSTRAINT PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE Brand (
	id int(10) NOT NULL,
	brandName varchar(255),
	CONSTRAINT PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE Technician (
	id int(10) NOT NULL,
	technicianName varchar(255),
	CONSTRAINT PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE Customer (
	id int(10) NOT NULL,
	customerName varchar(255),
	phone int(10),
	customerAddress varchar(255),
	CONSTRAINT PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE Job (
	id int(10) NOT NULL,
	noteNo varchar(255) NOT NULL,
	customerID int(10),
	addedDate date,
	itemTypeID int(10),
	brandID int(10),
	model varchar(255),
	serialNo varchar(255),
	numOfTimes int(10),
	errorDesc varchar(255),
	notes varchar(255),
	CONSTRAINT PRIMARY KEY (noteNo),
	CONSTRAINT FOREIGN KEY(customerID) REFERENCES ItemType(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FOREIGN KEY(itemTypeID) REFERENCES Customer(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FOREIGN KEY(brandID) REFERENCES Brand(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

CREATE TABLE JobDone (
	id int(10) NOT NULL,
	noteNo varchar(255),
	issuedDate date,
	warranty int(10),
	remarks varchar(255),
	cost decimal(12,2),
	sellingPrice decimal(12,2),
	technicianID int(10),
	CONSTRAINT PRIMARY KEY (id),
	CONSTRAINT FOREIGN KEY(noteNo) REFERENCES Job(noteNo) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT FOREIGN KEY(technicianID) REFERENCES Technician(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

INSERT INTO User VALUES ('1','1234');
INSERT INTO Shop VALUES ('1','MARS Computers & Security Solutions','No 05, Minuwangoda Junction, Galle.','071 495 6572, 091 5 707908, 091 2 246887');
INSERT INTO ItemType VALUES ('1','Laptop');
INSERT INTO ItemType VALUES ('2','Desktop');
INSERT INTO ItemType VALUES ('3','Monitor');
INSERT INTO Brand VALUES ('1','HP');
INSERT INTO Brand VALUES ('2','Apple');
INSERT INTO Brand VALUES ('3','Dell');
INSERT INTO Technician VALUES ('1','Kasun');
INSERT INTO Technician VALUES ('2','Damith');
INSERT INTO Technician VALUES ('3','Sandun');
INSERT INTO Customer VALUES ('1','Michael Jordan','0912212345','90/2, Wiskam Rd, Wakunagoda, Galle');
INSERT INTO Customer VALUES ('2','Arthur Curry','0914123456','78/1, Godakanda Rd, Karapitiya, Galle');
INSERT INTO Customer VALUES ('3','Clint Barton','0917456789','32/5, Circular Rd, Magalle, Galle');
INSERT INTO Job VALUES ('1','N0001','1','2018-10-06','1','1','ProBook','','1','Krr sound','Laptop received with power cord, adaptor and mouse.');
INSERT INTO Job VALUES ('2','N0002','1','2018-10-06','3','1','LCD','FHSHF456123789','2','Display suddenly goes white','Monitor received with power cord, adaptor and HDMI cable.');
INSERT INTO Job VALUES ('3','N0003','2','2018-10-06','2','2','iMac','YEBFJF456789416','3','Slow performance','');
INSERT INTO JobDone VALUES ('1','N0001','2018-10-07','3','Replaced HDD','7000.00','8500.00','1');
INSERT INTO JobDone VALUES ('2','N0003','2018-10-07','6','Updated OS','1000.00','1200.00','2');