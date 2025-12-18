ClashRecordController.java

package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;

@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    private final ClashDetectionService clashService;

    public ClashRecordController(ClashDetectionService clashService) {
        this.clashService = clashService;
    }

    // LOG CLASH
    @PostMapping
    public ClashRecord logClash(@RequestBody ClashRecord clash) {
        return clashService.logClash(clash);
    }

    // RESOLVE CLASH
    @PutMapping("/{id}/resolve")
    public ClashRecord resolveClash(@PathVariable Long id) {
        return clashService.resolveClash(id);
    }

    // GET ALL CLASHES
    @GetMapping
    public List<ClashRecord> getAllClashes() {
        return clashService.getAllClashes();
    }

    // GET UNRESOLVED CLASHES
    @GetMapping("/unresolved")
    public List<ClashRecord> getUnresolvedClashes() {
        return clashService.getUnresolvedClashes();
    }

    // GET CLASHES FOR EVENT
    @GetMapping("/event/{eventId}")
    public List<ClashRecord> getClashesForEvent(@PathVariable Long eventId) {
        return clashService.getClashesForEvent(eventId);
    }
}