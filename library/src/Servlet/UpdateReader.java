package Servlet;

import Dao.ReaderDao;
import JavaBean.Reader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class UpdateReader extends HttpServlet {//管理员修改读者信息
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
        String name=request.getParameter("up_reader_name");
        String type=request.getParameter("up_reader_type");//要转换
        String dep=request.getParameter("up_reader_dep");
        String tel=request.getParameter("up_reader_tel");
        String mail=request.getParameter("up_reader_mail");
        String photo=request.getParameter("up_reader_photo");
        String pwd=request.getParameter("up_reader_pwd");
        try {
            ReaderDao readerDao=new ReaderDao();
            Reader reader=new Reader();
            reader.setRdID(id);
            reader.setRdName(name);
            reader.setRdType(readerDao.typeTocode(type));
            reader.setRdDept(dep);
            reader.setRdPhone(tel);
            reader.setRdEmail(mail);
            reader.setRdPhoto(photo);
            reader.setRdPwd(pwd);
            if(readerDao.update(reader)) {
                response.getWriter().print("<script type='text/javascript'>alert('successful');window.parent.location.href='readerManage.jsp';</script>");
            }else{
                response.getWriter().print("<script type='text/javascript'>alert('error!');" +
                        "window.parent.location.href='readerManage.jsp';</script>");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

   }
