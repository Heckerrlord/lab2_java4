<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

</head>

<body>

	<section>
		<form action="/ASM_GD1_JAVA4/tam-giac" method="post">
			<input name="a" placeholder="Cạnh a?"><br> <input
				name="b" placeholder="Cạnh b?"><br> <input name="c"
				placeholder="Cạnh c?">
			<hr>
			<button formaction="/ASM_GD1_JAVA4/dien-tich">Tính diện tích</button>
			<button formaction="/ASM_GD1_JAVA4/chu-vi">Tính chu vi</button>
		</form>
		<h3>${message}</h3>
	</section>

</body>
</html>