ClashRecordRepository.java

package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ClashRecord;

public interface ClashRecordRepository extends JpaRepository<ClashRecord, Long> {

    List<ClashRecord> findByEventId(Long eventId);

    List<ClashRecord> findByResolvedFalse();
}