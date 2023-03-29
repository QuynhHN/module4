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
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h2>Caculator</h2>
<form action="/caculator" method="get">
  <div class="mb-3">
    <label for="exampleInputNumber1" class="form-label">Number First</label>
    <input style="width: 20%" type="number" class="form-control" id="exampleInputNumber1" name="numberFirst" value="${numberFirst}">
  </div>
  <div class="mb-3">
    <label for="exampleInputNumber2" class="form-label">Number Second</label>
    <input style="width: 20%" type="number" class="form-control" id="exampleInputNumber2" name="numberSecond" value="${numberSecond}">
</div>
  <div class="mb-3">
    <input type="submit" name="caculate" value="Addition(+)">
    <input type="submit" name="caculate" value="Subtraction(-)">
    <input type="submit" name="caculate" value="Multiplication(*)">
    <input type="submit" name="caculate" value="Division(/)">
  </div>
</form>
<p style="font-weight: bolder"> Result ${caculationMessage} : ${result}</p>
<p style="color: red">${message}</p>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
