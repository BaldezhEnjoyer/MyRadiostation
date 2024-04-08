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
@Table(name="Artists")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "aName")
    private String aname;
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
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Genre")
    private Genre genre;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "artist")
    private List<TracksOfArtists>  tracksofartists = new ArrayList<>();


    public Artist(String aname, String surname, Short age, Date dateofbirth, Date dateofdeath) {
        this.aname = aname;
        this.surname = surname;
        this.age = age;
        this.dateofbirth = dateofbirth;
        this.dateofdeath = dateofdeath;
    }
}
