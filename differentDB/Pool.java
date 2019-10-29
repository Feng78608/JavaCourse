package differentDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Pool {
    private JdbcUrl jdbc;
    private Connection conn=null;
    private List<Connection> list=new ArrayList<>();

    public void setJdbcUrl(JdbcUrl jdbc){
        this.jdbc=jdbc;
    }
    public void buildPool(int number) throws ClassNotFoundException, SQLException {
        String[] temp=jdbc.getJdbcDri_Url().split(" ");
        if(jdbc.getDBType().trim().toUpperCase().equals("ORACLE")){
            for(int i=0;i<number;i++) {
                Class.forName(temp[0]);
                // 一个是缓存取到的记录数，一个是设置默认的批量提交数
                Properties props = new Properties();
                props.setProperty("user", jdbc.getUserName());
                props.setProperty("password", jdbc.getPassWord());
                props.setProperty("defaultRowPrefetch", "50");
                props.setProperty("defaultExecuteBatch", "50");
                conn = DriverManager.getConnection(temp[1], props);
                list.add(conn);
            }
        }else if(jdbc.getDBType().trim().toUpperCase().equals("MYSQL")||jdbc.getDBType().trim().toUpperCase().equals("DB2")||jdbc.getDBType().trim().toUpperCase().equals("SQLSERVER")){
            for(int i=0;i<number;i++){
                Class.forName(temp[0]);
                conn=DriverManager.getConnection(temp[1],jdbc.getUserName(),jdbc.getPassWord());
                list.add(conn);
            }
        }else
            System.out.println("没有匹配到相应数据库");

    }
    public synchronized Connection getConn(){
        if(list.size()>0)
        {

            // System.out.println("正在连接"+pool+"连接池里还有"+pool.size()+"个");
            return list.remove(0);
        }
        else{
            System.out.println("服务器正忙");
            return null;
        }
    }
    public void closeConn(Connection conn){
        if(conn!=null)
            list.add(conn);
    }
}
