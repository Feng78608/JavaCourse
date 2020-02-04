package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReaderTypeDao {
    SqlHelper sqlHelper;
    public  ReaderTypeDao() throws SQLException, ClassNotFoundException {
        sqlHelper=new SqlHelper();
    }
    public int getTimesByReaderType(int type) throws SQLException {//续借次数
        int times=0;
        String sql="select CanContinueTimes from TB_ReaderType where rdType=?";
        String[] para={String.valueOf(type)};
        ResultSet rs=sqlHelper.query(sql,para);
        if(rs.next())
            times=rs.getInt(1);
        return times;
    }
    public int getCanLendDayByType(int type) throws SQLException {//一次可借多少天
        int day=0;
        String sql="select CanLendDay from TB_ReaderType where rdType=?";
        String[] para={String.valueOf(type)};
        ResultSet rs=sqlHelper.query(sql,para);
        if(rs.next())
            day=rs.getInt(1);
        return day;
    }
    public int getQtyByType(int type) throws SQLException {//最多借几本
        int qty=0;
        String sql="select CanLendQty from TB_ReaderType where rdType=?";
        String[] para={String.valueOf(type)};
        ResultSet rs=sqlHelper.query(sql,para);
        if(rs.next())
            qty=rs.getInt(1);
        return qty;
    }
    /*public  static void main(String[] pags) throws SQLException, ClassNotFoundException {
        ReaderTypeDao readerTypeDao=new ReaderTypeDao();
        ReaderDao readerDao=new ReaderDao();
        int n=readerDao.getReaderById(1).getRdType();
        int can=readerTypeDao.getQtyByType(n);
        System.out.println(n);
    }*/
}
