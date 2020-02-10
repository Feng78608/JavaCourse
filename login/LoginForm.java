package login;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginForm {
    private UserDao userDao;
    public LoginForm() throws SQLException, ClassNotFoundException {
        userDao=new UserDao();

    }    public void display() throws SQLException, ClassNotFoundException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("***************");
        System.out.println("用户名：");
        String userName=scanner.next();
        System.out.println("密码：");
        String pwd=scanner.next();
        if(userDao.findUser(userName,pwd)){
            System.out.println("登陆成功≧∇≦");
            System.out.println("***************");
        }else{
            System.out.println("用户名或密码不正确哦•̆ ᵕ •̆ ");
            display();
        }

    }
    public void validate(){//验证
    }
}
