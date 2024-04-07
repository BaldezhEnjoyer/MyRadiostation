package com.example.MyRadiostation.models;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="Tracks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "tName")
    private String tname;
     @Column(name="Date_Create")
     @DateTimeFormat(pattern = "yyyy-MM-dd")
     private Date datecreate;

    public Track(Date datecreate, String tname) {
        this.datecreate = datecreate;
        this.tname = tname;
    }
}
