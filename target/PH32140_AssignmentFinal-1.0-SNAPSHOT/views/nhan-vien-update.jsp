<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UpdateNhanVien</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<form action="/nhan-vien/update" method="post">
    <div class="row">
        <div class="col">
            <div class="mb-3">
                <label class="form-label">Mã Nhân Viên</label>
                <input type="text" name="ma" class="form-control" value="${nv.ma}">
                <input type="hidden" name="id" class="form-control" value="${nv.id}">
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
    <button type="submit" class="btn btn-success float-end">Update</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
