--board
CREATE TABLE board (
board_idx int NOT NULL,
employee_idx varchar(45)  NOT NULL,
board_type varchar(45) NOT NULL,
content varchar(45) NOT NULL,
attached_file varchar(45) NOT NULL,
date_created varchar(45) NOT NULL,
modified_date varchar(45) NOT NULL,
state varchar(45) NOT NULL,
PRIMARY KEY (board_idx));
SELECT *FROM board;
--EMPLOYEE
CREATE TABLE "EMPLOYEE" 
   ("EMP_IDX" NUMBER, 
	"COMPANY_IDX" NUMBER, 
	"TEAM_IDX" NUMBER, 
	"DUTY_IDX" NUMBER, 
	"POSITION_IDX" NUMBER, 
	"AUTHORITY_IDX" NUMBER, 
	"NAME" VARCHAR2(100), 
	"EN_NAME" VARCHAR2(100), 
	"PROFILE_IMAGE" VARCHAR2(100), 
	"GENDER" VARCHAR2(100), 
	"BIRTHDAY" VARCHAR2(100), 
	"PHONE_NUMBER" VARCHAR2(100), 
	"EMAIL" VARCHAR2(100), 
	"ADDRESS" VARCHAR2(100), 
	"SALARY" NUMBER, 
	"ANNUAL_LEAVE" NUMBER, 
	"STATE" VARCHAR2(100), 
	"HIRE_DATE" DATE, 
	"RESIGNATION_DATE" DATE, 
	"CREATE_DATE" DATE, 
	"DEPARTMENT_IDX" NUMBER, 
	 CONSTRAINT "EMPLOYEE_PK" PRIMARY KEY ("EMP_IDX"));
	
	 
	 
	 
	 select * from board;

DELETE from board WHERE employee_idx!=null;


select * from Employee;

		SELECT * FROM Board b,Employee e where b.employee_idx = e.employee_idx	;
commit;
SELECT * 
FROM Board b 
left join Employee e on b.employee_idx = e.employee_idx
where b.employee_idx = e.employee_idx;
--alter table board modify(
--
--ALTER TABLE board MODIFY employee_idx NUMBER;
--ALTER TABLE board DROP COLUMN employee_idx;
--ALTER TABLE board add employee_idx NUMBER;

ALTER TABLE boardattach MODIFY (FILE_TYPE DEFAULT '0');

commit;