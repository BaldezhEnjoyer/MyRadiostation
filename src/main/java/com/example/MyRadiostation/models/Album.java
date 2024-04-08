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
@Table(name="Albums")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "aName")
    private String aname;
    @Column(name="Date_Create")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datecreate;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "album")
    private List<Track> tracks = new ArrayList<>();

    public Album(String aname,Date datecreate) {
        this.datecreate = datecreate;
        this.aname = aname;
    }
}
