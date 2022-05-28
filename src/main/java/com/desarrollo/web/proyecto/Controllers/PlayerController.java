package com.desarrollo.web.proyecto.Controllers;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.desarrollo.web.proyecto.Db.ItemRepository;
import com.desarrollo.web.proyecto.Db.PlayerRepository;
import com.desarrollo.web.proyecto.Model.Player;
import com.desarrollo.web.proyecto.Model.Room;

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
@RequestMapping("/player")
public class PlayerController {
    
    @Autowired
    PlayerRepository playerRepository;
    
    @Autowired
    ItemRepository itemRepository;

    Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/list")
    @CrossOrigin("http://localhost:4200")
    List<Player> showPlayers(){

        List<Player> list =(List<Player>) playerRepository.findAll();

        for(Player p: list){
            resolveRedundancy(p.getLocation());
        }

        return list;
    }

    @GetMapping("/{id}/get")
    @CrossOrigin("http://localhost:4200")
    Player showPlayer(@PathVariable Long id){
        Player selected = playerRepository.findById(id).orElseThrow();
        resolveRedundancy(selected.getLocation());

        return selected;
    }

    @PostMapping("/save")
    @CrossOrigin("http://localhost:4200")
    Player saveData(@RequestBody Player player){

        Player saved = playerRepository.save(player);

        resolveRedundancy(saved.getLocation());

        return saved;
    }

    @GetMapping("/{id}/delete")
    @CrossOrigin("http://localhost:4200")
    String deleteMonster(@PathVariable Long id){
       playerRepository.deleteById(id);
       return "player deleted";
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
