package com.example.MyRadiostation.models;
import lombok.Data;

@Data
public class ArtistsInGroups {
    private Long Id_Artist;
    private Long Id_Group;
    private String Role_Artist;
    private String Date_Start_In_Group;
    private String Date_End_In_Group;
}
