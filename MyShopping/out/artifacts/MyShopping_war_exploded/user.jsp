<%@ page import="Dao.AdminDao" %>
<%@ page import="Javabean.Admin" %>
<%@ page import="Dao.UserDao" %>
<%@ page import="Javabean.User" %>
<%@ page import="java.sql.SQLException" %><%--
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
    <title>UserInformation</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>


</head>
<body>
<div id="login_frame">
    <%String uId=(String)session.getAttribute("userId");
        request.getSession().setAttribute("uid",uId);
        UserDao userDao= null;
        try {
            userDao = new UserDao();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        User user= null;
        try {
            assert userDao != null;
            user = userDao.getInfoById(uId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    %>
    <form method="post" action="updateUserInfo">
        <p>
            <label class="label_car">用户信息</label>
        </p>
        <p>
            <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:345px">id:<%=user.getUser_id()%></label>
            <input type = "hidden" name = "uid" value = "<%=uId%>"/>
        </p>
        <p>
            <label class="label_input">用户名</label>
            <input type="text" id="uname" name="uname" value="<%=user.getUser_name()%>" class="text_field"/>
        </p>
        <p>
            <label class="label_input">密码</label>
            <input type="password" id="upassword" name="upassword" value="<%=user.getUser_pwd()%>" class="text_field"/>
        </p>
        <div id="login_control">
            <input type="submit" id="sub_login" value="修改" />
            <a href="index.jsp">返回主页</a>
        </div>
    </form>
</div>
</body>
</html>
