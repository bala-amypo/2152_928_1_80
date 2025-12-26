package com.example.demo.controller;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/merge-records")
@Tag(name = "Event Merge Records")
public class EventMergeController {

    private final EventMergeService service;

    public EventMergeController(EventMergeService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Merge events")
    public EventMergeRecord merge(@RequestParam List<Long> eventIds,
                                  @RequestParam String reason) {
        return service.mergeEvents(eventIds, reason);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get merge record by ID")
    public EventMergeRecord getById(@PathVariable Long id) {
        return service.getMergeRecordById(id);
    }

    @GetMapping
    @Operation(summary = "Get all merge records")
    public Object getAll() {
        return service.getAllMergeRecords();
    }

    @GetMapping("/range")
    @Operation(summary = "Get merge records by date range")
    public Object getByDate(@RequestParam LocalDate start,
                            @RequestParam LocalDate end) {
        return service.getMergeRecordsByDate(start, end);
    }
}
