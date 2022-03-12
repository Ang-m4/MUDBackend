package com.desarrollo.web.proyecto;

import java.util.ArrayList;
import com.desarrollo.web.proyecto.Model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProyectoApplication {

	Logger log = LoggerFactory.getLogger(getClass());
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

    @Bean
    ArrayList<Player> loadPlayers(){

        ArrayList<Player> playerList = new ArrayList<>();

        Player a = new Player();
        Player b = new Player();
        a.setId(1l);
        a.setName("PRIMERO");
        b.setId(2l);
        b.setName("SEGUNDO");

        Item ia = new Item();
        ia.setName("item1");
        Item iab = new Item();
        iab.setName("item2");

        b.getBackpack().add(ia);
        b.getBackpack().add(iab);

        a.getBackpack().add(ia);
        a.getBackpack().add(iab);

        a.getCategory().add("CAT1");
        a.getCategory().add("CATb");

        b.getCategory().add("CAT1");
        b.getCategory().add("CATb");

        playerList.add(a);
        playerList.add(b);

        return playerList;
    }

    @Bean
    ArrayList<Room> createRooms(){
        ArrayList<Room> retorno = new ArrayList<>();
        return retorno;
    }
    
}