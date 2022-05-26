/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.model.domain;

import com.tfg.myGamesList.model.Achievement;
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
public class ClientList {
    private String gameName;
    private List<ClientResume> clients;

    public ClientList(Game game) {
        clients = new ArrayList();
        this.gameName = game.getName();
        List<Client> clientRes = game.getClients();
        for (Client client : clientRes) {
            ClientResume ClientResume = new ClientResume(client);
            this.clients.add(ClientResume);

        }
    }
}
