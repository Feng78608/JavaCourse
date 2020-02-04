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
    <title>UserLogin</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <%--<script type="text/javascript">
        function CheckCode(obj)
        {

            obj.src="CheckCode?"+new Date().getTime();
            $(function () {
                $("#tou").load('login.jsp');
            });
        }

    </script>--%>
</head>

<body>
<div id="login_frame">
    <form method="post" action="userLogin">
        <p>
            <label class="label_car">读者登录</label>
        </p>
        <p>
            <label class="label_input">id</label>
            <label for="userid"><input type="text" id="userid" name="userid" class="text_field"/></label>
        </p>
        <p>
            <label class="label_input">用户名</label>
            <label for="username"><input type="text" id="username" name="username" class="text_field"/></label>
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
