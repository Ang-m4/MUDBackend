package com.desarrollo.web.proyecto;

import java.util.ArrayList;

import com.desarrollo.web.proyecto.Model.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/player")
public class PlayerController {
    
    @Autowired
    ArrayList<Player> players;
    

    @GetMapping("/list")
    String showPlayers(Model model){
        
        model.addAttribute("datos",players);
        return "player-list";
    }
    
    @GetMapping("/edit")
    public String editPlayer(Model model,@RequestParam Long id) {
        
        Player selected = getById(id);
        model.addAttribute("selected",selected);
        
        return "player-edit";
    }
    

    @GetMapping("/create")
    String createPlayer(Model model){
        
        model.addAttribute("selected",new Player());
        return "player-create";
    }


    @GetMapping("/show")
    String showPlayer(Model model,@RequestParam Long id){

        Player  selected = getById(id);
        model.addAttribute("selected",selected);
        return "player-show";
    }


    @PostMapping("/save")
    String saveData(@ModelAttribute Player player,Model model){
       
        Integer index = findById(player.getId());

        if(index != -1 ){
            
            players.set(index, player);

        }else{
            players.add(player);
        }
        
        return "redirect:/player/list";
    }

    @GetMapping("/delete")
    String deleteMonster(Model model,@RequestParam Long id){
        
        Player selected = getById(id);
        players.remove(selected);

        return "redirect:/player/list";
    }

    Player getById(Long id){

        Player retorno = null;

        for(Player player : players){
            if( player.getId() == id ){
                return player;
            }
        }

        return retorno;
    }

    Integer findById(Long id){

        for (int index = 0; index < players.size(); index++) {
            
            if(players.get(index).getId().longValue() == id){
                
                return index;
            }
        }
        return -1;
    }
}   
