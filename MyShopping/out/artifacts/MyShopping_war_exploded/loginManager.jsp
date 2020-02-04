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
    <title>LoginManager</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>

</head>
<body>
<div id="login_frame">
    <%--<p id="image_logo"><img src="images/login/fly.png"></p>--%>
    <form method="post" action="LoginManager">
        <p>
            <label class="label_car">管理员登录</label>
        </p>
        <p>
            <label class="label_input">id</label>
            <input type="text" id="lo_userid" name="lo_userid" class="text_field"/>
        </p>
        <p>
            <label class="label_input">用户名</label>
            <input type="text" id="lo_username" name="lo_username" class="text_field"/>
        </p>
        <p>
            <label class="label_input">密码</label>
            <input type="password" id="lo_password" name="lo_password" class="text_field"/>
        </p>
        <%--<p>
            <td>
                <label class="label_input">验证码</label>
                <input type="text" name="yanzheng" size="20">
                <img src="CheckCode" onclick="CheckCode(this)">
            </td>
        </p>--%>
        <div id="login_control">
            <input type="submit" id="sub_login" value="登录" />
            <a id="forget_pwd" href="forget_pwd.html">忘记密码？</a>
        </div>
    </form>
</div>
</body>
</html>
