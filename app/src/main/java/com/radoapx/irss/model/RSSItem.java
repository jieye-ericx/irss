package com.radoapx.irss.model;

/**
 * Created by Administrator on 2019/3/28.
 */
public class RSSItem {


    public static final String TITLE = "title";      //定义两个常量用于显示在listview上的
    public static final String PUBDATE = "pubDate";

    private String title = null;   //新闻标题
    private String link = null;    //新闻链接
    private String pubDate = null;  //新闻发布时间
    private String description = null;  //新闻描述
    private String category = null;     //新闻类别
    private String isStared;

    public String getIsStared() {
        return isStared;
    }

    public void setIsStared(String isStared) {
        this.isStared = isStared;
    }

    public RSSItem(String title, String description){
        this.title = title;
        this.description = description;
    }
    public RSSItem(){
    }


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {return pubDate;}
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }


}