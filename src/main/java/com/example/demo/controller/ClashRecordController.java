package com.example.demo.controller;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clashes")
@Tag(name = "Clash Records")
public class ClashRecordController {

    private final ClashDetectionService service;

    public ClashRecordController(ClashDetectionService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Log clash")
    public ClashRecord log(@RequestBody ClashRecord clash) {
        return service.logClash(clash);
    }

    @PutMapping("/{id}/resolve")
    @Operation(summary = "Resolve clash")
    public ClashRecord resolve(@PathVariable Long id) {
        return service.resolveClash(id);
    }

    @GetMapping("/event/{eventId}")
    @Operation(summary = "Get clashes for event")
    public Object getByEvent(@PathVariable Long eventId) {
        return service.getClashesForEvent(eventId);
    }

    @GetMapping("/unresolved")
    @Operation(summary = "Get unresolved clashes")
    public Object getUnresolved() {
        return service.getUnresolvedClashes();
    }

    @GetMapping
    @Operation(summary = "Get all clashes")
    public Object getAll() {
        return service.getAllClashes();
    }
}
