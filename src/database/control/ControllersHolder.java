package database.control;

import database.entity.DataBase;

public class ControllersHolder {

    private DbController dbCtrl;
    private TableController tbCtrl;
    private ColumnController clCtrl;
    private DataProvider provider;

    public ControllersHolder () {
        dropAllStates();
        this.dbCtrl = new DbController( this );
        this.tbCtrl = new TableController( this );
        this.clCtrl = new ColumnController( this );
    }

    DataProvider getProvider () {
        return provider;
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

    void dropAllStates ( String string ) {
        provider = new DataProvider( new DataBase( string ) );
    }

    final void dropAllStates () {
        dropAllStates( "вiдсутня" );
    }
}
