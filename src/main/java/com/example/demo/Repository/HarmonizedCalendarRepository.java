HarmonizedCalendarRepository.java

package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.HarmonizedCalendar;

public interface HarmonizedCalendarRepository
        extends JpaRepository<HarmonizedCalendar, Long> {

    List<HarmonizedCalendar> findByEffectiveFromBetween(
            LocalDate start, LocalDate end);
}