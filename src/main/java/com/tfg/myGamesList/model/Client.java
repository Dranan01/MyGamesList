/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.model;

import com.tfg.myGamesList.model.domain.ClientResume;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Entity(name = "clients") //Lo cambio porque password es una palabra reservada de MYSQL
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    
    @Column
    private String username;
    
    @Column(name="_password") //Lo cambio porque password es una palabra reservada de MYSQL
    private String password;
    
    
    
    @ManyToMany(cascade = CascadeType.DETACH)
  @JoinTable(name="client_game", 
    joinColumns={@JoinColumn(name="clientId")}, 
    inverseJoinColumns={@JoinColumn(name="gameId")})
    private List<Game> games;

    public Client(ClientResume cr) {
        this.username = cr.getUsername();
        this.password = cr.getPassword();
    }
    
    
    
    
    
    
    
    
    
}
