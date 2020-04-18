package com.uncg.emuLadder.service;

import com.uncg.emuLadder.enums.ResponseStatusType;
import com.uncg.emuLadder.model.database.Events;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.repository.EventsRepository;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Component
public class EventService {

    private final EventsRepository eventsRepository;

    public List<Events> test() throws ParseException {
        Timestamp timestamp = new Timestamp(2020, 1, 18, 0, 0, 0, 0);
        Timestamp timestamp1 = new Timestamp(2020, 2, 19, 0, 0, 0, 0);
        List<Events> events = eventsRepository.findAllByStartTimeAfterAndStartTimeBeforeAndName(timestamp, timestamp1, "LCS");

//        responseData.setStatus(ResponseStatusType.SUCCESS.name());
//        responseData.setResponse(events);

        return events;
    }

    public EventService(final EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }
}
