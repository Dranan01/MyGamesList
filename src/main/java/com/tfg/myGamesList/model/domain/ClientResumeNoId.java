/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.model.domain;

import com.tfg.myGamesList.model.Client;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 *
 * @author Francisco Miguel Pérez
 */
@Data
public class ClientResumeNoId {

    @Schema(description = "username of the client, used for log in", example = "XxMatthyxX", required = true)
    private String username;

    @Schema(description = "password of the client, used for log in", example = "@1234Potatoe", required = true)
    private String password;

    public ClientResumeNoId(Client c) {
        this.username = c.getUsername();
        this.password = c.getPassword();
    }


    
    
    
    
    
}
