package database.control;

import database.entity.Table;
import database.model.table.MetadataTableModel;
import database.model.list.MyListModel;
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

    public List<Table> getTables () {
        return holder.getProvider().getTables();
    }

    public void addTable ( Table table, MyListModel<Table> model ) {
        getTables().add( table );
        model.updateWhenAdded();
    }

    public void delTable ( Table table, MyListModel<Table> model ) {
        holder.getProvider().getTables().remove( table );
        model.updateWhenRemoved();
    }
}