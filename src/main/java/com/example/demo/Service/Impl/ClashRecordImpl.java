ClashDetectionServiceImpl.java

package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.ClashRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ClashRecordRepository;

@Service
public class ClashDetectionServiceImpl implements ClashDetectionService {

    private final ClashRecordRepository repo;

    public ClashDetectionServiceImpl(ClashRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public ClashRecord logClash(ClashRecord clash) {
        clash.setResolved(false);
        return repo.save(clash);
    }

    @Override
    public ClashRecord resolveClash(Long id) {
        ClashRecord clash = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Clash not found"));
        clash.setResolved(true);
        return repo.save(clash);
    }

    @Override
    public List<ClashRecord> getClashesForEvent(Long eventId) {
        return repo.findByEventId(eventId);
    }

    @Override
    public List<ClashRecord> getUnresolvedClashes() {
        return repo.findByResolvedFalse();
    }

    @Override
    public List<ClashRecord> getAllClashes() {
        return repo.findAll();
    }
}