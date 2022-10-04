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
        Cargo cargo = new Cargo("4577GHHB4548JKI",
                "Kyrgyzstan, Cholpon-Ata,  Sovet st. 105",
                12.5,
                new Dimensions(14, 15, 5));

        cargo.Printer();
    }
}


