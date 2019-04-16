package com.raizlabs.android.dbflow.config;

import com.radoapx.irss.db.MyDatabase;
import com.radoapx.irss.db.ResourceInfo_Table;
import com.radoapx.irss.db.StaredRssItem_Table;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;

/**
 * This is generated code. Please do not modify */
public final class MyDatabaseStarRssItem_Database extends DatabaseDefinition {
  public MyDatabaseStarRssItem_Database(DatabaseHolder holder) {
    addModelAdapter(new ResourceInfo_Table(this), holder);
    addModelAdapter(new StaredRssItem_Table(this), holder);
  }

  @Override
  public final Class<?> getAssociatedDatabaseClassFile() {
    return MyDatabase.class;
  }

  @Override
  public final boolean isForeignKeysSupported() {
    return false;
  }

  @Override
  public final boolean isInMemory() {
    return false;
  }

  @Override
  public final boolean backupEnabled() {
    return false;
  }

  @Override
  public final boolean areConsistencyChecksEnabled() {
    return false;
  }

  @Override
  public final int getDatabaseVersion() {
    return 3;
  }

  @Override
  public final String getDatabaseName() {
    return "StarRssItem";
  }
}
