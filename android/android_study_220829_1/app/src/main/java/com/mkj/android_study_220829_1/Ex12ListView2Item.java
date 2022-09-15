package com.mkj.android_study_220829_1;


public class Ex12ListView2Item {
    /* 아이템의 정보를 담기 위한 클래스 */
    String num;
    String name;
    int resId;

    public Ex12ListView2Item(String num, String name, int resId) {
        this.num = num;
        this.name = name;
        this.resId = resId;
    }

    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getResId() {
        return resId;
    }
    public void setResId(int resId) {
        this.resId = resId;
    }
}
