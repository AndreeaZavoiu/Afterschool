
import comparator.GradeComparator;
import entity.*;
import service.AfterschoolService;

import java.util.*;

public class Main {

    public static void main(String[] args) {

// TreeSet(Comparator<? super E> comparator)
// It is used to construct an empty tree set that will be sorted according to given comparator.
//        GradeComparator gradeComparator = new GradeComparator();
//        Set<Student> students = new TreeSet<>(gradeComparator);
//        students.add(s1);
//        students.add(s2);
//        students.add(s3);
//        students.add(s4);

        Student s1 = new Student("615010929", "Stan Maria", 1, "01.09.2021");
        Student s4 = new Student("613010928", "Ionescu Mara", 3, "11.04.2021");
        Student s2 = new Student("514022100", "Stefan Mihai", 2, "20.03.2022");
        Student s3 = new Student("614120111", "Popa Andreea", 1, "20.09.2021");

        Student[] students = new Student[4];
        students[0] = s1;
        students[1] = s2;
        students[2] = s3;
        students[3] = s4;


        Course curs1 = new Course("engleza", "avansat");
        Course curs2 = new Course("germana", "incepator");
        Course curs3 = new Course("dansuri populare", "incepator");
        List<Course> l1 = new ArrayList<>();
        List<Course> l2 = new ArrayList<>();
        List<Course> cursuri = new ArrayList<>();
        l1.add(curs1);
        l1.add(curs2);
        l2.add(curs3);
        cursuri.add(curs1); cursuri.add(curs2); cursuri.add(curs3);

        Teacher t1 = new Teacher("Alina","profesor", 3400, l1);
        Teacher t2 = new Teacher("Radu Boriga","profesor", 3400, l2);
        Employee t3 = new Employee("Nutica","bucatar", 2000);
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(t1);
        employees.add(t2);
        employees.add(t3);


        Schedule schedule1 = new Schedule("10-11", "Luni");
        Schedule schedule2 = new Schedule("11-12", "Luni");
        Schedule schedule3 = new Schedule("12-13", "Luni");
        Schedule schedule4 = new Schedule("14-15", "Luni");
        Schedule schedule5 = new Schedule("12-13", "Marti");
        Schedule schedule6 = new Schedule("13-14", "Marti");
        Schedule schedule7 = new Schedule("15-16", "Marti");
        Schedule scheduleSerbarePrimavara = new Schedule("11-13", "Sambata");
        Schedule scheduleExcursie1 = new Schedule("9-19", "Duminica");

        List<Schedule> orar1 = new ArrayList<>();
        orar1.add(schedule1);
        orar1.add(schedule4);

        List<Schedule> orar2 = new ArrayList<>();
        orar2.add(schedule2);

        s1.setOrar(orar1);
        s2.setOrar(orar2);

        t1.setOrar(orar1);
        t2.setOrar(orar2);

        curs1.setSchedule(orar1);
        curs2.setSchedule(orar2);

        AfterschoolService afterschool = new AfterschoolService(students, employees, cursuri);
        System.out.println(afterschool);

        Serbare serbarePrimavara = new Serbare(students,"Casa de cultura", scheduleSerbarePrimavara, "primavara");
        System.out.println(serbarePrimavara);


        Student[] studentsCopy = students.clone();
        GradeComparator gradeComparator = new GradeComparator();
        Arrays.sort(studentsCopy, gradeComparator);
        System.out.println("\n\n   Elevii sortati in ordinea crescatoare a clasei:" + Arrays.toString(studentsCopy));

        Excursie excursie1 = new Excursie(students, "Delta Dunarii", scheduleExcursie1, employees);
        System.out.println(excursie1);


        // IMPLEMENTARE INTEROGARI
        Student studentNou = new Student("516092471", "Gheorghe David", 3, "15.04.2022");
        afterschool.addStudent(studentNou);

        Course cursNou =  new Course("engleza", "incepator");
        afterschool.addCourse(cursNou);

        List<Course> listaNouaCursuri = new ArrayList<>();
        listaNouaCursuri.add(curs1);
        listaNouaCursuri.add(cursNou);
        Teacher profNou = new Teacher("Gherasim Luminita", "profesor", 3000, listaNouaCursuri);
        afterschool.addTeacher(profNou);

        afterschool.changeTeacher(t1, profNou);

        afterschool.changeInterval(schedule7, "14-15");
        afterschool.addToSchedule(orar2, schedule6);

        s3.setOrar(orar2);
        List<Schedule> orar3 = new ArrayList<>();
        orar3.add(schedule3); orar3.add(schedule4); orar3.add(schedule5); orar3.add(schedule6);
        s4.setOrar(orar3);
        List<Schedule> orar4 = new ArrayList<>();
        orar4.add(schedule7);
        studentNou.setOrar(orar4);
        afterschool.getOrar(schedule1);

        afterschool.payMonthlyFee(studentNou, 1000);
        afterschool.upgradeYear();

        afterschool.deleteStudent(studentNou);
        afterschool.deleteCourse(cursNou);
        afterschool.deleteEmployee(t3);
    }
}
