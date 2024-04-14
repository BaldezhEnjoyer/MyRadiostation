package com.example.MyRadiostation.repositories;

import com.example.MyRadiostation.models.ProgramsWithTracks;
import com.example.MyRadiostation.models.SpeakersInSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeakersInScheduleRepository extends JpaRepository<SpeakersInSchedule,Long> {
    List<SpeakersInSchedule> findBySpeaker_Id(Long idspeaker);
    List<SpeakersInSchedule> findByProgram_Id(Long idprogram);
}
