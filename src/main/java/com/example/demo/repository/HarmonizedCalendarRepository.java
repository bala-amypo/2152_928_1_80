package com.example.demo.repository;

import com.example.demo.entity.HarmonizedCalendar;
import java.time.LocalDate;   // ✅ ADD THIS
import java.util.List;

public interface HarmonizedCalendarRepository {

    HarmonizedCalendar save(HarmonizedCalendar h);

    List<HarmonizedCalendar>
    findByEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(
            LocalDate from,
            LocalDate to
    );
}
