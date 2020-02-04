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

public class ManagerLogin extends HttpServlet {
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
        int id= Integer.parseInt(request.getParameter("managerid"));
        String username=request.getParameter("managername");
        String userpsd=request.getParameter("password");

        try {
            ReaderDao readerDao=new ReaderDao();
            Reader temp= readerDao.getReaderById(id);
            if(!temp.getRdName().equals(username))
                response.getWriter().print("<script type='text/javascript'>alert('username erro');" +
                        "window.parent.location.href='userlogin.jsp';</script>");
            if(temp.getRdPwd().equals(userpsd)) {
                session.setAttribute("managerId",id);
                session.setAttribute("userId",0);
                if(temp.getRdAdminRoles()==0){
                    session.setAttribute("userId",id);
                    /*if ((session.getAttribute("managerId") == null) && (session.getAttribute("userId") == null)) {
                        System.out.println(1);
                    } else if (session.getAttribute("managerId") != null) {
                        System.out.println(2);
                    } else if (session.getAttribute("userId") != null) {
                        System.out.println(3);
                    }*/
                }

                response.getWriter().print(readerDao.jumpByRole(temp.getRdAdminRoles()));
            }else{
                response.getWriter().print("<script type='text/javascript'>alert('password erro');" +
                        "window.parent.location.href='login.jsp';</script>");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}



