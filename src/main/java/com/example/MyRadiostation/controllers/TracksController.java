package com.example.MyRadiostation.controllers;
import com.example.MyRadiostation.repositories.TracksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.MyRadiostation.models.Track;
import lombok.RequiredArgsConstructor;
import java.util.Date;


@Controller
@RequiredArgsConstructor
public class TracksController {
    @Autowired
    private final TracksRepository tracksRepository;

    @GetMapping("/tracks")
    public String allTracks( Model model) {
        Iterable<Track> tracks = tracksRepository.findAll();
        model.addAttribute("tracks",tracks);
        return "tracks";
    }

    @GetMapping("/tracks/create")
    public String trackCreate(Track track) {
        return "track-create";
    }

    @PostMapping("/tracks/create")
    public String trackCreate(@RequestParam String tname, @RequestParam("datecreate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date datecreate, Model model) {
        Track track = new Track(tname,datecreate);
        tracksRepository.save(track);
        return "redirect:/tracks";
    }



    @PostMapping("/tracks/{id}/delete")
    public String trackDelete(@PathVariable(value="id") Long id, Model model) {
        Track track = tracksRepository.findById(id).orElseThrow();
        tracksRepository.delete(track);
        return "redirect:/tracks";
    }

}
