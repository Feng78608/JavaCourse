package connectPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MyPool pool=new MyPool();
        pool.bulidPool(9);
        String sql = "select * from student order by sno";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        long timeStart=System.currentTimeMillis();
        Connection con;
        for(int i=0;i<50000;i++){
            con=pool.getConn();
            pstmt=(PreparedStatement)con.prepareStatement(sql);
            rs=(ResultSet)pstmt.executeQuery();
//            while(rs.next()){
//                String number=rs.getString("sno");
//                String name=rs.getString("sname");
//                System.out.println(number+"\t"+name);
//            }
            pool.closeConn(con);
        }
        long timeEnd=System.currentTimeMillis();
        Long time=timeEnd-timeStart;
        System.out.println("查询5000次所用时间为："+time+"毫秒");
    }
}
