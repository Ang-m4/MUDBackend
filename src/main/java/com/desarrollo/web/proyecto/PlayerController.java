package com.desarrollo.web.proyecto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/player")
public class PlayerController {
    
    @RequestMapping("/list")
    String showPlayers(){

        return "listPlayers";
    }
    @RequestMapping("/create")
    String createPlayer(){

        return "createPlayer";
    }
}   
