<%--
  Created by IntelliJ IDEA.
  User: qqins
  Date: 2018/8/26
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试json交互</title>
</head>
<script type="text/javascript"
        src="/js/jquery-3.3.1.min.js">
</script>
<script type="text/javascript">
    function testJson() {
        var username = $("#username").val();
        var password = $("#password").val();
        $.ajax({
            url: "/testJson",
            type: "post",
            data: JSON.stringify({username: username, password: password}),
            contentType: "application/json;charset=UTF-8",
            dataType: "json",
            success: function (data) {
                if (data != null) {
                    alert("您输入的用户名为: " + data.username + " " +
                        "密码为：" + data.password);
                }
            }
        });
    }
</script>
<body>
<form>
    用户名：<input type="text" name="username" id="username"/><br/>
    密&nbsp;&nbsp;&nbsp;码：
    <input type="password" name="password" id="password"/><br/>
    <input type="button" value="测试json交互" onclick="testJson()"/>
</form>
</body>
</html>
