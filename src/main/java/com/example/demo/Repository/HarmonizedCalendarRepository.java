package com.example.demo.Repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.HarmonizedCalendarEntity;

public interface HarmonizedCalendarRepository
        extends JpaRepository<HarmonizedCalendarEntity, Long> {

    List<HarmonizedCalendarEntity> findByEffectiveFromBetween(
            LocalDate start, LocalDate end);
}