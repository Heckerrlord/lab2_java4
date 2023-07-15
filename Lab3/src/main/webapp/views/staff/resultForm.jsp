<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/17/2023
  Time: 12:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>form-result</title>
</head>
<body>

<ul>
    <li>Họ và tên: <b>${bean.fullName}</b></li>
    <li>Hình ảnh:<br> <img src="../ASM_GD1_JAVA4/files/${bean.avatar}" height="60" width="60"></li>
    <li>Ngày sinh: <b>${bean.birthDay}</b></li>
    <li>Giới tính: <b>${gender}</b></li>
    <li>Quốc tịch: <b>${bean.country}</b></li>
    <li>TT hôn nhân: <b>${married}</b></li>
    <li>Sở thích: <b>${hobbies}</b></li>
    <li>Ghi chú: <b>${bean.notes}</b></li>
</ul>

</body>
</html>
