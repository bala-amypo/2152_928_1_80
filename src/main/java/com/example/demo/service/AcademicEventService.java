package com.example.demo.service;

import com.example.demo.entity.AcademicEventEntity;
import java.util.List;

public interface AcademicEventService {

    AcademicEventEntity createEvent(AcademicEventEntity event);

    List<AcademicEventEntity> getEventsByBranch(Long branchId);

    AcademicEventEntity updateEvent(String title, AcademicEventEntity event);

    AcademicEventEntity getEventById(String title);

    List<AcademicEventEntity> getAllEvents();
}
