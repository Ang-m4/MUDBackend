package com.desarrollo.web.proyecto;
import java.util.ArrayList;
import com.desarrollo.web.proyecto.Data.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    ArrayList<Item> items;

    @Autowired
    ArrayList<DecorativeItem> decoItems;
   
    @RequestMapping("/list")
    String showRooms(){
        return "listRooms";
    }

    @RequestMapping("/create")
    String createRoom(){
        return "createRoom";
    }


}   
