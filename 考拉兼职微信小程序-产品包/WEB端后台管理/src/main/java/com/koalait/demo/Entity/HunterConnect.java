package com.koalait.demo.Entity;

public class HunterConnect {

    private int hunter_id;
    private int user_id;//预约人的id
    private String user_name;
    private String hunter_title;
    private String price;
    private int order_boss;
    private int check;

    public int getHunter_id() {
        return hunter_id;
    }

    public void setHunter_id(int hunter_id) {
        this.hunter_id = hunter_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getHunter_title() {
        return hunter_title;
    }

    public void setHunter_title(String hunter_title) {
        this.hunter_title = hunter_title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getOrder_boss() {
        return order_boss;
    }

    public void setOrder_boss(int order_boss) {
        this.order_boss = order_boss;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }
}
