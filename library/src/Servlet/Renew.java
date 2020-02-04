package Servlet;

import Dao.BorrowDao;
import Dao.ReaderDao;
import Dao.ReaderTypeDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Renew extends HttpServlet {//续借
    private static final long serialVersionUID = 324345345;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        float borrowId=Float.parseFloat(request.getParameter("borrowid"));
        int userId=Integer.parseInt(request.getParameter("uid"));
        try {
            BorrowDao borrowDao=new BorrowDao();
            ReaderDao readerDao=new ReaderDao();
            ReaderTypeDao readerTypeDao=new ReaderTypeDao();
            /*borrowDao.getBorrowById(borrowId).getLdContinueTimes();//borrowId的续借次数
            readerTypeDao.getTimesByReaderType(readerDao.getReaderById(userId).getRdType())//读者userId是什么类型，它的可借次数*/
            int now=borrowDao.getBorrowById(borrowId).getLdContinueTimes();
            int can=readerTypeDao.getTimesByReaderType(readerDao.getReaderById(userId).getRdType());
            if(now<can){
                if(borrowDao.renew(borrowId)) {
                    response.getWriter().print("<script type='text/javascript'>alert('successful');window.parent.location.href='myBooks.jsp';</script>");
                }else{
                    response.getWriter().print("<script type='text/javascript'>alert('error!');" +
                            "window.parent.location.href='myBooks.jsp';</script>");
                }
            }else
                response.getWriter().print("<script type='text/javascript'>alert('Current power cannot be renewed!');" +
                        "window.parent.location.href='myBooks.jsp';</script>");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

   }
