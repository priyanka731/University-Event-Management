package com.priyanka.UniversityEventManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Event")
public class Event {
    @Id
    private Integer eventId;
    private String eventName;
    private String locationOfEvent;
    private LocalDate eventDate;
    private LocalTime startTime;
    private LocalTime endTime;

}
