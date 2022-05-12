package entity;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Schedule {
    private String interval; // "8-9", "9-10"...
    private int day = 0; // 1,2,3...31 , nu e neaparata nevoie de acest atribut, decat in unele cazuri
    private String weekDay; // ziua saptamanii (luni, marti...)
    private int month = 0; // pentru serbari / verificari de semestru , nu e neaparata nevoie de acest atribut, decat in unele cazuri

    public Schedule(){
        day=0; month=0;
    }

    public Schedule(String interval, String weekDay) {
        this.interval = interval;
        this.weekDay = weekDay;
    }

    public String getInterval() { return interval;}
    public int getDay() { return day;}
    public String getWeekDay() { return weekDay;}
    public int getMonth() { return month;}
    public void setInterval(String interval) { this.interval = interval;}
    public void setDay(int day) { this.day = day;}
    public void setWeekDay(String weekDay) { this.weekDay = weekDay;}
    public void setMonth(int month) { this.month = month;}


    @Override
    public String toString() { return weekDay + " in intervalul orar: " + interval; }

    public String toCSV() { return interval + "," + weekDay; }

    public void read(Scanner in){
        System.out.println("Interval orar:");
        this.interval = in.nextLine();
        System.out.println("Ziua saptamanii:");
        this.weekDay = in.nextLine();
    }
}
