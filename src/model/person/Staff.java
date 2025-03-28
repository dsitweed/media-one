package model.person;

import java.util.Objects;

public class Staff extends Person {
    private String id;
    private double salary;
    private String username;
    private String password;

    public Staff(String name, int age, double salary, String username, String password) {
        super(name, age);
        this.salary = salary;
        this.username = username;
        this.password = password;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return String.format("| %20s | %20d | %20.2f |", getName(), getAge(), salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return Double.compare(staff.salary, salary) == 0 && Objects.equals(username, staff.username) && Objects.equals(password, staff.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash( salary, username, password);
    }
}
