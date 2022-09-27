public class Main {
    public static void main(String[] args) {

        Arithmetics calculation = new Arithmetics();
        calculation.initiation(2, 52);
        calculation.sum();
        calculation.multiplication();
        calculation.max();
        calculation.min();

        System.out.println("Сумма чисел равна: " + calculation.sum());
        System.out.println("Произведение чисел равено : " + calculation.multiplication());
        System.out.println("Максимальное из заданных чисел :" + calculation.max());
        System.out.println("Минимальное из заданных чисел :" + calculation.min());

    }
}


