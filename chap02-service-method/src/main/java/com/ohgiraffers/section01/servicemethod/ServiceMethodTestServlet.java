package com.ohgiraffers.section01.servicemethod;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/request-service")
public class ServiceMethodTestServlet extends HttpServlet {



    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) res;
        // 상속 관계이기에.. 자료형이 부모이면 자식의 메소드는 쓸 수 없다.
        // 부모에게 자식을 넣었다면 다운 캐스팅해야 된다.

        // httpRequest의 getMethod()는 어떠한 http method 요청이 들어온 건지 문자열로 반환한다.
        String httpMethod = httpRequest.getMethod();
        System.out.println("http method: " + httpMethod);

        if(("GET").equals(httpMethod)){
            doGet(httpRequest, httpResponse);
        }else if(("POST").equals(httpMethod)){
            doPost(httpRequest, httpResponse);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청을 처리할 메소드 호출");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST 요청을 처리할 메소드 호출");
    }

}
