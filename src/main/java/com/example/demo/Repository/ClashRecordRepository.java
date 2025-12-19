package com.example.demo.Repository;

import com.example.demo.entity.ClashRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClashRecordRepository extends JpaRepository<ClashRecordEntity, Long> {

    List<ClashRecordEntity> findByResolved(Boolean resolved);

    List<ClashRecordEntity> findByEventAIdOrEventBId(Long eventAId, Long eventBId);
}
