package Dao;

import JavaBean.Reader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ReaderDao {
    private SqlHelper sqlHelper;
    private Reader result;
    private List<Reader> readers;
    public ReaderDao() throws SQLException, ClassNotFoundException {
        sqlHelper=new SqlHelper();
        result=new Reader();
        readers=new ArrayList<Reader>();
        String sql="select * from TB_Reader where 1=?";
        String[] para={"1"};
        ResultSet rs=sqlHelper.query(sql,para);
        while (rs.next()){
            Reader temp=new Reader();
            temp.setRdID(rs.getInt(1));
            temp.setRdName(rs.getString(2));
            temp.setRdSex(rs.getString(3));
            temp.setRdType(rs.getInt(4));
            temp.setRdDept(rs.getString(5));
            temp.setRdPhone(rs.getString(6));
            temp.setRdEmail(rs.getString(7));
            temp.setRdDateReg(new Timestamp(rs.getDate(8).getTime()));
            temp.setRdPhoto(rs.getString(9));
            temp.setRdStatus(rs.getString(10));
            temp.setRdBorrowQty(rs.getInt(11));
            temp.setRdPwd(rs.getString(12));
            temp.setRdAdminRoles(rs.getInt(13));
            readers.add(temp);
        }
    }
    public List<Reader> getReaders(){return readers;}
    public int typeTocode(String type){//读者类型转化为数据库字段定义的类型
        int code=0;
        switch(type){
            case "教师":{
                code=10;
                break;
            }case "本科生":{
                code=20;
                break;
            }case "专科生":{
                code=21;
                break;
            }case "硕士研究生":{
                code=30;
                break;
            }case "博士研究生":{
                code=31;
                break;
            }
        }
        return code;
    }
    public int roleTocode(String role){//管理员角色转为可进数据库的类型0-读者、1-借书证管理、2-图书管理、4-借阅管理、8-系统管理，
        int code=0;
        switch(role){
            case "读者":{
                break;
            }case "借书证管理员":{
                code=1;
                break;
            }case "图书管理员":{
                code=2;
                break;
            } case "系统管理员":{
                code=8;
                break;
            }case "借阅管理员":{//没有做借阅管理
                code=4;
                break;
            }
        }
        return code;
    }
    public Reader getReaderById(int id) throws SQLException {
        String sql="select * from TB_Reader where rdID=?";
        String[] para={String.valueOf(id)};
        ResultSet rs=sqlHelper.query(sql,para);
        if(rs.next()) {
            result.setRdID(rs.getInt(1));
            result.setRdName(rs.getString(2));
            result.setRdSex(rs.getString(3));
            result.setRdType(rs.getInt(4));
            result.setRdDept(rs.getString(5));
            result.setRdPhone(rs.getString(6));
            result.setRdEmail(rs.getString(7));
            result.setRdDateReg(new Timestamp(rs.getDate(8).getTime()));
            result.setRdPhoto(rs.getString(9));
            result.setRdStatus(rs.getString(10));
            result.setRdBorrowQty(rs.getInt(11));
            result.setRdPwd(rs.getString(12));
            result.setRdAdminRoles(rs.getInt(13));
        }
        return result;
    }
    public String jumpByRole(int role){
        String url ="<script type='text/javascript'>window.parent.location.href='index.jsp';</script>";
        switch (role){
            case 1:{
                url="<script type='text/javascript'>window.parent.location.href='readerManage.jsp';</script>";
                break;}
            case 2:{
                url="<script type='text/javascript'>window.parent.location.href='booksManage.jsp';</script>";
                break;
            }
            case 8:{
                url="<script type='text/javascript'>window.parent.location.href='systemManage.jsp';</script>";
            }
        }
        return url;
    }
    public String getPageById(int id) throws SQLException {
        String page="index.jsp";
        switch (getReaderById(id).getRdAdminRoles()){
            case 1:{
                page="readerManage.jsp";
                break;}
            case 2:{
                page="booksManage.jsp";
                break;
            }
            case 8:{
                page="systemManage.jsp";
            }
        }
        return page;
    }
    public boolean addToDb(Reader reader) throws SQLException {
        boolean flag=false;
        String sql="insert into TB_Reader values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String[] para={String.valueOf(reader.getRdID()),reader.getRdName(),
                reader.getRdSex(),String.valueOf(reader.getRdType()),
                reader.getRdDept(),reader.getRdPhone(),reader.getRdEmail(),
                reader.getRdDateReg()+"",reader.getRdPhoto(),reader.getRdStatus(),
                String.valueOf(reader.getRdBorrowQty()),reader.getRdPwd(),
                String.valueOf(reader.getRdAdminRoles())};
        if(sqlHelper.update(sql,para))
            flag=true;
        return flag;
    }
    public String codeToType(int code){/*由代码得到读者类型*/
        String type="本科生";
        switch (code) {
            case 20:{
                break;
            }case 10:{
                type="教师";
                break;
            }case 21:{
                type="专科生";
                break;
            }case 30:{
                type="硕士研究生";
                break;
            }case 31:{
                type="博士研究生";
                break;
            }
        }
        return type;
    }
    public String codeToRole(int code){/*由代码得到管理员角色0-读者、1-借书证管理、2-图书管理、4-借阅管理、8-系统管理，*/
        String role="读者";
        switch (code) {
            case 0:{
                break;
            }case 1:{
                role="借书证管理员";
                break;
            }case 2:{
                role="图书管理员";
                break;
            }case 8:{
                role="系统管理员";
                break;
            }case 4:{
                role="借阅管理员";
                break;
            }
        }
        return role;
    }
    public boolean update(Reader reader) throws SQLException {
        boolean flag=false;
        String sql="update TB_Reader set rdName=?,rdType=?,rdDept=?,rdPhone=?,rdEmail=?,rdPhoto=?,rdPwd=? where rdID=?";
        String[] para={reader.getRdName(),String.valueOf(reader.getRdType()),
                reader.getRdDept(),reader.getRdPhone(),reader.getRdEmail(),
                reader.getRdPhoto(),reader.getRdPwd(),String.valueOf(reader.getRdID())};
        if(sqlHelper.update(sql,para))
            flag=true;
        return flag;
    }
    public boolean upRole(Reader reader) throws SQLException {
        boolean flag=false;
        String sql="update TB_Reader set rdPwd=?,rdAdminRoles=? where rdID=?";
        String[] para={reader.getRdPwd(),String.valueOf(reader.getRdAdminRoles()),String.valueOf(reader.getRdID())};
        if(sqlHelper.update(sql,para))
            flag=true;
        return flag;
    }
    public boolean deleteById(int id) throws SQLException {
        boolean flag=false;
        String sql="delete TB_Reader where rdID=?";
        String[] para={String.valueOf(id)};
        if(sqlHelper.update(sql,para))
            flag=true;
        return flag;
    }
    public int[] getIdByName(String name) throws SQLException {
        int[] readers= new int[10];
        String sql = "select rdID from TB_Reader where rdName like ?";
        String[] para = {"%" + name + "%"};
        ResultSet rs = sqlHelper.query(sql, para);
        int i = 0;
        while (rs.next()) {
            readers[i] = rs.getInt(1);
            i++;
        }
        return readers;
    }
    /*public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ReaderDao readerDao=new ReaderDao();
        System.out.println(readerDao.getReaderById(10).getRdID());
    }*/
}

