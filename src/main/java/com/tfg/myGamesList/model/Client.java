/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.model;

import com.tfg.myGamesList.model.domain.ClientResume;
import com.tfg.myGamesList.model.domain.ClientResumeNoId;
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
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;


/**
 *
 * @author Francisco Miguel Pérez
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "clients") 
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    
    @Column(unique = true)
    private String username;
    
    @Column
    private String description;
   
    @Column
    private String email;
    
    @Column(name="_password") //Lo cambio porque password es una palabra reservada de MYSQL
    private String password;
    
    @Column
    @ColumnDefault(value = "false")
    private boolean logged;
    
    @Column
    private String profilePic;
    
    
    @ManyToMany(cascade = CascadeType.DETACH)
  @JoinTable(name="client_game", 
    joinColumns={@JoinColumn(name="clientId")}, 
    inverseJoinColumns={@JoinColumn(name="gameId")})
    private List<Game> games;

    public Client(ClientResume cr) {
        this.username = cr.getUsername();
        this.password = cr.getPassword();
        this.logged = cr.isLogged();
        this.profilePic = cr.getProfilePic();
        this.description = cr.getDescription();
        this.email = cr.getEmail();
    }
    
        public Client(ClientResumeNoId cr) {
        this.username = cr.getUsername();
        this.password = cr.getPassword();
        this.logged = cr.isLogged();
        this.profilePic = cr.getProfilePic();
    }
    
    
    
    
    
    
    
    
    
    
}
