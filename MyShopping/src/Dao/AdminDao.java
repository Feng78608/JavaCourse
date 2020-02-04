package Dao;

import Javabean.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
    private SqlHelper sqlHelper;
    private Admin result;
    public AdminDao() throws SQLException, ClassNotFoundException {
        sqlHelper=new SqlHelper();
        result = new Admin();
    }

    public boolean registe(Admin admin) throws SQLException {//注册
        boolean flag=false;
        String sql="insert into admininfo values(?,?,?,1)";
        String[] para={admin.getAmin_id(),admin.getAdmin_name(),admin.getAdmin_pwd()};
        if(sqlHelper.update(sql,para))
            flag=true;
        return flag;

    }
    public Admin login(Admin admin) throws SQLException {//登录
        String sql="select * from admininfo where admin_id=? and admin_pwd=?";
        String[] para={admin.getAmin_id(),admin.getAdmin_pwd()};
        ResultSet resultSet=sqlHelper.query(sql,para);
        while(resultSet.next()){
            result.setAdmin_id(resultSet.getString(1));
            result.setAdmin_name(resultSet.getString(2));
            result.setAdmin_pwd(resultSet.getString(3));
            result.setAdmin_level(resultSet.getInt(4));
        }
        return result;
    }
    public Admin getInfoById(String id) throws SQLException {

        String sql="select * from admininfo where admin_id=?";
        String[] para={id};
        ResultSet resultSet=sqlHelper.query(sql,para);
        while(resultSet.next()){
            result.setAdmin_id(resultSet.getString(1));
            result.setAdmin_name(resultSet.getString(2));
            result.setAdmin_pwd(resultSet.getString(3));
            result.setAdmin_level(resultSet.getInt(4));
        }
        return result;
    }
    public boolean updateInfo(Admin admin) throws SQLException {
        boolean flag=false;
        String sql="update admininfo set admin_name=?,admin_pwd=? where admin_id=?";
        String[] para={admin.getAdmin_name(),admin.getAdmin_pwd(),admin.getAmin_id()};
        if(sqlHelper.update(sql,para))
            flag=true;
        return flag;
    }
   /* public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AdminDao userDao=new AdminDao();
        Admin user=new Admin();
        user.setAdmin_id("001");
        user.setAdmin_name("zamg");
        user.setAdmin_pwd("123456");
        user.setAdmin_level(1);
        if(userDao.updateInfo(user))
            System.out.println("cheng");
        *//*boolean flag=userDao.registe(user);
        System.out.println("userDao.login(user).getUser_name()");
        System.out.println(userDao.login(user).getAdmin_name());
        System.out.println(userDao.getInfoById("011").getAdmin_name());*//*
    }*/
}
