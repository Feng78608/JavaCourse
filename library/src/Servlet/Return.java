package Servlet;

import Dao.BorrowDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class Return extends HttpServlet {//还书
    private static final long serialVersionUID = 324345345;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String test=request.getParameter("borrowid");
        float borrowId=Float.parseFloat(test);

        try {
            BorrowDao borrowDao=new BorrowDao();
            if(borrowDao.returnBook(borrowId)) {
                response.getWriter().print("<script type='text/javascript'>alert('successful');window.parent.location.href='myBooks.jsp';</script>");
            }else{
                response.getWriter().print("<script type='text/javascript'>alert('error!');" +
                        "window.parent.location.href='myBooks.jsp';</script>");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

   }
