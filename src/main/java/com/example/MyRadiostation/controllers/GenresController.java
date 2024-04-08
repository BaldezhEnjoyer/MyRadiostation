package com.example.MyRadiostation.controllers;
import com.example.MyRadiostation.repositories.GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.MyRadiostation.models.Genre;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class GenresController {
    @Autowired
    private final GenresRepository genresRepository;

    @GetMapping("/genres")
    public String allGenres( Model model) {
        Iterable<Genre> genres = genresRepository.findAll();
        model.addAttribute("genres",genres);
        return "genres";
    }

    @GetMapping("/genres/create")
    public String genreCreate(Genre genre) {
        return "genre-create";
    }

    @PostMapping("/genres/create")
    public String genreCreate(@RequestParam String gname, Model model) {
        Genre genre = new Genre(gname);
        genresRepository.save(genre);
        return "redirect:/genres";
    }



    @PostMapping("/genres/{id}/delete")
    public String genreDelete(@PathVariable(value="id") Long id, Model model) {
        Genre genre = genresRepository.findById(id).orElseThrow();
        genresRepository.delete(genre);
        return "redirect:/genres";
    }

}