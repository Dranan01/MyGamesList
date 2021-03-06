/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.model.domain;

import com.tfg.myGamesList.model.Client;
import com.tfg.myGamesList.model.Game;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Francisco Miguel Pérez
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameList {

    private List<GameResume> game;

    public GameList(Client client) {
        game = new ArrayList();
        List<Game> gameRes = client.getGames();
        for (Game games : gameRes) {
            GameResume gameResume = new GameResume(games);
            this.game.add(gameResume);

        }
    }

}
