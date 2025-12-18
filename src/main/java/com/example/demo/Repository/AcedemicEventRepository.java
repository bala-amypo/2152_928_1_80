package com.example.demo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.AcademicEventEntity;

public interface AcademicEventRepository extends JpaRepository<AcademicEventEntity, Long> {

    List<AcademicEventEntity> findByBranchId(Long branchId);
}