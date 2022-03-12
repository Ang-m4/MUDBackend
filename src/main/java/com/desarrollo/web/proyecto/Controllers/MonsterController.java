package com.desarrollo.web.proyecto.Controllers;

import java.util.ArrayList;
import com.desarrollo.web.proyecto.Model.Monster;

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
@RequestMapping("/monster")
public class MonsterController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ArrayList<Monster> monsters;
    
    @GetMapping("/list")
    String showMonsters(Model model){

        model.addAttribute("datos",monsters);
        model.addAttribute("ruta", "monster");
        return "monster-list";
    }

    @GetMapping("/show")
    String showMonster(Model model,@RequestParam Long id){
        
        Monster selected = getById(id);
        model.addAttribute("selected",selected);
        return "monster-show";
    
    }

    @GetMapping("/edit")
    String editMonster(Model model,@RequestParam Long id){
       
        Monster selected = getById(id);
        model.addAttribute("selected",selected);
        return "monster-edit";
    }

    @GetMapping("/delete")
    String deleteMonster(Model model,@RequestParam Long id){
        
        Monster selected = getById(id);
        monsters.remove(selected);

        return "redirect:/monster/list";
    }

    @PostMapping("/save")
    String saveData(@ModelAttribute Monster monster,Model model){
       
        Integer index = findById(monster.getId());

        if(index != -1 ){
            
            monsters.set(index, monster);

        }else{
            monsters.add(monster);
        }
        
        return "redirect:/monster/list";
    }
    
    @GetMapping("/create")
    String createMonster(Model model){

        model.addAttribute("selected", new Monster());
        return "monster-create";
    }
   
    Monster getById(Long id){

        Monster retorno = null;

        for(Monster monster : monsters){

            if( monster.getId() == id ){

                return monster;
            }
        }

        return retorno;
    }

    Integer findById(Long id){

        for (int index = 0; index < monsters.size(); index++) {
            
            if(monsters.get(index).getId().longValue() == id){
                
                return index;
            }

        }

        return -1;
    }
}
