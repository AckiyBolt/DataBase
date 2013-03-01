package database.model.list;

import database.gui.UpdatableModel;
import java.util.Collections;
import java.util.List;
import javax.swing.AbstractListModel;

public class MyListModel<T>
        extends AbstractListModel
        implements UpdatableModel {

    protected List<T> data;

    public MyListModel () {
        this.data = Collections.EMPTY_LIST;
    }

    public MyListModel ( List<T> data ) {
        this.data = data == null ?
                    Collections.EMPTY_LIST :
                    data;
    }

    public final void updateData ( List<T> data ) {

        if ( data == null )
            throw new NullPointerException( "Null isn't allowe here" );

        this.data = data;

    }

    @Override
    public int getSize () {
        return data.size();
    }

    @Override
    public T getElementAt ( int index ) {
        
        T result = null;
        
        try {
            result = data.get( index );
        } catch ( IndexOutOfBoundsException ex ) {
        } finally {
            return result;
        }
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

    public void clear () {
        this.data.clear();
    }
}
