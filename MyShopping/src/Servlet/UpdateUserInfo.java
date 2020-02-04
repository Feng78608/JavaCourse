package Servlet;

import Dao.AdminDao;
import Dao.UserDao;
import Javabean.Admin;
import Javabean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateUserInfo extends HttpServlet {//修改用户信息
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        /*response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");*/



        try {

            UserDao userDao=new UserDao();
            User user=new User();
            user.setUser_id(request.getParameter("uid"));
            user.setUser_name(request.getParameter("uname"));
            user.setUser_pwd(request.getParameter("upassword"));
            boolean flag=userDao.updateInfo(user);
            if(flag==true)
            {
                response.getWriter().print("<script type='text/javascript'>alert('successful');" +
                        "window.parent.location.href='user.jsp';</script>");
            }else {
                response.getWriter().print("<script type='text/javascript'>alert('erro');" +
                        "window.parent.location.href='user.jsp';</script>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
