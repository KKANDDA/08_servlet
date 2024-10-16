package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class EncodingFilter implements Filter {

    private String encodingTupe;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encodingTupe = filterConfig.getInitParameter("encoding-type"); // 파라메터 네임을 가져온다.
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse hresponse = (HttpServletResponse) servletResponse;
        hresponse.setContentType(encodingTupe); //

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
