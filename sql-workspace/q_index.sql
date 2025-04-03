/*
인덱스(index)
 테이블 안의 데이터를 쉽고 빠르게 찾을 수 있도록 만든 데이터베이스 객체이다. 
 SQL을 실행할 때, 디스크 접근 횟수를 줄여 검색 속도를 높이기 위해 인덱스를 사용한다. 
 B-트리를 이용하면 모든 데이터에 대한 일정 수준의 검색 시간을 보장하는 장점이 있다. 
 테이블 행이 입력되거나 수정될 때마다  << 인덱스가 재구성 >>되어 데이터를 검색할 때는 효율적이지만 
 데이터를 추가하고 수정할 때는 인덱스 관리 때문에 시간이 더 걸린다. 

 【인덱스 생성이 바람직한 경우】
• 기본키와 외래키의 경우, 인덱스 생성이 바람직하다. 대부분의 DBMS는 기본키에 대해서 자동으로 인덱스를 생성한다. 
• WHERE 절 조건식에 자주 사용되는 테이블 열의 경우, 인덱스 생성이 바람직하다. 
• 조인 조건식에 자주 사용되는 테이블 열도 인덱스 생성이 바람직하다. 
• 하나의 테이블에 3~5개 정도의 인덱스가 효과적이다. 
• 가변길이 문자형이나 실수형, 날짜형 열보다는 정수형, 고정길이 문자형 열에 인덱스를 생성하는 것이 바람직하다. 
• ORDER BY절이나 GROUP BY절에 자주 사용되는 열의 경우, 인덱스 생성을 고려할 수 있다.
 
 【인덱스 생성이 바람직하지 않은 경우】
• 갱신이 빈번한 테이블 열의 경우, 인덱스가 바람직하지 않다. 
• 집계 함수, 내장 함수를 적용하여 열 값을 변형하는 경우, 인덱스가 효과적이지 않다. 
• 성별 같은 열처럼 도메인이 작아서 열의 선택도(selectivity)가 높을 경우, 인덱스가 바람직하지 않다. 
• 범위 검색을 하는 경우, 인덱스가 바람직하지 않다.
 • 테이블의 행 개수가 별로 없는 경우, 인덱스가 바람직하지 않다
*/

-- Q1. 함수 기반 인덱스를 활용해 보자'
use my_emp;
CREATE TABLE tbl (
  col1 LONGTEXT,
  INDEX idx1 ((SUBSTRING(col1, 1, 10)))
);
desc tbl;
insert into tbl values ('11111111111111111');
insert into tbl values ('1234567890');
insert into tbl values ('123456789');
select * from tbl;

-- 함수형 인덱스 적용 확인
explain
SELECT * FROM tbl WHERE SUBSTRING(col1, 1, 9) = '123456789';

-- 함수형 인덱스 적용 확인

-- Q2. EMP 테이블을 EMP_TEST로 만들어서 내보내자
drop table emp_test;

create table emp_test
as
select *
from emp;
explain
SELECT * FROM tbl WHERE SUBSTRING(col1, 1, 10) = '1234567890';

select * from emp_test;

drop table employees;
CREATE TABLE employees (
  data JSON,
  ID INT,
  -- INDEX ((data->>'$.name')) 이렇게 하면 에러 (name에 어떤 타입의 값이 들어올지 모르기 때문에 에러뜸)
    INDEX ((CAST(data->>'$.name' AS CHAR(30))))
);

SELECT * FROM employees WHERE data->>'$.name' = 'James';


