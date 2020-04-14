package com.uncg.emuLadder.service.bl;

import com.uncg.emuLadder.model.database.EventPoints;
import com.uncg.emuLadder.model.database.LeagueStats;
import com.uncg.emuLadder.model.database.compositekeys.LeagueStatsId;
import com.uncg.emuLadder.repository.EventPointsRepository;
import com.uncg.emuLadder.repository.LeagueStatsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UpdatePointsService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final EventPointsRepository eventPointsRepository;
    private final LeagueStatsRepository leagueStatsRepository;

    @Autowired
    public UpdatePointsService(
            final EventPointsRepository eventPointsRepository,
            final LeagueStatsRepository leagueStatsRepository
    ) {
        this.eventPointsRepository = eventPointsRepository;
        this.leagueStatsRepository = leagueStatsRepository;
    }

    public boolean updatePoints() {
        logger.info("Updating event points");

        List<EventPoints> eventPointsList = eventPointsRepository.findAll();

        for (EventPoints eventPoints : eventPointsList) {
            LeagueStatsId id = new LeagueStatsId();
            id.setMatchId(eventPoints.getMatchId());
            id.setParticipantNumber(eventPoints.getParticipantNumber());

            /* Check to see exists */
            Optional<LeagueStats> optional = leagueStatsRepository.findById(id);

            if (!optional.isPresent()) {
                logger.error("No league stats with ID: {}", id);
                continue; // Skip due to error
            }

            /* Set the point values */
            LeagueStats leagueStats = optional.get();
            eventPoints.setPoints(leagueStats.calculate());

            // Save the new information to the DB table
            eventPointsRepository.saveAndFlush(eventPoints);
        }

        logger.info("Updating successful.");
        return true;
    }
}
