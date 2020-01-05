package Servlet;

import Dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class Buy extends HttpServlet {
    private static final long serialVersionUID = 324345345;
    private static int oId=1;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");/*商品id*/
        String uid=request.getParameter("uid");
        int num;
        String tempNum=request.getParameter("buy_num");
        if(tempNum==null)
            num=1;
        else
            num = Integer.parseInt(tempNum);
        try {
            OrderDao orderDao=new OrderDao();
            if(orderDao.addToDb(id,uid,oId,num)){
                oId++;
                response.getWriter().print("<script type='text/javascript'>alert('successful');" +
                        "window.parent.location.href='car.jsp';</script>");
            }
            else
                response.getWriter().print("<script type='text/javascript'>alert('error');" +
                        "window.parent.location.href='car.jsp';</script>");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

   }
