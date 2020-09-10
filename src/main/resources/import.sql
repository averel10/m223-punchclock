INSERT into user (id, username, password) VALUES (1, 'test','$2a$10$V/28B6zZL1uX/22PtGrTOeun2BaQ86WMtoEUEDgAkW2A9.YaqxI5G');/*pw:test*/
INSERT into user (username, password) VALUES ('test2','$2a$10$eSKaHPEw1C3LiFK9nTktNe77cKTM0/6y67D6jFUFFglAGMZrZbIxC');/*pw:test2*/

INSERT into category (id, name) VALUES (1, 'Testkategorie');
INSERT into category (name) VALUES ('Testkategorie2');

INSERT into department (id, name, location) VALUES (1, 'Testdepartment', 'Testlocation');

INSERT into entry (CHECK_IN, CHECK_OUT, USER_ID, CATEGORY_ID, DEPARTMENT_ID) VALUES ('2020-09-23T10:29:00', '2020-09-24T10:29:00', 1, 1, 1);