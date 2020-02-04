package Dao;

import Javabean.Car;
import Javabean.Goods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDao {
    private SqlHelper sqlHelper;
    private Car result;
    public List<Car> cars;
    public CarDao() throws SQLException, ClassNotFoundException {
        sqlHelper=new SqlHelper();
        result=new Car();
        cars=new ArrayList<Car>();
        String sql="select * from carinfo where 1=?";
        String[] para={"1"};
        ResultSet temp=sqlHelper.query(sql,para);
        while (temp.next()){
            Car tempcar=new Car();
            tempcar.setUser_id(temp.getString(1));
            tempcar.setGood_id(temp.getString(2));
            tempcar.setGood_price(temp.getFloat(3));
            tempcar.setGood_num(temp.getInt(4));
            tempcar.setGood_picture(temp.getString(5));
            tempcar.setGood_name(temp.getString(6));
            cars.add(tempcar);
        }
    }
    public boolean addToDb(String gId,String uId,int num) throws SQLException, ClassNotFoundException {
        boolean flag=false;
        GoodsDao goodsDao=new GoodsDao();
        Goods good=goodsDao.getGoodById(gId);
        String sql;
        String[] para;
        if(getCarById(gId, uId).getGood_id()!=null){
            sql="update  carinfo set good_num+=? where good_id=? and user_id=?";
            para= new String[]{String.valueOf(num),gId,uId};
        }else {
            sql="insert into carinfo values(?,?,?,?,?,?)";
            para= new String[]{uId, gId, String.valueOf(good.getGood_price()), String.valueOf(num), good.getGood_picture(),good.getGood_name()};
        }
        if(sqlHelper.update(sql,para))
            flag=true;
        return flag;
    }
    public boolean upCar(String gId,String uId,int num) throws SQLException, ClassNotFoundException {
        boolean flag=false;
        GoodsDao goodsDao=new GoodsDao();
        Goods good=goodsDao.getGoodById(gId);
        String sql = null;
        String[] para = new String[0];
        if(getCarById(gId, uId).getGood_id()!=null){
            sql="update  carinfo set good_num=? where good_id=? and user_id=?";
            para= new String[]{String.valueOf(num),gId,uId};
        }
        if(sqlHelper.update(sql,para))
            flag=true;
        return flag;
    }
    public Car getCarById(String gId,String uId) throws SQLException {
        String sql="select * from carinfo where good_id=? and user_id=?";
        String[] para={gId,uId};
        ResultSet temp =sqlHelper.query(sql,para);
        if(temp.next()){
            result.setUser_id(temp.getString(1));
            result.setGood_id(temp.getString(2));
            result.setGood_price(temp.getFloat(3));
            result.setGood_num(temp.getInt(4));
            result.setGood_picture(temp.getString(5));
            result.setGood_name(temp.getString(6));
       }

        return result;
    }
    public boolean deleteById(String gId,String uId) throws SQLException {
        boolean flag=false;
        String sql="delete carinfo where good_id=? and user_id=?";
        String[] para={gId,uId};
        if(sqlHelper.update(sql,para))
            flag=true;
        return flag;
    }

    /*public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CarDao carDao=new CarDao();
        if(carDao.deleteById("002","001"))
            System.out.println("cheng");
    }*/
}
