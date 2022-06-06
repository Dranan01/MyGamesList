/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.controller;

import com.tfg.myGamesList.exception.GameNotFoundException;
import com.tfg.myGamesList.model.Game;
import com.tfg.myGamesList.model.domain.AchievementList;
import com.tfg.myGamesList.model.domain.ClientList;
import com.tfg.myGamesList.model.domain.GameResume;
import com.tfg.myGamesList.service.GameServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.HashSet;
import java.util.Set;
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
@Tag(name = "game", description = "methods about all the games on the database")
@RestController
public class GameController {

    private final Logger logger = LoggerFactory.getLogger(GameController.class);

    @Autowired
    private GameServiceImpl gameImpl;

    @Operation(summary = "Obtains a list of every game")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of games", content = @Content(array = @ArraySchema(schema = @Schema(implementation = GameResume.class)))),})
    @GetMapping("game/")
    public ResponseEntity<Set<GameResume>> getClients() {
        logger.info("start getGames");
        Set<Game> games = gameImpl.findAll();
        Set<GameResume> resume = new HashSet<>();
        for (Game g : games) {
            resume.add(new GameResume(g));
        }
        logger.info("finish getGames");
        return new ResponseEntity(resume, HttpStatus.CREATED);
    }

    @Operation(summary = "Obtain a game by his id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Get a game using the id", content = @Content(array = @ArraySchema(schema = @Schema(implementation = GameResume.class)))),})
    @GetMapping("/game/{id}")
    public ResponseEntity<GameResume> getGame(@PathVariable long id) {
        Game game = gameImpl.findById(id)
                .orElseThrow(() -> new GameNotFoundException(id));
        GameResume resume = new GameResume(game);

        return new ResponseEntity<>(resume, HttpStatus.OK);
    }

    @Operation(summary = "saves a new game")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "saves a new game ", content = @Content(array = @ArraySchema(schema = @Schema(implementation = GameResume.class)))),})
    @PostMapping("/game")
    public ResponseEntity<GameResume> addGame(@RequestBody GameResume gr) {
        Game game = new Game(gr);
        gameImpl.addGame(game);
        return new ResponseEntity<>(gr, HttpStatus.OK);
    }

    @Operation(summary = "Delete an game by his id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Delete an game by his id", content = @Content(array = @ArraySchema(schema = @Schema(implementation = GameResume.class)))),})
    @DeleteMapping("/game/{id}")
    public ResponseEntity<GameResume> deleteGame(@PathVariable long id) {
        Game g = gameImpl.findById(id).get();
        GameResume ar = new GameResume(g);
        gameImpl.deleteGame(id);
        return new ResponseEntity<>(ar, HttpStatus.GONE);
    }

    @Operation(summary = "Obtain the list of achievements that the game has")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "get the achievements of the game", content = @Content(array = @ArraySchema(schema = @Schema(implementation = AchievementList.class)))),})
    @GetMapping("/game/{id}/achievementList")
    public ResponseEntity<AchievementList> getAchievementList(@PathVariable long id) {

        Game game = gameImpl.findById(id).get();
        AchievementList al = new AchievementList(game);

        return new ResponseEntity<>(al, HttpStatus.OK);
    }

    @Operation(summary = "Obtain the list of clients that own this game")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "get the clients that own the game", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClientList.class)))),})
    @GetMapping("/game/{id}/clientList")
    public ResponseEntity<ClientList> getClientList(@PathVariable long id) {

        Game game = gameImpl.findById(id).get();
        ClientList cl = new ClientList(game);

        return new ResponseEntity<>(cl, HttpStatus.OK);
    }
}
