<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP-Upload</title>
</head>
<body>
<form action="/ASM_GD1_JAVA4/upload" method="post" enctype="multipart/form-data">
    <label>Hình ảnh</label>
    <br>
    <input type="file" name="img"><br>
    <label>Tài liệu</label>
    <br>
    <input type="file" name="doc"><br>
    <hr>
    <button>Upload</button>
</form>
<h2>${message}</h2>
</body>
</html>