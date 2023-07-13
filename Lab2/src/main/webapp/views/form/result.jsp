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
			<li>Giới tính: <b>${param.gender?"nam":"nu"}</b></li>
			<li>Tình trạng hôn nhân: <b>${param.married?"co":"ko"}</b></li>
			<li>Quốc tịch: <b>${param.country}</b></li>
			<li>Sở thích: <b> <c:forEach var="hobby"
						items="${param.hobbies}">
						<li><c:out value="${hobby}" /></li>
					</c:forEach></b></li>

			<li>Ghi chú: <b>${param.notes}</b></li>
		</ul>
	</section>

</body>
</html>