package com.example.MyRadiostation.repositories;

import com.example.MyRadiostation.models.Schedule;
import com.example.MyRadiostation.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
    List<Schedule> findByDayofprogram(LocalDate dayofprogram);
}
