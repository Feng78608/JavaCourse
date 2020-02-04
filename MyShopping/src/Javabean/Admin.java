package Javabean;

public class Admin {
    private String admin_id;
    private String admin_name;
    private String admin_pwd;
    private int admin_level;

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public void setAdmin_pwd(String admin_pwd) {
        this.admin_pwd = admin_pwd;
    }

    public void setAdmin_level(int admin_level) {
        this.admin_level = admin_level;
    }
    public String getAmin_id(){
        return admin_id;
    }
    public String getAdmin_name(){
        return admin_name;
    }
    public String getAdmin_pwd(){
        return admin_pwd;
    }
    public int getAdmin_level(){
        return admin_level;
    }
}
