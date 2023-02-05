package AbstractClasses.practice_1;


public class Manager implements Employee {

    private final double SALARY = (Math.random() * (90000-45000))+45000;

    private static double managers_sales;

    public Manager() {
        managers_sales = (Math.random() * (190000-145000))+145000;
    }

    @Override
    public int getMonthSalary() {
        return (int) (SALARY*0.5);
    }

    public double getIncomeOfManager() {
        return managers_sales;
    }

}




