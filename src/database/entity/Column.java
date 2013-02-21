package database.entity;

import java.util.Objects;

public class Column {

    private String name;
    // if it's a primitive
    private ColumnType simpleType;
    // if it's an another table here we will have its name
    private String complexType;

    public Column ( String name ) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public ColumnType getSimpleType () {
        return simpleType;
    }

    public void setSimpleType ( ColumnType simpleType ) {
        this.simpleType = simpleType;
    }

    public String getComplexType () {
        return complexType;
    }

    public void setComplexType ( String complexType ) {
        this.complexType = complexType;
    }

    @Override
    public int hashCode () {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode( this.name );
        return hash;
    }

    @Override
    public boolean equals ( Object obj ) {
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        final Column other = ( Column ) obj;
        if ( !Objects.equals( this.name, other.name ) )
            return false;
        return true;
    }
}