package com.example.demo.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.ClashRecordEntity;
import com.example.demo.Service.ClashDetectionService;

@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    private final ClashDetectionService clashService;

    public ClashRecordController(ClashDetectionService clashService) {
        this.clashService = clashService;
    }

    // LOG CLASH
    @PostMapping
    public ClashRecordEntity logClash(@RequestBody ClashRecordEntity clash) {
        return clashService.logClash(clash);
    }

    // RESOLVE CLASH
    @PutMapping("/{id}/resolve")
    public ClashRecordEntity resolveClash(@PathVariable Long id) {
        return clashService.resolveClash(id);
    }

    // GET ALL CLASHES
    @GetMapping
    public List<ClashRecordEntity> getAllClashes() {
        return clashService.getAllClashes();
    }

    // GET UNRESOLVED CLASHES
    @GetMapping("/unresolved")
    public List<ClashRecordEntity> getUnresolvedClashes() {
        return clashService.getUnresolvedClashes();
    }

    // GET CLASHES FOR EVENT
    @GetMapping("/event/{eventId}")
    public List<ClashRecord> getClashesForEvent(@PathVariable Long eventId) {
        return clashService.getClashesForEvent(eventId);
    }
}