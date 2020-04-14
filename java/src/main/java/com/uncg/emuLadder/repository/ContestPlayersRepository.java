package com.uncg.emuLadder.repository;

import com.uncg.emuLadder.model.database.ContestPlayers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContestPlayersRepository extends JpaRepository<ContestPlayers, Integer> {
    List<ContestPlayers> findAllByContestId(int contestId);
    ContestPlayers findByContestIdAndPlayerId(int contestId, String playerId);
}
