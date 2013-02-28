package database.gui.table;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public abstract class AbstractMyTableModel<T>
        extends DefaultTableModel {

    protected List<String[]> data;
    protected int columnCount;

    public AbstractMyTableModel ( String[] columns, int columnCount ) {
        this.setColumnIdentifiers( columns );
        this.columnCount = columnCount;
        data = new ArrayList<String[]>();
    }

    @Override
    public int getRowCount () {
        return data == null ?
               0 :
               data.size();
    }

    @Override
    public int getColumnCount () {
        return columnCount;
    }

    @Override
    public Object getValueAt ( int rowIndex, int columnIndex ) {
        return data.get( rowIndex )[columnIndex];
    }

    @Override
    public void setValueAt ( Object value, int row, int column ) {
        data.get( row )[column] = value.toString();
        fireTableCellUpdated( row, column );
    }

    protected void update () {
        fireTableRowsInserted( 0, data.size() );
    }

    public abstract List<T> getData ();

    public abstract void addValues ( List<T> values );

    public abstract void addValue ( T value );
    
    public void clear () {
        data.clear();
    }
}