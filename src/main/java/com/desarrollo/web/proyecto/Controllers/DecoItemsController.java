package com.desarrollo.web.proyecto.Controllers;

import java.util.ArrayList;
import java.util.List;

import com.desarrollo.web.proyecto.Db.DecorativeItemRepository;
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
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/decoItem")

public class DecoItemsController {


    @Autowired
    DecorativeItemRepository decoItemRepository;

    Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/list")
    List<DecorativeItem> showItems(Model model){

        ArrayList<DecorativeItem> decoItems = new ArrayList<>();
        decoItemRepository.findAll().forEach(decoItems::add);

        model.addAttribute("datos",decoItems);
        return (List<DecorativeItem>) decoItemRepository.findAll();
    }

    @GetMapping("/show")
    DecorativeItem showItem(Model model, @RequestParam Long id) {

        DecorativeItem selected = decoItemRepository.findById(id).orElseThrow();
        model.addAttribute("selected", selected);

        return selected;
    }


    @GetMapping("/delete")
    String deleteDecoItem(Model model,@RequestParam Long id){

        decoItemRepository.deleteById(id);

        return "redirect:/decoItem/list";
    }

    @GetMapping("/edit")
    String editDecoItem(Model model,@RequestParam Long id){

        DecorativeItem selected = decoItemRepository.findById(id).orElseThrow();
        model.addAttribute("selected", selected);

        return "decoitem-edit";
    }

    @PostMapping("/save")
    String saveData(Model model,@ModelAttribute DecorativeItem dItem){

        decoItemRepository.save(dItem);
        return "redirect:/decoItem/list";
    }

    @GetMapping("/create")
    String createMonster(Model model){

        model.addAttribute("newItem", new DecorativeItem());
        return "decoitem-create";
    }

    

}
