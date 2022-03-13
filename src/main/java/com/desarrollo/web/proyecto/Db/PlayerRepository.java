package com.desarrollo.web.proyecto.Db;

import com.desarrollo.web.proyecto.Model.Player;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player,Long> {
}
