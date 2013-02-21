package database.entity;

import java.util.Objects;
import java.util.Set;

public class Table {
    
    private String name;
    private Set<Column> columns;
    private Column primaryKey;

    public Table ( String name ) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public Set<Column> getColumns () {
        return columns;
    }

    public void setColumns ( Set<Column> columns ) {
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
        hash = 67 * hash + Objects.hashCode( this.name );
        return hash;
    }

    @Override
    public boolean equals ( Object obj ) {
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        final Table other = ( Table ) obj;
        if ( !Objects.equals( this.name, other.name ) )
            return false;
        return true;
    }
}
