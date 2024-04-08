package com.example.MyRadiostation.controllers;
import com.example.MyRadiostation.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.MyRadiostation.models.Schedule;
import lombok.RequiredArgsConstructor;
import java.util.Date;


@Controller
@RequiredArgsConstructor
public class ScheduleController {
    @Autowired
    private final ScheduleRepository scheduleRepository;

    @GetMapping("/schedule")
    public String allSchedule( Model model) {
        Iterable<Schedule> schedule = scheduleRepository.findAll();
        model.addAttribute("schedule",schedule);
        return "schedule";
    }

    @GetMapping("/schedule/create")
    public String programCreate(Schedule program) {
        return "program-create";
    }

    @PostMapping("/schedule/create")
    public String programCreate(@RequestParam String pname,@RequestParam("dayofprogram") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dayofprogram,@RequestParam("timestart") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) Date timestart,@RequestParam("timestart") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) Date timeend, Model model) {
        Schedule program = new Schedule(pname,dayofprogram,timestart,timeend);
        scheduleRepository.save(program);
        return "redirect:/schedule";
    }



    @PostMapping("/schedule/{id}/delete")
    public String programDelete(@PathVariable(value="id") Long id, Model model) {
        Schedule program = scheduleRepository.findById(id).orElseThrow();
        scheduleRepository.delete(program);
        return "redirect:/schedule";
    }

}