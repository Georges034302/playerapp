package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return repository.findAll();
    }

    @Transactional
    public Player player(int ID) {
        return repository.findById(ID).get();
    }

    @Transactional
    public void addPlayer(Player player) {
        repository.save(player);
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
}