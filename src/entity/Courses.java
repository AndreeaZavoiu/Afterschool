package entity;

import java.util.List;

public class Courses extends entity.Activity {
    private String name; // numele cursului / materiei studiate
    private String nivel; // pentru ce clase e destinat
    private List<Schedule> schedule; // fiecare curs are alocat un interval orar dintr-o zi a saptamanii

    public Courses(String name, String nivel) {
        this.name = name;
        this.nivel = nivel;
    }

    public String getName() { return name; }
    public String getNivel() { return nivel; }
    public List<Schedule> getSchedule() { return schedule; }

    public void setName(String name) {this.name = name;}
    public void setNivel(String nivel) {this.nivel = nivel;}
    public void setSchedule(List<Schedule> schedule) {this.schedule = schedule;}

    @Override
    public String toString() {
        return "Curs: " + name + ", nivel " + nivel + ", se desfasoara: " + schedule;
    }

}
