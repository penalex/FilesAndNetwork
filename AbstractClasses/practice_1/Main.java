package AbstractClasses.practice_1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> workers = new ArrayList<>();

        Company samsung = new Company("Samsung");

        hireEmployees(samsung);
        samsung.hireAll(workers);
        System.out.println("__________________________________________");
        printHighestSalaries(samsung);
        System.out.println("__________________________________________");
        printLowestSalaries(samsung);
        System.out.println("__________________________________________");
        System.out.println("Доход компании составил: "+(long)samsung.getIncome());
        System.out.println("__________________________________________");
        fireHalfEmployees(samsung);
        System.out.println("__________________________________________");
        printHighestSalaries(samsung);
        System.out.println("__________________________________________");
        printLowestSalaries(samsung);
        System.out.println("__________________________________________");
        System.out.println("Доход компании составил: "+(long)samsung.getIncome());
        System.out.println();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();

        Company aser = new Company("aser");
        
        hireEmployees(aser);
        samsung.hireAll(workers);
        System.out.println("__________________________________________");
        printHighestSalaries(aser);
        System.out.println("__________________________________________");
        printLowestSalaries(aser);
        System.out.println("__________________________________________");
        System.out.println("Доход компании составил: "+(long)aser.getIncome());
        System.out.println("__________________________________________");
        fireHalfEmployees(aser);
        System.out.println("__________________________________________");
        printHighestSalaries(aser);
        System.out.println("__________________________________________");
        printLowestSalaries(aser);
        System.out.println("__________________________________________");
        System.out.println("Доход компании составил: "+(long)aser.getIncome());


    }

    private static void hireEmployees(Company company) {

        for (int i = 0; i < 180; i++) {
            Operator operator = new Operator();
            company.hire(operator);
        }

        for (int i = 0; i < 80; i++) {
            Manager manager = new Manager();
            company.hire(manager);
        }
        for (int i = 0; i < 10; i++) {
            TopManager topManager = new TopManager(company);
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








