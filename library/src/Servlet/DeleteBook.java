package Servlet;

import Dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteBook extends HttpServlet {//管理员删除图书DeleteBook
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
        try {
           BookDao bookDao=new BookDao();
            if(bookDao.deleteById(id)) {
                response.getWriter().print("<script type='text/javascript'>alert('successful');window.parent.location.href='booksManage.jsp';</script>");
            }else{
                response.getWriter().print("<script type='text/javascript'>alert('error!');" +
                        "window.parent.location.href='booksManage.jsp';</script>");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

   }
