package com.yomii.librarydemos.rxretrofit.bean;

/**
 * Created by Yomii on 2017/3/22.
 */

public class Bean<T> {


    /**
     * count : 20
     * start : 0
     * total : 32
     * title : 正在上映的电影-北京
     */

    private int count;
    private int start;
    private int total;
    private String title;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
