package com.example.demo.Service;

import java.util.List;
import com.example.demo.Entity.AcademicEventEntity;

public interface AcademicEventService {

    AcademicEventEntity createEvent(AcademicEventEntity event);

    AcademicEventEntity updateEvent(Long id, AcademicEventEntity event);

    AcademicEventEntity getEventById(Long id);

    List<AcademicEventEntity> getAllEvents();

    List<AcademicEventEntity> getEventsByBranch(Long branchId);
}

