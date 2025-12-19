package com.example.demo.service;

import com.example.demo.entity.AcademicEventEntity;
import java.util.List;

public interface AcademicEventService {

    AcademicEventEntity createEvent(AcademicEventEntity event);

    List<AcademicEventEntity> getEventsByBranch(Long branchId);

    AcademicEventEntity updateEvent(Long id, AcademicEventEntity event);

    AcademicEventEntity getEventById(Long id);

    List<AcademicEventEntity> getAllEvents();
}
