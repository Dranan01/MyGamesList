/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.service;

import com.tfg.myGamesList.model.Client;
import com.tfg.myGamesList.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Francisco Miguel Pérez
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Override
    public Set<Client> findAll() {
        return (Set<Client>) repository.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void addClient(Client client) {
        repository.save(client);
    }

    @Override
    public Client modifyClient(Long id, Client newClient) {
        Optional<Client> c = repository.findById(id);
        Client x = c.get();
        newClient.setClientId(x.getClientId());
        newClient.setGames(x.getGames());
        System.out.println("En clientServiceImpl " + newClient.isLogged());
        repository.save(newClient);
   

        return newClient;
    }

    @Override
    public void deleteClient(Long id) {
        Optional<Client> client = repository.findById(id);
        repository.delete(client.get());

    }

    @Override
    public Optional<Client> findByUsername(String username) {

        Set<Client> clients = repository.findAll();
        for (Client c : clients) {
            if (c.getUsername().equals(username)) {
                
               return Optional.of(c);
            }
        }
        Client vacio = new Client();

        return Optional.of(vacio);
    }
}
