package database.entity;

import java.util.Objects;
import java.util.Set;

public class DataBase {

    private String name;
    private Set<Table> tables;
    private Set<Entity> data;

    public DataBase ( String name ) {
        this.name = name;
    }
    
    public String getName () {
        return name;
    }

    public Set<Table> getTables () {
        return tables;
    }

    public void setTables ( Set<Table> tables ) {
        this.tables = tables;
    }

    public Set<Entity> getData () {
        return data;
    }

    public void setData ( Set<Entity> data ) {
        this.data = data;
    }

    @Override
    public int hashCode () {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode( this.name );
        return hash;
    }

    @Override
    public boolean equals ( Object obj ) {
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        final DataBase other = ( DataBase ) obj;
        if ( !Objects.equals( this.name, other.name ) )
            return false;
        return true;
    }
}
