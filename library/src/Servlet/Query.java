package Servlet;

import Dao.BookDao;
import Dao.ReaderDao;
import JavaBean.Book;
import JavaBean.Reader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Query extends HttpServlet {//查询书籍
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
        String book=request.getParameter("book");

        try {
            BookDao bookDao=new BookDao();
            ReaderDao readerDao=new ReaderDao();
            int[] books;
            books=bookDao.getBooksByName(book);
            if(books[0]!=0) {
                session.setAttribute("books", books);
                if((request.getParameter("mid")!=null)&&readerDao.getReaderById(Integer.parseInt(request.getParameter("mid"))).getRdAdminRoles()==2){//是图书管理员登录的话
                    response.getWriter().print("<script type='text/javascript'>window.parent.location.href='booksManageQuery.jsp';</script>");
                }else
                    response.getWriter().print("<script type='text/javascript'>window.parent.location.href='query.jsp';</script>");
            }else{
                response.getWriter().print("<script type='text/javascript'>alert('There is no such book in the library');" +
                        "window.parent.location.href='index.jsp';</script>");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

   }
