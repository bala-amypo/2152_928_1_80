package com.example.demo.serviceimpl;

import com.example.demo.entity.AcademicEventEntity;
import com.example.demo.exception.ResourceNotFoundException;
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
    public AcademicEventEntity createEvent(AcademicEventEntity event) {
        return repository.save(event);
    }

    @Override
    public List<AcademicEventEntity> getEventsByBranch(Long branchId) {
        return repository.findByBranchId(branchId);
    }

    @Override
    public AcademicEventEntity updateEvent(String title, AcademicEventEntity event) {
        AcademicEventEntity existing = getEventById(title);

        existing.setEventType(event.getEventType());
        existing.setStartDate(event.getStartDate());
        existing.setEndDate(event.getEndDate());
        existing.setLocation(event.getLocation());
        existing.setDescription(event.getDescription());

        return repository.save(existing);
    }

    @Override
    public AcademicEventEntity getEventById(String title) {
        return repository.findById(title)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Event not found"));
    }

    @Override
    public List<AcademicEventEntity> getAllEvents() {
        return repository.findAll();
    }
}
