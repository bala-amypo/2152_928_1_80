package com.example.demo.Service;

import java.util.List;
import com.example.demo.Entity.ClashRecordEntity;

public interface ClashDetectionService {
    
    ClashRecordEntity resolveClash(Long id);


    ClashRecordEntity logClash(ClashRecordEntity clash);

    //ClashRecordEntity resolveClash(Long id);

    List<ClashRecordEntity> getClashesForEvent(Long eventId);

    List<ClashRecordEntity> getUnresolvedClashes();

    List<ClashRecordEntity> getAllClashes();
}



