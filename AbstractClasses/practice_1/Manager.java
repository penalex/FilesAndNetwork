package AbstractClasses.practice_1;

public class Manager implements Employee {

    private final double FIXED_SALARY = 30000+Math.random() * 70000;


    private final int incomeForCompany;

    public Manager(Company company, int incomeForCompany) {
        this.incomeForCompany = incomeForCompany;
    }

    public Manager(int incomeForCompany) {
        this.incomeForCompany = (int) (Math.random() * 25000)+115000;
    }

    @Override
    public int getMonthSalary() {

        return (int) (FIXED_SALARY+(int) (incomeForCompany * 0.05));
    }
}




