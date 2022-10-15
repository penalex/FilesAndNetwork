public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());
        Container container1 = new Container();
        container1.addCount(5235);
        container = container1;
        System.out.println(container.getCount());
        container.CharFinder();

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.

    }
}
