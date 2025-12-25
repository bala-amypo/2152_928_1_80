package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;
public interface ClashRecordRepository {
    Optional<ClashRecord> findById(Long id);
    ClashRecord save(ClashRecord c);
    List<ClashRecord> findByResolvedFalse();
    List<ClashRecord> findByEventAIdOrEventBId(Long a, Long b);
}
