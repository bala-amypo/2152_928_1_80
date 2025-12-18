package com.example.demo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.ClashRecordEntity;

public interface ClashRecordRepository extends JpaRepository<ClashRecordEntity, Long> {

    List<ClashRecordEntity> findByEventId(Long eventId);

    List<ClashRecordEntity> findByResolvedFalse();
}