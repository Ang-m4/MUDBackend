package com.desarrollo.web.proyecto.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    private Long name;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "Room_decoItems", joinColumns = { @JoinColumn(name = "Room_Id") }, inverseJoinColumns = {
            @JoinColumn(name = "decoItem_id") })
    private Set<DecorativeItem> decorativeItems;


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "Room_Items", joinColumns = { @JoinColumn(name = "Room_Id") }, inverseJoinColumns = {
            @JoinColumn(name = "Item_id") })
    private Set<Item> items;
    

    @ManyToOne
    @JoinColumn(name = "monster_id")
    private Monster monster;

    @Transient
    private List<Player> players;

    @Transient
    private List<Room> exits;

    public Room() {
        this.decorativeItems = new HashSet<>();
        this.items = new HashSet<>();
        this.players = new ArrayList<>();
        this.exits = new ArrayList<>();
    }

    public Room(Long name, Set<DecorativeItem> decorativeItems, Set<Item> items, Monster monster,
            ArrayList<Player> players, ArrayList<Room> exits) {
        
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

    public Set<DecorativeItem> getDecorativeItems() {
        return decorativeItems;
    }

    public void setDecorativeItems(Set<DecorativeItem> decorativeItems) {
        this.decorativeItems = decorativeItems;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
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
