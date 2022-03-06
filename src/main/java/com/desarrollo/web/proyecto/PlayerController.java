package com.desarrollo.web.proyecto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/player")
public class PlayerController {
    
    @GetMapping("/list")
    String showPlayers(){

        return "listPlayers";
    }
    
    @GetMapping("/create")
    String createPlayer(){

        return "createPlayer";
    }

}   
