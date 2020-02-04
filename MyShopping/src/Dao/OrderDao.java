package Dao;

import Javabean.Goods;
import Javabean.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private SqlHelper sqlHelper;
    private List<Order> order;
    public OrderDao() throws SQLException, ClassNotFoundException {
        sqlHelper=new SqlHelper();
        order=new ArrayList<Order>();
        String sql="select * from orderinfo where 1=?";
        String[] para={"1"};
        ResultSet rs=sqlHelper.query(sql,para);
        while (rs.next()){
            Order temp=new Order();
            temp.setOrder_id(rs.getInt(1));
            temp.setUser_id(rs.getString(2));
            temp.setGood_id(rs.getString(3));
            temp.setGood_num(rs.getInt(4));
            order.add(temp);
        }
    }
    public boolean addToDb(String gId,String uId,int oId,int num) throws SQLException, ClassNotFoundException {
        boolean flag=false;
        String sql;
        String[] para;
        if(getOrderById(oId).getGood_id()!=null){
            sql="update  orderinfo set good_num+=? where order_id=?";
            para= new String[]{String.valueOf(num),gId,uId};
        }else {
            sql="insert into orderinfo (order_id,user_id,good_id,good_num) values(?,?,?,?)";
            para= new String[]{String.valueOf(oId),uId, gId, String.valueOf(num)};
        }
        if(sqlHelper.update(sql,para))
            flag=true;
        return flag;
    }
    public Order getOrderById(int oId) throws SQLException {
        Order result = new Order();
        String sql="select * from orderinfo where order_id=?";
        String[] para={String.valueOf(oId)};
        ResultSet temp =sqlHelper.query(sql,para);
        if(temp.next()){
            result.setOrder_id(temp.getInt(1));
            result.setUser_id(temp.getString(2));
            result.setGood_id(temp.getString(3));
            result.setGood_num(temp.getInt(4));
        }

        return result;

    }
    public List<Order> getOrder(){return order;}
}
