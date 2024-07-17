<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>DongSP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        a{
            text-decoration: none;
            color: black;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="text-center">DongSP</h1>
    <br>
    <br>
    <form action="/dong-sp/add" method="post">
        <div class="row">
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Mã</label>
                    <input type="text" name="ma" class="form-control" value="${sp.ma}">
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Tên</label>
                    <input type="text" name="ten" class="form-control" value="${sp.ten}">
                </div>
            </div>
        </div>
        <br>
        <br>
        <button type="submit" class="btn btn-success float-end">Add</button>
    </form>
    <br>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Mã</th>
            <th scope="col">Tên</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${spList}" var="sp">
            <tr>
                <td>${sp.id}</td>
                <td>${sp.ma}</td>
                <td>${sp.ten}</td>
                <td>
                    <button class="btn btn-info"><a href="/dong-sp/detail?id=${sp.id}">Detail</a></button>
                    <button class="btn btn-danger"><a href="/dong-sp/remove?id=${sp.id}">Remove</a></button>
                    <button class="btn btn-warning"><a href="/dong-sp/view-update?id=${sp.id}">Edit</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7spXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
