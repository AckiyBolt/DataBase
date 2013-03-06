package database.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Entity {
    
    // K - column name, V - value
    private Map<String, String> properties;

    public Entity () {
    }

    public Map<String, String> getProperties () {
        if (properties == null)
            properties = new HashMap<String, String>();
        return properties;
    }

    public void setProperties ( Map<String, String> properties ) {
        this.properties = properties;
    }
}