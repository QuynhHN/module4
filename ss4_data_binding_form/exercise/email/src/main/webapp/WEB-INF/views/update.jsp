<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="frorm" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 03/29/2023
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container" style="margin-top: 2%;width: 300px">
<h2>Setting</h2>
<form:form action="/email" modelAttribute="emailBox" method="post">
    <div class="mb-3">
        <label class="form-label" for="languages">Languages:</label>
        <form:select path="language" id="languages" items="${languagesList}"/>
    </div>
    <div class="mb-3">
        <label class="form-label" for="pageSize">Page Size:</label>

        <span>Show</span>
        <form:select path="pageSize" id="pageSize" items="${pagesizesList}"/>
        <span>emails per page</span>

    </div>
    <div class="mb-3">
        <label class="form-label" for="spamFilte">Spams filter:</label>
        <form:checkbox path="spamsFilter" id="spamFilte"/>
        <span>Enable spams filter</span>
    </div>
    <div class="mb-3">
        <label class="form-label" for="signature">Signature:</label>
        <form:textarea path="signature" id="signature"/>
    </div>
    <div class="mb-3">
        <button type="submit" class="btn btn-primary">Update</button>
        <input type="reset" class="btn btn-secondary" value="Cancel"/>
    </div>
</form:form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
