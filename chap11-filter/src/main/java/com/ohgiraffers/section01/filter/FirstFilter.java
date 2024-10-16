package com.ohgiraffers.section01.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;


@WebFilter("/first/*") // first를 거쳐가는 모든 것은 여기 필터를 거쳐가라!!!!!!
public class FirstFilter implements Filter {

    public FirstFilter() {
        System.out.println("FirstFilter 인스턴스 생성!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 필터 인스턴스가 최초 생성될 때 호출되는 메소드
        System.out.println("FirstFilter init 호출");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // servlet으로 request가 전달되기 전에 요청을 가로채는 역할을 하는 메소드
        System.out.println("Filter doFilter 호출");

        // 필터에서 처리할 코드를 작성하는 부분

        // 처리 한 후 다음 필터 혹은 서블릿의 doGet/doPost 호출
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        // 필터 인스턴스가 소멸될 때 호출되는 메소드(= 톰캣 종료 시)
        System.out.println("Filter destroy 호출");
    }
}
