package com.example.demo.service;

import com.example.demo.entity.AcademicEventEntity;
import java.util.List;

public interface AcademicEventService {
    AcademicEventEntity save(AcademicEventEntity event);
    List<AcademicEventEntity> getAll();
}
