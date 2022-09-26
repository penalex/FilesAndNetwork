public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();

        basket.add("Milk", 40,2,2.3);
        basket.add("Bread",25,3,1.2);
        basket.add("Banana",107,2);
        basket.add("Avocado",87);
        basket.print();
        System.out.println();
        basket.getTotalWeight();
        System.out.println();
        basket.getTotalPrice();
        basket.clear();

        System.out.println();
        basket.print();
        basket.add("",0);
        basket.getTotalWeight();
        basket.getTotalPrice();
    }
}
