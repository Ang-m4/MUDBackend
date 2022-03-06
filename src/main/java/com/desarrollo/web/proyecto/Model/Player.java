package com.desarrollo.web.proyecto.Model;

import java.util.ArrayList;

public class Player extends NPC {
    
    ArrayList<Item> backpack;
    Long maxWeight;
    Long weight;


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
