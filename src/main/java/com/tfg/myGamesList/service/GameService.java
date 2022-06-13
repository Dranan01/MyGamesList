/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.service;

import com.tfg.myGamesList.model.Game;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author Francisco Miguel Pérez
 */
@Service
public interface GameService {

    Set<Game> findAll();

    Optional<Game> findById(Long id);

    void addGame(Game newGame);

    void modifyGame(Long id, Game newGame);

    void deleteGame(Long id);

    Optional<Game> findByName(String username);
}
