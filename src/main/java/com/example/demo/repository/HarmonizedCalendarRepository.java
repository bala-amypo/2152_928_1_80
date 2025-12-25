package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;
public interface HarmonizedCalendarRepository {
    HarmonizedCalendar save(HarmonizedCalendar h);
    List<HarmonizedCalendar> findByEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(
        LocalDate f, LocalDate t);
}
