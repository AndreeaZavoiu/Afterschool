package entity;

import java.util.Arrays;

public class Serbare extends Activity {
    private Student[] students;
    private String location;
    private Schedule schedule;
    private String tematica; // iarna/vara/8 martie/paste etc

    public Serbare(String location, String interval, String weekDay, String tematica) {
        this.location = location;
        this.schedule = new Schedule(interval, weekDay);
        this.tematica = tematica;
    }

    public Serbare(Student[] students, String location, Schedule schedule, String tematica) {
        this.students = students;
        this.location = location;
        this.schedule = schedule;
        this.tematica = tematica;
    }

    @Override
    public String toString() {
        String str = "\n   Va invitam la serbarea cu tematica '" + tematica + "', de la locatia '" + location +
                "', program: " + schedule + ", la care vor participa elevii: ";
        for (Student s: students)
            str += s.getName() + ", ";
        return str;
    }

    @Override
    public int funLevel(){
        return students.length * 10;
    }

    public String toCSV() {
        return location +
                "," + schedule +
                "," + tematica;
    }
}
