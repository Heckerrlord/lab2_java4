<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

</head>

<body>

	<section>
	<ul>
		<li>Tên đăng nhập: <b>${param.username}</b></li>
		<li>Mật khẩu: <b>${param.password}</b></li>
		<li>Giới tính: <b>${param.gender == 'true' ? 'nam' : 'nữ'}</b></li>
		<li>Tình trạng hôn nhân: <b>${param.married == 'true' ? 'có' : 'không'}</b></li>
		<li>Quốc tịch: <b>${param.country}</b></li>
		<li>Sở thích: 
			<c:forEach var="hobby" items="${paramValues.hobbies}">
				<li><c:out value="${hobby}" /></li>
			</c:forEach>
		</li>
		<li>Ghi chú: <b>${param.notes}</b></li>
	</ul>
</section>


</body>
</html>