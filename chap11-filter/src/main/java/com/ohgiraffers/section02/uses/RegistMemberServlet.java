package com.ohgiraffers.section02.uses;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;

@WebServlet("/member/regist")
public class RegistMemberServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 필터를 거쳐 암호화된 리퀘스트가 들어왔다.

        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String name = req.getParameter("name");

        System.out.println("userId = " + userId);
        System.out.println("password = " + password);
        System.out.println("name = " + name);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println("비밀번호가 pass01인지 확인: "+passwordEncoder.matches("pass01", password));
        // 암호화된 내용을 2번째 인자로 전달해야 한다.

    }
}
