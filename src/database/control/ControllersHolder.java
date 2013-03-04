package database.control;

import database.entity.DataBase;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControllersHolder {

    private DbController dbCtrl;
    private TableController tbCtrl;
    private ColumnController clCtrl;
    private EntityController enCtrl;
    private DataProvider provider;
    private ErrorHolder errors;

    public ControllersHolder () {
        dropAllStates();
        this.dbCtrl = new DbController( this );
        this.tbCtrl = new TableController( this );
        this.clCtrl = new ColumnController( this );
        this.enCtrl = new EntityController( this );
        this.errors = new ErrorHolder();
    }

    DataProvider getProvider () {
        return provider;
    }

    public ErrorHolder getErrors () {
        return errors;
    }
    
    public DbController getDbCtrl () {
        return dbCtrl;
    }

    public TableController getTbCtrl () {
        return tbCtrl;
    }

    public ColumnController getClCtrl () {
        return clCtrl;
    }

    public EntityController getEnCtrl () {
        return enCtrl;
    }

    /**
     * Creates real database with specified name
     */
    void dropAllStates ( String string ) {
        provider = new DataProvider( new DataBase( string ), false );
    }

    /**
     * Creates mock database. Just for first run
     */
    final void dropAllStates () {
        provider = new DataProvider( new DataBase( "вiдсутня" ), true );
    }
    
    public void showMessage (JFrame form)
            throws HeadlessException {
        String message = getErrors().getMessageAndClearErrors();
        if ( !message.isEmpty() )
            JOptionPane.showMessageDialog( form, message );
    }
    
    public void showMessage (JFrame form, String message)
            throws HeadlessException {
        getErrors().addError( message );
        showMessage( form );
    }
}
