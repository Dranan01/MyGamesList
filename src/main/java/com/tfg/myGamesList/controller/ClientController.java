/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.controller;

import com.tfg.myGamesList.model.Client;
import com.tfg.myGamesList.repository.ClientRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author franm
 */

//@Tag(name = "client", description = "list of clients")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ClientController {
    
    
    @Autowired
    private ClientRepository clientRepository;
    
    private final Logger logger = LoggerFactory.getLogger(GameController.class);

    
        @GetMapping("client/")
    public List<Client> getClients() {
        logger.info("start getClients");
        //List<Game> games = new ArrayList();

        //games = 
            System.out.println(clientRepository.findAll().toString());
        return (List<Client>) clientRepository.findAll();
    }
    
}
