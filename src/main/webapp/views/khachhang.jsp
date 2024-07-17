<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>KhachHang</title>
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
    <h1 class="text-center">Khách Hàng</h1>
    <br>
    <br>
    <form action="/khach-hang/add" method="post">
        <div class="row">
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Mã KH</label>
                    <input type="text" name="ma" class="form-control" value="${kh.ma}">
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Tên</label>
                    <input type="text" name="ten" class="form-control" value="${kh.ten}">
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Tên Đệm</label>
                    <input type="text" name="tenDem" class="form-control" value="${kh.tenDem}">
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Họ</label>
                    <input type="text" name="ho" class="form-control" value="${kh.ho}">
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Ngày Sinh</label>
                    <input type="text" name="ngaySinh" class="form-control" value="${kh.ngaySinh}">
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">SĐT</label>
                    <input type="text" name="sdt" class="form-control" value="${kh.sdt}">
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Địa Chỉ</label>
                    <input type="text" name="diaChi" class="form-control" value="${kh.diaChi}">
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Thành Phố</label>
                    <input type="text" name="thanhPho" class="form-control" value="${kh.thanhPho}">
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Quốc Gia</label>
                    <input type="text" name="quocGia" class="form-control" value="${kh.quocGia}">
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Mật Khẩu</label>
                    <input type="text" name="matKhau" class="form-control" value="${kh.matKhau}">
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
            <th scope="col">Tên Đệm</th>
            <th scope="col">Họ</th>
            <th scope="col">Ngày Sinh</th>
            <th scope="col">SĐT</th>
            <th scope="col">Địa Chỉ</th>
            <th scope="col">Thành Phố</th>
            <th scope="col">Quốc Gia</th>
            <th scope="col">Mật Khẩu</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${khList}" var="kh">
            <tr>
                <td>${kh.id}</td>
                <td>${kh.ma}</td>
                <td>${kh.ten}</td>
                <td>${kh.tenDem}</td>
                <td>${kh.ho}</td>
                <td>${kh.ngaySinh}</td>
                <td>${kh.sdt}</td>
                <td>${kh.diaChi}</td>
                <td>${kh.thanhPho}</td>
                <td>${kh.quocGia}</td>
                <td>${kh.matKhau}</td>
                <td>
                    <button class="btn btn-info"><a href="/khach-hang/detail?id=${kh.id}">Detail</a></button>
                    <button class="btn btn-danger"><a href="/khach-hang/remove?id=${kh.id}">Remove</a></button>
                    <button class="btn btn-warning"><a href="/khach-hang/view-update?id=${kh.id}">Edit</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7khXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
