package Servlet;

import Dao.ReaderDao;
import JavaBean.Reader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateRole extends HttpServlet {//管理员修改读者权限
    private static final long serialVersionUID = 324345345;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String pwd=request.getParameter("up_reader_pwd");
        String role=request.getParameter("up_reader_role");
        try {
            ReaderDao readerDao=new ReaderDao();
            Reader reader=new Reader();
            reader.setRdID(id);
            reader.setRdAdminRoles(readerDao.roleTocode(role));
            reader.setRdPwd(pwd);
            if(readerDao.upRole(reader)) {
                response.getWriter().print("<script type='text/javascript'>alert('successful');window.parent.location.href='systemManage.jsp';</script>");
            }else{
                response.getWriter().print("<script type='text/javascript'>alert('error!');" +
                        "window.parent.location.href='systemManage.jsp';</script>");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

   }
