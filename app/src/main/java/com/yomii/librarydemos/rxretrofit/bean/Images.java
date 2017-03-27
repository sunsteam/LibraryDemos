package com.yomii.librarydemos.rxretrofit.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 图片
 */
public class Images implements Parcelable {
    /**
     * small : http://img7.doubanio.com/view/movie_poster_cover/ipst/public/p2417948644.jpg
     * large : http://img7.doubanio.com/view/movie_poster_cover/lpst/public/p2417948644.jpg
     * medium : http://img7.doubanio.com/view/movie_poster_cover/spst/public/p2417948644.jpg
     */

    private String small;
    private String large;
    private String medium;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.small);
        dest.writeString(this.large);
        dest.writeString(this.medium);
    }

    public Images() {
    }

    protected Images(Parcel in) {
        this.small = in.readString();
        this.large = in.readString();
        this.medium = in.readString();
    }

    public static final Creator<Images> CREATOR = new Creator<Images>() {
        @Override
        public Images createFromParcel(Parcel source) {
            return new Images(source);
        }

        @Override
        public Images[] newArray(int size) {
            return new Images[size];
        }
    };
}