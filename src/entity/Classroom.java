package entity;

import java.util.List;

public class Classroom {
    private int id;
    private String utilization;
    private float capacity;
    private List<Student> students;
    private Schedule schedule;

    public Classroom(int id, String utilization, float capacity) {
        this.id = id;
        this.utilization = utilization;
        this.capacity = capacity;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUtilization() {
        return this.utilization;
    }

    public void setUtilization(String utilization) {
        this.utilization = utilization;
    }

    public float getCapacity() {
        return this.capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public String toString() {
        return "Classroom: id=" + this.id + ", utilization=" + this.utilization + ", capacity=" + this.capacity;
    }
}
