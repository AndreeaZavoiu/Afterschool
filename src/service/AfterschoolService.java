package service;
import entity.*;

import java.util.List;
import java.util.Scanner;


public class AfterschoolService {          // clasa serviciu care expune operatiile sistemului

    // poate nu e nevoie de aceste date membre, de constructor si de getteri si setteri
    private List<Student> students;
    private List<Employee> employees; // list = to access the elements frequently by using the index
    private List<Course> courses;
    private List<Teacher> teachers;
    private List<Schedule> schedules;

    public AfterschoolService() {}

    public AfterschoolService(List<Student> students, List<Employee> employees, List<Course> courses) {
        this.students = students;
        this.employees = employees;
        this.courses = courses;
    }

    public List<Student> getStudent() {
        return students;
    }
    public List<Employee> getEmployees(){
        return employees;
    }
    public List<Teacher> getTeachers(){ return teachers; }
    public List<Course> getCourses() { return courses; }
    public List<Schedule> getSchedules() { return schedules; }
    public void setStudent(List<Student> students) {
        this.students = students;
    }
    public void setTeacher(List<Teacher> teachers) {
        this.teachers = teachers;
    }
    public void setCourses(List<Course> courses) { this.courses = courses; }
    public void setSchedules(List<Schedule> schedules) { this.schedules = schedules; }



    // actiuni / interogari pe obiectele create
    public void addTeacher (Scanner in){
        Teacher newTeacher = new Teacher();
        newTeacher.read(in);
        teachers.add(newTeacher);
    }

    public void addStudent (Scanner in) {
        Student newStudent = new Student();
        newStudent.read(in);
        students.add(newStudent);}

    public void addCourse (Scanner in) {
        Course newCourse = new Course();
        newCourse.read(in);
        courses.add(newCourse);
    }

    public void changeTeacher (Teacher oldTeacher, Scanner in) { // pt profi cu acelasi departament si aceleasi cursuri
        Teacher newTeacher = new Teacher();
        newTeacher.read(in);
        oldTeacher.setName(newTeacher.getName());
        oldTeacher.setDepartament(newTeacher.getDepartament());
        oldTeacher.setSalary(newTeacher.getSalary());
    }

    public void changeInterval (Schedule oldSch, Scanner in) { // doar intervalul orar
        System.out.println("New interval:");
        String newInterval = in.nextLine();
        oldSch.setInterval(newInterval);
    }

    public void addToSchedule (Scanner in){
        Schedule newSchedule = new Schedule();
        newSchedule.read(in);
        schedules.add(newSchedule);
    }

    public void getClassroom (Classroom c, Schedule s) { // afiseaza clasele complex: ce studenti in acea clasa, ce curs au in intervalul dat
    } // ma mai gandesc daca implementez interogarea asta


    public void getOrar(Schedule schedule) {  // afiseaza orar complex: ce cursuri are fiecare student, pe intervale orare
        System.out.println("\n-----------------------------");
        for (Student stud : students){
            System.out.println("Elevul " + stud.getName() + " are ore ");
            if (stud != null && stud.getOrar()!=null)
                for (Schedule sch : stud.getOrar()){
                    System.out.println("\t" + sch.getWeekDay() + ", intre " + sch.getInterval());
                }
        }
        System.out.println("-----------------------------");
    }


    // in september or when requested, the grade of the students must be upgraded
    public void upgradeYear(){
        System.out.println("\nYear upgraded.");
        for (Student s : students){
            s.setGrade(s.getGrade() + 1);
        }
    }

    public void deleteStudent (Student student) {  // daca a depasit ciclul primar de studii, este sters din Afterschool
        System.out.println(student.toString() + " deleted from afterschool.");
        // if (student.getGrade() > 4)
        students.remove(student);
    }

    public void deleteEmployee (Employee employee) {
        System.out.println("\nEmployee " + employee.getDepartament() + " " + employee.getName() + " deleted from afterschool.");
        employees.remove(employee);
    }

    public void deleteCourse (Course course) {
        System.out.println("\nCourse " + course.getName() + ", " + course.getNivel() + " deleted.");
        courses.remove(course);
    }

    public void payMonthlyFee(Student s, String in){
        s.setFeesPaid(s.getFeesPaid() + Double.parseDouble(in));
    }

    @Override
    public String toString() {
        return "\nAfterschool Java" + "\n   Studenti inscrisi:" + students +  "\n\n   Angajati:" + employees; }

}
