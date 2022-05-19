/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author franm
 */
@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity(name="achievement")
public class Achievement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long achievementId;
    
    @Column
    private String achDescription;
    
    @Column
    private String achImage;
    
    @Column
    private boolean isDone;
    
    @Column
    private String difficulty;
    
    
    @ManyToOne
    @JoinColumn(name= "gameId")
    private Game game;
}
