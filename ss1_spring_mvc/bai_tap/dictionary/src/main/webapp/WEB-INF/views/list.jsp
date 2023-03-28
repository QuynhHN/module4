<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 03/28/2023
  Time: 10:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<h2>Dictionary</h2>
<form action="/dictionary">
    <input type="text" name="english" placeholder="search" value="${english}">
    <input type="submit" value="search">
</form>
<h2>${result}</h2>
</body>
</html>
