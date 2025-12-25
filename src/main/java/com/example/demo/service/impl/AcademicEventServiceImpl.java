package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.AcademicEventRepository;

import java.time.LocalDate;
import java.util.List;

public class AcademicEventServiceImpl {

    private final AcademicEventRepository repository;

    public AcademicEventServiceImpl(AcademicEventRepository repository) {
        this.repository = repository;
    }

    public AcademicEvent createEvent(AcademicEvent event) {

        LocalDate start = event.getStartDate();
        LocalDate end = event.getEndDate();

        if (start != null && end != null && start.isAfter(end)) {
            throw new ValidationException("startDate cannot be after endDate");
        }

        event.prePersist();
        return repository.save(event);
    }

    public List<AcademicEvent> getEventsByBranch(Long branchId) {
        return repository.findByBranchId(branchId);
    }
}
