package com.desarrollo.web.proyecto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.desarrollo.web.proyecto.Db.PlayerRepository;
import com.desarrollo.web.proyecto.Model.Player;

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


@ActiveProfiles("integrationtest")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IntegrationPlayerTests {
    
    @LocalServerPort
    private int port;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TestRestTemplate rest;

    @BeforeEach
    void init() {

        Player pA = new Player();
        pA.setName("Alice");
        pA.setAttack_level(30);
        pA.setSize(30);
        pA.setWeight(0l);
        pA.setMaxWeight(100l);
        pA.getCategory().add("Categoria Uno");
        pA.getCategory().add("Categoria Dos");

        Player pB = new Player();
        pB.setName("Bob");
        pB.setAttack_level(20);
        pB.setSize(20);
        pB.setWeight(0l);
        pB.setMaxWeight(100l);
        pB.getCategory().add("Categoria Uno");
        pB.getCategory().add("Categoria Dos");

        playerRepository.save(pA);
        playerRepository.save(pB);

    }

    
    @Test
    void getPlayerTest() {

        Player player = this.rest.getForObject("http://localhost:" + port + "/player/2/get",
                Player.class);

        assertEquals("Bob", player.getName());

    }

    @Test
    void createPlayerTest() {

        Player newPlayer = this.rest.postForObject(
                "http://localhost:" + port + "/player/save",
                new Player("new player"),
                Player.class);

        assertEquals("new player", newPlayer.getName());

    }

    @Test
    void editPlayerTest() {

        Long id = 2l;

        Player editPlayer = new Player("Bob edited");
        editPlayer.setId(2l);

        this.rest.postForObject(
                "http://localhost:" + port + "/player/save",
                editPlayer,
                Player.class);

        Player player = this.rest.getForObject("http://localhost:" + port + "/player/" + id + "/get",
                Player.class);

        assertEquals("Bob edited",player.getName());

    }

    @Test
    void deleteMonsterTest() {

        String message = this.rest.getForObject(
                "http://localhost:" + port + "/player/1/delete", String.class);

        assertEquals("player deleted", message);

    }

}
