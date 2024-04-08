package com.example.MyRadiostation.controllers;
import com.example.MyRadiostation.repositories.AlbumsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.MyRadiostation.models.Album;
import lombok.RequiredArgsConstructor;
import java.util.Date;


@Controller
@RequiredArgsConstructor
public class AlbumsController {
    @Autowired
    private final AlbumsRepository albumsRepository;

    @GetMapping("/albums")
    public String allAlbums( Model model) {
        Iterable<Album> albums = albumsRepository.findAll();
        model.addAttribute("albums",albums);
        return "albums";
    }

    @GetMapping("/albums/create")
    public String albumCreate(Album album) {
        return "album-create";
    }

    @PostMapping("/albums/create")
    public String albumCreate(@RequestParam String aname, @RequestParam("datecreate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date datecreate, Model model) {
        Album album = new Album(aname,datecreate);
        albumsRepository.save(album);
        return "redirect:/albums";
    }



    @PostMapping("/albums/{id}/delete")
    public String albumDelete(@PathVariable(value="id") Long id, Model model) {
        Album album = albumsRepository.findById(id).orElseThrow();
        albumsRepository.delete(album);
        return "redirect:/albums";
    }

}
