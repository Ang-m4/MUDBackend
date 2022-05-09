package com.desarrollo.web.proyecto.Controllers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.desarrollo.web.proyecto.Db.DecorativeItemRepository;
import com.desarrollo.web.proyecto.Db.ItemRepository;
import com.desarrollo.web.proyecto.Db.MonsterRepository;
import com.desarrollo.web.proyecto.Db.PlayerRepository;
import com.desarrollo.web.proyecto.Db.RoomRepository;
import com.desarrollo.web.proyecto.Model.*;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {
    
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    DecorativeItemRepository decorativeItemRepository;

    @Autowired
    MonsterRepository monsterRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    RoomRepository roomRepository;

    Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/list")
    @CrossOrigin("http://localhost:4200")
    List<Room> listRooms() {




        return (List<Room>) roomRepository.findAll();
    }

    @GetMapping("/{id}/get")
    @CrossOrigin("http://localhost:4200")
    Room getRoom(@PathVariable Long id) {
        Room selected = roomRepository.findById(id).orElseThrow();
        return selected;
    }

    @PostMapping("/save")
    @CrossOrigin("http://localhost:4200")
    Boolean saveData(@RequestBody Room room) {

        Room saved = room;
        //roomRepository.save(room);
        //El error esta en el guardado de los datos redundantes en el repositorio.
        Set<Room> exits = new HashSet<Room>();

        for(Room r : saved.getExits()){
            
            exits.add(new Room(r.getId(),r.getName()));
            
        }

        saved.setExits(exits);

  

        return false;
    }
    
    @GetMapping("/{id}/delete")
    @CrossOrigin("http://localhost:4200")
    void deleteRoom(@PathVariable Long id){
        roomRepository.deleteById(id);
    }

}