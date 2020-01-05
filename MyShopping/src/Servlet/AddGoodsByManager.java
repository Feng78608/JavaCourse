package Servlet;

import Dao.CarDao;
import Dao.GoodsDao;
import Javabean.Goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddGoodsByManager extends HttpServlet {//加商品
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        /*response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");*/
        Goods good=new Goods();
        good.setGood_brief(request.getParameter("good_breif"));
        good.setGood_stock(Integer.parseInt(request.getParameter("good_stock")));
        good.setGood_price(Float.parseFloat(request.getParameter("good_price")));
        good.setGood_name(request.getParameter("good_name"));
        good.setGood_id(request.getParameter("good_id"));
        good.setGood_picture(request.getParameter("good_picture"));


        try {

            GoodsDao goodsDao=new GoodsDao();
            boolean flag=goodsDao.addToDb(good);
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
