CREATE TABLE CONTACTS ( 
ID integer, 
FNAME varchar(100), 
LNAME varchar(100), 
EMAIL varchar(255), 
CONTACT_TYPE varchar(30), 
AGE          integer,
CONSTRAINT CONTACTS_pk primary key (ID)
);

CREATE TABLE CHILDREN ( 
ID integer, 
CONTACT_ID integer references CONTACTS (ID), 
FNAME varchar(30), 
AGE   integer,
CONSTRAINT CHILDREN_pk primary key (ID)
);

CREATE TABLE HOBBIES ( 
ID integer, 
CONTACT_ID integer references CONTACTS (ID), 
HOBBY varchar(100),
CONSTRAINT HOBBIES_pk primary key (ID) 
) ;

insert into CONTACTS (id, fname,lname, email, contact_type, age) values (1, 'Dave','Smith','dsmith@icloud.com', 'friend', 46);

insert into CONTACTS (id, fname,lname, email, contact_type, age) values (2, 'Xena','Johnson','xjonson@icloud.com', 'friend', 46);

insert into CONTACTS (id, fname,lname, email, contact_type, age) values (3, 'Fred','Jackon','fjackson@icloud.com', 'co-worker', 18);

insert into CONTACTS (id, fname,lname, email, contact_type, age) values 
  (4, 'Alma','Tyler','atyler@icloud.com', 'contact', 57);


insert into CONTACTS (id, fname,lname, email, contact_type, age) values 
  (5,'Jane','Edwards','jedwards@icloud.com', 'contact', 40);


insert into CONTACTS (id,fname,lname, email, contact_type, age) values 
  (6,'Jill','Jackson','jjackson@icloud.com', 'friend', 24);


insert into CHILDREN (id, contact_id, fname, age) values (1, 5, 'Sam', 5);


insert into CHILDREN (id, contact_id, fname, age) values (2, 1, 'Ruby', 2);


insert into CHILDREN (id, contact_id, fname, age) values (3, 1, 'Robert', 4);


insert into CHILDREN (id, contact_id, fname, age) values (4, 1, 'Roman', 6);


insert into HOBBIES (id, contact_id, hobby) values (1, 1, 'Horseback Riding');


insert into HOBBIES (id, contact_id, hobby) values (2, 2, 'Sailing');


insert into HOBBIES (id, contact_id, hobby) values (3, 1, 'Guitar');


insert into HOBBIES (id, contact_id, hobby) values (4, 3, 'Skiing');


insert into HOBBIES (id, contact_id, hobby) values (5, 3, 'Scuba');


insert into HOBBIES (id, contact_id, hobby) values (6, 4, 'Photography');


insert into HOBBIES (id, contact_id, hobby) values (7, 6, 'Travel');


insert into HOBBIES (id, contact_id, hobby) values (8, 6, 'Guitar');

commit;
