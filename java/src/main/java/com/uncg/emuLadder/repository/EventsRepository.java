package com.uncg.emuLadder.repository;

import com.uncg.emuLadder.model.database.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<Events, Integer> {
}