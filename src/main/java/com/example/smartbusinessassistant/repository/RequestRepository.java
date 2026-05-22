package com.example.smartbusinessassistant.repository;

import com.example.smartbusinessassistant.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
