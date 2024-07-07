package domain;

public interface AbstractDomainObject {

    String getTableName();

    String getColumnNamesForInsert();

    String getInsertValues();

    void setId(long id);

    String getUpdateValues();

    String getJoinText();

    String getSelectedText();

    String getID();

}
