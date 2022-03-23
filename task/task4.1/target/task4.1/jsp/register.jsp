<%--
  Created by IntelliJ IDEA.
  User: 熠丶
  Date: 2021/12/15
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<form action="/register.html" method="post">
    用户名:<input type="text" name="login_name">
    密码:<input type="password" name="password"><br>
    密码确认:<input type="text" name="password"><br>
    真实姓名:<input type="text" name="real_name"><br>
    联系电话:<input type="text" name="tel"><br>
    电子邮箱:<input type="text" name="email"><br>
    <input type="submit" value="注册"><br>
    <input type="submit" value="取消">
</form>
</body>
</html>
