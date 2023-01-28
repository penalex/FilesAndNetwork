package AbstractClasses.practice_1;

public class Operator implements Employee {
    private final double FIXED_SALARY = 30000+Math.random() * 70000;

    private final int incomeForCompany;

    public Operator(Company company, int incomeForCompany) {
        this.incomeForCompany = incomeForCompany;
    }

    public Operator(int incomeForCompany) {
        this.incomeForCompany = incomeForCompany;
    }

    @Override
    public int getMonthSalary() {
        return (int) (FIXED_SALARY);
    }
}
