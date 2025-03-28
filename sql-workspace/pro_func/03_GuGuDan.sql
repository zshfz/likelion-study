CREATE DEFINER=`mydb`@`%` PROCEDURE `03_GuGuDan`(IN p_dan INT)
BEGIN
WITH RECURSIVE GuGuDan AS (
	SELECT p_dan AS DAN, 1 AS NUM, p_dan*1 AS RESULT

	UNION ALL

	SELECT DAN, NUM+1, DAN*(NUM+1)
	FROM GuGuDan
	WHERE NUM < 9
	)
	SELECT * FROM GuGuDan;
END