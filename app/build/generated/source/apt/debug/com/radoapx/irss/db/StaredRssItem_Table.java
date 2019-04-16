package com.radoapx.irss.db;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import java.lang.Class;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Number;
import java.lang.Override;
import java.lang.String;

/**
 * This is generated code. Please do not modify */
public final class StaredRssItem_Table extends ModelAdapter<StaredRssItem> {
  /**
   * Primary Key AutoIncrement */
  public static final Property<Integer> Id = new Property<Integer>(StaredRssItem.class, "Id");

  public static final Property<String> title = new Property<String>(StaredRssItem.class, "title");

  public static final Property<String> link = new Property<String>(StaredRssItem.class, "link");

  public static final Property<String> pubDate = new Property<String>(StaredRssItem.class, "pubDate");

  public static final Property<String> description = new Property<String>(StaredRssItem.class, "description");

  public static final Property<String> category = new Property<String>(StaredRssItem.class, "category");

  public static final Property<Integer> isStared = new Property<Integer>(StaredRssItem.class, "isStared");

  public static final Property<Integer> from = new Property<Integer>(StaredRssItem.class, "from");

  public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{Id,title,link,pubDate,description,category,isStared,from};

  public StaredRssItem_Table(DatabaseDefinition databaseDefinition) {
    super(databaseDefinition);
  }

  @Override
  public final Class<StaredRssItem> getModelClass() {
    return StaredRssItem.class;
  }

  @Override
  public final String getTableName() {
    return "`StaredRssItem`";
  }

  @Override
  public final StaredRssItem newInstance() {
    return new StaredRssItem();
  }

  @Override
  public final Property getProperty(String columnName) {
    columnName = QueryBuilder.quoteIfNeeded(columnName);
    switch ((columnName)) {
      case "`Id`":  {
        return Id;
      }
      case "`title`":  {
        return title;
      }
      case "`link`":  {
        return link;
      }
      case "`pubDate`":  {
        return pubDate;
      }
      case "`description`":  {
        return description;
      }
      case "`category`":  {
        return category;
      }
      case "`isStared`":  {
        return isStared;
      }
      case "`from`":  {
        return from;
      }
      default: {
        throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
      }
    }
  }

  @Override
  public final void updateAutoIncrement(StaredRssItem model, Number id) {
    model.Id = id.intValue();
  }

  @Override
  public final Number getAutoIncrementingId(StaredRssItem model) {
    return model.Id;
  }

  @Override
  public final String getAutoIncrementingColumnName() {
    return "Id";
  }

  @Override
  public final IProperty[] getAllColumnProperties() {
    return ALL_COLUMN_PROPERTIES;
  }

  @Override
  public final void bindToInsertValues(ContentValues values, StaredRssItem model) {
    values.put("`title`", model.title != null ? model.title : null);
    values.put("`link`", model.link != null ? model.link : null);
    values.put("`pubDate`", model.pubDate != null ? model.pubDate : null);
    values.put("`description`", model.description != null ? model.description : null);
    values.put("`category`", model.category != null ? model.category : null);
    values.put("`isStared`", model.isStared);
    values.put("`from`", model.from);
  }

  @Override
  public final void bindToContentValues(ContentValues values, StaredRssItem model) {
    values.put("`Id`", model.Id);
    bindToInsertValues(values, model);
  }

  @Override
  public final void bindToInsertStatement(DatabaseStatement statement, StaredRssItem model,
      int start) {
    statement.bindStringOrNull(1 + start, model.title);
    statement.bindStringOrNull(2 + start, model.link);
    statement.bindStringOrNull(3 + start, model.pubDate);
    statement.bindStringOrNull(4 + start, model.description);
    statement.bindStringOrNull(5 + start, model.category);
    statement.bindLong(6 + start, model.isStared);
    statement.bindLong(7 + start, model.from);
  }

  @Override
  public final void bindToStatement(DatabaseStatement statement, StaredRssItem model) {
    int start = 0;
    statement.bindLong(1 + start, model.Id);
    bindToInsertStatement(statement, model, 1);
  }

  @Override
  public final void bindToUpdateStatement(DatabaseStatement statement, StaredRssItem model) {
    statement.bindLong(1, model.Id);
    statement.bindStringOrNull(2, model.title);
    statement.bindStringOrNull(3, model.link);
    statement.bindStringOrNull(4, model.pubDate);
    statement.bindStringOrNull(5, model.description);
    statement.bindStringOrNull(6, model.category);
    statement.bindLong(7, model.isStared);
    statement.bindLong(8, model.from);
    statement.bindLong(9, model.Id);
  }

  @Override
  public final void bindToDeleteStatement(DatabaseStatement statement, StaredRssItem model) {
    statement.bindLong(1, model.Id);
  }

  @Override
  public final String getInsertStatementQuery() {
    return "INSERT INTO `StaredRssItem`(`title`,`link`,`pubDate`,`description`,`category`,`isStared`,`from`) VALUES (?,?,?,?,?,?,?)";
  }

  @Override
  public final String getCompiledStatementQuery() {
    return "INSERT INTO `StaredRssItem`(`Id`,`title`,`link`,`pubDate`,`description`,`category`,`isStared`,`from`) VALUES (?,?,?,?,?,?,?,?)";
  }

  @Override
  public final String getUpdateStatementQuery() {
    return "UPDATE `StaredRssItem` SET `Id`=?,`title`=?,`link`=?,`pubDate`=?,`description`=?,`category`=?,`isStared`=?,`from`=? WHERE `Id`=?";
  }

  @Override
  public final String getDeleteStatementQuery() {
    return "DELETE FROM `StaredRssItem` WHERE `Id`=?";
  }

  @Override
  public final String getCreationQuery() {
    return "CREATE TABLE IF NOT EXISTS `StaredRssItem`(`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `title` TEXT, `link` TEXT, `pubDate` TEXT, `description` TEXT, `category` TEXT, `isStared` INTEGER, `from` INTEGER)";
  }

  @Override
  public final void loadFromCursor(FlowCursor cursor, StaredRssItem model) {
    model.Id = cursor.getIntOrDefault("Id");
    model.title = cursor.getStringOrDefault("title");
    model.link = cursor.getStringOrDefault("link");
    model.pubDate = cursor.getStringOrDefault("pubDate");
    model.description = cursor.getStringOrDefault("description");
    model.category = cursor.getStringOrDefault("category");
    model.isStared = cursor.getIntOrDefault("isStared");
    model.from = cursor.getIntOrDefault("from");
  }

  @Override
  public final boolean exists(StaredRssItem model, DatabaseWrapper wrapper) {
    return model.Id > 0
    && SQLite.selectCountOf()
    .from(StaredRssItem.class)
    .where(getPrimaryConditionClause(model))
    .hasData(wrapper);
  }

  @Override
  public final OperatorGroup getPrimaryConditionClause(StaredRssItem model) {
    OperatorGroup clause = OperatorGroup.clause();
    clause.and(Id.eq(model.Id));
    return clause;
  }
}
