package AbstractClasses.practice_1;


public interface Employee extends Comparable <Employee>{

    default int getMonthSalary() {
        return 0;
    }

    default double getIncome() {
        return 0;
    }

    @Override
    default int compareTo(Employee o) {
        return Integer.compare(getMonthSalary(), o.getMonthSalary());
    }

}
