package com.desarrollo.web.proyecto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Player")
public class PlayerController {
    
    @RequestMapping("list")
    String showPlayers(){

        return "listPlayers";
    }
    @RequestMapping("Create")
    String createPlayer(){

        return "createPlayer";
    }
}   
