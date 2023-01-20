package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.model.Player;
import com.repository.PlayerRepository;

import java.util.*;

import javax.transaction.Transactional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    @Transactional
    public List<Player> players() {
        return repository.findAll(); //SELECT * FROM MYDB.PLAYERS
    }

    @Transactional
    public List<Player> topPlayers(int x) {
        return repository.topPlayers(x); //get top x players
    }

    @Transactional
    public Player player(int ID) {
        return repository.findById(ID).get();
    }

    @Transactional
    public void addPlayer(Player player) {
        repository.save(player); //insert query
    }

    @Transactional
    public void deletePlayerBiId(int ID) {
        repository.deleteById(ID);
    }
    
    @Transactional
    public void deletePlayer(Player player) {
        repository.delete(player);
    }
    
    @Transactional
    public void updatePlayer(String name, int score, int ID) {
        repository.updatePlayer(name, score, ID);
    }

    public String jsonString(Object obj) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer =  mapper.writerWithDefaultPrettyPrinter();
        return writer.writeValueAsString(writer);
    }
}