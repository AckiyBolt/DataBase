package database.entity;

public enum ColumnType {

    NUMBER( "\\d*" ),
    STRING( "[\\wа-яА-Я]*" ),
    BOOL( "(true|false)?" ),
    DATE( "\\d{2}.\\d{2}.\\d{4}" ),
    LIST( "^\\[(([\\wа-яА-Я]+, )*[\\wа-яА-Я]+)?\\]$" );

    private ColumnType ( String regexp ) {
        this.regexp = regexp;
    }
    private String regexp;

    public boolean isValid ( String value ) {
        if ( value == null )
            value = "";
        return value.matches( regexp );
    }

    @Override
    public String toString () {
        return this.name();
    }
}
