package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class HarmonizedCalendarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    public void setTitle(String title) {
        this.title = title;
    }
}
