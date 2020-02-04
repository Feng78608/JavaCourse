<%@ page import="Dao.BookDao" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="JavaBean.Book" %>
<%@ page import="Dao.ReaderDao" %>
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
  <title>Library</title>
  <link rel="stylesheet" type="text/css" href="css/index.css">
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<!-- --------------------页眉板块-------------------- -->
<div class="header">
  <div class="logo">
    <form method="post" action="query">
      <p>
        <input type="submit" class="label_input" value="查书"/>
        <label for="book"><input type="text" id="book" name="book" class="text_field"/></label>
      </p>
    </form>
  </div>
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
        <a href="userlogin.jsp" style="color: #F5F5F5">读者登录</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <%
          try {
            ReaderDao readerDao=new ReaderDao();
            String url=readerDao.getPageById((int)session.getAttribute("managerId"));%>
        <a href="<%=url%>" style="color: #F5F5F5">管理</a>
        <%} catch (SQLException | ClassNotFoundException e) {
          e.printStackTrace();
        }
        %>
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
      if(session.getAttribute("books")!=null){
          int[] books=(int[])session.getAttribute("books");
        BookDao bookDao= null;
        try {
          bookDao = new BookDao();

        } catch (SQLException | ClassNotFoundException e) {
          e.printStackTrace();
        }
        assert bookDao != null;
        Book book=new Book();
        int j=0;
        while(books[j]!=0){
          try {
            book = bookDao.getAllById(books[j]);
          } catch (SQLException e) {
            e.printStackTrace();
          }

          String picture=book.getBkCover();
      %>

      <%--<form action="borrow" method="post">--%>
        <li>
          <img src="css/images/<%=picture%>" style="width: 361px;height: 240px" class="img_li">
          <%--<img src="css/images/<%=goodsDao.goods.get(i).getGood_picture()%>"  style="width: 361px;height: 240px"  class="img_li"/>--%>
          <form action="borrow" method="post">
          <div class="info">
            <h3><%=book.getBkName()%></h3>
            <p><div class="price"><%=book.getBkPrice()%>元</div></p>
            <p><div class="price">作者：<%=book.getBkAuthor()%></div></p>
            <p>
              <%=book.getBkBrief()%>
            </p>
              <br/>
              <input type = "hidden" name = "uid" value = "<%=uId%>"/>
              <input type = "hidden" name = "id" value = "<%=book.getBkID()%>"/>

              <!-- 按钮 -->
              <div class="login_control">
                <input type="submit" class="buttton" value="借书"/>
              </div>
            </div>
            </form>
            <%--显示状态--%>
          <div class="login_control">
              <button class="buttton"><%=book.getBkStatus()%></button>
          </div>
        </li>
      <% j++;}}%>
    </ul>
  </div>
</div>
<!-- --------------------页脚板块-------------------- -->
<div class="footer">
  <p class="p2">造烛求明，读书求理© 2019 POWERED BY <span>WanKcn</span></p>
</div>
</body>
</html>
