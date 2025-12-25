package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;
public interface AcademicEventRepository {
    AcademicEvent save(AcademicEvent e);
    List<AcademicEvent> findByBranchId(Long branchId);
    List<AcademicEvent> findAllById(List<Long> ids);
}
