package com.example.MyRadiostation.repositories;

import com.example.MyRadiostation.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistsRepository extends JpaRepository<Artist,Long> {
}
