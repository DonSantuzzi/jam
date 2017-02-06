<%@ page import="java.time.Instant" %>
<%@ page import="java.time.ZoneId" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: agrunow
  Date: 14.11.16
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="userbean" type="com.unitedinternet.jam.konten.model.UserBean"
             scope="session"/>
<jsp:useBean id="zeitBean" type="com.unitedinternet.jam.konten.model.ZeitBean"
             scope="session"/>
<html>
<head>
    <title>Login erfolgreich!</title>
</head>
<body>

   Juhu, ich habe mich eingeloggt.

   Ich bin User <jsp:getProperty name="userbean" property="user" />
<p />
<hr />
<jsp:getProperty name="zeitBean" property="zeit" />
</body>
</html>
