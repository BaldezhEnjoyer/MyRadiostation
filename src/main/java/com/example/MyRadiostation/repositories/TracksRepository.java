package com.example.MyRadiostation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MyRadiostation.models.Track;

import java.util.List;

public interface TracksRepository extends JpaRepository<Track,Long> {
    List<Track> findByTname(String tname);
}
