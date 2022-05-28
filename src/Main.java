package com.company;
import com.company.config.DatabaseConfiguration;
import com.company.entity.*;
import com.company.repository.CourseRepository;
import com.company.repository.ScheduleRepository;
import com.company.repository.StudentRepository;
import com.company.repository.TeacherRepository;
import com.company.service.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepository();
        studentRepository.createTable();
        studentRepository.addStudent("6110921298888", "Maria", 3);
        studentRepository.displayStudents();
        studentRepository.updateStudentGrade("6110921298888", 4);
        studentRepository.displayStudents();
        studentRepository.deleteStudent("6110921298888");
        studentRepository.displayStudents();


        TeacherRepository teacherRepository = new TeacherRepository();
        teacherRepository.createTable();
        teacherRepository.addTeacher("Pana Tatiana", "profesor", 3900);
        teacherRepository.addTeacher("Gherasim Luminita", "profesor", 4200);
        teacherRepository.displayTeachers();
        teacherRepository.updateTeacherSalary("Gherasim Luminita", 5700);
        teacherRepository.displayTeachers();
        teacherRepository.deleteTeacher("Pana Tatiana");
        teacherRepository.displayTeachers();


        CourseRepository courseRepository = new CourseRepository();
        courseRepository.createTable();
        courseRepository.addCourse("Dansuri", "incepator");
        courseRepository.addCourse("Tenis", "incepator");
        courseRepository.displayCourses();
        courseRepository.updateCourseLevel(1, "avansat");
        courseRepository.displayCourses();
        courseRepository.deleteCourse("Tenis", "incepator");
        courseRepository.displayCourses();


        ScheduleRepository scheduleRepository = new ScheduleRepository();
        scheduleRepository.createTable();
        scheduleRepository.addSchedule("15-16", "joi");
        scheduleRepository.addSchedule("11-12", "miercuri");
        scheduleRepository.displaySchedules();
        scheduleRepository.updateScheduleInterval("joi", "15-16", "16-17");
        scheduleRepository.displaySchedules();
        scheduleRepository.deleteSchedule(2);
        scheduleRepository.displaySchedules();


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

        DatabaseConfiguration.closeDatabaseConfiguration();
    }
}
