package com.yomii.librarydemos.rxretrofit.bean;

import java.util.List;

/**
 * Created by Yomii on 2017/3/22.
 */

public class Movie {


    /**
     * rating : {"max":10,"average":7.5,"stars":"40","min":0}
     * genres : ["爱情","奇幻","歌舞"]
     * title : 美女与野兽
     * casts : [{"alt":"https://movie.douban.com/celebrity/1053624/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/10321.jpg","large":"http://img7.doubanio.com/img/celebrity/large/10321.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/10321.jpg"},"name":"艾玛·沃森","id":"1053624"},{"alt":"https://movie.douban.com/celebrity/1027527/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/1359042267.71.jpg","large":"http://img7.doubanio.com/img/celebrity/large/1359042267.71.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/1359042267.71.jpg"},"name":"丹·史蒂文斯","id":"1027527"},{"alt":"https://movie.douban.com/celebrity/1276136/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/36425.jpg","large":"http://img7.doubanio.com/img/celebrity/large/36425.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/36425.jpg"},"name":"卢克·伊万斯","id":"1276136"}]
     * collect_count : 66106
     * original_title : Beauty and the Beast
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1027245/","avatars":{"small":"http://img7.doubanio.com/img/celebrity/small/42170.jpg","large":"http://img7.doubanio.com/img/celebrity/large/42170.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/42170.jpg"},"name":"比尔·康顿","id":"1027245"}]
     * year : 2017
     * images : {"small":"http://img7.doubanio.com/view/movie_poster_cover/ipst/public/p2417948644.jpg","large":"http://img7.doubanio.com/view/movie_poster_cover/lpst/public/p2417948644.jpg","medium":"http://img7.doubanio.com/view/movie_poster_cover/spst/public/p2417948644.jpg"}
     * alt : https://movie.douban.com/subject/25900945/
     * id : 25900945
     */

    private Rating rating;
    private String title;
    private int collect_count;
    private String original_title;
    private String subtype;
    private String year;
    private Images images;
    private String alt;
    private String id;
    private List<String> genres;
    private List<Casts> casts;
    private List<Directors> directors;

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<Casts> getCasts() {
        return casts;
    }

    public void setCasts(List<Casts> casts) {
        this.casts = casts;
    }

    public List<Directors> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Directors> directors) {
        this.directors = directors;
    }

    public static class Casts {
        /**
         * alt : https://movie.douban.com/celebrity/1053624/
         * avatars : {"small":"http://img7.doubanio.com/img/celebrity/small/10321.jpg","large":"http://img7.doubanio.com/img/celebrity/large/10321.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/10321.jpg"}
         * name : 艾玛·沃森
         * id : 1053624
         */

        private String alt;
        private Images avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public Images getAvatars() {
            return avatars;
        }

        public void setAvatars(Images avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class Directors {
        /**
         * alt : https://movie.douban.com/celebrity/1027245/
         * avatars : {"small":"http://img7.doubanio.com/img/celebrity/small/42170.jpg","large":"http://img7.doubanio.com/img/celebrity/large/42170.jpg","medium":"http://img7.doubanio.com/img/celebrity/medium/42170.jpg"}
         * name : 比尔·康顿
         * id : 1027245
         */

        private String alt;
        private Images avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public Images getAvatars() {
            return avatars;
        }

        public void setAvatars(Images avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
