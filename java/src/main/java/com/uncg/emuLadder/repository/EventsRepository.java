package com.uncg.emuLadder.repository;

import com.uncg.emuLadder.model.database.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Events, String> {
    List<Events> findAllByStartTimeAfterAndStartTimeBeforeAndName(Timestamp start, Timestamp end, String name);

    @Query(value = "SELECT MIN(startTime) FROM Events WHERE startTime >= '2020-02-09' and name = 'LCS' GROUP BY DATE(startTime) ORDER BY startTime LIMIT 5", nativeQuery = true)
    List<Timestamp> getLatestDates();

    @Query(value = "SELECT * FROM Events WHERE DATE(startTime) >= '2020-02-09' AND DATE(startTime) <= '2020-02-18' AND name = 'LCS' ORDER BY startTime", nativeQuery = true)
    List<Events> getLatestEvents();
}