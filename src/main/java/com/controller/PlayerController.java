package com.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.model.Player;
import com.service.PlayerService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/playerapi")
public class PlayerController {
    
    @Autowired
    private PlayerService service;

    //http://localhost:8080/playerapi/hello
    @GetMapping("/hello")
    public String hello() {
        String output = "Hello from SpringBoot";
        output += "<br>Spring version: " + SpringVersion.getVersion();
        output += "<br>Java version: " + System.getProperty("java.version");
        return output;
    }
    
    //http://localhost:8080/playerapi/players
    @GetMapping(value = "/players", produces = {MediaType.APPLICATION_JSON_VALUE })
    public List<Player> players() {
        return service.players();
    }
    
    //http://localhost:8080/playerapi/topplayers/10
    @GetMapping(value = "/topplayers/{x}")
    public List<Player> topPlayers(@PathVariable int x) {
        return service.topPlayers(x);
    }
    
    //http://localhost:8080/playerapi/players
    @GetMapping(value = "/get/all", produces = {MediaType.APPLICATION_JSON_VALUE })
    public String getPlayers() throws JsonProcessingException {
        return service.jsonString(service.players());
    }
    
    //http://localhost:8080/playerapi/player/100
    @GetMapping(value="/player/{ID}")
    public Player getPlayer(@PathVariable int ID) {
        return service.player(ID);
    }

    //http://localhost:8080/playerapi/add
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        try {
            service.addPlayer(player);
            return new ResponseEntity<>(player, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    //http://localhost:8080/playerapi/save/John-88
    @GetMapping("/save/{name}-{score}")
    public ResponseEntity<Player> savePlayer(@PathVariable String name, @PathVariable int score) {
        try {
            Player player = new Player(name, score);
            service.addPlayer(player);
            return new ResponseEntity<>(player, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    //http://localhost:8080/playerapi/delete/164
    @DeleteMapping("/delete/{ID}")
    public ResponseEntity<Object> delete(@PathVariable int ID) {
        try {
            service.deletePlayerBiId(ID);
            return new ResponseEntity<>("Player " + ID + " record has been deleted", HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>("Player " + ID + " not found", HttpStatus.NOT_FOUND);
        }
    }
    
    //http://localhost:8080/playerapi/update/163-Paul-99
    @PutMapping("/update/{ID}-{name}-{score}")
    public ResponseEntity<Object> update(@PathVariable int ID, @PathVariable String name, @PathVariable int score) {
        try {
            service.updatePlayer(name, score, ID);
            return new ResponseEntity<>("Player " + ID + " record has been updated", HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>("Player " + ID + " not found", HttpStatus.NOT_FOUND);
        }
    }
}
