package com.uncg.emuLadder.repository;

import com.uncg.emuLadder.model.database.Contests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContestsRepository extends JpaRepository<Contests, Integer> {
}