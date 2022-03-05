package com.desarrollo.web.proyecto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Monster")
public class MonsterController {

    @RequestMapping("list")
    String showMonsters(){

        return "listMonsters";
    }

    @RequestMapping("Create")
    String createMonster(){

        return "createMonster";
    }
}
