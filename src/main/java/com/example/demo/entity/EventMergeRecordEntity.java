package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.*;

@Entity
public class EventMergeRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long branchA;
    private Long branchB;
    private LocalDateTime createdAt;

    public EventMergeRecordEntity() {}

    public EventMergeRecordEntity(Long a, Long b) {
        this.branchA = a;
        this.branchB = b;
        this.createdAt = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
