package com.desarrollo.web.proyecto;

import java.util.ArrayList;
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

@Controller
@RequestMapping("/item")
public class ItemController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ArrayList<Item> items;

    @GetMapping("/list")
    String showItems(Model model) {

        model.addAttribute("datos", items);
        return "item-list";
    }

    @GetMapping("/show")
    String showItem(Model model, @RequestParam Long id) {

        Item selected = getById(id);
        model.addAttribute("selected", selected);

        return "item-show";
    }

    @GetMapping("/edit")
    String editItems(Model model, @RequestParam Long id) {

        Item selected = getById(id);
        model.addAttribute("selected", selected);

        return "item-edit";
    }

    @GetMapping("/delete")
    String deleteItem(Model model, @RequestParam Long id) {

        Item selected = getById(id);

        items.remove(selected);

        return "redirect:/item/list";
    }

    @PostMapping("/save")
    String saveData(@ModelAttribute Item item, Model model) {

        if(getById(item.getId()) != null){

            items.set(findById(item.getId()), item);

        }else{

            if(findByName(item.getName()) == -1){

                items.add(item);

            }else{
                items.set(findByName(item.getName()), item);
            }

        }        
    

        return "redirect:/item/list";
    }

    @GetMapping("/create")
    String createItem(Model model) {

        model.addAttribute("newItem", new Item());
        return "item-create";

    }

    Item getById(Long id) {

        Item retorno = null;

        for (Item item : items) {

            if (id == item.getId()) {

                retorno = item;
            }
        }

        return retorno;
    }

    Integer findByName(String name){

        for (int index = 0; index < items.size(); index++) {
            
            if(items.get(index).getName().contains(name)){
                
                return index;
            }

        }

        return -1;
    }

    Integer findById(Long id){

        for (int index = 0; index < items.size(); index++) {
            
            if(items.get(index).getId().longValue() == id){
                
                return index;
            }

        }

        return -1;
    }

}
