package com.koalait.demo.Entity;

public class BossConnect {
    private int boss_id;
    private int user_id;//预约人的id
    private String user_name;
    private String boss_title;
    private String price;
    private int order_hunter;
    private int check;
    private String state;

    public int getBoss_id() {
        return boss_id;
    }

    public void setBoss_id(int boss_id) {
        this.boss_id = boss_id;
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

    public String getBoss_title() {
        return boss_title;
    }

    public void setBoss_title(String boss_title) {
        this.boss_title = boss_title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getOrder_hunter() {
        return order_hunter;
    }

    public void setOrder_hunter(int order_hunter) {
        this.order_hunter = order_hunter;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
