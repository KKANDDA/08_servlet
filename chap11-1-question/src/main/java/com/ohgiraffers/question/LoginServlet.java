package com.ohgiraffers.question;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userId");
        String password = req.getParameter("userPassword");
        System.out.println(userId);
        System.out.println(password);

        HttpSession session = req.getSession();
        Enumeration<String> sessionKeys = session.getAttributeNames();
        while (sessionKeys.hasMoreElements()) {
            System.out.println(sessionKeys.nextElement());
        }

        String forCheckId = (String) session.getAttribute("userId");
        String forCheckPassword = (String) session.getAttribute("userPassword");
        System.out.println(forCheckId);
        System.out.println(forCheckPassword);

        if (forCheckId == null || forCheckPassword == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        if(forCheckId.equals(userId) && forCheckPassword.equals(password)) {
            resp.sendRedirect("main.jsp");
        }else {
            resp.sendRedirect("login.jsp");
        }




    }
}
