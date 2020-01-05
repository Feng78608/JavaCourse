package Dao;

import Javabean.Goods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class GoodsDao {
    private SqlHelper sqlHelper;
    private Goods result;
    public List<Goods> goods;

    public GoodsDao() throws SQLException, ClassNotFoundException {
        sqlHelper=new SqlHelper();
        result=new Goods();
        goods=new ArrayList<Goods>();
        String sql="select * from goodsinfo where 1=?";
        String[] para={"1"};
        ResultSet temp=sqlHelper.query(sql,para);
        while (temp.next()){
            Goods tempGoods=new Goods();
            tempGoods.setGood_id(temp.getString(1));
            tempGoods.setGood_name(temp.getString(2));
            tempGoods.setGood_price(temp.getFloat(3));
            tempGoods.setGood_picture(temp.getString(4));
            tempGoods.setGood_stock(temp.getInt(5));
            tempGoods.setGood_brief(temp.getString(6));
            goods.add(tempGoods);
        }
    }
    public Goods getGoodById(String id) throws SQLException {
        String sql="select * from goodsinfo where good_id=?";
        String[] para={id};
        ResultSet temp =sqlHelper.query(sql,para);
        if(temp.next()){
            result.setGood_id(temp.getString(1));
            result.setGood_name(temp.getString(2));
            result.setGood_price(temp.getFloat(3));
            result.setGood_picture(temp.getString(4));
            result.setGood_stock(temp.getInt(5));
            result.setGood_brief(temp.getString(6));
        }
        return result;
    }
    public boolean deleteById(String gId) throws SQLException {
        boolean flag=false;
        String sql="delete goodsinfo where good_id=?";
        String[] para={gId};
        if(sqlHelper.update(sql,para))
            flag=true;
        return flag;
    }
    public boolean addToDb(Goods good1) throws SQLException, ClassNotFoundException {
        boolean flag=false;
       /* GoodsDao goodsDao=new GoodsDao();
        Goods good=goodsDao.getGoodById(good1.getGood_id());*/
        Goods good=getGoodById(good1.getGood_id());
        String sql;
        String[] para;
        if(good.getGood_id()!=null){//因为一个空的good中有一些参数为0，所以good并不是
            sql="update  goodsinfo set good_name=?,good_price=?,good_picture=?,good_stock=?,good_brief=? where good_id=?";
            para= new String[]{good1.getGood_name(),String.valueOf(good1.getGood_price()),good1.getGood_picture(),String.valueOf(good1.getGood_stock()),good1.getGood_brief(),good1.getGood_id()};
        }else {
            sql="insert into goodsinfo values(?,?,?,?,?,?)";
            para= new String[]{good1.getGood_id(), good1.getGood_name(), String.valueOf(good1.getGood_price()),good1.getGood_picture(), String.valueOf(good1.getGood_stock()), good1.getGood_brief()};
        }
        if(sqlHelper.update(sql,para))
            flag=true;
        return flag;
    }
    /*public String getGoodsByName(String name) throws SQLException {
        String goodsId = null;
        String sql = "select good_id from goodsinfo where good_name like ?";
        String[] para = {"%" + name + "%"};
        ResultSet rs = sqlHelper.query(sql, para);
        int i = 0;
        while (rs.next()) {
            goodsId.concat(rs.getString(1));
            goodsId.concat(",");
            i++;
        }
        return goodsId;
    }*/
    /*public static void main(String[] args) throws SQLException, ClassNotFoundException {
        GoodsDao goodsDao=new GoodsDao();
        *//*for(int i=0;i<goodsDao.getGoodsByName("香水").length;i++)
        {
            System.out.println(goodsDao.getGoodsByName("香水")[i]);
        }*//*
        System.out.println(goodsDao.getGoodsByName("香水"));
        *//*Goods good=new Goods();
        for(int i = goodsDao.goods.size()-1; i>=0; i--){
            System.out.println(goodsDao.goods.get(i).getGood_name());
        }
        good.setGood_brief("施华洛世奇 耀动的心 SPARKLING DC 耀动晶彩 女项链 圣诞送礼");
        good.setGood_stock(30);
        good.setGood_price(1290);
        good.setGood_name("Swarovski/施华洛世奇项链");
        good.setGood_id("001");
        good.setGood_picture("xoanglian.png");
        if(goodsDao.addToDb(good))
            System.out.println("cheng");*//*
    }*/
}
