<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Staff-form</title>
</head>
<body>
<h2>Thông tin nhân viên</h2>
<form action="/ASM_GD1_JAVA4/staff" method="post" enctype="multipart/form-data">
    <label>Họ và tên: </label> <br>
    <input type="text" name="fullName" min="6" maxlength="32" placeholder="Name" required> <br>

    <label>Hình ảnh:</label> <br>
    <input type="file" name="avt_img"><br>

    <label>Ngày sinh: </label> <br>
    <input type="text" name="birthDay" placeholder="Ngày Sinh" required> <br>

    <label>Quốc tịch</label><br>
    <select name="country" required>
        <option value="US">United States</option>
        <option value="VN">Việt Nam</option>
    </select>
    <br>
    <label>Giới tính: </label>
    <input type="radio" name="gender" value="true" checked>Nam
    <input type="radio" name="gender" value="false">Nữ <br>

    <label>Tình trạng hôn nhân </label>
    <input type="checkbox" name="married">Đã kết hôn
    <br>

    <label>Sở thích</label><br>
    <input type="checkbox" name="hobbies" value="Đọc sách">Đọc sách
    <input type="checkbox" name="hobbies" value="Du lịch">Du lịch
    <input type="checkbox" name="hobbies" value="Âm nhạc">Âm nhạc
    <input type="checkbox" name="hobbies" value="Khác">Khác
    <br>
    <label>Ghi chú</label><br>
    <textarea name="notes" cols="30" rows="3" placeholder="Ghi chú"></textarea><br>
    <hr>

    <button>Submit</button>
</form>
<h3>${alert}</h3>
</body>
</html>
