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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<body>
<div class="container" style="width: 50%">
    <h2>Sandwich Condiments</h2>
    <form action="/save" method="get">
        <div class="mb-3">
            <label for="lettuce" class="form-label">
                <input type="checkbox" class="form-check-input" name="condiments" id="lettuce" value="lettuce">Lettuce
            </label>
            <label class="form-label" for="tomato">
                <input type="checkbox" class="form-check-input" name="condiments" id="tomato" value="tomato">Tomato
            </label>
            <label class="form-label" for="mustard">
                <input type="checkbox" class="form-check-input" name="condiments" id="mustard" value="mustard">Mustard
            </label>
            <label class="form-label" for="sprouts">
                <input type="checkbox" class="form-check-input" name="condiments" id="sprouts" value="sprouts">Sprouts
            </label>
        </div>
        <hr>
        <input type="submit" class="btn btn-primary" value="Save">
    </form>
    <p>The condiments in the sandwich</p>
    <p>${condimentsList}</p>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
