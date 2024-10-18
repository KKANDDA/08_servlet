package com.ohgiraffers.section01.question;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/writepost")
public class WritePostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // html 폼을 작성하여 사용자에게 반환
        StringBuilder responseText = new StringBuilder();

        // 응답 내용의 타입
        resp.setContentType("text/html;charset=UTF-8");

        responseText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("<title>게시글 작성</title>\n") // 페이지 제목
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>게시글 작성</h1>\n");

        // 오류 메시지가 있을 경우 출력
        String errorMessge = (String) req.getAttribute("error"); // error는 키값이다.
        if (errorMessge != null) {
            responseText.append("<h2 style='color:red;'>").append(errorMessge).append("</h2>\n");
        }

        // 폼 생성
        responseText.append("<form action='writepost' method='post'>\n") // 폼의 action과 메서드 설정
                .append("제목: <input type='text' name='title' required><br>\n") // 제목 입력 필드
                .append("내용: <textarea name='content' required></textarea><br>\n") // 내용 입력 필드
                .append("<input type='submit' value='작성하기'>\n") // 제출 버튼
                .append("</form>\n")
                .append("</body>\n")
                .append("</html>");

        // 최종적으로 작성한 HTML을 응답으로 전송
        PrintWriter out = resp.getWriter();
        out.println(responseText.toString());
        out.flush();  // 여기서 전체 다 뿌려줌
        out.close();


    }

















    // 여기서부터.. 공부 시작해!!!!!!!!!!!!!!!!
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String content = req.getParameter("content");

        boolean isTitleValid = title.length() >= 5;
        boolean isContentValid = content.length() >= 10;

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        if (!isTitleValid) {
            out.println("<h2>제목은 5자 이상이어야 합니다.</h2>");
        }else if(!isContentValid) {
            out.println("<h2>내용은 10자 이상이어야 합니다.</h2>");
        }
        out.close();

        resp.sendRedirect("resultpost");
    }
}
