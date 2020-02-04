package Servlet;

import Dao.BookDao;
import JavaBean.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateBook extends HttpServlet {//管理员修改图书信息UpdateBook
    private static final long serialVersionUID = 324345345;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*int id=Integer.parseInt(request.getParameter("id"));
        String code=request.getParameter("book_code");
        float price=Float.parseFloat(request.getParameter("book_price"));
        String brief=request.getParameter("book_breif");
        String cover=request.getParameter("book_cover");
        String status=request.getParameter("up_good_picture");
        String[] para={code,String.valueOf(price),brief,cover,status,String.valueOf(id)};*/
        try {
           BookDao bookDao=new BookDao();
           Book book=new Book();
           book.setBkID(Integer.parseInt(request.getParameter("id")));
           book.setBkCode(request.getParameter("up_book_code"));
           book.setBkPrice(Float.parseFloat(request.getParameter("up_book_price")));
           book.setBkBrief(request.getParameter("up_book_breif"));
           book.setBkCover(request.getParameter("up_book_cover"));
           book.setBkStatus(request.getParameter("up_book_status"));
            if(bookDao.update(book)) {
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
