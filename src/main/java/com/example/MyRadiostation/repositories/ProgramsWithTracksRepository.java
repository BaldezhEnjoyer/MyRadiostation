package com.example.MyRadiostation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MyRadiostation.models.ProgramsWithTracks;

public interface ProgramsWithTracksRepository extends JpaRepository<ProgramsWithTracks,Long> {
}
