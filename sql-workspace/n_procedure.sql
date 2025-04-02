/*
DELIMITER $$
CREATE PROCEDURE 프로시저명 ( [매개변수 목록] )
BEGIN
    -- SQL 문들
END$$
DELIMITER ;

매개변수 
IN : 입력값 전달
OUT : 출력값 반환
INOUT : 입력도 하고 수정된 값도 반환
CRUD 문법 (프로시저 안에서도 동일하게 사용 가능)

ex)
CREATE PROCEDURE sample_proc(IN param1 INT, OUT result INT)
BEGIN
   SELECT param1 * 2 INTO result;
END;
*/

-- 01. sample_proc를 호출해보자
SET @OUTPUT = 0; -- OUT result INT 파라미터 저장할 변수
call sample_proc(5, @OUTPUT);
select @output as result;

-- 02. 두 수를 입력받아 사칙연산 프로시저를 호출해보자
/*
set @a = 10;
set @b = 5;
set @hap = 0;
set @sub = 0;
set @mul = 0;
set @r_div = 0;
*/

set @a = 10, @b = 5, @hap = 0, @sub = 0, @mul = 0, @r_div = 0; -- 한줄로 선언 가능

-- 프로시저 호출
call my_calc(@a, @b, @hap, @sub, @mul, @r_div);

-- 결과 출력
select @hap, @sub, @mul, @r_div;

call my_emp.doiterate(6);
select @x;

call dorepeat(10);
select @x;

use my_emp;
SELECT  * 
FROM EMP;

DROP TABLE EMP_TEST;
-- Q1) 제약 조건이 없는 사원 테이블 `EMP_TEST`를 생성해보자.
create table emp_test
as
select *
from emp;

select * from emp_test;
-- Q2) `PRO01_INSERT`() 프로시저를 작성하여, `EMP_TEST`에 사원의 번호, 이름, 부서번호를 여러 건 입력하자.
call PRO01_INSERT();

-- Q3) `PRO02_DELETE`(IN E_NO INT) 프로시저를 작성하여, 사원 번호를 입력받아 해당 사원을 삭제해보자.
call PRO02_DELETE(3);

-- Q4) `PRO03_UPDATE`(IN E_NO INT, IN E_NAME VARCHAR(50)) 프로시저를 작성하여, 사번에 해당하는 사원의 이름을 수정하자.
call PRO03_UPDATE(2, '홍길동');

-- Q5) `PRO04_SELECT`(IN EMP_NAME VARCHAR(50)) 프로시저를 작성하여, 사원 이름으로 해당 사원의 정보를 조회하자.
call PRO04_SELECT('홀길동');

-- 프로시저 확인
show procedure status where db = 'my_emp';

-- 특정 프로시저 내용 확인
show create procedure my_emp.PRO01_INSERT;

-- Q6) `PRO05_COUNT`(OUT CNT INT) 프로시저를 작성하여, EMP_TEST 테이블의 총 사원 수를 반환하자.
call PRO05_COUNT(@RES); -- 프로시저 호출시 OUT으로 리턴되는 값 받을 수 있는 변수 선언
select @RES; -- 개수 출력

-- Q7) `PRO06_SELECTALL`() 프로시저를 작성하여, EMP_TEST 테이블의 모든 데이터를 조회하자.
call PRO06_SELECTALL();

-- Q8) `PRO07_IF`(IN ENO INT) 프로시저를 작성하여,
--      사원이 존재하면 해당 사원의 월급을 2배로 인상하고, 
--      존재하지 않으면 메시지를 출력하자.
set @ENO = 7902;
call PRO07_IF(@ENO);

-- Q9) `PRO08_IF`(IN IN_SAL DECIMAL) 프로시저를 작성하여,
--      입력받은 월급보다 많이 받는 사원의 이름과 급여를 출력하되, 
--      존재하지 않으면 메시지를 출력하자.
call PRO08_IF(1000);

/*  <<예외>> 
1) DECLARE ... HANDLER : CONTINUE, EXIT, UNDO 핸들러를 통해 오류 발생 후의 흐름 제어
         -DECLARE CONTINUE HANDLER FOR condition action: 지정된 조건이 발생하면 현재 실행 중인 구문을 완료하고 다음 구문을 계속 실행
         -DECLARE EXIT HANDLER FOR condition action: 지정된 조건이 발생하면 현재 블록(BEGIN ... END)을 즉시 종료
         -DECLARE UNDO HANDLER FOR condition action: (트랜잭션 스토리지 엔진에서) 지정된 조건이 발생하면 현재 트랜잭션을 롤백
         
condition 부분 지정  옵션 = SQLSTATE value: 특정 SQLSTATE 값 (5자리 문자열, 예를 들어 '45000').=SQLEXCEPTION: 모든 SQLSTATE 값 중에서 일반적인 오류를 나타내는 클래스=SQLWARNING: 모든 SQLSTATE 값 중에서 경고를 나타내는 클래스= NOT FOUND: 커서 작업에서 더 이상 행이 없을 때 발생하는 조건 (SQLSTATE '02000').=specific_error_code: 특정 MySQL 오류 코드 (정수).
2) SIGNAL SQLSTATE :SQL 예외 발생
3) GET DIAGNOSTICS:발생한 오류에 대한 자세한 정보(SQLSTATE, 오류 코드, 메시지 등)확인

*/

-- Q10) 모든 사원의 급여를 입력받은 비율만큼 인상하는 프로시저를 작성하자. (예: 비율 1.1 → 10% 인상)
call PRO09_IF(0);

-- Q10-1)
drop table t;
create table t(s1 int primary key);

call handlerdemo();
select @x;
select @x2;

-- Q11) `DO` 문을 활용하여 반복 또는 조건문 기반 로직을 실습해보자.
create table if not exists random_members (
id int auto_increment primary key,
name varchar(50),
phone varchar(20),
join_date DATE
);

select datediff('2024-12-31', '2020-01-01');
call PRO11_INSERT_random_members();
select * from random_members;

-- Q12) `CURSOR`(커서)를 이용한 프로시저를 작성하여, TEST_EMP의 사원의 이름과 봉급을 출력해보자
call PRO12_CURSOR_SELECT();

call PRO12_CURSOR_SELECT02();
-- Q13) `CURSOR`(커서)를 이용한 프로시저를 작성하여, 부서번호가 10번인 사원들을 순차적으로 출력하자.



 
 
 
 
 
 
 
 
 
 


