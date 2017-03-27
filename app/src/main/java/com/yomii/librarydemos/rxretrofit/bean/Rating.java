package com.yomii.librarydemos.rxretrofit.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 星级
 */
public class Rating implements Parcelable {
        /**
         * max : 10
         * average : 7.5
         * stars : 40
         * min : 0
         */

        private int max;
        private double average;
        private String stars;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public double getRating(){
            if (max == 0)
                return 0;
            return average / max;
        }

    @Override
    public String toString() {
        return "Rating{" +
                "max=" + max +
                ", average=" + average +
                ", stars='" + stars + '\'' +
                ", min=" + min +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.max);
        dest.writeDouble(this.average);
        dest.writeString(this.stars);
        dest.writeInt(this.min);
    }

    public Rating() {
    }

    protected Rating(Parcel in) {
        this.max = in.readInt();
        this.average = in.readDouble();
        this.stars = in.readString();
        this.min = in.readInt();
    }

    public static final Creator<Rating> CREATOR = new Creator<Rating>() {
        @Override
        public Rating createFromParcel(Parcel source) {
            return new Rating(source);
        }

        @Override
        public Rating[] newArray(int size) {
            return new Rating[size];
        }
    };
}