/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.model;

import com.tfg.myGamesList.model.domain.GameResume;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author Francisco Miguel Pérez
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "game")
public class Game implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;
    
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String genre;
    @Column
    private String designer;
    @Column
    private String coverPage;
    @Column
    private int releaseYear;
    @Column
    private double gameScore;
    
    
     @ManyToMany(cascade = CascadeType.DETACH, mappedBy = "games")
    private List<Client> clients;
    
    
    @OneToMany(mappedBy = "achievementId", cascade = CascadeType.ALL)
    private List<Achievement> achievements;

    public Game(GameResume gr) {
        this.gameId = gr.getGameId();
        this.name = gr.getName();
        this.description = gr.getDescription();
        this.genre = gr.getGenre();
        this.designer = gr.getDesigner();
        this.coverPage = gr.getCoverPage();
        this.releaseYear = gr.getReleaseYear();
        this.gameScore = 0.0;
    }

    @Override
    public String toString() {
        return "Game{" + "gameId=" + gameId + ", name=" + name + ", description=" + description + ", genre=" + genre + ", designer=" + designer + ", coverPage=" + coverPage + ", releaseYear=" + releaseYear + ", gameScore=" + gameScore + ", clients=" + clients + ", achievements=" + achievements + '}';
    }
    
    
    
    
    
    
}
