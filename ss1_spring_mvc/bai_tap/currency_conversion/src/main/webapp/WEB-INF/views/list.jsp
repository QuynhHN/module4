<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 03/28/2023
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Conversion</title>
</head>
<body>
<h1>Currency Conversion</h1>
<form action="/currency">
    <input type="text" name="usd" id="change" value="${usd}" placeholder="Input money">
    <input type="submit" value="Convert">
</form>
<h1>VND: ${vnd}  vnd</h1>
</body>
</html>
