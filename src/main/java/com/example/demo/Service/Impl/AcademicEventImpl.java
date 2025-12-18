AcademicEventServiceImpl.java

package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.AcademicEvent;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.AcademicEventRepository;

@Service
public class AcademicEventServiceImpl implements AcademicEventService {

    private final AcademicEventRepository repo;

    public AcademicEventServiceImpl(AcademicEventRepository repo) {
        this.repo = repo;
    }

    @Override
    public AcademicEvent createEvent(AcademicEvent event) {
        if (event.getStartDate().isAfter(event.getEndDate())) {
            throw new ValidationException("Start date must be before end date");
        }
        return repo.save(event);
    }

    @Override
    public AcademicEvent updateEvent(Long id, AcademicEvent event) {
        AcademicEvent existing = getEventById(id);
        existing.setTitle(event.getTitle());
        existing.setEventType(event.getEventType());
        existing.setStartDate(event.getStartDate());
        existing.setEndDate(event.getEndDate());
        existing.setLocation(event.getLocation());
        existing.setDescription(event.getDescription());
        return repo.save(existing);
    }

    @Override
    public AcademicEvent getEventById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    @Override
    public List<AcademicEvent> getAllEvents() {
        return repo.findAll();
    }

    @Override
    public List<AcademicEvent> getEventsByBranch(Long branchId) {
        return repo.findByBranchId(branchId);
    }
}