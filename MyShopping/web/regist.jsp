<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 2019/12/17
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<div id="regist_frame">
    <%--<p id="image_logo"><img src="css/images/logo1.jpg" ></p>--%>
    <form method="post" action="regist">
        <p>
            <label class="label_car">用户注册</label>
        </p>
        <p><label class="label_input">id</label>
            <input type="text" id="rg_userid" name="rg_userid" class="text_field"/>
        </p>
        <p><label class="label_input">用户名</label>
            <input type="text" id="rg_username" name="rg_username" class="text_field"/>
        </p>
        <p><label class="label_input">密码</label>
            <input type="password" id="rg_password" name="rg_password" class="text_field"/>
        </p>
        <div id="login_control">
            <input type="submit" id="sub_login" value="注册" />
            <a id="forget_pwd" href="index.jsp">返回主界面</a>
        </div>
    </form>
</div>


</form>
</body>
</html>
