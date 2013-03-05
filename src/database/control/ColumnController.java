package database.control;

import database.entity.Column;
import database.entity.Table;
import database.model.table.MetadataTableModel;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ColumnController
        extends AbstractController {

    public ColumnController ( ControllersHolder holder ) {
        super( holder );
    }

    public void updateMetadataTableModel ( MetadataTableModel model, String columnName ) {

        if ( columnName == null || model == null )
            return;

        model.clear();
        model.addValues( getColumns( columnName ) );
        model.updateWhenAdded();
    }

    public void addColumn ( Column column, Table table, MetadataTableModel model ) {

        if ( column == null || table == null || model == null )
            return;

        List<Column> columns = holder.getProvider().getColumns( table.getName() );
        columns.add( column );
        if ( column.getPrimaryKey() )
            table.setPrimaryKey( column );

        model.clear();
        model.addValues( columns );
        model.updateWhenAdded();
    }

    public void delColumn ( int[] indexes, Table table, MetadataTableModel model ) {

        if ( indexes == null || table == null || model == null )
            return;

        List<Column> columns = holder.getProvider().getColumns( table.getName() );
        List<Column> columnsToDel = new LinkedList<Column>();

        for ( int i : indexes ) {
            Column column = columns.get( i );
            columnsToDel.add( column );
            if (column.getPrimaryKey())
                table.setPrimaryKey( null );
        }

        columns.removeAll( columnsToDel );

        model.clear();
        model.addValues( columns );
        model.updateWhenAdded();
    }

    List<Column> getColumns ( String tableName ) {
        return holder.getProvider().findTable( tableName ).getColumns();
    }
}