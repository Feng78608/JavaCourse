package databaseNew;

import java.sql.*;
import java.util.Scanner;

public class NewBase {




    static final String JDBC_DRIVER_SERVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String DB_URL_SERVER ="jdbc:sqlserver://localhost:1433;DatabaseName=teaching";
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/teaching?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";



    // 数据库的用户名与密码
    static final String USER = "root";
    static final String USER_SERVER = "sa";
    static final String PASS = "123456";
    public static void main(String [] args) throws SQLException {
        System.out.println("*请选择要连接的数据库*");
        System.out.println("1.SQLServer\t2.M2ySQL");
        System.out.println("********************");
        Connection conn = null;
        Statement stmt = null;
        int flag;
        Scanner scanner = new Scanner(System.in);
        flag = scanner.nextInt();
        try {
            // 注册 JDBC 驱动
            switch (flag){
                case 1:
                    Class.forName(JDBC_DRIVER_SERVER);

                    // 打开链接
                    System.out.println("连接数据库...");
                    conn = DriverManager.getConnection(DB_URL_SERVER,USER_SERVER,PASS);
                    break;
                case 2:
                    Class.forName(JDBC_DRIVER);

                    // 打开链接
                    System.out.println("连接数据库...");
                    conn = DriverManager.getConnection(DB_URL,USER,PASS);
                    break;
            }

            System.out.println("连接数据库成功");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("连接数据库失败");
        }
        String sql = "select * from student order by sno";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {

            pstmt = (PreparedStatement) conn.prepareStatement(sql);

            rs = (ResultSet) pstmt.executeQuery();//产生单个结果集

            while (rs.next()){//提取结果

                //int sno = rs.getInt("sno");
                String sNo=rs.getString("sno");
                String sName = rs.getString("sname");
                System.out.println(sNo+' '+sName);


            }

        } catch (SQLException e) {

            // TODO: handle exception

            e.printStackTrace();

        }finally{

            pstmt.close();

            conn.close();		//必须关闭

        }



    }

}
