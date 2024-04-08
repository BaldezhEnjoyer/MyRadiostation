package com.example.MyRadiostation.controllers;
import com.example.MyRadiostation.repositories.ArtistsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.MyRadiostation.models.Artist;
import lombok.RequiredArgsConstructor;
import java.util.Date;


@Controller
@RequiredArgsConstructor
public class ArtistsController {
    @Autowired
    private final ArtistsRepository artistsRepository;

    @GetMapping("/artists")
    public String allArtists( Model model) {
        Iterable<Artist> artists = artistsRepository.findAll();
        model.addAttribute("artists",artists);
        return "artists";
    }

    @GetMapping("/artists/create")
    public String artistCreate(Artist artist) {
        return "artist-create";
    }

    @PostMapping("/artists/create")
    public String artistCreate(@RequestParam String aname,@RequestParam String surname,@RequestParam Short age, @RequestParam("dateofbirth") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateofbirth,@RequestParam("dateofdeath") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateofdeath, Model model) {
        Artist artist = new Artist(aname,surname,age,dateofbirth,dateofdeath);
        artistsRepository.save(artist);
        return "redirect:/artists";
    }



    @PostMapping("/artists/{id}/delete")
    public String artistDelete(@PathVariable(value="id") Long id, Model model) {
        Artist artist = artistsRepository.findById(id).orElseThrow();
        artistsRepository.delete(artist);
        return "redirect:/artists";
    }

}