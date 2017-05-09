CREATE TABLE CONTACTS ( 
	ID integer, 
	FNAME varchar(100), 
	LNAME varchar(100), 
	EMAIL varchar(255), 
	CONTACT_TYPE varchar(30), 
	AGE          integer,
	CONSTRAINT CONTACTS_pk primary key (ID)
);

CREATE TABLE HOBBIES ( 
	ID integer, 
	CONTACT_ID integer references CONTACTS (ID), 
	HOBBY varchar(100),
	SINCE date,
	CONSTRAINT HOBBIES_pk primary key (ID) 
);