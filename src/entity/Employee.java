package entity;
import interefete.Salary;

import java.util.Scanner;

public class Employee implements Salary {

    private String name;
    private String departament; // profesor (poate fi lista [prof romana, prof engleza...]), [ingrijitor, bucatar], soferi
    protected int salary;

    public Employee() {}

    public Employee(String name, String departament, int salary) {
        this.name = name;
        this.departament = departament;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }
    public String getDepartament() {
        return departament;
    }
    public int getSalary() {
        return salary;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDepartament(String departament) {
        this.departament = departament;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }


    @Override
    public void crestereSalariala(int x) {
        salary += x*salary/100;
    }


    @Override
    public String toString() {
        return "\nEmployee: " + name + ", departament: " + departament + ", salary: " + salary ;
    }

    public void read(Scanner in){
        System.out.println("Nume:");
        this.name = in.nextLine();
        System.out.println("Departament:");
        this.departament = in.nextLine();
        System.out.println("Salariu:");
        this.salary = Integer.parseInt(in.nextLine());
    }
}
