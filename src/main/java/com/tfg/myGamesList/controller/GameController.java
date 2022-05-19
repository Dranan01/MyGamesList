/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.controller;


import com.tfg.myGamesList.model.Game;
import com.tfg.myGamesList.repository.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author franm
 */
@CrossOrigin(origins = "http://localhost:8080")
@Tag(name = "game", description = "list of games")
@RestController
public class GameController {

    private final Logger logger = LoggerFactory.getLogger(GameController.class);

    @Autowired
    private GameRepository gameRepository;
    
    
      /*@Operation(summary = "Obtiene un listado de todos los equipos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of all games", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Game.class)))),})*/
}
