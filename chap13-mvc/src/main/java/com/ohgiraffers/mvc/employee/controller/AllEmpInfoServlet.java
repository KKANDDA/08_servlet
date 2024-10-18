package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/employee/list")
public class AllEmpInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 전체 회원 조회하기를 클릭하면 필터를 거쳐서 여기에 온다. 전체 직원 조회는 사용자가 입력한 값이 없으니 그냥 넘어왔겠지..?
        // DAO를 이용해 쿼리문을 날려 DB에서 전체회원의 정보를 받아내 DTO 객체에 담는다.

        EmployeeService empService = new EmployeeService();
        List<EmployeeDTO> allEmpList = empService.allEmpInfo();
                // EmployeeDTO allEmp = empService.allEmpInfo();
        System.out.println("모든 사원들의 정보");
        for (EmployeeDTO emp : allEmpList) {
            System.out.println(emp);
        }
                // System.out.println("모든 사원들의 정보: " + allEmpList);
        String path = "";
        if (allEmpList != null) {
            path = "/WEB-INF/views/employee/employeeList.jsp";
            req.setAttribute("empList", allEmpList);
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "전체 직원 정보 조회 실패");
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
