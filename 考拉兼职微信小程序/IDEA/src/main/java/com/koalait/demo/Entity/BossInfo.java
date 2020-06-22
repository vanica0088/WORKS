package com.koalait.demo.Entity;

import java.util.Date;

public class BossInfo {
    private int boss_id;
    private String boss_detail;
    private Integer user_id;
    private String limited_time;
    private String price;
    private int daily_wage;
    private boolean boss_state;
    private String boss_title;
    private String img_url;
    private Date create_time;
    private int orderhunter;
    private int checkstate;
    private int check;
    private String state;
    private String user_name;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getBoss_id() {
        return boss_id;
    }

    public void setBoss_id(int boss_id) {
        this.boss_id = boss_id;
    }

    public String getBoss_detail() {
        return boss_detail;
    }

    public void setBoss_detail(String boss_detail) {
        this.boss_detail = boss_detail;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getLimited_time() {
        return limited_time;
    }

    public void setLimited_time(String limited_time) {
        this.limited_time = limited_time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getDaily_wage() {
        return daily_wage;
    }

    public void setDaily_wage(int daily_wage) {
        this.daily_wage = daily_wage;
    }

    public boolean isBoss_state() {
        return boss_state;
    }

    public void setBoss_state(boolean boss_state) {
        this.boss_state = boss_state;
    }

    public String getBoss_title() {
        return boss_title;
    }

    public void setBoss_title(String boss_title) {
        this.boss_title = boss_title;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getOrderhunter() {
        return orderhunter;
    }

    public void setOrderhunter(int orderhunter) {
        this.orderhunter = orderhunter;
    }

    public int getCheckstate() {
        return checkstate;
    }

    public void setCheckstate(int checkstate) {
        this.checkstate = checkstate;
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
