package entity;
import java.util.List;
import java.util.Scanner;

public class Teacher extends Employee {

    private List<Course> courses; // cursuri pe care le preda
    private List<Schedule> orar;

    public Teacher(){
        super();
        this.courses = null;
        this.orar = null;
    }

    public Teacher(String name, String departament, int salary) {
        super(name, departament, salary);
    }

    public Teacher(String name, String departament, int salary, List<Course> courses) {
        super(name, departament, salary);
        this.courses = courses;
        this.orar = orar;
    }

    public List<Course> getCourses() { return courses;}
    public List<Schedule> getOrar() { return orar;}
    public void setCourses(List<Course> courses) { this.courses = courses;}
    public void setOrar(List<Schedule> orar) { this.orar = orar;}

    @Override
    public String toString() {
        return "\nTeacher: " + super.getName() +
                " preda:" + courses
//                + ", orar=" + orar
                ;
    }

    public String toCSV() {
        return getName() +
                "," + getDepartament() +
                "," + getSalary();
    }

    public void read(Scanner in){
        super.read(in);
    }
}
