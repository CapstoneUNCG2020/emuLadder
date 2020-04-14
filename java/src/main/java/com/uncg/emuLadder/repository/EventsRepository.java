package com.uncg.emuLadder.repository;

import com.uncg.emuLadder.model.database.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Events, Integer> {
    List<Events> findAllByStartTimeAndName(Date startTime, String name);
}