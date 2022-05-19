/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.service;

import com.tfg.myGamesList.model.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author franm
 */
@Service
public interface ClientService {
    
    List<Client>FindAll();

    Optional<Client> findById(Long id);

    Client addClient(Client client);

    Client modifyClient(Long id, Client newClient);

    void deleteClient(Long id);

}
