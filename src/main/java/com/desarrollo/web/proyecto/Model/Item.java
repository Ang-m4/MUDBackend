package com.desarrollo.web.proyecto.Model;

public class Item{

    
    private Long id;
    private String name;
    private String last_updated;
    private int cost;
    private int weight;
    private String examine;
    private String wiki_url;

    public Item(){}

    public Item(Long id, String name, String last_updated, int cost, int weight, String examine, String wiki_url) {
        
        this.id = id;
        this.name = name;
        this.last_updated = last_updated;
        this.cost = cost;
        this.weight = weight;
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
    };

    



    

}
