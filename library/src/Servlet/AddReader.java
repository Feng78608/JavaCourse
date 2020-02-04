package Servlet;

import Dao.BookDao;
import Dao.ReaderDao;
import JavaBean.Book;
import JavaBean.Reader;

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

public class AddReader extends HttpServlet {//管理员添加读者
    private static final long serialVersionUID = 324345345;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("reader_id"));
        String name=request.getParameter("reader_name");
        String sex=request.getParameter("reader_sex");
        String type=request.getParameter("reader_type");//要转换
        String dep=request.getParameter("reader_dep");
        String tel=request.getParameter("reader_tel");
        String mail=request.getParameter("reader_mail");
        String photo=request.getParameter("reader_photo");
        String status=request.getParameter("reader_status");
        String pwd=request.getParameter("reader_pwd");
        String role=request.getParameter("reader_role");//
        try {
            ReaderDao readerDao=new ReaderDao();
            Reader reader=new Reader();
            if(readerDao.getReaderById(id).getRdID()==0){/*添加的id不在数据库中，即不重复*/
            reader.setRdID(id);
            reader.setRdName(name);
            reader.setRdSex(sex);
            reader.setRdType(readerDao.typeTocode(type));
            reader.setRdDept(dep);
            reader.setRdPhone(tel);
            reader.setRdEmail(mail);
            reader.setRdPhoto(photo);
            reader.setRdStatus(status);
            reader.setRdPwd(pwd);
            reader.setRdAdminRoles(readerDao.roleTocode("读者"));
            reader.setRdDateReg(new Timestamp(new Date().getTime()));
            if (readerDao.addToDb(reader)) {
                if(role.equals("读者")) {/*该管理员只能添加读者*/
                    response.getWriter().print("<script type='text/javascript'>alert('successful');window.parent.location.href='readerManage.jsp';</script>");
                } else {
                    response.getWriter().print("<script type='text/javascript'>alert('You do not have power to add an administrator. The user role has been changed to a reader!');" +
                            "window.parent.location.href='readerManage.jsp';</script>");
                }
            }else
                response.getWriter().print("<script type='text/javascript'>alert('error!');" +
                        "window.parent.location.href='readerManage.jsp';</script>");
            }else
                response.getWriter().print("<script type='text/javascript'>alert('the reader already exit!');" +
                        "window.parent.location.href='readerManage.jsp';</script>");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

   }
