package com.desarrollo.web.proyecto.Controllers;
import java.util.List;
import com.desarrollo.web.proyecto.Db.DecorativeItemRepository;
import com.desarrollo.web.proyecto.Model.DecorativeItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/decoItem")
public class DecoItemsController {

    @Autowired
    DecorativeItemRepository decoItemRepository;

    Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/list")
    @CrossOrigin("http://localhost:4200")
    List<DecorativeItem> showDecoItems() {
        return (List<DecorativeItem>) decoItemRepository.findAll();
    }

    @GetMapping("/{id}/get")
    @CrossOrigin("http://localhost:4200")
    DecorativeItem getDecoItem(@PathVariable Long id) {
        DecorativeItem selected = decoItemRepository.findById(id).orElseThrow();
        return selected;
    }

    @PostMapping("/save")
    @CrossOrigin("http://localhost:4200")
    DecorativeItem saveData(@RequestBody DecorativeItem dItem) {
        return decoItemRepository.save(dItem);
    }

    @PostMapping("/{id}/delete")
    @CrossOrigin("http://localhost:4200")
    void deleteDecoItem(@PathVariable Long id) {
        decoItemRepository.deleteById(id);
    }
    
}
