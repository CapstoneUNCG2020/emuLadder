package com.uncg.emuLadder.controller;

import com.uncg.emuLadder.model.database.Events;
import com.uncg.emuLadder.model.response.ResponseData;
import com.uncg.emuLadder.repository.EventsRepository;
import com.uncg.emuLadder.service.EventService;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/event")
public class EventController {

    private final EventsRepository eventsRepository;
    private final EventService eventService;

    @GetMapping("/test")
    public ResponseData<List<Timestamp>> getLatestDates() {
        return eventService.getLatestDates();
    }

    @GetMapping("/latest")
    public ResponseData<List<Events>> getLatestEvents() {
        return eventService.getLatestEvents();
    }

    public EventController(final EventsRepository eventsRepository, final EventService eventService) {
        this.eventsRepository = eventsRepository;
        this.eventService = eventService;
    }

}
