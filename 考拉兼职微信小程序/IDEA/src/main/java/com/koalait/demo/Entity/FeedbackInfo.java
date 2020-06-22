package com.koalait.demo.Entity;

public class FeedbackInfo {
    private  int user_id;
    private  int hunter_id;
    private int boss_id;
    private  String detail;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getHunter_id() {
        return hunter_id;
    }

    public void setHunter_id(int hunter_id) {
        this.hunter_id = hunter_id;
    }

    public int getBoss_id() {
        return boss_id;
    }

    public void setBoss_id(int boss_id) {
        this.boss_id = boss_id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
