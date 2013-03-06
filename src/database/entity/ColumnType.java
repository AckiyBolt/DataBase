package database.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public enum ColumnType {

    INTEGER( "\\d*" ),
    DOUBLE("(\\d+.\\d+)?"),
    STRING( ".*" ),
    BOOL( "(true|false)?" ),
    DATE( "(\\d{2}.\\d{2}.\\d{4})*" ),
    LIST( "^\\[(([\\wа-яА-Я]+, )*[\\wа-яА-Я]+)?\\]$" );

    private ColumnType ( String regexp ) {
        this.regexp = regexp;
    }
    private String regexp;

    public boolean isValid ( String value ) {

        if ( value == null )
            value = "";

        boolean result = value.matches( regexp );

        if ( this == DATE )
            result = validateDate( value ) && result;

        return result;
    }

    private boolean validateDate ( String value ) {

        boolean result = false;

        try {
            SimpleDateFormat df = new SimpleDateFormat( "dd.MM.yyyy" );
            df.setLenient( false );
            df.parse( value );
            result = true;
        } catch ( ParseException e ) {
        } finally {
            return result;
        }
    }

    @Override
    public String toString () {
        return this.name();
    }
}
