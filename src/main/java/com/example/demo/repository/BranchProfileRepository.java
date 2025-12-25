package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;
public interface BranchProfileRepository {
    BranchProfile save(BranchProfile b);
    Optional<BranchProfile> findById(Long id);
    List<BranchProfile> findAll();
}