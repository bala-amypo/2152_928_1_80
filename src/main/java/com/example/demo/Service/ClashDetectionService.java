ClashDetectionService.java

package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.ClashRecord;

public interface ClashDetectionService {

    ClashRecord logClash(ClashRecord clash);

    ClashRecord resolveClash(Long id);

    List<ClashRecord> getClashesForEvent(Long eventId);

    List<ClashRecord> getUnresolvedClashes();

    List<ClashRecord> getAllClashes();
}