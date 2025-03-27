/*
1. INNER JOIN (교집합):
두 테이블에서 일치하는 값만 출력되며, NULL과 False는 모두 제외된다.
ON 또는 USING을 사용하여 조인 조건을 명시한다.

2. LEFT OUTER JOIN (왼쪽 기준 차집합):
왼쪽 테이블의 모든 데이터는 출력하고, 오른쪽 테이블에서 일치하는 값만 출력된다.
일치하지 않는 오른쪽 데이터는 NULL로 채워진다.

3. RIGHT OUTER JOIN (오른쪽 기준 차집합):
오른쪽 테이블의 모든 데이터는 출력하고, 왼쪽 테이블에서 일치하는 값만 출력된다.
일치하지 않는 왼쪽 데이터는 NULL로 채워진다.

4. FULL OUTER JOIN (합집합):
왼쪽과 오른쪽 테이블의 모든 데이터를 출력하고,
일치하지 않는 부분은 NULL로 채워진다.
MySQL에서는 LEFT JOIN과 RIGHT JOIN을 UNION으로 합쳐 구현한다.

5. CROSS JOIN (데카르트 곱):
두 테이블의 모든 데이터를 서로 곱해서 조합한 결과를 출력한다.
결과 행 수가 첫 번째 테이블 행 수 × 두 번째 테이블 행 수가 된다.

6. SELF JOIN (자기자신 조인):
한 테이블을 자기 자신과 조인하여 상위-하위 관계나 계층 구조를 표현할 때 사용한다.

7. NATURAL JOIN:
두 테이블에서 컬럼명이 같은 컬럼들을 자동으로 조인하며,
명시적으로 ON이나 USING 없이 동작하지만 명확성이 떨어져 실무에서는 잘 사용하지 않는다.

8. EQUI JOIN (동등 조인):
=(동등 연산자)를 사용하여 조건을 지정하고,
테이블 간 일치하는 값만 추출하는 방식으로, 사실상 INNER JOIN과 동일하게 동작한다.

--------------------------------------------------------------------------

- inner join, outer join,cross join,[full outer join,Equi join,self join] 
조인 : 테이블의 컬럼 값에 공통값  (value)를 추출하는 것  
using (같은컬럼명) ,  on (다른 컬럼명)  


1) 내부 조인(inner join) : 같은값만 추출 / false, null  추출 되지 않는다. 
두 테이블 모두에 일치하는 항목이 있으면 행을 반환
조인된 테이블의 행이 일치하지 않으면 행이 반환되지 않는다.

- CASE 1 : 컬럼명 다를때
SELECT columns
FROM table1
INNER JOIN table2
ON table1.common_column = table2.common_column;

- CASE 2 : 컬럼명 다를때
SELECT columns
FROM table1
INNER JOIN table2
USING(common_colum);

2)외부 조인(OUTER JOIN): 주종 관계를 만들어서 주 테이블은 전체출력, 종테이블은 True값만 출력된다.
OUTER JOIN에는 LEFT, RIGHT, FULL의 세 가지 유형
한 테이블의 모든 행과 다른 테이블의 일치하는 행을 반환하는 데 사용. 
일치하는 항목이 없으면 NULL 값을 사용하여 일치 항목이 없는 테이블의 열을 채운다

2-1) LEFT OUTER JOIN 구문
SELECT columns
FROM table1
LEFT OUTER JOIN table2
ON table1.common_column = table2.common_column;
- 왼쪽 테이블의 모든 레코드를 반환하고, 오른쪽 테이블의 일치하는 레코드를 반환한다.  
- 일치하는 항목이 없으면 오른쪽 부터 NULL이 된다.  
EX) 주테이블의 모든 항목에 따라 종테이블의  원하는 레코드를 추출할 때 사용 

2-2) RIGHT OUTER JOIN은 비슷하지만 두 번째 테이블의 모든 행과 첫 번째 테이블의 일치하는 행을 반환
- 일치하는 항목이 없으면 왼쪽 부터 NULL이 된다.  
SELECT columns
FROM table1
RIGHT  OUTER JOIN table2
ON table1.common_column = table2.common_column;

2-3 FULL OUTER JOIN은 LEFT 및 RIGHT 외부 조인의 결과를 결합한다.  = UNION을 사용한다.  
--------------------------------------------------------------
- USING 
SELECT columns
FROM table1
JOIN table2
USING (common_column);

- 열 이름이 다른 ON 절
SELECT columns
FROM table1
JOIN table2
ON table1.column_name = table2.other_column_name;

3)CROSS JOIN은 두 테이블의 데카르트 곱을 반환. 
즉, 첫 번째 테이블의 모든 행을 두 번째 테이블의 모든 행과 조인한다 
일반적으로 생성할 수 있는 행 수가 많기 때문에 덜 자주 사용된다.
SELECT columns
FROM table1
CROSS JOIN table2;
*/

