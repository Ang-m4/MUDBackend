package com.desarrollo.web.proyecto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room")
public class RoomController {
   
    @RequestMapping("/list")
    String showRooms(){

        return "listRooms";
    }

    @RequestMapping("/create")
    String createRoom(){

        return "createRoom";
    }

}   
