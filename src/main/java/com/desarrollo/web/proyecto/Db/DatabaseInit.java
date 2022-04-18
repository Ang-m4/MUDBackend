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
        
        //loadRooms();
       // loadPlayers();
        
    }
    
    void loadDecoItems(){

        List<DecorativeItem> itemList = new ArrayList<>();

        itemList.add(new DecorativeItem("Crate"));
        itemList.add(new DecorativeItem("Cave Entrance"));
        itemList.add(new DecorativeItem("Prison Door"));
        itemList.add(new DecorativeItem("Door"));
        itemList.add(new DecorativeItem("Large door"));
        itemList.add(new DecorativeItem("Crate"));
        itemList.add(new DecorativeItem("Giant crystal"));
        itemList.add(new DecorativeItem("Vine"));
        itemList.add(new DecorativeItem("Door"));
        itemList.add(new DecorativeItem("Stairs"));

        decoItemRepo.saveAll(itemList);
    }

    void loadItems() {
        
		List<Item> itemList = new ArrayList<>();

        itemList.add(new Item("Dwarf remains","2022-09-24",2,3,"The body of a Dwarf savaged by Goblins.", "https://oldschool.runescape.wiki/w/Dwarf_remains"));
        itemList.add(new Item("Toolkit","2021-09-4",2,33,"The body of a Dwarf savaged by Goblins.", "https://oldschool.runescape.wiki/w/Dwarf_remains"));
        itemList.add(new Item("Cannonball","2021-2-24",23,31,"The body of a Dwarf savaged by Goblins.", "https://oldschool.runescape.wiki/w/Dwarf_remains"));
        itemList.add(new Item("Nulodion's notes","2021-09-24",4,32,"The body of a Dwarf savaged by Goblins.", "https://oldschool.runescape.wiki/w/Dwarf_remains"));
        itemList.add(new Item("Ammo mould","2021-09-2",6,35,"The body of a Dwarf savaged by Goblins.", "https://oldschool.runescape.wiki/w/Dwarf_remains"));
        itemList.add(new Item("Instruction manual","2021-09-24",2,32,"The body of a Dwarf savaged by Goblins.", "https://oldschool.runescape.wiki/w/Dwarf_remains"));
        itemList.add(new Item( "Cannon barrels","2020-09-24",2,3,"The body of a Dwarf savaged by Goblins.", "https://oldschool.runescape.wiki/w/Dwarf_remains"));
        
        itemRepo.saveAll(itemList);
        
	}

    void loadMonsters(){
  
		List<Monster> monsterList = new ArrayList<>();
        ArrayList<String> catego = new ArrayList<>();
        catego.add("Cat A");
        catego.add("Cat B");
        catego.add("Cat C");
        monsterList.add(new Monster("Aberrant spectre","2021-09-02",1,20,2,90,catego,"A very smelly ghost.","https://oldschool.runescape.wiki/w/Aberrant_spectre"));
        monsterList.add(new Monster("Nechryael","2021-09-02",1,20,2,90,catego,"A very smelly ghost.","https://oldschool.runescape.wiki/w/Aberrant_spectre"));
        monsterList.add(new Monster( "Death spawn","2021-09-02",1,20,2,90,catego,"A very smelly ghost.","https://oldschool.runescape.wiki/w/Aberrant_spectre"));
        monsterList.add(new Monster( "An evil death spawn.","2021-09-02",1,20,2,90,catego,"A very smelly ghost.","https://oldschool.runescape.wiki/w/Aberrant_spectre"));
        monsterList.add(new Monster("Zombie","2021-09-02",1,20,2,90,catego,"A very smelly ghost.","https://oldschool.runescape.wiki/w/Aberrant_spectre"));
        monsterList.add(new Monster("Summoned Zombie","2021-09-02",1,20,2,90,catego,"A very smelly ghost.","https://oldschool.runescape.wiki/w/Aberrant_spectre"));
        monsterList.add(new Monster("Ghost","2021-09-02",1,20,2,90,catego,"A very smelly ghost.","https://oldschool.runescape.wiki/w/Aberrant_spectre"));
        monsterList.add(new Monster("The living dead","2021-09-02",1,20,2,90,catego,"A very smelly ghost.","https://oldschool.runescape.wiki/w/Aberrant_spectre"));
        monsterList.add(new Monster("Rock Crab","2021-09-02",1,20,2,90,catego,"A very smelly ghost.","https://oldschool.runescape.wiki/w/Aberrant_spectre"));
        monsterList.add(new Monster("Molanisk","2021-09-02",1,20,2,90,catego,"A very smelly ghost.","https://oldschool.runescape.wiki/w/Aberrant_spectre"));
        monsterList.add(new Monster( "Skeleton Mage","2021-09-02",1,20,2,90,catego,"A very smelly ghost.","https://oldschool.runescape.wiki/w/Aberrant_spectre"));
        
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
