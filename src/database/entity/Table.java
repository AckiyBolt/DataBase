package database.entity;

import java.util.ArrayList;
import java.util.List;

public class Table {
    
    private String name;
    private List<Column> columns;
    private Column primaryKey;
    private List<Entity> data;

    public List<Entity> getData () {
        return data;
    }

    public void setData ( List<Entity> data ) {
        this.data = data;
    }

    public Table ( String name ) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public List<Column> getColumns () {
        if ( columns == null )
            columns = new ArrayList<Column>();
        return columns;
    }

    public void setColumns ( List<Column> columns ) {
        this.columns = columns;
    }

    public Column getPrimaryKey () {
        return primaryKey;
    }

    public void setPrimaryKey ( Column primaryKey ) {
        this.primaryKey = primaryKey;
    }

    @Override
    public int hashCode () {
        int hash = 3;
        hash = 67 * hash + this.name.hashCode();
        return hash;
    }

    @Override
    public boolean equals ( Object obj ) {
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        final Table other = ( Table ) obj;
        if ( !other.name.equals( this.name ) )
            return false;
        return true;
    }

    @Override
    public String toString () {
        return name;
    }
}