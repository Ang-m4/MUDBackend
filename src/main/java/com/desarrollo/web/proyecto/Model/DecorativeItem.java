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
@Table(name = "Decorative_items")
public class DecorativeItem {
    
    @JsonIgnore
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "decorativeItems")
    private Set<Room> locations;

    public DecorativeItem(){
        locations = new HashSet<>();
    }

    public DecorativeItem(String name,Set<Room> locations) {
        this.name = name;
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

    public Set<Room> getLocations() {
        return locations;
    }

    public void setLocations(Set<Room> locations) {
        this.locations = locations;
    };


}