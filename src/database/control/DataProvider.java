package database.control;

import database.entity.Column;
import database.entity.DataBase;
import database.entity.Entity;
import database.entity.Table;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DataProvider {

    private DataBase db;
    private Map<String, Table> tblCache;
    private Map<String, Column> colCache;
    private Map<String, Entity> entCache;

    public DataProvider ( DataBase db ) {
        this.db = db;
        tblCache = new HashMap<String, Table>();
        colCache = new HashMap<String, Column>();
        entCache = new HashMap<String, Entity>();
    }

    public DataBase getDB () {
        return db;
    }

    public List<Table> getTables () {
        return getDB().getTables();
    }

    public List<Column> getColumns ( String tableName ) {
        return findTable( tableName ).getColumns();
    }

    public List<Entity> getEntities ( String tableName ) {
        return findTable( tableName ).getData();
    }

    public Table findTable ( String tableName ) {
        
        Table result = tblCache.get( tableName );
        
        if ( result == null ) {
            for ( Table table : getTables() ) {
                if ( table.getName().equals( tableName ) ) {
                    result = table;
                    tblCache.put( tableName, table );
                    break;
                }
            }
        }
        return result;
    }
}
