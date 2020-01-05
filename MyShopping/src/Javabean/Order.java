package Javabean;

import java.util.Date;

public class Order {
    private int order_id;
    private String good_id;
    private String user_id;
    private int good_num;
    private float good_price;
    private float all_price;
    private Date order_date;
    private boolean order_state;
    private String receiver_name;
    private String receiver_address;
    private String receiver_tel;

    public void setGood_price(float good_price) {
        this.good_price = good_price;
    }

    public void setGood_num(int good_num) {
        this.good_num = good_num;
    }

    public void setGood_id(String good_id) {
        this.good_id = good_id;
    }

    public void setAll_price(float all_price) {
        this.all_price = all_price;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setOrder_state(boolean order_state) {
        this.order_state = order_state;
    }

    public void setReceiver_address(String receiver_address) {
        this.receiver_address = receiver_address;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public void setReceiver_tel(String receiver_tel) {
        this.receiver_tel = receiver_tel;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getGood_id() {
        return good_id;
    }

    public int getGood_num() {
        return good_num;
    }

    public float getGood_price() {
        return good_price;
    }

    public float getAll_price() {
        return all_price;
    }

    public boolean isOrder_state() {
        return order_state;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public int getOrder_id() {
        return order_id;
    }

    public String getReceiver_address() {
        return receiver_address;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public String getReceiver_tel() {
        return receiver_tel;
    }
}
