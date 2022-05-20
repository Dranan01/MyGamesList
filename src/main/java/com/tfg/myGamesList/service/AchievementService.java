/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.service;

import com.tfg.myGamesList.model.Achievement;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author franm
 */
@Service
public interface AchievementService {
    
    List<Achievement>findAll();

    Optional<Achievement> findById(Long id);

    Achievement addAchievement(Achievement newAchievement);

    Achievement modifyAchievement(Long id, Achievement newAchievement);

    void deleteAchievement(Long id);
}
