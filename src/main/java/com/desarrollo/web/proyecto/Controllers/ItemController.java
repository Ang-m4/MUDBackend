package com.desarrollo.web.proyecto.Controllers;

import com.desarrollo.web.proyecto.Db.ItemRepository;
import com.desarrollo.web.proyecto.Model.Item;
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
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Controller
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/list")
    List<Item> showItems(Model model) {

        model.addAttribute("datos",itemRepository.findAll());
        return (List<Item>) itemRepository.findAll();
    }   

    //http://localhost:8080/item/show?id=41
    @GetMapping("/show")
    Item showItem(Model model, @RequestParam Long id) {

        Item selected = itemRepository.findById(id).orElseThrow();
        model.addAttribute("selected", selected);

        return selected;
    }

    @GetMapping("/edit")
    String editItems(Model model, @RequestParam Long id) {

        Item selected = itemRepository.findById(id).orElseThrow();
        model.addAttribute("selected", selected);
        
        return "item-edit";
    }

    @GetMapping("/delete")
    String deleteItem(Model model, @RequestParam Long id) {

        itemRepository.deleteById(id);

        return "redirect:/item/list";
    }

    @PostMapping("/save")
    String saveData(@ModelAttribute Item item, Model model) {

        
        itemRepository.save(item);

        return "redirect:/item/list";
    }

    @GetMapping("/create")
    String createItem(Model model) {

        model.addAttribute("newItem", new Item());
        return "item-create";

    }

}
