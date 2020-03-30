package com.uncg.emuLadder.repository;

import com.uncg.emuLadder.model.database.EventPoints;
import com.uncg.emuLadder.model.database.compositekeys.EventPointsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventPointsRepository extends JpaRepository<EventPoints, EventPointsId> {
}