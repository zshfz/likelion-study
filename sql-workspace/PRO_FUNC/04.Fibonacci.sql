CREATE DEFINER=`mydb`@`%` PROCEDURE `04_Fibonacci_CTE`(IN p_limit int)
BEGIN
   WITH RECURSIVE  Fibonacci_CTE AS (
   -- [1] 초기값 (N =0, FIB=0, PREV_FIB= 1) 
    SELECT  0 AS N, 0 AS FIB, 1 AS PREV_FIB
    UNION ALL  
    -- [2] 재귀적으로 피보나치 수열을 계산하자.  
   SELECT N + 1,  PREV_FIB AS FIB, FIB + PREV_FIB AS  PREV_FIB
   FROM Fibonacci_CTE
   WHERE N + 1 <  p_limit
   ) 
    SELECT  N AS "항번호 "  , FIB AS  "피보나치 수열"
    FROM  Fibonacci_CTE;  
END