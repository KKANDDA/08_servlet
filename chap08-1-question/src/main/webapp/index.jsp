<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>내 맘대로~</title>
</head>
<body>

<%--<form action="forward" method="post">
    <table>
        <tr>
            <td>아이디: </td>
            <td><input type="text" name="userId"/></td>
            <td rowspan="2"><button type="submit" style="height: 50px;">로그인</button></td>
        </tr>
        <tr>
            <td>비밀번호 : </td>
            <td><input type="password" name="password"/></td>
        </tr>
    </table>
</form>--%>

    <h2></h2>
    <h1>게시글 작성</h1>
    <form action="writepost" method="post">
        <table>
            <label>제목: <input type="text" name="title"/></label>
            <br/>
            <label>내용: <textarea name="content"></textarea></label>
            <br/>
            <button type="submit">작성하기</button>
        </table>
    </form>



</body>
</html>