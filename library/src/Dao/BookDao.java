package Dao;

import Filter.Filter;
import JavaBean.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookDao {
    private SqlHelper sqlHelper;
    private Book result;
    private List<Book> books;

    public BookDao() throws SQLException, ClassNotFoundException {
        sqlHelper = new SqlHelper();
        result = new Book();
        books = new ArrayList<Book>();
        String sql = "select * from TB_Book where 1=?";
        String[] para = {"1"};
        ResultSet rs = sqlHelper.query(sql, para);
        while (rs.next()) {
            Book temp = new Book();
            temp.setBkID(rs.getInt(1));
            temp.setBkCode(rs.getString(2));
            temp.setBkName(rs.getString(3));
            temp.setBkAuthor(rs.getString(4));
            temp.setBkPress(rs.getString(5));
            temp.setBkDatePress(new Timestamp(rs.getDate(6).getTime()));
            temp.setBkISBN(rs.getString(7));
            temp.setBkLanguage(rs.getInt(8));
            temp.setBkPages(rs.getInt(9));
            temp.setBkPrice(rs.getFloat(10));
            temp.setBkDateIn(new Timestamp(rs.getDate(11).getTime()));
            temp.setBkBrief(rs.getString(12));
            temp.setBkCover(rs.getString(13));
            temp.setBkStatus(rs.getString(14));
            temp.setBkCatalog(rs.getString(15));
            books.add(temp);
        }
    }

    public Book getAllById(int id) throws SQLException {
        String sql = "select * from TB_Book where bkID=?";
        String[] para = {String.valueOf(id)};
        ResultSet rs = sqlHelper.query(sql, para);
        if (rs.next()) {
            result.setBkID(rs.getInt(1));
            result.setBkCode(rs.getString(2));
            result.setBkName(rs.getString(3));
            result.setBkAuthor(rs.getString(4));
            result.setBkPress(rs.getString(5));
            result.setBkDatePress(new Timestamp(rs.getDate(6).getTime()));
            result.setBkISBN(rs.getString(7));
            result.setBkLanguage(rs.getInt(8));
            result.setBkPages(rs.getInt(9));
            result.setBkPrice(rs.getFloat(10));
            result.setBkDateIn(new Timestamp(rs.getDate(11).getTime()));
            result.setBkBrief(rs.getString(12));
            result.setBkCover(rs.getString(13));
            result.setBkStatus(rs.getString(14));
            result.setBkCatalog(rs.getString(15));
        }
        return result;
    }
    public int lanTocode(String lan){
        int code=0;
        switch(lan){
            case "中文":{
                break;
            }
            case "英文":{
                code=1;
                break;
            }
            case "日文":{
                code=2;
                break;
            }
            case "俄文":{
                code=3;
                break;
            }
            case "德文":{
                code=4;
                break;
            }
            case "法文":{
                code=5;
                break;
            }
        }
        return code;
    }

    public String codeToLan(int code){
        String lan="中文";
        switch (code){
            case 0:{
                lan="中文";
                break;
            }case 1:{
                lan="英文";
                break;
            }case 2:{
                lan="日文";
                break;
            }case 3:{
                lan="俄文";
                break;
            }case 4:{
                lan="德文";
                break;
            }case 5:{
                lan="法文";
                break;
            }
        }
        return lan;
    }

    public boolean addToDB(Book book) throws SQLException {
        boolean flag = false;
        String sql = "insert into TB_Book values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String[] para = {String.valueOf(book.getBkID()), book.getBkCode(), book.getBkName(),
                book.getBkAuthor(), book.getBkPress(), book.getBkDatePress() + "", book.getBkISBN(),
                String.valueOf(book.getBkLanguage()), String.valueOf(book.getBkPages()),
                String.valueOf(book.getBkPrice()), book.getBkDateIn() + "", book.getBkBrief(),
                book.getBkCover(), book.getBkStatus(), book.getBkCatalog()};
        if (sqlHelper.update(sql, para))
            flag = true;
        return flag;
    }
    public boolean update(Book book) throws SQLException {
        boolean flag=false;
        String sql="update TB_Book set bkCode=?,bkPrice=?,bkBrief=?,bkCover=?,bkStatus=? where bkID=?";
        String[] para={book.getBkCode(),String.valueOf(book.getBkPrice()),book.getBkBrief(),book.getBkCover(),book.getBkStatus(),String.valueOf(book.getBkID())};
        if(sqlHelper.update(sql,para))
            flag=true;
        return flag;
    }
    public boolean deleteById(int id) throws SQLException {
        boolean flag=false;
        String sql="delete TB_Book where bkID=?";
        String[] para={String.valueOf(id)};
        if(sqlHelper.update(sql,para))
            flag=true;
        return flag;
    }

    public List<Book> getBooks() {
        return books;
    }

    public int[] getBooksByName(String name) throws SQLException {
        int[] booksId = new int[10];
        String sql = "select bkID from TB_Book where bkName like ?";
        String[] para = {"%" + name + "%"};
        ResultSet rs = sqlHelper.query(sql, para);
        int i = 0;
        while (rs.next()) {
            booksId[i] = rs.getInt(1);
            i++;
        }
        return booksId;
    }
    /*public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        *//*Book temp=new Book();*//*
        BookDao bookDao=new BookDao();
        System.out.println(bookDao.getAllById(100).getBkID());
        *//*int[] list=bookDao.getBooksByName("ni");
        int i=0;
        while(list[i]!=0){
            System.out.println(bookDao.getAllById(list[i]).getBkName());i++;}
        String test="3.0";
        float n=Float.parseFloat(test);
        System.out.println(n);*//*
       }
*/
}
/*for(int i = 0; i<bookDao.getBooks().size(); i++){
            System.out.println(bookDao.getBooks().get(i).getBkName());
        }
        if(bookDao.addToDB(temp))
            System.out.println("cheng");
        System.out.println(bookDao.getAllById(1).getBkName());*/
   /* //String date="2019-09-01";
   Book temp=new Book();
    DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
    //Date date1=df.parse(date);
    String date = "2009-07-16T19:20"; // <input type="datetime-local"> 输入参数
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
    Date dt = sdf.parse(date);
        temp.setBkDatePress(new Timestamp(dt.getTime()));
                temp.setBkID(3);
                temp.setBkCode("003");
                temp.setBkName("无声之证");
                temp.setBkAuthor("赖尔");
                temp.setBkPress("福建人民出版社");
                temp.setBkDatePress(new Timestamp(df.parse("2019-09-01").getTime()));
                temp.setBkISBN("9787211081349");
                temp.setBkLanguage(0);
                temp.setBkPages(768);
                temp.setBkPrice(37);
                temp.setBkDateIn(new Timestamp(df.parse("2019-10-11").getTime()));
                temp.setBkBrief("这是一部成熟的悬疑推理小说。一位有WIFI过敏症，听觉能力超凡的女性殡导师； 一位从“官二代”跌落至人生谷底、为还债而嗜钱如命的快递小哥； 一位身家百亿又视金钱为粪土的电脑高手 毒舌侦探； 殡仪馆中永眠的证人，街头巷尾中隐匿的加害者，电磁波段中暗含的信息； 在不夜都市中，监控无处不在，讯息四通八达，却仍有解不开的谜团，猜不透的人心……");
                temp.setBkCover("b2.png");
                temp.setBkStatus("在馆");
                temp.setBkCatalog("I054");
*/