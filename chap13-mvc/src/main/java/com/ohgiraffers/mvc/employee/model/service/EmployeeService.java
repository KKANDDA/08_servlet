package com.ohgiraffers.mvc.employee.model.service;

import com.ohgiraffers.mvc.employee.model.dao.EmployeeDAO;
import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;

import java.sql.Connection;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.close;
import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.getConnection;

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


    public EmployeeDTO allEmpInfo() {

        Connection con = getConnection();

        EmployeeDTO allEmp =empDAO.allEmpInfo(con);

        close(con);

        return allEmp;
    }
}
