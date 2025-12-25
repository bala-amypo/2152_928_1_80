package com.example.demo.service.impl;

import com.example.demo.entity.*;
import java.time.*;

public class AcademicEventServiceImpl {

    public AcademicEventEntity updateEvent(AcademicEventEntity existing,
                                           AcademicEventEntity incoming) {

        existing.setEventType(incoming.getEventType());
        existing.setStartDate(incoming.getStartDate());
        existing.setEndDate(incoming.getEndDate());
        existing.setLocation(incoming.getLocation());
        existing.setDescription(incoming.getDescription());

        return existing;
    }
}
