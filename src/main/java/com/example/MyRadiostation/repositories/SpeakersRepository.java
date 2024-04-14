package com.example.MyRadiostation.repositories;

import com.example.MyRadiostation.models.Speaker;
import com.example.MyRadiostation.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SpeakersRepository extends JpaRepository<Speaker,Long> {
    List<Speaker> findBySurname(String surname);
}
