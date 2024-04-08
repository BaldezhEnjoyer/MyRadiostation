package com.example.MyRadiostation.models;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="Schedule")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "pName")
    private String pname;
    @Column(name="Day_Of_Program")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dayofprogram;
    @Column(name="Time_Start")
    @DateTimeFormat(pattern = "hh:mm")
    private Date timestart;
    @Column(name="Time_End")
    @DateTimeFormat(pattern = "hh:mm")
    private Date timeend;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "schedule")
    private List<SpeakersInSchedule> speakersinschedule = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "schedule")
    private List<ProgramsWithTracks> programswithtracks = new ArrayList<>();

    public Schedule(String pname, Date dayofprogram, Date timestart, Date timeend) {
        this.pname = pname;
        this.dayofprogram = dayofprogram;
        this.timestart = timestart;
        this.timeend = timeend;
    }
}
