/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.model.domain;

import com.tfg.myGamesList.model.Game;
import io.swagger.v3.oas.annotations.media.Schema;
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
public class GameResume {
    @Schema(description = "Id of the game", example = "1", required = true)
    private Long gameId;
    @Schema(description = "name of the game", example = "Dark souls", required = true)
    private String name;
    @Schema(description = "a short description of what is about", example = "is about a soldier and his friends rescuing a princess", required = true)
    private String description;
    @Schema(description = "the genre of the game", example = "Shooter", required = true)
    private String genre;
    @Schema(description = "The main designer of the game", example = "Hidetaka Miyazaki", required = true)
    private String designer;
    @Schema(description = "The location of the coverImage of the game", example = "c:/games/images/1", required = true)
    private String coverPage;
    @Schema(description = "The release year of the game", example = "2001", required = true)
    private int releaseYear;
    @Schema(description = "The average score that the clients gives to this game", example = "8.8", required = true)
    private double gameScore;

    public GameResume(Game game) {
        this.gameId = game.getGameId();
        this.name = game.getName();
        this.description = game.getDescription();
        this.genre = game.getGenre();
        this.designer = game.getDesigner();
        this.coverPage = game.getCoverPage();
        this.releaseYear = game.getReleaseYear();
        this.gameScore = game.getGameScore();
    }
    
    
    
    
    
    
    
    
    
}
