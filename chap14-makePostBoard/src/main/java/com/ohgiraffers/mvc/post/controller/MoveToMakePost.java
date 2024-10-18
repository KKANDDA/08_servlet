package com.ohgiraffers.mvc.post.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/movetomakepost")
public class MoveToMakePost extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = "/WEB-INF/views/postBoard/makePost.jsp";
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
