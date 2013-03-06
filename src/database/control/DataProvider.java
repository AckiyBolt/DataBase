package database.control;

import database.entity.Column;
import database.entity.DataBase;
import database.entity.Entity;
import database.entity.Table;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class DataProvider {

    private boolean isMock;
    private DataBase db;
    private Map<String, Table> tblCache;

    public DataProvider ( DataBase db, boolean isMock ) {
        this.isMock = isMock;
        this.db = db;
        this.tblCache = new HashMap<String, Table>();
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

    public List<String> getTablesNames () {
        List<String> names = new LinkedList<String>();

        for ( Table table : getTables() ) {
            names.add( table.getName() );
        }
        return names;
    }
    
    public List<String> getPkValues ( String tableName ){
        
        List<String> result = new ArrayList<String>();
        
        Table table = findTable( tableName );
        Column primaryKeyColumn = table.getPrimaryKey();
        List<Entity> data = table.getData();
        
        for ( Entity entity : data ) {
            result.add( entity.getProperties().get( primaryKeyColumn.getName() ) );
        }
        
        return result;
    }

    public boolean isMock () {
        return isMock;
    }

    void setDB ( DataBase db ) {
        tblCache.clear();
        this.db = db;
        isMock = false;
    }
}
