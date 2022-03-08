package com.desarrollo.web.proyecto;

import java.util.ArrayList;

import com.desarrollo.web.proyecto.Model.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/player")
public class PlayerController {
    
    @Autowired
    ArrayList<Player> players;

    @GetMapping("/list")
    String showPlayers(){
        
        return "listPlayers";
    }
    
    @GetMapping("/create")
    String createPlayer(){

        return "createPlayer";
    }

}   
