package com.example.MyRadiostation.controllers;
import com.example.MyRadiostation.models.Schedule;
import com.example.MyRadiostation.models.Track;
import com.example.MyRadiostation.models.ProgramsWithTracks;
import com.example.MyRadiostation.repositories.ProgramsWithTracksRepository;
import com.example.MyRadiostation.repositories.TracksRepository;
import com.example.MyRadiostation.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@EnableMethodSecurity
@Controller
@RequiredArgsConstructor
public class ProgramsWithTracksController {
    @Autowired
    private final ProgramsWithTracksRepository programsWithTracksRepository;
    @Autowired
    private final TracksRepository tracksRepository;
    @Autowired
    private final ScheduleRepository scheduleRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/programswithtracks")
    public String allProgramsWithTracks(Model model) {
            Iterable<ProgramsWithTracks> programswithtracks = programsWithTracksRepository.findAll();
            model.addAttribute("programswithtracks", programswithtracks);
            return "programswithtracks";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/programswithtracks-find/**")
    public String getProgramsWithTracksByTrackId(@RequestParam(name = "idtrack", required = false) Long idtrack,@RequestParam(name = "idprogram", required = false) Long idprogram, Model model) {
        if(idtrack != null && idprogram ==null) {
            model.addAttribute("programswithtracks", programsWithTracksRepository.findByTrack_Id(idtrack));
            return "programswithtracks-find";
        }
        else if (idtrack == null && idprogram !=null) {
            model.addAttribute("programswithtracks",programsWithTracksRepository.findByProgram_Id(idprogram));
            return "programswithtracks-find";
        }
        else{
            model.addAttribute("programswithtracks",programsWithTracksRepository.findByProgram_Id(idprogram));
            return "programswithtracks-find";
        }
    }

//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/programswithtracks-find/**")
//    public String getProgramsWithTracksByProgramId(@RequestParam(name = "idprogram", required = false) Long idprogram, Model model) {
//        model.addAttribute("programswithtracks",programsWithTracksRepository.findByProgram_Id(idprogram));
//        return "programswithtracks-find";
//    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/programswithtracks/create")
    public String ProgramsWithTracksCreate(ProgramsWithTracks programswithtracks) {
        return "programswithtracks-create";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/programswithtracks/create")
    public String ProgramsWithTracksCreate(@RequestParam Long idtrack,@RequestParam Long idprogram) {
        Schedule program =  scheduleRepository.findById(idprogram).orElseThrow();
        Track track = tracksRepository.findById(idtrack).orElseThrow();
        programsWithTracksRepository.save(new ProgramsWithTracks(track,program));
        return "redirect:/programswithtracks";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/programswithtracks/{id}/delete")
    public String ProgramsWithTracksDelete(@PathVariable(value="id") Long id, Model model) {
        ProgramsWithTracks pwt = programsWithTracksRepository.findById(id).orElseThrow();
        programsWithTracksRepository.delete(pwt);
        return "redirect:/programswithtracks";
    }

}