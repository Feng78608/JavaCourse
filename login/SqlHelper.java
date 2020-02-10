package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlHelper {
    private DBUtil dbUtil;
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection conn;
    public SqlHelper() throws SQLException, ClassNotFoundException {
        dbUtil=new DBUtil();
        conn=dbUtil.getConnection();
        ps=null;
        rs=null;
    }
    public ResultSet query(String[] para,String sql) throws SQLException, ClassNotFoundException {
        ps=conn.prepareStatement(sql);
        for(int i=0;i<para.length;i++){
            ps.setString(i+1,para[i]);
        }
        rs=ps.executeQuery();
        return rs;
    }
}
