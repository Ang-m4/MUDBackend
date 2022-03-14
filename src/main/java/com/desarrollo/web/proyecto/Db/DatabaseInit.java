package com.desarrollo.web.proyecto.Db;

import com.desarrollo.web.proyecto.Model.DecorativeItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import com.desarrollo.web.proyecto.Model.*;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
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

    /// se ejecuta una sola vez al inicio de la aplicacion.
    @Override
    public void run(ApplicationArguments args) throws Exception {
        
        loadDecoItems();
        loadItems();
        loadMonsters();


        loadRooms();

        loadPlayers();
        
        
    }
    
    void loadDecoItems(){

        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		TypeReference<List<DecorativeItem>> typeReference = new TypeReference<List<DecorativeItem>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/assets/objetos-decorativos.json");

		List<DecorativeItem> itemList = new ArrayList<>();
        
        try {
            itemList = (mapper.readValue(inputStream,typeReference));
        } catch (StreamReadException e) {
            
            e.printStackTrace();
        } catch (DatabindException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }

       
        decoItemRepo.saveAll(itemList);
    }

    void loadItems() {
        
      
		ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		TypeReference<List<Item>> typeReference = new TypeReference<List<Item>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/assets/items.json");

		List<Item> itemList = new ArrayList<>();
        try {
            itemList = (mapper.readValue(inputStream,typeReference));
        } catch (StreamReadException e) {
            
            e.printStackTrace();
        } catch (DatabindException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
        itemRepo.saveAll(itemList);
        
	}

    void loadMonsters(){

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		TypeReference<List<Monster>> typeReference = new TypeReference<List<Monster>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/assets/monstruos.json");       
		List<Monster> monsterList = new ArrayList<>();

        try {
            monsterList = (mapper.readValue(inputStream,typeReference));     
        } catch (StreamReadException e) {
            
            e.printStackTrace();
        } catch (DatabindException e) {
            
            e.printStackTrace();
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
        
        Player pB = new Player();
        pB.setName("Bob");
        pB.setAttack_level(20);
        pB.setSize(20);

        pA.getCategory().add("Categoria Uno");
        pA.getCategory().add("Categoria Dos");

        pB.getCategory().add("Categoria Uno");
        pB.getCategory().add("Categoria Dos");

        Item iA = itemRepo.findById(45l).orElseThrow();
        Item iB = itemRepo.findById(48l).orElseThrow();
        
        playerRepo.save(pA);
        playerRepo.save(pB);

        pA.getBackpack().add(iA);
        pA.getBackpack().add(iB);

        pB.getBackpack().add(iA);
        pB.getBackpack().add(iB);

        pA.setLocation(roomRepo.findById(137l).orElseThrow());
        pB.setLocation(roomRepo.findById(137l).orElseThrow());

        playerRepo.save(pA);
        playerRepo.save(pB);
        
    }

    void loadRooms(){

        Room rA = new Room();
        
        rA.setName("ROOM_1");

        roomRepo.save(rA);
        Item iA = itemRepo.findById(45l).orElseThrow();
        DecorativeItem diA = decoItemRepo.findById(2l).orElseThrow();
        DecorativeItem diB = decoItemRepo.findById(3l).orElseThrow();
        Monster mA = monsterRepo.findById(130l).orElseThrow();
        rA.getItems().add(iA);
        rA.getDecorativeItems().add(diA);
        rA.getDecorativeItems().add(diB);
        rA.setMonster(mA);

        roomRepo.save(rA);

        
        Room rB = new Room();
        
        rB.setName("ROOM_2");

        roomRepo.save(rB);
        Item iB = itemRepo.findById(46l).orElseThrow();
        DecorativeItem diC = decoItemRepo.findById(7l).orElseThrow();
        DecorativeItem diD = decoItemRepo.findById(5l).orElseThrow();
        Monster mB = monsterRepo.findById(131l).orElseThrow();
        rB.getItems().add(iB);
        rB.getDecorativeItems().add(diC);
        rB.getDecorativeItems().add(diD);
        rB.setMonster(mB);

        rB.getExits().add(rA);

        roomRepo.save(rB);

    }

}
