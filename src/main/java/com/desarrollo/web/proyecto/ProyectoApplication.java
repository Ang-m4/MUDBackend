package com.desarrollo.web.proyecto;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.desarrollo.web.proyecto.Data.*;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    ArrayList<Monster> loadMonsters() {
		
		ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		TypeReference<List<Monster>> typeReference = new TypeReference<List<Monster>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/assets/monstruos.json");
       
		List<Monster> monsterList = new ArrayList<>();
        
        try {
            
            monsterList = (mapper.readValue(inputStream,typeReference));
            
        } catch (StreamReadException e) {
            
            e.printStackTrace();
        } catch (DatabindException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
		ArrayList<Monster> monsters = new ArrayList<>();
		monsters.addAll(monsterList);

		return monsters;
	}

	@Bean
    ArrayList<Item> loadItems() {
		
		ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		TypeReference<List<Item>> typeReference = new TypeReference<List<Item>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/assets/items.json");

		List<Item> itemList = new ArrayList<>();
        
        try {
            
            itemList = (mapper.readValue(inputStream,typeReference));
            
        } catch (StreamReadException e) {
            
            e.printStackTrace();
        } catch (DatabindException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
		ArrayList<Item> items = new ArrayList<>();
		items.addAll(itemList);

		return items;
	}

	@Bean
    ArrayList<DecorativeItem> loadDecorativeItems() {
		
		ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		TypeReference<List<DecorativeItem>> typeReference = new TypeReference<List<DecorativeItem>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/assets/objetos-decorativos.json");

		List<DecorativeItem> itemList = new ArrayList<>();
        
        try {
            itemList = (mapper.readValue(inputStream,typeReference));
        } catch (StreamReadException e) {
            
            e.printStackTrace();
        } catch (DatabindException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }

		ArrayList<DecorativeItem> items = new ArrayList<>();
		items.addAll(itemList);

		return items;
	}
	
}