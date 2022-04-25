package com.desarrollo.web.proyecto.Controllers;

import com.desarrollo.web.proyecto.Db.ItemRepository;
import com.desarrollo.web.proyecto.Model.Item;
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
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;
    Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/list")
    @CrossOrigin("http://localhost:4200")
    List<Item> showItems() {
        return (List<Item>) itemRepository.findAll();
    }

    @GetMapping("/{id}/get")
    @CrossOrigin("http://localhost:4200")
    Item getItem(@PathVariable Long id) {
        Item selected = itemRepository.findById(id).orElseThrow();
        return selected;
    }

    @PostMapping("/save")
    @CrossOrigin("http://localhost:4200")
    Item saveData(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @GetMapping("/{id}/delete")
    @CrossOrigin("http://localhost:4200")
    void deleteItem(@PathVariable Long id) {
        itemRepository.deleteById(id);  
    }

}
