/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.service;

import com.tfg.myGamesList.model.Game;
import com.tfg.myGamesList.repository.GameRepository;
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
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository repository;

    @Override
    public Set<Game> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Game> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void addGame(Game newGame) {
        repository.save(newGame);
    }

    @Override
    public void modifyGame(Long id, Game newGame) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteGame(Long id) {
        Game g = repository.findById(id).get();
        repository.delete(g);
    }

    @Override
    public Optional<Game> findByName(String name) {

        Set<Game> games = repository.findAll();
        for (Game g : games) {
            if (g.getName().toLowerCase().equals(name.toLowerCase())) {

                return Optional.of(g);
            }
        }
        Game vacio = new Game();

        return Optional.of(vacio);
    }
}
