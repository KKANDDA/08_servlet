<%--
  Created by IntelliJ IDEA.
  User: 803-3
  Date: 2024-10-18
  Time: 오후 4:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>새 게시글 작성</h1>
    <form action="newpost">
        <table>
            <tr>
                <td><th>제목: </th></td>
                <td><input type="text" name="title" placeholder="이거슨 제목"/></td>
            </tr>
            <tr>
                <td><th>내용: </th></td>
                <td><textarea typeof="text" name="content" placeholder="이거슨 내용"></textarea> </td>
            </tr>
        </table>
        <button type="submit">작성하기</button>
    </form>
</body>
</html>
