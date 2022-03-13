package com.desarrollo.web.proyecto.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "Items")
public class Item{

    @JsonIgnore
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String last_updated;
    private int cost;
    private int weight;
    private String examine;
    private String wiki_url; 

    @ManyToMany(mappedBy = "backpack")
    private Set<Player> obtainedBy;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "items")
    private Set<Room> locations;

    public Item(){
        obtainedBy = new HashSet<>();
        locations = new HashSet<>();
    }

    public Item(String name, String last_updated, int cost, int weight, String examine, String wiki_url,Set<Player> obtainedBy,Set<Room> locations) {
        
        this.name = name;
        this.last_updated = last_updated;
        this.cost = cost;
        this.weight = weight;
        this.examine = examine;
        this.wiki_url = wiki_url;
        this.obtainedBy = obtainedBy;
        this.locations = locations;
        
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

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getExamine() {
        return examine;
    }

    public void setExamine(String examine) {
        this.examine = examine;
    }

    public String getWiki_url() {
        return wiki_url;
    }

    public void setWiki_url(String wiki_url) {
        this.wiki_url = wiki_url;
    }

    public Set<Player> getObtainedBy() {
        return obtainedBy;
    }

    public void setObtainedBy(Set<Player> obtainedBy) {
        this.obtainedBy = obtainedBy;
    }

    public Set<Room> getLocations() {
        return locations;
    }

    public void setLocations(Set<Room> locations) {
        this.locations = locations;
    };

        
}
