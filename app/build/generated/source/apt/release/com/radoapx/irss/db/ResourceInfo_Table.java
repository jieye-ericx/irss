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
import java.lang.Override;
import java.lang.String;

/**
 * This is generated code. Please do not modify */
public final class ResourceInfo_Table extends ModelAdapter<ResourceInfo> {
  /**
   * Primary Key */
  public static final Property<Integer> id = new Property<Integer>(ResourceInfo.class, "id");

  public static final Property<String> name = new Property<String>(ResourceInfo.class, "name");

  public static final Property<String> remark = new Property<String>(ResourceInfo.class, "remark");

  public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{id,name,remark};

  public ResourceInfo_Table(DatabaseDefinition databaseDefinition) {
    super(databaseDefinition);
  }

  @Override
  public final Class<ResourceInfo> getModelClass() {
    return ResourceInfo.class;
  }

  @Override
  public final String getTableName() {
    return "`ResourceInfo`";
  }

  @Override
  public final ResourceInfo newInstance() {
    return new ResourceInfo();
  }

  @Override
  public final Property getProperty(String columnName) {
    columnName = QueryBuilder.quoteIfNeeded(columnName);
    switch ((columnName)) {
      case "`id`":  {
        return id;
      }
      case "`name`":  {
        return name;
      }
      case "`remark`":  {
        return remark;
      }
      default: {
        throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
      }
    }
  }

  @Override
  public final IProperty[] getAllColumnProperties() {
    return ALL_COLUMN_PROPERTIES;
  }

  @Override
  public final void bindToInsertValues(ContentValues values, ResourceInfo model) {
    values.put("`id`", model.id);
    values.put("`name`", model.name != null ? model.name : null);
    values.put("`remark`", model.remark != null ? model.remark : null);
  }

  @Override
  public final void bindToInsertStatement(DatabaseStatement statement, ResourceInfo model,
      int start) {
    statement.bindLong(1 + start, model.id);
    statement.bindStringOrNull(2 + start, model.name);
    statement.bindStringOrNull(3 + start, model.remark);
  }

  @Override
  public final void bindToUpdateStatement(DatabaseStatement statement, ResourceInfo model) {
    statement.bindLong(1, model.id);
    statement.bindStringOrNull(2, model.name);
    statement.bindStringOrNull(3, model.remark);
    statement.bindLong(4, model.id);
  }

  @Override
  public final void bindToDeleteStatement(DatabaseStatement statement, ResourceInfo model) {
    statement.bindLong(1, model.id);
  }

  @Override
  public final String getCompiledStatementQuery() {
    return "INSERT INTO `ResourceInfo`(`id`,`name`,`remark`) VALUES (?,?,?)";
  }

  @Override
  public final String getUpdateStatementQuery() {
    return "UPDATE `ResourceInfo` SET `id`=?,`name`=?,`remark`=? WHERE `id`=?";
  }

  @Override
  public final String getDeleteStatementQuery() {
    return "DELETE FROM `ResourceInfo` WHERE `id`=?";
  }

  @Override
  public final String getCreationQuery() {
    return "CREATE TABLE IF NOT EXISTS `ResourceInfo`(`id` INTEGER, `name` TEXT, `remark` TEXT, PRIMARY KEY(`id`))";
  }

  @Override
  public final void loadFromCursor(FlowCursor cursor, ResourceInfo model) {
    model.id = cursor.getIntOrDefault("id");
    model.name = cursor.getStringOrDefault("name");
    model.remark = cursor.getStringOrDefault("remark");
  }

  @Override
  public final boolean exists(ResourceInfo model, DatabaseWrapper wrapper) {
    return SQLite.selectCountOf()
    .from(ResourceInfo.class)
    .where(getPrimaryConditionClause(model))
    .hasData(wrapper);
  }

  @Override
  public final OperatorGroup getPrimaryConditionClause(ResourceInfo model) {
    OperatorGroup clause = OperatorGroup.clause();
    clause.and(id.eq(model.id));
    return clause;
  }
}
