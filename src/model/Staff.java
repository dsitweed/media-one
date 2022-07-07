package model;

import java.util.Scanner;

public class Staff extends Person {
    private String id;
    private double salary;

    public Staff(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("| %20s | %20d | %20.2f |", getName(), getAge(), salary);
    }
}
