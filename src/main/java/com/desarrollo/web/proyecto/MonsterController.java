package com.desarrollo.web.proyecto;
import java.util.ArrayList;
import com.desarrollo.web.proyecto.Data.Monster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/monster")
public class MonsterController {

    @Autowired
    ArrayList<Monster> monsters;

    @RequestMapping("/list")
    String showMonsters(){

        return "listMonsters";
    }

    @RequestMapping("/create")
    String createMonster(){

        System.out.println(monsters.get(0).getName());
        return "createMonster";
    }


    
}
