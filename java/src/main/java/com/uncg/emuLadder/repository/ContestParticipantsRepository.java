package com.uncg.emuLadder.repository;

import com.uncg.emuLadder.model.database.ContestParticipants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ContestParticipantsRepository extends JpaRepository<ContestParticipants, Integer> {
    int countByContestId(int contestId);

    List<ContestParticipants> findAllByEmail(String email);

    @Transactional
    int deleteAllByContestIdAndEmail(int contestId, String email);
}