/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.service;

import com.tfg.myGamesList.model.Game;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author franm
 */
@Service
public interface GameService {
    
    List<Game>FindAll();
    
    Optional<Game> findById(Long id);

    Game addAchievement(Game newGame);

    Game modifyAchievement(Long id, Game newGame);

    void deleteGame(Long id);
}
