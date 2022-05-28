package com.desarrollo.web.proyecto.Controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.desarrollo.web.proyecto.Db.PlayerRepository;
import com.desarrollo.web.proyecto.Model.Player;
import com.desarrollo.web.proyecto.Model.Room;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class gameController {
    
    @Autowired
    PlayerRepository playerRepository;

    Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/roomPlayers/{roomName}")
    @CrossOrigin("http://localhost:4200")
    List<Player> getRoomPlayers(@PathVariable String roomName){
        
        List<Player> list =(List<Player>) playerRepository.findAll();
        List<Player> ret =  new ArrayList<>();

        for(Player p: list){
            
            if(p.getLocation() != null && roomName != ""){

                if(p.getLocation().getName().equals(roomName)){

                    resolveRedundancy(p.getLocation());    
                    ret.add(p);
                    
                }   

            }            
        }

        return ret;
    }

    public void resolveRedundancy(Room selected){

        if(selected != null){

            Set<Room> exits = new HashSet<Room>();
            for(Room r : selected.getExits()){
    
                Room aux = new Room();
                aux.setName(r.getName());
                aux.setId(r.getId());
                exits.add(aux); 
            }
            
            selected.setExits(exits);

        }

    }

}
