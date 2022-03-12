package com.desarrollo.web.proyecto.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DecorativeItem {
    
    @JsonIgnore
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public DecorativeItem(){}

    public DecorativeItem(String name) {
        this.name = name;
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
    };

}