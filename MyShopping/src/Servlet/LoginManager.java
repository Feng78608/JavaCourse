package Servlet;

import Dao.AdminDao;
import Dao.UserDao;
import Javabean.Admin;
import Javabean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class LoginManager extends HttpServlet {
    private static final long serialVersionUID = 324345345;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");*/
        HttpSession session=request.getSession();
        String id=request.getParameter("lo_userid");
        String username=request.getParameter("lo_username");
        String userpsd=request.getParameter("lo_password");
        Admin admin=new Admin();
        admin.setAdmin_id(id);
        admin.setAdmin_name(username);
        admin.setAdmin_pwd(userpsd);
        try {
            AdminDao adminDao=new  AdminDao();
            Admin temp=adminDao.login(admin);
            if(!temp.getAdmin_name().equals(username))
                response.getWriter().print("<script type='text/javascript'>alert(' name erro');" +
                        "window.parent.location.href='login.jsp';</script>");
            if(temp.getAdmin_pwd().equals(userpsd)) {
                session.setAttribute("managerId",id);
                response.getWriter().print("<script type='text/javascript'>alert('successful');" +
                        "window.parent.location.href='addGoods.jsp';</script>");
            }else{
                response.getWriter().print("<script type='text/javascript'>alert('password erro');" +
                        "window.parent.location.href='login.jsp';</script>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

   }
