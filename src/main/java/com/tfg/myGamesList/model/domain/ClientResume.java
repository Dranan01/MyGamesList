/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.model.domain;

import com.tfg.myGamesList.model.Client;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.Column;
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
public class ClientResume {

    @Schema(description = "Id of the client", example = "1", required = true)
    private Long clientId;

    @Schema(description = "username of the client, used for log in", example = "XxMatthyxX", required = true)
    private String username;

    @Schema(description = "Descriptrion in the profile of the client", example = "My name is Mr Potatoe", required = true)
    private String description;

    @Schema(description = "email of the client", example = "asdkjgnbadsjkhlgblsa@tal.com", required = true)
    private String email;

    @Schema(description = "password of the client, used for log in", example = "@1234Potatoe", required = true)
    private String password;

    @Schema(description = "boolean to know if the client i logged or not", example = "true", required = true)
    private boolean logged;

    @Schema(description = "profilePic direction", example = "assets/users/1", required = true)
    private String profilePic;

    public ClientResume(Client c) {
        this.clientId = c.getClientId();
        this.username = c.getUsername();
        this.password = c.getPassword();
        this.profilePic = c.getProfilePic();
        this.email = c.getEmail();
        this.description = c.getDescription();
    }

}
