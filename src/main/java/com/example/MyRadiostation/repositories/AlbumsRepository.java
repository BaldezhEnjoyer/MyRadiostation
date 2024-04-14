package com.example.MyRadiostation.repositories;

import com.example.MyRadiostation.models.Album;
import com.example.MyRadiostation.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AlbumsRepository extends JpaRepository<Album,Long> {
    List<Album> findByAname(String aname);
}
