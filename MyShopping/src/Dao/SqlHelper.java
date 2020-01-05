package Dao;

import java.sql.*;

public class SqlHelper{
    private String sqlserverDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String sqlserverUrl="jdbc:sqlserver://localhost:1433;DatabaseName=shopping";
    private String user="sa";
    private String pwd="123456";
    private Connection conn=null;
    private PreparedStatement ps=null;
    private ResultSet rs;
    public SqlHelper() throws ClassNotFoundException, SQLException {
        Class.forName(sqlserverDriver);
        conn= DriverManager.getConnection(sqlserverUrl,user,pwd);
    }
    public boolean update(String sql,String[] para) throws SQLException {//para即参数
        boolean flag=false;
        ps = conn.prepareStatement(sql);
        for(int i=0;i<para.length;i++){
            ps.setString(i+1,para[i]);
        }
        if(ps.executeUpdate()>0)
            flag=true;
        return flag;
    }


    public ResultSet query(String sql,String[] para) throws SQLException {
        ps=conn.prepareStatement(sql);
        for(int i=0;i<para.length;i++){
            ps.setString(i+1,para[i]);
        }
        rs=ps.executeQuery();
        return rs;
    }
   /* public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SqlHelper sqlHelper=new SqlHelper();
        String sql="insert into userinfo values(?,?,?)";
        String[] para={"004", "ma", "123"};
        PreparedStatement ps=sqlHelper.conn.prepareStatement(sql);
        for(int i=0;i<para.length;i++){
            ps.setString(i+1,para[i]);
        }
        int i=ps.executeUpdate();
        System.out.println(i);
    }*/
}
