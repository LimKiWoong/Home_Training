package com.woongs.home_training;

public class Frag02_ListItem {
    String min;
    String sec;
    String num;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    public Frag02_ListItem(String num,String min, String sec){
        this.min = min;
        this.sec = sec;
        this.num = num;
    }
}
