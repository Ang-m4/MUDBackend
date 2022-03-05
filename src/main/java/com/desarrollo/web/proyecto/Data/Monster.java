package com.desarrollo.web.proyecto.Data;

import java.util.ArrayList;
import java.util.Date;

public class Monster extends Entity {
    
    private Date last_update;
    private int attack_level;
    private int defence_slash;
    private int size;
    private int hitpoints;
    private ArrayList<String> category;
    private String examine;
    private String wiki_url;
    
    public Monster(int id, String name, Date last_update, int attack_level, int defence_slash, int size, int hitpoints,
           ArrayList<String> category, String examine, String wiki_url) {
        super(id, name);
        this.last_update = last_update;
        this.attack_level = attack_level;
        this.defence_slash = defence_slash;
        this.size = size;
        this.hitpoints = hitpoints;
        this.category = category;
        this.examine = examine;
        this.wiki_url = wiki_url;
    }

    public Date getLast_update() {
        return last_update;
    }
    public void setLast_update(Date last_update) {
        this.last_update = last_update;
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

    public ArrayList<String> getCategory() {
        return category;
    }
    public void setCategory(ArrayList<String> category) {
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

}
