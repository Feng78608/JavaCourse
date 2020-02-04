
<%@ page import="java.sql.SQLException" %>
<%@ page import="JavaBean.Reader" %>
<%@ page import="Dao.ReaderDao" %><%--
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
          <form method="post" action="queryReader">
              <p>
                  <input type="submit" class="label_input" value="查读者"/>
                  <label for="reader"><input type="text" id="reader" name="reader" class="text_field"/></label>
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
          <li style="height: 400px">
              <form method="post" action="addReader">
                  <%--<img src="css/images/<%=picture%>" style="width: 361px;height: 240px" class="img_li">--%>
                  <p>
                      <label class="label_input">读者ID</label>
                      <input type="text" id="reader_id" name="reader_id" class="text"/>
                  </p>
                      <p>
                          <label class="label_input">姓名</label>
                          <input type="text" id="reader_name" name="reader_name" class="text"/>
                      </p>
                      <p>
                          <label class="label_input">性别</label>
                          <input type="text" id="reader_sex" name="reader_sex" class="text"/>
                      </p>
                  <p>
                      <label class="label_input">类型</label>
                      <input type="text" id="reader_type" name="reader_type" class="text"/>
                  </p>
                  <p>
                      <label class="label_input">单位</label>
                      <input type="text" id="reader_dep" name="reader_dep" class="text"/>
                  </p>
                      <p>
                          <label class="label_input">联系电话</label>
                          <input type="text" id="reader_tel" name="reader_tel" class="text"/>
                      </p>
                      <p>
                          <label class="label_input">电子邮件</label>
                          <input type="text" id="reader_mail" name="reader_mail" class="text"/>
                      </p>
                      <p>
                          <label class="label_input">照片</label>
                          <input type="text" id="reader_photo" name="reader_photo" class="text"/>
                      </p>
                      <p>
                          <label class="label_input">状态</label>
                          <input type="text" id="reader_status" name="reader_status" class="text"/>
                      </p>
                      <p>
                          <label class="label_input">密码</label>
                          <input type="password" id="reader_pwd" name="reader_pwd" class="text"/>
                      </p>
                  <p>
                      <label class="label_input">管理角色</label>
                      <input type="text" id="reader_role" name="reader_role" class="text"/>
                  </p>
                  <input type="submit" class="buttton" value="添加" />
              </form>
          </li>

          <%int mId=0;
          if((session.getAttribute("managerId")!=null)&&((int)session.getAttribute("userId")!=0))
              mId=(int)session.getAttribute("managerId");
          request.getSession().setAttribute("mid",mId);
              ReaderDao readerDao= null;
              try {
                  readerDao = new ReaderDao();
              } catch (SQLException | ClassNotFoundException e) {
                  e.printStackTrace();
              }
              assert readerDao != null;
              for(int i = readerDao.getReaders().size()-1; i>=0; i--){
            String picture=readerDao.getReaders().get(i).getRdPhoto();
          %>


        <li style="height: 820px">
            <form method="post" action="updateReader">
          <img src="css/images/<%=picture%>" style="width: 361px;height: 240px" class="img_li">

              <div class="info">
                  <p>
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">读者ID:<%=readerDao.getReaders().get(i).getRdID()%></label>
                  </p>
                  <p>
                      <label class="label_input">姓名</label>
                      <input type="text" id="up_reader_name" name="up_reader_name" value="<%=readerDao.getReaders().get(i).getRdName()%>" class="text"/>
                  </p>
                  <p >
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">性别:<%=readerDao.getReaders().get(i).getRdSex()%></label>
                  </p>
                  <p>
                      <label class="label_input">读者类型</label>
                      <input type="text" id="up_reader_type" name="up_reader_type" value="<%=readerDao.codeToType(readerDao.getReaders().get(i).getRdType())%>" class="text"/>
                  </p>
                  <p>
                      <label class="label_input">读者单位</label>
                      <input type="text" id="up_reader_dep" name="up_reader_dep" value="<%=readerDao.getReaders().get(i).getRdDept()%>" class="text"/>
                  </p>
                  <p>
                      <label class="label_input">联系电话</label>
                      <input type="text" id="up_reader_tel" name="up_reader_tel" value="<%=readerDao.getReaders().get(i).getRdPhone()%>" class="text"/>
                  </p>
                  <p>
                      <label class="label_input">电子邮箱</label>
                      <input type="text" id="up_reader_mail" name="up_reader_mail" value="<%=readerDao.getReaders().get(i).getRdEmail()%>" class="text"/>
                  </p>
                  <p >
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">办证时间:<%=readerDao.getReaders().get(i).getRdDateReg()%></label>
                  </p>
                  <p>
                      <label class="label_input">照片</label>
                      <input type="text" id="up_reader_photo" name="up_reader_photo" value="<%=readerDao.getReaders().get(i).getRdPhoto()%>" class="text"/>
                  </p>
                  <p>
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">状态:<%=readerDao.getReaders().get(i).getRdStatus()%></label>
                  </p>
                  <p >
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">已借数量:<%=readerDao.getReaders().get(i).getRdBorrowQty()%></label>
                  </p>
                  <p>
                      <label class="label_input">密码</label>
                      <input type="text" id="up_reader_pwd" name="up_reader_pwd" value="<%=readerDao.getReaders().get(i).getRdPwd()%>" class="text"/>
                  </p>
                  <p>
                      <label class="label_input" style="border-top-right-radius: 5px;border-bottom-right-radius: 5px;width:270px">管理角色:<%=readerDao.codeToRole(readerDao.getReaders().get(i).getRdAdminRoles())%></label>
                  </p>
             <%-- 库存数量--%>
              <input type = "hidden" name = "mid" value = "<%=mId%>"/>
              <input type = "hidden" name = "id" value = "<%=readerDao.getReaders().get(i).getRdID()%>"/><%--读者id--%>
              <!-- 修改按钮 -->
              <div class="login_control">
                      <input type="submit" class="buttton" value="修改" />
              </div>
          </div>
        </form>
            <%--删除按钮--%>
            <div class="login_control">
            <form action="deleteReader" method="post">
                <input type = "hidden" name = "id" value = "<%=readerDao.getReaders().get(i).getRdID()%>"/><%--读者id--%>
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
