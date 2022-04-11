package service;
import entity.*;
import java.util.Arrays;
import java.util.List;


public class AfterschoolService {          // clasa serviciu care expune operatiile sistemului

    // poate nu e nevoie de aceste date membre, de constructor si de getteri si setteri
    private Student[] students;
    private List<Employee> employees; // list = to access the elements frequently by using the index
    private List<Course> courses;

    public AfterschoolService(Student[] students, List<Employee> employees, List<Course> courses) {
        this.students = students;
        this.employees = employees;
        this.courses = courses;
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
    public void addTeacher (Employee employee){
        employees.add(employee);
    }

    public void addStudent (Student newStudent) {
        Student[] newStudents = new Student[students.length+1];
        int i;
        for (i=0; i<students.length; i++){
            newStudents[i] = students[i];
        }
        newStudents[i] = newStudent;
        setStudent(newStudents);
    }

    public void addCourse (Course course) {
        courses.add(course);
    }

    public void changeTeacher (Teacher oldTeacher, Teacher newTeacher) { // pt profi cu acelasi departament si aceleasi cursuri
        oldTeacher.setName(newTeacher.getName());
        oldTeacher.setSalary(newTeacher.getSalary());
    }

    public void changeInterval (Schedule oldSch, String newInterval) { // doar intervalul orar
        oldSch.setInterval(newInterval);
    }

    public void addToSchedule (List<Schedule> schVechi, Schedule schNou){
        schVechi.add(schNou);
    }

    public void getClassroom (Classroom c, Schedule s) { // afiseaza clasele complex: ce studenti in acea clasa, ce curs au in intervalul dat
    } // ma mai gandesc daca implementez interogarea asta


    public void getOrar(Schedule schedule) {  // afiseaza orar complex: studentii in ce clase si la ce cursuri -> pe intervale orare
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
        if (student.getGrade() > 4)
            student = null; // the garbage collector will remove it
    }

    public void deleteEmployee (Employee employee) {
        System.out.println("\nEmployee " + employee.getDepartament() + " " + employee.getName() + " deleted from afterschool.");
        employees.remove(employee);
    }

    public void deleteCourse (Course course) {
        System.out.println("\nCourse " + course.getName() + ", " + course.getNivel() + " deleted.");
        courses.remove(course);
    }

    public void payMonthlyFee(Student s, double fee){
        s.setFeesPaid(s.getFeesPaid() + fee);
    }

    @Override
    public String toString() {
        return "\nAfterschool Java" + "\n   Studenti inscrisi:" + Arrays.toString(students) +  "\n\n   Angajati:" + employees; }

}
