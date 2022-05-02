import comparator.GradeComparator;
import entity.*;
import service.AfterschoolService;
import service.AuditService;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        AfterschoolService afterschool = new AfterschoolService();
        AuditService audit = AuditService.getInstance();

        Scanner input = new Scanner(System.in);
        listCommands();
        boolean end = false;

        StudentSingleton.getInstance().readFromCSV();
        afterschool.setStudent(StudentSingleton.getInstance().getStudents());
        TeacherSingleton.getInstance().readFromCSV();
        afterschool.setTeacher(TeacherSingleton.getInstance().getTeachers());
        CourseSingleton.getInstance().readFromCSV();
        afterschool.setCourses(CourseSingleton.getInstance().getCourses());
        ScheduleSingleton.getInstance().readFromCSV();
        afterschool.setSchedules(ScheduleSingleton.getInstance().getSchedule());

        while(!end){
            System.out.println("Insert command (or 0 to list them again):");
            int command = Integer.parseInt(input.nextLine());

            try{
                switch (command) {
                    case 1: {
                        afterschool.addStudent(input);
                        audit.log("Add Student"); break;}

                    case 2: {
                        afterschool.addTeacher(input);
                        audit.log("Add Teacher"); break;}

                    case 3: {
                        afterschool.addCourse(input);
                        audit.log("Add Course"); break;}

                    case 4: {
                        int i=0;
                        for (Teacher teacher : afterschool.getTeachers()) {
                            System.out.println(i + " " + teacher); i++;
                        }
                        System.out.println("Choose teacher to change:");
                        int t = Integer.parseInt(input.nextLine());
                        afterschool.changeTeacher(afterschool.getTeachers().get(t), input);
                        audit.log("Change Teacher"); break;}

                    case 5: {
                        int i=0;
                        for (Schedule schedule : afterschool.getSchedules()) {
                            System.out.println(i + ". " + schedule); i++;
                        }
                        System.out.println("Choose schedule to change interval for:");
                        int s = Integer.parseInt(input.nextLine());
                        afterschool.changeInterval(afterschool.getSchedules().get(s), input);
                        audit.log("Change Interval"); break;}

                    case 6: {
                        afterschool.addToSchedule(input);
                        audit.log("Add to schedule"); break;}

                    case 7: {
                        int i=0;
                        for (Schedule schedule : afterschool.getSchedules()) {
                            System.out.println(i + ". " + schedule); i++;
                        }
                        System.out.println("Choose schedule to print:");
                        int s = Integer.parseInt(input.nextLine());
                        afterschool.getOrar(afterschool.getSchedules().get(s));
                        audit.log("Print schedule"); break;}

                    case 8: {
                        afterschool.upgradeYear();
                        audit.log("Upgrade Year"); break;}

                    case 9: {
                        if (afterschool.getStudent().size() == 0)
                            System.out.println("No students to delete!");
                        else {
                            int i = 0;
                            for (Student student : afterschool.getStudent()) {
                                System.out.println(i + ". " + student);
                                i++;
                            }
                            System.out.println("Choose student to delete:");
                            int s = Integer.parseInt(input.nextLine());
                            afterschool.deleteStudent(afterschool.getStudent().get(s));
                        }
                        audit.log("Delete Student"); break;}

                    case 10: {
                        if (afterschool.getEmployees() == null)
                            System.out.println("No employees to delete!");
                        else {
                            int i=0;
                            for (Employee employee : afterschool.getEmployees()) {
                                System.out.println(i + " " + employee); i++;
                            }
                            System.out.println("Choose employee to delete:");
                            int t = Integer.parseInt(input.nextLine());
                            afterschool.deleteEmployee(afterschool.getEmployees().get(t));
                        }
                        audit.log("Delete Employee"); break;}

                    case 11: {
                        if (afterschool.getCourses().size() == 0)
                            System.out.println("No courses to delete!");
                        else {
                            int i = 0;
                            for (Course course : afterschool.getCourses()) {
                                System.out.println(i + ". " + course);
                                i++;
                            }
                            System.out.println("Choose course to delete:");
                            int s = Integer.parseInt(input.nextLine());
                            afterschool.deleteCourse(afterschool.getCourses().get(s));
                        }
                        audit.log("Delete Course"); break;}

                    case 12: {
                        if (afterschool.getStudent().size() == 0)
                            System.out.println("No students to pay fee!");
                        else {
                            int i=0;
                            for (Student student : afterschool.getStudent()) {
                                System.out.println(i + ". " + student);
                                i++;
                            }
                            System.out.println("Choose student to pay fee:");
                            int s = Integer.parseInt(input.nextLine());
                            System.out.println("Fee paid:");
                            afterschool.payMonthlyFee(afterschool.getStudent().get(s), input.nextLine());
                        }
                        audit.log("Pay Monthly Fee"); break;}

                    case 13: {
                        end=true; audit.log("Exit"); break;}
                    }
            } catch (Exception e){
                System.out.println(e.toString());
            }

        }

        StudentSingleton.getInstance().writeToCSV();
        TeacherSingleton.getInstance().writeToCSV();
        CourseSingleton.getInstance().writeToCSV();
        ScheduleSingleton.getInstance().writeToCSV();
    }

    private static void listCommands(){
        System.out.println("----Available commands----");
        System.out.println("1. Add Student");
        System.out.println("2. Add Teacher");
        System.out.println("3. Add Course");
        System.out.println("4. Change Teacher");
        System.out.println("5. Change Interval");
        System.out.println("6. Add to schedule");
        System.out.println("7. Print schedule");
        System.out.println("8. Upgrade Year");
        System.out.println("9. Delete Student");
        System.out.println("10. Delete Employee");
        System.out.println("11. Delete Course");
        System.out.println("12. Pay Monthly Fee");
        System.out.println("13. Exit");
    }


}
