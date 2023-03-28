<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 03/28/2023
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<h2>Caculator</h2>
<form action="/caculator" method="get">
  <div>
    <input type="number" name="number1" value="${number1}">
    <input type="number" name="number2" value="${number2}" >
  </div>
  <div>
    <input type="submit" name="caculate" value="Addition(+)">
    <input type="submit" name="caculate" value="Subtraction(-)">
    <input type="submit" name="caculate" value="Multiplication(*)">
    <input type="submit" name="caculate" value="Division(/)">
  </div>
</form>
<p style="font-weight: bolder"> Result ${caculationMessage} : ${result}</p>
<p style="color: red">${message}</p>
</body>
</html>
