package database.control;

import database.entity.Column;
import database.model.table.MetadataTableModel;
import java.util.List;

public class ColumnController {

    private ControllersHolder holder;
    
    ColumnController ( ControllersHolder holder ) {
        this.holder = holder;
    }

    public void updateMetadataTableModel ( MetadataTableModel model, String columnName ) {
        model.clear();
        model.addValues( getColumns(columnName) );
        model.updateWhenAdded();
    }

    List<Column> getColumns (String tableName) {
        return holder.getProvider().findTable( tableName ).getColumns();
    }

}
