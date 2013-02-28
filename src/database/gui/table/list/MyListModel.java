package database.gui.table.list;

import database.gui.UpdatableModel;
import java.util.List;
import javax.swing.AbstractListModel;

public class MyListModel<T>
        extends AbstractListModel<T>
        implements UpdatableModel {

    protected List<T> data;

    public MyListModel ( List<T> data ) {
        this.data = data;
    }

    @Override
    public int getSize () {
        return data.size();
    }

    @Override
    public T getElementAt ( int index ) {
        return data.get( index );
    }

    @Override
    public void updateWhenChanged () {
        this.fireContentsChanged( this, 0, data.size() );
    }

    @Override
    public void updateWhenAdded () {
        this.fireIntervalAdded( this, 0, data.size() );
    }

    @Override
    public void updateWhenRemoved () {
        this.fireIntervalRemoved( this, 0, data.size() );
    }
}
