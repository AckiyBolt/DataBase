package database.control;

import database.entity.Column;
import database.entity.ColumnType;
import database.entity.DataBase;
import database.entity.Entity;
import database.entity.Table;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DbController
        extends AbstractController {

    public DbController ( ControllersHolder holder ) {
        super( holder );
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
        column1.setComplexType( "complex" );
        column1.setPrimaryKey( Boolean.TRUE );
        
        Column column2 = new Column( "test col2" );
        column2.setSimpleType( ColumnType.DATE );
        column2.setPrimaryKey( Boolean.FALSE );
        
        Column column3 = new Column( "test col3" );
        column3.setSimpleType( ColumnType.DATE );
        column3.setPrimaryKey( Boolean.FALSE );
        
        table.getColumns().add( column1 );
        table.getColumns().add( column2 );
        table.getColumns().add( column3 );
        table.setData( new ArrayList<Entity>() );
        
        db().getTables().add( table );

        Entity ent = new Entity();
        Map<String,String> properties = new HashMap<String,String>();
        properties.put( "test col1", "col1");
        properties.put( "test col2", "col2");
        properties.put( "test col3", "col3");
        ent.setProperties( properties );
        
        LinkedList<Entity> ents = new LinkedList<Entity>();
        ents.add( ent );
        
        db().getTables().get( 0 ).setData( ents );
    }

    public String getDbName () {
        return db().getName();
    }
}