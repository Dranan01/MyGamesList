/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.controller;

import com.tfg.myGamesList.model.Achievement;
import com.tfg.myGamesList.model.Game;
import com.tfg.myGamesList.repository.AchievementRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.ArrayList;
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
@CrossOrigin(origins = "http://localhost:8080")
@Tag(name = "achievement", description = "list of achievements")
@RestController
public class AchievementController {

    @Autowired
    private AchievementRepository achievementRepository;
    
    private final Logger logger = LoggerFactory.getLogger(GameController.class);

    @GetMapping("achievement/")
    public List<Achievement> getAchievement() {
        logger.info("start getAchievements");
        List<Game> games = new ArrayList();

        //games = 
        return (List<Achievement>) achievementRepository.findAll();
    }
}
