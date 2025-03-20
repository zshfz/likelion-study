use my_emp;
CREATE DATABASE TEST;
DROP DATABASE TEST;

/*
SELECT 컬럼명,,,[*]
FROM 테이블명;
*/

#Q1. 사원 테이블의 전체 인원을 출력 해보자
SELECT *
FROM EMP;

#Q2. 사원 테이블에서 사원의 이름, 사원의 번호를 출력 해보자
SELECT ENAME, EMPNO
FROM EMP;

#Q3 .사원 테이블에서 사원의 이름, 봉급, 부서번호를 출력 해보자
SELECT ENAME, SAL, DEPTNO
FROM EMP;

#Q4. 부서 테이블의 모든 데이터 출력 해보자
SELECT *
FROM DEPT; 

#Q5. 부서 테이블의 부서이름, 부서번호를 출력 해보자
SELECT DNAME, DEPTNO
FROM DEPT;

#Q6. 부서 테이블과 사원 테이블의 모든 내용을 출력 해보자 (카디션 프로덕트)
SELECT *
FROM EMP, DEPT;

#Q7. 사원의 이름과 부서이름 부서의 위치를 출력 해보자
SELECT ENAME, DNAME, LOC
FROM EMP, DEPT;

/* 별칭
SELECT 컬럼명 [as] 별칭 ,,, [*]
FROM 테이블명 별칭,,,;
*/

#Q8. 사원의 이름, 부서번호, 부서이름 (DEPTNO 중복되기 때문에 에러 주의)
SELECT ENAME, DEPTNO, DNAME
FROM EMP, DEPT;
##CASE 1
SELECT EMP.ENAME, EMP.DEPTNO, DNAME
FROM EMP, DEPT;
##CASE 2
SELECT E.ENAME, E.DEPTNO, D.DNAME
FROM EMP E, DEPT D;
##CASE 3
SELECT E.ENAME, E.DEPTNO, D.DNAME
FROM EMP AS E, DEPT AS D;

#Q9. "사원 이름", "부서 번호", "부서 이름"을 출력 해보자
#CASE 1 (공백 있으면 터블 쿼테이션)
SELECT E.ENAME "사원 이름", E.DEPTNO "부서 번호", D.DNAME "부서 이름" 
FROM EMP E, DEPT D;
#CASE 2 (AS 선택 명시)
SELECT E.ENAME AS 사원이름, E.DEPTNO AS 부서번호, D.DNAME AS 부서이름
FROM EMP E, DEPT D;
#CASE 3
SELECT EMP.ENAME AS "사원 이름", EMP.DEPTNO 부서번호, DEPT.DNAME 부서이름
FROM EMP EMP, DEPT DEPT;

/* 중복 데이터 제거
SELECT DISTINCT 컬럼명 [AS] 별칭,,,[*]
FROM 테이블명 [AS] 별칭,,,;

DISTINCT: 지정한 컬럼 값이 완전히 같을 때 중복 제거
		  컬럼 1개 일때는 해당 컬럼 값만 비교하고 
          컬럼 2개 이상 일때는 컬럼들의 조합이 같아야 중복으로 간주
*/

#Q10. 사원 테이블에서 고유 직업명만 출력 해보자 
SELECT DISTINCT JOB
FROM EMP;

#Q11. 사원 테이블에서 직업, 부서번호를 고유값으로 출력 해보자
SELECT DISTINCT JOB, DEPTNO
FROM EMP;

/* 속성에 사칙연산을 할 수 있다
연산시 NULL은 NULL로 리턴되어서 계산되지 않는다
- IFNULL(널이 있는 컬럼, 초기값)
- COALESCE(NULL, 1) => 1
- WHERE IS NULL
*/

#Q12. 사원의 이름, 사원의 봉급, 사원의 연봉을 연봉이라고 출력 해보자
SELECT ENAME, SAL, SAL*12 AS 연봉
FROM EMP;

#Q13. 사원의 이름, 사원의 봉급을 출력하되 봉급 = 봉급 + 커미션을 계산해서 봉급이라고 출력 해보자
SELECT ENAME, SAL, COMM, SAL + IFNULL(COMM, SAL) AS 봉급
FROM EMP;

