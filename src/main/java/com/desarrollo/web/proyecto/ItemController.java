package com.desarrollo.web.proyecto;

import java.util.ArrayList;

import com.desarrollo.web.proyecto.Model.DecorativeItem;
import com.desarrollo.web.proyecto.Model.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ArrayList<Item> items;

    @Autowired
    ArrayList<DecorativeItem> decoItems;

    @GetMapping("/list")
    String showItems(Model model){
        
        model.addAttribute("items",items);
        return "listItems";
    }

    
    @GetMapping("/create")
    String createItems(){

        return "createItem";
    }


}   
