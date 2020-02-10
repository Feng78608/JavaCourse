package login;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private SqlHelper sqlHelper;
    public UserDao() throws SQLException, ClassNotFoundException {
        sqlHelper=new SqlHelper();
    }
    public boolean findUser(String userName,String pwd) throws SQLException, ClassNotFoundException {//根据用户名查密码，对比即可
        boolean flag=false;
        String[] para={userName};
        String sql="select password from student where sname=?";
        ResultSet rs=sqlHelper.query(para,sql);
        while(rs.next()){
            String passWord=rs.getString(1);
            if(passWord.equals(pwd)){
                flag=true;
                break;
            }
        }
        return flag;
    }
}
