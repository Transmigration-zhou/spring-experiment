<%--
  Created by IntelliJ IDEA.
  User: 熠丶
  Date: 2021/12/15
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
<h1>简易设备资产管理系统</h1>
<form action="/login.html" method="post">
    用户名:<input type="text" name="login_name"><br>
    密码:<input type="password" name="password"><br>
    <input type="submit" value="管理员登陆">
    <input type="submit" value="用户登陆">
    <input type="button" value="注册" onclick="window.location.href='/register.html'"><br>
</form>
</body>
</html>
