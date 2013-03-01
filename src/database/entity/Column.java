package database.entity;

public class Column {

    private String name;
    // if it's a primitive
    private ColumnType simpleType;
    // if it's an another table here we will have its name
    private String complexType;
    private Boolean primaryKey;

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

    public Boolean getPrimaryKey () {
        return primaryKey;
    }

    public void setPrimaryKey ( Boolean primaryKey ) {
        this.primaryKey = primaryKey;
    }

    @Override
    public int hashCode () {
        int hash = 7;
        hash = 17 * hash + this.name.hashCode();
        return hash;
    }

    @Override
    public boolean equals ( Object obj ) {
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        final Column other = ( Column ) obj;
        if ( !other.name.equals( this.name ) )
            return false;
        return true;
    }

    @Override
    public String toString () {
        return name;
    }
}