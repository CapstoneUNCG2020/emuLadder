package com.uncg.emuLadder.service.bl;

import com.uncg.emuLadder.model.database.EventPoints;
import com.uncg.emuLadder.model.database.LeagueStats;
import com.uncg.emuLadder.repository.EventPointsRepository;
import com.uncg.emuLadder.repository.LeagueStatsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public void updatePoints() {
        logger.info("Updating event points");

        List<EventPoints> eventPointsList = eventPointsRepository.findAll();

        for (EventPoints eventPoints : eventPointsList) {
            String matchId = eventPoints.getMatchId();
            String teamId = eventPoints.getTeamId();

            /* Check to see if duplicates or no values for match ID and team ID */
            List<LeagueStats> leagueStatsList = leagueStatsRepository.findByMatchIdAndTeamId(
                    matchId, teamId);

            if (leagueStatsList.size() == 0) {
                logger.error("No league stats with match ID {} and team ID {}", matchId, teamId);
                continue; // Skip due to error
            } else if (leagueStatsList.size() > 1) {
                logger.error("Multiple matching league stats with match ID {} and team ID {}", matchId, teamId);
                continue; // Skip due to error
            }

            /* Set the point values */
            LeagueStats leagueStats = leagueStatsList.get(0);
            eventPoints.setPoints(leagueStats.calculate());

            // Save the new information to the DB table
            eventPointsRepository.saveAndFlush(eventPoints);
        }

        logger.info("Updating successful.");
    }
}
