package com.uncg.emuLadder.repository;

import com.uncg.emuLadder.model.database.LeagueStats;
import com.uncg.emuLadder.model.database.compositekeys.LeagueStatsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueStatsRepository extends JpaRepository<LeagueStats, LeagueStatsId> {
}