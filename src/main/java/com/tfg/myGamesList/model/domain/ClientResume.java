/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.model.domain;

import com.tfg.myGamesList.model.Client;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author franm
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResume {

    @Schema(description = "Id of the client", example = "1", required = true)
    private Long clientId;

    @Schema(description = "username of the client, used for log in", example = "XxMatthyxX", required = true)
    private String username;
    
    @Schema(description = "password of the client, used for log in", example = "@1234Potatoe", required = true)
    private String password;

    public ClientResume(Client c) {
        this.clientId = c.getClientId();
        this.username = c.getUsername();
        this.password = c.getPassword();
    }

}
