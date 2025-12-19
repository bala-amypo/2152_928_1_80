package com.example.demo.repository;

import com.example.demo.entity.ClashRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClashRecordRepository
        extends JpaRepository<ClashRecordEntity, Long> {

    List<ClashRecordEntity> findByEventAIdOrEventBId(Long eventAId, Long eventBId);

    List<ClashRecordEntity> findByResolvedFalse();
}
