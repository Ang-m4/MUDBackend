package com.desarrollo.web.proyecto.Data;

public class Item extends Entity {

    private String last_updated;
    private int cost;
    private int weight;
    private String examine;
    private String wiki_url;

    public Item(){};

    public Item(int id, String name,String last_updated, int cost, int weight, String examine, String wiki_url) {
        super(id, name);
        this.last_updated = last_updated;
        this.cost = cost;
        this.weight = weight;
        this.examine = examine;
        this.wiki_url = wiki_url;
    }

    public String getLast_updated() {
        return last_updated;
    }
    public void setLast_update(String last_updated) {
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
       

    

}
