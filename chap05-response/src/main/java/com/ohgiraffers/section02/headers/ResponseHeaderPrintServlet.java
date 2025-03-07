package com.ohgiraffers.section02.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

@WebServlet("/headers")
public class ResponseHeaderPrintServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();

        long currntTime = System.currentTimeMillis();

        out.println("<h1>" + currntTime + "</h1>");
        out.close(); // 닫힐 때 바로 요청이 날아감

        Collection<String> responseHeaders = resp.getHeaderNames();

        Iterator<String> iter = responseHeaders.iterator();

        while (iter.hasNext()) {
            String headerName = iter.next();
            System.out.println(headerName + ": " + resp.getHeader(headerName));
        }
    }
}
