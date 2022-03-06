package com.desarrollo.web.proyecto.Data;

public abstract class Entity {
    
    private int id;
    private String name;

    public Entity(){};

    public Entity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
