package com.desarrollo.web.proyecto.Model;

import java.util.ArrayList;

public class Player extends NPC {
    
    ArrayList<Item> backpack;
    Long maxWeight;
    Long weight;

    public Player() {
        backpack = new ArrayList<>();
    }

    public Player(Long id, String name, String last_updated, int attack_level, int defence_slash, int size,
            int hitpoints, ArrayList<String> category, String examine, String wiki_url, ArrayList<Item> backpack,
            Long maxWeight, Long weight) {
        super(id, name, last_updated, attack_level, defence_slash, size, hitpoints, category, examine, wiki_url);
        this.backpack = backpack;
        this.maxWeight = maxWeight;
        this.weight = weight;
    }

    public ArrayList<Item> getBackpack() {
        return backpack;
    }
    public void setBackpack(ArrayList<Item> backpack) {
        this.backpack = backpack;
    }
    public Long getMaxWeight() {
        return maxWeight;
    }
    public void setMaxWeight(Long maxWeight) {
        this.maxWeight = maxWeight;
    }
    public Long getWeight() {
        return weight;
    }
    public void setWeight(Long weight) {
        this.weight = weight;
    }
    
    

}
