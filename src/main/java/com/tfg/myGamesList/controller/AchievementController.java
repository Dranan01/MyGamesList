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
import com.tfg.myGamesList.service.AchievementServiceImpl;
import com.tfg.myGamesList.service.GameServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Francisco Miguel Pérez
 */
@CrossOrigin
@Tag(name = "achievement", description = "methods about all the achievements on the database")
@RestController
public class AchievementController {

    @Autowired
    private AchievementServiceImpl achievementImpl;

    @Autowired
    private GameServiceImpl gameImpl;

    private final Logger logger = LoggerFactory.getLogger(GameController.class);

    @Operation(summary = "Obtains a list of every achievement")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of achievements", content = @Content(array = @ArraySchema(schema = @Schema(implementation = AchievementResume.class)))),})
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
        @ApiResponse(responseCode = "200", description = "Get an achievement using the id", content = @Content(array = @ArraySchema(schema = @Schema(implementation = AchievementResume.class)))),})
    @GetMapping("/achievement/{id}")
    public ResponseEntity<AchievementResume> getAchievement(@PathVariable long id) {
        Achievement achievement = achievementImpl.findById(id)
                .orElseThrow(() -> new AchievementNotFoundException(id));
        AchievementResume resume = new AchievementResume(achievement);

        return new ResponseEntity<>(resume, HttpStatus.OK);
    }

    @Operation(summary = "Creates a new achievement")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Saves a new achievement ", content = @Content(array = @ArraySchema(schema = @Schema(implementation = AchievementResume.class)))),})
    @PostMapping("/achievement/game/{gameId}")
    public ResponseEntity<AchievementResume> addGame(@RequestBody AchievementResume ar, @PathVariable long gameId) {
        Achievement achievement = new Achievement(ar);
        Game game = gameImpl.findById(gameId).get();
        achievement.setGame(game);
        achievementImpl.addAchievement(achievement);
        return new ResponseEntity<>(ar, HttpStatus.OK);
    }

    @Operation(summary = "Delete an achievement by his id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Deletes an achievement", content = @Content(array = @ArraySchema(schema = @Schema(implementation = AchievementResume.class)))),})
    @DeleteMapping("/achievement/{id}")
    public ResponseEntity<AchievementResume> deleteClient(@PathVariable long id) {
        Achievement a = achievementImpl.findById(id).get();
        AchievementResume ar = new AchievementResume(a);
        achievementImpl.deleteAchievement(id);
        return new ResponseEntity<>(ar, HttpStatus.GONE);
    }
    
        @Operation(summary = "Gives the game of this achievement")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Obtain the game of this achievement", content = @Content(array = @ArraySchema(schema = @Schema(implementation = GameResume.class)))),})
    @GetMapping("achievement/game/{id}")
    public ResponseEntity<GameResume> getGameOfAchievement(@PathVariable long id) {
        Game game = gameImpl.findById(id).get();
        GameResume gr = new GameResume(game);
        
        return new ResponseEntity<>(gr, HttpStatus.GONE);
    }

}
