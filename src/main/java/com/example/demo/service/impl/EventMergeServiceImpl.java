package com.example.demo.service.impl;

import com.example.demo.entity.*;
import java.util.*;

public class EventMergeServiceImpl {

    public EventMergeRecordEntity merge(Long branchA, Long branchB) {
        return new EventMergeRecordEntity(branchA, branchB);
    }

    public List<EventMergeRecordEntity> history() {
        return new ArrayList<>();
    }
}
