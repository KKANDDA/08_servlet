package com.ohgiraffers.section01.join;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet("/join")
public class Join extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String setName = "";
        String id = req.getParameter("id");
        String setId = "";
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        String setPassword = "";
        String phone = req.getParameter("phone");
        String setPhone = "";

        if(name.length()>=2){
            setName = req.getParameter("name");
            System.out.println("이름: " + setName);
        } else {
            out.println("<h2>이름은 2글자 이상이어야 합니다.</h2>");
            out.flush();
        }

        if(Pattern.matches("^[a-zA-Z0-9]*$", id)){
            setId = req.getParameter("id");
            System.out.println("아이디: " + id);
        }else{
            out.println("<h2>아이디를 확인해 주세요.</h2>");
            out.flush();
        }

        if(password.equals(password2)&&password.length()>=8){
            setPassword = req.getParameter("password");
            System.out.println("비밀번호: " + setPassword);
        }else {
            out.println("<h2>비밀번호를 확인해 주세요.</h2>");
            out.flush();
        }

        if(phone.length()==11){
            setPhone = req.getParameter("phone");
            System.out.println("전화번호: " + setPhone);
        }else {
            out.println("<h2>유효하지 않은 전화번호입니다.</h2>");
            out.flush();
        }

        if(setName.length()>1 && setId.length()>1 && setPassword.length()>1 && setPhone.length()>1){
            out.println("<h2>환영합니다. "+name+ " 님!</h2>");
        }

        out.close();

    }
}

/*
package com.ohgiraffers.question;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");

        boolean isNameValid = name != null && name.trim().length() >= 2
                && Pattern.matches("^[가-힣a-zA-Z]+$", name);

        boolean isPhoneValid = Pattern.matches("^[0-9]{11}$", phone);

        boolean isPasswordValid = password.length() >=8;
        boolean isPassword = password.equals(password2);

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        if( isNameValid && isPhoneValid && isPasswordValid && isPassword){
            out.print("<h1> 환영합니다 " + name + " 님! </h1>");
        }else {
            out.print("<h1>입력값을 확인하세요</h1>");
        }
        out.close();


    }
}
*/
