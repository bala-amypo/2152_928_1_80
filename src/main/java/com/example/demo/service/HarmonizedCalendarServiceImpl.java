package com.example.demo.service.impl;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.repository.HarmonizedCalendarRepository;

import java.time.LocalDate;
import java.util.List;

public class HarmonizedCalendarServiceImpl {

    private final HarmonizedCalendarRepository repository;

    public HarmonizedCalendarServiceImpl(HarmonizedCalendarRepository repository) {
        this.repository = repository;
    }

    public HarmonizedCalendar generateHarmonizedCalendar(
            String title, String generatedBy) {

        HarmonizedCalendar calendar = new HarmonizedCalendar();
        calendar.setGeneratedBy(generatedBy);
        calendar.prePersist();

        return repository.save(calendar);
    }

    public List<HarmonizedCalendar> getCalendarsWithinRange(
            LocalDate from, LocalDate to) {

        return repository
                .findByEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(
                        from, to);
    }
}
