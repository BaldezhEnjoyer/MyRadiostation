package com.example.MyRadiostation.repositories;

import com.example.MyRadiostation.controllers.ITracksListenings;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MyRadiostation.models.Track;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TracksRepository extends JpaRepository<Track,Long>, CrudRepository<Track, Long> {
    List<Track> findByTname(String tname);
    List<Track> findByDatecreate(LocalDate datecreate);
    List<Track> findAllByDatecreateBetween(LocalDate start,LocalDate end);
    @Query(value = " SELECT "+
            " tName AS tname, COUNT(tName) AS listenings "+
            " FROM "+
            " Programs_With_Tracks inner join Tracks on Programs_With_Tracks.Id_Track = Tracks.Id Where Tracks.tName = :trackname"+
            " GROUP BY tName ",nativeQuery = true)
    List<ITracksListenings> CountListeningsTracks(@Param("trackname") String trackname);
}
