public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;

    private double totalWeight = 0;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice, int totalWeight) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
        this.totalWeight = totalWeight;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price) {
        add(name, price, price, 1);
    }

    public void add(String name, int price, int count) {
        add(name, price, count, 1);
    }

    public void add(String name, int price, int count, double weight) {

        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price + " ," + "вес товара: " + weight;
        totalPrice = totalPrice + count * price;
        this.totalWeight = totalWeight;
        totalWeight = totalWeight + weight;
    }

    public double getTotalWeight() {
        System.out.println("Общий вес товара составил: " + totalWeight + "кг.");
        return totalWeight;

    }

    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
    }

    public int getTotalPrice() {
        System.out.println("Общая стоимость товара: " + totalPrice);
        return totalPrice;

    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print () {
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
