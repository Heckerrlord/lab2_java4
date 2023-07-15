
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>cookies</title>
</head>
<body>

        <form action="/ASM_GD1_JAVA4/cookies" method="post">
          <label>User name:</label> <br>
            <input type="text" required maxlength="20" min="6" value="${username}" name="username"><br>

          <label>Pass Word: </label> <br>
            <input type="${type}" id="password" required maxlength="20" min="6" name="password" value="${password}"><br>
            <input type="checkbox" name="showpass" id="showpass" checked>Show passWord

            <input type="checkbox" name="remember"> Remember me?

          <hr>
          <button>Login</button>
          <br>
            <h3><mark>${message}</mark></h3>

        </form>
        <script>
            const passIp = document.getElementById("password");
            const showPass = document.getElementById("showpass");

            showPass.addEventListener("change",function (){
                passIp.type = showPass.checked ? "text":"password";
            });
        </script>
</body>
</html>
