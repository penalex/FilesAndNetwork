import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

      /*  Elevator elevator = new Elevator(-3,26);
            while (true) {
            System.out.println("Введите номер этажа:...");
            int floor = new Scanner(System.in).nextInt();
            elevator.move(floor);
        }
      */

        Dimensions dimensions = new Dimensions(0.1,3,1.8);
        Cargo cargo = new Cargo( "1215544QV21","51 Union st., South avenue",12);
        cargo.isFlipAllowed(true);
        cargo.isFragile(false);
        cargo.Printer();
        dimensions.PrintDimension();
    }
}


