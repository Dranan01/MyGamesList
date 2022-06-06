/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.service;

import com.tfg.myGamesList.model.Client;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author Francisco Miguel Pérez
 */
@Service
public interface ClientService {
    
    Set<Client>findAll();

    Optional<Client> findById(Long id);

    void addClient(Client client);

    Client modifyClient(Long id, Client newClient);

    void deleteClient(Long id);
    
    Optional<Client> findByUsername(String username);

}
