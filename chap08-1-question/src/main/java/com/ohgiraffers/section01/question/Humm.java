package com.ohgiraffers.section01.question;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class Humm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String content = req.getParameter("content");

        boolean isTitleValid = title.length() >= 5;
        boolean isContentValid = content.length() >= 10;

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        if (!isTitleValid) {
            out.println("<h2>제목은 5자 이상이어야 합니다.</h2>");
        }
        if (!isContentValid) {
            out.println("<h2>내용은 10자 이상이어야 합니다.</h2>");
        }
        out.close();
    }
}
