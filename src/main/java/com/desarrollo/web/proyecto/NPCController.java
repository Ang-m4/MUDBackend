package com.desarrollo.web.proyecto;

import java.util.ArrayList;
import com.desarrollo.web.proyecto.Model.NPC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/monster")
public class NPCController {

    @Autowired
    ArrayList<NPC> monsters;
    
    @GetMapping("/list")
    String showMonsters(Model model){

        NPC a = new NPC();
        System.out.println("Monsters" + monsters.size());
        a.setName("Maria");
        monsters.add(a);
        model.addAttribute("monsters",monsters);
        return "listMonsters";
    }

    @GetMapping("/create")
    String createMonster(){

        System.out.println("Monsters" + monsters.size());
        return "createMonster";
    }

}
