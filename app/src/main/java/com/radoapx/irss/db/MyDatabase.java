package com.radoapx.irss.db;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(version = MyDatabase.VERSION, name = MyDatabase.NAME)
public class MyDatabase {
    public static final String NAME="StarRssItem";
    public static final int VERSION=3;
}
