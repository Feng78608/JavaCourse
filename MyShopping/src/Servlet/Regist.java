package Servlet;


import Dao.SqlHelper;
import Dao.UserDao;
import Javabean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class Regist extends HttpServlet {
    private static final long serialVersionUID = 326755345;
    public Regist(){

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        //用来注册用户  对数据库进行增加
        doPost(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub


        /*response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");*/
        String id =request.getParameter("rg_userid");
        String pwd = request.getParameter("rg_password");
        String name = request.getParameter("rg_username");

        //System.out.println(id+pwd+name);
        HttpSession session=request.getSession();
        User user=new User();
        user.setUser_pwd(pwd);
        user.setUser_name(name);
        user.setUser_id(id);
        try {
            UserDao userDao=new UserDao();
            if(userDao.registe(user)){
                JOptionPane.showMessageDialog(null, "successful");
                session.setAttribute("userId",id);
                response.sendRedirect("index.jsp");
            }else
            {
                JOptionPane.showMessageDialog(null, "erro");
                response.sendRedirect("index.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
