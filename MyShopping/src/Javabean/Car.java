package Javabean;

public class Car {
    private String user_id;
    private String good_id;
    private float good_price;
    private int good_num;
    private String good_picture;
    private String good_name;

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setGood_id(String good_id) {
        this.good_id = good_id;
    }

    public void setGood_num(int good_num) {
        this.good_num = good_num;
    }

    public void setGood_picture(String good_picture) {
        this.good_picture = good_picture;
    }

    public void setGood_price(float good_price) {
        this.good_price = good_price;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public float getGood_price() {
        return good_price;
    }

    public int getGood_num() {
        return good_num;
    }

    public String getGood_id() {
        return good_id;
    }

    public String getGood_picture() {
        return good_picture;
    }

    public String getUser_id() {
        return user_id;
    }
    public String getGood_name(){return good_name;}
}
