package com.example.demo.Service;

import java.time.LocalDate;
import java.util.List;
import com.example.demo.Entity.HarmonizedCalendarEntity;

public interface HarmonizedCalendarService {

    HarmonizedCalendarEntity generateHarmonizedCalendar(String title, String generatedBy);

    HarmonizedCalendarEntity getCalendarById(Long id);

    List<HarmonizedCalendarEntity> getAllCalendars();

    List<HarmonizedCalendarEntity> getCalendarsWithinRange(LocalDate start, LocalDate end);
}