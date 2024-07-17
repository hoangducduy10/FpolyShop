<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CuaHang</title>
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
        <h1 class="text-center">Cửa Hàng</h1>
        <br>
        <br>
        <form action="/cua-hang/add" method="post">
            <div class="row">
                <div class="col">
                    <div class="mb-3">
                        <label class="form-label">Mã</label>
                        <input type="text" name="ma" class="form-control" value="${ch.ma}">
                    </div>
                </div>
                <div class="col">
                    <div class="mb-3">
                        <label class="form-label">Tên</label>
                        <input type="text" name="ten" class="form-control" value="${ch.ten}">
                    </div>
                </div>
                <div class="col">
                    <div class="mb-3">
                        <label class="form-label">Địa Chỉ</label>
                        <input type="text" name="diaChi" class="form-control" value="${ch.diaChi}">
                    </div>
                </div>
                <div class="col">
                    <div class="mb-3">
                        <label class="form-label">Thành Phố</label>
                        <input type="text" name="thanhPho" class="form-control" value="${ch.thanhPho}">
                    </div>
                </div>
                <div class="col">
                    <div class="mb-3">
                        <label class="form-label">Quốc Gia</label>
                        <input type="text" name="quocGia" class="form-control" value="${ch.quocGia}">
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
                <th scope="col">Địa Chỉ</th>
                <th scope="col">Thành Phố</th>
                <th scope="col">Quốc Gia</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${chList}" var="ch">
                <tr>
                    <td>${ch.id}</td>
                    <td>${ch.ma}</td>
                    <td>${ch.ten}</td>
                    <td>${ch.diaChi}</td>
                    <td>${ch.thanhPho}</td>
                    <td>${ch.quocGia}</td>
                    <td>
                        <button class="btn btn-info"><a href="/cua-hang/detail?id=${ch.id}">Detail</a></button>
                        <button class="btn btn-danger"><a href="/cua-hang/remove?id=${ch.id}">Remove</a></button>
                        <button class="btn btn-warning"><a href="/cua-hang/view-update?id=${ch.id}">Edit</a></button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsp1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
