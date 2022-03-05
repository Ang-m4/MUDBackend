package com.desarrollo.web.proyecto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/monster")
public class MonsterController {

    @RequestMapping("/list")
    String showMonsters(){

        return "listMonsters";
    }

    @RequestMapping("/create")
    String createMonster(){

        return "createMonster";
    }
}
