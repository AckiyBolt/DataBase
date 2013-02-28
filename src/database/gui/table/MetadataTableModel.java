package database.gui.table;

import database.entity.Column;
import database.entity.ColumnType;
import java.util.LinkedList;
import java.util.List;

public class MetadataTableModel
        extends AbstractMyTableModel<Column> {

    private static final String[] COLUMN_ARRAY = new String[] { "Назва", "Комплексний тип", "Простий тип", "ПК" };
    private static final int COL_COUNT = 4;

    public MetadataTableModel () {
        super( COLUMN_ARRAY, COL_COUNT );
    }

    @Override
    public List<Column> getData () {

        List<Column> result = new LinkedList<Column>();

        for ( String[] tbCol : data ) {

            Column col = new Column( tbCol[0] );

            col.setComplexType( tbCol[1] == null || tbCol[1].isEmpty() ?
                                null :
                                tbCol[1] );

            col.setSimpleType( tbCol[2] == null || tbCol[2].isEmpty() ?
                               null :
                               ColumnType.valueOf( tbCol[2] ) );

            col.setPrimaryKey( Boolean.valueOf( tbCol[3] ) );

            result.add( col );
        }

        return result;
    }

    @Override
    public final void addValues ( List<Column> columns ) {

        if ( columns == null )
            return;

        for ( Column column : columns ) {
            addItem( column );
        }

        updateWhenAdded();
    }

    @Override
    public final void addValue ( Column column ) {
        addItem( column );
        updateWhenAdded();
    }

    private void addItem ( Column column ) {

        if ( column == null )
            return;

        ColumnType simpleType = column.getSimpleType();
        Boolean pk = column.getPrimaryKey();

        data.add( new String[] {
                    column.getName(),
                    column.getComplexType(),
                    simpleType == null ?
                    null :
                    simpleType.toString(),
                    pk == null ?
                    null :
                    pk.toString()
                } );
    }
}
