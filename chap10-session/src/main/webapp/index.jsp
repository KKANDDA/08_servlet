<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Session</title>
</head>
<body>
    <h1>Session handler</h1>
    <br/>
    <form action="sesstion" method="post">
        <table>
            <tr>
                <td>firstName: </td>
                <td><input type="text" name="firstName"></td>
            </tr>
            <tr>
                <td>lastName: </td>
                <td><input type="text" name="lastName"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit">전송</button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>