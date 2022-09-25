public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();

        basket.add("Milk", 40,2,2.3);
        basket.add("Bread",25,3,1.2);
        basket.add("Cheese",125,1);
        basket.add("Butter",12);
        basket.print();
        System.out.println();
        basket.getTotalWeight();
        System.out.println();
        basket.getTotalPrice();
    }
}
