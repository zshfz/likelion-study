package com.mysqlapp.view;

import com.mysqlapp.model.Emp;
import com.mysqlapp.model.EmpDeptDTO;

import java.util.List;

public class EmpView {
    public void display(List<Emp> list) {
        System.out.println("\n=== 사원 목록 ===");
        for (Emp e : list) {
            System.out.printf("사번: %d | 이름: %s | 직무: %s | 급여: %.2f | 부서번호: %d%n",
                e.empno(), e.ename(), e.job(), e.sal(), e.deptno());
        }
    }

    public void printEmpWithDept(List<EmpDeptDTO> list) {
        System.out.println("\n=== 사원 + 부서 조인 목록 ===");
        for (EmpDeptDTO e : list) {
            System.out.printf("사원명: %s | 부서번호: %d | 부서명: %s | 위치: %s%n",
                e.ename(), e.deptno(), e.dname(), e.loc());
        }
    }
}
