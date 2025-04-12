package com.mysqlapp.model;

import java.util.Date;

/*
 *  1.java.util.Date
 * 	2.java.sql.Date
 * */

public record Emp(
    int empno,
    String ename,
    String job,
    int mgr,
    Date hiredate,
    double sal,
    double comm,
    int deptno
){}