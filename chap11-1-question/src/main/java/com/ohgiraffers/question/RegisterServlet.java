package com.ohgiraffers.question;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userId");
        String password = req.getParameter("userPassword");
        String email = req.getParameter("userEmail");

        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(60*60); // 1시간

        session.setAttribute("userId", userId);
        session.setAttribute("userPassword", password);
        session.setAttribute("userEmail", email);

        System.out.println(session.getAttribute("userId"));
        System.out.println(session.getAttribute("userPassword"));
        System.out.println(session.getAttribute("userEmail"));

        resp.sendRedirect("login.jsp");
    }
}
