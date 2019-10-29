package differentDB;

/**
 * 数据库连接配置信息类
 * @author Damon
 */
public class JdbcUrl
{

    /** 定义数据库参数 */

    // 数据库类型
    private String DBType;
    // 数据库服务器IP
    private String IP;
    // 数据库服务器端口
    private String Port;
    // 数据库名称
    private String DBName;
    // 用户名
    private String UserName;
    // 密码
    private String PassWord;


    /**
     * 默认构造方法，连接默认数据库
     */
    public JdbcUrl()
    {
        // TODO Auto-generated constructor stub
        DBType = "MYSQL";
        IP = "127.0.0.1";
        DBName = "teaching";
        Port = "3306";
        UserName = "root";
        PassWord = "123456";
    }

    /**
     * 连接指定数据库
     * @param urlType 传入连接类型标识
     */
    public JdbcUrl(String urlType)
    {
        if ("mysql".equals(urlType))
        {
            DBType = "MYSQL";
            IP = "127.0.0.1";
            DBName = "mysql";
            Port = "3306";
            UserName = "root";
            PassWord = "123456";
        }
    }

    /**
     * 获取连接句柄
     * @return String
     */
    public String getJdbcDri_Url()
    {
        String Dri_url = null;
        String sUrl = null;
        String driver = null;
        if (DBType.trim().toUpperCase().equals("MYSQL"))//trim()去掉首尾空格，toUpperCase()返回大写的字符串
        {
            sUrl = "jdbc:mysql://" + IP + ":" + Port + "/" + DBName + "?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8";
            driver="com.mysql.cj.jdbc.Driver";
        }
        else if (DBType.trim().toUpperCase().equals("DB2"))
        {
            sUrl = "jdbc:db2://" + IP + ":" + Port + "/" + DBName;
            driver="com.ibm.db2.jcc.DB2Driver";
        }

        else if (DBType.trim().toUpperCase().equals("ORACLE"))
        {
            sUrl = "jdbc:oracle:thin:@" + IP + ":" + Port + ":" + DBName;
            driver="oracle.jdbc.driver.OracleDriver";
        }

        else if (DBType.trim().toUpperCase().equals("SQLSERVER"))
        {
            sUrl = "jdbc:microsoft:sqlserver://" + IP + ":" + Port + ";databaseName=" + DBName;
            driver="com.microsoft.jdbc.sqlserver.SQLServerDriver";
        }
        else
        {
            System.out.println("暂无对应数据库驱动");
        }
        Dri_url=driver+" "+sUrl;
        //System.out.println("测试JdbcURL"+Dri_url);
        return Dri_url;
    }//split();
     //String str="Java string split test";
     //String[] strarray=str.split(" "); //str即为stringObj；
     //for (int i = 0; i < strarray.length; i++)
     //System.out.println(strarray[i]);

   /* public static void main(String[] args){
        JdbcUrl url=new JdbcUrl();
        url.getJdbcDri_Url();
    }*/

    // getters and setters

    public String getDBType()
    {
        return DBType;
    }

    public void setDBType(String dBType)
    {
        DBType = dBType;
    }

    public String getIP()
    {
        return IP;
    }

    public void setIP(String iP)
    {
        IP = iP;
    }

    public String getPort()
    {
        return Port;
    }

    public void setPort(String port)
    {
        Port = port;
    }

    public String getDBName()
    {
        return DBName;
    }

    public void setDBName(String dBName)
    {
        DBName = dBName;
    }

    public String getUserName()
    {
        return UserName;
    }

    public void setUserName(String userName)
    {
        UserName = userName;
    }

    public String getPassWord()
    {
        return PassWord;
    }

    public void setPassWord(String passWord)
    {
        PassWord = passWord;
    }

}
