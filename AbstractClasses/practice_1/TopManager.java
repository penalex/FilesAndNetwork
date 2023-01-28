package AbstractClasses.practice_1;

public class TopManager implements Employee {

    private final double FIXED_SALARY = 30000+Math.random() * 70000;


    private final int incomeForCompany;

    public TopManager(Company company, int incomeForCompany) {
        this.incomeForCompany = incomeForCompany;
    }

    public TopManager(int incomeForCompany) {
        this.incomeForCompany = (int) (Math.random() * 25000)+115000;
    }

    @Override
    public int getMonthSalary() {
        if (incomeForCompany >= 10000000) {
        }
        return (int) (FIXED_SALARY+(int) (incomeForCompany * 1.5));
    }
}
