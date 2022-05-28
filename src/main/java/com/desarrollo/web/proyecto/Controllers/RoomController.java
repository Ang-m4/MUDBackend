package com.desarrollo.web.proyecto.Controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.desarrollo.web.proyecto.Db.DecorativeItemRepository;
import com.desarrollo.web.proyecto.Db.ItemRepository;
import com.desarrollo.web.proyecto.Db.MonsterRepository;
import com.desarrollo.web.proyecto.Db.PlayerRepository;
import com.desarrollo.web.proyecto.Db.RoomRepository;
import com.desarrollo.web.proyecto.Model.*;

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

        List<Room> found = (List<Room>) roomRepository.findAll();
        for (Room r : found) {
            resolveRedundancy(r);
        }
        return found;
    }

    @GetMapping("/{id}/get")
    @CrossOrigin("http://localhost:4200")
    Room getRoom(@PathVariable Long id) {

        Room selected = roomRepository.findById(id).orElseThrow();
        resolveRedundancy(selected);
        return selected;
    }

    @GetMapping("/{id}/delete")
    @CrossOrigin("http://localhost:4200")
    String deleteRoom(@PathVariable Long id) {
        roomRepository.deleteById(id);
        return "room deleted";
    }

    @PostMapping("/save")
    @CrossOrigin("http://localhost:4200")
    Room saveData(@RequestBody Room room) {

        if (room.getMonster() != null) {

            if (room.getMonster().getName().isEmpty()) {
                room.setMonster(null);
            }
        }

        Room saved = roomRepository.save(room);
        resolveRedundancy(saved);

        return saved;
    }

    public void resolveRedundancy(Room selected) {

        Set<Room> exits = new HashSet<Room>();
        for (Room r : selected.getExits()) {

            Room aux = new Room();
            aux.setName(r.getName());
            aux.setId(r.getId());
            exits.add(aux);
        }

        selected.setExits(exits);
    }

}