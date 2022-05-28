package com.desarrollo.web.proyecto.Db;

import com.desarrollo.web.proyecto.Model.DecorativeItem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import com.desarrollo.web.proyecto.Model.*;

@Component
@Profile("develop")
public class DatabaseInit implements ApplicationRunner{

    @Autowired
    DecorativeItemRepository decoItemRepo;

    @Autowired
    ItemRepository itemRepo;

    @Autowired
    MonsterRepository monsterRepo;

    @Autowired
    PlayerRepository playerRepo;

    @Autowired
    RoomRepository roomRepo;
     
    @Override
    public void run(ApplicationArguments args) throws Exception {
        
       
        loadDecoItems();
        loadItems();
        loadMonsters();
        loadPlayers();
        loadRooms();    
    }
    
    void loadDecoItems() {

        List<DecorativeItem> decorativeItems = new ArrayList<DecorativeItem>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
                decorativeItems = objectMapper.readValue(
                new File("Assets/objetos-decorativos.json"), 
                new TypeReference<List<DecorativeItem>>(){});

        } catch (IOException e) {

            e.printStackTrace();
        }
    

        decoItemRepo.saveAll(decorativeItems);
    }

    void loadItems() {
        
		List<Item> itemList = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
                itemList = objectMapper.readValue(
                new File("Assets/items.json"), 
                new TypeReference<List<Item>>(){});

        } catch (IOException e) {

            e.printStackTrace();
        } 
        itemRepo.saveAll(itemList);
        
	}

    void loadMonsters(){
  
		List<Monster> monsterList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
                monsterList = objectMapper.readValue(
                new File("Assets/monstruos.json"), 
                new TypeReference<List<Monster>>(){});

        } catch (IOException e) {

            e.printStackTrace();
        }
        monsterRepo.saveAll(monsterList);

    }

    void loadPlayers(){

        Player pA = new Player();
        pA.setName("Alice");
        pA.setAttack_level(30);
        pA.setSize(30);
        pA.setWeight(0l);
        pA.setMaxWeight(100l);
        pA.getCategory().add("Categoria Uno");
        pA.getCategory().add("Categoria Dos");

        Player pB = new Player();
        pB.setName("Bob");
        pB.setAttack_level(20);
        pB.setSize(20);
        pB.setWeight(0l);
        pB.setMaxWeight(100l);
        pB.getCategory().add("Categoria Uno");
        pB.getCategory().add("Categoria Dos");

        playerRepo.save(pA);
        playerRepo.save(pB);
        
    }

    void loadRooms(){

        Room roomA = new Room();
        roomA.setName("Room A");
        roomRepo.save(roomA);

        Room roomB = new Room();
        roomB.setName("Room B");
        roomRepo.save(roomB);

    
    }

}
