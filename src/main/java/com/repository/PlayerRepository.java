package com.repository;

import com.model.Player;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    
    @Query(value="UPDATE players SET NAME = :name, SCORE = :score WHERE ID = :pID", nativeQuery=true)
    public void updatePlayer(@Param("name") String name, @Param("score")int score, @Param("pID")int pID);
}
