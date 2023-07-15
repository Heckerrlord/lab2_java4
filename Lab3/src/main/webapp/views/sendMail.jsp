
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mail</title>
</head>
<body>
<h1>Send mail</h1>
        <form action="/ASM_GD1_JAVA4/sendMail" method="post" enctype="multipart/form-data">
          <label>To: </label><br>
          <input type="email" name="to" id="" required><br>
          <label>Subject: </label><br>
          <input type="text" name="subject" required><br>
          <label>Message: </label><br>
          <textarea name="message" cols="30" rows="5" required></textarea><br>
          <label>File:</label><br>
          <input type="file" name="file">
          <br>
          <hr>
          <button>Submit</button>
        </form>
<h3>${alert}</h3>
</body>
</html>
