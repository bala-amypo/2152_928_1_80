package com.example.demo.service.impl;

import com.example.demo.entity.*;
import java.util.*;

public class BranchProfileServiceImpl {

    public BranchProfileEntity createBranch(String code, String name, String email) {
        BranchProfileEntity b = new BranchProfileEntity();
        b.setActive(true);
        return b;
    }

    public void attachEvents(BranchProfileEntity branch, List<AcademicEventEntity> events) {
        for (AcademicEventEntity e : events) {
            e.setBranch(branch);
        }
    }
}
