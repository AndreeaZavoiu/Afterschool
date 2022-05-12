package entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeacherSingleton {
    public static TeacherSingleton instance = null;

    public static TeacherSingleton getInstance() {
        if (instance == null){
            instance = new TeacherSingleton();
        }
        return instance;
    }

    private List<Teacher> teachers = new ArrayList<Teacher>();

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
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
            System.out.println("No saved teachers!");
        }
        return columns;
    }


    public void readFromCSV() {
        var columns = TeacherSingleton.getCSVColumns("data/teachers.csv");
        for(var fields : columns){
            var newTeacher = new Teacher(
                    fields[0], // name
                    fields[1], // department
                    Integer.parseInt(fields[2]) // salary
            );
            teachers.add(newTeacher);
        }
    }

    public void writeToCSV(){
        try{
            var writer = new FileWriter("data/teachers.csv");
            for(var teacher : this.teachers){
                writer.write(teacher.toCSV());
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
