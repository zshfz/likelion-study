USE MY_EMP;
-- Q1. 사원 테이블에서 '부서번호'와 '사원 이름'을 모두 출력해보자. 단 별칭으로 출력하자. 
select deptno as 부서번호, ename as "사원 이름" from emp;

-- Q2. 부서번호가 10번인 사원의 모든 정보를 출력해보자.
select * from emp where deptno = 10;

-- FORMAT(X,D[,locale]): 1000단위 콤마 표시
-- Q3. 급여가 3000 이상인 사원의 사번(empno), 이름(ename), 급여(sal)를 출력해보자.
select empno, ename, format(sal,0), round(sal, 0) from emp where sal >= 3000;

-- Q4. 직업이 'MANAGER'인 사원의 이름과 직업를 출력해보자. (명령은 대소문자를 구분하지 않지만 VALUE값은 구분함)
select ename, job from emp where job = "MANAGER";

-- DATE_FORMAT(date, format)
-- Q5. 입사일이 1985년 이후인 사원의 이름과 입사일을 출력해보자.
SELECT DATE_FORMAT(hiredate, "입사일은 %Y년 %m월 %d일 %w요일 입니다")  as 입사일 from emp where hiredate >= "1985-01-01";

-- Q6. 급여가 2000 이상이면서 직무가 'SALESMAN'인 사원의 이름과 급여, 직업를 출력해보자.
select ename, sal, job from emp where sal >= 2000 and job = "SALESMAN";

-- Q7. 커미션이 NULL이거나 급여가 5000 이상인 사원의 이름과 급여, 커미션을 출력해보자. 단 커미션이 없으면 없다고 출력 해보자
select ename, format(sal, 0), ifnull(format(comm, 0), "없음") from emp where comm is null or sal >= 2000;

select ename, format(sal, 0), ifnull(format(comm, 0), "없음") from emp;

-- Q8. 사원의 이름과 매니저를 출력하자 단, 매니저 없으면 없음으로 
select ename, ifnull(mgr, "없음") as 매니저 from emp ;

-- Q9. 사원의 이름과 매니저를 출력하자 단, 매니저 없으면 없음으로 (case when then 사용)
select ename, 
case when mgr is null then "없음"
	 else cast(mgr as char) -- 숫자를 문자로 변환
     end as 매니저
from emp;

/* 날짜 포맷
mysql> SELECT DATE_FORMAT('2009-10-04 22:23:00', '%W %M %Y'); 요일이름, 월이름, 4자리연도
        -> 'Sunday October 2009'
        
mysql> SELECT DATE_FORMAT('2007-10-04 22:23:00', '%H:%i:%s'); 시간, 분, 초
        -> '22:23:00'
mysql> SELECT DATE_FORMAT('1900-10-04 22:23:00',
    ->                 '%D %y %a %d %m %b %j'); %a: 요일의 약어. %j: 일년중 몇번째 날
        -> '4th 00 Thu 04 10 Oct 277'
mysql> SELECT DATE_FORMAT('1997-10-04 22:23:00',
    ->                 '%H 24시간 2자리 표시
						%k 24시간 1자리 표시
						%I 12시간제
						%r 12시간 표시 시, 분, 초
						%T 24시간 표시 시, 분, 초
						%S 초
						%w 요일을 숫자로 0 = 일요일
                        ');
        -> '22 22 10 10:23:00 PM 22:23:00 00 6'
mysql> SELECT DATE_FORMAT('1999-01-01', '%X %V');
        -> '1998 52'
mysql> SELECT DATE_FORMAT('2006-06-00', '%d'); 일 
        -> '00'
        
현재 날짜 포맷
SELECT DATE_FORMAT(NOW(), "오늘은 %Y년 %m월 %d일 %w요일 입니다")
*/   

SELECT DATE_FORMAT(NOW(), "오늘은 %Y년 %m월 %d일 %w요일 입니다") ; 

------------------------------------------------------------------


-- 숫자함수, 문자함수, 날짜함수
-- 집계함수 : COUNT, MAX, MIN ,AVG, SUM ..
-- Q1. 사원 테이블의 봉급을 이용해서 집계함수를 출력해보자
select count(sal), max(sal), min(sal), sum(sal), avg(sal) from emp;

 select count(null), max(null), min(null), sum(null), avg(null) from emp;
 
select count(comm) from emp; -- COUNT는 NULL 안 샘

select count(*) from emp;

-- Q2. 사원 테이블에서  부서번호가 10번인 사원의 평균 월급을 구해보자
select avg(sal)
from emp
where deptno = 10;

-- Q3. 사원 테이블에서 부서번호가 10, 30번인 사원의 월급의 합을 구해보자
select sum(sal)
from emp
where deptno in(10, 30);

-- Q4. 직업이 salesman인 직원의 평균 월급과 월급의 합을 구해보자
select avg(sal), sum(sal)
from emp
where job = "SALESMAN";

-- Q5. 봉급이 3000이상 5000이하의 월급을 몇명이 받는지 개수를 출력해보자
select count(*)
from emp
where sal between 3000 and 5000;

/*   실행순서  
SELECT  컬럼리스트   -----------------------------------------------5
FROM    테이블 리스트          ------------------------------------ 1
WHERE   조건문 [숫자비교, 문자비교, 대소문자비교, NULL, 날짜비교,,]-------  2
GROUP BY   그룹화( 집계연산 SUM, MAX, MIN, AVG, MEAN, STD,,,,)------------  3
HAVING    GROUP BY 조건문    -----------------------------------  4
ORDER BY  정렬  ----------------------------------------------- 6 
LIMIT[옵션]  결과 제한  ---------------------------------------------7  
 
  FROM → WHERE → GROUP BY → HAVING → SELECT → ORDER BY → LIMIT 
*/

