package com.company;
import com.company.entity.*;
import com.company.service.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ReadCSVService in = ReadCSVService.getInstance();
        AfterschoolService afterschool = new AfterschoolService();

        List<Student> students = in.readCSV("data/student.csv", "Student");
        Student elev1 = students.get(0);
        List<Teacher> teachers = in.readCSV("data/teacher.csv", "Teacher");
        Teacher prof1 = teachers.get(0);

        Student student1 = new Student("5121212121212", "Mircea Matei", 3, "21.09.2011");
        Teacher teacher1 = new Teacher("Lorena Mihai", "profesor", 2900);
        Teacher teacher2 = new Teacher("Silviu Anastase", "profesor", 3100);
        Course curs1 = new Course("franceza", "incepator");
        Schedule schedule1 = new Schedule("15-16", "Joi");

        afterschool.addStudent(student1);
        afterschool.addTeacher(teacher1);
        afterschool.addCourse(curs1);
        afterschool.addToSchedule(schedule1);
        afterschool.changeTeacher(prof1, teacher2);
        afterschool.changeInterval(schedule1, "15-17");
        afterschool.upgradeYear();
        afterschool.deleteCourse(curs1);
        afterschool.deleteEmployee(teacher1);
        afterschool.deleteStudent(elev1);
        afterschool.payMonthlyFee(student1, "1200");

        WriteToCSVService write = WriteToCSVService.getInstance();
        write.writeToCSV(student1, "data/student.csv");
    }
}
