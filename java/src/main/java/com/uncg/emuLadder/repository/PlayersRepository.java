package com.uncg.emuLadder.repository;

import com.uncg.emuLadder.model.database.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersRepository extends JpaRepository<Players, String> {
}