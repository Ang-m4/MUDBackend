package com.desarrollo.web.proyecto.Controllers;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    String listRooms(Model model) {

        model.addAttribute("datos", roomRepository.findAll());
        return "room-list";
    }

    @GetMapping("/show")
    String showRoom(Model model, @RequestParam Long id) {

        log.info(" El id del cuarto a mostrar es " + id);
        Room selected = roomRepository.findById(id).orElseThrow();
        log.info(" Encontro el cuarto " + id);
        model.addAttribute("selected", selected);
        log.info(" Agrego el cuarto " + id);
        return "room-show";
    }

    @GetMapping("/edit")
    String editRoom(Model model, @RequestParam Long id) {

        Room selected = roomRepository.findById(id).orElseThrow();
        model.addAttribute("selected", selected);
        return "room-edit";
    }

    @PostMapping("/save")
    String saveData(@ModelAttribute Room room,
            @RequestParam String decoItemsAdd,
            @RequestParam String itemsAdd,
            @RequestParam String playersAdd,
            @RequestParam String monsterAdd,
            @RequestParam String exitsAdd) {

        log.info(decoItemsAdd);
        log.info(itemsAdd);
        log.info(playersAdd);
        log.info(monsterAdd);
        log.info(exitsAdd);
        log.info(" El id del cuarto es " + room.getId());
        log.info(" El nombre del cuarto es " + room.getName());

        String[] listIds = decoItemsAdd.split(",");

        if (!listIds[0].isEmpty()) {

            for (int i = 0; i < listIds.length; i++) {

                if (decorativeItemRepository.findById(Long.parseLong(listIds[i])).isPresent()) {
                    DecorativeItem decoItem = decorativeItemRepository.findById(Long.parseLong(listIds[i]))
                            .orElseThrow();
                    log.info("dECO ITEM " + decoItem.getName());
                    log.info("estado: " + room.getDecorativeItems().add(decoItem));
                } else {
                    log.info("No se encontro el item descrito");
                }
            }

        }

        listIds = itemsAdd.split(",");

        if (!listIds[0].isEmpty()) {

            for (int i = 0; i < listIds.length; i++) {

                if (itemRepository.findById(Long.parseLong(listIds[i])).isPresent()) {
                    Item item = itemRepository.findById(Long.parseLong(listIds[i])).orElseThrow();
                    log.info("ITEM " + item.getName());
                    log.info("estado: " + room.getItems().add(item));
                } else {
                    log.info("No se encontro el item " + listIds[i]);
                }

            }
        }

        listIds = playersAdd.split(",");

        if (!listIds[0].isEmpty()) {

            for (int i = 0; i < listIds.length; i++) {

                if (playerRepository.findById(Long.parseLong(listIds[i])).isPresent()) {

                    Player player = playerRepository.findById(Long.parseLong(listIds[i])).orElseThrow();
                    log.info("player " + player.getName());
                    player.setLocation(room);
                } else {
                    log.info("No se encontro el item " + listIds[i]);
                }
            }
        }

        if (!monsterAdd.isEmpty()) {
            if (monsterAdd.matches("^[0-9]*$")) {

                if (monsterRepository.findById(Long.parseLong(monsterAdd)).isPresent()) {
                    Monster monster = monsterRepository.findById(Long.parseLong(monsterAdd)).orElseThrow();
                    room.setMonster(monster);
                }

            }
        }
        

        listIds = exitsAdd.split(",");

        if (!listIds[0].isEmpty()) {

            for (int i = 0; i < listIds.length; i++) {

                if (roomRepository.findById(Long.parseLong(listIds[i])).isPresent()) {

                    Room roomA = roomRepository.findById(Long.parseLong(listIds[i])).orElseThrow();
                    log.info("player " + room.getName());
                    room.getExits().add(roomA);
                } else {
                    log.info("No se encontro el item " + listIds[i]);
                }
            }
        }

        roomRepository.save(room);
        return "redirect:/room/list";
    }

    @GetMapping("/create")
    String createRoom(Model model) {


        model.addAttribute("items",itemRepository.findAll());
        model.addAttribute("players",playerRepository.findAll());
        model.addAttribute("rooms",roomRepository.findAll());
        model.addAttribute("decoItems",decorativeItemRepository.findAll());
        model.addAttribute("monsters",monsterRepository.findAll());
        return "room-create";
    }

    @GetMapping("/delete")
    String deleteRoom(Model model, @RequestParam Long id) {

        roomRepository.deleteById(id);
        return "redirect:/room/list";
    }

}