USE my_emp;
-- Q1. 사원의 이름과 사원이 속해있는 부서 이름을 출력하자. INNER JOIN 같은 값만 추출
-- SQL
SELECT ENAME, DNAME
FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO;

-- ANSI
SELECT ENAME, DNAME
FROM EMP INNER JOIN DEPT USING(DEPTNO);

SELECT ENAME, DNAME
FROM EMP JOIN DEPT USING(DEPTNO);

-- Q2) 간단한 테이블을 생성해서 JOIN을 생각해 보자. 

CREATE TABLE X(
X1 VARCHAR(5),
X2 VARCHAR(5));

DROP TABLE Y;
CREATE TABLE Y(
Y1 VARCHAR(5),
Y2 VARCHAR(5));


INSERT  INTO X  VALUES ('A','D' ) ;

INSERT  INTO Y  VALUES ( 'A','1'); 
INSERT  INTO Y  VALUES ( 'B','2'); 
INSERT  INTO Y  VALUES ( 'C','3'); 
INSERT  INTO Y  VALUES ( NULL,'1');

SELECT * FROM X;
SELECT * FROM Y;
DESC Y;

-- Q3. X, Y 테이블에서 X1, Y1 컬럼 조인해보자
-- SQL
SELECT *
FROM X, Y
WHERE X1 = Y1;

-- ANSI
SELECT *
FROM X JOIN Y ON X1 = Y1; -- 두 테이블의 속성명이 다른 값은 추출할 때 ON

-- Q4. 주종 관계를 만들어서 조인 해보자

/*
주테이블의 COUNT()에 맞추어서 종테이블의 NULL이 채워지는 결과 확인
종테이블의 COUNT()가 주테이블 보다 클때 TURE 값에 의한 행의 리턴에 의해 주테이블의 값 늘어나는 것 확인
*/

INSERT INTO X VALUES('C', 'D');
INSERT INTO X VALUES(NULL,  NULL);
INSERT INTO X VALUES('F', 'D');
INSERT INTO X VALUES('C', '3');
INSERT INTO X VALUES('C', '1');
INSERT INTO X VALUES('C', '2');
SELECT * FROM X;
SELECT * FROM Y;
-- Q4-1. Y를 주테이블로 만들고 X를 종테이블로 RIGHT OUTER JOIN
-- ANSI
SELECT * 
FROM X RIGHT OUTER JOIN Y
ON X1 = Y1;

-- SQL

-- Q4-2. Y를 주테이블로 만들고 X를 종테이블로 LEFT OUTER JOIN
-- ANSI
SELECT * 
FROM Y LEFT OUTER JOIN X
ON X1 = Y1;

-- SQL

-- Q4-3. FULL OUTER JOIN을 해보자 (MySQL은 해당 키워드 없어서 UNION 사용)
-- ANSI
SELECT * 
FROM X RIGHT OUTER JOIN Y
ON X1 = Y1
UNION
SELECT * 
FROM Y LEFT OUTER JOIN X
ON X1 = Y1;

-- SQL

/*
      FULL OUTER JOIN =  RIGHT OUTER JOIN  + LEFT OUTER JOIN     / UNION(중복항목x ), UNION ALL(중복항목 O) 
 1) UNION 앞의 쿼리에서  Y의 모든 레코드를 검색하고 X테이블에 일치하는 레코드를 검색한다.
 2) UNION 뒤의 쿼리에서  Y의 모든 레코드를 검색하고 X테이블에 일치하는 레코드를 검색한다. 
 3) UNION은 두개의 결과 레코드를 결합해서 리턴한다.
 4) UNION 쿼리는 두개 쿼리 결과 부분에서 열의 개수와 유형일치를 확인한다.
 5) 중복행 제거 후 결합한다.
 */
 
