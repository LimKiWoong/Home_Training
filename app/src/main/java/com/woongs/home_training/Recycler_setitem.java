package com.woongs.home_training;

import android.graphics.drawable.Drawable;

public class Recycler_setitem {
    private String num;
    private Drawable img2;
    private String text1;
    private String text2;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Drawable getImg2() {
        return img2;
    }

    public void setImg2(Drawable img2) {
        this.img2 = img2;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public Recycler_setitem(String num, Drawable img2, String text1, String text2) {
        this.num = num;
        this.img2 = img2;
        this.text1 = text1;
        this.text2 = text2;
    }
    public Recycler_setitem(String num, String text1, String text2) {
        this.num = num;
        this.text1 = text1;
        this.text2 = text2;
    }
}
