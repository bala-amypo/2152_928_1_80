package com.example.demo.repository;

import com.example.demo.entity.AcademicEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AcademicEventRepository
        extends JpaRepository<AcademicEventEntity, String> {

    List<AcademicEventEntity> findByBranchId(Long branchId);
}
