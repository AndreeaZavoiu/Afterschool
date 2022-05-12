package entity;
import java.util.Comparator;

public class GradeComparator implements Comparator<Student> {
    public GradeComparator() {
    }

    public int compare(Student o1, Student o2) {
        return o1.getGrade() - o2.getGrade();
    }

    public Comparator<Student> reversed() {
        return Comparator.super.reversed();
    }
}