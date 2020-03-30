package com.uncg.emuLadder.repository;

import com.uncg.emuLadder.model.database.ContestPlayers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContestPlayersRepository extends JpaRepository<ContestPlayers, Integer> {
}
