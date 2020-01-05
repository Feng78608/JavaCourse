package Servlet;

import Dao.CarDao;
import Dao.GoodsDao;
import Javabean.Goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class Index extends HttpServlet {//加购物车
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        /*response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");*/
        int num;
        String tempNum=request.getParameter("num");
        if(tempNum.equals(""))
            num=1;
        else
            num = Integer.parseInt(tempNum);
        String gId = request.getParameter("id");
        String uId = request.getParameter("uid");//有问题

        //然后把指定的uId的iId的数量设为num
        //根据id在数据库中查询哪个item

        try {
            /*GoodsDao goodsDao= new GoodsDao();
            *//*Goods goods=goodsDao.getGoodById(gId);*/
            CarDao carDao=new CarDao();
            boolean flag=carDao.addToDb(gId,uId,num);
            if(flag==true)
            {
                response.getWriter().print("<script type='text/javascript'>alert('successful');" +
                        "window.parent.location.href='index.jsp';</script>");
            }else {
                response.getWriter().print("<script type='text/javascript'>alert('erro');" +
                        "window.parent.location.href='index.jsp';</script>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
