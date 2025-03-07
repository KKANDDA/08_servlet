
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <script>
        (function(){
            const successCode = '${requestScope.successCode}';
            let successMessage = "";

            switch (successCode){
                case 'insertEmp':
                    successMessage = "신규 직원 등록 성공!";
                    break;
                case  'update':
                    successMessage = "직원 정보 수정 성공!";
                    break;
                case 'deleteEmp':
                    successMessage = "직원 정보 삭제 성공!";
                    break;
            }
            alert(successMessage);
            location.href = '${pageContext.servletContext.contextPath}/employee/list';
        })(); // 즉시 실행 함수! (function(){})();
    </script>
</body>
</html>
