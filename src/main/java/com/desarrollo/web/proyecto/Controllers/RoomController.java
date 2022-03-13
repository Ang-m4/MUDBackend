package com.desarrollo.web.proyecto.Controllers;

import java.util.ArrayList;

import com.desarrollo.web.proyecto.Db.DecorativeItemRepository;
import com.desarrollo.web.proyecto.Db.ItemRepository;
import com.desarrollo.web.proyecto.Db.MonsterRepository;
import com.desarrollo.web.proyecto.Db.PlayerRepository;
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
    ItemRepository itemRepository;

    @Autowired
    DecorativeItemRepository decorativeItemRepository;

    @Autowired
    MonsterRepository monsterRepository;

    @Autowired
    PlayerRepository playerRepository;

    Logger log = LoggerFactory.getLogger(getClass());

    // @GetMapping("/list")
    // String showRooms(Model model) {

    //     model.addAttribute("datos", rooms);
    //     return "room-list";
    // }

    // @GetMapping("/create")
    // String createRoom(Model model, Long i) {

    //     model.addAttribute("items", itemRepository.findAll());
    //     model.addAttribute("monsters", monsterRepository.findAll());
    //     model.addAttribute("decoItems",decorativeItemRepository.findAll());
    //     model.addAttribute("players", playerRepository.findAll());
    //     model.addAttribute("rooms", rooms);
    //     model.addAttribute("room", new Room());

    //     return "room-create";
    // }

    // @PostMapping("/addItem")
    // String agregarItem(Long idItem, Room room, Model model) {

    //     log.info("Entramos al Add");
    //     log.info(idItem.toString());
    //     log.info("El tam de los items es " + room.getItems().size());

    //     return "room-create";
    // }

}