package entity;

import java.util.List;

public class Teacher extends entity.Employee {

    private List<entity.Courses> courses; // cursuri pe care le preda
    private List<entity.Schedule> orar;

    public Teacher(String name, String departament, int salary, List<entity.Courses> courses) {
        super(name, departament, salary);
        this.courses = courses;
        this.orar = orar;
    }

    public List<entity.Courses> getCourses() { return courses;}
    public List<entity.Schedule> getOrar() { return orar;}
    public void setCourses(List<entity.Courses> courses) { this.courses = courses;}
    public void setOrar(List<entity.Schedule> orar) { this.orar = orar;}

    @Override
    public String toString() {
        return "\nTeacher: " + super.getName() +
                " preda:" + courses
//                + ", orar=" + orar
                ;
    }
}
