package com.desarrollo.web.proyecto.Controllers;

import java.util.ArrayList;
import java.util.Arrays;

import com.desarrollo.web.proyecto.Db.ItemRepository;
import com.desarrollo.web.proyecto.Db.PlayerRepository;
import com.desarrollo.web.proyecto.Model.Item;
import com.desarrollo.web.proyecto.Model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/list")
    String showPlayers(Model model){
        
        model.addAttribute("datos",playerRepository.findAll());
        return "player-list";
    }
    
    @GetMapping("/edit")
    String editPlayer(Model model,@RequestParam Long id) {
        
        Player selected = playerRepository.findById(id).orElseThrow();
        model.addAttribute("selected",selected);
        model.addAttribute("items", itemRepository.findAll());
        return "player-edit";
    }
    
    @GetMapping("/create")
    String createPlayer(Model model){
        
        model.addAttribute("selected",new Player());
        model.addAttribute("items", itemRepository.findAll());
        return "player-create";
    }

    @GetMapping("/show")
    String showPlayer(Model model,@RequestParam Long id){

        Player  selected = playerRepository.findById(id).orElseThrow();
        model.addAttribute("selected",selected);
        return "player-show";
    }

    @PostMapping("/save")
    String saveData(@ModelAttribute Player player,@RequestParam String categories,@RequestParam String items){
       
        ArrayList<String> catego = new ArrayList<>(Arrays.asList(categories.split(",")));
        player.setCategory(catego);
        String[] itemIds = items.split(",");

        if(!itemIds[0].isEmpty()){
            for (int i = 0; i < itemIds.length; i++) {
            
                if(itemRepository.findById(Long.parseLong(itemIds[i])).isPresent()){
                    Item item = itemRepository.findById(Long.parseLong(itemIds[i])).orElseThrow();
                    player.getBackpack().add(item);
                }else{
                    log.info("No se encontro el item descrito");
                }
            }
        }
        
        playerRepository.save(player);
        return "redirect:/player/list";
    }

    @GetMapping("/delete")
    String deleteMonster(Model model,@RequestParam Long id){
        
        playerRepository.deleteById(id);
        return "redirect:/player/list";
    }
    
}   
