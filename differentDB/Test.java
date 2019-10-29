package differentDB;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test {//测试数据在代码结尾
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        JdbcUrl url = new JdbcUrl();
        Pool pool=new Pool();
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入数据库的名称");
        url.setDBName(scanner.next());
        System.out.println("请输入数据库的类型");
        url.setDBType(scanner.next());
        System.out.println("请输入数据库的ip地址");
        url.setIP(scanner.next());
        System.out.println("请输入数据库的端口号");
        url.setPort(scanner.next());
        System.out.println("请输入数据库的用户名");
        url.setUserName(scanner.next());
        System.out.println("请输入数据库的密码");
        url.setPassWord(scanner.next());

        System.out.println("数据处理中。。。");
        pool.setJdbcUrl(url);
        pool.buildPool(9);
        String sql="select * from student order by sno";
        Connection conn;
        ResultSet resultSet=null;
        PreparedStatement statement=null;
        long timeStart=System.currentTimeMillis();
        for(int i=0;i<50000;i++){
            conn=pool.getConn();
            statement=conn.prepareStatement(sql);
            resultSet=(ResultSet)statement.executeQuery();
            /*while(resultSet.next()){
                System.out.println(resultSet.getString("sno")+"\t"+resultSet.getString("sname"));
            }*/
            pool.closeConn(conn);
        }
        long timeEnd=System.currentTimeMillis();
        System.out.println("访问"+url.getDBType()+"的时间为"+(timeEnd-timeStart)+"毫秒");
    }
  /*  teaching
      mysql
      127.0.0.1
      3306
      root
      123456*/
}
