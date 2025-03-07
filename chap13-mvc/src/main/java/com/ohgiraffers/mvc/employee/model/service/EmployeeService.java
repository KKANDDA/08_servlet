package com.ohgiraffers.mvc.employee.model.service;

import com.ohgiraffers.mvc.employee.model.dao.EmployeeDAO;
import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.*;

public class EmployeeService {

    private final EmployeeDAO empDAO; // 한번 만들어 지면 바꿀 생각이 읎기에..

    public EmployeeService(){
        empDAO = new EmployeeDAO(); // EmployeeService 클래스를 자료형으로 쓰는 객체가 생길 때 empDAO 객체도 같이 생긴다.
    }

    public EmployeeDTO selectOneEmpById(int empId) {

        Connection con = getConnection();

        EmployeeDTO selectEmp = empDAO.selectEmpById(con, empId);

        close(con);

        return selectEmp;
    }


    public List<EmployeeDTO> allEmpInfo() {

        Connection con = getConnection();

        List<EmployeeDTO> allEmp = empDAO.allEmpInfo(con);

        close(con);

        return allEmp;
    }

    public int selectNewEmpId() {

        // AUTO_INCREMENT가 걸려 있는 경우는 필요 없지만, 제일 끝 번호를 추적해 직접 값을 넣어주는 메소드
        Connection con = getConnection();
        int newEmpId = empDAO.selectNewEmpId(con);
        close(con);
        return newEmpId;
    }

    public int insertEmp(EmployeeDTO emp) {
        Connection con = getConnection();
        int result = empDAO.insertEmp(con, emp);

        if (result > 0){
            commit(con);
        }else{
            rollback(con);
        }
        close(con);
        return result;
    }

    public int firedEmp(int empId, Date entDate) {
        Connection con = getConnection();
        int result = empDAO.firedEmp(con, empId, entDate);

        if (result > 0){
            commit(con);
        }else {
            rollback(con);
        }
        close(con);
        return result;
    }

    public int deleteEmp(int id) {
        Connection con = getConnection();
        int result = empDAO.deleteEmp(con, id);

        if (result > 0){
            commit(con);
        }else {
            rollback(con);
        }
        close(con);
        return result;
    }
}
