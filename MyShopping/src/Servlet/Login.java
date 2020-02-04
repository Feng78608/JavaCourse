package Servlet;

import Dao.UserDao;
import Javabean.User;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

public class Login extends HttpServlet {
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
        User user=new User();
        user.setUser_id(id);
        user.setUser_name(username);
        user.setUser_pwd(userpsd);
        try {
            UserDao userDao=new  UserDao();
            User temp=userDao.login(user);
            if(!temp.getUser_name().equals(username))
                response.getWriter().print("<script type='text/javascript'>alert('username erro');" +
                        "window.parent.location.href='login.jsp';</script>");
            if(temp.getUser_pwd().equals(userpsd)) {
                session.setAttribute("userId",id);
                response.getWriter().print("<script type='text/javascript'>alert('successful');" +
                        "window.parent.location.href='index.jsp';</script>");
            }else{
                response.getWriter().print("<script type='text/javascript'>alert('password erro');" +
                        "window.parent.location.href='login.jsp';</script>");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

   }
