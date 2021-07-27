USE RESERVATION;

SELECT * FROM USER;

CREATE TABLE user_backup AS SELECT * FROM USER;
SELECT * FROM user_backup;

CREATE TABLE user_role_backup AS SELECT * FROM user_role;
SELECT * FROM user_role_backup;

delete from user_role;
delete from USER;

SELECT * FROM USER;
SELECT * FROM ROLE;
SELECT * FROM user_role;

insert into user_role values(5,1);