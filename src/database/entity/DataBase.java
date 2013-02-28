package database.entity;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataBase {

    private String name;
    private List<Table> tables;

    public DataBase ( String name ) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public List<Table> getTables () {

        if ( tables == null )
            tables = new ArrayList<Table>();
        return tables;
    }

    public void setTables ( List<Table> tables ) {
        this.tables = tables;
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

    @Override
    public String toString () {
        return name;
    }
}