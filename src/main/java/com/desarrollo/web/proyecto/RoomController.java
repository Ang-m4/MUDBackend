package com.desarrollo.web.proyecto;

import java.util.ArrayList;
import com.desarrollo.web.proyecto.Model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    ArrayList<Item> items;

    @Autowired
    ArrayList<Monster> monsters;

    @Autowired
    ArrayList<DecorativeItem> decoItems;

    @Autowired
    ArrayList<Player> players;

    @Autowired
    ArrayList<Room> rooms;

    Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/list")
    String showRooms(Model model) {

        model.addAttribute("datos", rooms);
        return "room-list";
    }

    @GetMapping("/create")
    String createRoom(Model model, Long i) {

        model.addAttribute("items", items);
        model.addAttribute("monsters", monsters);
        model.addAttribute("decoItems", decoItems);
        model.addAttribute("players", players);
        model.addAttribute("rooms", rooms);
        model.addAttribute("room", new Room());

        return "room-create";
    }

    @PostMapping("/addItem")
    String agregarItem(Long idItem, Room room, Model model) {

        log.info("Entramos al Add");
        log.info(idItem.toString());
        room.getItems().add(items.get(0));

        
        log.info("El tam de los items es " + room.getItems().size());

        return "room-create";
    }

}