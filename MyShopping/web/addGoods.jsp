<%@ page import="Dao.GoodsDao" %>
<%@ page import="java.sql.SQLException" %><%--
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
      <div class="auth">
          <ul>
              <li><a href="orderManager.jsp" style="color: #F5F5F5">订单</a></li>
              <li><a href="out" style="color: #F5F5F5">退出登录</a></li>
          </ul>
      </div>
    <!-- 设置管理员登录 -->
   <%if(session.getAttribute("managerId")==null){%>

    <div class="auth">
      <ul>
        <%--<li><button href="login.jsp" id="sub_login" value="登录" /></li>--%>
        <li><a href="loginManager.jsp" style="color: #F5F5F5">登录</a></li>
      </ul>
    </div>
     <% }else{%>

      <div class="auth">
          <ul>
              <li><a href="manager.jsp" style="color: #F5F5F5">管理员：<%=session.getAttribute("managerId")%></a></li>
          </ul>
      </div>
     <% }%>
  </div>

  <!-- --------------------正文板块-------------------- -->
  <div class="content">
      <!-- 设置广告栏 -->
      <div class="banner">
          <img src="css/images/welcome.png"  class="banner_img">
      </div>
    <div class="img_content">
      <ul>
          <li style="height: 230px">
              <form method="post" action="AddGoodsByManager">
                  <%--<img src="css/images/<%=picture%>" style="width: 361px;height: 240px" class="img_li">--%>
                  <p>
                      <label class="label_input">商品ID</label>
                      <input type="text" id="good_id" name="good_id" class="text"/>
                  </p>
                  <p>
                      <label class="label_input">商品图片</label>
                      <input type="text" id="good_picture" name="good_picture" class="text"/>
                  </p>
                  <p>
                      <label class="label_input">商品名</label>
                      <input type="text" id="good_name" name="good_name" class="text"/>
                  </p>
                  <p>
                      <label class="label_input">商品价格</label>
                      <input type="text" id="good_price" name="good_price" class="text"/>
                  </p>
                  <p>
                      <label class="label_input">商品库存</label>
                      <input type="text" id="good_stock" name="good_stock" class="text"/>
                  </p>
                  <p>
                      <label class="label_input">商品简介</label>
                      <input type="text" id="good_breif" name="good_breif" class="text"/>
                  </p>
                  <input type="submit" class="buttton" value="添加" />
              </form>
          </li>

          <%String mId=(String)session.getAttribute("managerId");
          request.getSession().setAttribute("mid",mId);
              GoodsDao goodsDao= null;
              try {
                  goodsDao = new GoodsDao();
              } catch (SQLException | ClassNotFoundException e) {
                  e.printStackTrace();
              }
              assert goodsDao != null;
              for(int i = goodsDao.goods.size()-1; i>=0; i--){
            String picture=goodsDao.goods.get(i).getGood_picture();
          %>


        <li style="height: 550px">
            <form method="post" action="updateGoodsByManager">
          <img src="css/images/<%=picture%>" style="width: 361px;height: 240px" class="img_li">

              <div class="info">
                  <p >
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">商品ID:<%=goodsDao.goods.get(i).getGood_id()%></label>
                      <%--<input type="" id="up_good_id" name="up_good_id" value="<%=goodsDao.goods.get(i).getGood_id()%>" class="text"/>--%>
                  </p>
                  <p>
                      <label class="label_input">商品图片</label>
                      <input type="text" id="up_good_picture" name="up_good_picture" value="<%=picture%>" class="text"/>
                  </p>
            <%--<h3><%=goodsDao.goods.get(i).getGood_name()%></h3>--%>

                  <p>
                      <label class="label_input">商品名</label>
                      <input type="text" id="up_good_name" name="up_good_name" class="text" value="<%=goodsDao.goods.get(i).getGood_name()%>"/>
                  </p>
                <p>
                    <label class="label_input">商品简介</label>
                    <input type="text" id="up_good_breif" name="up_good_breif" value="<%=goodsDao.goods.get(i).getGood_brief()%>" class="text"/>
                </p>
              <!-- 价格 -->
                <p>
                    <label class="label_input">商品价格</label>
                    <input type="text" id="up_good_price" name="up_good_price" value="<%=goodsDao.goods.get(i).getGood_price()%>" class="text"/>
                </p>
             <%-- 库存数量--%>
              <input type = "hidden" name = "mid" value = "<%=mId%>"/>
              <input type = "hidden" name = "id" value = "<%=goodsDao.goods.get(i).getGood_id()%>"/>
                <p>
                    <label class="label_input">商品库存</label>
                    <input type="text" id="up_good_stock" name="up_good_stock" value="<%=goodsDao.goods.get(i).getGood_stock()%>" class="text"/>
                </p>
              <!-- 修改按钮 -->
              <div class="login_control">
                      <input type="submit" class="buttton" value="修改" />
              </div>
          </div>
        </form>
            <%--删除按钮--%>
            <div class="login_control">
            <form action="deleteByManager" method="post">
                <input type = "hidden" name = "id" value = "<%=goodsDao.goods.get(i).getGood_id()%>"/>
                <input type="submit" id="sub_login" value="删除该商品"/>
            </form>
            </div>
        </li>


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
