package com.mkj.android_study_220829_1;


public class Ex13PhoneList2Item {
    /* 아이템의 정보를 담기 위한 클래스 */
    String num;
    String name;
    int resId;
    int resIdBtn;

    public Ex13PhoneList2Item(int resId, String name, String num, int resIdBtn) {
        this.resId = resId;
        this.name = name;
        this.num = num;
        this.resIdBtn = resIdBtn;
    }

    public int getResId() {
        return resId;
    }
    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }

    public int getResIdBtn() {
        return resIdBtn;
    }
    public void setResIdBtn(int resIdBtn) {
        this.resIdBtn = resIdBtn;
    }
}
