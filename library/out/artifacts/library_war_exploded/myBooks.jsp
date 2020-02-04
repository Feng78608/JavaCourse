<%@ page import="Dao.BookDao" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="Dao.ReaderDao" %>
<%@ page import="Dao.BorrowDao" %>
<%@ page import="JavaBean.Book" %>
<%@ page import="java.util.logging.SimpleFormatter" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 2019/12/21
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <title>MyBooks</title>
  <link rel="stylesheet" type="text/css" href="css/index.css">
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<!-- --------------------页眉板块-------------------- -->
<div class="header">
  <%--<div class="logo">
    <form method="post" action="query">
      <p>
        <input type="submit" class="label_input" value="查书"/>
        <label for="book"><input type="text" id="book" name="book" class="text_field"/></label>
      </p>
    </form>
  </div>--%>
  <!-- 设置菜单 -->
  <div class="auth">
      <ul><li><a href="index.jsp" style="color: #F5F5F5">主页</a></li></ul>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="out" style="color: #F5F5F5">退出登录</a>
  </div>
  <%--管理员登录--%>
  <div class="auth">
    <ul>
      <li>
        <%if((session.getAttribute("managerId")==null)&&(session.getAttribute("userId")==null)){%>
        <a href="managerlogin.jsp" style="color: #F5F5F5">管理员登录</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="userlogin.jsp" style="color: #F5F5F5">读者登录</a>
        <%} else if((session.getAttribute("managerId")!=null)&&((int)session.getAttribute("managerId")!=0)){%>
        <a style="color: #F5F5F5">管理员：<%=session.getAttribute("managerId")%></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="userlogin.jsp" style="color: #F5F5F5">读者登录</a>
        <%}else if((session.getAttribute("userId")!=null)&&((int)session.getAttribute("userId")!=0)){%>
        <a style="color: #F5F5F5">读者：<%=session.getAttribute("userId")%></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="managerlogin.jsp" style="color: #F5F5F5">管理员登录</a>
        <%}%>
      </li>
    </ul>
  </div>
</div>

<!-- --------------------正文板块-------------------- -->
<div class="content">
  <!-- 设置广告栏 -->
  <div class="banner">
    <img src="css/images/welcome.png" class="banner_img">
  </div>

  <div class="img_content">
    <ul>
      <%int uId=0;
      if((session.getAttribute("userId")!=null)&&((int)session.getAttribute("userId")!=0)){
        uId=(int)session.getAttribute("userId");
        request.getSession().setAttribute("uid",uId);
      }
          BookDao bookDao= null;
          try {
              bookDao = new BookDao();

          } catch (SQLException | ClassNotFoundException e) {
              e.printStackTrace();
          }
          assert bookDao != null;
        BorrowDao borrowDao= null;
        try {
          borrowDao = new BorrowDao();
        } catch (SQLException | ClassNotFoundException e) {
          e.printStackTrace();
        }
        assert borrowDao != null;
        Book book=new Book();
        for(int i = borrowDao.getList().size()-1; i>=0; i--){
          try {
            book=bookDao.getAllById(borrowDao.getList().get(i).getBkID());
          } catch (SQLException e) {
            e.printStackTrace();
          }
          if(borrowDao.getList().get(i).getRdID()==uId){
          Calendar calendar=Calendar.getInstance();
          long over=borrowDao.getList().get(0).getLdDateRetPlan().getTime()-calendar.getTimeInMillis();
          String picture=book.getBkCover();
      %>

      <%--<form action="borrow" method="post">--%>
        <li style="height: 480px">
          <img src="css/images/<%=picture%>" style="width: 361px;height: 240px" class="img_li">
          <%--<img src="css/images/<%=goodsDao.goods.get(i).getGood_picture()%>"  style="width: 361px;height: 240px"  class="img_li"/>--%>

          <div class="info">
            <form action="renew" method="post">
              <p>
                <label class="label_car">书名:<%=book.getBkName()%></label>
              </p>
              <p>
                <label class="label_car">作者名:<%=book.getBkAuthor()%></label>
              </p>
              <p>
                <label class="label_car">借书时间:<%=borrowDao.getList().get(i).getLdDateOut()%></label>
              </p>

              <%if(borrowDao.getList().get(i).getIsHasReturn()==0){%>
              <p>
                <label class="label_car">未还书</label>
              </p>
              <p>
                <label class="label_car">应还时间:<%=borrowDao.getList().get(i).getLdDateRetPlan()%></label>
              </p>
              <%if(over<0){
                double M=Math.abs(over)*0.05;
                float money=(float)M;
                borrowDao.getList().get(i).setLdOverMoney(money);%>
              <p>
                <label class="label_car">已超期：<%=borrowDao.getList().get(i).getLdOverDay()%>天</label>
              </p>
              <p>
                <label class="label_car">应还款：<%=M%>元</label>
              </p>
              <%}%>
              <%}else{%>
              <p>
                <label class="label_car">于<%=borrowDao.getList().get(i).getLdDateRetAct()%>已还</label>
              </p>
              <%}%>
              <input type = "hidden" name = "uid" value = "<%=uId%>"/>
              <input type = "hidden" name = "id" value = "<%=book.getBkID()%>"/>
              <input type="hidden" name="borrowid" value="<%=borrowDao.getList().get(i).getBorrowID()%>">
              <!-- 按钮 -->
              <%if(borrowDao.getList().get(i).getIsHasReturn()==0){%>
              <div class="login_control">
                <input type="submit" class="buttton" value="续借"/>
              </div><%}%>
            </form>
            <form action="return" method="post">
              <%if(borrowDao.getList().get(i).getIsHasReturn()==0){%>
              <div class="login_control">
                <input type = "hidden" name = "borrowid" value = "<%=borrowDao.getList().get(i).getBorrowID()%>"/>
                <input type="submit" class="buttton" value="还书"/>
              </div><%}%>
            </form>
            </div>
        </li>
      <% }}%>
    </ul>
  </div>
</div>
<!-- --------------------页脚板块-------------------- -->
<div class="footer">
  <p class="p2">造烛求明，读书求理© 2019 POWERED BY <span>WanKcn</span></p>
</div>
</body>
</html>
