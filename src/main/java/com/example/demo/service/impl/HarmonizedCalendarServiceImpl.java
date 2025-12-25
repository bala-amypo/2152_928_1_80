package com.example.demo.service.impl;

import com.example.demo.entity.*;

public class HarmonizedCalendarServiceImpl {

    public HarmonizedCalendarEntity create(String title) {
        HarmonizedCalendarEntity c = new HarmonizedCalendarEntity();
        c.setTitle(title);
        return c;
    }
}
