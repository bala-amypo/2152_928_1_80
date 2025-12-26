package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.service.AcademicEventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    private final AcademicEventRepository repository;

    public AcademicEventServiceImpl(AcademicEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public AcademicEvent createEvent(AcademicEvent event) {

        if (event.getStartDate().isAfter(event.getEndDate())) {
            throw new ValidationException("startDate cannot be after endDate");
        }

        return repository.save(event);
    }

    @Override
    public AcademicEvent updateEvent(Long id, AcademicEvent updated) {

        AcademicEvent existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

        if (updated.getStartDate().isAfter(updated.getEndDate())) {
            throw new ValidationException("startDate cannot be after endDate");
        }

        updated.setId(existing.getId());
        return repository.save(updated);
    }

    @Override
    public AcademicEvent getEventById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    @Override
    public List<AcademicEvent> getEventsByBranch(Long branchId) {
        return repository.findByBranchId(branchId);
    }

    @Override
    public List<AcademicEvent> getAllEvents() {
        return repository.findAll();
    }
}
