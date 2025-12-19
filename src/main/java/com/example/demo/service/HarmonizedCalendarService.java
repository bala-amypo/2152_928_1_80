package com.example.demo.service;

import com.example.demo.entity.HarmonizedCalendarEntity;
import java.time.LocalDate;
import java.util.List;

public interface HarmonizedCalendarService {

    HarmonizedCalendarEntity generateHarmonizedCalendar(String title, String generatedBy);

    HarmonizedCalendarEntity getCalendarById(Long id);

    List<HarmonizedCalendarEntity> getAllCalendars();

    List<HarmonizedCalendarEntity> getCalendarsWithinRange(
            LocalDate start, LocalDate end);
}
