package entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseSingleton {
    public static CourseSingleton instance = null;

    private List<Course> courses = new ArrayList<Course>();

    public List<Course> getCourses() {
        return courses;
    }
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public static CourseSingleton getInstance(){
        if (instance == null){
            instance = new CourseSingleton();
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
            System.out.println("No saved courses!");
        }
        return columns;
    }


    public void readFromCSV() {
        var columns = CourseSingleton.getCSVColumns("data/courses.csv");
        for(var fields : columns){
            var newCourse = new Course(
                    fields[0], // nume
                    fields[1] // nivel
            );
            courses.add(newCourse);
        }
    }

    public void writeToCSV(){
        try{
            var writer = new FileWriter("data/courses.csv");
            for(var course : this.courses){
                writer.write(course.toCSV());
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
