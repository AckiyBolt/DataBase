package database.entity;

import java.util.Map;
import java.util.Set;

public class Entity {
    
    // K - column name, V - value
    private Map<String, String> properties;

    public Map<String, String> getProperties () {
        return properties;
    }

    public void setProperties ( Map<String, String> properties ) {
        this.properties = properties;
    }
}
