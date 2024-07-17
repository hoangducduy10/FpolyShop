<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>NhanVien</title>
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
    <h1 class="text-center">Nhân Viên</h1>
    <br>
    <br>
    <form action="/nhan-vien/add" method="post">
        <div class="row">
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Mã Nhân Viên</label>
                    <input type="text" name="ma" class="form-control" value="${nv.ma}">
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Tên</label>
                    <input type="text" name="ten" class="form-control" value="${nv.ten}">
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Tên Đệm</label>
                    <input type="text" name="tenDem" class="form-control" value="${nv.tenDem}">
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Họ</label>
                    <input type="text" name="ho" class="form-control" value="${nv.ho}">
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Giới Tính</label>
                    <input type="text" name="gioiTinh" class="form-control" value="${nv.gioiTinh}">
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Ngày Sinh</label>
                    <input type="text" name="ngaySinh" class="form-control" value="${nv.ngaySinh}">
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Địa Chỉ</label>
                    <input type="text" name="diaChi" class="form-control" value="${nv.diaChi}">
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">SĐT</label>
                    <input type="text" name="sdt" class="form-control" value="${nv.sdt}">
                </div>
            </div>
            <div class="col">
                <div class="mb-3">
                    <label class="form-label">Trạng Thái</label>
                    <input type="text" name="trangThai" class="form-control" value="${nv.trangThai}">
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
            <th scope="col">Giới Tính</th>
            <th scope="col">Ngày Sinh</th>
            <th scope="col">Địa Chỉ</th>
            <th scope="col">SĐT</th>
            <th scope="col">Trạng Thái</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${nvList}" var="nv">
            <tr>
                <td>${nv.id}</td>
                <td>${nv.ma}</td>
                <td>${nv.ten}</td>
                <td>${nv.tenDem}</td>
                <td>${nv.ho}</td>
                <td>${nv.gioiTinh}</td>
                <td>${nv.ngaySinh}</td>
                <td>${nv.diaChi}</td>
                <td>${nv.sdt}</td>
                <td>${nv.trangThai}</td>
                <td>
                    <button class="btn btn-info"><a href="/nhan-vien/detail?id=${nv.id}">Detail</a></button>
                    <button class="btn btn-danger"><a href="/nhan-vien/remove?id=${nv.id}">Remove</a></button>
                    <button class="btn btn-warning"><a href="/nhan-vien/view-update?id=${nv.id}">Edit</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7nvXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
