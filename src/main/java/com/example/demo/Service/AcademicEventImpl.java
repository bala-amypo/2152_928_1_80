package com.example.demo.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.AcademicEventEntity;
import com.example.demo.Repository.AcademicEventRepository;

@Service
public class AcademicEventImpl implements AcademicEventService {

    private final AcademicEventRepository repo;

    public AcademicEventImpl(AcademicEventRepository repo) {
        this.repo = repo;
    }

    @Override
    public AcademicEventEntity createEvent(AcademicEventEntity event) {
        if (event.getStartDate().isAfter(event.getEndDate())) {
            throw new ValidationException("Start date must be before end date");
        }
        return repo.save(event);
    }

    @Override
    public AcademicEventEntity updateEvent(Long id, AcademicEventEntity event) {
        AcademicEventEntity existing = getEventById(id);
        existing.setTitle(event.getTitle());
        existing.setEventType(event.getEventType());
        existing.setStartDate(event.getStartDate());
        existing.setEndDate(event.getEndDate());
        existing.setLocation(event.getLocation());
        existing.setDescription(event.getDescription());
        return repo.save(existing);
    }

    @Override
    public AcademicEventEntity getEventById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    @Override
    public List<AcademicEventEntity> getAllEvents() {
        return repo.findAll();
    }

    @Override
    public List<AcademicEventEntity> getEventsByBranch(Long branchId) {
        return repo.findByBranchId(branchId);
    }
}