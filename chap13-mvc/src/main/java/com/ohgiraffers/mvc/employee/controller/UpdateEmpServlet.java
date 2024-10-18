package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employee/update")
public class UpdateEmpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int empId = Integer.parseInt(req.getParameter("empId"));
        java.sql.Date entDate = java.sql.Date.valueOf(req.getParameter("entDate"));

        EmployeeService empService = new EmployeeService();
        int result = empService.firedEmp(empId, entDate);
        System.out.println("result = " + result);

        String path = "";
        if (result > 0) {
            path = "/WEB-INF/views/common/successPage.jsp";
            req.setAttribute("successCode", "update");
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "해당 직원 해고 실패");
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