-- Q4-4 확인 해보자 
SELECT X1,X2 FROM X
UNION ALL 
SELECT Y1,Y2 FROM Y;

SELECT X1,X2 FROM X
UNION
SELECT Y1,Y2 FROM Y;
#------------------------
SELECT X1 FROM X
UNION ALL 
SELECT Y1 FROM Y;

SELECT X1 FROM X
UNION
SELECT Y1 FROM Y;

 -- Q5. 
 CREATE TABLE SALGRADE(
	GRADE INT,
    LOSAL INT,
    HISAL INT
    );
    
INSERT INTO SALGRADE (GRADE, LOSAL, HISAL) VALUES (1, 700, 1200);
INSERT INTO SALGRADE (GRADE, LOSAL, HISAL) VALUES (2, 1201, 1400);
INSERT INTO SALGRADE (GRADE, LOSAL, HISAL) VALUES (3, 1401, 2000);
INSERT INTO SALGRADE (GRADE, LOSAL, HISAL) VALUES (4, 2001, 3000);
INSERT INTO SALGRADE (GRADE, LOSAL, HISAL) VALUES (5, 3001, 9999);
commit;

SELECT * FROM SALGRADE;

-- Q6. 각 사원의 이름과 월급, 그리고 그 사원의 급여 등급을 출력해보자 EQUI JOIN, NONEQUI JOIN
-- SQL
SELECT ENAME, SAL, GRADE AS 등급
FROM EMP, SALGRADE
WHERE SAL >= LOSAL AND SAL <= HISAL;

SELECT ENAME, SAL, GRADE AS 등급
FROM EMP, SALGRADE
WHERE SAL BETWEEN LOSAL AND HISAL;

-- ANSI
SELECT ENAME, SAL, GRADE AS 등급
FROM EMP JOIN SALGRADE ON (SAL >= LOSAL AND SAL <= HISAL);

SELECT ENAME, SAL, GRADE AS 등급
FROM EMP JOIN SALGRADE ON (SAL BETWEEN LOSAL AND HISAL);

-- Q7. 사원의 이름, 월급, 급여등급, 부서이름
-- 테이블에 제약조건 사항이 있는 경우 선 조인, 나머지 후 조인문으로 작성
-- SQL
SELECT ENAME, SAL, GRADE AS 등급, DNAME
FROM EMP E, DEPT D, SALGRADE
WHERE E.DEPTNO = D.DEPTNO AND (SAL BETWEEN LOSAL AND HISAL);

-- ANSI
SELECT ENAME, SAL, GRADE AS 등급, DNAME
FROM EMP JOIN DEPT USING(DEPTNO) JOIN SALGRADE ON(SAL BETWEEN LOSAL AND HISAL);

-- Q8. SELF JOIN 테이블 하나에 같은 값을 가진 컬럼을 조인 하는 것
-- 사원 번호, 사원 이름, 관리자 사원번호, 관리자 이름을 출력해보자
-- ANSI
SELECT 사원.EMPNO, 사원.ENAME, 관리자.EMPNO, 관리자.ENAME 
FROM EMP 사원 JOIN EMP 관리자 ON (사원.MGR = 관리자.EMPNO); -- 상사가 없는 직원은 출력 안됨

SELECT 사원.EMPNO, 사원.ENAME, 관리자.EMPNO, 관리자.ENAME 
FROM EMP 사원 LEFT JOIN EMP 관리자 ON (사원.MGR = 관리자.EMPNO); -- 상사 없어도 사원 다 나오게 하려면 사원 테이블 주테이블로, 관리자 테이블 종테이블로 해서 
-- SQL

-- Q9. 동일한 컬럼의 이름을 가진 테이블 조인) NATURAL JOIN 
SELECT * FROM EMP NATURAL JOIN DEPT;

-- Q10. CROSS JOIN 
SELECT * FROM EMP CROSS JOIN DEPT; -- 카티션 프로덕트
