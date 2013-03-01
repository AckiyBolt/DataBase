package database.model.combobox;

import database.gui.UpdatableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class MyComboBoxModel<T>
        extends DefaultComboBoxModel
        implements UpdatableModel {

    private List<T> data;

    public MyComboBoxModel () {
        data = new ArrayList<T>();
    }

    @Override
    public T getSelectedItem () {
        return ( T ) super.getSelectedItem();
    }

    @Override
    public int getSize () {
        return data.size();
    }

    @Override
    public Object getElementAt ( int index ) {
        return data.get( index );
    }

    @Override
    public void addElement ( Object value ) {
        data.add( ( T ) value );
        updateWhenAdded();
    }

    public void addElements ( List<T> values ) {
        data.addAll( values );
        updateWhenAdded();
    }
    
    @Override
    public void removeElementAt ( int index ) {
        data.remove( index );
        updateWhenRemoved();
    }

    @Override
    public void removeAllElements () {
        data.clear();
        updateWhenRemoved();
    }

    protected void update ( Object source, int index0, int index1 ) {
    }

    @Override
    public void updateWhenChanged () {
        super.fireContentsChanged( this, 0, data.size() );
    }

    @Override
    public void updateWhenAdded () {
        super.fireIntervalAdded( this, 0, data.size() );
    }

    @Override
    public void updateWhenRemoved () {
        super.fireIntervalRemoved( this, 0, data.size() );
    }
}