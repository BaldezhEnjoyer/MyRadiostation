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
@Table(name="Speakers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "sName")
    private String sname;
    @Column(name = "Surname")
    private String surname;
    @Column(name = "Age")
    private Short age;
    @Column(name="Date_Of_Birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateofbirth;
    @Column(name="Date_Of_Death")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateofdeath;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "speaker")
    private List<SpeakersInSchedule> speakersinschedule = new ArrayList<>();

    public Speaker(String sname, String surname, Short age, Date dateofbirth, Date dateofdeath) {
        this.sname = sname;
        this.surname = surname;
        this.age = age;
        this.dateofbirth = dateofbirth;
        this.dateofdeath = dateofdeath;
    }
}
