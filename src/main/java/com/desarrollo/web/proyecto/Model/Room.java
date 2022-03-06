package com.desarrollo.web.proyecto.Model;

import java.util.ArrayList;

public class Room {
    
    private ArrayList<DecorativeItem> decorativeItems;
    private ArrayList<Item> items;
    private NPC monster;
    private ArrayList<Player> players;
    private ArrayList<Room> exits;

    public Room() {
    }

    public Room(ArrayList<DecorativeItem> decorativeItems, ArrayList<Item> items, NPC monster,
            ArrayList<Player> players, ArrayList<Room> exits) {
        this.decorativeItems = decorativeItems;
        this.items = items;
        this.monster = monster;
        this.players = players;
        this.exits = exits;
    }

    
    public ArrayList<DecorativeItem> getDecorativeItems() {
        return decorativeItems;
    }
    public void setDecorativeItems(ArrayList<DecorativeItem> decorativeItems) {
        this.decorativeItems = decorativeItems;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    public NPC getMonster() {
        return monster;
    }
    public void setMonster(NPC monster) {
        this.monster = monster;
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    public ArrayList<Room> getExits() {
        return exits;
    }
    public void setExits(ArrayList<Room> exits) {
        this.exits = exits;
    }


}
