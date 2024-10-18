package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/member/*") // /* 으로 모든 요청이 필터를 거치게 된다.
public class PasswordEncryptFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        /*
        ServletRequest는 최상위 부모 인터페이스, HttpServletRequest는 그 자식 인터페이스,
        사용자로부터 실제 받은 정보는 HttpServletRequest
        부모는 자식에 넣을 수 없으니 (HttpServletRequest)를 사용해 다운캐스팅해 변수 hrequest에 담아준다.

        RequestWrapper 클래스는 HttpServletRequest 인터페이스를 상속받고 있다.
        RequestWrapper는 HttpServletRequest의 request를 원하기 때문에, 다운캐스팅한 hrequest를 넣어서 wrapper 객체를 만들었다.

        그렇게 servletRequest가 wrapper로 형변환되어 수정이 가능하게 되었고,
        RequestWrapper에서 getParameter를 오버라이드해 wrapper가 암호화되었다.

        filterChain.doFilter(wrapper, servletResponse);을 통해 wrapper를 다음 서블릿 RegistMemberServlet으로 넘어갔다.


        * */

        HttpServletRequest hrequest = (HttpServletRequest) servletRequest;

        RequestWrapper wrapper = new RequestWrapper(hrequest);

        filterChain.doFilter(wrapper, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
