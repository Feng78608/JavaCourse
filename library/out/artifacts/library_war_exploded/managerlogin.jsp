<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 2019/12/17
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>ManagerLogin</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>

<body>
<div id="login_frame">
    <form method="post" action="managerLogin">
        <p>
            <label class="label_car">管理员登录</label>
        </p>
        <p>
            <label class="label_input">id</label>
            <label for="managerid"><input type="text" id="managerid" name="managerid" class="text_field"/></label>
        </p>
        <p>
            <label class="label_input">登录名</label>
            <label for="managername"><input type="text" id="managername" name="managername" class="text_field"/></label>
        </p>
        <p>
            <label class="label_input">密码</label>
            <label for="password"><input type="password" id="password" name="password" class="text_field"/></label>
        </p>
        <div id="login_control">
            <input type="submit" id="sub_login" value="登录" />
            <a href="index.jsp">返回主页</a>
        </div>
    </form>
</div>
</body>
</html>
