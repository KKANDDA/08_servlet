
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>게시판</h1>
    <a href="movetomakepost" methods="get">새 게시글 작성</a>
    <br/>
    <h2>게시글 목록</h2>
    <table>
        <tr>
            <th>게시물의 번호</th>
            <th>제목</th>
            <th>수정/삭제</th>
        </tr>
        <c:forEach items="${requestScope.postList}" var="post">
            <tr>
                <td>post.postId</td>
                <td>post.postTitle</td>
                <td>
                    <a href="post/update?id=${post.postId}">수정</a>
                    <a href="post/delete?id=${post.postId}">삭제</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
