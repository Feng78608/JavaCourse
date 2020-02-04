package Servlet;

import Dao.BookDao;
import Dao.BorrowDao;
import Dao.ReaderDao;
import Dao.ReaderTypeDao;
import JavaBean.Book;

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

public class Borrow extends HttpServlet {//借书籍
    private static final long serialVersionUID = 324345345;
    private static float borrowId=1;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        int bookId=Integer.parseInt(request.getParameter("id"));
        int uId=Integer.parseInt(request.getParameter("uid"));
        int bookCount=0;//该读者现在借了几本书
        try {
            if(!request.getParameter("uid").equals("0")) {//读者应该登录
                BorrowDao borrowDao = new BorrowDao();
                ReaderDao readerDao = new ReaderDao();
                BookDao bookDao = new BookDao();
                ReaderTypeDao readerTypeDao = new ReaderTypeDao();
                if (bookDao.getAllById(bookId).getBkStatus().equals("在馆")) {

                for (int i = 0; i < borrowDao.getList().size(); i++) {
                    if (borrowDao.getList().get(i).getRdID() == uId && (borrowDao.getList().get(i).getIsHasReturn() == 0))//读者未还的书
                        bookCount++;
                }
                if (bookCount < readerTypeDao.getQtyByType(readerDao.getReaderById(uId).getRdType())) {//读者借书未还的数量未达上限
                    int num = readerTypeDao.getCanLendDayByType(readerDao.getReaderById(uId).getRdType());//获取该类型的读者一次可以借多久
                    Date date = new Date();
                    Calendar ca = Calendar.getInstance();
                    ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
                    String[] para = {String.valueOf(borrowId), String.valueOf(uId), String.valueOf(bookId), String.valueOf(0),
                            new Timestamp(date.getTime()) + "", new Timestamp(ca.getTime().getTime()) + "",
                            new Timestamp(date.getTime()) + "", String.valueOf(0), String.valueOf(0), String.valueOf(0),
                            String.valueOf(0), "", ""};
                    borrowId++;
                    if (borrowDao.borrow(para)) {
                        response.getWriter().print("<script type='text/javascript'>alert('successful');window.parent.location.href='index.jsp';</script>");
                    }
                } else
                    response.getWriter().print("<script type='text/javascript'>alert('Maximum number of books borrowed!');" +
                            "window.parent.location.href='index.jsp';</script>");
            }else
                    response.getWriter().print("<script type='text/javascript'>alert('The book is not in the library!');" +
                            "window.parent.location.href='index.jsp';</script>");
            }else{
                response.getWriter().print("<script type='text/javascript'>alert('Please login first !');" +
                        "window.parent.location.href='index.jsp';</script>");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

   }
