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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monster")
public class MonsterController {

    @Autowired
    MonsterRepository monsterRepository;
    Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/list")
    @CrossOrigin("http://localhost:4200")
    List<Monster> showMonsters() {
        return (List<Monster>) monsterRepository.findAll();
    }

    @GetMapping("/{id}/get")
    @CrossOrigin("http://localhost:4200")
    Monster getMonster(@PathVariable Long id) {
        Monster selected = monsterRepository.findById(id).orElseThrow();
        return selected;
    }

    @PostMapping("/save")
    Monster saveData(@RequestBody Monster newMonster) {
        return monsterRepository.save(newMonster);
    }

    @PostMapping("/{id}/delete")
    void deleteMonster(@PathVariable Long id) {
        monsterRepository.deleteById(id);
    }

}
