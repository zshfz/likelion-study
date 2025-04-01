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

-- Q2) `PRO01_INSERT`() 프로시저를 작성하여, `EMP_TEST`에 사원의 번호, 이름, 부서번호를 여러 건 입력하자.

-- Q3) `PRO02_DELETE`(IN E_NO INT) 프로시저를 작성하여, 사원 번호를 입력받아 해당 사원을 삭제해보자.

-- Q4) `PRO03_UPDATE`(IN E_NO INT, IN E_NAME VARCHAR(50)) 프로시저를 작성하여, 사번에 해당하는 사원의 이름을 수정하자.

-- Q5) `PRO04_SELECT`(IN EMP_NAME VARCHAR(50)) 프로시저를 작성하여, 사원 이름으로 해당 사원의 정보를 조회하자.

-- Q6) `PRO05_COUNT`(OUT CNT INT) 프로시저를 작성하여, EMP_TEST 테이블의 총 사원 수를 반환하자.

-- Q7) `PRO06_SELECTALL`() 프로시저를 작성하여, EMP_TEST 테이블의 모든 데이터를 조회하자.

-- Q8) `PRO07_IF`(IN ENO INT) 프로시저를 작성하여,
--      사원이 존재하면 해당 사원의 월급을 2배로 인상하고, 
--      존재하지 않으면 메시지를 출력하자.

-- Q9) `PRO08_IF`(IN IN_SAL DECIMAL) 프로시저를 작성하여,
--      입력받은 월급보다 많이 받는 사원의 이름과 급여를 출력하되, 
--      존재하지 않으면 메시지를 출력하자.

-- Q10) 모든 사원의 급여를 입력받은 비율만큼 인상하는 프로시저를 작성하자. (예: 비율 1.1 → 10% 인상)

-- Q11) `DO` 문을 활용하여 반복 또는 조건문 기반 로직을 실습해보자.

-- Q12) `CURSOR`(커서)를 이용한 프로시저를 작성하여, 부서번호가 10번인 사원들을 순차적으로 출력하자.



 
 
 
 
 
 
 
 
 
 


