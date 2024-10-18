package com.ohgiraffers.mvc.employee.model.dao;

import com.ohgiraffers.mvc.common.config.ConfigLocation;
import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.close;

public class EmployeeDAO {

    private final Properties prop;

    public EmployeeDAO() {
        prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "employee-mapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public EmployeeDTO selectEmpById(Connection con, int empId) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        EmployeeDTO selectEmp = null;

        String query = prop.getProperty("selectEmpById");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, empId);

            rset = pstmt.executeQuery();

            if (rset.next()) {
                selectEmp = new EmployeeDTO();

                selectEmp.setEmpId(rset.getInt("EMP_ID"));
                selectEmp.setEmpName(rset.getString("EMP_NAME"));
                selectEmp.setDeptCode(rset.getString("DEPT_CODE"));
                selectEmp.setJobCode((rset.getString("JOB_CODE")));
                selectEmp.setSalary(rset.getInt("SALARY"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(pstmt);
        }
        return selectEmp;

    }

    public List<EmployeeDTO> allEmpInfo(Connection con) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<EmployeeDTO> allEmpList = null;
        String query = prop.getProperty("allEmpInfo");

        try {
            pstmt =con.prepareStatement(query);
            rset = pstmt.executeQuery();
            allEmpList = new ArrayList<>();

            while (rset.next()) {
                EmployeeDTO allEmp = new EmployeeDTO();
                allEmp.setEmpId(rset.getInt("EMP_ID"));
                allEmp.setEmpName(rset.getString("EMP_NAME"));
                allEmp.setEmpNo(rset.getString("EMP_NO"));
                allEmp.setEmail(rset.getString("EMAIL"));
                allEmp.setPhone(rset.getString("PHONE"));
                allEmp.setDeptCode(rset.getString("DEPT_CODE"));
                allEmp.setJobCode(rset.getString("JOB_CODE"));
                allEmp.setSalLevel(rset.getString("SAL_LEVEL"));
                allEmp.setSalary(rset.getInt("SALARY"));
                allEmp.setBonus(rset.getDouble("BONUS"));
                allEmp.setManagerId(rset.getString("MANAGER_ID"));
                allEmp.setHireDate(rset.getDate("HIRE_DATE"));
                allEmp.setEntDate(rset.getDate("ENT_DATE"));
                allEmp.setEntYn(rset.getString("ENT_YN"));

                allEmpList.add(allEmp);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(pstmt);
        }
        return allEmpList;
    }

    public int insertEmp(Connection con, EmployeeDTO emp) {

        PreparedStatement pstmt = null;
        int result = 0;

        String query = prop.getProperty("insertEmp");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, emp.getEmpId());
            pstmt.setString(2, emp.getEmpName());
            pstmt.setString(3, emp.getEmpNo());
            pstmt.setString(4, emp.getEmail());
            pstmt.setString(5, emp.getPhone());
            pstmt.setString(6, emp.getDeptCode());
            pstmt.setString(7, emp.getJobCode());
            pstmt.setString(8, emp.getSalLevel());
            pstmt.setInt(9, emp.getSalary());
            pstmt.setDouble(10, emp.getBonus());
            pstmt.setString(11, emp.getManagerId());
            pstmt.setDate(12, emp.getHireDate());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
        }
    return result;
    }

    public int selectNewEmpId(Connection con) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        int newEmpId = 0;

        String query = prop.getProperty("selectNewEmpId");

        try {
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();

            if (rset.next()) { // rset에 다음이 있느냐는 말은 rset이 성공했는 냐는 뜻이다. 성공했으면 true!
                newEmpId = rset.getInt("EMP_ID");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(pstmt);

        }
        return newEmpId;
    }

    public int firedEmp(Connection con, int empId, Date entDate) {
        PreparedStatement pstmt = null;
        int result = 0;

        String query = prop.getProperty("firedEmp");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setDate(1, entDate);
            pstmt.setInt(2, empId);

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
        }
        return result;
    }

    public int deleteEmp(Connection con, int id) {
        PreparedStatement pstmt = null;
        int result = 0;

        String query = prop.getProperty("deleteEmp");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
        }
        return result;
    }
}
