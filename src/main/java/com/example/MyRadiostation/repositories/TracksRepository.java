package com.example.MyRadiostation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MyRadiostation.models.Track;

public interface TracksRepository extends JpaRepository<Track,Long> {
}
