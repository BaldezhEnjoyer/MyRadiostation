package com.example.MyRadiostation.controllers;
import com.example.MyRadiostation.repositories.SpeakersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.MyRadiostation.models.Speaker;
import lombok.RequiredArgsConstructor;
import java.util.Date;


@Controller
@RequiredArgsConstructor
public class SpeakersController {
    @Autowired
    private final SpeakersRepository speakersRepository;

    @GetMapping("/speakers")
    public String allSpeakers( Model model) {
        Iterable<Speaker> speakers = speakersRepository.findAll();
        model.addAttribute("speakers",speakers);
        return "speakers";
    }

    @GetMapping("/speakers/create")
    public String speakerCreate(Speaker speaker) {
        return "speaker-create";
    }

    @PostMapping("/speakers/create")
    public String speakerCreate(@RequestParam String sname,@RequestParam String surname,@RequestParam Short age, @RequestParam("dateofbirth") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateofbirth,@RequestParam("dateofdeath") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateofdeath, Model model) {
        Speaker speaker = new Speaker(sname,surname,age,dateofbirth,dateofdeath);
        speakersRepository.save(speaker);
        return "redirect:/speakers";
    }



    @PostMapping("/speakers/{id}/delete")
    public String speakerDelete(@PathVariable(value="id") Long id, Model model) {
        Speaker speaker = speakersRepository.findById(id).orElseThrow();
        speakersRepository.delete(speaker);
        return "redirect:/speakers";
    }

}