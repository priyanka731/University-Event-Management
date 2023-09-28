package com.priyanka.UniversityEventManagement.service;

import com.priyanka.UniversityEventManagement.model.Event;
import com.priyanka.UniversityEventManagement.repository.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    IEventRepo iEventRepo;

    public String addAEvent(Event event) {

        iEventRepo.save(event);

        return "New Event Added!!!";
    }

    public String addEvents(List<Event> event) {
        iEventRepo.saveAll(event);

        return "Event added";
    }

    public Iterable<Event> getAllEvents() {

        return iEventRepo.findAll();
    }

    public Optional<Event> getEventById(Integer id) {
        return iEventRepo.findById(id);
    }

    public Iterable<Event> getEventsOnSameDate(LocalDate date) {
        return iEventRepo.findByEventDate(date);
    }

    public String updateEventLocationById(Integer id, String localEvent)  {
        Optional<Event> s = iEventRepo.findById(id);

        if (s.isEmpty()) {
            return "Event not Found!!!";
        }

        Event event = s.get();
        event.setLocationOfEvent(localEvent);
        iEventRepo.save(event);
        return "Location updated for the event";

    }

    public String removeEventById(Integer id) {
        Event e = iEventRepo.findById(id).orElse(null);
        if(e==null)
        {
            return "Id not found";
        }
        iEventRepo.delete(e);

        return "Event Removed";
    }
}