-- WHERE는 GROUP BY 이전에 실행 → 일반 필터링
-- HAVING은 GROUP BY 이후에 실행 → 그룹핑 결과 필터링

/*
SELECT 
FROM 
GROUP BY
ORDER BY

-GROUP BY 절에서는 테이블의 칼럼이나 변수만 사용할 수 있으며, { 그룹 함수는 사용할 수 없다} 
-SELECT 리스트에는 GROUP BY에 명시된 표현식과 그룹 함수만 사용할 수 있으며, *는 사용할 수 없다
-ORDER BY 절에서는 SELECT 리스트에 명시된 칼럼, 표현식, 별칭, 또는 칼럼 번호를 사용할 수 있다.
-FROM → WHERE → GROUP BY → HAVING → SELECT → ORDER BY → LIMIT
*/


-- Q1. 부서별 평균 월급을 구하자.
select avg(sal)
from emp
group by deptno;

select deptno, avg(sal)
from emp
group by deptno;

-- 별칭으로 그룹핑 해보자
select deptno as no, avg(sal)
from emp
group by no; -- 별칭 그룹핑 권장사항 x

-- 문자열의 별칭으로 그룹핑 해보자 => 안된다!!
select deptno as "별 명", avg(sal)
from emp
group by "별 명"; -- X

select deptno as 별명, avg(sal)
from emp
group by 별명; -- O

-- 속성명 위치로 그룹핑 해보자
select deptno, avg(sal)
from emp
group by 1; -- SELECT의 속성명 위치

-- Q2.  직업별 평균 월급을 구하자.
select job, format(avg(sal),0) as 평균월급
from emp
group by job;

-- Q3.  부서별 평균 월급을 구하되 10번 부서의 평균 월급만 출력하자.
select deptno, avg(sal)
from emp
where deptno = 10
group by deptno;

-- Q4. 직업별 월급의 합을 구하자
select job, sum(sal)
from emp
group by job;

-- Q5.직업이 SALESMAN인 사원의 월급의 합을 구하라.
select sum(sal)
from emp
where job="SALESMAN";

-- Q6. 사원 테이블에서 사원의 최대 월급을 출력하자.
select max(sal)
from emp;

-- Q7. 사원테이블에서 사원 최소 월급을 출력하자. 
select min(sal)
from emp;

-- Q8. 각 부서별 최대 월급을 출력하자.
select deptno, max(sal)
from emp
group by deptno;

-- Q9. 사원 테이블에서 커미션이 책정되어 있는 사원의 이름과 커미션을 출력하라
select ename, comm
from emp
where comm is not null;

-- Q10. 사원 테이블에서 커미션이 책정되지 않은 사원의 이름과 커미션을 출력하라.
select ename, comm
from emp
where comm is null;

/*
HAVING : 그룹함수로 집계된 데이터의 조건을 줄 때 사용 하는 구문
    1)  GROUP BY 절로 그룹화된 데이터에 조건을 줄때 사용
    2)  WHERE 절은 각 행에 대한 조건을 적용하는 반면,  HAVING 절은 그룹화된 데이터에 대한 조건을 적용한다. 
    3)  HAVING절에는 그룹핑된 컬럼이나 그룹함수에 대한 조건만 적용된다.
    4)  WHERE 와 HAVING은 함께 사용할 수 있으며, WHERE절로 행단위 조건은 먼저 수행하고, 그룹화된 
    결과에 추가 조건을  HAVING을 통해 적용할 수 있다. 
    5)  HAVING 다음에 SELECT-LIST에서 그룹핑에 사용한 컬럼과 , 그룹함수에 사용한 컬럼에 대해서만 조건을 
        줄 수 있다.
        
	WITH ROLLUP  =  그룹의 총계, 부분 소계를 나타낸다. ROLLUP 연산자는 GROUP BY 문과 함께 사용되며
             GROUP BY 문에서 명시된 컬럼 순서대로 추가적인 요약 정보를 단계적으로 만들어 준다.
        
*/

-- Q1. 직업별 월급의 합을 구하고 월급이 5000 이상인 사원만 출력해보자
select job, sum(sal)
from emp
where sal >= 1000
group by job;
  
-- Q2. 직업별 월급의 합을 구하고 월급의 합이 5000인 사원만 출력해보자
select job, sum(sal)
from emp
group by job
having sum(sal) >= 5000;

-- Q3. 부서별 월급의 총합, 전체 총합 및 세부내역을 출력
select deptno, ename, sum(sal)
from emp
group by deptno, ename with rollup;

-- Q4. 직업별 사원의 이름과 월급의 합, 전체 총합 및 세부내역을 출력
select job, ename, sum(sal)
from emp
group by job, ename with rollup
order by 1 DESC; -- ORDER BY 컬럼명, SELECT-LIST 순서(1부터 시작), ASC DEFAULT, DESC

/*
GROUPING SETS: 선택적인 그룹화 구현하는 키워드
	- 여러개의 조합을 그룹으로 사용 할 때 사용하는 키워드
    - GROUP BY +
    ex) 부서별 그룹화, 직업별 그룹화를 동시에 결합
*/


