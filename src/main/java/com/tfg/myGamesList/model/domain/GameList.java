/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.model.domain;

import com.tfg.myGamesList.model.Game;
import java.util.ArrayList;
import lombok.Data;

/**
 *
 * @author franm
 */
@Data
public class GameList {
    private ArrayList<GameResume> game;

    public GameList(ArrayList<Game> gameRes) {
        
        for(Game games : gameRes){
            
            GameResume game = new GameResume(games);
            this.game.add(game);
            
        }
        
        
        
    }
    
    
    
    
}
