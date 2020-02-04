package Servlet;

import Dao.CarDao;
import Dao.GoodsDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteByManager extends HttpServlet {//管理员删商品
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        /*response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");*/
        String gId = request.getParameter("id");


        try {
            GoodsDao goodsDao=new GoodsDao();
            boolean flag=goodsDao.deleteById(gId);
            if(flag==true)
            {
                response.getWriter().print("<script type='text/javascript'>alert('successful');" +
                        "window.parent.location.href='addGoods.jsp';</script>");
            }else {
                response.getWriter().print("<script type='text/javascript'>alert('erro');" +
                        "window.parent.location.href='addGoods.jsp';</script>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
