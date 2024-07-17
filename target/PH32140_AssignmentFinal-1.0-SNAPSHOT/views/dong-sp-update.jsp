<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Updatesp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<form action="/dong-sp/update" method="post">
    <div class="row">
        <div class="col">
            <div class="mb-3">
                <label class="form-label">Mã</label>
                <input type="text" name="ma" class="form-control" value="${sp.ma}">
                <input type="hidden" name="id" class="form-control" value="${sp.id}">
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
    <button type="submit" class="btn btn-success float-end">Update</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
