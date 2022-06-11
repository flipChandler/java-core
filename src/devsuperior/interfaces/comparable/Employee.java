package devsuperior.interfaces.comparable;

import org.jetbrains.annotations.NotNull;

public class Employee implements Comparable<Employee> {

    private String name;
    private Double salary;

    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    // > == +
    // < == -
    // igual == 0
    @Override
    public int compareTo(@NotNull Employee employee) {
        return -this.salary.compareTo(employee.getSalary()); // em ordem descrescente de salario
    }
}
