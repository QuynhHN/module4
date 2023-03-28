<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 03/28/2023
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h2>Sandwich Condiments</h2>
<form action="/save" method="get">
    <label>
        <input type="checkbox" name="condiments" id="lettuce" value="lettuce">Lettuce
    </label>
    <label>
        <input type="checkbox" name="condiments" id="tomato" value="tomato">Tomato
    </label>
    <label>
        <input type="checkbox" name="condiments" id="mustard" value="mustard">Mustard
    </label>
    <label>
        <input type="checkbox" name="condiments" id="sprouts" value="sprouts">Sprouts
    </label>
    <hr>
    <input type="submit" value="Save">
</form>
<p>The condiments in the sandwich</p>
<p>${condimentsList}</p>
</body>
</html>
