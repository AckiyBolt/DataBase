package database;

import database.entity.Column;
import database.entity.Entity;
import database.entity.Table;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author T@urus
 */
public class EntityTableModel
        extends AbstractTableModel {

    private Table table;

    public EntityTableModel ( Table table ) {
        this.table = table;
    }

    @Override
    public int getRowCount () {
        return table.getData().size();
    }

    @Override
    public int getColumnCount () {
        return table.getColumns().size();
    }

    @Override
    public Object getValueAt ( int rowIndex, int columnIndex ) {

        Entity row = table.getData().get( rowIndex );
        Column col = table.getColumns().get( columnIndex );

        return row.getProperties().get( col.getName() );
    }

    @Override
    public String getColumnName ( int column ) {
        return table.getColumns().get( column ).getName();
    }

    @Override
    public void setValueAt ( Object aValue, int rowIndex, int columnIndex ) {
        super.setValueAt( aValue, rowIndex, columnIndex );
    }
}