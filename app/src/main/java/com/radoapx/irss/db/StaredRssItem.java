package com.radoapx.irss.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.io.Serializable;

@Table(database = MyDatabase.class)
public class StaredRssItem extends BaseModel implements Serializable {
    @PrimaryKey(autoincrement = true)
    int Id;

    @Column
    String title ; //新闻标题

    @Column
    String link ; //新闻链接

    @Column
    String pubDate ;  //新闻发布时间

    @Column
    String description;  //新闻描述

    @Column
    String category ;//新闻类别

    @Column
    int isStared;//是否被收藏

    @Column
    int from;

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getIsStared() {
        return isStared;
    }

    public void setIsStared(int isStared) {
        this.isStared = isStared;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descriptionull) {
        this.description = descriptionull;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
