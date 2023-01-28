package AbstractClasses.practice_1;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        Company samsung = new Company("Samsung");
        hireEmployees(samsung);
        samsung.hireAll(employees);
        System.out.println();
        printHighestSalaries(samsung);
        printLowestSalaries(samsung);
        System.out.println();
        fireHalfEmployees(samsung);
        System.out.println();
        printHighestSalaries(samsung);
        printLowestSalaries(samsung);
    }

    private static void hireEmployees(Company company) {

        for (int i = 0; i < 180; i++) {
            Employee operator = new Operator(15000);
            company.hire(operator);
        }

        for (int i = 0; i < 80; i++) {
            Employee manager = new Manager(100000);
            company.hire(manager);
        }
        for (int i = 0; i < 10; i++) {
            Employee topManager = new TopManager(5000000);
            company.hire(topManager);
        }

        System.out.println("Добавлено сотрудников: "+company.countEmployees()
                +" человек, нанимающая компания: "+company.companyName);
    }


    private static void printLowestSalaries(Company company) {
        System.out.println("Самые низкие зарплаты компании: "+company.companyName);
        for (Employee employee : company.getLowestSalaryStaff(30)) {
            System.out.println(employee.getMonthSalary());
        }
    }

    private static void printHighestSalaries(Company company) {
        System.out.println("Самые высокие зарплаты компании: "+company.companyName);
        for (Employee employee : company.getTopSalaryStaff(10)) {
            System.out.println(employee.getMonthSalary());
        }
    }

    private static void fireHalfEmployees(Company company) {
        int countEmployees = company.countEmployees();
        for (int i = 0; i < countEmployees / 2; i++) {
            int index = (int) (Math.random() * company.countEmployees());
            Employee fired = company.getEmployees().get(index);
            company.fire(fired);
        }
        System.out.println("Уволено "+countEmployees / 2+" сотрудников!");
    }

}








