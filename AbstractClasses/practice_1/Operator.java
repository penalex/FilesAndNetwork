package AbstractClasses.practice_1;


public class Operator implements Employee {

    private final double SALARY = (Math.random() * (45000-20000))+20000;

    private final int operators_sales;

    public Operator(){
        operators_sales = (int) ((Math.random() * (90000-45000))+45000);
    }

    @Override
    public int getMonthSalary() {
        return (int) (SALARY);
    }

    public double getIncomeOfOperator() {
        return operators_sales;
    }

}
