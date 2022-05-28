package com.desarrollo.web.proyecto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.desarrollo.web.proyecto.Db.RoomRepository;
import com.desarrollo.web.proyecto.Model.Room;

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
public class IntegrationRoomTests {
    

    @LocalServerPort
    private int port;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    TestRestTemplate rest;

    @BeforeEach
    void init() {

        Room roomA = new Room();
        roomA.setName("Room A");
        roomRepository.save(roomA);

        Room rB = new Room();
        rB.setName("Room B");
        roomRepository.save(rB);

    }

    @Test
    void getRoomTest() {

        Room room = this.rest.getForObject("http://localhost:" + port + "/room/2/get",
                Room.class);

        assertEquals("Room B", room.getName());

    }

    @Test
    void createRoomTest() {

        Room newRoom = this.rest.postForObject(
                "http://localhost:" + port + "/room/save",
                new Room("new room"),
                Room.class);

        assertEquals("new room", newRoom.getName());

    }

    @Test
    void editRoomTest() {

        Long id = 2l;

        Room editDecoMonster = new Room("Room B edited");
        editDecoMonster.setId(2l);

        this.rest.postForObject(
                "http://localhost:" + port + "/room/save",
                editDecoMonster,
                Room.class);

        Room room = this.rest.getForObject("http://localhost:" + port + "/room/" + id + "/get",
                Room.class);

        assertEquals("Room B edited",room.getName());

    }

    @Test
    void deleteMonsterTest() {

        String message = this.rest.getForObject(
                "http://localhost:" + port + "/room/1/delete", String.class);

        assertEquals("room deleted", message);

    }

}
