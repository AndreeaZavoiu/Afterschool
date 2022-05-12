package entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentSingleton {
    public static StudentSingleton instance = null;

    private List<Student> students = new ArrayList<Student>();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public static StudentSingleton getInstance(){
        if (instance == null){
            instance = new StudentSingleton();
        }
        return instance;
    }

    private static List<String[]> getCSVColumns(String fileName){
        List<String[]> columns = new ArrayList<>();

        try(var in = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = in.readLine()) != null ) {
                String[] fields = line.replaceAll(" ", "").split(",");
                columns.add(fields);
            }
        } catch (IOException e) {
            System.out.println("No saved students!");
        }
        return columns;
    }


    public void readFromCSV() {
        var columns = StudentSingleton.getCSVColumns("data/students.csv");
        for(var fields : columns){
            var newStudent = new Student(
                    fields[0], // CNP
                    fields[1], // nume
                    Integer.parseInt(fields[2]), // grade
                    fields[3] // entryDate
            );
            students.add(newStudent);
        }
    }

    public void writeToCSV(){
        try{
            var writer = new FileWriter("data/students.csv");
            for(var student : this.students){
                writer.write(student.toCSV());
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
