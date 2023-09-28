package com.priyanka.UniversityEventManagement.repository;

import com.priyanka.UniversityEventManagement.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IEventRepo extends CrudRepository<Event,Integer> {
    List<Event> findByEventDate(LocalDate Date);
}