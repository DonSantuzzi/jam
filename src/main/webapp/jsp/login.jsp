<%--
  Created by IntelliJ IDEA.
  User: agrunow
  Date: 14.11.16
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bitte loggen Sie sich ein!</title>
</head>
<body>

    <form name="login" method="POST" action="/login">
        <table>
            <tr>
                <td>Login:</td>
                <td><input type="text" name="username" value="Kekse"></td>
            </tr>
            <tr>
                <td>Passwort:</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="log mich ein!"></td>
                <td><input type="reset" value="lösch ma alles!"></td>
            </tr>
        </table>
    </form>

</body>
</html>
