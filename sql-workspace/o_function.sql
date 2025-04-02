USE MY_EMP;
create table emp_test
as
select *
from emp;
-- Q1) 사원의 이름을 입력받아 소문자로 만드는 함수를 만들자.  
-- 선언
DELIMITER $$
CREATE DEFINER=`mydb`@`localhost` FUNCTION `FUN01`(MYNAME VARCHAR(50)) RETURNS varchar(50) CHARSET utf8mb4
    DETERMINISTIC
BEGIN 
	RETURN  lOWER(MYNAME); 
END$$
DELIMITER ;


-- 호출 
SELECT FUN01(ENAME), ENAME 
FROM emp_test;

select my_fun(ename), ename
from emp_test;

-- Q2) 사원의 이름을 출력하고 월급 연봉을 출력하는 함수를 만들자  
-- 선언 
DELIMITER $$
CREATE DEFINER=`mydb`@`localhost` FUNCTION `FUN02`(E_SAL DECIMAL(15,2)) 
 RETURNS decimal(15,2)
    DETERMINISTIC
BEGIN 
RETURN E_SAL*12;
END$$
DELIMITER ;

-- 호출 
SELECT ENAME, SAL , FUN02(SAL) 
FROM EMP_TEST ;

-- Q3) 00 은 00월  00일 입사했다를 출력하자.  
-- 선언
DELIMITER $$
CREATE DEFINER=`mydb`@`localhost` FUNCTION `FUN03`(emp_name VARCHAR(50), hire_date DATE) RETURNS varchar(100) CHARSET utf8mb4
    DETERMINISTIC
BEGIN
    RETURN CONCAT(emp_name, '은 ', DATE_FORMAT(hire_date, '%m월 %d일'), ' 입사했다');
END$$
DELIMITER ;

-- 호출
SELECT FUN03(ENAME, HIREDATE) 
FROM EMP_TEST;   


-- Q4) 부서번호와 부서이름을 출력하자.  

-- 선언  
 DELIMITER $$
CREATE DEFINER=`mydb`@`localhost` FUNCTION `FUN04`(D_DEPTNO INT)
  RETURNS varchar(100) CHARSET utf8mb4
    READS SQL DATA
BEGIN
    DECLARE D_NAME VARCHAR(100);
    SELECT DNAME INTO D_NAME FROM  DEPT WHERE DEPTNO =D_DEPTNO;
    RETURN D_NAME;
END$$
DELIMITER ;

-- 호출
SELECT  EMPNO , ENAME ,  FUN04(DEPTNO) 
FROM EMP_TEST; 
