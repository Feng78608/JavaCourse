package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/teaching?serverTimezone=UTC&&useSSL=false";
        //String url="jdbc:mysql://localhost:3306/teaching?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8\""
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection(url,
                "root","123456");
        return conn;
    }
}
