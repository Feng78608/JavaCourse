<%@ page import="Dao.AdminDao" %>
<%@ page import="Javabean.Admin" %><%--
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
    <title>ManagerInformation</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>


</head>
<body>
<div id="login_frame">
    <%String mId=(String)session.getAttribute("managerId");
        request.getSession().setAttribute("mid",mId);
        AdminDao adminDao=new AdminDao();
      Admin admin=adminDao.getInfoById(mId);
    %>
    <form method="post" action="updateManagerInfo">
        <p>
            <label class="label_car">管理员信息</label>
        </p>
        <p>
            <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:345px">id:<%=admin.getAmin_id()%></label>
            <input type = "hidden" name = "mid" value = "<%=mId%>"/>
        </p>
        <p>
            <label class="label_input">用户名</label>
            <input type="text" id="managername" name="managername" value="<%=admin.getAdmin_name()%>" class="text_field"/>
        </p>
        <p>
            <label class="label_input">密码</label>
            <input type="password" id="mpassword" name="mpassword" value="<%=admin.getAdmin_pwd()%>" class="text_field"/>
        </p>
        <div id="login_control">
            <input type="submit" id="sub_login" value="修改" />
            <a href="addGoods.jsp">返回主页</a>
        </div>
    </form>
</div>
</body>
</html>
