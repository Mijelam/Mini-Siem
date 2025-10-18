package com.Mijelam.mini_siem.repository;

import com.Mijelam.mini_siem.model.LogEvent;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LogEventRepository extends JpaRepository<LogEvent, Long> {
    int countByLevel(String level);
}
