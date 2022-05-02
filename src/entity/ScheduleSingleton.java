package entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleSingleton {
    public static ScheduleSingleton instance = null;

    private List<Schedule> schedules = new ArrayList<Schedule>();

    public List<Schedule> getSchedule() {
        return schedules;
    }
    public void setSchedule(List<Schedule> schedules) { this.schedules = schedules;}

    public static ScheduleSingleton getInstance(){
        if (instance == null){
            instance = new ScheduleSingleton();
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
            System.out.println("No saved schedules!");
        }
        return columns;
    }


    public void readFromCSV() {
        var columns = ScheduleSingleton.getCSVColumns("data/schedules.csv");
        for(var fields : columns){
            var newSchedule = new Schedule(
                    fields[0], // nume
                    fields[1] // nivel
            );
            schedules.add(newSchedule);
        }
    }

    public void writeToCSV(){
        try{
            var writer = new FileWriter("data/schedules.csv");
            for(var schedule : this.schedules){
                writer.write(schedule.toCSV());
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
