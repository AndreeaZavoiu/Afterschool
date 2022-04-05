package service;
import entity.*;
import java.util.Arrays;
import java.util.List;


public class Afterschool {          // clasa serviciu care expune operatiile sistemului

    // poate nu e nevoie de aceste date membre, de constructor si de getteri si setteri
    private Student[] students;
    private List<Employee> employees; // list = to access the elements frequently by using the index

    public Afterschool(Student[] students, List<Employee> employees) {
        this.students = students;
        this.employees = employees;
    }

    public Student[] getStudent() {
        return students;
    }
    public List<Employee> getEmployees(){
        return employees;
    }
    public void setStudent(Student[] students) {
        this.students = students;
    }
    public void setTeacher(List<Employee> employees) {
        this.employees = employees;
    }



    // actiuni / interogari pe obiectele create
    public void AddTeacher (Employee employee){
        employees.add(employee);
    }
    public void AddStudent (Student student) {}
    public void AddCourse (Courses course) {}
    public void ChangeTeacher (Teacher teacher) {}  // metoda membra clasei Teacher => change this teacher? sau am nevoie de 2 teachers
    public void ChangeSchedule (Schedule s1, Schedule s2) {}
    public void GetClassroom (Classroom c, Schedule s) {}   // afiseaza clasele complex: ce studenti in acea clasa, ce curs au in intervalul dat
    public void GetOrar(Schedule schedule) {}  // afiseaza orar complex: studentii in ce clase si la ce cursuri -> pe intervale orare
    public void DeleteStudent (Student student) {}   // daca a depasit ciclul primar de studii, este sters din Afterschool
    public void DeleteEmployee (Employee employee) {}
    public void DeleteCourse (Courses course) {}


    @Override
    public String toString() {
        return "\nAfterschool Java" + "\n   Studenti inscrisi:" + Arrays.toString(students) +  "\n\n   Angajati:" + employees; }

}
