package com.desarrollo.web.proyecto;

import java.util.ArrayList;
import com.desarrollo.web.proyecto.Model.NPC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/monster")
public class NPCController {

    Logger log = LoggerFactory.getLogger(getClass());


    @Autowired
    ArrayList<NPC> monsters;
    
    @GetMapping("/list")
    String showMonsters(Model model){

        model.addAttribute("datos",monsters);
        model.addAttribute("ruta", "monster");
        return "monster-list";
    }

    @GetMapping("/edit")
    String createMonster(){
        

        return "monster-edit";
    }

}
