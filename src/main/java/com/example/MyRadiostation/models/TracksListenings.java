package com.example.MyRadiostation.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TracksListenings {
    String tname;
    Long listenings;

    public TracksListenings(String tname) {
        this.tname = tname;
    }

    public TracksListenings(Long listenings) {
        this.listenings = listenings;
    }
}
