package Servlet;

import Dao.BookDao;
import Dao.BorrowDao;
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

public class AddBook extends HttpServlet {//管理员添加书进图书馆
    private static final long serialVersionUID = 324345345;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("book_id"));
        String code=request.getParameter("book_code");
        String name=request.getParameter("book_name");
        String author=request.getParameter("book_author");
        String press=request.getParameter("book_press");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String ISBN=request.getParameter("book_ISBN");
        String lan=request.getParameter("book_language");
        int pages=Integer.parseInt(request.getParameter("book_pages"));
        float price=Float.parseFloat(request.getParameter("book_price"));
        String brief=request.getParameter("book_breif");
        String cover=request.getParameter("book_cover");
        String catalog=request.getParameter("book_catalog");//分类号
        try {
            Date datePress=sdf.parse(request.getParameter("book_press_date"));
            Book book=new Book();
            BookDao bookDao=new BookDao();
            if(bookDao.getAllById(id).getBkID()==0){
            book.setBkID(id);
            book.setBkCode(code);
            book.setBkName(name);
            book.setBkCatalog(catalog);
            book.setBkStatus("在馆");
            book.setBkCover(cover);
            book.setBkPrice(price);
            book.setBkPages(pages);
            book.setBkLanguage(bookDao.lanTocode(lan));
            book.setBkISBN(ISBN);
            book.setBkPress(press);
            book.setBkAuthor(author);
            book.setBkBrief(brief);
            book.setBkDateIn(new Timestamp(new Date().getTime()));
            book.setBkDatePress(new Timestamp(datePress.getTime()));
            if(bookDao.addToDB(book)) {
                response.getWriter().print("<script type='text/javascript'>alert('successful');" +
                        "window.parent.location.href='booksManage.jsp';</script>");
            }else{
                response.getWriter().print("<script type='text/javascript'>alert('error!');" +
                        "window.parent.location.href='booksManage.jsp';</script>");
            }
            }else
                response.getWriter().print("<script type='text/javascript'>alert('the book already exits!');" +
                        "window.parent.location.href='booksManage.jsp';</script>");
        } catch (SQLException | ClassNotFoundException | ParseException e) {
            e.printStackTrace();
        }
    }

   }
