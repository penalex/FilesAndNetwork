package ObjectsAndClasses_Methods_2_6_8.src;

public class Main {
    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Banana",12,1,11);
        basket.add("Blueberry",12,14,1);

        Basket basket1 = new Basket("bjhbj",12,78,4);
        Basket basket2 = new Basket("112,",12,4,12);
        Basket basket3 = new Basket("hjhjk", 95,45,82);



        System.out.println("Общее колличество корзин: " + Basket.getTotalBasketCount());
        System.out.println("Общее колличество товара в корзинах: " + Basket.getTotalBasketItems());
        System.out.println("Средняя стоимость корзины: " + Basket.getAveragePrice());
    }
}
