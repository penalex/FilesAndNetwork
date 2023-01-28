package AbstractClasses.practice_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Company implements Employee {

    public static double income;
    public String companyName;

    public final List<Employee> employees = new ArrayList<>();

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public void hire(Employee employee) {
        this.employees.add(employee);
    }

    public void hireAll(Collection<Employee> employees) {
        this.employees.addAll(employees);
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public double getIncome() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getIncome))
                .limit((long) income).collect(Collectors.toList());
        return income;
    }


    public List<Employee> getLowestSalaryStaff(int count) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getMonthSalary))
                .limit(count).collect(Collectors.toList());
    }

    public List<Employee> getTopSalaryStaff(int count) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getMonthSalary).reversed())
                .limit(count)
                .collect(Collectors.toList());
    }

    public int countEmployees() {
        return employees.size();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public int getMonthSalary() {
        return 0;
    }
}

