package connectPool;

import java.sql.*;

public class TestSingle {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/teaching?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";

        String USER = "root";
        String PASS = "123456";
        String sql="select * from student order by sno";
        long timeStart=System.currentTimeMillis();

        for(int i=0;i<50;i++){
            Class.forName(JDBC_DRIVER);
            Connection conn= DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
        }
        long timeEnd=System.currentTimeMillis();
        Long time=timeEnd-timeStart;
        System.out.println("查询5000次所用时间为："+time+"毫秒");
    }
}
