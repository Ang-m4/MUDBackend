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
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

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

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players;

    @ManyToMany
    @JoinTable(name = "Exits", joinColumns = @JoinColumn(name = "Room_id"), inverseJoinColumns = @JoinColumn(name = "Exit_id"))
    private Set<Room> exits;

    @ManyToMany
    @JoinTable(name = "Exits", joinColumns = @JoinColumn(name = "Exit_id"), inverseJoinColumns = @JoinColumn(name = "Room_id"))
    @Transient
    private Set<Room> exitOf;

    @JsonIgnore
    @Transient
    String decoItemsAdd;

    @JsonIgnore
    @Transient
    String itemsAdd;

    @JsonIgnore
    @Transient
    String playersAdd;

    @JsonIgnore
    @Transient
    String monsterAdd;

    @JsonIgnore
    @Transient
    String exitsAdd;

    public Room() {
        this.decorativeItems = new HashSet<>();
        this.items = new HashSet<>();
        this.players = new ArrayList<>();
        this.exits = new HashSet<>();
    }

    public Room(String name, Set<DecorativeItem> decorativeItems, Set<Item> items, Monster monster,
            ArrayList<Player> players, Set<Room> exits) {

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    
    public Set<Room> getExits() {
        return exits;
    }

    public void setExits(Set<Room> exits) {
        this.exits = exits;
    }

    public Set<Room> getExitOf() {
        return exitOf;
    }

    public void setExitOf(Set<Room> exitOf) {
        this.exitOf = exitOf;
    }

    public String getDecoItemsAdd() {

        if(decorativeItems.size() != 0){

            String retorno = "";

            for(DecorativeItem item: decorativeItems){

                retorno = retorno + item.getId() + ",";
            }

            return retorno;

        }

        return decoItemsAdd;
    }

    public void setDecoItemsAdd(String decoItemsAdd) {
        this.decoItemsAdd = decoItemsAdd;
    }

    public String getItemsAdd() {

        if(items.size() != 0){

            String retorno = "";
            for(Item item: items){
                retorno = retorno + item.getId() + ",";
            }
            return retorno;
        }
        
        return itemsAdd;
    }

    public void setItemsAdd(String itemsAdd) {

        this.itemsAdd = itemsAdd;
    }

    public String getPlayersAdd() {

        if(players.size() != 0){

            String retorno = "";
            for(Player item: players){
                retorno = retorno + item.getId() + ",";
            }
            return retorno;
        }

        return playersAdd;
    }

    public void setPlayersAdd(String playersAdd) {
        this.playersAdd = playersAdd;
    }

    public String getMonsterAdd() {

        if(monster != null){

            return this.getMonster().getId().toString();

        }

        return monsterAdd;
    }

    public void setMonsterAdd(String monsterAdd) {
        this.monsterAdd = monsterAdd;
    }

    public String getExitsAdd() {

        if(exits.size() != 0){

            String retorno = "";
            for(Room item: exits){
                retorno = retorno + item.getId() + ",";
            }
            return retorno;
        }

        return exitsAdd;
    }

    public void setExitsAdd(String exitsAdd) {
        this.exitsAdd = exitsAdd;
    }
        
}
