EventMergeController.java

package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;

@RestController
@RequestMapping("/api/event-merges")
public class EventMergeController {

    private final EventMergeService mergeService;

    public EventMergeController(EventMergeService mergeService) {
        this.mergeService = mergeService;
    }

    // MERGE EVENTS
    @PostMapping
    public EventMergeRecord mergeEvents(@RequestBody List<Long> eventIds,
                                        @RequestParam String reason) {
        return mergeService.mergeEvents(eventIds, reason);
    }

    // GET ALL MERGE RECORDS
    @GetMapping
    public List<EventMergeRecord> getAllMergeRecords() {
        return mergeService.getAllMergeRecords();
    }

    // GET MERGE RECORD BY ID
    @GetMapping("/{id}")
    public EventMergeRecord getMergeRecordById(@PathVariable Long id) {
        return mergeService.getMergeRecordById(id);
    }
}