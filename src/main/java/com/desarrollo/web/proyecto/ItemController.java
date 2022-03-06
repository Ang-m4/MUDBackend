package com.desarrollo.web.proyecto;

import java.util.ArrayList;

import com.desarrollo.web.proyecto.Model.DecorativeItem;
import com.desarrollo.web.proyecto.Model.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ArrayList<Item> items;

    @Autowired
    ArrayList<DecorativeItem> decoItems;

    @RequestMapping("/list")
    String showItems(Model model){
        
        model.addAttribute("items",items);
        return "listItems";
    }

    
    @RequestMapping("/create")
    String createItems(){

        return "createItem";
    }


}   
