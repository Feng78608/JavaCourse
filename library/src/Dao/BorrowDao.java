package Dao;

import JavaBean.Book;
import JavaBean.Borrow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BorrowDao {
    private SqlHelper sqlHelper;
    private Borrow result;
    private List<Borrow> list;
    public BorrowDao() throws SQLException, ClassNotFoundException {
        sqlHelper=new SqlHelper();
        result=new Borrow();
        list=new ArrayList<Borrow>();
        String sql="select * from TB_Borrow where 1=?";
        String[] para={"1"};
        ResultSet rs=sqlHelper.query(sql,para);
        while(rs.next()){
            Borrow temp=new Borrow();
            temp.setBorrowID(rs.getInt(1));
            temp.setRdID(rs.getInt(2));
            temp.setBkID(rs.getInt(3));
            temp.setLdContinueTimes(rs.getInt(4));
            temp.setLdDateOut(rs.getDate(5));
            temp.setLdDateRetPlan(rs.getDate(6));
            temp.setLdDateRetAct(rs.getDate(7));
            temp.setLdOverDay(rs.getInt(8));
            temp.setLdOverMoney(rs.getFloat(9));
            temp.setLdPunishMoney(rs.getFloat(10));
            temp.setIsHasReturn(rs.getByte(11));
            temp.setOperatorLend(rs.getString(12));
            temp.setOperatorRet(rs.getString(13));
            list.add(temp);
        }
    }
    public boolean borrow(String[]para) throws SQLException, ClassNotFoundException {//para[1]为读者id，para[2]为书籍id
        boolean flag=false;
        String sql1="update TB_Book set bkStatus='外借' where bkID=?";/*设置图书状态*/
        String[] para1={para[2]};
        String sql2="update TB_Reader set rdBorrowQty+=1 where rdID=?";/*设置读者已接图书数量*/
        String[] para2={para[1]};
        String sql="insert into TB_Borrow values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(sqlHelper.update(sql,para)&&sqlHelper.update(sql1,para1)&&sqlHelper.update(sql2,para2))
            flag=true;
        return flag;
    }
    public int getBkIdByRdId(int uid) throws SQLException {
        int bkId=0;
        String sql="select bkID from TB_Borrow where rdID=?";
        String[] para={String.valueOf(uid)};
        ResultSet rs=sqlHelper.query(sql,para);
        if(rs.next()){
            bkId=rs.getInt(1);
        }
        return bkId;
    }
    public boolean returnBook(float borrowId) throws SQLException, ClassNotFoundException {
        boolean flag=false;
        String sql1="update TB_Book set bkStatus='在馆' where bkID=?";
        String[] para1={String.valueOf(getBorrowById(borrowId).getBkID())};
        String sql2="update TB_Reader set rdBorrowQty-=1 where rdID=?";/*设置读者已接图书数量*/
        String[] para2={String.valueOf(getBorrowById(borrowId).getRdID())};
        String sql="update TB_Borrow set isHasReturn=1 where BorrowID=?";
        String[] para={String.valueOf(borrowId)};
        if(sqlHelper.update(sql,para)&&sqlHelper.update(sql1,para1)&&sqlHelper.update(sql2,para2))
            flag=true;
        return flag;
    }
    public boolean renew(float borrowId) throws SQLException {
        boolean flag=false;
        String sql="update TB_Borrow set ldContinueTimes+=1,ldDateRetPlan+=30 where BorrowID=?";
        String[] para={String.valueOf(borrowId)};
        if(sqlHelper.update(sql,para))
            flag=true;
        return flag;
    }
    public Borrow getBorrowById(float bId) throws SQLException {
        String sql="select * from TB_Borrow where BorrowID=?";
        String[] para={String.valueOf(bId)};
        ResultSet rs=sqlHelper.query(sql,para);
        if(rs.next()){
            result.setBorrowID(rs.getInt(1));
            result.setRdID(rs.getInt(2));
            result.setBkID(rs.getInt(3));
            result.setLdContinueTimes(rs.getInt(4));
            result.setLdDateOut(rs.getDate(5));
            result.setLdDateRetPlan(rs.getDate(6));
            result.setLdDateRetAct(rs.getDate(7));
            result.setLdOverDay(rs.getInt(8));
            result.setLdOverMoney(rs.getFloat(9));
            result.setLdPunishMoney(rs.getFloat(10));
            result.setIsHasReturn(rs.getByte(11));
            result.setOperatorLend(rs.getString(12));
            result.setOperatorRet(rs.getString(13));
        }
        return result;
    }
    public List<Borrow> getList(){
        return list;
    }
   /* public static void main(String[] args) throws SQLException, ClassNotFoundException {
        BorrowDao borrowDao=new BorrowDao();
        BookDao bookDao=new BookDao();
        bookDao.getAllById(2).setBkStatus("外借");
        int bookCount=0;
        for(int i=0;i<borrowDao.getList().size();i++){
            if(borrowDao.getList().get(i).getRdID()==1&&(borrowDao.getList().get(i).getIsHasReturn()==0))//读者未还的书
                bookCount++;
        }
        System.out.println(bookCount);
    }*/
   /* public static void main(String[] args) throws ParseException, SQLException, ClassNotFoundException {
        BorrowDao borrowDao=new BorrowDao();
        *//*if(borrowDao.returnBook(4))
            System.out.println("c");*//*
        Date date=new Date();
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, 30);// num为增加的天数，可以改变的
        *//*Calendar calendar=Calendar.getInstance();
        long over=borrowDao.getList().get(0).getLdDateRetPlan().getTime()-calendar.getTimeInMillis();
        System.out.println(over/ (1000 * 60 * 60 * 24));
        for(int i=borrowDao.getList().size()-1;i>=0;i--){
            System.out.println(borrowDao.getList().get(i).getBkID());
        }
        System.out.println(borrowDao.getBkIdByRdId(1));*//*
        *//*String[] para={String.valueOf(5.0),String.valueOf(1),String.valueOf(2),String.valueOf(0),
                date+"",ca.getTime()+"",
                date+"",String.valueOf(0),String.valueOf(0),String.valueOf(0),
                String.valueOf(0),"",""};*//*
        *//*String[] para={String.valueOf(5.0),String.valueOf(1),String.valueOf(2),String.valueOf(0),
                new Timestamp(date.getTime())+"",new Timestamp(ca.getTime().getTime())+"",
                new Timestamp(date.getTime())+"",String.valueOf(0),String.valueOf(0),String.valueOf(0),
                String.valueOf(0),"",""};
        *//**//*String[] para={date+""};*//**//*
        SqlHelper sqlHelper1=new SqlHelper();
        String sql="update TB_Borrow set ldDateOut=? where BorrowID=1";
        if(borrowDao.borrow(para))
            System.out.println("cheng");*//*
    }*/




}
