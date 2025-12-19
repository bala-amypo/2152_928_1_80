package com.example.demo.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.EventMergeRecordEntity;
import com.example.demo.Repository.EventMergeRecordRepository;

@Service
public class EventMergeServiceImpl {
    @Autowired
    private EventMergeService eventMergeService;

    private final EventMergeRecordRepository repo;

    public EventMergeServiceImpl(EventMergeRecordRepository repo) {
        this.repo = repo;
    }
    import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



    



   


    @Override
    public EventMergeRecordEntity mergeEvents(List<Long> eventIds, String reason) {
        EventMergeRecordEntity record = new EventMergeService();
        record.setSourceEventIds(eventIds.toString());
        record.setMergeReason(reason);
        record.setCreatedAt(LocalDateTime.now());
        return repo.save(record);
    }

    @Override
    public EventMergeRecordEntity getMergeRecordById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<EventMergeRecordEntity> getAllMergeRecords() {
        return repo.findAll();
    }

    @Override
    public List<EventMergeRecordEntity> getMergeRecordsByDate(LocalDate start, LocalDate end) {
        return repo.findByCreatedAtBetween(start.atStartOfDay(), end.atTime(23,59));
    }
}


