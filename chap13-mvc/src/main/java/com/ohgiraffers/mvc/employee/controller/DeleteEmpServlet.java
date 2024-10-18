package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dao.EmployeeDAO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employee/delete")
public class DeleteEmpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("empId"));

        EmployeeService empService = new EmployeeService();
        int result = empService.deleteEmp(id);

        String path = "";
        if(result > 0){
            path = "/WEB-INF/views/common/successPage.jsp";
            req.setAttribute("successCode", "deleteEmp");
        }else{
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", ",해당 직원 정보 삭제 실패");
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
