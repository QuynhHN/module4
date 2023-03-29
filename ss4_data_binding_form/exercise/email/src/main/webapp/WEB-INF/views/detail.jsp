<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 03/29/2023
  Time: 1:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h2>Detail</h2>
<table class="table">
    <tbody>
    <tr>
        <div class="form-group">
        <th scope="row">Languages</th>
        <td>${emailBox.language}</td>
        </div>
    </tr>
    <tr>
        <div class="form-group">
            <th scope="row">Page Size</th>
            <td>${emailBox.pageSize}</td>
        </div>
    </tr>
    <tr>
        <div class="form-group">
            <th scope="row">Page Size</th>
            <td>
                <span>Show</span>
                <span>${emailBox.pageSize}</span>
                <span>emails per page</span>
            </td>
        </div>
    </tr>
    <tr>
        <div class="form-group">
            <th scope="row">Spams filter</th>
            <td>
                <span>
                    <c:if test="${emailBox.spamsFilter}">
                        Enable spams filter
                    </c:if>
                    <c:if test="${!emailBox.spamsFilter}">
                        Disable spams filter
                    </c:if>
                </span>
            </td>
        </div>
    </tr>
    <tr>
        <div class="form-group">
            <th scope="row">Signature</th>
            <td>${emailBox.signature}</td>
        </div>
    </tr>
    <tr>
        <th></th>
        <td>
            <a href="/email" class="btn btn-secondary">Update</a>
        </td>
    </tr>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
