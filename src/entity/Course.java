package entity;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Course extends Activity {
    private String name; // numele cursului / materiei studiate
    private String nivel; // pentru ce clase e destinat
    private List<Schedule> schedule; // fiecare curs are alocat un interval orar dintr-o zi a saptamanii

    public Course(){
        schedule = null;
    }

    public Course(String name, String nivel) {
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

    public int funLevel(){
        Random rand = new Random();
        int var = rand.nextInt(10);
        if (nivel=="avansat")
            return var*10;
        return var;
    }

    public String toCSV() { return name + "," + nivel; }

    public void read(Scanner in){
        System.out.println("Nume curs:");
        this.name = in.nextLine();
        System.out.println("Nivel:");
        this.nivel = in.nextLine();
    }
}
