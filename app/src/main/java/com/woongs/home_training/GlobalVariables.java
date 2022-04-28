package com.woongs.home_training;

import android.app.Application;

public class GlobalVariables extends Application {

    public static int radionum = 0;

    public static int image = 0;
    public static int setnumber1 = 1;
    public static int setnumber2 = 0;

    public static int pos1_sec_time = 0;
    public static int pos1_min_time = 0;

    public static int pos2_sec_time = 0;
    public static int pos2_min_time = 0;

    public static int pos3_sec_time = 0;
    public static int pos3_min_time = 0;

    public static int pos4_sec_time = 0;
    public static int pos4_min_time = 0;

    public static int pos5_sec_time = 0;
    public static int pos5_min_time = 0;

    public static String pos1_count = "0";
    public static String pos2_count = "0";
    public static String pos3_count = "0";
    public static String pos4_count = "0";
    public static String pos5_count = "0";

    public static String setlevel = "0";

    //t_time = 운동하는시간
    public static long t_time = 0;
    public static String datetime = "0";

    //오늘운동시간
    public static String todaymin = "0";
    public static String todaysec = "0";
    //어제운동시간
    public static String yesterdaymin = "0";
    public static String yesterdaysec = "0";





    public static int getRadionum() {
        return radionum;
    }

    public static void setRadionum(int radionum) {
        GlobalVariables.radionum = radionum;
    }




    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public static int getSetnumber1() {
        return setnumber1;
    }

    public static void setSetnumber1(int setnumber1) {
        GlobalVariables.setnumber1 = setnumber1;
    }

    public static int getSetnumber2() {
        return setnumber2;
    }

    public static void setSetnumber2(int setnumber2) {
        GlobalVariables.setnumber2 = setnumber2;
    }

    public static int getPos1_sec_time() {
        return pos1_sec_time;
    }

    public static void setPos1_sec_time(int pos1_sec_time) {
        GlobalVariables.pos1_sec_time = pos1_sec_time;
    }

    public static int getPos1_min_time() {
        return pos1_min_time;
    }

    public static void setPos1_min_time(int pos1_min_time) {
        GlobalVariables.pos1_min_time = pos1_min_time;
    }

    public static int getPos2_sec_time() {
        return pos2_sec_time;
    }

    public static void setPos2_sec_time(int pos2_sec_time) {
        GlobalVariables.pos2_sec_time = pos2_sec_time;
    }

    public static int getPos2_min_time() {
        return pos2_min_time;
    }

    public static void setPos2_min_time(int pos2_min_time) {
        GlobalVariables.pos2_min_time = pos2_min_time;
    }

    public static int getPos3_sec_time() {
        return pos3_sec_time;
    }

    public static void setPos3_sec_time(int pos3_sec_time) {
        GlobalVariables.pos3_sec_time = pos3_sec_time;
    }

    public static int getPos3_min_time() {
        return pos3_min_time;
    }

    public static void setPos3_min_time(int pos3_min_time) {
        GlobalVariables.pos3_min_time = pos3_min_time;
    }

    public static int getPos4_sec_time() {
        return pos4_sec_time;
    }

    public static void setPos4_sec_time(int pos4_sec_time) {
        GlobalVariables.pos4_sec_time = pos4_sec_time;
    }

    public static int getPos4_min_time() {
        return pos4_min_time;
    }

    public static void setPos4_min_time(int pos4_min_time) {
        GlobalVariables.pos4_min_time = pos4_min_time;
    }

    public static int getPos5_sec_time() {
        return pos5_sec_time;
    }

    public static void setPos5_sec_time(int pos5_sec_time) {
        GlobalVariables.pos5_sec_time = pos5_sec_time;
    }

    public static int getPos5_min_time() {
        return pos5_min_time;
    }

    public static void setPos5_min_time(int pos5_min_time) {
        GlobalVariables.pos5_min_time = pos5_min_time;
    }






    public static String getPos1_count() {
        return pos1_count;
    }

    public static void setPos1_count(String pos1_count) {
        GlobalVariables.pos1_count = pos1_count;
    }

    public static String getPos2_count() {
        return pos2_count;
    }

    public static void setPos2_count(String pos2_count) {
        GlobalVariables.pos2_count = pos2_count;
    }

    public static String getPos3_count() {
        return pos3_count;
    }

    public static void setPos3_count(String pos3_count) {
        GlobalVariables.pos3_count = pos3_count;
    }

    public static String getPos4_count() {
        return pos4_count;
    }

    public static void setPos4_count(String pos4_count) {
        GlobalVariables.pos4_count = pos4_count;
    }

    public static String getPos5_count() {
        return pos5_count;
    }

    public static void setPos5_count(String pos5_count) {
        GlobalVariables.pos5_count = pos5_count;
    }




    public static String getSetlevel() {
        return setlevel;
    }

    public static void setSetlevel(String setlevel) {
        GlobalVariables.setlevel = setlevel;
    }

    public static long getT_time() {
        return t_time;
    }

    public static void setT_time(long t_time) {
        GlobalVariables.t_time = t_time;
    }

    public static String getDatetime() {
        return datetime;
    }

    public static void setDatetime(String datetime) {
        GlobalVariables.datetime = datetime;
    }

    public static String getTodaymin() {
        return todaymin;
    }

    public static void setTodaymin(String todaymin) {
        GlobalVariables.todaymin = todaymin;
    }

    public static String getTodaysec() {
        return todaysec;
    }

    public static void setTodaysec(String todaysec) {
        GlobalVariables.todaysec = todaysec;
    }

    public static String getYesterdaymin() {
        return yesterdaymin;
    }

    public static void setYesterdaymin(String yesterdaymin) {
        GlobalVariables.yesterdaymin = yesterdaymin;
    }

    public static String getYesterdaysec() {
        return yesterdaysec;
    }

    public static void setYesterdaysec(String yesterdaysec) {
        GlobalVariables.yesterdaysec = yesterdaysec;
    }
}
