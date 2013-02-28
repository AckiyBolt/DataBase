package database.control;

import database.entity.Column;
import database.entity.ColumnType;
import database.entity.DataBase;
import database.entity.Entity;
import database.entity.Table;
import java.util.ArrayList;

public class DbController {

    private ControllersHolder holder;

    DbController ( ControllersHolder holder ) {
        this.holder = holder;
    }

    private DataBase db () {
        return holder.getProvider().getDB();
    }

    public void createDB ( String name ) {
        holder.dropAllStates( name );
    }

    public void changeDBName ( String name ) {
        db().setName( name );
    }

    public void crateMockDB () {
        holder.dropAllStates();
        db().setName( "mock" );
        db().setTables( new ArrayList<Table>() );

        Table table = new Table( "test" );
        table.setColumns( new ArrayList<Column>() );
        Column column1 = new Column( "test col1" );
        column1.setSimpleType( ColumnType.DATE );
        Column column2 = new Column( "test col2" );
        column2.setSimpleType( ColumnType.DATE );
        Column column3 = new Column( "test col3" );
        column3.setSimpleType( ColumnType.DATE );
        table.getColumns().add( column1 );
        table.getColumns().add( column2 );
        table.getColumns().add( column3 );
        table.setData( new ArrayList<Entity>() );

        db().getTables().add( table );
    }

    public String getDbName () {
        return db().getName();
    }
}