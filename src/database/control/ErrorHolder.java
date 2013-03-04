package database.control;

import java.util.LinkedList;
import java.util.List;

public class ErrorHolder {

    private List<String> errors;

    public ErrorHolder () {
        errors = new LinkedList<String>();
    }

    public void addError ( String error ) {
        errors.add( error );
    }

    public String getMessageAndClearErrors () {
        String message = getMessage();
        errors.clear();
        return message;
    }

    public String getMessage () {
        StringBuilder sb = new StringBuilder();
        String nl = "\n";

        for ( String err : errors ) {
            sb.append( err ).append( nl );
        }

        return sb.toString();
    }
}