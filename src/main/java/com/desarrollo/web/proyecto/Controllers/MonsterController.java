package com.desarrollo.web.proyecto.Controllers;

import java.util.ArrayList;
import java.util.Arrays;

import com.desarrollo.web.proyecto.Db.MonsterRepository;
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
    MonsterRepository monsterRepository;
    
    @GetMapping("/list")
    String showMonsters(Model model){

        model.addAttribute("datos",monsterRepository.findAll());
        return "monster-list";
    }

    @GetMapping("/show")
    String showMonster(Model model,@RequestParam Long id){
        
        Monster selected = monsterRepository.findById(id).orElseThrow();
        model.addAttribute("selected",selected);
        return "monster-show";
    
    }

    @GetMapping("/edit")
    String editMonster(Model model,@RequestParam Long id){
       
        Monster selected = monsterRepository.findById(id).orElseThrow();
        model.addAttribute("selected",selected);
        return "monster-edit";
    }

    @GetMapping("/delete")
    String deleteMonster(Model model,@RequestParam Long id){
        
        monsterRepository.deleteById(id);
        return "redirect:/monster/list";

    }

    @PostMapping("/save")
    String saveData(@ModelAttribute Monster monster,@RequestParam String categories){
        
        ArrayList<String> catego = new ArrayList<>(Arrays.asList(categories.split(",")));
        monster.setCategory(catego);
        monsterRepository.save(monster);
        return "redirect:/monster/list";
    }
    
    @GetMapping("/create")
    String createMonster(Model model){
        
        model.addAttribute("selected", new Monster());
        return "monster-create";

    }
    
}
