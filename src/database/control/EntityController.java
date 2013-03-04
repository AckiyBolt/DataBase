package database.control;

import database.entity.Table;

public class EntityController
        extends AbstractController {

    private Table workingTable;
    
    public EntityController ( ControllersHolder holder ) {
        super( holder );
    }

    public Table getWorkingTable () {
        return workingTable;
    }

    public void setWorkingTable ( Table workingTable ) {
        this.workingTable = workingTable;
    }
}