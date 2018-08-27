<%--
  Created by IntelliJ IDEA.
  User: qqins
  Date: 2018/8/26
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RESTful测试</title>
    <script type="text/javascript"
            src="/js/jquery-3.3.1.min.js">
    </script>
    <script type="text/javascript">
        function search() {
            var id = $("#number").val();
            $.ajax({
                url: "/user/" + id,
                type: "GET",
                dataType: "json",
                success: function (data) {
                    if (data.username != null) {
                        alert("您查询的用户是：" + data.username);
                    } else {
                        alert("没有找到id为：" + id + "的用户！");
                    }
                }
            });
        }
    </script>
</head>
<body>
<form>
    编号：<input type="text" name="number" id="number">
    <input type="button" value="搜索" onclick="search()"/>
</form>
</body>
</html>
