 -- szef:
INSERT INTO Person(id, name, age, chef_id) VALUES (1, 'Johny Wick', 30, null);

-- pracownicy:
INSERT INTO Person(id, name, age, chef_id) VALUES (2, 'Foo Bar', 18, 1);
INSERT INTO Person(id, name, age, chef_id) VALUES (3, 'Doo Boo', 20, 1);
INSERT INTO Person(id, name, age, chef_id) VALUES (4, 'Daisy Crazy', 30, 1);
INSERT INTO Person(id, name, age, chef_id) VALUES (5, 'Big Chef', 50, 1);

-- pracownik w strukturze drzewiastej
INSERT INTO Person(id, name, age, chef_id) VALUES (6, 'Pracownik', 50, 5);



INSERT INTO GURU_TASKS(id, descr) VALUES (1, 'Maven');
INSERT INTO GURU_TASKS(id, descr) VALUES (2, 'Java8');
INSERT INTO GURU_TASKS(id, descr) VALUES (3, 'AngularJS');


INSERT INTO PERSON_GURUTASKS(PERSON_ID, GURUTASK_ID) VALUES (1,1);
INSERT INTO PERSON_GURUTASKS(PERSON_ID, GURUTASK_ID) VALUES (1,2);
INSERT INTO PERSON_GURUTASKS(PERSON_ID, GURUTASK_ID) VALUES (1,3);