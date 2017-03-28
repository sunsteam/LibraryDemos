package com.yomii.librarydemos.rxretrofit.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 豆瓣api返回结果封装
 * Created by Yomii on 2017/3/22.
 */

public class DoubanBean<T> {


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

    @SerializedName(value = "subjects", alternate = {"books"})
    private List<T> subjects;

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

    public List<T> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<T> subjects) {
        this.subjects = subjects;
    }

    /**
     * 获取下一次请求的索引条目号
     *
     * @return 没有数据时返回-2 , 已请求到所有数据时返回-1, 可以请求时返回大于0的数
     */
    public int getNextStart() {
        if (total == 0)
            return -2;
        if (start + count >= total)
            return -1;
        return start + count;
    }
}
