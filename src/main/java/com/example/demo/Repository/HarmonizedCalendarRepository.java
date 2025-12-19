package com.example.demo.repository;

import com.example.demo.entity.HarmonizedCalendarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HarmonizedCalendarRepository
        extends JpaRepository<HarmonizedCalendarEntity, Long> {
}
