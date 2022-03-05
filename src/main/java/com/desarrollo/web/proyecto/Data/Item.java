package com.desarrollo.web.proyecto.Data;

import java.util.Date;

public class Item extends Entity {

    private Date last_update;
    private int cost;
    private int weight;
    private String examine;
    private String wiki_url;

    

    public Item(int id, String name, Date last_update, int cost, int weight, String examine, String wiki_url) {
        super(id, name);

        this.last_update = last_update;
        this.cost = cost;
        this.weight = weight;
        this.examine = examine;
        this.wiki_url = wiki_url;
    }
    
    public Date getLast_update() {
        return last_update;
    }
    public void setLast_update(Date last_update) {
        this.last_update = last_update;
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
       

    

}
