package Dao;


import Javabean.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private SqlHelper sqlHelper;
    private User result;
    public UserDao() throws SQLException, ClassNotFoundException {
        sqlHelper=new SqlHelper();
        result = new User();
    }

    public boolean registe(User user) throws SQLException {//注册
        boolean flag=false;
        String sql="insert into userinfo values(?,?,?)";
        String[] para={user.getUser_id(),user.getUser_name(),user.getUser_pwd()};
        if(sqlHelper.update(sql,para))
            flag=true;
        return flag;

    }
    public User login(User user) throws SQLException {//登录

        String sql="select * from userinfo where user_id=?";
        String[] para={user.getUser_id()};
        ResultSet resultSet=sqlHelper.query(sql,para);
        while(resultSet.next()){
            result.setUser_id(resultSet.getString(1));
            result.setUser_name(resultSet.getString(2));
            result.setUser_pwd(resultSet.getString(3));
        }
        return result;
    }
    public boolean updateInfo(User user) throws SQLException {
        boolean flag=false;
        String sql="update userinfo set user_name=?,user_pwd=? where user_id=?";
        String[] para={user.getUser_name(),user.getUser_pwd(),user.getUser_id()};
        if(sqlHelper.update(sql,para))
            flag=true;
        return flag;
    }
    public User getInfoById(String id) throws SQLException {

        String sql="select * from userinfo where user_id=?";
        String[] para={id};
        ResultSet resultSet=sqlHelper.query(sql,para);
        while(resultSet.next()){
            result.setUser_id(resultSet.getString(1));
            result.setUser_name(resultSet.getString(2));
            result.setUser_pwd(resultSet.getString(3));
        }
        return result;
    }
    /*public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao=new UserDao();
        User user=new User();
        user.setUser_id("009");
        user.setUser_name("zamg");
        user.setUser_pwd("123456");
        boolean flag=userDao.registe(user);
        System.out.println("userDao.login(user).getUser_name()");
        System.out.println(userDao.login(user).getUser_name());

    }*/
}
