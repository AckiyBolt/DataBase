package database.control;

import database.entity.Table;
import database.gui.table.MetadataTableModel;
import database.gui.table.list.MyListModel;
import java.util.Collections;
import java.util.List;

public class TableController {

    private ControllersHolder holder;

    TableController ( ControllersHolder holder ) {
        this.holder = holder;
    }

    public void updateTablesListModel ( MyListModel<Table> model ) {
        model.updateData( getTables() );
        model.updateWhenAdded();
    }
    
    public Table getTable ( String name ) {
        return holder.getProvider().findTable( name );
    }

    List<Table> getTables () {
        return holder.getProvider().getTables();
    }
}
