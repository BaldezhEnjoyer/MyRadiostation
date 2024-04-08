package com.example.MyRadiostation.repositories;

import com.example.MyRadiostation.models.TracksOfArtists;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TracksOfArtistsRepository extends JpaRepository<TracksOfArtists,Long> {
}
