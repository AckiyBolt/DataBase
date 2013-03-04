package database.model.table;

import database.entity.Column;
import database.entity.Entity;
import database.entity.Table;
import java.util.Enumeration;
import java.util.List;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class EntityTableModel
        extends AbstractMyTableModel<Entity> {

    private Table table;
    
    public EntityTableModel ( Table table ) {
        super( table.getColumns().size() );
        String[] columns = initColIdentifiers( table );
        this.setColumnIdentifiers( columns );
        this.table = table;
    }

    @Override
    public List<Entity> getData () {
        throw new UnsupportedOperationException( "Not supported yet." );
    }

    @Override
    public void addValues ( List<Entity> values ) {
        for ( Entity entity : values ) {
            addItem( entity );
        }
        updateWhenAdded();
    }

    @Override
    public void addValue ( Entity value ) {
        addItem( value );
        updateWhenAdded();
    }

    private void addItem ( Entity entity ) {

        if ( entity == null )
            return;
        String[] row = new String[ table.getColumns().size() ];
        int index = -1;

        for ( Column col : table.getColumns() ) {

            String id = col.getName();
            String value = entity.getProperties().get( id );

            row[++index] = value;
        }

        data.add( row );
    }

    public String[] initColIdentifiers ( Table table ) {

        String[] columns = new String[ table.getColumns().size() ];
        int index = -1;

        for ( Column col : table.getColumns() ) {
            String type = col.getComplexType() == null ?
                          col.getSimpleType().name() :
                          col.getComplexType();
            String pk = col.getPrimaryKey() ?
                        " [ПК]" :
                        "";
            
            columns[++index] = col.getName() + " : " + type + pk;
        }

        return columns;
    }
}