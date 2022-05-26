/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.model.domain;

import com.tfg.myGamesList.model.Client;
import com.tfg.myGamesList.model.Game;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Francisco Miguel Pérez
 */
@Data
public class GameList {

    private String clientName;
    private List<GameResume> game;

    public GameList(Client client) {
        game = new ArrayList();
        this.clientName = client.getUsername();
        List<Game> gameRes = client.getGames();
        for (Game games : gameRes) {
            System.out.println(game.toString());
            GameResume gameResume = new GameResume(games);
            this.game.add(gameResume);

        }
    }

}
