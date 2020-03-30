package com.uncg.emuLadder.repository;

import com.uncg.emuLadder.model.database.ContestEvents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContestEventsRepository extends JpaRepository<ContestEvents, Integer> {
}
