package com.desarrollo.web.proyecto.Controllers;

import java.util.ArrayList;

import com.desarrollo.web.proyecto.Db.DecorativeItemRepository;
import com.desarrollo.web.proyecto.Db.ItemRepository;
import com.desarrollo.web.proyecto.Db.MonsterRepository;
import com.desarrollo.web.proyecto.Db.PlayerRepository;
import com.desarrollo.web.proyecto.Db.RoomRepository;
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

    @Autowired
    RoomRepository roomRepository;

    Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/list")
    String showRooms(Model model) {

        model.addAttribute("datos", roomRepository.findAll());
        return "room-list";
    }

}