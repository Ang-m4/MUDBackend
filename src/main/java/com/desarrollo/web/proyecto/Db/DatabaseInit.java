package com.desarrollo.web.proyecto.Db;

import com.desarrollo.web.proyecto.Model.DecorativeItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.desarrollo.web.proyecto.Model.*;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DatabaseInit implements ApplicationRunner{


    @Autowired
    DecorativeItemRepository decoItemRepo;

    @Autowired
    ItemRepository itemRepo;

    /// se ejecuta una sola vez al inicio de la aplicacion.
    @Override
    public void run(ApplicationArguments args) throws Exception {
        
       
        loadDecoItems();
        loadItems();
        

    }
    
    
    void loadDecoItems(){

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

        decoItemRepo.saveAll(itemList);
    }

    void loadItems() {
		
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

        itemRepo.saveAll(itemList);
        
	}



}
