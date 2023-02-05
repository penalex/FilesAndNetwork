package AbstractClasses.practice_1;

public class TopManager implements Employee {

    private final Company company;

    private final double SALARY = (Math.random() * (150000-75000))+75000;

    private final int topManagers_sales;

    public TopManager(Company company){
        this.company = company;
        topManagers_sales= (int) ((Math.random() * (290000-245000))+245000);
    }

    @Override
    public int getMonthSalary() {
        return company.getIncome()>10000000 ? (int) (SALARY * 1.5) : (int) SALARY;
    }

    public double getIncomeOfTopManager() {
        return topManagers_sales;
    }
}
