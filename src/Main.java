
import comparator.GradeComparator;
import entity.*;
import service.Afterschool;

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


        Courses c1 = new Courses("engleza", "avansat");
        Courses c2 = new Courses("germana", "incepator");
        Courses c3 = new Courses("dansuri populare", "incepator");
        List<Courses> l1 = new ArrayList<>();
        List<Courses> l2 = new ArrayList<>();
        l1.add(c1);
        l1.add(c2);
        l2.add(c3);

        Teacher t1 = new Teacher("Alina","profesor", 3400, l1);
        Teacher t2 = new Teacher("Radu Boriga","profesor", 3400, l2);
        Employee t3 = new Employee("Nutica","bucatar", 2000);
        ArrayList<Employee> employees = new ArrayList<Employee>();
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

        List<Schedule> orar1 = new ArrayList<>();
        orar1.add(schedule1);
        orar1.add(schedule4);

        List<Schedule> orar2 = new ArrayList<>();
        orar2.add(schedule2);

        t1.setOrar(orar1);
        t2.setOrar(orar2);

        c1.setSchedule(orar1);
        c2.setSchedule(orar2);

        Afterschool afterschool = new Afterschool(students, employees);
        System.out.println(afterschool);

        Serbare serbarePrimavara = new Serbare(students,"Casa de cultura", scheduleSerbarePrimavara, "primavara");
        System.out.println(serbarePrimavara);


        Student[] studentsCopy = students.clone();
        GradeComparator gradeComparator = new GradeComparator();
        Arrays.sort(studentsCopy, gradeComparator);
        System.out.println("\n\n   Studentii sortati in ordinea crescatoare a clasei:" + Arrays.toString(studentsCopy));
    }
}
