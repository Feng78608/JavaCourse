package Servlet;

import Dao.BookDao;
import Dao.ReaderDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class QueryReader extends HttpServlet {//查询读者
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
        String name=request.getParameter("reader");/*输入的读者姓名*/

        try {
            ReaderDao readerDao=new ReaderDao();
            int[] readers;
            readers=readerDao.getIdByName(name);
            if(readers[0]!=0) {
                session.setAttribute("readers", readers);
                    response.getWriter().print("<script type='text/javascript'>window.parent.location.href='readerManageQuery.jsp';</script>");
            }else{
                response.getWriter().print("<script type='text/javascript'>alert('There is no such book in the library');" +
                        "window.parent.location.href='readerManage.jsp';</script>");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

   }
