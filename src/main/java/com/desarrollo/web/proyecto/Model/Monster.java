package com.desarrollo.web.proyecto.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Monsters")
public class Monster {
    
    @Id
    @GeneratedValue
  
    private Long id;
    
    private String name;
    private String last_updated;
    private int attack_level;
    private int defence_slash;
    private int size;
    private int hitpoints;

    @ElementCollection
    @CollectionTable(name = "MONSTER_CATEGORY")
    private List<String> category; 

    private String examine;
    private String wiki_url;

    @JsonIgnore
    @OneToMany(mappedBy = "monster",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Room> locations;

    @JsonIgnore
    @Transient
    String categories;
    
    public Monster (){
        this.category = new ArrayList<>();
        this.locations = new ArrayList<>();
    }    

    public Monster( String name, String last_updated, int attack_level, int defence_slash, int size,
            int hitpoints, ArrayList<String> category, String examine, String wiki_url,ArrayList<Room> locations) {
            
        this.name = name;
        this.last_updated = last_updated;
        this.attack_level = attack_level;
        this.defence_slash = defence_slash;
        this.size = size;
        this.hitpoints = hitpoints;
        this.category = category;
        this.examine = examine;
        this.wiki_url = wiki_url;
        this.locations = locations;
    }

    
    public Monster( String name, String last_updated, int attack_level, int defence_slash, int size,
            int hitpoints, ArrayList<String> category, String examine, String wiki_url) {
            
        this.name = name;
        this.last_updated = last_updated;
        this.attack_level = attack_level;
        this.defence_slash = defence_slash;
        this.size = size;
        this.hitpoints = hitpoints;
        this.category = category;
        this.examine = examine;
        this.wiki_url = wiki_url;
        
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
    public int getAttack_level() {
        return attack_level;
    }
    public void setAttack_level(int attack_level) {
        this.attack_level = attack_level;
    }
    public int getDefence_slash() {
        return defence_slash;
    }
    public void setDefence_slash(int defence_slash) {
        this.defence_slash = defence_slash;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getHitpoints() {
        return hitpoints;
    }
    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }
    public List<String> getCategory() {
        return category;
    }
    public void setCategory(List<String> category) {
        this.category = category;
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

    public List<Room> getLocations() {
        return locations;
    }

    public void setLocations(List<Room> locations) {
        this.locations = locations;
    }

    public String getCategories() {

        String retorno = "";
        for(String cate: category){

            retorno = retorno + cate + ",";
        }

        return retorno;
    }

    public void setCategorias(String categories) {
        this.categories = categories;
    }


}
