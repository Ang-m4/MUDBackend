package com.desarrollo.web.proyecto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.desarrollo.web.proyecto.Db.ItemRepository;

import com.desarrollo.web.proyecto.Model.Item;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import com.fasterxml.jackson.core.type.TypeReference;

@ActiveProfiles("integrationtest")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IntegrationItemTests {

    @LocalServerPort
    private int port;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    TestRestTemplate rest;

    @BeforeEach
    void init() {

        ObjectMapper objectMapper = new ObjectMapper();
        List<Item> itemList = new ArrayList<>();
        try {
            itemList = objectMapper.readValue(
                    new File("Assets/itemsTest.json"),
                    new TypeReference<List<Item>>() {
                    });

        } catch (IOException e) {

            e.printStackTrace();
        }
        itemRepository.saveAll(itemList);
    }

    @Test
    void getItemTest() {

        Item item = this.rest.getForObject("http://localhost:" + port + "/item/3/get",
                Item.class);

        assertEquals("Cannonball", item.getName());

    }

    @Test
    void createItemTest() {

        Item decoItem = this.rest.postForObject(
                "http://localhost:" + port + "/item/save",
                new Item("new Item"),
                Item.class);

        assertEquals("new Item", decoItem.getName());

    }

    @Test
    void editItemTest() {

        Long id = 2l;

        Item editDecoItem = new Item("Toolkit edited");
        editDecoItem.setId(2l);

        this.rest.postForObject(
                "http://localhost:" + port + "/item/save",
                editDecoItem,
                Item.class);

        Item decoItem = this.rest.getForObject("http://localhost:" + port + "/item/" + id + "/get",
                Item.class);

        assertEquals("Toolkit edited", decoItem.getName());

    }

    @Test
    void deleteItemTest() {

        String message = this.rest.getForObject(
                "http://localhost:" + port + "/item/1/delete", String.class);

        assertEquals("item deleted", message);

    }

}
