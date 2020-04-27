package com.uncg.emuLadder.service.bl;

import com.uncg.emuLadder.model.database.Events;
import com.uncg.emuLadder.repository.EventsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public class ContestEventService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final EventsRepository eventsRepository;

    /**
     * Returns the events that start on the same day as
     * the contest, capped at 5, in the same region.
     *
     * @param start - When the contest starts.
     * @param region - Region of the contest
     * @return - The list of events that are in the contest.
     */
    public List<Events> getNextEvents(Timestamp start, String region) {
        logger.info("Starttime: {}", start);
        Timestamp end = Timestamp.valueOf(start.toLocalDateTime().plusDays(1));

        List<Events> events = eventsRepository.findAllByStartTimeAfterAndStartTimeBeforeAndName(start, end, region);

        // Return only 5 events max
        return events.size() <= 5 ? events :  events.subList(0, 5);
    }

    @Autowired
    public ContestEventService(final EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }
}
