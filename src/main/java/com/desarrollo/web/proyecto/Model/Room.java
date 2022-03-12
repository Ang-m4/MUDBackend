package com.desarrollo.web.proyecto.Model;

import java.util.ArrayList;
import java.util.List;

public class Room {
    
    private Long id;
    private Long name;
    private List<DecorativeItem> decorativeItems;
    private List<Item> items;
    private Entity monster;
    private List<Player> players;
    private List<Room> exits;

    public Room(){
        this.decorativeItems = new ArrayList<>();
        this.items = new ArrayList<>();
        this.players = new ArrayList<>();
        this.exits = new ArrayList<>();
    }

    public Room(Long id, Long name, ArrayList<DecorativeItem> decorativeItems, ArrayList<Item> items, Entity monster,
            ArrayList<Player> players, ArrayList<Room> exits) {
        this.id = id;
        this.name = name;
        this.decorativeItems = decorativeItems;
        this.items = items;
        this.monster = monster;
        this.players = players;
        this.exits = exits;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Long getName() {
        return name;
    }


    public void setName(Long name) {
        this.name = name;
    }


    public List<DecorativeItem> getDecorativeItems() {
        return decorativeItems;
    }
    public void setDecorativeItems(ArrayList<DecorativeItem> decorativeItems) {
        this.decorativeItems = decorativeItems;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    public Entity getMonster() {
        return monster;
    }
    public void setMonster(Entity monster) {
        this.monster = monster;
    }
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    public List<Room> getExits() {
        return exits;
    }
    public void setExits(ArrayList<Room> exits) {
        this.exits = exits;
    }

}
