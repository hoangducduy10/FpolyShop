<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SanPhamChiTiet</title>
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
    <h1 class="text-center">Sản Phẩm Chi Tiết</h1>
    <br>
    <br>
    <form action="/san-pham-chi-tiet/add" method="post">
        <div class="row">
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Năm Bảo Hành</label>
                    <input type="text" name="namBH" class="form-control" value="${spct.namBH}">
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Mô Tả</label>
                    <input type="text" name="moTa" class="form-control" value="${spct.moTa}">
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Số Lượng Tồn</label>
                    <input type="text" name="soLuongTon" class="form-control" value="${spct.soLuongTon}">
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Giá Nhập</label>
                    <input type="text" name="giaNhap" class="form-control" value="${spct.giaNhap}">
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Giá Bán</label>
                    <input type="text" name="giaBan" class="form-control" value="${spct.giaBan}">
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
            <th scope="col">Năm Bảo Hành</th>
            <th scope="col">Mô Tả</th>
            <th scope="col">Số Lượng Tồn</th>
            <th scope="col">Giá Nhập</th>
            <th scope="col">Giá Bán</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${spctList}" var="spct">
            <tr>
                <td>${spct.id}</td>
                <td>${spct.namBH}</td>
                <td>${spct.moTa}</td>
                <td>${spct.soLuongTon}</td>
                <td>${spct.giaNhap}</td>
                <td>${spct.giaBan}</td>
                <td>
                    <button class="btn btn-info"><a href="/san-pham-chi-tiet/detail?id=${spct.id}">Detail</a></button>
                    <button class="btn btn-danger"><a href="/san-pham-chi-tiet/remove?id=${spct.id}">Remove</a></button>
                    <button class="btn btn-warning"><a href="/san-pham-chi-tiet/view-update?id=${spct.id}">Edit</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
