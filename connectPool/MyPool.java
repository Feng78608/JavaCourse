package connectPool;

import javax.swing.*;
import java.sql.*;
import java.util.*;

public class MyPool {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/teaching?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";

    static final String USER = "root";
    static final String PASS = "123456";
    private  Connection conn=null;
    private  List<Connection> pool=new ArrayList<>();
    public  void  bulidPool(int number) throws ClassNotFoundException, SQLException {
        for(int i=0;i<number;i++){
            Class.forName(JDBC_DRIVER);
            conn=DriverManager.getConnection(DB_URL,USER,PASS);
            pool.add(conn);
        }
    }
    public synchronized Connection getConn(){
        if(pool.size()>0)
            return pool.remove(0);
        else{
            System.out.println("服务器正忙");
            return null;
        }
    }
    public void closeConn(Connection conn){
        if(conn!=null)
            pool.add(conn);
    }
}
