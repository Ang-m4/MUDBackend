package com.desarrollo.web.proyecto.Controllers;

import com.desarrollo.web.proyecto.Db.ItemRepository;
import com.desarrollo.web.proyecto.Db.PlayerRepository;
import com.desarrollo.web.proyecto.Model.Item;
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
    PlayerRepository playerRepository;
    
    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/list")
    String showPlayers(Model model){
        
        model.addAttribute("datos",playerRepository.findAll());
        return "player-list";
    }
    
    @GetMapping("/edit")
    public String editPlayer(Model model,@RequestParam Long id) {
        
        Player selected = playerRepository.findById(id).orElseThrow();
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

        Player  selected = playerRepository.findById(id).orElseThrow();
        model.addAttribute("selected",selected);
        return "player-show";
    }


    @PostMapping("/save")
    String saveData(@ModelAttribute Player player,Model model){
       
        Item iA = itemRepository.findById(41l).orElseThrow();
        Item iB = itemRepository.findById(45l).orElseThrow();

        player.getBackpack().add(iA);
        player.getBackpack().add(iB);

        playerRepository.save(player);
        return "redirect:/player/list";
    }

    @GetMapping("/delete")
    String deleteMonster(Model model,@RequestParam Long id){
        
        playerRepository.deleteById(id);
        return "redirect:/player/list";
    }
}   
