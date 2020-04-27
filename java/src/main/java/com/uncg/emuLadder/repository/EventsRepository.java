package com.uncg.emuLadder.repository;

import com.uncg.emuLadder.model.database.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Events, String> {
    List<Events> findAllByStartTimeAfterAndStartTimeBeforeAndName(Timestamp start, Timestamp end, String name);
}