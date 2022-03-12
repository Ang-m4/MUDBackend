package com.desarrollo.web.proyecto.Db;

import com.desarrollo.web.proyecto.Model.Monster;
import org.springframework.data.repository.CrudRepository;

public interface MonsterRepository extends CrudRepository<Monster,Long>{
    
}
