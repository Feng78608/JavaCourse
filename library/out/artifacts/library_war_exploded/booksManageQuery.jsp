
<%@ page import="java.sql.SQLException" %>
<%@ page import="Dao.BookDao" %>
<%@ page import="JavaBean.Book" %><%--
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
    <title>BooksManage</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  <body style="background-image: url(css/images/bg1.jpg)">
  <!-- --------------------页眉板块-------------------- -->
  <div class="header">
    <!-- 设置logo -->
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
          <ul>
              <li><a href="index.jsp" style="color: #F5F5F5">主页</a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <a href="out" style="color: #F5F5F5">退出登录</a>
          </ul>
      </div>
    <!-- 设置管理员登录 -->
   <%if(session.getAttribute("managerId")==null){%>

    <div class="auth">
      <ul>
        <li><a href="managerlogin.jsp" style="color: #F5F5F5">管理员登录</a></li>
      </ul>
    </div>
     <% }else{%>
      <div class="auth">
          <ul>
              <li><a href="manager.jsp" style="color: #F5F5F5">管理员：<%=session.getAttribute("managerId")%></a></li>
              <li><a href="booksManage.jsp" style="color: #F5F5F5">图书管理</a></li>
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


          <%int mId=0;
              if((session.getAttribute("managerId")!=null)&&((int)session.getAttribute("managerId")!=0))
                  mId=(int)session.getAttribute("managerId");
              request.getSession().setAttribute("mid",mId);
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


        <li style="height: 870px">
            <form method="post" action="updateBook">
          <img src="css/images/<%=picture%>" style="width: 361px;height: 240px" class="img_li">

              <div class="info">
                  <p >
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">书籍ID:<%=book.getBkID()%></label>
                  </p>
                  <p>
                      <label class="label_input">书码</label>
                      <input type="text" id="up_book_code" name="up_book_code" value="<%=book.getBkCode()%>" class="text"/>
                  </p>
                  <p>
                      <label class="label_input">书籍封面</label>
                      <input type="text" id="up_book_cover" name="up_book_cover" value="<%=picture%>" class="text"/>
                  </p>
                  <p>
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">书名:<%=book.getBkName()%></label>
                  </p>
                  <p>
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">作者:<%=book.getBkAuthor()%></label>
                  </p>
                  <p>
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">出版社:<%=book.getBkPress()%></label>
                  </p>
                  <p>
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">出版时间:<%=book.getBkDatePress()%></label>
                  </p>
                  <p>
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">ISBN:<%=book.getBkISBN()%></label>
                  </p>
                  <p>
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">语言:<%=bookDao.codeToLan(book.getBkLanguage())%></label>
                  </p>
                  <p>
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">书籍页数:<%=book.getBkPages()%></label>
                  </p>
                  <p>
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">入馆时间:<%=book.getBkDateIn()%></label>
                  </p>
                <p>
                    <label class="label_input">书籍简介</label>
                    <input type="text" id="up_book_breif" name="up_book_breif" value="<%=book.getBkBrief()%>" class="text"/>
                </p>
                  <p>
                      <label class="label_input">状态</label>
                      <input type="text" id="up_book_status" name="up_book_status" value="<%=book.getBkStatus()%>" class="text"/>
                  </p>
                  <p>
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">书籍分类号:<%=book.getBkCatalog()%></label>
                  </p>
              <!-- 价格 -->
                <p>
                    <label class="label_input">书籍价格</label>
                    <input type="text" id="up_book_price" name="up_book_price" value="<%=book.getBkPrice()%>" class="text"/>
                </p>
             <%-- 库存数量--%>
              <input type = "hidden" name = "mid" value = "<%=mId%>"/>
              <input type = "hidden" name = "id" value = "<%=book.getBkID()%>"/>
              <!-- 修改按钮 -->
              <div class="login_control">
                      <input type="submit" class="buttton" value="修改" />
              </div>
          </div>
        </form>
            <%--删除按钮--%>
            <div class="login_control">
            <form action="deleteBook" method="post">
                <input type = "hidden" name = "id" value = "<%=book.getBkID()%>"/>
                <input type="submit" id="sub_login" value="删除该商品"/>
            </form>
            </div>
        </li>


          <%j++; }}%>

      </ul>
    </div>

</div>
  <!-- --------------------页脚板块-------------------- -->
  <div class="footer">
    <p class="p2">造烛求明，读书求理© 2019 POWERED BY <span>WanKcn</span></p>
  </div>
  </body>
</html>
