package com.example.MyRadiostation.models;
import lombok.Data;

@Data
public class Schedule {
    private Long Id_Schedule;
    private Long Id_Program;
    private String Day_Of_Program;
    private String Time_Start;
    private String Time_End;
}
