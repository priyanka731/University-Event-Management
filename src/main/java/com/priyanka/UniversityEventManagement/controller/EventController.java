package com.priyanka.UniversityEventManagement.controller;

import com.priyanka.UniversityEventManagement.model.Event;
import com.priyanka.UniversityEventManagement.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping("event")//add event
    public String addAEvent(@RequestBody Event event)
    {
        return eventService.addAEvent(event);
    }

    @PostMapping("events")//add multiple events
    public String addEvents(@RequestBody List<Event> event)
    {
        return eventService.addEvents(event);
    }

    @GetMapping("events")//get all
    public Iterable<Event> getAllEvents()
    {
        return  eventService.getAllEvents();
    }

    @GetMapping("event/{id}")//get by id
    public Optional<Event> getEventById(@PathVariable Integer id)
    {
        return eventService.getEventById(id);
    }

    @GetMapping("events/{date}") // get events by date
    public Iterable<Event> getEventsOnSameDate(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return eventService.getEventsOnSameDate(date);
    }


    @PutMapping("event/id/{id}/location/{localEvent}")//update location
    public String updateEventLocationById(@PathVariable Integer id ,@PathVariable String localEvent)
    {
        return eventService.updateEventLocationById(id,localEvent);
    }

    @DeleteMapping("event/{id}")//delete event
    public String removeEventById(@PathVariable Integer id)
    {
        return  eventService.removeEventById(id);
    }

}
