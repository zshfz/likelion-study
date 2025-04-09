CREATE DEFINER=`mydb`@`%` PROCEDURE `GetEmp_Res`()
BEGIN
WITH RECURSIVE  EMP_RES AS (
    -- [1]  최상위 정보를 출력 해보자.  
       SELECT EMPNO, ENAME, MGR, 1 AS LEVEL
       FROM EMP 
	   WHERE MGR IS NULL         
      UNION ALL   
    -- [2] 각사원의 (부하직원) 을 재귀적으로 출력 하자.  
	 SELECT E.EMPNO, E.ENAME, E.MGR, ET.LEVEL + 1
     FROM EMP E     
     JOIN  EMP_RES  ET ON E.MGR =  ET.EMPNO         
  ) 
  SELECT  EMPNO, ENAME, MGR, LEVEL
  FROM EMP_RES
  ORDER BY LEVEL, MGR, EMPNO;
END