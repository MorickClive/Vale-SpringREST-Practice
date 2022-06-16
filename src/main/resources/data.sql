INSERT INTO PERSON(forename, surname, age) VALUES 
('Morick', 'Clive', 34),
('Safiya', 'Founder', 25),
('Caspian', 'Lovett', 27);

INSERT INTO NOTE_GROUP (label) values ('Test Note');
INSERT INTO NOTE_GROUP (label) values ('Test Note 2');
INSERT INTO NOTE (fk_id, header, contents) values (1, 'GROUP 1: FirstMessage', 'More details below');
INSERT INTO NOTE (fk_id, header, contents) values (1, 'GROUP 1: Another Message', 'More details below');
INSERT INTO NOTE (fk_id, header, contents) values (2, 'GROUP 2: FirstMessage', 'More details below');
