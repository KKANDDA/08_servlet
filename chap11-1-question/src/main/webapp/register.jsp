<%--
  Created by IntelliJ IDEA.
  User: 803-3
  Date: 2024-10-16
  Time: 오후 3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입 페이지</title>
</head>
<body>
    <h1>회원가입</h1>
    <form action="register" method="post">
        <input type="text" name="userId" placeholder="User ID" required/>
        <input type="password" name="userPassword" placeholder="Password" required/>
        <input type="text" name="userEmail" placeholder="Email" required/>
        <button type="submit">가입하기</button>
        <br/>
    </form>
    <a href="login.jsp">로그인 페이지로 이동</a>
</body>
</html>
