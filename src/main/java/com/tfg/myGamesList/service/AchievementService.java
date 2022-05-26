/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.service;

import com.tfg.myGamesList.model.Achievement;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author Francisco Miguel Pérez
 */
@Service
public interface AchievementService {
    
    Set<Achievement>findAll();

    Optional<Achievement> findById(Long id);

    void addAchievement(Achievement newAchievement);

    void modifyAchievement(Long id, Achievement newAchievement);

    void deleteAchievement(Long id);
}
