package com.desarrollo.web.proyecto;

import java.util.ArrayList;

import com.desarrollo.web.proyecto.Model.DecorativeItem;

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
@RequestMapping("/decoItem")

public class DecoItemsController {

    @Autowired
    ArrayList<DecorativeItem> decoItems;

    Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/list")
    String showItems(Model model){

        model.addAttribute("datos",decoItems);
        return "decoitem-list";
    }

    

    @GetMapping("/delete")
    String deleteDecoItem(Model model,@RequestParam Long id){

        DecorativeItem decoItem = getById(id);

        decoItems.remove(decoItem);

        return "redirect:/decoItem/list";
    }

    @GetMapping("/edit")
    String editDecoItem(Model model,@RequestParam Long id){

        DecorativeItem selected = getById(id);
        model.addAttribute("selected", selected);

        return "decoitem-edit";
    }

    @PostMapping("/save")
    String saveData(Model model,@ModelAttribute DecorativeItem dItem){

        Integer index = findById(dItem.getId());

        if(index != -1 ){
            
            decoItems.set(index, dItem);

        }else{
            decoItems.add(dItem);
        } 

        return "redirect:/decoItem/list";
    }

    @GetMapping("/create")
    String createMonster(Model model){
        log.info("ENTRO AL CREATE");

        model.addAttribute("newItem", new DecorativeItem());
        return "decoitem-create";
    }

    DecorativeItem getById(Long id) {

        DecorativeItem retorno = null;

        for (DecorativeItem item : decoItems) {

            if (id == item.getId()) {

                retorno = item;
            }
        }

        return retorno;
    }

    Integer findById(Long id){

        for (int index = 0; index < decoItems.size(); index++) {
            
            if(decoItems.get(index).getId().longValue() == id){
                
                return index;
            }

        }

        return -1;
    }

}
