package com.desarrollo.web.proyecto.Controllers;
import java.util.List;
import com.desarrollo.web.proyecto.Db.ItemRepository;
import com.desarrollo.web.proyecto.Db.PlayerRepository;
import com.desarrollo.web.proyecto.Model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        return (List<Player>) playerRepository.findAll();
    }

    @GetMapping("/{id}/get")
    @CrossOrigin("http://localhost:4200")
    Player showPlayer(@PathVariable Long id){
        Player selected = playerRepository.findById(id).orElseThrow();
        return selected;
    }

    @PostMapping("/save")
    @CrossOrigin("http://localhost:4200")
    Player saveData(@RequestBody Player player){
        return playerRepository.save(player);
    }

    @GetMapping("/{id}/delete")
    @CrossOrigin("http://localhost:4200")
    void deleteMonster(@PathVariable Long id){
       playerRepository.deleteById(id);
    }
    
}   
