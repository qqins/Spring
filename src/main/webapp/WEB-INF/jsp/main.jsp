<%--
  Created by IntelliJ IDEA.
  User: qqins
  Date: 2018/8/27
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统主页</title>
</head>
<body>
    当前用户：${USER_SESSION.username}
    <a href="/logout">退出</a>
</body>
</html>
