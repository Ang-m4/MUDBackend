package com.desarrollo.web.proyecto.Db;

import com.desarrollo.web.proyecto.Model.Item;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item,Long>{
    
}
