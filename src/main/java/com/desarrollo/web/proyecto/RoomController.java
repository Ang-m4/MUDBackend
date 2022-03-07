package com.desarrollo.web.proyecto;

import java.util.ArrayList;
import com.desarrollo.web.proyecto.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    ArrayList<Item> items;

    @Autowired
    ArrayList<NPC> monsters;
    
    @Autowired
    ArrayList<DecorativeItem> decoItems;

    @Autowired
    ArrayList<Player> players;

    @GetMapping("/list")
    String showRooms(){
       
        return "listRooms";
    }
    
    @GetMapping("/create")
    String createRoom(){
        
        return "createRoom";
    }

}   