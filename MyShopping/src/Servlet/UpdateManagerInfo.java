package Servlet;

import Dao.AdminDao;
import Dao.GoodsDao;
import Javabean.Admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateManagerInfo extends HttpServlet {//修改管理员信息
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

            AdminDao adminDao=new AdminDao();
            Admin admin=new Admin();
            admin.setAdmin_id(request.getParameter("mid"));
            admin.setAdmin_name(request.getParameter("managername"));
            admin.setAdmin_pwd(request.getParameter("mpassword"));
            admin.setAdmin_level(1);
            boolean flag=adminDao.updateInfo(admin);
            if(flag==true)
            {
                response.getWriter().print("<script type='text/javascript'>alert('successful');" +
                        "window.parent.location.href='manager.jsp';</script>");
            }else {
                response.getWriter().print("<script type='text/javascript'>alert('erro');" +
                        "window.parent.location.href='manager.jsp';</script>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
