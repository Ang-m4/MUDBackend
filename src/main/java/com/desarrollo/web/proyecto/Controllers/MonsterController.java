package com.desarrollo.web.proyecto.Controllers;
import java.util.List;

import com.desarrollo.web.proyecto.Db.MonsterRepository;
import com.desarrollo.web.proyecto.Model.Monster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monster")
public class MonsterController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    MonsterRepository monsterRepository;
    
    @GetMapping("/list")
    @CrossOrigin("http://localhost:4200")
    List<Monster> showMonsters(){

        return (List<Monster>) monsterRepository.findAll();
    }

    @GetMapping("/{id}/show")   
    @CrossOrigin("http://localhost:4200")
    Monster showMonster(@PathVariable Long id){
        
        Monster selected = monsterRepository.findById(id).orElseThrow();
        return selected;
    }

    @GetMapping("/{id}/edit")
    Monster editMonster( Long id){
       
        Monster selected = monsterRepository.findById(id).orElseThrow();
        return selected;
    }

    @GetMapping("/{id}/delete")
    void deleteMonster(@PathVariable Long id){
        monsterRepository.deleteById(id);
    }

    @PostMapping("/{id}/save")
    Monster saveData(@RequestBody Monster monster, @RequestParam String categories){
        return monsterRepository.save(monster);
    }
    
    @PostMapping("/create")
    Monster createMonster(@RequestBody Monster newMonster){
        
        return monsterRepository.save(newMonster);

    }
    
}
