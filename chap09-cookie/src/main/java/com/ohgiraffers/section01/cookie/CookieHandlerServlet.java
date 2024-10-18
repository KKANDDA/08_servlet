package com.ohgiraffers.section01.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("firstName: " + firstName);
        System.out.println("lastName: " + lastName);

        // resp.sendRedirect("redirect");
        // 이 상태론 다른 서블릿과 데이터를 공유할 수 없다. 그래서 cookie를 사용해 보자.

        /*
        * 쿠키를 사용하는 방법은 간단하며, 다음과 같다.
        * 1. 쿠키를 생성한다.
        * 2. 생성한 쿠키의 만효 시간을 설정한다.
        * 3. 응답 헤더에 쿠키를 담는다.
        * 4. 응답을 보낸다.
        *
        * 하지만 쿠키는 일부 제약사항이 있다.
        * 1. 한 번 설정한 쿠키의 이름은 변경할 수 없다.
        * 2. 쿠키의 이름에는 공백문자와 일부 특수문자([] () , = " \ @ ? : ;)를 사용할 수 없다.
        * */

        // 1.
        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("lastName", lastName);

        // 2.
        firstNameCookie.setMaxAge(60 * 60 * 24); // 초단위, 곧 하루
        lastNameCookie.setMaxAge(60 * 60 * 24); // 시간 설정을 안 해두면, 브라우져가 꺼질 때 사라진다.

        // 3.
        resp.addCookie(firstNameCookie);
        resp.addCookie(lastNameCookie);

        // 4.
        resp.sendRedirect("redirect");
    }
}
