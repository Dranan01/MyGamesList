/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.controller;

import com.tfg.myGamesList.exception.AchievementNotFoundException;
import com.tfg.myGamesList.model.Achievement;
import com.tfg.myGamesList.model.Game;
import com.tfg.myGamesList.model.domain.AchievementResume;
import com.tfg.myGamesList.model.domain.GameResume;
import com.tfg.myGamesList.repository.AchievementRepository;
import com.tfg.myGamesList.service.AchievementServiceImpl;
import com.tfg.myGamesList.service.GameServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    private AchievementServiceImpl achievementImpl;
    
    @Autowired
    private GameServiceImpl gameImpl;
    
    private final Logger logger = LoggerFactory.getLogger(GameController.class);

  @Operation(summary = "Obtains a list of every achievement")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of games", content = @Content(array = @ArraySchema(schema = @Schema(implementation = AchievementResume.class)))),})
    @GetMapping("achievement/")
    public ResponseEntity<Set<GameResume>> getClients() {
        logger.info("start getAchievements");
        Set<Achievement> achievements = achievementImpl.findAll();
        Set<AchievementResume> resume = new HashSet<>();
        for (Achievement a : achievements) {
            resume.add(new AchievementResume(a));
        }
        logger.info("finish getAchievements");
        return new ResponseEntity(resume, HttpStatus.CREATED);
    }
    
    
    
    @Operation(summary = "Obtain a achievement by his id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Get a achievement using the id", content = @Content(array = @ArraySchema(schema = @Schema(implementation = AchievementResume.class)))),})
        @GetMapping("/achievement/{id}")
    public ResponseEntity<AchievementResume> getGame(@PathVariable long id) {
        Achievement achievement = achievementImpl.findById(id)
                .orElseThrow(() -> new AchievementNotFoundException(id));
        AchievementResume resume = new AchievementResume(achievement);

        return new ResponseEntity<>(resume, HttpStatus.OK);
    }

            @Operation(summary = " Creates a new achievement")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "saves a new game ", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Achievement.class)))),})
        @PostMapping("/achievement/game/{id}")
    public ResponseEntity<AchievementResume> addGame(@RequestBody AchievementResume ar, @PathVariable long gameId) {
        Achievement achievement = new Achievement(ar);
        Game game = gameImpl.findById(gameId).get();
        achievement.setGame(game);
        achievementImpl.addAchievement(achievement);
        return new ResponseEntity<>(ar, HttpStatus.OK);
    }
    
}
