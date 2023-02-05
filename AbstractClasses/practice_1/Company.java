package AbstractClasses.practice_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Company implements Employee {

    public String companyName;

    public final List<Employee> employees = new ArrayList<>();

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public void hire(Employee employee) {
        this.employees.add(employee);
    }

    public void hireAll(Collection<Employee> employees) {
        for (Employee e: employees){
            hire(e);
        }
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public double getIncome() {
        int income = 0;
        for (Employee e: employees ){
            if (e instanceof Manager){
                income += ((Manager) e).getIncomeOfManager();
            }
            if (e instanceof Operator){
                income += ((Operator) e).getIncomeOfOperator();
            }
            if (e instanceof TopManager){
                income += ((TopManager) e).getIncomeOfTopManager();
            }
          }
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

