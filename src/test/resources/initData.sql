INSERT into user (id, username, password) VALUES (1, 'test','test');
INSERT into user (username, password) VALUES ('test2','test2');

INSERT into category (id, name) VALUES (1, 'Testkategorie');
INSERT into category (name) VALUES ('Testkategorie2');

INSERT into department (id, name, location) VALUES (1, 'Testdepartment', 'Testlocation');

INSERT into entry (CHECK_OUT, CHECK_IN, USER_ID, CATEGORY_ID, DEPARTMENT_ID)
VALUES ('2020-09-23T10:29:00', '2020-09-24T10:29:00', 1, 1, 1);