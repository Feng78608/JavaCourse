
<%@ page import="java.sql.SQLException" %>
<%@ page import="Dao.BookDao" %><%--
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
                  <input type = "hidden" name = "mid" value = "<%=(int)session.getAttribute("managerId")%>"/>
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
          <li style="height: 470px">
              <form method="post" action="addBook">
                  <%--<img src="css/images/<%=picture%>" style="width: 361px;height: 240px" class="img_li">--%>
                  <p>
                      <label class="label_input">书籍ID</label>
                      <input type="text" id="book_id" name="book_id" class="text"/>
                  </p>
                      <p>
                          <label class="label_input">书号</label>
                          <input type="text" id="book_code" name="book_code" class="text"/>
                      </p>
                  <p>
                      <label class="label_input">书籍封面</label>
                      <input type="text" id="book_cover" name="book_cover" class="text"/>
                  </p>
                  <p>
                      <label class="label_input">书名</label>
                      <input type="text" id="book_name" name="book_name" class="text"/>
                  </p>
                      <p>
                          <label class="label_input">作者</label>
                          <input type="text" id="book_author" name="book_author" class="text"/>
                      </p>
                      <p>
                          <label class="label_input">出版社</label>
                          <input type="text" id="book_press" name="book_press" class="text"/>
                      </p>
                      <p>
                          <label class="label_input">出版时间</label>
                          <input type="text" id="book_press_date" name="book_press_date" class="text"/>
                      </p>
                      <p>
                          <label class="label_input">ISBN</label>
                          <input type="text" id="book_ISBN" name="book_ISBN" class="text"/>
                      </p>
                      <p>
                          <label class="label_input">语言</label>
                          <input type="text" id="book_language" name="book_language" class="text"/>
                      </p>
                      <p>
                          <label class="label_input">书籍页数</label>
                          <input type="text" id="book_pages" name="book_pages" class="text"/>
                      </p>
                  <p>
                      <label class="label_input">书籍价格</label>
                      <input type="text" id="book_price" name="book_price" class="text"/>
                  </p>
                  <p>
                      <label class="label_input">商品简介</label>
                      <input type="text" id="book_breif" name="book_breif" class="text"/>
                  </p>
                      <p>
                          <label class="label_input">分类号</label>
                          <input type="text" id="book_catalog" name="book_catalog" class="text"/>
                      </p>
                  <input type="submit" class="buttton" value="添加" />
              </form>
          </li>

          <%int mId=0;
          if((session.getAttribute("managerId")!=null)&&((int)session.getAttribute("userId")!=0))
              mId=(int)session.getAttribute("managerId");
          request.getSession().setAttribute("mid",mId);
              BookDao bookDao= null;
              try {
                  bookDao = new BookDao();
              } catch (SQLException | ClassNotFoundException e) {
                  e.printStackTrace();
              }
              assert bookDao != null;
              for(int i = bookDao.getBooks().size()-1; i>=0; i--){
            String picture=bookDao.getBooks().get(i).getBkCover();
          %>


        <li style="height: 870px">
            <form method="post" action="updateBook">
          <img src="css/images/<%=picture%>" style="width: 361px;height: 240px" class="img_li">

              <div class="info">
                  <p >
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">书籍ID:<%=bookDao.getBooks().get(i).getBkID()%></label>
                  </p>
                  <p>
                      <label class="label_input">书码</label>
                      <input type="text" id="up_book_code" name="up_book_code" value="<%=bookDao.getBooks().get(i).getBkCode()%>" class="text"/>
                  </p>
                  <p>
                      <label class="label_input">书籍封面</label>
                      <input type="text" id="up_book_cover" name="up_book_cover" value="<%=picture%>" class="text"/>
                  </p>
                  <p>
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">书名:<%=bookDao.getBooks().get(i).getBkName()%></label>
                  </p>
                  <p>
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">作者:<%=bookDao.getBooks().get(i).getBkAuthor()%></label>
                  </p>
                  <p>
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">出版社:<%=bookDao.getBooks().get(i).getBkPress()%></label>
                  </p>
                  <p>
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">出版时间:<%=bookDao.getBooks().get(i).getBkDatePress()%></label>
                  </p>
                  <p>
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">ISBN:<%=bookDao.getBooks().get(i).getBkISBN()%></label>
                  </p>
                  <p>
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">语言:<%=bookDao.codeToLan(bookDao.getBooks().get(i).getBkLanguage())%></label>
                  </p>
                  <p>
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">书籍页数:<%=bookDao.getBooks().get(i).getBkPages()%></label>
                  </p>
                  <p>
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">入馆时间:<%=bookDao.getBooks().get(i).getBkDateIn()%></label>
                  </p>
                <p>
                    <label class="label_input">书籍简介</label>
                    <input type="text" id="up_book_breif" name="up_book_breif" value="<%=bookDao.getBooks().get(i).getBkBrief()%>" class="text"/>
                </p>
                  <p>
                      <label class="label_input">状态</label>
                      <input type="text" id="up_book_status" name="up_book_status" value="<%=bookDao.getBooks().get(i).getBkStatus()%>" class="text"/>
                  </p>
                  <p>
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">书籍分类号:<%=bookDao.getBooks().get(i).getBkCatalog()%></label>
                  </p>
              <!-- 价格 -->
                <p>
                    <label class="label_input">书籍价格</label>
                    <input type="text" id="up_book_price" name="up_book_price" value="<%=bookDao.getBooks().get(i).getBkPrice()%>" class="text"/>
                </p>
             <%-- 库存数量--%>
              <input type = "hidden" name = "mid" value = "<%=mId%>"/>
              <input type = "hidden" name = "id" value = "<%=bookDao.getBooks().get(i).getBkID()%>"/>
              <!-- 修改按钮 -->
              <div class="login_control">
                      <input type="submit" class="buttton" value="修改" />
              </div>
          </div>
        </form>
            <%--删除按钮--%>
            <div class="login_control">
            <form action="deleteBook" method="post">
                <input type = "hidden" name = "id" value = "<%=bookDao.getBooks().get(i).getBkID()%>"/>
                <input type="submit" id="sub_login" value="删除"/>
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
