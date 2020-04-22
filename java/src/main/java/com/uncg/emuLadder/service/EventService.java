package com.uncg.emuLadder.service;

import com.sun.mail.iap.Response;
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
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Component
public class EventService {

    private final EventsRepository eventsRepository;

//    public ResponseData<List<Events>> test() {
//        ResponseData<List<Events>> responseData = new ResponseData<>();
//        List<Events> events = eventsRepository.findFiveLatestEvents();
//        responseData.setStatus(ResponseStatusType.SUCCESS.name());
//        responseData.setResponse(events);
//        return responseData;
//    }

    public ResponseData<List<Timestamp>> getLatestDates() {
        ResponseData<List<Timestamp>> responseData = new ResponseData<>();
        List<Timestamp> dates = eventsRepository.getLatestDates();
        responseData.setStatus(ResponseStatusType.SUCCESS.name());
        responseData.setResponse(dates);

        return responseData;
    }

    public EventService(final EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }
}
