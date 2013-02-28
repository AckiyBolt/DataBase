package database.gui.table.list;

import java.util.List;
import javax.swing.AbstractListModel;

public class MyListModel<T>
        extends AbstractListModel<T> {

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
    
    public void update() {
        this.fireIntervalAdded( this, 0, data.size() );
    }
}
