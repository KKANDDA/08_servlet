package com.ohgiraffers.section01.question;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/writepost")
public class Question extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    /*
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        System.out.println("userId: " + userId);
        System.out.println("password: " + password);

        // 다른 서블릿으로 데이터를 request의 setAttribute로 전달한다
        req.setAttribute("userId", userId);

        // print라는 경로로 요청을 넘기기 위한 객체 생성
        // 이 경로는 서블릿이나 jsp 모두 가능
        RequestDispatcher rd = req.getRequestDispatcher("print");

        rd.forward(req, resp);
    */

        resp.sendRedirect("redirect");




    }
}
