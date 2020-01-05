package Javabean;

public class Goods {
    private String good_id;
    private String good_name;
    private float good_price;
    private String good_picture;
    private int good_stock;
    private String good_brief;

    public void setGood_id(String good_id) {
        this.good_id = good_id;
    }

    public void setGood_price(float good_price) {
        this.good_price = good_price;
    }

    public void setGood_picture(String good_picture) {
        this.good_picture = good_picture;
    }

    public void setGood_brief(String good_brief) {
        this.good_brief = good_brief;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public void setGood_stock(int good_stock) {
        this.good_stock = good_stock;
    }

    public float getGood_price() {
        return good_price;
    }

    public String getGood_id() {
        return good_id;
    }

    public String getGood_picture() {
        return good_picture;
    }

    public int getGood_stock() {
        return good_stock;
    }

    public String getGood_brief() {
        return good_brief;
    }

    public String getGood_name() {
        return good_name;
    }
}
