package com.example.MyRadiostation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MyRadiostation.models.Genre;

public interface GenresRepository extends JpaRepository<Genre,Long> {
}
