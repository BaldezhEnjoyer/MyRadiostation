package com.example.MyRadiostation.repositories;

import com.example.MyRadiostation.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumsRepository extends JpaRepository<Album,Long> {
}
