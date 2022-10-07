package ObjectsAndClasses_Methods_2_6_8.src;

public class Basket {

    private static int totalBasketCount;
    private static int totalBasketItems;

    private static int count = 0;
    private String items = "";
    private static int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;


    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
        totalBasketCount = totalBasketCount+1;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
        totalBasketItems = totalBasketItems + count;
    }

    public Basket(String items, int totalPrice, int totalWeight, int count) {
        this();
        this.items = this.items+items;
        this.totalPrice = totalPrice;
        this.totalWeight = totalWeight;
        this.count = count;
        totalBasketItems = totalBasketItems + count;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count+count;
    }

    public void add(String name, int price) {
        add(name, price, 0);
        totalBasketItems = totalBasketItems + count;
    }

    public void add(String name, int price, int count) {
        add(name, price, count, 0);
        totalBasketItems = totalBasketItems + count;
    }

    public void add(String name, int price, int count, double weight) {

        boolean error = contains(name);

        if (totalPrice+count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items+"\n"+name+" - "+
                count+" шт. - "+price+" ,"+"вес товара: "+weight;
        totalPrice = totalPrice+count * price;
        totalWeight = totalWeight+count * weight;
        totalBasketItems = totalBasketItems + count;
    }

    public double getTotalWeight() {
        System.out.println("Общий вес товара составил: "+totalWeight+"кг.");
        return totalWeight;
    }

    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
    }

    public int getTotalPrice() {
        System.out.println("Общая стоимость товара: "+totalPrice);
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print() {
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }

    }

    public static int getTotalBasketCount() {
        return totalBasketCount;
    }

    public static int getTotalBasketItems() {
        return totalBasketItems;
    }

    public static int getAveragePrice() {
        totalBasketItems = totalBasketItems * totalPrice;
        return (int) totalBasketItems / totalBasketCount;
    }


}

