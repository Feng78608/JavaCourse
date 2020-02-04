package Servlet;

import Dao.ReaderDao;
import JavaBean.Reader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class UserLogin extends HttpServlet {
    private static final long serialVersionUID = 324345345;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session=request.getSession();
        int id= Integer.parseInt(request.getParameter("userid"));
        String username=request.getParameter("username");
        String userpsd=request.getParameter("password");

        try {
            ReaderDao readerDao=new ReaderDao();
            Reader temp= readerDao.getReaderById(id);
            if(!temp.getRdName().equals(username))
                response.getWriter().print("<script type='text/javascript'>alert('username error');" +
                        "window.parent.location.href='userlogin.jsp';</script>");
            if(temp.getRdPwd().equals(userpsd)) {
                session.setAttribute("userId",id);
                session.setAttribute("managerId",0);
                response.getWriter().print("<script type='text/javascript'>window.parent.location.href='index.jsp';</script>");
            }else{
                response.getWriter().print("<script type='text/javascript'>alert('password erro');" +
                        "window.parent.location.href='login.jsp';</script>");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

   }
