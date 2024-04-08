package com.example.MyRadiostation.repositories;

import com.example.MyRadiostation.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SpeakersRepository extends JpaRepository<Speaker,Long> {
}
