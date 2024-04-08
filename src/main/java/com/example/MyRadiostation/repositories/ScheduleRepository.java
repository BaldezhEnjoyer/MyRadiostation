package com.example.MyRadiostation.repositories;

import com.example.MyRadiostation.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
}