SELECT ENAME, SAL, COMM, SAL + IFNULL(COMM, 0) AS 봉급
FROM EMP;

SELECT ENAME, SAL, COMM, SAL + IFNULL(COMM, SAL*3) AS 봉급
FROM EMP;

/* 조건문
SELECT DISTINCT 컬럼명 [AS] 별칭,,,[*]
FROM 테이블명 [AS] 별칭,,,
WHERE 조건식; (IN, NOT IN, IS NULL, IS NOT NULL, AND, OR, BETWEEN AND)
*/

#Q14. 사원 테이블에서 사원의 봉급이 1000 이상인 사원의 이름, 봉급, 커미션을 출력 해보자
SELECT ENAME, SAL, COMM
FROM EMP
WHERE SAL >= 1000;
 
#Q15. 사원 테이블에서 커미션이 500이상인 사원의 이름, 봉급을 출력 해보자
SELECT ENAME, SAL
FROM EMP
WHERE COMM >= 500;

#Q16. 커미션이 NULL이 아닌 사원의 이름, 커미션을 출력 해보자
SELECT ENAME, COMM
FROM EMP
WHERE COMM IS NOT NULL;

#Q17. 부서 번호가 10 또는 20인 사원의 모든 정보를 출력 해보자
SELECT *
FROM EMP
WHERE DEPTNO IN(10, 20);

#Q18. 부서 번호가 10 또는 20인 사원을 제외한 모든 정보를 출력 해보자
SELECT *
FROM EMP
WHERE DEPTNO NOT IN(10, 20);

#Q19. 봉급이 2000 이상 5000 이하인 사원의 이름과 직업, 봉급을 출력 해보자
SELECT ENAME, JOB, SAL
FROM EMP
WHERE SAL >= 2000 AND SAL <= 5000;

#Q20. 봉급이 2000 이상 5000 이하인 사원의 이름과 직업, 봉급을 출력 해보자
SELECT ENAME, JOB, SAL
FROM EMP
WHERE SAL BETWEEN 2000 AND 5000;

#Q21. 날짜는 수치 변환이 가능하다 날짜 데이트를 확인해보자
#EMP 테이블의 구조를 확인하자
DESC EMP;
#EMP 테이블의 모든 내용을 TEST 테이블로 생성해보자 (TABLE 복사)
CREATE TABLE TEST
AS 
SELECT * FROM EMP;

SELECT * FROM TEST;
#TEST 구조 다시 확인 (테이블 복사했을 때 제약조건은 복사 안됨)
DESC TEST;

#EMP 테이블의 사원의 이름과 입사일을 TEST02 테이블로 생성해보자
CREATE TABLE TEST02
AS
SELECT ENAME, HIREDATE
FROM EMP;

DESC TEST02;

#EMP 테이블의 사원의 이름과 입사일을 TEST03 테이블로 생성해보자
/*
CREATE TABLE TEST03 MySQL에서는 이 위치에 컬럼 명 못씀
AS
SELECT ENAME, HIREDATE
FROM EMP;

DESC TEST03;
*/

#구조만 가지고 오고 싶다
CREATE TABLE TEST03 LIKE EMP;
DESC TEST03;

#TEST02에 데이터를 입력해보자 INSERT INTO 테이블명(컬럼명) VALUES(,,,);
DESC TEST02;

INSERT INTO TEST02
VALUES('111', '1980-01-01');

INSERT INTO TEST02
VALUES('222', '1980/01/01');

INSERT INTO TEST02
VALUES('333', '80-01-01');

INSERT INTO TEST02
VALUES('444', '80/01/01'); #4가지 형식 잘됨

SELECT * FROM TEST02;

#TEST02의 사원들의 입사년도가 1981년 이후의 사원들의 목록을 출력 해보자
SELECT *
FROM TEST02
WHERE HIREDATE > '1981-01-01'; #(년월일 다 써줘야 함)
 
#Q22.
#Q23.
#Q24.
#Q25.
#Q26.
#Q22.
#Q22.
#Q22.
