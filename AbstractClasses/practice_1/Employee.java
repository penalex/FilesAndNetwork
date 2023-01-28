package AbstractClasses.practice_1;

public interface Employee {
     default int getMonthSalary() {
        return 0;
    }

     default double getIncome() {
        return 0;
    }
}
