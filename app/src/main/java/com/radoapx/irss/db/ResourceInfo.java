package com.radoapx.irss.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDatabase.class)
public class ResourceInfo extends BaseModel {
    @PrimaryKey
    int id;

    @Column
    String name;

    @Column
    String remark;
}
