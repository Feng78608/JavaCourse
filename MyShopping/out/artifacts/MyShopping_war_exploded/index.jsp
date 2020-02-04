<%@ page import="Dao.GoodsDao" %><%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 2019/12/7
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="utf-8">
    <title>商城</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript" src="index.js"></script>
  </head>
  <body>
  <%--<form method="post" action="regist.jsp">
    <input type="submit" value="注册"/>
    <a href="login.jsp">登录</a>
  </form>--%>
  <!-- --------------------页眉板块-------------------- -->
  <div class="header">
    <!-- 设置logo -->
    <div class="logo">
      <img src="css/images/logo.png">
    </div>

    <!-- 设置菜单 -->
    <div class="auth" >
      <ul>
        <li><a href="index.jsp" style="color: #F5F5F5">主页</a></li>
        <li><a href="car.jsp" style="color: #F5F5F5">购物车</a></li>
          <li><a href="regist.jsp" style="color: #F5F5F5">注册</a></li>
          <li><a href="order.jsp" style="color: #F5F5F5">订单</a></li>
      </ul>
    </div>
      <%--管理员登录--%>
      <div class="auth">
          <ul>
              <li><a href="loginManager.jsp" style="color: #F5F5F5">管理员登录</a></li>
          </ul>
      </div>
    <!-- 设置用户登录 -->
   <%if((session.getAttribute("userId")==null)){%>

    <div class="auth">
      <ul>
        <%--<li><button href="login.jsp" id="sub_login" value="登录" /></li>--%>

        <li><a href="login.jsp" style="color: #F5F5F5">登录</a></li>
      </ul>
    </div>
     <% }else{%>

      <div class="auth">
          <ul>
              <li><a href="user.jsp" style="color: #F5F5F5">用户：<%=session.getAttribute("userId")%></a></li>
              <li><a href="out" style="color: #F5F5F5">退出登录</a></li>
          </ul>
      </div>
     <% }%>
  </div>

  <!-- --------------------正文板块-------------------- -->
  <div class="content">
    <!-- 设置广告栏 -->
    <div class="banner">
      <img src="css/images/welcome.png" class="banner_img">
    </div>

    <div class="img_content">
      <ul>
          <%String uId=(String)session.getAttribute("userId");
          request.getSession().setAttribute("uid",uId);
          GoodsDao goodsDao=new GoodsDao();
          for(int i=0;i<goodsDao.goods.size();i++){
            String picture=goodsDao.goods.get(i).getGood_picture();
          %>

        <form action="add" method="post">
        <li style="height: 490px">
          <img src="css/images/<%=picture%>" style="width: 361px;height: 240px" class="img_li">
              <%--<img src="css/images/<%=goodsDao.goods.get(i).getGood_picture()%>"  style="width: 361px;height: 240px"  class="img_li"/>--%>

              <div class="info">
            <h3><%=goodsDao.goods.get(i).getGood_name()%></h3>
            <p>
                <%=goodsDao.goods.get(i).getGood_brief()%>
            </p>
            <div class="img_btn">
              <!-- 价格，购买logo -->
              <p><div class="price"><%=goodsDao.goods.get(i).getGood_price()%></div></p>
                <br/>
             <%-- 购买数量--%>
              <input type = "hidden" name = "uid" value = "<%=uId%>"/>
              <input type = "hidden" name = "id" value = "<%=goodsDao.goods.get(i).getGood_id()%>"/>
              <input type="text" name="num" class="text"/>

              <!-- 购物车按钮 -->
              <div class="login_control">
                <input type="submit" id="sub_login" value="加入购物车"/>
                <%--src="css/images/cart.svg"--%>
              </div>
            </div>
          </div>
        </li>
        </form>

          <% }%>
      </ul>
    </div>
  </div>
  <!-- --------------------页脚板块-------------------- -->
  <div class="footer">
    <p class="p2">造烛求明，读书求理© 2019 POWERED BY <span>WanKcn</span></p>
  </div>
  </body>
</html>
