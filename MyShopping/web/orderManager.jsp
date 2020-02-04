<%@ page import="Dao.GoodsDao" %>
<%@ page import="Dao.CarDao" %>
<%@ page import="Dao.OrderDao" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="Javabean.Goods" %>
<%@ page import="Dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 2019/12/19
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>order</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript" src="index.js"></script>
</head>
<body>

<!-- --------------------页眉板块-------------------- -->
<div class="header">
    <!-- 设置logo -->
    <div class="logo">
        <img src="css/images/logo.png">
    </div>

    <!-- 设置菜单 -->
    <div class="auth">
    <ul>
        <li><a href="addGoods.jsp" style="color: #F5F5F5">主页</a></li>
        <li><a href="out" style="color: #F5F5F5">退出登录</a></li>
    </ul>
    </div>
    <!-- 设置用户登录 -->
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
    <div class="banner">
        <img src="css/images/welcome.png" class="banner_img">
    </div>
    <div class="img_content">
        <ul>
            <%  float nowPrice=0;
                float price=0;
                OrderDao orderDao= null;
                try {
                    orderDao = new OrderDao();
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                GoodsDao goodsDao= null;
                try {
                    goodsDao = new GoodsDao();
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                UserDao userDao= null;
                try {
                    userDao = new UserDao();
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Goods goods=new Goods();
                assert orderDao != null;
                for(int i = 0; i<orderDao.getOrder().size(); i++){
                    try {
                        assert goodsDao != null;
                        goods=goodsDao.getGoodById(orderDao.getOrder().get(i).getGood_id());

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                        price=orderDao.getOrder().get(i).getGood_num()*goods.getGood_price();
                        String picture=goods.getGood_picture();
                    int oId=orderDao.getOrder().get(i).getOrder_id();
                    nowPrice+=price;
                    assert userDao != null;%>
                <li style="height: 450px">
                    <img src="css/images/<%=picture%>" style="width: 361px;height: 240px" class="img_li">
                    <div class="info">
                        <form action="updateByUser" method="post">
                            <p>
                                <label class="label_car">用户:<%=userDao.getInfoById(orderDao.getOrderById(oId).getUser_id()).getUser_name()%></label>
                            </p>
                        <p>
                            <label class="label_car">商品名:<%=goods.getGood_name()%></label>
                        </p>
                        <!-- 价格 -->
                        <p>
                            <label class="label_car">商品价格:<%=goods.getGood_price()%>元</label>
                        </p>
                        <p>
                            <label class="label_car">购买数量：<%=orderDao.getOrder().get(i).getGood_num()%></label>
                        </p>
                        <p>
                            <label class="label_car">商品总价:<%=price%>元</label>
                        </p>
                        </form>
                    </div>

                </li>

                     <% }%>

        </ul>
    </div>
    <button class="buttton" style="position: fixed;top:400px;right:100px">总价：<%=nowPrice%></button>
</div>
<!-- --------------------页脚板块-------------------- -->
<div class="footer">
    <p class="p2">造烛求明，读书求理© 2019 POWERED BY <span>WanKcn</span></p>
</div>
</body>
</html>
