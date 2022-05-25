/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.service;

import com.tfg.myGamesList.model.Achievement;
import com.tfg.myGamesList.repository.AchievementRepository;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author franm
 */
@Service
public class AchievementServiceImpl implements AchievementService    {
    
    
    @Autowired
    private AchievementRepository repository;

   

    @Override
    public Set<Achievement> findAll() {
        return  repository.findAll();
    }

    @Override
    public Optional<Achievement> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void addAchievement(Achievement newAchievement) {
        repository.save(newAchievement);
    }

    @Override
    public void modifyAchievement(Long id, Achievement newAchievement) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteAchievement(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
