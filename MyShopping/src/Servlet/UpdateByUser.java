package Servlet;

import Dao.CarDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateByUser extends HttpServlet {
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
        String uId = request.getParameter("uid");
        int num;
        String tempNum=request.getParameter("up_good_stock");
        if(tempNum.equals(""))
            num=1;
        else
            num = Integer.parseInt(tempNum);

        try {

            CarDao carDao = new CarDao();
            boolean flag = carDao.upCar(gId,uId,num);
            if (flag == true) {
                response.getWriter().print("<script type='text/javascript'>alert('successful');" +
                        "window.parent.location.href='car.jsp';</script>");
            } else {
                response.getWriter().print("<script type='text/javascript'>alert('erro');" +
                        "window.parent.location.href='car.jsp';</script>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
