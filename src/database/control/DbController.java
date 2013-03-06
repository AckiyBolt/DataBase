package database.control;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import database.control.file.FileController;
import database.entity.Column;
import database.entity.ColumnType;
import database.entity.DataBase;
import database.entity.Entity;
import database.entity.Table;
import database.model.list.MyListModel;
import java.awt.Component;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.JFrame;

public class DbController
        extends AbstractController {

    private FileController fileCtlr;
    private Gson gson;

    public DbController ( ControllersHolder holder ) {
        super( holder );
        this.fileCtlr = new FileController();
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    private DataBase db () {
        return holder.getProvider().getDB();
    }

    public void createDB ( String name ) {
        holder.dropAllStates( name );
    }

    public void openDB ( JFrame parentComponent ) {
        String json = fileCtlr.readFile( parentComponent, holder.getErrors() );
        
        if (json == null){
            holder.showMessage( parentComponent );
            return;
        }
        
        DataBase db = gson.fromJson( json, DataBase.class );
        this.holder.getProvider().setDB( db );
    }

    public void saveDB ( JFrame parentComponent ) {
        String json = gson.toJson( holder.getProvider().getDB() );
        
        if (json == null){
            holder.showMessage( parentComponent );
            return;
        }
        
        fileCtlr.writeFile( parentComponent, holder.getErrors(), json );
    }

    public void changeDBName ( String name ) {
        db().setName( name );
    }

    public void crateMockDB () {
        holder.dropAllStates( "mock" );
        db().setTables( new ArrayList<Table>() );

        Table table = new Table( "test" );
        table.setColumns( new ArrayList<Column>() );

        Column column1 = new Column( "test col1" );
        column1.setSimpleType( ColumnType.INTEGER );
        column1.setPrimaryKey( Boolean.TRUE );

        Column column2 = new Column( "test col2" );
        column2.setSimpleType( ColumnType.STRING );
        column2.setPrimaryKey( Boolean.FALSE );

        Column column3 = new Column( "test col3" );
        column3.setSimpleType( ColumnType.STRING );
        column3.setPrimaryKey( Boolean.FALSE );

        table.getColumns().add( column1 );
        table.getColumns().add( column2 );
        table.getColumns().add( column3 );
        table.setData( new ArrayList<Entity>() );
        table.setPrimaryKey( column1 );

        db().getTables().add( table );

        Entity ent = new Entity();
        Map<String, String> properties = new HashMap<String, String>();
        properties.put( "test col1", "0000" );
        properties.put( "test col2", "col2" );
        properties.put( "test col3", "col3" );
        ent.setProperties( properties );

        LinkedList<Entity> ents = new LinkedList<Entity>();
        ents.add( ent );

        db().getTables().get( 0 ).setData( ents );
    }

    public String getDbName () {
        return db().getName();
    }

    public boolean isExists () {
        return !holder.getProvider().isMock();
    }
}