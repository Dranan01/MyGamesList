/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.repository;

import com.tfg.myGamesList.model.Game;
import java.util.Set;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Francisco Miguel Pérez
 */
@Repository
public interface GameRepository extends CrudRepository<Game,Long> {
    Set<Game> findAll();

}
