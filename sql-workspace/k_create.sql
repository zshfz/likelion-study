-- 1) CREATE TABLE로 새 테이블 만들기
-- 2) CREATE TABLE에서 기본 키 (PRIMARY KEY) 제약 조건 지정
-- 3) CREATE TABLE에서 고유 키(UNIQUE KEY) 제약 조건 지정
-- 4) CREATE TABLE에서 검사 (CHECK) 제약 조건 지정
-- 5) CREATE TABLE에서 열에 기본값 지정  DEFAULT 
-- 6) CREATE TABLE에서 외래 키 (FOREIGN KEY) 제약 조건 지정

--  << 학생 정보를 유지하기 위한 students 테이블 생성 >>- 

CREATE DATABASE  STUDENTS;
USE STUDENTS;
DROP TABLE STUDENTS;
-- Q1) CREATE TABLE로 새 테이블 만들기

create table students(
student_id int,
student_number varchar(10),
frist_name varchar(50),
last_name varchar(50),
middle_name varchar(50),
birthday date,
gender enum('m', 'f'),
paid_flag bool
);

desc students;
-- Q1-1 데이터 입력
insert into students values 
(1,'1','1','1','1',now(), 'm', true),
(2,'1','1','1','1',now(), 'f', 0),
(3,'1','1','1','1',now(), 'f', false),
(4,'1','1','1','1',now(), 'm', true);

-- Q1-2 전체 내용 확인
select * from students;

-- Q2. CREATE TABLE로 새 테이블 만들기
-- CREATE TABLE에서 기본 키 제약 조건 지정 _ 식별키
-- 테이블당 하나만 지정할 수 있다
create table students02(
student_id int,
student_number varchar(10) not null,
frist_name varchar(50) not null,
last_name varchar(50) not null,
middle_name varchar(50) not null,
birthday date,
gender enum('m', 'f'),
paid_flag bool,
primary key(student_id)
);

desc students02;
-- Q2-1 데이터 입력
insert into students02 values 
(1,'1','1','1','1',now(), 'm', true),
(2,'1','1','1','1',now(), 'f', 0),
(3,'1','1','1','1',now(), 'f', false),
(4,'1','1','1','1',now(), 'm', true);

-- Q2-2 전체 내용 확인
desc students02;

-- Q2-3 PK 확인
insert into students02 values 
(1,'1','1','1','1',now(), 'm', true); #에러

-- Q2-4 정보를 확인해보자
SHOW CREATE TABLE students;
SHOW CREATE TABLE students02;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM information_schema.TABLE_CONSTRAINTS
WHERE TABLE_SCHEMA = 'STUDENTS' AND TABLE_NAME = 'students';

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM information_schema.TABLE_CONSTRAINTS
WHERE TABLE_SCHEMA = 'STUDENTS' AND TABLE_NAME = 'students02';

-- Q3 PK 복합키를 확인해보자
create table students03(
student_id int,
student_number varchar(10),
primary key(student_id, student_number) 
);

desc students03;
-- Q3-1 데이터를 입력해보자
insert into students03 values 
(1,1),(1,2),(1,3),(1,4);

insert into students03 values 
(2,1),(2,2),(2,3),(2,4);

insert into students03 values 
(3,'1'),(3,'2'),(3,'3'),(3,'4');

insert into students03 values 
(3,1),(3,2),(3,3),(3,null); #에러

select * from students03;

-- Q3-2 제약조건을 확인하자
SHOW CREATE TABLE students03;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM information_schema.TABLE_CONSTRAINTS
WHERE TABLE_SCHEMA = 'STUDENTS' AND TABLE_NAME = 'students03';

-- Q4) 자동증가 구현하는 제약조건 확인해보자
 create table students04(
student_id int auto_increment,
student_number varchar(10) not null,
primary key(student_id)
);

desc students04;

insert into students04(student_number) values 
(10),(20),(30),(40);

select * from students04;

-- Q4-1 테이블 수정하자 자동증가 초기값 100으로
alter table students04 auto_increment = 100;

insert into students04(student_number) values 
(10),(20),(30),(40);

select * from students04;

-- 번외
create table t1 (
c1 int unsigned not null auto_increment primary key,
c2 char(1)
) engine = innodb;

desc t1;

insert into t1(c1,c2) values (1,'a'),(null,'b'),(5,'c'),(null,'d');

select * from t1;

show table status like 'students04';

-- t1 테이블의 키 삭제해보자
alter table t1 modify column c1 int;
alter table t1 drop primary key; -- auto_increment 걸려있는 기본키 삭제하려면 먼제 auto_increment 먼저 없애야 함

-- Q5) 자동증가 구현하는 제약조건 확인해보자 PK도 걸고 자동증가도 걸고 기본값도 지정하자
 create table students05(
student_id int auto_increment,
student_number varchar(10) default 'abc',
primary key(student_id, student_number)
);

desc students05;

insert into students05 values 
(1, 10),(2,20),(3,30),(4,40);

insert into students05(student_id) values(1);

select * from students05;

-- Q6) 복합키, 자동증가, 기본값으로 지정하고 각 제약조건 삭제해보자
 create table students06(
student_id int auto_increment,
student_number varchar(10) default 'abc',
student_name varchar(50),
primary key(student_id, student_number)
);

insert into students06(student_name)
values(1);

select * from students06;

-- Q6-1 기본키 삭제
alter table students06 modify column student_id int; -- 자동 증가 속성 해제해야 기본키 삭제 가능

alter table students06 drop primary key;

-- Q6-2 default 삭제
alter table students06
alter student_number
drop default;

desc students06;

-- Q6-3 default 추가
alter table students06
alter student_number
set default 'abc';

-- Q7 제약조건을 생성해보자
 create table students07(
student_id int,
student_number varchar(10),
birthday date,
check(birthday >= '2000-01-01'),
unique key(student_id)
);

desc students07;

insert into students07(student_id) values(null);
insert into students07(student_id, birthday) values(1, now());
insert into students07(student_id, birthday) values(2, now());
insert into students07(student_id, birthday) values(3, '1999-01-01'); 

select * from students07;

show create table students07;

-- 제약조건 확인
SELECT CONSTRAINT_NAME, CHECK_CLAUSE
FROM information_schema.CHECK_CONSTRAINTS; 

-- Q7-1 제약조건을 확인 후 체크제약조건을 삭제해보자
alter table students07 drop check students07_chk_1;

-- Q7-2 테이블의 제약 조건을 확인하고 남아있는 키값을 삭제하자
-- 유니크 키는 drop index로 삭제
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM information_schema.TABLE_CONSTRAINTS
WHERE TABLE_NAME = 'students07';

alter table student07
drop index student_id;

show keys from students07;

-- Q8) 참조형 테이블을 생성해 보자
drop table students05;

 create table students05(
student_id int auto_increment,
student_number varchar(10) default 'abc',
primary key(student_id)
);

insert into students05 values(1,2),(2,2);

create table student_my(
student_id int,
foreign key(student_id)references students05(student_id)
);

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM information_schema.TABLE_CONSTRAINTS
WHERE TABLE_NAME = 'student_my';

SELECT CONSTRAINT_NAME, UPDATE_RULE, DELETE_RULE, REFERENCED_TABLE_NAME
FROM information_schema.REFERENTIAL_CONSTRAINTS
WHERE TABLE_NAME = 'student_my';

insert into student_my values(1);
insert into student_my values(null);
insert into student_my values(3); #에러
select * from student_my;


