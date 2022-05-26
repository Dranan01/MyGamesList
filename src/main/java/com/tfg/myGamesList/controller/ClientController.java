/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.controller;

import com.tfg.myGamesList.exception.ClientNotFoundException;
import com.tfg.myGamesList.model.Client;
import com.tfg.myGamesList.model.Game;
import com.tfg.myGamesList.model.domain.ClientResume;
import com.tfg.myGamesList.model.domain.ClientResumeNoId;
import com.tfg.myGamesList.model.domain.GameList;
import com.tfg.myGamesList.service.ClientServiceImpl;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Francisco Miguel Pérez
 */
@Tag(name = "client", description = "methods about all the clients on the database")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientImpl;

    @Autowired
    private GameServiceImpl gameImpl;

    private final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Operation(summary = "Obtains a list of every client")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of clients", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClientResume.class)))),})
    @GetMapping("client/")
    public ResponseEntity<Set<ClientResume>> getClients() {
        logger.info("start getClients");
        Set<Client> clients = clientImpl.findAll();
        Set<ClientResume> resume = new HashSet<>();
        for (Client c : clients) {
            resume.add(new ClientResume(c));
        }

        
        logger.info("fin GetClients");
        return new ResponseEntity<>(resume, HttpStatus.OK);
    }

    @Operation(summary = "Obtain a client")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Get a client with the id", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClientResume.class)))),})
    @GetMapping("/client/{id}")
    public ResponseEntity<ClientResume> getClient(@PathVariable long id) {
        Client client = clientImpl.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
        ClientResume resume = new ClientResume(client);

        return new ResponseEntity<>(resume, HttpStatus.OK);
    }

    @Operation(summary = "creates a new client without games")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "creates a client", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClientResume.class)))),})
    @PostMapping("/client")
    public ResponseEntity<ClientResume> addClient(@RequestBody ClientResume cr) {

        Client addedClient = new Client(cr); //clientImpl.addClient(new Client(cr));
        clientImpl.addClient(addedClient);
        return new ResponseEntity<>(cr, HttpStatus.CREATED);
    }

    @Operation(summary = "modifies the client")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "modifies a client", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClientResume.class)))),})
    @PutMapping("/client/{id}")
    public ResponseEntity<ClientResumeNoId> modifyClientUser(@PathVariable long id, @RequestBody ClientResumeNoId cr) {
        Client c = new Client(cr);
        clientImpl.modifyClient(id, c);
        return new ResponseEntity<>(cr, HttpStatus.ACCEPTED);

    }

        @Operation(summary = "delete a client by his id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "delete a client", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClientResume.class)))),})
    @DeleteMapping("/client/{id}")
    public ResponseEntity<ClientResume> deleteClient(@PathVariable long id) {
        Client c = clientImpl.findById(id).get();
        ClientResume cr = new ClientResume(c);
        clientImpl.deleteClient(id);
        return new ResponseEntity<>(cr, HttpStatus.GONE);
    }

    @Operation(summary = "get the clients gameList")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "get a list of the games that the client has", content = @Content(array = @ArraySchema(schema = @Schema(implementation = GameList.class)))),})
    @GetMapping("/client/{id}/GameList")
    public ResponseEntity<GameList> getGameList(@PathVariable long id) {
        Client client = clientImpl.findById(id).get();
        GameList gl = new GameList(client);
        return new ResponseEntity<>(gl, HttpStatus.CREATED);
    }

    @Operation(summary = "add a new game to the clients gameList")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "add a new game to the list of the games that the client has", content = @Content(array = @ArraySchema(schema = @Schema(implementation = GameList.class)))),})
    @PostMapping("/game/{gameId}/client/{clientId}")
    public void addGameToList(@PathVariable long gameId, @PathVariable long clientId) {
        Client client = clientImpl.findById(clientId).get();
        Game game = gameImpl.findById(gameId).get();

        client.getGames().add(game);
        clientImpl.addClient(client);

    }
    
        @Operation(summary = "deletes a game from the gametList of the client ")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "deletes a game from the list of the games that the client has", content = @Content(array = @ArraySchema(schema = @Schema(implementation = GameList.class)))),})
    @DeleteMapping("/client/{id}/GameList/game/{gameId}")
    public void deleteGameFromGameList(@PathVariable long id, @PathVariable long gameId) {
        Client client = clientImpl.findById(id).get();
        Game game = gameImpl.findById(gameId).get();

        client.getGames().remove(game);
        clientImpl.addClient(client);
   
    }
}
