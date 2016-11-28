<%--
  Created by IntelliJ IDEA.
  User: agrunow
  Date: 14.11.16
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="userbean" type="com.unitedinternet.jam.konten.model.UserBean" scope="session"/>
<html>
<head>
    <title>Login erfolgreich!</title>
</head>
<body>

   Juhu, ich habe mich eingeloggt.
   Ich bin User <jsp:getProperty name="userbean" property="User" />

</body>
</html>
