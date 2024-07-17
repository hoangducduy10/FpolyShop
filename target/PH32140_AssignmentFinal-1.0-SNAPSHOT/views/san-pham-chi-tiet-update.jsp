<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UpdateSanPhamChiTiet</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<form action="/san-pham-chi-tiet/update" method="post">
    <div class="row">
        <div class="col">
            <div class="mb-3">
                <label class="form-label">ID</label>
                <input type="text" name="id" class="form-control" value="${spct.id}">
            </div>
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
            <div class="mb-3">
                <label class="form-label">Giá Bán</label>
                <input type="text" name="giaBan" class="form-control" value="${spct.giaBan}">
            </div>
        </div>
    </div>
    <br>
    <button type="submit" class="btn btn-success">Update</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
