package com.yomii.librarydemos.rxretrofit.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * 图书
 * Created by Yomii on 2017/3/28.
 */

public class Book implements Cover {


    /**
     * rating : {"max":10,"numRaters":260651,"average":"8.8","min":0}
     * subtitle :
     * author : ["[美] 卡勒德·胡赛尼"]
     * pubdate : 2006-5
     * tags : [{"count":57739,"name":"追风筝的人","title":"追风筝的人"},{"count":40280,"name":"阿富汗","title":"阿富汗"},{"count":39947,"name":"人性","title":"人性"},{"count":37159,"name":"救赎","title":"救赎"},{"count":35689,"name":"小说","title":"小说"},{"count":26302,"name":"卡勒德·胡赛尼","title":"卡勒德·胡赛尼"},{"count":25271,"name":"外国文学","title":"外国文学"},{"count":13786,"name":"外国小说","title":"外国小说"}]
     * origin_title : The Kite Runner
     * image : https://img3.doubanio.com/mpic/s1727290.jpg
     * binding : 平装
     * translator : ["李继宏"]
     * catalog : 第一章
     * 第二章
     * 第三章
     * 第四章
     * 第五章
     * 第六章
     * 第七章
     * 第八章
     * 第九章
     * 第十章
     * 第十一章
     * 第十二章
     * 第十三章
     * 第十四章
     * 第十五章
     * 第十六章
     * 第十七章
     * 第十八章
     * 第十九章
     * 第二十章
     * 第二十一章
     * 第二十二章
     * 第二十三章
     * 第二十四章
     * 第二十五章
     * 译后记
     * ebook_url : https://read.douban.com/ebook/1162265/
     * pages : 362
     * images : {"small":"https://img3.doubanio.com/spic/s1727290.jpg","large":"https://img3.doubanio.com/lpic/s1727290.jpg","medium":"https://img3.doubanio.com/mpic/s1727290.jpg"}
     * alt : https://book.douban.com/subject/1770782/
     * id : 1770782
     * publisher : 上海人民出版社
     * isbn10 : 7208061645
     * isbn13 : 9787208061644
     * title : 追风筝的人
     * url : https://api.douban.com/v2/book/1770782
     * alt_title : The Kite Runner
     * author_intro : 卡勒德·胡赛尼（Khaled Hosseini），1965年生于阿富汗喀布尔市，后随父亲迁往美国。胡赛尼毕业于加州大学圣地亚哥医学系，现居加州。“立志拂去蒙在阿富汗普通民众面孔的尘灰，将背后灵魂的悸动展示给世人。”著有小说《追风筝的人》(The Kite Runner，2003）、《灿烂千阳》(A Thousand Splendid Suns，2007)、《群山回唱》（And the Mountains Echoed,2013）。作品全球销量超过4000万册。2006年，因其作品巨大的国际影响力，胡赛尼获得联合国人道主义奖，并受邀担任联合国难民署亲善大使。
     * summary : 12岁的阿富汗富家少爷阿米尔与仆人哈桑情同手足。然而，在一场风筝比赛后，发生了一件悲惨不堪的事，阿米尔为自己的懦弱感到自责和痛苦，逼走了哈桑，不久，自己也跟随父亲逃往美国。
     * 成年后的阿米尔始终无法原谅自己当年对哈桑的背叛。为了赎罪，阿米尔再度踏上暌违二十多年的故乡，希望能为不幸的好友尽最后一点心力，却发现一个惊天谎言，儿时的噩梦再度重演，阿米尔该如何抉择？
     * 故事如此残忍而又美丽，作者以温暖细腻的笔法勾勒人性的本质与救赎，读来令人荡气回肠。
     * ebook_price : 12.99
     * series : {"id":"19760","title":"卡勒德·胡赛尼作品"}
     * price : 29.00元
     */

    private Rating rating;
    private String subtitle;
    private String pubdate;
    private String origin_title;
    private String image;
    private String binding;
    private String catalog;
    private String ebook_url;
    private String pages;
    private Images images;
    private String alt;
    private String id;
    private String publisher;
    private String isbn10;
    private String isbn13;
    private String title;
    private String url;
    private String alt_title;
    private String author_intro;
    private String summary;
    private String ebook_price;
    private Series series;
    private String price;
    private List<String> author;
    private List<Tags> tags;
    private List<String> translator;

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getOrigin_title() {
        return origin_title;
    }

    public void setOrigin_title(String origin_title) {
        this.origin_title = origin_title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getEbook_url() {
        return ebook_url;
    }

    public void setEbook_url(String ebook_url) {
        this.ebook_url = ebook_url;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    @Override
    public String getCoverUrl() {
        Images images = getImages();
        return images == null ? null : images.getLarge();
    }

    @Override
    public double getRatingValue() {
        Rating rating = getRating();
        if (rating != null)
            return rating.getRating();
        return 0;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlt_title() {
        return alt_title;
    }

    public void setAlt_title(String alt_title) {
        this.alt_title = alt_title;
    }

    public String getAuthor_intro() {
        return author_intro;
    }

    public void setAuthor_intro(String author_intro) {
        this.author_intro = author_intro;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getEbook_price() {
        return ebook_price;
    }

    public void setEbook_price(String ebook_price) {
        this.ebook_price = ebook_price;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public List<String> getTranslator() {
        return translator;
    }

    public void setTranslator(List<String> translator) {
        this.translator = translator;
    }

    public static class Series implements Parcelable {
        /**
         * id : 19760
         * title : 卡勒德·胡赛尼作品
         */

        private String id;
        private String title;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.id);
            dest.writeString(this.title);
        }

        public Series() {
        }

        protected Series(Parcel in) {
            this.id = in.readString();
            this.title = in.readString();
        }

        public static final Creator<Series> CREATOR = new Creator<Series>() {
            @Override
            public Series createFromParcel(Parcel source) {
                return new Series(source);
            }

            @Override
            public Series[] newArray(int size) {
                return new Series[size];
            }
        };
    }

    public static class Tags {
        /**
         * count : 57739
         * name : 追风筝的人
         * title : 追风筝的人
         */

        private int count;
        private String name;
        private String title;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.rating, flags);
        dest.writeString(this.subtitle);
        dest.writeString(this.pubdate);
        dest.writeString(this.origin_title);
        dest.writeString(this.image);
        dest.writeString(this.binding);
        dest.writeString(this.catalog);
        dest.writeString(this.ebook_url);
        dest.writeString(this.pages);
        dest.writeParcelable(this.images, flags);
        dest.writeString(this.alt);
        dest.writeString(this.id);
        dest.writeString(this.publisher);
        dest.writeString(this.isbn10);
        dest.writeString(this.isbn13);
        dest.writeString(this.title);
        dest.writeString(this.url);
        dest.writeString(this.alt_title);
        dest.writeString(this.author_intro);
        dest.writeString(this.summary);
        dest.writeString(this.ebook_price);
        dest.writeParcelable(this.series, flags);
        dest.writeString(this.price);
        dest.writeStringList(this.author);
        dest.writeList(this.tags);
        dest.writeStringList(this.translator);
    }

    public Book() {
    }

    protected Book(Parcel in) {
        this.rating = in.readParcelable(Rating.class.getClassLoader());
        this.subtitle = in.readString();
        this.pubdate = in.readString();
        this.origin_title = in.readString();
        this.image = in.readString();
        this.binding = in.readString();
        this.catalog = in.readString();
        this.ebook_url = in.readString();
        this.pages = in.readString();
        this.images = in.readParcelable(Images.class.getClassLoader());
        this.alt = in.readString();
        this.id = in.readString();
        this.publisher = in.readString();
        this.isbn10 = in.readString();
        this.isbn13 = in.readString();
        this.title = in.readString();
        this.url = in.readString();
        this.alt_title = in.readString();
        this.author_intro = in.readString();
        this.summary = in.readString();
        this.ebook_price = in.readString();
        this.series = in.readParcelable(Series.class.getClassLoader());
        this.price = in.readString();
        this.author = in.createStringArrayList();
        this.tags = new ArrayList<>();
        in.readList(this.tags, Tags.class.getClassLoader());
        this.translator = in.createStringArrayList();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public String toString() {
        return "Book{" +
                "rating=" + rating +
                ", subtitle='" + subtitle + '\'' +
                ", pubdate='" + pubdate + '\'' +
                ", origin_title='" + origin_title + '\'' +
                ", image='" + image + '\'' +
                ", binding='" + binding + '\'' +
                ", catalog='" + catalog + '\'' +
                ", ebook_url='" + ebook_url + '\'' +
                ", pages='" + pages + '\'' +
                ", images=" + images +
                ", alt='" + alt + '\'' +
                ", id='" + id + '\'' +
                ", publisher='" + publisher + '\'' +
                ", isbn10='" + isbn10 + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", alt_title='" + alt_title + '\'' +
                ", author_intro='" + author_intro + '\'' +
                ", summary='" + summary + '\'' +
                ", ebook_price='" + ebook_price + '\'' +
                ", series=" + series +
                ", price='" + price + '\'' +
                ", author=" + author +
                ", tags=" + tags +
                ", translator=" + translator +
                '}';
    }
}
